/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.service;

import com.pfe.facade.ServiceService;
import com.pfe.facade.UtilisateurService;
import com.pfe.model.Utilisateur;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author abdelmouhgit
 */
@Transactional
@Service("utilisateurService")
public class UtilisateurServiceImpl implements UtilisateurService{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Autowired
    private ServiceService serviceService;
    
    @Override
    public void save(Utilisateur user) {
        System.out.println("********d5éélt");
        com.pfe.model.Service service=  serviceService.find(user.getService().getIdService());
        System.out.println("********daazt find");
        if(service!=null)
            System.out.println("***********haa service"+service);
            user.setService(service);
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public Utilisateur findById(int id) {
       return (Utilisateur) sessionFactory.getCurrentSession().get(Utilisateur.class, id);
    }

    @Override
    public List<Utilisateur> findAll() {
        return sessionFactory.getCurrentSession().createQuery("From Utilisateur").list();
    }

    @Override
    public void update(Utilisateur user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public void changerEtat(Utilisateur user) {
        if(user.isBlocked()){
            user.setBlocked(false);
        }
        if(!user.isBlocked()){
            user.setBlocked(true);
        }
    }
    
}
