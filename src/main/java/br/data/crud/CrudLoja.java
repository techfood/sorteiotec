package br.data.crud;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class CrudLoja extends AbstractCrud<br.data.entity.Loja>{

    private EntityManager em;
    
    public CrudLoja() {
        super(br.data.entity.Loja.class);
    }

    @Override
    protected EntityManager getEntityManager() {
         if (em == null) {
            em = Persistence.createEntityManagerFactory(EMNames.EMN1, EMNames.getEMN1Props()).createEntityManager();
        }
        return em;
    }
}
