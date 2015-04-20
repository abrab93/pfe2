/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.facade;

import com.pfe.model.Service;
import java.util.List;

/**
 *
 * @author abdelmouhgit
 */
public interface ServiceService {
 
    public void save(Service service);
    public Service find(int id);
    public List<Service> findAll();
}
