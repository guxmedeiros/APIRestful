package org.serratec.backend.banco.entity;

import org.serratec.backend.banco.enums.Tipo;

public class OperacaoEntity {
	private Tipo tipo;
	private Double valor;
	
	public OperacaoEntity(Tipo tipo, Double valor) {
		super();
		this.tipo = tipo;
		this.valor = valor;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
}
