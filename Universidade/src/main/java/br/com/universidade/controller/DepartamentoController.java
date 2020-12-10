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

import br.com.universidade.mode.Departamento;
import io.swagger.annotations.ApiOperation;
import br.com.universidade.service.DepartamentoService;


@RestController
@RequestMapping("/departamentos/api")
public class DepartamentoController {

	
	@Autowired
	private DepartamentoService service;
	
	@ApiOperation(
			value="Listar um departamento novo", 
			response=ResponseEntity.class, 
			notes="Essa operação lista um novo registro com as informações do departamento.")
	@GetMapping("/v1")
	public List<Departamento> listarv1() {
		System.out.println("Chamando a versão 1");
		return this.service.listarDepartamentos();
	}
	@ApiOperation(
			value="Listar um departamento novo", 
			response=ResponseEntity.class, 
			notes="Essa operação lista um novo registro com as informações do departamento.")
	@GetMapping("/v2")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Departamento>> Listarv2() {
		return ResponseEntity.ok().body(this.service.listarDepartamentos());
	}

	@ApiOperation(
			value="Buscar um departamento", 
			response=ResponseEntity.class, 
			notes="Essa operação busca um departamento por ID.")
	@PutMapping("/{id}")
	public Departamento editar(@PathVariable("id") Long id, @RequestBody Departamento departamento) {
		Departamento departamentoDoBancoDeDados = this.service.buscaPorIdDepartamento(id);
		BeanUtils.copyProperties(departamento, departamentoDoBancoDeDados, "id");
		this.service.salvar(departamentoDoBancoDeDados);
		return departamentoDoBancoDeDados;
		
	}
	@ApiOperation(
			value="Remove um departamento novo", 
			response=ResponseEntity.class, 
			notes="Essa operação remove um departamento por ID.")
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable("id") Long id) {
		this.service.removerPorId(this.service.buscaPorIdDepartamento(id));
	}
	
	@ApiOperation(
			value="Salva um departamento novo", 
			response=ResponseEntity.class, 
			notes="Essa operação salva um novo registro com as informações do departamento.")
	@PostMapping("/v1")
	public Departamento salvarv1(@RequestBody Departamento departamento) {
		return this.service.salvar(departamento);
	}
	
	
	@ApiOperation(
			value="Cadastrar um departamento novo", 
			response=ResponseEntity.class, 
			notes="Essa operação salva um novo registro com as informações do departamento.")
	@PostMapping("/v2")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Departamento> salvarv2(@RequestBody Departamento departamento) {
		return ResponseEntity.ok().body(this.service.salvar(departamento));
	}
}

