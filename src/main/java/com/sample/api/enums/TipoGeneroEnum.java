package com.sample.api.enums;

public enum TipoGeneroEnum {

	HOMEM("HOMEM"), 
	MULHER("MULHER"),
	OUTRO("OUTRO");

	private final String descricao;

	TipoGeneroEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
