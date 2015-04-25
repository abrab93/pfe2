/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.facade;

import com.pfe.model.Proprietairevehicule;
import java.util.List;

/**
 *
 * @author Youness
 */
public interface ProprietairevehiculeService {
    
     public void save(Proprietairevehicule prop);

    public Proprietairevehicule findById(int id);

    public List<Proprietairevehicule> findAll();

    public void update(Proprietairevehicule prop);
    
    public List<Integer> generateIdProprietairevehicule();
    
}
