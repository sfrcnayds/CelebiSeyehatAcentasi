/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAO.BonusPuan;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author sefercanaydas
 */
public class BonusPuanService {
    EntityManagerFactory emf;
    EntityManager em;
    public BonusPuanService() {
        emf = Persistence.createEntityManagerFactory("CelebiSeyehatAcentasiPU");
        em = emf.createEntityManager();
    }
    
    
    public int getBonusPuan(int firmaId){
        Query q = em.createNamedQuery("BonusPuan.findAll");
        List<BonusPuan> bonuslar = q.getResultList();
        return bonuslar.stream().filter(bonus -> bonus.getFirma().getId() == firmaId).collect(Collectors.toList()).get(0).getBonusYuzde();
    }
}
