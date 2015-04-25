/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.web;

import com.pfe.facade.TypecarburantService;
import com.pfe.model.Typecarburant;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Youness
 */
@Component("typecarburantControler")
@SessionScoped
public class TypecarburantControler {

   
    private Typecarburant typecarburant=new Typecarburant();
    private List<Typecarburant>Typecarburants=new ArrayList<Typecarburant>();
    
    @Autowired
    private TypecarburantService typecarburantService;
    
    private Typecarburant cloneTypecarburant() {
        Typecarburant t = new Typecarburant();
        t.setIdTypeCarburant(typecarburantService.generateIdTypecarburant().get(0));
        t.setLibelleTypeCarburant(typecarburant.getLibelleTypeCarburant());
        return t;
    }
    
    private String save() {
        typecarburantService.save(typecarburant);
        Typecarburants.add(cloneTypecarburant());
        return null;
    }
    
    @PostConstruct
    private void init(){
    Typecarburants=typecarburantService.findAll();
    }
    
    public TypecarburantControler() {
    }

    public Typecarburant getTypecarburant() {
        return typecarburant;
    }

    public void setTypecarburant(Typecarburant typecarburant) {
        this.typecarburant = typecarburant;
    }

    public List<Typecarburant> getTypecarburants() {
        return Typecarburants;
    }

    public void setTypecarburants(List<Typecarburant> Typecarburants) {
        this.Typecarburants = Typecarburants;
    }

    public TypecarburantService getTypecarburantService() {
        return typecarburantService;
    }

    public void setTypecarburantService(TypecarburantService typecarburantService) {
        this.typecarburantService = typecarburantService;
    }
    
    
}
