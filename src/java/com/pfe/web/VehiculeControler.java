/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.web;

import com.pfe.facade.VehiculeService;
import com.pfe.model.Vehicule;

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
@Component("vehiculeControler")
@SessionScoped
public class VehiculeControler {

    private Vehicule  vehicule=new Vehicule();
    private List<Vehicule>vehicules=new ArrayList<Vehicule>();
    
    @Autowired
    private VehiculeService vehiculeService;
    
    private Vehicule cloneVehicule() {
        Vehicule v = new Vehicule();
        v.setIdVehicule(vehiculeService.generateIdVehicule().get(0));
        v.setDate1mc(vehicule.getDate1mc());
        v.setDate1mcmaroc(vehicule.getDate1mcmaroc());
        v.setDureDeVie(vehicule.getDureDeVie());
        v.setImmatriculation(vehicule.getImmatriculation());
        v.setKilometrageVehicule(vehicule.getKilometrageVehicule());
        v.setMarque(vehicule.getMarque());
        v.setNombreCylindres(vehicule.getNombreCylindres());
        v.setNombrePlaces(vehicule.getNombrePlaces());
        v.setNumeroChassis(vehicule.getNumeroChassis());
        v.setPoidsVide(vehicule.getPoidsVide());
        v.setProprietairevehicule(vehicule.getProprietairevehicule());
        v.setPtac(vehicule.getPtac());
        v.setPtmct(vehicule.getPtmct());
        v.setPuissanceFiscale(vehicule.getPuissanceFiscale());
        v.setRemorque(vehicule.isRemorque());
        v.setTypecarburant(vehicule.getTypecarburant());
        v.setTypevehicule(vehicule.getTypevehicule());
        v.setUsageVehicule(vehicule.getUsageVehicule());
        return v;
    }
    
    public String save(){
        vehiculeService.save(vehicule);
        vehicules.add(cloneVehicule());
    return null;
    }
    
    @PostConstruct
    public void init(){
        vehicules=vehiculeService.findAll();
    }
    
    public Vehicule findById(int id){
    return vehiculeService.findById(id);
    }
    
    public List<Vehicule> findAll(){
    return vehiculeService.findAll();
    }
    
    public String delete(Vehicule vehicule){
      vehiculeService.delete(vehicule);///ba9iii 5aasha t devloppa 
      vehicules.remove(vehicule);
      return null;
    }
    
    int indexVehicule;
    public String update(Vehicule vehicule1){
        indexVehicule=vehicules.indexOf(vehicule1);
        vehicule=vehicule1;
        
    return "updateVehicule";
    }
    
    public String saveChange(){
       
        vehiculeService.update(vehicule);//baa9i 5èès nchoof lcote tliste apres lmaj 
        
        return null;
    }
    
    
    public VehiculeControler() {
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public List<Vehicule> getVehicules() {
        return vehicules;
    }

    public void setVehicules(List<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }

    public VehiculeService getVehiculeService() {
        return vehiculeService;
    }

    public void setVehiculeService(VehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    public int getIndexVehicule() {
        return indexVehicule;
    }

    public void setIndexVehicule(int indexVehicule) {
        this.indexVehicule = indexVehicule;
    }
    
    
}
