/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Filipe
 */
@Entity
@Table(name = "resultado_sorteio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResultadoSorteio.findAll", query = "SELECT r FROM ResultadoSorteio r")
    , @NamedQuery(name = "ResultadoSorteio.findByPkIdResultadoSorteio", query = "SELECT r FROM ResultadoSorteio r WHERE r.pkIdResultadoSorteio = :pkIdResultadoSorteio")})
public class ResultadoSorteio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id_resultado_sorteio")
    private Integer pkIdResultadoSorteio;
    @JoinColumn(name = "fk_id_cupom_primeiro", referencedColumnName = "pk_id_cupom")
    @ManyToOne(optional = false)
    private Cupom fkIdCupomPrimeiro;
    @JoinColumn(name = "fk_id_cupom_segundo", referencedColumnName = "pk_id_cupom")
    @ManyToOne
    private Cupom fkIdCupomSegundo;
    @JoinColumn(name = "fk_id_cupom_terceiro", referencedColumnName = "pk_id_cupom")
    @ManyToOne
    private Cupom fkIdCupomTerceiro;

    public ResultadoSorteio() {
    }

    public ResultadoSorteio(Integer pkIdResultadoSorteio) {
        this.pkIdResultadoSorteio = pkIdResultadoSorteio;
    }

    public Integer getPkIdResultadoSorteio() {
        return pkIdResultadoSorteio;
    }

    public void setPkIdResultadoSorteio(Integer pkIdResultadoSorteio) {
        this.pkIdResultadoSorteio = pkIdResultadoSorteio;
    }

    public Cupom getFkIdCupomPrimeiro() {
        return fkIdCupomPrimeiro;
    }

    public void setFkIdCupomPrimeiro(Cupom fkIdCupomPrimeiro) {
        this.fkIdCupomPrimeiro = fkIdCupomPrimeiro;
    }

    public Cupom getFkIdCupomSegundo() {
        return fkIdCupomSegundo;
    }

    public void setFkIdCupomSegundo(Cupom fkIdCupomSegundo) {
        this.fkIdCupomSegundo = fkIdCupomSegundo;
    }

    public Cupom getFkIdCupomTerceiro() {
        return fkIdCupomTerceiro;
    }

    public void setFkIdCupomTerceiro(Cupom fkIdCupomTerceiro) {
        this.fkIdCupomTerceiro = fkIdCupomTerceiro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkIdResultadoSorteio != null ? pkIdResultadoSorteio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResultadoSorteio)) {
            return false;
        }
        ResultadoSorteio other = (ResultadoSorteio) object;
        if ((this.pkIdResultadoSorteio == null && other.pkIdResultadoSorteio != null) || (this.pkIdResultadoSorteio != null && !this.pkIdResultadoSorteio.equals(other.pkIdResultadoSorteio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.data.ResultadoSorteio[ pkIdResultadoSorteio=" + pkIdResultadoSorteio + " ]";
    }
    
}
