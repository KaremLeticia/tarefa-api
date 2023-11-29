package com.pc.tarefaapi;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class TarefaServiceImpl implements TarefaService {

	private static Map<Integer, Tarefa> tarefas = new HashMap<Integer, Tarefa>();
	private int nextId = 1;
	
	@Override
	public Tarefa getTarefa(int id) {
		return tarefas.get(id);
	}

	@Override
	public Collection<Tarefa> getTarefas() {
		return tarefas.values();
	}

	@Override
	public void insert(Tarefa item) {
		item.setId(nextId++);
		tarefas.put(item.getId(), item);
	}

	@Override
	public void update(Tarefa item) {
		int id = item.getId();
		if (tarefas.containsKey(id)) {
			tarefas.put(id, item);
		}
	}

	@Override
	public void delete(int id) {
		Tarefa item = tarefas.get(id);
		if (item != null) {
			tarefas.remove(id);
		}
	}
}
