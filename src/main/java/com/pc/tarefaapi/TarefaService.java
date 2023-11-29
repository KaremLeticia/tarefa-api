package com.pc.tarefaapi;

import java.util.Collection;

public interface TarefaService {

	Tarefa getTarefa(int id);
	Collection<Tarefa> getTarefas();

	void insert(Tarefa item);
	void update(Tarefa item);
	void delete(int id);
}
