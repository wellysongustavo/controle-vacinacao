package br.imd.vacinacao.beans;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.imd.vacinacao.util.VacinacaoException;

@ManagedBean(name = "DashboardMB")
@ViewScoped
public class DashboardMBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6783781356226319385L;
	
	public void goDashboard() throws VacinacaoException, IOException {

		FacesContext.getCurrentInstance().getExternalContext().redirect(
			FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
			+"/gerencia/dashboard.xhtml");
	
	}
}
