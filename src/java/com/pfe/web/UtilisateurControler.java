/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfe.web;

import com.pfe.facade.ServiceService;
import com.pfe.facade.UtilisateurService;
import com.pfe.model.Utilisateur;
import java.util.ArrayList;
import javax.faces.bean.SessionScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import java.io.File;
import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
/**
 *
 * @author abdelmouhgit
 */

@Component("utilisateurControler")
@SessionScoped
public class UtilisateurControler {

    private Utilisateur user=new Utilisateur();
    private List<Utilisateur>users=new ArrayList<Utilisateur>();
    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
     private ServiceService serviceService;
    
    public Utilisateur clonedUser(){
        Utilisateur cloneUser=new Utilisateur();
        cloneUser.setBlocked(user.isBlocked());
        cloneUser.setEmail(user.getEmail());
        cloneUser.setNomPrenom(user.getNomPrenom());
        cloneUser.setPassWord(user.getPassWord());
        cloneUser.setService(user.getService());
        cloneUser.setNomUtilisateur(user.getNomUtilisateur());
        cloneUser.setIdUtilisateur(utilisateurService.generateIDuser().get(0));
        return cloneUser;
    }
    
    public String save(){
        utilisateurService.save(user);
        System.out.println("****** colned From user "+user);
        System.out.println("******clonedUser "+clonedUser());
        users.add(clonedUser());
        user=new Utilisateur();
        return "add";
    }
    
    @PostConstruct
    public void init(){
        users=utilisateurService.findAll();
    }
    
    public Utilisateur findById(int id){
    return utilisateurService.findById(id);
    }
    
    public List<Utilisateur> findAll(){
    return utilisateurService.findAll();
    }
    
    public String updateEtatDeblo(Utilisateur userEtat){
        int index=users.indexOf(userEtat);
        System.out.println("*********User avant l etat :"+userEtat);
        utilisateurService.deblocker(userEtat);
         System.out.println("***********User apres l etat :"+userEtat);
         utilisateurService.update(userEtat);
         users.set(index, userEtat);
      
        return "list";
    }
     public String updateEtatBlo(Utilisateur userEtat){
        int index=users.indexOf(userEtat);
        System.out.println("*********User avant l etat :"+userEtat);
        utilisateurService.blocker(userEtat);
         System.out.println("***********User apres l etat :"+userEtat);
         utilisateurService.update(userEtat);
         users.set(index, userEtat);
      
        return "list";
    }
     
     public String delete(Utilisateur user){
      utilisateurService.delete(user);
      users.remove(user);
      return "delete";
     }
    
  
  
    public int getIIndexOfUser(Utilisateur usr){
        for (int i = 0; i < users.size(); i++) {
            Utilisateur loadedUser=users.get(i);
            if(loadedUser.equals(usr))
                return i;}
        return -1;
    }
    
      int indexUser;
    public String update(Utilisateur user1){
        indexUser=users.indexOf(user1);
        user=user1;
        
    return "update";
    }
    
    public String saveChange(){
        System.out.println("***********in");
        utilisateurService.update(user);
        System.out.println("*********serivecc"+user.getService().getLibelleService());
        user.setService(serviceService.find(user.getService().getIdService()));
        users.set(indexUser, user);
        user=new Utilisateur();
        return "/Vues/Utilisateur/List.xhtml";
    }
    
    public String creatNewService(){
    return "service";
    }
//    //************************
//    public void onCellEdit(CellEditEvent event) {
//        Object oldValue = event.getOldValue();
//        Object newValue = event.getNewValue();
//         
//        if(newValue != null && !newValue.equals(oldValue)) {
//            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
//            FacesContext.getCurrentInstance().addMessage(null, msg);
//        }}
//    //***********************
//    //*************************
//    public void onRowEdit(RowEditEvent event) {
//        FacesMessage msg = new FacesMessage("Car Edited", ((Utilisateur) event.getObject()).getNomUtilisateur());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//    }
//     
//    public void onRowCancel(RowEditEvent event) {
//        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Utilisateur) event.getObject()).getNomPrenom());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//    }
//    //*******************************
    public UtilisateurControler() {
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public List<Utilisateur> getUsers() {
        return users;
    }

    public void setUsers(List<Utilisateur> users) {
        this.users = users;
    }

    public UtilisateurService getUtilisateurService() {
        return utilisateurService;
    }

    public void setUtilisateurService(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }
    
    
    public void postProcessXLS(Object document) {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow header = sheet.getRow(0);
         
        HSSFCellStyle cellStyle = wb.createCellStyle();  
        cellStyle.setFillForegroundColor(HSSFColor.GREEN.index);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
         
        for(int i=0; i < header.getPhysicalNumberOfCells();i++) {
            HSSFCell cell = header.getCell(i);
             
            cell.setCellStyle(cellStyle);
        }
    }
    
        public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
        Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A4);
 
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String logo = servletContext.getRealPath("") + File.separator + "resources" + File.separator + "images" + File.separator + "pdfs.png";
         
        pdf.add(Image.getInstance(logo));
    }
        
        public void deleteUser() {
        users.remove(user);
        user = null;
    }
}
