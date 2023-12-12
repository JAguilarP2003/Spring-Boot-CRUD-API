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


import com.example.models.Estudiante;
import com.example.services.EstudianteServices;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {
	@Autowired
	private EstudianteServices estudianteService;
	
	@GetMapping
	public ResponseEntity<ArrayList<Estudiante>> getAll()
	{
		return ResponseEntity.ok(estudianteService.getAll());
	}
	
	@PostMapping
	public ResponseEntity<Estudiante> save(@RequestBody Estudiante estudiante){
		return ResponseEntity.ok(estudianteService.save(estudiante));
	}
	
	@PutMapping
	public ResponseEntity<Estudiante> update(@RequestBody Estudiante estudiante){
		return ResponseEntity.ok(estudianteService.update(estudiante));
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        estudianteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
	
}
