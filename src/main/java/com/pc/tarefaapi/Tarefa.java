package com.pc.tarefaapi;

public class Tarefa {

	private int id;
	private String descricao;
	private Boolean feita;
	
	public Tarefa() {
	}
	
	public Tarefa(String descricao, Boolean feita) {
		this.descricao = descricao;
		this.feita = feita;
	}
	
	public void Update(Tarefa tarefa) {
		if (tarefa != null) {
			this.descricao  = tarefa.descricao;
			this.feita = tarefa.feita;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getFeita() {
        return feita;
    }

    public void setFeita(Boolean feita) {
        this.feita = feita;
    }
	
	@Override
	public String toString() {
		return "CatalogItem [id=" + id + ", descricao=" + descricao + ", feita=" + feita + "]";
	}
}
