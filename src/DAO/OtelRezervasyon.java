/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sefercanaydas
 */
@Entity
@Table(name = "OTEL_REZERVASYON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OtelRezervasyon.findAll", query = "SELECT o FROM OtelRezervasyon o")
    , @NamedQuery(name = "OtelRezervasyon.findById", query = "SELECT o FROM OtelRezervasyon o WHERE o.id = :id")
    , @NamedQuery(name = "OtelRezervasyon.findByTarih", query = "SELECT o FROM OtelRezervasyon o WHERE o.tarih = :tarih")
    , @NamedQuery(name = "OtelRezervasyon.findBySure", query = "SELECT o FROM OtelRezervasyon o WHERE o.sure = :sure")})
public class OtelRezervasyon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "TARIH")
    @Temporal(TemporalType.DATE)
    private Date tarih;
    @Column(name = "SURE")
    private Integer sure;
    @JoinColumn(name = "OTEL", referencedColumnName = "ID")
    @ManyToOne
    private Otel otel;

    public OtelRezervasyon() {
    }

    public OtelRezervasyon(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    public Integer getSure() {
        return sure;
    }

    public void setSure(Integer sure) {
        this.sure = sure;
    }

    public Otel getOtel() {
        return otel;
    }

    public void setOtel(Otel otel) {
        this.otel = otel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OtelRezervasyon)) {
            return false;
        }
        OtelRezervasyon other = (OtelRezervasyon) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.OtelRezervasyon[ id=" + id + " ]";
    }
    
}
