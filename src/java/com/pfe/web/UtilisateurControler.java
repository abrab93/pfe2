/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.web;

import com.pfe.facade.UtilisateurService;
import com.pfe.model.Utilisateur;
import java.util.ArrayList;
import javax.faces.bean.SessionScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
/**
 *
 * @author abdelmouhgit
 */

@Component("utilisateurControler")
@SessionScoped
public class UtilisateurControler {

    private Utilisateur user=new Utilisateur();
    private List<Utilisateur>users=new ArrayList<Utilisateur>();
    @Autowired
    private UtilisateurService utilisateurService;
    
    
    public String save(){
        utilisateurService.save(user);
        return null;
    }
    
    @PostConstruct
    public void init(){
        users=utilisateurService.findAll();
    }
    
    public Utilisateur findById(int id){
    return utilisateurService.findById(id);
    }
    
    public List<Utilisateur> findAll(){
    return utilisateurService.findAll();
    }
    
    public void updateEtat(Utilisateur user){
//        utilisateurService.changerEtat(user);
//        utilisateurService.update(user);
//        return null;
        System.out.println("kjkjhjkbnkjj");
    }
    //************************
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }}
    //***********************
    //*************************
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Car Edited", ((Utilisateur) event.getObject()).getNomUtilisateur());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Utilisateur) event.getObject()).getNomPrenom());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    //*******************************
    public UtilisateurControler() {
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public List<Utilisateur> getUsers() {
        return users;
    }

    public void setUsers(List<Utilisateur> users) {
        this.users = users;
    }

    public UtilisateurService getUtilisateurService() {
        return utilisateurService;
    }

    public void setUtilisateurService(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }
    
    
    
}
