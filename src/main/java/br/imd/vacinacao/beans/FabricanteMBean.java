package br.imd.vacinacao.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import br.imd.vacinacao.dao.FabricanteVacinaDAO;
import br.imd.vacinacao.dominio.FabricanteVacina;
import br.imd.vacinacao.util.VacinacaoException;

@ManagedBean(name = "FabricanteMB")
@ViewScoped
public class FabricanteMBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6783781356226319385L;
	
	private FabricanteVacina fabricanteVacina = new FabricanteVacina();
	private FabricanteVacinaDAO fabricanteVacinaDAO = new FabricanteVacinaDAO();
	
	private Integer fabricanteVacinaId;
	private String fabricanteVacinaDescricao;
	private String fabricanteVacinaLote;
	private Date fabricanteVacinaValidade = new Date();
	private Integer fabricanteVacinaQuantidade;
	
	public FabricanteVacina getFabricanteVacina() {
		return fabricanteVacina;
	}

	public void setFabricanteVacina(FabricanteVacina fabricanteVacina) {
		this.fabricanteVacina = fabricanteVacina;
	}
	
	public FabricanteVacinaDAO getFabricanteVacinaDAO() {
		return fabricanteVacinaDAO;
	}

	public void setFabricanteVacinaDAO(FabricanteVacinaDAO fabricanteVacinaDAO) {
		this.fabricanteVacinaDAO = fabricanteVacinaDAO;
	}
	
	public Integer getFabricanteVacinaId() {
		return fabricanteVacinaId;
	}

	public void setFabricanteVacinaId(Integer fabricanteVacinaId) {
		this.fabricanteVacinaId = fabricanteVacinaId;
	}

	public String getFabricanteVacinaDescricao() {
		return fabricanteVacinaDescricao;
	}

	public void setFabricanteVacinaDescricao(String fabricanteVacinaDescricao) {
		this.fabricanteVacinaDescricao = fabricanteVacinaDescricao;
	}

	public String getFabricanteVacinaLote() {
		return fabricanteVacinaLote;
	}

	public void setFabricanteVacinaLote(String fabricanteVacinaLote) {
		this.fabricanteVacinaLote = fabricanteVacinaLote;
	}

	public Date getFabricanteVacinaValidade() {
		return fabricanteVacinaValidade;
	}

	public void setFabricanteVacinaValidade(Date fabricanteVacinaValidade) {
		this.fabricanteVacinaValidade = fabricanteVacinaValidade;
	}

	public Integer getFabricanteVacinaQuantidade() {
		return fabricanteVacinaQuantidade;
	}

	public void setFabricanteVacinaQuantidade(Integer fabricanteVacinaQuantidade) {
		this.fabricanteVacinaQuantidade = fabricanteVacinaQuantidade;
	}

	//Ações

	public void apagar(FabricanteVacina fabricanteVacina) throws VacinacaoException, IOException {
		fabricanteVacinaDAO.excluir(fabricanteVacina);
		FacesContext.getCurrentInstance().getExternalContext().redirect(
    			FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
				+"/gerencia/fabricante/listagem.xhtml");
	}

	public List<FabricanteVacina> getLista() throws VacinacaoException{
		return fabricanteVacinaDAO.listar();
	}
	
	public void editar(FabricanteVacina fabricanteVacina) throws IOException {
		this.fabricanteVacina = fabricanteVacina;
		this.setFabricanteVacinaId(fabricanteVacina.getId());
		
		FacesContext.getCurrentInstance().getExternalContext().redirect(
    			FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
				+"/gerencia/fabricante/cadastro.xhtml");
	}
	
	public void gravar() throws VacinacaoException, IOException {
		if(this.fabricanteVacina.getId() == null) {
			fabricanteVacinaDAO.salvar(this.fabricanteVacina);
		} else {
			fabricanteVacinaDAO.atualizar(fabricanteVacina);
		}
		this.fabricanteVacina = new FabricanteVacina();
		
	}
	
	public void atualizarFabricanteVacina(AjaxBehaviorEvent e) throws VacinacaoException {
		this.fabricanteVacina = fabricanteVacinaDAO.buscarId(fabricanteVacinaId);
		this.fabricanteVacinaDescricao = this.fabricanteVacina.getDescricao();
		this.fabricanteVacinaLote = this.fabricanteVacina.getLote();
		this.fabricanteVacinaValidade = this.fabricanteVacina.getValidade();
		this.fabricanteVacinaQuantidade = this.fabricanteVacina.getQuantidade();
	}
	
	public void goListagemFabricante() throws VacinacaoException, IOException {
		
		FacesContext.getCurrentInstance().getExternalContext().redirect(
				FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
				+"/gerencia/fabricante/listagem.xhtml");
	        
    }
	
	public void goCadastroFabricante() throws VacinacaoException, IOException {
   		
		FacesContext.getCurrentInstance().getExternalContext().redirect(
				FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
				+"/gerencia/fabricante/cadastro.xhtml");
	        
    }
	
}