/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author sefercanaydas
 */
@Entity
@Table(name = "OTEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Otel.findAll", query = "SELECT o FROM Otel o")
    , @NamedQuery(name = "Otel.findById", query = "SELECT o FROM Otel o WHERE o.id = :id")
    , @NamedQuery(name = "Otel.findByIsim", query = "SELECT o FROM Otel o WHERE o.isim = :isim")})
public class Otel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ISIM")
    private String isim;
    @OneToMany(mappedBy = "otel")
    private Collection<OtelRezervasyon> otelRezervasyonCollection;
    @JoinColumn(name = "IL", referencedColumnName = "IL_NO")
    @ManyToOne
    private Iller il;

    public Otel() {
    }

    public Otel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    @XmlTransient
    public Collection<OtelRezervasyon> getOtelRezervasyonCollection() {
        return otelRezervasyonCollection;
    }

    public void setOtelRezervasyonCollection(Collection<OtelRezervasyon> otelRezervasyonCollection) {
        this.otelRezervasyonCollection = otelRezervasyonCollection;
    }

    public Iller getIl() {
        return il;
    }

    public void setIl(Iller il) {
        this.il = il;
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
        if (!(object instanceof Otel)) {
            return false;
        }
        Otel other = (Otel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.Otel[ id=" + id + " ]";
    }
    
}
