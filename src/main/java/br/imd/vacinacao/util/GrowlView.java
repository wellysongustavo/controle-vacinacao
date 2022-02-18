package br.imd.vacinacao.util;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "GrowlView")
@RequestScoped
public class GrowlView {

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void successCadastroFabricante() {
        addMessage(FacesMessage.SEVERITY_INFO, "Cadastro realizado!", "Fabricante adicionado com sucesso.");
    }
    
    public void successRemocaoFabricante() {
        addMessage(FacesMessage.SEVERITY_INFO, "Remoção realizada!", "Fabricante removido com sucesso.");
    }
    
    public void successCadastroEndereco() {
        addMessage(FacesMessage.SEVERITY_INFO, "Cadastro realizado!", "Endereço adicionado com sucesso.");
    }
    
    public void successRemocaoEndereco() {
        addMessage(FacesMessage.SEVERITY_INFO, "Remoção realizada!", "Endereço removido com sucesso.");
    }
    
    public void successCadastroProfissional() {
        addMessage(FacesMessage.SEVERITY_INFO, "Cadastro realizado!", "Profissional adicionado com sucesso.");
    }
    
    public void successRemocaoProfissional() {
        addMessage(FacesMessage.SEVERITY_INFO, "Remoção realizada!", "Profissional removido com sucesso.");
    }
    
    public void successCadastroPaciente() {
        addMessage(FacesMessage.SEVERITY_INFO, "Cadastro realizado!", "Paciente adicionado com sucesso.");
    }
    
    public void successRemocaoPaciente() {
        addMessage(FacesMessage.SEVERITY_INFO, "Remoção realizada!", "Paciente removido com sucesso.");
    }
    
    public void showInfo() {
        addMessage(FacesMessage.SEVERITY_INFO, "Info Message", "Message Content");
    }
    
    public void showWarnPaciente() {
        addMessage(FacesMessage.SEVERITY_WARN, "Credenciais inválidas!", "CPF não cadastrado no sistema. Tente novamente com os dados corretos"
        		+ " ou solicte o cadastro a gerência.");
    }
    
    public void showWarn() {
        addMessage(FacesMessage.SEVERITY_WARN, "Credenciais inválidas!", "Login e/ou senha não conferem. Tente novamente com os dados corretos.");
    }

    public void showError() {
        addMessage(FacesMessage.SEVERITY_ERROR, "Error Message", "Message Content");
    }

    public void showSticky() {
        FacesContext.getCurrentInstance().addMessage("sticky-key", new FacesMessage(FacesMessage.SEVERITY_INFO, "Sticky Message", "Message Content"));
    }

    public void showMultiple() {
        addMessage(FacesMessage.SEVERITY_INFO, "Message 1", "Message Content");
        addMessage(FacesMessage.SEVERITY_INFO, "Message 2", "Message Content");
        addMessage(FacesMessage.SEVERITY_INFO, "Message 3", "Message Content");
    }
}