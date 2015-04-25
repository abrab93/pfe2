/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.service;

import com.pfe.facade.VehiculeService;
import com.pfe.model.Utilisateur;
import com.pfe.model.Vehicule;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Youness
 */
@Transactional
@Service("vehiculeService")
public class VehiculeServiceImpl implements VehiculeService{

    
     @Autowired
    private SessionFactory sessionFactory;
    
    
    
    @Override
    public void save(Vehicule vehicule) {
        sessionFactory.getCurrentSession().save(vehicule);
    }

    @Override
    public Vehicule findById(int id) {
        return (Vehicule) sessionFactory.getCurrentSession().get(Vehicule.class, id);
    }

    @Override
    public List<Vehicule> findAll() {
       return   sessionFactory.getCurrentSession().createQuery("From Vehicule").list(); 
    }

    @Override
    public void update(Vehicule vehicule) {
        sessionFactory.getCurrentSession().saveOrUpdate(vehicule);
    }

    @Override
    public List<Integer> generateIdVehicule() {
        return sessionFactory.getCurrentSession().createQuery("select max(idVehicule) from Vehicule").list();
    }
    
     @Override
    public void delete(Vehicule vehicule) {
        sessionFactory.getCurrentSession().delete(vehicule);
    }
    
}
