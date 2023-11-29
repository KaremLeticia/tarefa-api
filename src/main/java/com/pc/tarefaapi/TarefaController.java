package com.pc.tarefaapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

@Controller
@RequestMapping(value="/catalogo")
@CrossOrigin
public class TarefaController {

	@Autowired
	private TarefaService service;

	// Get all tarefas
	@GetMapping(value="/tarefas", produces={"application/json","application/xml"})
	public ResponseEntity<Collection<Tarefa>> getItems() {
		Collection<Tarefa> result = service.getTarefas();
		return ResponseEntity.ok().body(result);
	}

	// Get tarefa
	@GetMapping(value="/tarefa/{id}", produces={"application/json","application/xml"})
	public ResponseEntity<Tarefa> getItem(@PathVariable int id) {
		Tarefa result = service.getTarefa(id);
		if (service.getTarefa(id) == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok().body(result);
	}

	// Insert tarefa
	@PostMapping(value="/tarefa",
			consumes={"application/json","application/xml"},
			produces={"application/json","application/xml"})
	public ResponseEntity<Tarefa> addItem(@RequestBody Tarefa item) {
		service.insert(item);
		URI uri = URI.create("/tarefa/" + item.getId());
		return ResponseEntity.created(uri).body(item);
	}

	// Update tarefa
	@PutMapping(value="/tarefa/{id}", consumes={"application/json","application/xml"})
	public ResponseEntity modifyItem(@PathVariable int id, @RequestBody Tarefa item) {
		if (service.getTarefa(id) == null)
			return ResponseEntity.notFound().build();
		else {
            item.setId(id);
			service.update(item);
			return ResponseEntity.ok().build();
		}
	}

	// Delete tarefa
	@DeleteMapping("/tarefa/{id}")
	public ResponseEntity deleteItem(@PathVariable int id) {
		if (service.getTarefa(id) == null)
			return ResponseEntity.notFound().build();
		else {
			service.delete(id);
			return ResponseEntity.ok().build();
		}
	}
}
