package ht.queeny.nbpharma.Models;

import java.util.Date;

public class pharmacies {

    private String adresse;
    private String email;
    private String horaire;
    private String intineraire;
    private Double map_lat;
    private Double map_long;
    private String nom;
    private String Pharmacien_responsable;
    private int status;
    private String  telephone;
    private String  objectId;
    private Date created;

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHoraire() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    public String getIntineraire() {
        return intineraire;
    }

    public void setIntineraire(String intineraire) {
        this.intineraire = intineraire;
    }

    public Double getMap_lat() {
        return map_lat;
    }

    public void setMap_lat(Double map_lat) {
        this.map_lat = map_lat;
    }

    public Double getMap_long() {
        return map_long;
    }

    public void setMap_long(Double map_long) {
        this.map_long = map_long;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPharmacien_responsable() {
        return Pharmacien_responsable;
    }

    public void setPharmacien_responsable(String pharmacien_responsable) {
        Pharmacien_responsable = pharmacien_responsable;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

}
