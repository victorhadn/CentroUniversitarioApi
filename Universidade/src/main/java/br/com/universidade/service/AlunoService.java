package br.com.universidade.service;

import java.util.List;

import br.com.universidade.mode.Aluno;

public interface AlunoService {

	Aluno buscaPorIdAluno(Long id);

	Aluno salvar(Aluno aluno);

	List<Aluno> listarAlunos();

	void removerPorAluno(Aluno aluno);

	void removerPorId(Aluno aluno);


}
