/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sefercanaydas
 */
@Entity
@Table(name = "BILET_ODEME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BiletOdeme.findAll", query = "SELECT b FROM BiletOdeme b")
    , @NamedQuery(name = "BiletOdeme.findById", query = "SELECT b FROM BiletOdeme b WHERE b.id = :id")
    , @NamedQuery(name = "BiletOdeme.findByMusteri", query = "SELECT b FROM BiletOdeme b WHERE b.musteri = :musteri")})
public class BiletOdeme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "MUSTERI")
    private Integer musteri;
    @JoinColumn(name = "BILET", referencedColumnName = "B_ID")
    @ManyToOne
    private Bilet bilet;
    @JoinColumn(name = "ODEME_TURU", referencedColumnName = "ID")
    @ManyToOne
    private OdemeTurleri odemeTuru;

    public BiletOdeme() {
    }

    public BiletOdeme(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMusteri() {
        return musteri;
    }

    public void setMusteri(Integer musteri) {
        this.musteri = musteri;
    }

    public Bilet getBilet() {
        return bilet;
    }

    public void setBilet(Bilet bilet) {
        this.bilet = bilet;
    }

    public OdemeTurleri getOdemeTuru() {
        return odemeTuru;
    }

    public void setOdemeTuru(OdemeTurleri odemeTuru) {
        this.odemeTuru = odemeTuru;
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
        if (!(object instanceof BiletOdeme)) {
            return false;
        }
        BiletOdeme other = (BiletOdeme) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.BiletOdeme[ id=" + id + " ]";
    }
    
}
