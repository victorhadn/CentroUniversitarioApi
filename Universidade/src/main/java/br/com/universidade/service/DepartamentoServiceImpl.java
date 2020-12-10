package br.com.universidade.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.universidade.mode.Departamento;
import br.com.universidade.repository.DepartamentoRepository;



@Service
public class DepartamentoServiceImpl implements DepartamentoService {
	
	@Autowired
	private DepartamentoRepository repository;
	
	@Transactional
	@Override
	public Departamento salvar(Departamento departamento) {
		return this.repository.save(departamento);
		
	}
	
	@Override
	public List<Departamento> listarDepartamentos() {
		return this.repository.findAll();
	}

    @Override
	@Transactional
	public void removerPorDepartamento(Departamento departamento) {
		this.repository.delete(departamento);
		
	}
    

	@Override
	public Departamento buscaPorIdDepartamento(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removerPorId(Departamento departamento) {
		// TODO Auto-generated method stub
		
	}


}