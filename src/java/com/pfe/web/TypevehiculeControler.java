/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.web;

import com.pfe.facade.TypevehiculeService;
import com.pfe.model.Typevehicule;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Youness
 */
@Component("typevehiculeControler")
@SessionScoped
public class TypevehiculeControler {

    private Typevehicule typevehicule=new Typevehicule();
    private List<Typevehicule> typevehicules=new ArrayList<Typevehicule>();
    
    @Autowired
    private TypevehiculeService typevehiculeService;
    
    private Typevehicule coloneTypevehicule(){
    Typevehicule t=new Typevehicule();
    t.setIdTypeVehicule(typevehiculeService.generateIdTypevehicule().get(0));
    t.setLibelleTypeVehicule(typevehicule.getLibelleTypeVehicule());
    
    return t;
    }
    
    public String save(){
        typevehiculeService.save(typevehicule);
        typevehicules.add(coloneTypevehicule());
    return null;
    }

    public Typevehicule getTypevehicule() {
        return typevehicule;
    }
    
    @PostConstruct
    private void init(){
    typevehicules=typevehiculeService.findAll();
    }

    public void setTypevehicule(Typevehicule typevehicule) {
        this.typevehicule = typevehicule;
    }

    public List<Typevehicule> getTypevehicules() {
        return typevehicules;
    }

    public void setTypevehicules(List<Typevehicule> typevehicules) {
        this.typevehicules = typevehicules;
    }

    public TypevehiculeService getTypevehiculeService() {
        return typevehiculeService;
    }

    public void setTypevehiculeService(TypevehiculeService typevehiculeService) {
        this.typevehiculeService = typevehiculeService;
    }
    
    
    public TypevehiculeControler() {
    }
    
}
