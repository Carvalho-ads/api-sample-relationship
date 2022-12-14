/* Example script*/
CREATE TABLE bd_api_sample.tb_aluno (
	id serial NOT NULL,
	nome varchar(40) NOT NULL,
	matricula varchar(12) NOT NULL,
	data_cadastro DATE NOT NULL,
	data_alteracao DATE NULL,
	tipoGenero varchar(30) NOT NULL,
	curso_id bigint NOT NULL,
	CONSTRAINT aluno_pk PRIMARY KEY (id),
	CONSTRAINT aluno_curso_fk FOREIGN KEY (curso_id) REFERENCES bd_api_sample.tb_curso(id)
);