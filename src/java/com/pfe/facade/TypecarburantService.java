/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.facade;


import com.pfe.model.Typecarburant;
import java.util.List;

/**
 *
 * @author Youness
 */
public interface TypecarburantService {
    
    public void save(Typecarburant tCarb);

    public Typecarburant findById(int id);

    public List<Typecarburant> findAll();

    public void update(Typecarburant tCarb);
    
    public List<Integer> generateIdTypecarburant();
}
