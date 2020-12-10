package br.com.universidade.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.universidade.mode.Professor;
import br.com.universidade.repository.ProfessorRepository;

@Service
public class ProfessorServiceImpl implements ProfessorService {
	
	@Autowired
	private ProfessorRepository repository;
	
    @Override
	@Transactional
	public Professor salvar(Professor professor) {
		return this.repository.save(professor);
		
	}
	
    @Override
	public List<Professor> listarProfessores() {
		return this.repository.findAll();
	}


	@Override
	public Professor buscaPorIdProfessor(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void removerPorId(Professor professor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerPorId(Long id) {
		// TODO Auto-generated method stub
		
	}

}

