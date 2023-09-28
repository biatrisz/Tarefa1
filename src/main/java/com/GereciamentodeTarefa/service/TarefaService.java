package com.GereciamentodeTarefa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GereciamentodeTarefa.entitie.Tarefa;
import com.GereciamentodeTarefa.repository.TarefaRepository;
@Service

public class TarefaService {
	    private final TarefaRepository tarefaRepository;
	    
	    @Autowired
	    public TarefaService(TarefaRepository tarefaRepository) {
	        this.tarefaRepository = tarefaRepository;
	    }

	    public List<Tarefa> getAllTarefa (){
	        return tarefaRepository.findAll();
	    }

	    public Tarefa getTarefaById(Long id) {
	        Optional<Tarefa> Tarefa = tarefaRepository.findById(id);
	        return Tarefa.orElse(null);
	    }

	    public Tarefa salvarTarefa(Tarefa tarefa) {
	        return tarefaRepository.save(tarefa);
	    }

	    public Tarefa updateTarefa(Long id, Tarefa updatedTarefa) {
	        Optional<Tarefa> existingTarefa = tarefaRepository.findById(id);
	        if (existingTarefa.isPresent()) {
	            updatedTarefa.setId(id);
	            return tarefaRepository.save(updatedTarefa);
	        }
	        return null;
	    }

	    public boolean deleteTareda(Long id) {
	        Optional<Tarefa> existingTarefa = tarefaRepository.findById(id);
	        if (existingTarefa.isPresent()) {
	            tarefaRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
	
	

}
