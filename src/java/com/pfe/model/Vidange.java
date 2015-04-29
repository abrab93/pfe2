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
 * Vidange generated by hbm2java
 */
@Entity
@Table(name="vidange"
    ,catalog="gestionvehiculepfe"
    , uniqueConstraints = @UniqueConstraint(columnNames="idVehicule") 
)
public class Vidange  implements java.io.Serializable {


     private Integer idVidange;
     private Date dateVidange;
     private double kilometrage;
     private int nombreLitres;
     private String typeVehicule;
     private Vehicule vehicule;

    public Vidange() {
    }

    public Vidange(Date dateVidange, double kilometrage, int nombreLitres, String typeVehicule, Vehicule vehicule) {
       this.dateVidange = dateVidange;
       this.kilometrage = kilometrage;
       this.nombreLitres = nombreLitres;
       this.typeVehicule = typeVehicule;
       this.vehicule = vehicule;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idVidange", unique=true, nullable=false)
    public Integer getIdVidange() {
        return this.idVidange;
    }
    
    public void setIdVidange(Integer idVidange) {
        this.idVidange = idVidange;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="dateVidange", nullable=false, length=10)
    public Date getDateVidange() {
        return this.dateVidange;
    }
    
    public void setDateVidange(Date dateVidange) {
        this.dateVidange = dateVidange;
    }

    
    @Column(name="kilometrage", nullable=false, precision=22, scale=0)
    public double getKilometrage() {
        return this.kilometrage;
    }
    
    public void setKilometrage(double kilometrage) {
        this.kilometrage = kilometrage;
    }

    
    @Column(name="nombreLitres", nullable=false)
    public int getNombreLitres() {
        return this.nombreLitres;
    }
    
    public void setNombreLitres(int nombreLitres) {
        this.nombreLitres = nombreLitres;
    }

    
    @Column(name="typeVehicule", nullable=false, length=40)
    public String getTypeVehicule() {
        return this.typeVehicule;
    }
    
    public void setTypeVehicule(String typeVehicule) {
        this.typeVehicule = typeVehicule;
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


