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
@Table(name = "BONUS_PUAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BonusPuan.findAll", query = "SELECT b FROM BonusPuan b")
    , @NamedQuery(name = "BonusPuan.findByBonusId", query = "SELECT b FROM BonusPuan b WHERE b.bonusId = :bonusId")
    , @NamedQuery(name = "BonusPuan.findByBonusYuzde", query = "SELECT b FROM BonusPuan b WHERE b.bonusYuzde = :bonusYuzde")})
public class BonusPuan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BONUS_ID")
    private Integer bonusId;
    @Column(name = "BONUS_YUZDE")
    private Integer bonusYuzde;
    @JoinColumn(name = "FIRMA", referencedColumnName = "ID")
    @ManyToOne
    private UlasimFirmalar firma;

    public BonusPuan() {
    }

    public BonusPuan(Integer bonusId) {
        this.bonusId = bonusId;
    }

    public Integer getBonusId() {
        return bonusId;
    }

    public void setBonusId(Integer bonusId) {
        this.bonusId = bonusId;
    }

    public Integer getBonusYuzde() {
        return bonusYuzde;
    }

    public void setBonusYuzde(Integer bonusYuzde) {
        this.bonusYuzde = bonusYuzde;
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
        hash += (bonusId != null ? bonusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BonusPuan)) {
            return false;
        }
        BonusPuan other = (BonusPuan) object;
        if ((this.bonusId == null && other.bonusId != null) || (this.bonusId != null && !this.bonusId.equals(other.bonusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAO.BonusPuan[ bonusId=" + bonusId + " ]";
    }
    
}
