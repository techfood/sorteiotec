/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.crud;

import br.data.entity.Cliente;
import br.data.entity.Loja;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Filipe
 */
public class CrudCliente extends AbstractCrud<br.data.entity.Cliente>{

    private EntityManager em;

    public CrudCliente() {
        super(br.data.entity.Cliente.class);
    }
    
    public List<br.data.entity.Cliente> SelectByNome(String nome) {
        List<br.data.entity.Cliente> lista;
        try {
            lista= getEntityManager().createNamedQuery("Cliente.findByPkCpfCliente").setParameter("pk_cpf_cliente", "%" 
                    + nome.toUpperCase() + "%").getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    protected EntityManager getEntityManager() {
        
        if (em == null) {
            em = Persistence.createEntityManagerFactory(EMNames.EMN1, EMNames.getEMN1Props()).createEntityManager();
        }
        return em;
        
    }
    
}
