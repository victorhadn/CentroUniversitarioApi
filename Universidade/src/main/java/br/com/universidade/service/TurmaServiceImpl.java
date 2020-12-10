package br.com.universidade.service;


import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.universidade.mode.Turma;
import br.com.universidade.repository.TurmaRepository;



@Service
public class TurmaServiceImpl implements TurmaService {
	
	@Autowired
	private TurmaRepository repository;
	
	@Transactional
	public Turma salvar(Turma turma) {
		return this.repository.save(turma);
		
	}
	
	@Override
	public List<Turma> listarTurmas() {
		return this.repository.findAll();
	}

	@Override
	@Transactional
	public void removerPorTurma(Turma turma) {
		this.repository.delete(turma);
		
	}
   
	@Override
	public Turma buscaPorIdTurma(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removerPorId(Turma turma) {
		// TODO Auto-generated method stub
		
	}
}