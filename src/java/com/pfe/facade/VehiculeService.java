/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.facade;

import com.pfe.model.Vehicule;

import java.util.List;

/**
 *
 * @author Youness
 */
public interface VehiculeService {
    
    public void save(Vehicule vehicule);

    public Vehicule findById(int id);

    public List<Vehicule> findAll();

    public void update(Vehicule vehicule);
    
    public List<Integer> generateIdVehicule();
    
    public void delete(Vehicule vehicule);
}
