package com.sample.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sample.api.enums.TipoCursoEnum;
import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_curso", schema = "bd_api_sample")
public class Curso implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_curso")
	private TipoCursoEnum tipoCurso;
	
	@NotNull
	@Column(name="nome")
	private String nome;
	
	@Column(name="data_cadastro")
	private Date dataCadastro;
	
	@Column(name="data_alteracao")
	private Date dataAlteracao;
	
	@Transient
	private List<Aluno> aluno = new ArrayList<Aluno>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoCursoEnum getTipoCurso() {
		return tipoCurso;
	}

	public void setTipoCurso(TipoCursoEnum tipoCurso) {
		this.tipoCurso = tipoCurso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public List<Aluno> getAluno() {
		return aluno;
	}

	public void setAluno(List<Aluno> aluno) {
		this.aluno = aluno;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	
}
