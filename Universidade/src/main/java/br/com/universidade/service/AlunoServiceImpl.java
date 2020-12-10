package br.com.universidade.service;


import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.universidade.mode.Aluno;
import br.com.universidade.repository.AlunoRepository;


@Service
public class AlunoServiceImpl implements AlunoService {
	
	@Autowired
	private AlunoRepository repository;
	
	@Override
	@Transactional
	public Aluno salvar(Aluno aluno) {
		return this.repository.save(aluno);
		
	}

	@Override
	public Aluno buscaPorIdAluno(Long id) {
		return null;
	}
    
    @Override
	public List<Aluno> listarAlunos() {
		return this.repository.findAll();
	}

	@Override
	@Transactional
	public void removerPorAluno(Aluno aluno) {
		this.repository.delete(aluno);
		
	}

	@Override
	public void removerPorId(Aluno aluno) {
		// TODO Auto-generated method stub
		
	}
}