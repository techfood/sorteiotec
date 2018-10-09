package br.web;

import br.data.crud.CrudLoja;
import br.data.entity.Loja;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "jsfLoja")
@RequestScoped
public class JsfLoja {

    
    CrudLoja crudLoja = new CrudLoja();
    
    public JsfLoja() {
    }
    
    public List<Loja> getAll() {
        return crudLoja.getAll();
    }
}
