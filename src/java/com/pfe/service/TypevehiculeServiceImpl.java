/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.service;

import com.pfe.facade.TypevehiculeService;
import com.pfe.model.Typevehicule;
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
@Service("typevehiculeService")
public class TypevehiculeServiceImpl implements TypevehiculeService{

    
     @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void save(Typevehicule tVehicule) {
        sessionFactory.getCurrentSession().save(tVehicule);
    }

    @Override
    public Typevehicule findById(int id) {
     return (Typevehicule) sessionFactory.getCurrentSession().get(Typevehicule.class, id);    
    }

    @Override
    public List<Typevehicule> findAll() {
        return   sessionFactory.getCurrentSession().createQuery("From Typevehicule").list(); 
    }

    @Override
    public void update(Typevehicule tVehicule) {
        sessionFactory.getCurrentSession().saveOrUpdate(tVehicule);
    }

    @Override
    public List<Integer> generateIdTypevehicule() {
        return sessionFactory.getCurrentSession().createQuery("select max(idTypeVehicule) from Typevehicule").list();
    }
    
}
