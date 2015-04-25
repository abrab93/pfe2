/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.facade;

import com.pfe.model.Marque;
import java.util.List;

/**
 *
 * @author Youness
 */
public interface MarqueService {
    
    public void save(Marque marque);

    public Marque findById(int id);

    public List<Marque> findAll();

    public void update(Marque marque);
    
    public List<Integer> generateIdMarque();
}
