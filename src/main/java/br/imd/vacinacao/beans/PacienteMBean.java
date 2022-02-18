package br.imd.vacinacao.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import br.imd.vacinacao.dao.EnderecoDAO;
import br.imd.vacinacao.dao.PacienteDAO;
import br.imd.vacinacao.dominio.Endereco;
import br.imd.vacinacao.dominio.Paciente;
import br.imd.vacinacao.dominio.Usuario;
import br.imd.vacinacao.util.VacinacaoException;

@ManagedBean(name = "PacienteMB")
@ViewScoped
public class PacienteMBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6783781356226319385L;
	
	private Paciente paciente = new Paciente();
	private PacienteDAO pacienteDAO = new PacienteDAO();
	
	private Integer pacienteId;
	private String pacienteNome;
	private String pacienteSobrenome;
	private String pacienteCpf;
	private String pacienteRg;
	private String pacienteEmail;
	private String pacienteTelefone;
	
	private Endereco pacienteEndereco = new Endereco();
	private EnderecoDAO pacienteEnderecoDAO = new EnderecoDAO();
	
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public PacienteDAO getPacienteDAO() {
		return pacienteDAO;
	}

	public void setPacienteDAO(PacienteDAO pacienteDAO) {
		this.pacienteDAO = pacienteDAO;
	}

	public Integer getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Integer pacienteId) {
		this.pacienteId = pacienteId;
	}

	public String getPacienteNome() {
		return pacienteNome;
	}

	public void setPacienteNome(String pacienteNome) {
		this.pacienteNome = pacienteNome;
	}

	public String getPacienteSobrenome() {
		return pacienteSobrenome;
	}

	public void setPacienteSobrenome(String pacienteSobrenome) {
		this.pacienteSobrenome = pacienteSobrenome;
	}

	public String getPacienteCpf() {
		return pacienteCpf;
	}

	public void setPacienteCpf(String pacienteCpf) {
		this.pacienteCpf = pacienteCpf;
	}

	public String getPacienteRg() {
		return pacienteRg;
	}

	public void setPacienteRg(String pacienteRg) {
		this.pacienteRg = pacienteRg;
	}

	public String getPacienteEmail() {
		return pacienteEmail;
	}

	public void setPacienteEmail(String pacienteEmail) {
		this.pacienteEmail = pacienteEmail;
	}

	public String getPacienteTelefone() {
		return pacienteTelefone;
	}

	public void setPacienteTelefone(String pacienteTelefone) {
		this.pacienteTelefone = pacienteTelefone;
	}

	public Endereco getPacienteEndereco() {
		return pacienteEndereco;
	}

	public void setPacienteEndereco(Endereco pacienteEndereco) {
		this.pacienteEndereco = pacienteEndereco;
	}

	public EnderecoDAO getPacienteEnderecoDAO() {
		return pacienteEnderecoDAO;
	}

	public void setPacienteEnderecoDAO(EnderecoDAO pacienteEnderecoDAO) {
		this.pacienteEnderecoDAO = pacienteEnderecoDAO;
	}
	
	//Ações
	
	public void apagar(Paciente paciente) throws VacinacaoException, IOException {
		pacienteDAO.excluir(paciente);
		FacesContext.getCurrentInstance().getExternalContext().redirect(
    			FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
				+"/gerencia/paciente/listagem.xhtml");
	}

	public List<Paciente> getLista() throws VacinacaoException{
		return pacienteDAO.listar();
	}
	
	public void editar(Paciente paciente) throws IOException {
		this.paciente = paciente;
		this.setPacienteId(paciente.getId());
		
		FacesContext.getCurrentInstance().getExternalContext().redirect(
    			FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
				+"/gerencia/paciente/cadastro.xhtml");
	}
	
	public void gravar() throws VacinacaoException, IOException {
		if(this.paciente.getId() == null) {
			pacienteDAO.salvar(this.paciente);
		} else {
			pacienteDAO.atualizar(paciente);
		}
		this.paciente = new Paciente();
	}
	
	public void atualizarPaciente(AjaxBehaviorEvent e) throws VacinacaoException {
		this.paciente = pacienteDAO.buscarId(pacienteId);
		this.pacienteNome = this.paciente.getNome();
		this.pacienteSobrenome = this.paciente.getSobrenome();
		this.pacienteCpf = this.paciente.getCpf();
		this.pacienteRg = this.paciente.getRg();
		this.pacienteEmail = this.paciente.getEmail();
		this.pacienteTelefone = this.paciente.getTelefone();
		this.pacienteEndereco = this.paciente.getEndereco();
	}
	
	public void validaLogin() throws VacinacaoException, IOException {

	    for (Paciente pac : pacienteDAO.listar()) {
	        if (pac.getCpf().equals(paciente.getCpf())) {
            	FacesContext.getCurrentInstance().getExternalContext().redirect(
        			FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
    				+"/paciente/cadastro-vacinacao.xhtml");
	        }
	    }
	    
	    FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
	}
	
	public void goListagemPaciente() throws VacinacaoException, IOException {
		
		FacesContext.getCurrentInstance().getExternalContext().redirect(
				FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
				+"/gerencia/paciente/listagem.xhtml");
	        
    }
	
	public void goCadastroPaciente() throws VacinacaoException, IOException {
   		
		FacesContext.getCurrentInstance().getExternalContext().redirect(
				FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
				+"/gerencia/paciente/cadastro.xhtml");
	        
    }
	
}