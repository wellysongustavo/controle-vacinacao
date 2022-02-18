package br.imd.vacinacao.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Vacinacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "id_fabricante_vacina")
	private FabricanteVacina vacina;
	
	@OneToOne
	@JoinColumn(name = "id_paciente")
	private Paciente paciente;
	
	@OneToOne
	@JoinColumn(name = "id_profissional_de_saude")
	private ProfissionalDeSaude ps;
	
	@Temporal(TemporalType.DATE)
	private Date dataAplicacao;
	
	@Column(length = 50)
	private String local;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public FabricanteVacina getVacina() {
		return vacina;
	}

	public void setVacina(FabricanteVacina vacina) {
		this.vacina = vacina;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public ProfissionalDeSaude getPs() {
		return ps;
	}

	public void setPs(ProfissionalDeSaude ps) {
		this.ps = ps;
	}

	public Date getDataAplicacao() {
		return dataAplicacao;
	}

	public void setDataAplicacao(Date dataAplicacao) {
		this.dataAplicacao = dataAplicacao;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
	
	
	
}
