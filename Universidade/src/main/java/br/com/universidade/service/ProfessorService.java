package br.com.universidade.service;

import java.util.List;


import br.com.universidade.mode.Professor;

public interface ProfessorService {

	Professor salvar(Professor professor);

	List<Professor> listarProfessores();

	void removerPorId(Professor professor);

	Professor buscaPorIdProfessor(Long id);

	void removerPorId(Long id);

}
