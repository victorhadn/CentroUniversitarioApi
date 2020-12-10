package br.com.universidade.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.universidade.mode.Professor;



@Repository
public interface ProfessorRepository extends JpaRepository <Professor, Long> {

}
