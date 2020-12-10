package br.com.universidade.service;

import java.util.List;

import br.com.universidade.mode.Departamento;

public interface DepartamentoService {

	void removerPorDepartamento(Departamento departamento);

	List<Departamento> listarDepartamentos();

	Departamento salvar(Departamento departamento);

	Departamento buscaPorIdDepartamento(Long id);

	void removerPorId(Departamento departamento);

}
