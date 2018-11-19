package br.data.crud;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class CrudLoja extends AbstractCrud<br.data.entity.Loja>{

    private EntityManager em;
    
    public CrudLoja() {
        super(br.data.entity.Loja.class);
    }

    public List<br.data.entity.Loja> SelectByNome(String nome) {
        List<br.data.entity.Loja> lista;
        try {
            lista= getEntityManager().createNamedQuery("Loja.findByPkCnpjLoja").setParameter("pk_cnpj_loja", "%" 
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
