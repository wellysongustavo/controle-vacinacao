package br.imd.vacinacao.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import br.imd.vacinacao.dao.EnderecoDAO;
import br.imd.vacinacao.dominio.Endereco;
import br.imd.vacinacao.util.VacinacaoException;

@ManagedBean(name = "EnderecoMB")
@ViewScoped
public class EnderecoMBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6783781356226319385L;
	
	private Endereco endereco = new Endereco();
	private EnderecoDAO enderecoDAO = new EnderecoDAO();
	
	private Integer enderecoId;
	private String enderecoCidade;
	private String enderecoEstado;
	private String enderecoCep;
	private String enderecoRua;
	private String enderecoComentario;
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public EnderecoDAO getEnderecoDAO() {
		return enderecoDAO;
	}

	public void setEnderecoDAO(EnderecoDAO enderecoDAO) {
		this.enderecoDAO = enderecoDAO;
	}
	
	public Integer getEnderecoId() {
		return enderecoId;
	}

	public void setEnderecoId(Integer enderecoId) {
		this.enderecoId = enderecoId;
	}
	
	public String getEnderecoCidade() {
		return enderecoCidade;
	}

	public void setEnderecoCidade(String enderecoCidade) {
		this.enderecoCidade = enderecoCidade;
	}

	public String getEnderecoEstado() {
		return enderecoEstado;
	}

	public void setEnderecoEstado(String enderecoEstado) {
		this.enderecoEstado = enderecoEstado;
	}

	public String getEnderecoCep() {
		return enderecoCep;
	}

	public void setEnderecoCep(String enderecoCep) {
		this.enderecoCep = enderecoCep;
	}

	public String getEnderecoRua() {
		return enderecoRua;
	}

	public void setEnderecoRua(String enderecoRua) {
		this.enderecoRua = enderecoRua;
	}

	public String getEnderecoComentario() {
		return enderecoComentario;
	}

	public void setEnderecoComentario(String enderecoComentario) {
		this.enderecoComentario = enderecoComentario;
	}

	//Ações

	public void apagar(Endereco endereco) throws VacinacaoException, IOException {
		enderecoDAO.excluir(endereco);
		FacesContext.getCurrentInstance().getExternalContext().redirect(
    			FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
				+"/gerencia/endereco/listagem.xhtml");
	}

	public List<Endereco> getLista() throws VacinacaoException{
		return enderecoDAO.listar();
	}
	
	public void gravar() throws VacinacaoException, IOException {
		if(this.endereco.getId() == null) {
			enderecoDAO.salvar(this.endereco);
		} else {
			enderecoDAO.atualizar(endereco);
		}
		this.endereco = new Endereco();
		
	}
	
	public void atualizarEndereco(AjaxBehaviorEvent e) throws VacinacaoException {
		this.endereco = enderecoDAO.buscarId(getEnderecoId());
		this.enderecoRua = this.endereco.getRua();
		this.enderecoCidade = this.endereco.getCidade();
		this.enderecoEstado = this.endereco.getEstado();
		this.enderecoCep = this.endereco.getCep();
		this.enderecoComentario = this.endereco.getComentario();
	}
	
	public void goListagemEndereco() throws VacinacaoException, IOException {
		
		FacesContext.getCurrentInstance().getExternalContext().redirect(
				FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
				+"/gerencia/endereco/listagem.xhtml");
	        
    }
	
	public void goCadastroEndereco() throws VacinacaoException, IOException {
   		
		FacesContext.getCurrentInstance().getExternalContext().redirect(
				FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
				+"/gerencia/endereco/cadastro.xhtml");
	        
    }
	
}
