/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Filipe
 */
@Entity
@Table(name = "loja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loja.findAll", query = "SELECT l FROM Loja l")
    , @NamedQuery(name = "Loja.findByPkCnpjLoja", query = "SELECT l FROM Loja l WHERE l.pkCnpjLoja = :pkCnpjLoja")
    , @NamedQuery(name = "Loja.findBySenhaLoja", query = "SELECT l FROM Loja l WHERE l.senhaLoja = :senhaLoja")
    , @NamedQuery(name = "Loja.findByNomeLoja", query = "SELECT l FROM Loja l WHERE l.nomeLoja = :nomeLoja")
    , @NamedQuery(name = "Loja.findByTelefoneLoja", query = "SELECT l FROM Loja l WHERE l.telefoneLoja = :telefoneLoja")})
public class Loja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "pk_cnpj_loja")
    private String pkCnpjLoja;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "senha_loja")
    private String senhaLoja;
    @Size(max = 100)
    @Column(name = "nome_loja")
    private String nomeLoja;
    @Size(max = 11)
    @Column(name = "telefone_loja")
    private String telefoneLoja;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCnpjLoja")
    private Collection<Cliente> clienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCnpjLoja")
    private Collection<Cupom> cupomCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCnpjLoja")
    private Collection<Sorteio> sorteioCollection;

    public Loja() {
    }

    public Loja(String pkCnpjLoja) {
        this.pkCnpjLoja = pkCnpjLoja;
    }

    public Loja(String pkCnpjLoja, String senhaLoja) {
        this.pkCnpjLoja = pkCnpjLoja;
        this.senhaLoja = senhaLoja;
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

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @XmlTransient
    public Collection<Cupom> getCupomCollection() {
        return cupomCollection;
    }

    public void setCupomCollection(Collection<Cupom> cupomCollection) {
        this.cupomCollection = cupomCollection;
    }

    @XmlTransient
    public Collection<Sorteio> getSorteioCollection() {
        return sorteioCollection;
    }

    public void setSorteioCollection(Collection<Sorteio> sorteioCollection) {
        this.sorteioCollection = sorteioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkCnpjLoja != null ? pkCnpjLoja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loja)) {
            return false;
        }
        Loja other = (Loja) object;
        if ((this.pkCnpjLoja == null && other.pkCnpjLoja != null) || (this.pkCnpjLoja != null && !this.pkCnpjLoja.equals(other.pkCnpjLoja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.data.Loja[ pkCnpjLoja=" + pkCnpjLoja + " ]";
    }
    
}
