/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.web;

import com.pfe.facade.MarqueService;
import com.pfe.model.Marque;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Youness
 */
@Component("marqueControler")
@RequestScoped
public class MarqueControler {

    private Marque marque=new Marque();
    private List<Marque> marques=new ArrayList<Marque>();
    
    @Autowired
    private MarqueService marqueService;
    
    private Marque coloneMarque(){
    Marque m=new  Marque();
    m.setIdMarque(marqueService.generateIdMarque().get(0));
    m.setLibelleMarque(marque.getLibelleMarque());
    return m;
    }
    
    private String save(){
    marqueService.save(marque);
    marques.add(coloneMarque());
    return null;
    }
    
    private void init(){
    marques=marqueService.findAll();
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public List<Marque> getMarques() {
        return marques;
    }

    public void setMarques(List<Marque> marques) {
        this.marques = marques;
    }

    public MarqueService getMarqueService() {
        return marqueService;
    }

    public void setMarqueService(MarqueService marqueService) {
        this.marqueService = marqueService;
    }
    
    
    public MarqueControler() {
    }
    
}
