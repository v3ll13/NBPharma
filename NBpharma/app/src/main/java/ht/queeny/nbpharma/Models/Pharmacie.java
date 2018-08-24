package ht.queeny.nbpharma.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by root on 8/23/18.
 */

public class Pharmacie implements Serializable {

    private String adresse;
    private  String email;
    private String horaire;
    private String Images;
    private String Intineraire;
    private  Double map_lati;
    private  Double map_long;
    private String nom;
    private  String Pharmacien_responsable;
    private  int status;
    private String  telephone;
    private Date created;

    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public String getHoraire() {
        return horaire;
    }

    public String getImages() {
        return Images;
    }

    public String getIntineraire() {
        return Intineraire;
    }

    public Double getMap_lati() {
        return map_lati;
    }

    public Double getMap_long() {
        return map_long;
    }

    public String getNom() {
        return nom;
    }

    public String getPharmacien_responsable() {
        return Pharmacien_responsable;
    }

    public int getStatus() {
        return status;
    }

    public String getTelephone() {
        return telephone;
    }

    public Date getCreated() {
        return created;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    public void setImages(String images) {
        Images = images;
    }

    public void setIntineraire(String intineraire) {
        Intineraire = intineraire;
    }

    public void setMap_lati(Double map_lati) {
        this.map_lati = map_lati;
    }

    public void setMap_long(Double map_long) {
        this.map_long = map_long;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPharmacien_responsable(String pharmacien_responsable) {
        Pharmacien_responsable = pharmacien_responsable;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setCreated(Date created) {
        this.created = created;
    }


    public static ArrayList<Pharmacie> fromListMap(List<Map> map){
        ArrayList<Pharmacie> pharmacies = new ArrayList();
        for(int i =0; i<map.size(); i++){
           Pharmacie pharma = Pharmacie.fromMap(map.get(i));

            pharmacies.add(pharma);
        }
        return pharmacies;
    }


    public static Pharmacie fromMap(Map map) {
        Pharmacie pharmacie = new Pharmacie();

        pharmacie.setAdresse((String) map.get("adresse"));
        pharmacie.setEmail((String) map.get("email"));
        pharmacie.setHoraire((String) map.get("horaire"));
        pharmacie.setIntineraire((String) map.get("itineraire"));
        pharmacie.setMap_lati((Double) map.get("latitude"));
        pharmacie.setImages((String) map.get("image"));
        pharmacie.setPharmacien_responsable((String) map.get("responsable"));
        pharmacie.setMap_long((Double) map.get("map_longitude"));
        pharmacie.setNom((String) map.get("Nom"));

        return pharmacie;
    }
}
