package br.com.universidade.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.universidade.mode.Turma;


@Repository
public interface TurmaRepository extends JpaRepository <Turma, Long> {

}
