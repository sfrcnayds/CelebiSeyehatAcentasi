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
@Table(name = "ILLER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Iller.findAll", query = "SELECT i FROM Iller i")
    , @NamedQuery(name = "Iller.findByIlNo", query = "SELECT i FROM Iller i WHERE i.ilNo = :ilNo")
    , @NamedQuery(name = "Iller.findByIsim", query = "SELECT i FROM Iller i WHERE i.isim = :isim")})
public class Iller implements Serializable {

    @OneToMany(mappedBy = "ilNo")
    private Collection<Musteri> musteriCollection;
    @OneToMany(mappedBy = "il")
    private Collection<Otel> otelCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IL_NO")
    private Integer ilNo;
    @Column(name = "ISIM")
    private String isim;
    @OneToMany(mappedBy = "cikisIl")
    private Collection<Bilet> biletCollection;
    @OneToMany(mappedBy = "varisIl")
    private Collection<Bilet> biletCollection1;

    public Iller() {
    }

    public Iller(Integer ilNo) {
        this.ilNo = ilNo;
    }

    public Integer getIlNo() {
        return ilNo;
    }

    public void setIlNo(Integer ilNo) {
        this.ilNo = ilNo;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    @XmlTransient
    public Collection<Bilet> getBiletCollection() {
        return biletCollection;
    }

    public void setBiletCollection(Collection<Bilet> biletCollection) {
        this.biletCollection = biletCollection;
    }

    @XmlTransient
    public Collection<Bilet> getBiletCollection1() {
        return biletCollection1;
    }

    public void setBiletCollection1(Collection<Bilet> biletCollection1) {
        this.biletCollection1 = biletCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ilNo != null ? ilNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Iller)) {
            return false;
        }
        Iller other = (Iller) object;
        if ((this.ilNo == null && other.ilNo != null) || (this.ilNo != null && !this.ilNo.equals(other.ilNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return isim;
    }

    @XmlTransient
    public Collection<Musteri> getMusteriCollection() {
        return musteriCollection;
    }

    public void setMusteriCollection(Collection<Musteri> musteriCollection) {
        this.musteriCollection = musteriCollection;
    }

    @XmlTransient
    public Collection<Otel> getOtelCollection() {
        return otelCollection;
    }

    public void setOtelCollection(Collection<Otel> otelCollection) {
        this.otelCollection = otelCollection;
    }
    
}
