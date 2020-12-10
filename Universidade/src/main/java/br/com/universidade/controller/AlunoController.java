package br.com.universidade.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.universidade.mode.Aluno;
import io.swagger.annotations.ApiOperation;
import br.com.universidade.service.AlunoService;


@RestController
@RequestMapping("/alunos/api")
public class AlunoController {

	
	@Autowired
	private AlunoService service;
	
	@ApiOperation(
			value="Listar um aluno novo", 
			response=ResponseEntity.class, 
			notes="Essa operação lista um novo registro com as informações do aluno.")
	@GetMapping("/v1")
	public List<Aluno> listarv1() {
		System.out.println("Chamando a versão 1");
		return this.service.listarAlunos();
	}
	@ApiOperation(
			value="Listar um aluno novo", 
			response=ResponseEntity.class, 
			notes="Essa operação lista um novo registro com as informações do aluno.")
	@GetMapping("/v2")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Aluno>> Listarv2() {
		return ResponseEntity.ok().body(this.service.listarAlunos());
	}

	@ApiOperation(
			value="Buscar um aluno", 
			response=ResponseEntity.class, 
			notes="Essa operação busca um aluno por ID.")
	@PutMapping("/{id}")
	public Aluno editar(@PathVariable("id") Long id, @RequestBody Aluno aluno) {
		Aluno alunoDoBancoDeDados = this.service.buscaPorIdAluno(id);
		BeanUtils.copyProperties(aluno, alunoDoBancoDeDados, "id");
		this.service.salvar(alunoDoBancoDeDados);
		return alunoDoBancoDeDados;
		
	}
	@ApiOperation(
			value="Remove um aluno novo", 
			response=ResponseEntity.class, 
			notes="Essa operação remove um aluno por ID.")
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable("id") Long id) {
		this.service.removerPorId(this.service.buscaPorIdAluno(id));
	}
	
	@ApiOperation(
			value="Salva um aluno novo", 
			response=ResponseEntity.class, 
			notes="Essa operação salva um novo registro com as informações do aluno.")
	@PostMapping("/v1")
	public Aluno salvarv1(@RequestBody Aluno aluno) {
		return this.service.salvar(aluno);
	}
	
	
	@ApiOperation(
			value="Cadastrar um aluno novo", 
			response=ResponseEntity.class, 
			notes="Essa operação salva um novo registro com as informações do aluno.")
	@PostMapping("/v2")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Aluno> salvarv2(@RequestBody Aluno aluno) {
		return ResponseEntity.ok().body(this.service.salvar(aluno));
	}
}

