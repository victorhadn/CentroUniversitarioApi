package br.com.universidade.mode;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_professores")

public class Professor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	private String nome;
	private String matricula;
	private String telefone;
	
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
    
    
	@OneToMany
	@JoinColumn(name ="professor_id")
	private List<Departamento> departamento;
	
    @OneToMany
    @JoinColumn(name = "professor_id")
    private List<Turma> turma;
    
    
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}
