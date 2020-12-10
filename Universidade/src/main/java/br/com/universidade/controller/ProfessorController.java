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

import br.com.universidade.mode.Professor;
import io.swagger.annotations.ApiOperation;
import br.com.universidade.service.ProfessorService;


@RestController
@RequestMapping("/professores/api")
public class ProfessorController {

	
	@Autowired
	private ProfessorService service;
	
	@ApiOperation(
			value="Listar um professor novo", 
			response=ResponseEntity.class, 
			notes="Essa operação lista um novo registro com as informações do professor.")
	@GetMapping("/v1")
	public List<Professor> listarv1() {
		System.out.println("Chamando a versão 1");
		return this.service.listarProfessores();
	}
	@ApiOperation(
			value="Listar um professor novo", 
			response=ResponseEntity.class, 
			notes="Essa operação lista um novo registro com as informações do professor.")
	@GetMapping("/v2")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Professor>> Listarv2() {
		return ResponseEntity.ok().body(this.service.listarProfessores());
	}

	@ApiOperation(
			value="Buscar um professor", 
			response=ResponseEntity.class, 
			notes="Essa operação busca um professor por ID.")
	@PutMapping("/{id}")
	public Professor editar(@PathVariable("id") Long id, @RequestBody Professor professor) {
		Professor professorDoBancoDeDados = this.service.buscaPorIdProfessor(id);
		BeanUtils.copyProperties(professor, professorDoBancoDeDados, "id");
		this.service.salvar(professorDoBancoDeDados);
		return professorDoBancoDeDados;
		
	}
	@ApiOperation(
			value="Remove um professor novo", 
			response=ResponseEntity.class, 
			notes="Essa operação remove um professor por ID.")
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable("id") Long id) {
		this.service.removerPorId(this.service.buscaPorIdProfessor(id));
	}
	
	@ApiOperation(
			value="Salva um professor novo", 
			response=ResponseEntity.class, 
			notes="Essa operação salva um novo registro com as informações do professor.")
	@PostMapping("/v1")
	public Professor salvarv1(@RequestBody Professor professor) {
		return this.service.salvar(professor);
	}
	
	
	@ApiOperation(
			value="Cadastrar um professor novo", 
			response=ResponseEntity.class, 
			notes="Essa operação salva um novo registro com as informações do professor.")
	@PostMapping("/v2")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Professor> salvarv2(@RequestBody Professor professor) {
		return ResponseEntity.ok().body(this.service.salvar(professor));
	}
}
