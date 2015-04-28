/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.facade;


import com.pfe.model.Utilisateur;
import java.util.List;

/**
 *
 * @author abdelmouhgit
 */
public interface UtilisateurService {
    
    public void save(Utilisateur user);
    public Utilisateur findById(int id);
    public List<Utilisateur> findAll();
    public void update(Utilisateur user);
   // public void changerEtat(Utilisateur user);   
    public List<Integer> generateIDuser();
    public void blocker(Utilisateur user);
    public void deblocker(Utilisateur user);
    public void delete(Utilisateur user);
}
