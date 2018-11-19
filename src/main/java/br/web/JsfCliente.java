/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web;

import br.data.entity.Endereco;
import br.data.entity.Loja;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Filipe
 */
@Named(value = "jsfCliente")
@ManagedBean
@RequestScoped
public class JsfCliente {

    private String   pkCpfCliente;
    private String   nomeCliente;
    private String   telefoneCliente;
    private String   emailCliente;
    private Endereco fkIdEndereco;
    private Loja     fkCnpjLoja;
    
    public JsfCliente() {
    }

    public String getPkCpfCliente() {
        return pkCpfCliente;
    }

    public void setPkCpfCliente(String pkCpfCliente) {
        this.pkCpfCliente = pkCpfCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public Endereco getFkIdEndereco() {
        return fkIdEndereco;
    }

    public void setFkIdEndereco(Endereco fkIdEndereco) {
        this.fkIdEndereco = fkIdEndereco;
    }

    public Loja getFkCnpjLoja() {
        return fkCnpjLoja;
    }

    public void setFkCnpjLoja(Loja fkCnpjLoja) {
        this.fkCnpjLoja = fkCnpjLoja;
    }
    
    public java.util.List<br.data.entity.Cliente> getAll() {
        
        return new br.data.crud.CrudCliente().getAll();
    }
    
    public java.util.List<br.data.entity.Cliente> getSelect() {
        
        if (this.pkCpfCliente != null && !this.pkCpfCliente.equals("")) {
            return new br.data.crud.CrudCliente().SelectByNome(pkCpfCliente);
        } else {
            return null;
        }
    }
    
    public void remove(br.data.entity.Cliente cliente) {
        Exception e = new br.data.crud.CrudCliente().remove(cliente);
         if (e == null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Sucesso!!", "Registro excluido com sucesso");
            FacesContext.getCurrentInstance().addMessage(null, message);

        } else {
            String msg = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Erro!", "Informe o administrador do erro: " + msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    public String update(br.data.entity.Cliente cliente) {
        
        this.pkCpfCliente       = cliente.getPkCpfCliente();
        this.nomeCliente        = cliente.getNomeCliente();
        this.fkCnpjLoja         = cliente.getFkCnpjLoja();
        this.fkIdEndereco       = cliente.getFkIdEndereco();
        this.emailCliente       = cliente.getEmailCliente();
        this.telefoneCliente    = cliente.getTelefoneCliente();
        
        return "merge.xhtml";
    }
    
    public String merge() {
     
        br.data.entity.Cliente cl;
        
        cl = new br.data.crud.CrudCliente().find(this.pkCpfCliente);
        cl.setPkCpfCliente(pkCpfCliente);
        
        //lj.setTeste1(new CrudTeste1().find(this.codTeste1));
        Exception e = new br.data.crud.CrudCliente().merge(cl);
        
        if (e == null) {
            
            this.setEmailCliente("");
            this.setNomeCliente("");
            this.setPkCpfCliente("");
            this.setTelefoneCliente("");
            
            
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Sucesso!!", "Registro alterado com sucesso");
            FacesContext.getCurrentInstance().addMessage(null, message);

        } else {
            
            String msg = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Erro!", "Informe o administrador do erro: " + msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        return "index.xhtml";
    }
    
    public String persist() {
        
        br.data.entity.Loja lj;
        lj = new br.data.entity.Loja();
        //tes.setCodigo(codigo);
        //tes.setNome(nome);
        //tes.setTeste1(new CrudTeste1().find(this.getCodTeste1()));
        Exception insert = new br.data.crud.CrudLoja().persist(lj);
        
        if (insert == null) {
            
            this.setEmailCliente("");
            this.setNomeCliente("");
            this.setPkCpfCliente("");
            this.setTelefoneCliente("");
            
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Sucesso!!", "Registro adicionado com sucesso");
            FacesContext.getCurrentInstance().addMessage(null, message);

        } else {
            String msg = insert.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Erro!", "Informe o administrador do erro: " + msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
            return null;
        }
        
        return "index.xhtml";
    }
}
