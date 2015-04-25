/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.service;

import com.pfe.facade.TypecarburantService;
import com.pfe.model.Marque;
import com.pfe.model.Typecarburant;
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
@Service("typecarburantService")
public class TypecarburantServiceImpl implements TypecarburantService{

    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void save(Typecarburant tCarb) {
         sessionFactory.getCurrentSession().save(tCarb);
    }

    @Override
    public Typecarburant findById(int id) {
        return (Typecarburant) sessionFactory.getCurrentSession().get(Typecarburant.class, id);
    }

    @Override
    public List<Typecarburant> findAll() {
        return   sessionFactory.getCurrentSession().createQuery("From Typecarburant").list(); 
    }

    @Override
    public void update(Typecarburant tCarb) {
        sessionFactory.getCurrentSession().saveOrUpdate(tCarb);
    }

    @Override
    public List<Integer> generateIdTypecarburant() {
        return sessionFactory.getCurrentSession().createQuery("select max(idTypeCarburant) from Typecarburant").list();
    }
    
}
