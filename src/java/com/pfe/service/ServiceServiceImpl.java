/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.service;

import com.pfe.facade.ServiceService;
import com.pfe.model.Service;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author abdelmouhgit
 */
@Transactional
@org.springframework.stereotype.Service("serviceService")
public class ServiceServiceImpl implements ServiceService{

    
    @Autowired
    private SessionFactory sessionFactory;
    
    
    @Override
    public void save(Service service) {
        sessionFactory.getCurrentSession().save(service);
    }

    @Override
    public Service find(int id) {
        return (Service) sessionFactory.getCurrentSession().get(Service.class, id);
    }

    @Override
    public List<Service> findAll() {
        return sessionFactory.getCurrentSession().createQuery("From Service").list();
    }

    @Override
    public List<Integer> generateIdServ() {
        return sessionFactory.getCurrentSession().createQuery("select max(idService) from Service").list();
    }

    @Override
    public List<Service> findByLib(String lib) {
        return  sessionFactory.getCurrentSession().createQuery("select s From Service s  where s.libelleService='"+lib+"'").list();
    }
}
    

