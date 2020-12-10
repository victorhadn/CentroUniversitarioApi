package br.com.universidade.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.universidade.mode.Aluno;



@Repository
public interface AlunoRepository extends JpaRepository <Aluno, Long> {

}
