package com.generation.escola.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.escola.model.Escola;
import com.generation.escola.repository.EscolaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/escola")
@CrossOrigin(origins="*", allowedHeaders="*")
public class EscolaController {
	
	@Autowired
	private EscolaRepository escolaRepository;
	
	@GetMapping
	public ResponseEntity<List<Escola>> getAll(){
		return ResponseEntity.ok(escolaRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Escola> getById(@PathVariable Long id){
		return escolaRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@PostMapping
	public ResponseEntity<Escola> created(@Valid @RequestBody Escola escola){
		return ResponseEntity.status(HttpStatus.CREATED).body(escolaRepository.save(escola));
	}
	
	@PutMapping
	public ResponseEntity<Escola> update(@Valid @RequestBody Escola escola){
		return escolaRepository.findById(escola.getId()).map(resposta-> ResponseEntity.status(HttpStatus.CREATED)
				.body(escolaRepository.save(escola))).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Escola> escola = escolaRepository.findById(id);
		if(escola.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		escolaRepository.deleteById(id);
		
	}
	

}
