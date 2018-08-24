package ht.queeny.nbpharma.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ht.queeny.nbpharma.Fragments.MedicamentContent;

/**
 * Created by root on 8/22/18.
 */

public class Medicaments implements Serializable {


    public String getForme() {
        return forme;
    }

    public String getNom() {
        return nom;
    }

    public String getPharmacieId() {
        return pharmacieId;
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
        this.pharmacieId = pharmacieId;
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

    public Categorie getCategorieID() {
        return CategorieID;
    }

    public void setCategorieID(Categorie categorieID) {
        CategorieID = categorieID;
    }

    private Categorie CategorieID; //in database
    private String forme; //in database
    private String nom;
    private String pharmacieId;
    private String photo;
    private String posologie;
    private Date updated;
    private Date created;


    public static ArrayList<Medicaments> fromListMap(List<Map> map){
        ArrayList<Medicaments> medicaments = new ArrayList();
        for(int i =0; i<map.size(); i++){
           // Medicaments medoc = Medicaments.fromMap(map.get(i));
            Medicaments medoc = Medicaments.fromMap(map.get(i));

            medicaments.add(medoc);
        }
        return medicaments;
    }

    public static Medicaments fromMap(Map map) {
        Medicaments medicament = new Medicaments();

        medicament.setCategorieID((Categorie) map.get("categorieId"));
        if(map.get("categoID") != null){
            medicament.setCategorieID(Categorie.fromMap((HashMap) map.get("categoID")));
        }

        medicament.setCreated((Date) map.get("created"));
        medicament.setForme((String) map.get("forme"));
        medicament.setNom((String) map.get("nom"));
        medicament.setPhoto((String) map.get("photo"));
        medicament.setPharmacieId((String) map.get("pharacie"));
        medicament.setPosologie((String) map.get("posologie"));
        medicament.setUpdated((Date) map.get("updated"));




        return medicament;
    }

}