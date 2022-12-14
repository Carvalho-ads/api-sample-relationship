package com.sample.api.enums;

public enum TipoCursoEnum {

	GRADUACAO("GRADUAÇÃO"), 
	POS_GRADUACAO("PÓS-GRADUAÇÃO"),
	MBA("MBA");

	private final String descricao;

	TipoCursoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
