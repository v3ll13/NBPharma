package ht.queeny.nbpharma.Models;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by root on 8/22/18.
 */

public class Medicaments  {

    private categorie categorie_id; //in database
    private String forme; //in database
    private String nom;
    private String pharmacie_id;
    private String photo;
    private String posologie;
    private Date updated;
    private Date created;


    public String getForme() {
        return forme;
    }

    public String getNom() {
        return nom;
    }

    public String getPharmacieId() {
        return pharmacie_id;
    }

    public String getPhoto() {
        return photo;
    }

    public String getPosologie() {
        return posologie;
    }

    public Date getUpdated() {
        return updated;
    }

    public Date getCreated() {
        return created;
    }

    public void setForme(String forme) {
        this.forme = forme;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPharmacieId(String pharmacieId) {
        this.pharmacie_id = pharmacieId;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setPosologie(String posologie) {
        this.posologie = posologie;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public categorie getCategorieID() {
        return categorie_id;
    }

    public void setCategorieID(categorie categorieID) {
        this.categorie_id = categorieID;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    private String objectId;



}