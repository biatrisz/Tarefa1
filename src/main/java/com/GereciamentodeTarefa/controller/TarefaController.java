package com.GereciamentodeTarefa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GereciamentodeTarefa.entitie.Tarefa;
import com.GereciamentodeTarefa.service.TarefaService;

@RestController
@RequestMapping("/TarefaRepository")

public class TarefaController {
	private final TarefaService tarefaService;

	@Autowired
	public TarefaController (TarefaService tarefaService) { 
		this.tarefaService = tarefaService; 
	} 
	
	@GetMapping("/{id}") 
	public ResponseEntity<Tarefa> buscaTarefaControllId(@PathVariable Long id){ 
		Tarefa alteraTarefa = tarefaService.getTarefaById(id); 
		if(alteraTarefa != null) { 
			return ResponseEntity.ok(alteraTarefa); 
		} 
		else { 
			return ResponseEntity.notFound().build(); 
		} 
	} 
	@GetMapping("/") 
	public ResponseEntity<List<Tarefa>> buscaTodosTarefaControl(){ 
		List<Tarefa> tarefa = tarefaService.getAllTarefa();
		return ResponseEntity.ok(tarefa);
	} 
	@PostMapping("/") 
	public ResponseEntity<Tarefa> salvaTarefaControl(@RequestBody Tarefa tarefa){ 
		Tarefa salvaTarefa = tarefaService.salvarTarefa(tarefa); 
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaTarefa); 
	} 
	@PutMapping("/{id}") 
	public ResponseEntity<Tarefa> alteraTarefaControl(@PathVariable Long id, @RequestBody Tarefa tarefa){ 
		Tarefa alteraTarefa = tarefaService.updateTarefa(id, tarefa); 
		
		if(alteraTarefa != null) { 
			return ResponseEntity.ok(alteraTarefa); 
		} 
		else { 
			return ResponseEntity.notFound().build();	 
		} 
	} 

	@DeleteMapping("/{id}") 
	public ResponseEntity<String> apagaTarefaControl(@PathVariable Long id){ 
		boolean apagar = tarefaService.deleteTareda(id); 

		if (apagar) { 
			return ResponseEntity.ok().body("O Produto foi excluído com sucesso"); 
		} 
		else { 
			return ResponseEntity.notFound().build(); 

		} 
	} 
}
