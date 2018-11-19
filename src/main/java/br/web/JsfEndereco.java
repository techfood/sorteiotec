/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Filipe
 */
@Named(value = "jsfEndereco")
@ManagedBean
@RequestScoped
public class JsfEndereco {

    /**
     * Creates a new instance of JsfEndereco
     */
    
    private int pkIdEndereco;   
    private String rua;   
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    private String cidade;    
    private String estado;
    
    public JsfEndereco() {
    }

    public int getPkIdEndereco() {
        return pkIdEndereco;
    }

    public void setPkIdEndereco(int pkIdEndereco) {
        this.pkIdEndereco = pkIdEndereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public java.util.List<br.data.entity.Endereco> getAll() {
        
        return new br.data.crud.CrudEndereco().getAll();
    }
    
    /*public java.util.List<br.data.entity.Endereco> getSelect() {
        
        if (this.pkCpfCliente != null && !this.pkCpfCliente.equals("")) {
            return new br.data.crud.CrudCliente().SelectByNome(pkCpfCliente);
        } else {
            return null;
        }
    }*/
    
    public void remove(br.data.entity.Endereco endereco) {
        Exception e = new br.data.crud.CrudEndereco().remove(endereco);
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
    
    public String update(br.data.entity.Endereco endereco) {
        
        this.bairro         = endereco.getBairro();
        this.cep            = endereco.getCep();
        this.cidade         = endereco.getCidade();
        this.complemento    = endereco.getComplemento();
        this.estado         = endereco.getEstado();
        this.numero         = endereco.getNumero();
        this.pkIdEndereco   = endereco.getPkIdEndereco();
        this.rua            = endereco.getRua();
                       
        return "merge.xhtml";
    }
    
    public String merge() {
     
        br.data.entity.Endereco en;
        
        en = new br.data.crud.CrudEndereco().find(this.pkIdEndereco);
        en.setPkIdEndereco(pkIdEndereco);
        
        //lj.setTeste1(new CrudTeste1().find(this.codTeste1));
        Exception e = new br.data.crud.CrudEndereco().merge(en);
        
        if (e == null) {
            
            this.setBairro("");
            this.setCep("");
            this.setCidade("");
            this.setComplemento("");
            this.setEstado("");
            this.setNumero("");
            //this.setPkIdEndereco();
            this.setRua("");
             
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
        
        br.data.entity.Endereco en;
        en = new br.data.entity.Endereco();
        //tes.setCodigo(codigo);
        //tes.setNome(nome);
        //tes.setTeste1(new CrudTeste1().find(this.getCodTeste1()));
        Exception insert = new br.data.crud.CrudEndereco().persist(en);
        
        if (insert == null) {
            
            this.setBairro("");
            this.setCep("");
            this.setCidade("");
            this.setComplemento("");
            this.setEstado("");
            this.setNumero("");
            //this.setPkIdEndereco();
            this.setRua("");
            
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
