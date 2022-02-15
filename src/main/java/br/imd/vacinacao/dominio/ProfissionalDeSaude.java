package br.imd.vacinacao.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "profissionalDeSaude")
public class ProfissionalDeSaude implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 50, nullable = false)
	private String nome;
	
	@Column(length = 50, nullable = false)
	private String sobrenome;
	
	@Column(length = 15, nullable = false)
	private String cpf;
	
	@Column(length = 50)
	private String email;
	
	@Column(length = 20)
	private String telefone;
	
	@Column
	private String profissao;
	
	public ProfissionalDeSaude(String nome, String sobrenome, String cpf,  
			String email, String telefone, String profissao) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.profissao = profissao;
	}
	public ProfissionalDeSaude() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	

}
