package com.sample.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.api.model.Aluno;
import com.sample.api.repository.AlunoRepository;


@RestController
@RequestMapping("/aluno")
public class AlunoController {
	
	
	@Autowired 	/* Faz a injeção de dependência, tornando desnecessário  */
	AlunoRepository repository;
	
	
	@GetMapping(value= "/listar")      /*faz o mapeamento da URL e encontra os métodos*/
    @ResponseBody                      	/*Retorna um corpo com reposta à requisição feita, neste caso, como resposta vou retornar os alunos cadastrados*/
    public ResponseEntity<List<Aluno>> ListaAluno(){
    	List<Aluno> alunos = repository.findAll();   /*por meio do método "findAll" do JpaRepository executa a consultar no banco de dados*/
    	
    	return new ResponseEntity<List<Aluno>>(alunos, HttpStatus.OK);	/*Retorna a lista em JSON*/
    }
	
	
	 @GetMapping(value= "/buscar") 
	    @ResponseBody 
	    public ResponseEntity<Aluno> buscarId(@RequestParam(name = "id") Long id){   /*recebe os parâmetros para realizar a consulta*/	
		Aluno aluno = repository.findById(id).get();		/*executa a consulta no banco de dados*/
	    return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);		/*Retorna em JSON a entidade específica pesquesida */    	
	    }
	    
	 
	
	@PostMapping(value= "/novo")      																                 																 
    public ResponseEntity<Aluno> CadastrarAluno(@RequestBody Aluno aluno){ 	/*Recebe os dados para persistir no banco de dados*/
    	Aluno aln = repository.save(aluno);    /*por meio do método "findAll" do JpaRepository executa a consultar no banco de dados*/
    	return new ResponseEntity<Aluno>(aln, HttpStatus.CREATED);		/*Retorna a lista em JSON do objeto criado "aln" e o HttpStatus*/
    }
	
	

	@PutMapping(value = "/atualizar")
    @ResponseBody
    public ResponseEntity<?> atualizar (@RequestBody Aluno aluno){
    	
    	if(aluno.getId() == null) {		/* Validação para verificar se o id informado não é nulo*/
    		return new ResponseEntity<String>("Id não foi informado", HttpStatus.BAD_REQUEST);           
    	}
    	
    	Aluno aln = repository.saveAndFlush(aluno);
    	return new ResponseEntity<Aluno>(aln, HttpStatus.OK);	 /*Retorna a lista em JSON do objeto atualizado "aln" e o HttpStatus*/
    }
	
	
	@DeleteMapping(value = "/deletar/{id}")
	@ResponseBody
	public ResponseEntity<?> deletar(@PathVariable Long id){
		repository.deleteById(id);
		return new ResponseEntity<String>("Deletado com sucesso", HttpStatus.ACCEPTED);	/*Retorna a mensagem do objeto deletado do banco por meio do "id" e o HttpStatus*/
	}
	
}
