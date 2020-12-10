package br.com.universidade.service;

import java.util.List;

import br.com.universidade.mode.Turma;

public interface TurmaService {

	void removerPorId(Turma turma);

	void removerPorTurma(Turma turma);

	List<Turma> listarTurmas();

	Turma buscaPorIdTurma(Long id);

	Turma salvar(Turma turmaDoBancoDeDados);

}
