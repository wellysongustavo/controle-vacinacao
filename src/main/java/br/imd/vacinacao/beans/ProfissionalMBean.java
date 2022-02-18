package br.imd.vacinacao.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import br.imd.vacinacao.dao.ProfissionalDeSaudeDAO;
import br.imd.vacinacao.dominio.ProfissionalDeSaude;
import br.imd.vacinacao.util.VacinacaoException;

@ManagedBean(name = "ProfissionalMB")
@ViewScoped
public class ProfissionalMBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6783781356226319385L;
	
	private ProfissionalDeSaude profissional = new ProfissionalDeSaude();
	private ProfissionalDeSaudeDAO profissionalDAO = new ProfissionalDeSaudeDAO();
	
	private Integer profissionalId;
	private String profissionalNome;
	private String profissionalSobrenome;
	private String profissionalCpf;
	private String profissionalEmail;
	private String profissionalTelefone;
	private String profissionalProfissao;

	public ProfissionalDeSaude getProfissional() {
		return profissional;
	}

	public void setProfissional(ProfissionalDeSaude profissional) {
		this.profissional = profissional;
	}

	public ProfissionalDeSaudeDAO getProfissionalDAO() {
		return profissionalDAO;
	}

	public void setProfissionalDAO(ProfissionalDeSaudeDAO profissionalDAO) {
		this.profissionalDAO = profissionalDAO;
	}

	public Integer getProfissionalId() {
		return profissionalId;
	}

	public void setProfissionalId(Integer profissionalId) {
		this.profissionalId = profissionalId;
	}

	public String getProfissionalNome() {
		return profissionalNome;
	}

	public void setProfissionalNome(String profissionalNome) {
		this.profissionalNome = profissionalNome;
	}

	public String getProfissionalSobrenome() {
		return profissionalSobrenome;
	}

	public void setProfissionalSobrenome(String profissionalSobrenome) {
		this.profissionalSobrenome = profissionalSobrenome;
	}

	public String getProfissionalCpf() {
		return profissionalCpf;
	}

	public void setProfissionalCpf(String profissionalCpf) {
		this.profissionalCpf = profissionalCpf;
	}

	public String getProfissionalEmail() {
		return profissionalEmail;
	}

	public void setProfissionalEmail(String profissionalEmail) {
		this.profissionalEmail = profissionalEmail;
	}

	public String getProfissionalTelefone() {
		return profissionalTelefone;
	}

	public void setProfissionalTelefone(String profissionalTelefone) {
		this.profissionalTelefone = profissionalTelefone;
	}

	public String getProfissionalProfissao() {
		return profissionalProfissao;
	}

	public void setProfissionalProfissao(String profissionalProfissao) {
		this.profissionalProfissao = profissionalProfissao;
	}
	
	//Ações

	public void apagar(ProfissionalDeSaude profissional) throws VacinacaoException, IOException {
		profissionalDAO.excluir(profissional);
		FacesContext.getCurrentInstance().getExternalContext().redirect(
    			FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
				+"/gerencia/profissional/listagem.xhtml");
	}

	public List<ProfissionalDeSaude> getLista() throws VacinacaoException{
		return profissionalDAO.listar();
	}
	
	public void editar(ProfissionalDeSaude profissional) throws IOException {
		this.profissional = profissional;
		this.setProfissionalId(profissional.getId());
		
		FacesContext.getCurrentInstance().getExternalContext().redirect(
    			FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
				+"/gerencia/profissional/cadastro.xhtml");
	}
	
	public void gravar() throws VacinacaoException, IOException {
		if(this.profissional.getId() == null) {
			profissionalDAO.salvar(this.profissional);
		} else {
			profissionalDAO.atualizar(profissional);
		}
		this.profissional = new ProfissionalDeSaude();
		
	}
	
	public void atualizarProfissinal(AjaxBehaviorEvent e) throws VacinacaoException {
		this.profissional = profissionalDAO.buscarId(profissionalId);
		this.profissionalNome = this.profissional.getNome();
		this.profissionalSobrenome = this.profissional.getSobrenome();
		this.profissionalCpf = this.profissional.getCpf();
		this.profissionalEmail = this.profissional.getEmail();
		this.profissionalTelefone = this.profissional.getTelefone();
		this.profissionalProfissao = this.profissional.getProfissao();
	}
	
	public void goListagemProfissional() throws VacinacaoException, IOException {
		
		FacesContext.getCurrentInstance().getExternalContext().redirect(
				FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
				+"/gerencia/profissional/listagem.xhtml");
	        
    }
	
	public void goCadastroProfissional() throws VacinacaoException, IOException {
   		
		FacesContext.getCurrentInstance().getExternalContext().redirect(
				FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
				+"/gerencia/profissional/cadastro.xhtml");
	        
    }
	
}