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
@Table(name = "MUSTERI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Musteri.findAll", query = "SELECT m FROM Musteri m")
    , @NamedQuery(name = "Musteri.findByAdi", query = "SELECT m FROM Musteri m WHERE m.adi = :adi")
    , @NamedQuery(name = "Musteri.findBySoyadi", query = "SELECT m FROM Musteri m WHERE m.soyadi = :soyadi")
    , @NamedQuery(name = "Musteri.findByHediyePuan", query = "SELECT m FROM Musteri m WHERE m.hediyePuan = :hediyePuan")
    , @NamedQuery(name = "Musteri.findByTcNo", query = "SELECT m FROM Musteri m WHERE m.tcNo = :tcNo")})
public class Musteri implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "ADI")
    private String adi;
    @Column(name = "SOYADI")
    private String soyadi;
    @Column(name = "HEDIYE_PUAN")
    private Integer hediyePuan;
    @Id
    @Basic(optional = false)
    @Column(name = "TC_NO")
    private Long tcNo;
    @JoinColumn(name = "IL_NO", referencedColumnName = "IL_NO")
    @ManyToOne
    private Iller ilNo;

    public Musteri() {
    }

    public Musteri(Long tcNo) {
        this.tcNo = tcNo;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public Integer getHediyePuan() {
        return hediyePuan;
    }

    public void setHediyePuan(Integer hediyePuan) {
        this.hediyePuan = hediyePuan;
    }

    public Long getTcNo() {
        return tcNo;
    }

    public void setTcNo(Long tcNo) {
        this.tcNo = tcNo;
    }

    public Iller getIlNo() {
        return ilNo;
    }

    public void setIlNo(Iller ilNo) {
        this.ilNo = ilNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tcNo != null ? tcNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Musteri)) {
            return false;
        }
        Musteri other = (Musteri) object;
        if ((this.tcNo == null && other.tcNo != null) || (this.tcNo != null && !this.tcNo.equals(other.tcNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return adi+" "+soyadi;
    }
    
}
