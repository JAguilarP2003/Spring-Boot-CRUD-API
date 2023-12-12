package com.example.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Docente;

@Repository
public interface DocenteRepository extends CrudRepository<Docente, Long>{
	Docente findByTipoDocumentoAndDocumento(String tipoDocumento, String documento);
}