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

import br.com.universidade.mode.Turma;
import io.swagger.annotations.ApiOperation;
import br.com.universidade.service.TurmaService;


@RestController
@RequestMapping("/turmas/api")
public class TurmaController {

	
	@Autowired
	private TurmaService service;
	
	@ApiOperation(
			value="Listar uma turma nova", 
			response=ResponseEntity.class, 
			notes="Essa operação lista um novo registro com as informações da turma.")
	@GetMapping("/v1")
	public List<Turma> listarv1() {
		System.out.println("Chamando a versão 1");
		return this.service.listarTurmas();
	}
	@ApiOperation(
			value="Listar uma turma nova", 
			response=ResponseEntity.class, 
			notes="Essa operação lista um novo registro com as informações da turma.")
	@GetMapping("/v2")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Turma>> Listarv2() {
		return ResponseEntity.ok().body(this.service.listarTurmas());
	}

	@ApiOperation(
			value="Buscar uma turma", 
			response=ResponseEntity.class, 
			notes="Essa operação busca uma turma por ID.")
	@PutMapping("/{id}")
	public Turma editar(@PathVariable("id") Long id, @RequestBody Turma turma) {
		Turma turmaDoBancoDeDados = this.service.buscaPorIdTurma(id);
		BeanUtils.copyProperties(turma, turmaDoBancoDeDados, "id");
		this.service.salvar(turmaDoBancoDeDados);
		return turmaDoBancoDeDados;
		
	}
	@ApiOperation(
			value="Remove uma turma nova", 
			response=ResponseEntity.class, 
			notes="Essa operação remove uma turma por ID.")
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable("id") Long id) {
		this.service.removerPorId(this.service.buscaPorIdTurma(id));
	}
	
	@ApiOperation(
			value="Salva uma turma nova", 
			response=ResponseEntity.class, 
			notes="Essa operação salva um novo registro com as informações da turma.")
	@PostMapping("/v1")
	public Turma salvarv1(@RequestBody Turma turma) {
		return this.service.salvar(turma);
	}
	
	
	@ApiOperation(
			value="Cadastrar uma turma nova", 
			response=ResponseEntity.class, 
			notes="Essa operação salva um novo registro com as informações da turma.")
	@PostMapping("/v2")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Turma> salvarv2(@RequestBody Turma turma) {
		return ResponseEntity.ok().body(this.service.salvar(turma));
	}
}