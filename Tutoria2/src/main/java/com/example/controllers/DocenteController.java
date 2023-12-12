package com.example.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.models.Docente;
import com.example.services.DocenteServices;

@RestController
@RequestMapping("/docente")
public class DocenteController {
	@Autowired
	private DocenteServices docenteService;
	
	@GetMapping
	public ResponseEntity<ArrayList<Docente>> getAll()
	{
		return ResponseEntity.ok(docenteService.getAll());
	}
	
	@PostMapping
	public ResponseEntity<Docente> save(@RequestBody Docente estudiante){
		return ResponseEntity.ok(docenteService.save(estudiante));
	}
	
	@PutMapping
	public ResponseEntity<Docente> update(@RequestBody Docente estudiante){
		return ResponseEntity.ok(docenteService.update(estudiante));
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        docenteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
	
}
