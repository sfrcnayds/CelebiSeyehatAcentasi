/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sefercanaydas
 */
@Entity
@Table(name = "BILET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bilet.findAll", query = "SELECT b FROM Bilet b")
    , @NamedQuery(name = "Bilet.findByBId", query = "SELECT b FROM Bilet b WHERE b.bId = :bId")
    , @NamedQuery(name = "Bilet.findByTarih", query = "SELECT b FROM Bilet b WHERE b.tarih = :tarih")
    , @NamedQuery(name = "Bilet.findByFiyat", query = "SELECT b FROM Bilet b WHERE b.fiyat = :fiyat")})
public class Bilet implements Serializable {

    @OneToMany(mappedBy = "bilet")
    private Collection<BiletOdeme> biletOdemeCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "B_ID")
    private Integer bId;
    @Column(name = "TARIH")
    @Temporal(TemporalType.DATE)
    private Date tarih;
    @Column(name = "FIYAT")
    private Integer fiyat;
    @JoinColumn(name = "CIKIS_IL", referencedColumnName = "IL_NO")
    @ManyToOne
    private Iller cikisIl;
    @JoinColumn(name = "VARIS_IL", referencedColumnName = "IL_NO")
    @ManyToOne
    private Iller varisIl;
    @JoinColumn(name = "FIRMA", referencedColumnName = "ID")
    @ManyToOne
    private UlasimFirmalar firma;

    public Bilet() {
    }

    public Bilet(Integer bId) {
        this.bId = bId;
    }

    public Integer getBId() {
        return bId;
    }

    public void setBId(Integer bId) {
        this.bId = bId;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    public Integer getFiyat() {
        return fiyat;
    }

    public void setFiyat(Integer fiyat) {
        this.fiyat = fiyat;
    }

    public Iller getCikisIl() {
        return cikisIl;
    }

    public void setCikisIl(Iller cikisIl) {
        this.cikisIl = cikisIl;
    }

    public Iller getVarisIl() {
        return varisIl;
    }

    public void setVarisIl(Iller varisIl) {
        this.varisIl = varisIl;
    }

    public UlasimFirmalar getFirma() {
        return firma;
    }

    public void setFirma(UlasimFirmalar firma) {
        this.firma = firma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bId != null ? bId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bilet)) {
            return false;
        }
        Bilet other = (Bilet) object;
        if ((this.bId == null && other.bId != null) || (this.bId != null && !this.bId.equals(other.bId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return bId+"";
    }

    @XmlTransient
    public Collection<BiletOdeme> getBiletOdemeCollection() {
        return biletOdemeCollection;
    }

    public void setBiletOdemeCollection(Collection<BiletOdeme> biletOdemeCollection) {
        this.biletOdemeCollection = biletOdemeCollection;
    }
    
}
