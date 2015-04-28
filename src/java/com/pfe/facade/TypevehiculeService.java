/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.facade;


import com.pfe.model.Typevehicule;
import java.util.List;

/**
 *
 * @author Youness
 */
public interface TypevehiculeService {
    
    public void save(Typevehicule tVehicule);

    public Typevehicule findById(int id);

    public List<Typevehicule> findAll();

    public void update(Typevehicule tVehicule);
    
    public List<Integer> generateIdTypevehicule();
    
}
