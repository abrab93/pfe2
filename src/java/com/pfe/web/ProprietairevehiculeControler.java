/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.web;

import com.pfe.facade.ProprietairevehiculeService;
import com.pfe.model.Proprietairevehicule;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.SessionScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Youness
 */
@Component("proprietairevehiculeControler")
@SessionScoped
public class ProprietairevehiculeControler {

    private Proprietairevehicule proprietairevehicule = new Proprietairevehicule();
    private List<Proprietairevehicule> proprietairevehicules = new ArrayList<Proprietairevehicule>();

    @Autowired
    private ProprietairevehiculeService proprietairevehiculeService;

    private Proprietairevehicule clonneProprietairevehicule() {
        Proprietairevehicule p = new Proprietairevehicule();
        p.setIdProprietaire(proprietairevehiculeService.generateIdProprietairevehicule().get(0));
        p.setAdresse(proprietairevehicule.getAdresse());
        p.setCinRc(proprietairevehicule.getCinRc());
        p.setNom(proprietairevehicule.getNom());
        p.setPrenom(proprietairevehicule.getPrenom());
        return p;
    }

    private String save() {
        proprietairevehiculeService.save(proprietairevehicule);
        proprietairevehicules.add(clonneProprietairevehicule());
        return null;
    }

    private void init() {
        proprietairevehicules = proprietairevehiculeService.findAll();
    }

    public Proprietairevehicule getProprietairevehicule() {
        return proprietairevehicule;
    }

    public void setProprietairevehicule(Proprietairevehicule proprietairevehicule) {
        this.proprietairevehicule = proprietairevehicule;
    }

    public List<Proprietairevehicule> getProprietairevehicules() {
        return proprietairevehicules;
    }

    public void setProprietairevehicules(List<Proprietairevehicule> proprietairevehicules) {
        this.proprietairevehicules = proprietairevehicules;
    }

    public ProprietairevehiculeService getProprietairevehiculeService() {
        return proprietairevehiculeService;
    }

    public void setProprietairevehiculeService(ProprietairevehiculeService proprietairevehiculeService) {
        this.proprietairevehiculeService = proprietairevehiculeService;
    }

    public ProprietairevehiculeControler() {
    }

}
