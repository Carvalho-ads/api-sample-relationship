package com.sample.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.api.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
