/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAO.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author sefercanaydas
 */
public class BiletService {
    EntityManagerFactory emf;
    EntityManager em;
    public BiletService() {
        emf = Persistence.createEntityManagerFactory("CelebiSeyehatAcentasiPU");
        em = emf.createEntityManager();
    }
    
    public List<Bilet> getBilets(UlasimFirmalar ulasimFirma,Iller cikisIl,Iller varisIl,Date tarih){
        List<Bilet> biletler = em.createNamedQuery("Bilet.findAll").getResultList();
        return biletler.stream()
                .filter(bilet -> bilet.getFirma().equals(ulasimFirma) &&
                        bilet.getCikisIl().equals(cikisIl) &&
                        bilet.getTarih().equals(tarih)&&
                        bilet.getVarisIl().equals(varisIl))
                .collect(Collectors.toList());
    }
}
