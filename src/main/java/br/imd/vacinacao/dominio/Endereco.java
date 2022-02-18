package br.imd.vacinacao.dominio;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column 
	private String cidade;
	
	@Column(length = 2)
	private String estado;
	
	@Column(length = 10)
	private String cep;
	
	@Column(length = 40)
	private String rua;
	
	@Column(length = 50)
	private String comentario;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "paciente_id")
	private Set<Paciente> pacientes;
	
	public Endereco(String cidade, String estado, String cep, String rua, String comentario) {
		super();
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.rua = rua;
		this.comentario = comentario;
	}
	public Endereco(String cidade, String estado, String cep, String rua) {
		super();
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.rua = rua;
	}
	public Endereco() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Set<Paciente> getPacientes() {
		return pacientes;
	}
	public void setPacientes(Set<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cep, cidade, estado, rua);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(cidade, other.cidade)
				&& Objects.equals(estado, other.estado) && Objects.equals(rua, other.rua);
	}
	
	
	
}
