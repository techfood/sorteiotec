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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Filipe
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByPkCpfCliente", query = "SELECT c FROM Cliente c WHERE c.pkCpfCliente = :pkCpfCliente")
    , @NamedQuery(name = "Cliente.findByNomeCliente", query = "SELECT c FROM Cliente c WHERE c.nomeCliente = :nomeCliente")
    , @NamedQuery(name = "Cliente.findByTelefoneCliente", query = "SELECT c FROM Cliente c WHERE c.telefoneCliente = :telefoneCliente")
    , @NamedQuery(name = "Cliente.findByEmailCliente", query = "SELECT c FROM Cliente c WHERE c.emailCliente = :emailCliente")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_cpf_cliente")
    private Integer pkCpfCliente;
    @Size(max = 100)
    @Column(name = "nome_cliente")
    private String nomeCliente;
    @Size(max = 11)
    @Column(name = "telefone_cliente")
    private String telefoneCliente;
    @Size(max = 100)
    @Column(name = "email_cliente")
    private String emailCliente;
    @JoinColumn(name = "fk_id_endereco", referencedColumnName = "pk_id_endereco")
    @ManyToOne(optional = false)
    private Endereco fkIdEndereco;
    @JoinColumn(name = "fk_cnpj_loja", referencedColumnName = "pk_cnpj_loja")
    @ManyToOne(optional = false)
    private Loja fkCnpjLoja;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCpfCliente")
    private Collection<Cupom> cupomCollection;

    public Cliente() {
    }

    public Cliente(Integer pkCpfCliente) {
        this.pkCpfCliente = pkCpfCliente;
    }

    public Integer getPkCpfCliente() {
        return pkCpfCliente;
    }

    public void setPkCpfCliente(Integer pkCpfCliente) {
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

    @XmlTransient
    public Collection<Cupom> getCupomCollection() {
        return cupomCollection;
    }

    public void setCupomCollection(Collection<Cupom> cupomCollection) {
        this.cupomCollection = cupomCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkCpfCliente != null ? pkCpfCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.pkCpfCliente == null && other.pkCpfCliente != null) || (this.pkCpfCliente != null && !this.pkCpfCliente.equals(other.pkCpfCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.data.Cliente[ pkCpfCliente=" + pkCpfCliente + " ]";
    }
    
}
