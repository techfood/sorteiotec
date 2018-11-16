package br.web;

import br.data.crud.CrudLoja;
import br.data.entity.Loja;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@Named(value = "jsfLoja")
@ManagedBean
@RequestScoped
public class JsfLoja {

    
    private String pkCnpjLoja;
    private String senhaLoja;
    private String nomeLoja;
    private String telefoneLoja;
    
    public JsfLoja() {
    }

    public String getPkCnpjLoja() {
        return pkCnpjLoja;
    }

    public void setPkCnpjLoja(String pkCnpjLoja) {
        this.pkCnpjLoja = pkCnpjLoja;
    }

    public String getSenhaLoja() {
        return senhaLoja;
    }

    public void setSenhaLoja(String senhaLoja) {
        this.senhaLoja = senhaLoja;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }

    public String getTelefoneLoja() {
        return telefoneLoja;
    }

    public void setTelefoneLoja(String telefoneLoja) {
        this.telefoneLoja = telefoneLoja;
    }
    
    public java.util.List<br.data.entity.Loja> getAll() {
        
        return new br.data.crud.CrudLoja().getAll();
    }
    
    public java.util.List<br.data.entity.Loja> getSelect() {
        
        if (this.nomeLoja != null && !this.nomeLoja.equals("")) {
            return new br.data.crud.CrudLoja().SelectByNome(nomeLoja);
        } else {
            return null;
        }
    }
    
    public void remove(br.data.entity.Loja loja) {
        Exception e =new br.data.crud.CrudLoja().remove(loja);
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
    
    public String update(br.data.entity.Loja loja) {
        
        this.pkCnpjLoja   = loja.getPkCnpjLoja();
        this.senhaLoja    = loja.getSenhaLoja();
        this.nomeLoja     = loja.getNomeLoja();
        this.telefoneLoja = loja.getTelefoneLoja();
                
        return "merge.xhtml";
    }
    
    public String merge() {
     
        br.data.entity.Loja lj;
        
        lj = new br.data.crud.CrudLoja().find(this.pkCnpjLoja);
        lj.setPkCnpjLoja(pkCnpjLoja);
        
        //lj.setTeste1(new CrudTeste1().find(this.codTeste1));
        Exception e = new br.data.crud.CrudLoja().merge(lj);
        
        if (e == null) {
            
            this.setPkCnpjLoja("");
            this.setSenhaLoja("");
            this.setNomeLoja("");
            this.setTelefoneLoja("");
            
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Sucesso!!", "Registro alterado com sucesso");
            FacesContext.getCurrentInstance().addMessage(null, message);

        } else {
            
            String msg = e.getMessage();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Erro!", "Informe o administrador do erro: " + msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        return "/operacoes/index.xhtml";
    }
    
    public String persist() {
        
        br.data.entity.Loja lj;
        lj = new br.data.entity.Loja();
        //tes.setCodigo(codigo);
        //tes.setNome(nome);
        //tes.setTeste1(new CrudTeste1().find(this.getCodTeste1()));
        Exception insert = new br.data.crud.CrudLoja().persist(lj);
        
        if (insert == null) {
            
            this.setPkCnpjLoja("");
            this.setSenhaLoja("");
            this.setNomeLoja("");
            this.setTelefoneLoja("");
            
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
        
        return "/operacoes/index.xhtml";
    }
}
