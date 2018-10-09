/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Filipe
 */
@Entity
@Table(name = "sorteio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sorteio.findAll", query = "SELECT s FROM Sorteio s")
    , @NamedQuery(name = "Sorteio.findByPkIdSorteio", query = "SELECT s FROM Sorteio s WHERE s.pkIdSorteio = :pkIdSorteio")
    , @NamedQuery(name = "Sorteio.findByTitulo", query = "SELECT s FROM Sorteio s WHERE s.titulo = :titulo")
    , @NamedQuery(name = "Sorteio.findByDescricao", query = "SELECT s FROM Sorteio s WHERE s.descricao = :descricao")
    , @NamedQuery(name = "Sorteio.findByDataInicio", query = "SELECT s FROM Sorteio s WHERE s.dataInicio = :dataInicio")
    , @NamedQuery(name = "Sorteio.findByDataFim", query = "SELECT s FROM Sorteio s WHERE s.dataFim = :dataFim")
    , @NamedQuery(name = "Sorteio.findByDiaSorteio", query = "SELECT s FROM Sorteio s WHERE s.diaSorteio = :diaSorteio")
    , @NamedQuery(name = "Sorteio.findByPremioPrimeiroSorteio", query = "SELECT s FROM Sorteio s WHERE s.premioPrimeiroSorteio = :premioPrimeiroSorteio")
    , @NamedQuery(name = "Sorteio.findByPremioSegundoSorteio", query = "SELECT s FROM Sorteio s WHERE s.premioSegundoSorteio = :premioSegundoSorteio")
    , @NamedQuery(name = "Sorteio.findByPremioTerceiroSorteio", query = "SELECT s FROM Sorteio s WHERE s.premioTerceiroSorteio = :premioTerceiroSorteio")})
public class Sorteio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_sorteio")
    private Integer pkIdSorteio;
    @Size(max = 100)
    @Column(name = "titulo")
    private String titulo;
    @Size(max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "data_inicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Column(name = "data_fim")
    @Temporal(TemporalType.DATE)
    private Date dataFim;
    @Column(name = "dia_sorteio")
    @Temporal(TemporalType.DATE)
    private Date diaSorteio;
    @Size(max = 45)
    @Column(name = "premio_primeiro_sorteio")
    private String premioPrimeiroSorteio;
    @Size(max = 45)
    @Column(name = "premio_segundo_sorteio")
    private String premioSegundoSorteio;
    @Size(max = 45)
    @Column(name = "premio_terceiro_sorteio")
    private String premioTerceiroSorteio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdSorteio")
    private Collection<Cupom> cupomCollection;
    @JoinColumn(name = "fk_cnpj_loja", referencedColumnName = "pk_cnpj_loja")
    @ManyToOne(optional = false)
    private Loja fkCnpjLoja;

    public Sorteio() {
    }

    public Sorteio(Integer pkIdSorteio) {
        this.pkIdSorteio = pkIdSorteio;
    }

    public Integer getPkIdSorteio() {
        return pkIdSorteio;
    }

    public void setPkIdSorteio(Integer pkIdSorteio) {
        this.pkIdSorteio = pkIdSorteio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Date getDiaSorteio() {
        return diaSorteio;
    }

    public void setDiaSorteio(Date diaSorteio) {
        this.diaSorteio = diaSorteio;
    }

    public String getPremioPrimeiroSorteio() {
        return premioPrimeiroSorteio;
    }

    public void setPremioPrimeiroSorteio(String premioPrimeiroSorteio) {
        this.premioPrimeiroSorteio = premioPrimeiroSorteio;
    }

    public String getPremioSegundoSorteio() {
        return premioSegundoSorteio;
    }

    public void setPremioSegundoSorteio(String premioSegundoSorteio) {
        this.premioSegundoSorteio = premioSegundoSorteio;
    }

    public String getPremioTerceiroSorteio() {
        return premioTerceiroSorteio;
    }

    public void setPremioTerceiroSorteio(String premioTerceiroSorteio) {
        this.premioTerceiroSorteio = premioTerceiroSorteio;
    }

    @XmlTransient
    public Collection<Cupom> getCupomCollection() {
        return cupomCollection;
    }

    public void setCupomCollection(Collection<Cupom> cupomCollection) {
        this.cupomCollection = cupomCollection;
    }

    public Loja getFkCnpjLoja() {
        return fkCnpjLoja;
    }

    public void setFkCnpjLoja(Loja fkCnpjLoja) {
        this.fkCnpjLoja = fkCnpjLoja;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdSorteio != null ? pkIdSorteio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sorteio)) {
            return false;
        }
        Sorteio other = (Sorteio) object;
        if ((this.pkIdSorteio == null && other.pkIdSorteio != null) || (this.pkIdSorteio != null && !this.pkIdSorteio.equals(other.pkIdSorteio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.data.Sorteio[ pkIdSorteio=" + pkIdSorteio + " ]";
    }
    
}
