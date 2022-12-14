package com.sample.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.api.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>   {
	


}
