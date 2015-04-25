/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.service;

import com.pfe.facade.ProprietairevehiculeService;
import com.pfe.model.Proprietairevehicule;
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
@Service("proprietairevehiculeService")
public class ProprietairevehiculeServiceImpl implements ProprietairevehiculeService{

      @Autowired
    private SessionFactory sessionFactory;
    
    
    @Override
    public void save(Proprietairevehicule prop) {
        sessionFactory.getCurrentSession().save(prop);
    }

    @Override
    public Proprietairevehicule findById(int id) {
        return (Proprietairevehicule) sessionFactory.getCurrentSession().get(Proprietairevehicule.class, id);
    }

    @Override
    public List<Proprietairevehicule> findAll() {
        return   sessionFactory.getCurrentSession().createQuery("From Proprietairevehicule").list(); 
    }

    @Override
    public void update(Proprietairevehicule prop) {
        sessionFactory.getCurrentSession().saveOrUpdate(prop);
    }

    @Override
    public List<Integer> generateIdProprietairevehicule() {
        return sessionFactory.getCurrentSession().createQuery("select max(idProprietaire) from Proprietairevehicule").list();
    }
    
    
}
