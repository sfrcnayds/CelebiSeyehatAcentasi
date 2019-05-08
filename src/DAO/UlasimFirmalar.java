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
@Table(name = "ULASIM_FIRMALAR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UlasimFirmalar.findAll", query = "SELECT u FROM UlasimFirmalar u")
    , @NamedQuery(name = "UlasimFirmalar.findById", query = "SELECT u FROM UlasimFirmalar u WHERE u.id = :id")
    , @NamedQuery(name = "UlasimFirmalar.findByFirmaAdi", query = "SELECT u FROM UlasimFirmalar u WHERE u.firmaAdi = :firmaAdi")
    , @NamedQuery(name = "UlasimFirmalar.findByUlasimYolu", query = "SELECT u FROM UlasimFirmalar u WHERE u.ulasimYolu = :ulasimYolu")})
public class UlasimFirmalar implements Serializable {

    @OneToMany(mappedBy = "firma")
    private Collection<BonusPuan> bonusPuanCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "FIRMA_ADI")
    private String firmaAdi;
    @Column(name = "ULASIM_YOLU")
    private String ulasimYolu;
    @OneToMany(mappedBy = "firma")
    private Collection<Bilet> biletCollection;

    public UlasimFirmalar() {
    }

    public UlasimFirmalar(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirmaAdi() {
        return firmaAdi;
    }

    public void setFirmaAdi(String firmaAdi) {
        this.firmaAdi = firmaAdi;
    }

    public String getUlasimYolu() {
        return ulasimYolu;
    }

    public void setUlasimYolu(String ulasimYolu) {
        this.ulasimYolu = ulasimYolu;
    }

    @XmlTransient
    public Collection<Bilet> getBiletCollection() {
        return biletCollection;
    }

    public void setBiletCollection(Collection<Bilet> biletCollection) {
        this.biletCollection = biletCollection;
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
        if (!(object instanceof UlasimFirmalar)) {
            return false;
        }
        UlasimFirmalar other = (UlasimFirmalar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return firmaAdi;
    }

    @XmlTransient
    public Collection<BonusPuan> getBonusPuanCollection() {
        return bonusPuanCollection;
    }

    public void setBonusPuanCollection(Collection<BonusPuan> bonusPuanCollection) {
        this.bonusPuanCollection = bonusPuanCollection;
    }
    
}
