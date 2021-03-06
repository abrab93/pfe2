package com.pfe.model;
// Generated 29 avr. 2015 00:11:25 by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Panne generated by hbm2java
 */
@Entity
@Table(name="panne"
    ,catalog="gestionvehiculepfe"
    , uniqueConstraints = {@UniqueConstraint(columnNames="idCategorie"), @UniqueConstraint(columnNames="idVehicule")} 
)
public class Panne  implements java.io.Serializable {


     private Integer idPanne;
     private Categorie categorie;
     private Date datePanne;
     private String descriptionPanne;
     private Date heurePanne;
     private String lieuPanne;
     private Vehicule vehicule;

    public Panne() {
    }

    public Panne(Categorie categorie, Date datePanne, String descriptionPanne, Date heurePanne, String lieuPanne, Vehicule vehicule) {
       this.categorie = categorie;
       this.datePanne = datePanne;
       this.descriptionPanne = descriptionPanne;
       this.heurePanne = heurePanne;
       this.lieuPanne = lieuPanne;
       this.vehicule = vehicule;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idPanne", unique=true, nullable=false)
    public Integer getIdPanne() {
        return this.idPanne;
    }
    
    public void setIdPanne(Integer idPanne) {
        this.idPanne = idPanne;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idCategorie", unique=true, nullable=false)
    public Categorie getCategorie() {
        return this.categorie;
    }
    
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="datePanne", nullable=false, length=10)
    public Date getDatePanne() {
        return this.datePanne;
    }
    
    public void setDatePanne(Date datePanne) {
        this.datePanne = datePanne;
    }

    
    @Column(name="descriptionPanne", nullable=false, length=50)
    public String getDescriptionPanne() {
        return this.descriptionPanne;
    }
    
    public void setDescriptionPanne(String descriptionPanne) {
        this.descriptionPanne = descriptionPanne;
    }

    @Temporal(TemporalType.TIME)
    @Column(name="heurePanne", nullable=false, length=8)
    public Date getHeurePanne() {
        return this.heurePanne;
    }
    
    public void setHeurePanne(Date heurePanne) {
        this.heurePanne = heurePanne;
    }

    
    @Column(name="lieuPanne", nullable=false, length=50)
    public String getLieuPanne() {
        return this.lieuPanne;
    }
    
    public void setLieuPanne(String lieuPanne) {
        this.lieuPanne = lieuPanne;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idVehicule", unique=true, nullable=false)
    public Vehicule getVehicule() {
        return this.vehicule;
    }
    
    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }




}


