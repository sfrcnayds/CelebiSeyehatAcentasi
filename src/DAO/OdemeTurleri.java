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
@Table(name = "ODEME_TURLERI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OdemeTurleri.findAll", query = "SELECT o FROM OdemeTurleri o")
    , @NamedQuery(name = "OdemeTurleri.findById", query = "SELECT o FROM OdemeTurleri o WHERE o.id = :id")
    , @NamedQuery(name = "OdemeTurleri.findByOdemeAdi", query = "SELECT o FROM OdemeTurleri o WHERE o.odemeAdi = :odemeAdi")})
public class OdemeTurleri implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ODEME_ADI")
    private String odemeAdi;
    @OneToMany(mappedBy = "odemeTuru")
    private Collection<BiletOdeme> biletOdemeCollection;

    public OdemeTurleri() {
    }

    public OdemeTurleri(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOdemeAdi() {
        return odemeAdi;
    }

    public void setOdemeAdi(String odemeAdi) {
        this.odemeAdi = odemeAdi;
    }

    @XmlTransient
    public Collection<BiletOdeme> getBiletOdemeCollection() {
        return biletOdemeCollection;
    }

    public void setBiletOdemeCollection(Collection<BiletOdeme> biletOdemeCollection) {
        this.biletOdemeCollection = biletOdemeCollection;
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
        if (!(object instanceof OdemeTurleri)) {
            return false;
        }
        OdemeTurleri other = (OdemeTurleri) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.OdemeTurleri[ id=" + id + " ]";
    }
    
}
