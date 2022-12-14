/* Example script*/
CREATE TABLE bd_api_sample.tb_curso (
	id serial NOT NULL,
	nome varchar(40) NOT NULL,
	tipoCurso varchar(30) NOT NULL,
	data_cadastro DATE NOT NULL,
	data_alteracao DATE NULL,
	aluno varchar(30) NULL,
	CONSTRAINT curso_pk PRIMARY KEY (id)
);