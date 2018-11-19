/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.crud;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Filipe
 */
public class CrudEndereco extends AbstractCrud<br.data.entity.Endereco> {

    private EntityManager em;
    
    public CrudEndereco() {
        super(br.data.entity.Endereco.class);
    }

    public List<br.data.entity.Endereco> SelectByNome(String nome) {
        List<br.data.entity.Endereco> lista;
        try {
            lista= getEntityManager().createNamedQuery("Endereco.findAll").setParameter("", "%" 
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
