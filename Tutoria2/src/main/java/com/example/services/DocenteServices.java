package com.example.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.models.Docente;
import com.example.repositories.DocenteRepository;


@Service
public class DocenteServices {
	
	@Autowired
	private DocenteRepository docenteRepository;
	
	public ArrayList<Docente> getAll(){
		
		return (ArrayList<Docente>) docenteRepository.findAll();
	}
	
	
	// Funciones antiguas.
	
	/*public Docente save(Docente Docente) {
		return docenteRepository.save(Docente);	
	}*/
	
	/*public Docente update(Docente docente) {
		if (docenteRepository.existsById(docente.getId())) {
			return docenteRepository.save(docente);
			
		} else {
			return null;
		}
	}*/
	
	/*public void deleteById(Long id) {
        docenteRepository.deleteById(id);
    }*/
	
	
	//Reglas de negocio.
	
	public Docente save(Docente docente) {
		if (docenteRepository.findByTipoDocumentoAndDocumento(docente.getTipoDocumento(), docente.getDocumento()) == null) {
			return docenteRepository.save(docente);
		} else {
			throw new RuntimeException("Ya existe un docente con esta información.");
		}
	}
	
	
	public Docente update(Docente docente) {
	    if (docenteRepository.existsById(docente.getId())) {
	        return docenteRepository.save(docente);
	    } else {
	        throw new RuntimeException("El docente con el ID especificado no existe.");
	    }
	}

	public void deleteById(Long id) {
	    if (docenteRepository.existsById(id)) {
	        docenteRepository.deleteById(id);
	    } else {
	        throw new RuntimeException("No se puede eliminar. El docente con el ID especificado no existe.");
	    }
	}
}
