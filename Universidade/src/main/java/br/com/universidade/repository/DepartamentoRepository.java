package br.com.universidade.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.universidade.mode.Departamento;



@Repository
public interface DepartamentoRepository extends JpaRepository <Departamento, Long> {

	

}
