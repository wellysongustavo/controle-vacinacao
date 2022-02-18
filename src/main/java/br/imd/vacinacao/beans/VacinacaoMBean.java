package br.imd.vacinacao.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import br.imd.vacinacao.dao.VacinacaoDAO;
import br.imd.vacinacao.dominio.FabricanteVacina;
import br.imd.vacinacao.dominio.Paciente;
import br.imd.vacinacao.dominio.ProfissionalDeSaude;
import br.imd.vacinacao.dominio.Vacinacao;
import br.imd.vacinacao.util.VacinacaoException;

@ManagedBean(name = "VacinacaoMBean")
@ViewScoped
public class VacinacaoMBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6783781356226319385L;
	
	private Vacinacao vacinacao = new Vacinacao();
	private VacinacaoDAO vacinacaoDAO = new VacinacaoDAO();
	
	private Integer vacinacaoId;
	private FabricanteVacina vacinacaoFabricante = new FabricanteVacina();
	private Paciente vacinacaoPaciente = new Paciente();
	private ProfissionalDeSaude vacinacaoPs = new ProfissionalDeSaude();
	private Date vacinacaoDataAplicacao = new Date();
	private String vacinacaoLocal;
	
	public Vacinacao getVacinacao() {
		return vacinacao;
	}

	public void setVacinacao(Vacinacao vacinacao) {
		this.vacinacao = vacinacao;
	}

	public Integer getVacinacaoId() {
		return vacinacaoId;
	}

	public void setVacinacaoId(Integer vacinacaoId) {
		this.vacinacaoId = vacinacaoId;
	}

	public FabricanteVacina getVacinacaoFabricante() {
		return vacinacaoFabricante;
	}

	public void setVacinacaoFabricante(FabricanteVacina vacinacaoFabricante) {
		this.vacinacaoFabricante = vacinacaoFabricante;
	}
	
	public Paciente getVacinacaoPaciente() {
		return vacinacaoPaciente;
	}

	public void setVacinacaoPaciente(Paciente vacinacaoPaciente) {
		this.vacinacaoPaciente = vacinacaoPaciente;
	}

	public ProfissionalDeSaude getVacinacaoPs() {
		return vacinacaoPs;
	}

	public void setVacinacaoPs(ProfissionalDeSaude vacinacaoPs) {
		this.vacinacaoPs = vacinacaoPs;
	}

	public Date getVacinacaoDataAplicacao() {
		return vacinacaoDataAplicacao;
	}

	public void setVacinacaoDataAplicacao(Date vacinacaoDataAplicacao) {
		this.vacinacaoDataAplicacao = vacinacaoDataAplicacao;
	}

	public String getVacinacaoLocal() {
		return vacinacaoLocal;
	}

	public void setVacinacaoLocal(String vacinacaoLocal) {
		this.vacinacaoLocal = vacinacaoLocal;
	}

	//Ações
	
	public void apagar(Vacinacao vacinacao) throws VacinacaoException, IOException {
		vacinacaoDAO.excluir(vacinacao);
		FacesContext.getCurrentInstance().getExternalContext().redirect(
    			FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
				+"/gerencia/editora.xhtml");
	}
	
	public List<Vacinacao> getLista() throws VacinacaoException{
		return vacinacaoDAO.listar();
	}
	
	public void editar(Vacinacao vacinacao) {
		this.vacinacao = vacinacao;
		this.vacinacaoId = vacinacao.getId();
	}
	
	public void gravar() throws VacinacaoException {
		if(this.vacinacao.getId() == null) {
			vacinacaoDAO.salvar(this.vacinacao);
		} else {
			vacinacaoDAO.atualizar(vacinacao);
		}
		this.vacinacao = new Vacinacao();
	}
	
	public void atualizarVacinacao(AjaxBehaviorEvent e) throws VacinacaoException {
		this.vacinacao = vacinacaoDAO.buscarId(vacinacaoId);
		this.vacinacaoFabricante = this.vacinacao.getVacina();
		this.vacinacaoPaciente = this.vacinacao.getPaciente();
		this.vacinacaoPs = this.vacinacao.getPs();
		this.vacinacaoDataAplicacao = this.vacinacao.getDataAplicacao();
		this.vacinacaoLocal= this.vacinacao.getLocal();
	}
	
	public void goListagemVacinacao() throws VacinacaoException, IOException {
		
		System.out.println(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath());	
		FacesContext.getCurrentInstance().getExternalContext().redirect(
				FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
				+"/gerencia/editora.xhtml");
	        
    }
	
	public void goCadastroVacinacao() throws VacinacaoException, IOException {
   		
		FacesContext.getCurrentInstance().getExternalContext().redirect(
				FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
				+"/gerencia/editora/cadastro.xhtml");
	        
    }
	
}

