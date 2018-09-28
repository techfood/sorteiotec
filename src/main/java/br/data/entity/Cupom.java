/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Filipe
 */
@Entity
@Table(name = "cupom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cupom.findAll", query = "SELECT c FROM Cupom c")
    , @NamedQuery(name = "Cupom.findByPkIdCupom", query = "SELECT c FROM Cupom c WHERE c.pkIdCupom = :pkIdCupom")})
public class Cupom implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_cupom")
    private Integer pkIdCupom;
    @JoinColumn(name = "fk_cpf_cliente", referencedColumnName = "pk_cpf_cliente")
    @ManyToOne(optional = false)
    private Cliente fkCpfCliente;
    @JoinColumn(name = "fk_cnpj_loja", referencedColumnName = "pk_cnpj_loja")
    @ManyToOne(optional = false)
    private Loja fkCnpjLoja;
    @JoinColumn(name = "fk_id_sorteio", referencedColumnName = "pk_id_sorteio")
    @ManyToOne(optional = false)
    private Sorteio fkIdSorteio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdCupomPrimeiro")
    private Collection<ResultadoSorteio> resultadoSorteioCollection;
    @OneToMany(mappedBy = "fkIdCupomSegundo")
    private Collection<ResultadoSorteio> resultadoSorteioCollection1;
    @OneToMany(mappedBy = "fkIdCupomTerceiro")
    private Collection<ResultadoSorteio> resultadoSorteioCollection2;

    public Cupom() {
    }

    public Cupom(Integer pkIdCupom) {
        this.pkIdCupom = pkIdCupom;
    }

    public Integer getPkIdCupom() {
        return pkIdCupom;
    }

    public void setPkIdCupom(Integer pkIdCupom) {
        this.pkIdCupom = pkIdCupom;
    }

    public Cliente getFkCpfCliente() {
        return fkCpfCliente;
    }

    public void setFkCpfCliente(Cliente fkCpfCliente) {
        this.fkCpfCliente = fkCpfCliente;
    }

    public Loja getFkCnpjLoja() {
        return fkCnpjLoja;
    }

    public void setFkCnpjLoja(Loja fkCnpjLoja) {
        this.fkCnpjLoja = fkCnpjLoja;
    }

    public Sorteio getFkIdSorteio() {
        return fkIdSorteio;
    }

    public void setFkIdSorteio(Sorteio fkIdSorteio) {
        this.fkIdSorteio = fkIdSorteio;
    }

    @XmlTransient
    public Collection<ResultadoSorteio> getResultadoSorteioCollection() {
        return resultadoSorteioCollection;
    }

    public void setResultadoSorteioCollection(Collection<ResultadoSorteio> resultadoSorteioCollection) {
        this.resultadoSorteioCollection = resultadoSorteioCollection;
    }

    @XmlTransient
    public Collection<ResultadoSorteio> getResultadoSorteioCollection1() {
        return resultadoSorteioCollection1;
    }

    public void setResultadoSorteioCollection1(Collection<ResultadoSorteio> resultadoSorteioCollection1) {
        this.resultadoSorteioCollection1 = resultadoSorteioCollection1;
    }

    @XmlTransient
    public Collection<ResultadoSorteio> getResultadoSorteioCollection2() {
        return resultadoSorteioCollection2;
    }

    public void setResultadoSorteioCollection2(Collection<ResultadoSorteio> resultadoSorteioCollection2) {
        this.resultadoSorteioCollection2 = resultadoSorteioCollection2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdCupom != null ? pkIdCupom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cupom)) {
            return false;
        }
        Cupom other = (Cupom) object;
        if ((this.pkIdCupom == null && other.pkIdCupom != null) || (this.pkIdCupom != null && !this.pkIdCupom.equals(other.pkIdCupom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.data.Cupom[ pkIdCupom=" + pkIdCupom + " ]";
    }
    
}
