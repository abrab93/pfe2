/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.service;

import com.pfe.facade.MarqueService;
import com.pfe.model.Marque;
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
@Service("marqueService")
public class MarqueServiceImpl implements  MarqueService{

    @Autowired
    private SessionFactory sessionFactory;
    
    
    @Override
    public void save(Marque marque) {
       sessionFactory.getCurrentSession().save(marque);
    }

    @Override
    public Marque findById(int id) {
       return (Marque) sessionFactory.getCurrentSession().get(Marque.class, id);
    }

    @Override
    public List<Marque> findAll() {
        return   sessionFactory.getCurrentSession().createQuery("From Marque").list(); 
    }

    @Override
    public void update(Marque marque) {
       sessionFactory.getCurrentSession().saveOrUpdate(marque);
    }

    @Override
    public List<Integer> generateIdMarque() {
        return sessionFactory.getCurrentSession().createQuery("select max(idMarque) from Marque").list();
    }
    
}
