package br.imd.vacinacao.beans;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.imd.vacinacao.dao.UsuarioDAO;
import br.imd.vacinacao.dominio.Usuario;
import br.imd.vacinacao.util.VacinacaoException;


@ManagedBean(name = "LoginMB")
@ViewScoped
public class LoginMBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6783781356226319385L;
  
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	public void validaLogin() throws VacinacaoException, IOException {

	    for (Usuario user : usuarioDAO.listar()) {
	        if (user.getLogin().equals(usuario.getLogin())) {
	            if (user.getSenha().equals(usuario.getSenha())) {
	            	FacesContext.getCurrentInstance().getExternalContext().redirect(
	        			FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
	    				+"/gerencia/dashboard.xhtml");
	           }
	        }
	    }
	    
	    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
	}
	
}