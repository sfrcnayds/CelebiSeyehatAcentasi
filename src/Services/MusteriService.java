/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAO.Iller;
import DAO.Musteri;
import java.math.BigInteger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author sefercanaydas
 */
public class MusteriService {
    EntityManagerFactory emf;
    EntityManager em;
    public MusteriService() {
        emf = Persistence.createEntityManagerFactory("CelebiSeyehatAcentasiPU");
        em = emf.createEntityManager();
    }
    
    public void createMusteri(Long tcNo,String musteriAdi,String musteriSoyadi,Iller il){
        Musteri yeniMusteri = new Musteri(tcNo);
        yeniMusteri.setAdi(musteriAdi);
        yeniMusteri.setSoyadi(musteriSoyadi);
        yeniMusteri.setIlNo(il);
        yeniMusteri.setHediyePuan(0);
        em.getTransaction().begin();
        em.persist(yeniMusteri);
        em.getTransaction().commit();
    }
    public Musteri getMusteriByTc(long tcNo){
        Query q = em.createNamedQuery("Musteri.findByTcNo");
        q.setParameter("tcNo", tcNo);
        try {
            Musteri m = (Musteri)q.getSingleResult();
            return m;
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public void satisYap(Musteri alicakMusteri,int tutar,int bonusYuzde,boolean puanKullandiMi){
        int bonusMiktar = (tutar * bonusYuzde+100)/100;
        em.getTransaction().begin();
        if (puanKullandiMi) {
            alicakMusteri.setHediyePuan(bonusMiktar);
        }else{
            alicakMusteri.setHediyePuan(alicakMusteri.getHediyePuan()+bonusMiktar);
        }
        em.merge(alicakMusteri);
        em.getTransaction().commit();   
    }
}
