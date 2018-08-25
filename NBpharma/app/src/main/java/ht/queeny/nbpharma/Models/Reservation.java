package ht.queeny.nbpharma.Models;

import android.service.restrictions.RestrictionsReceiver;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by root on 8/23/18.
 */

public class Reservation  implements Serializable{

    private Medicaments Data_relation;
    private String nom_User;
    private  String  telephone;
    private Double qtite;
    private  String userReserVid;
    private  String created;
    private String updated;


    public Medicaments getData_relation() {
        return Data_relation;
    }

    public String getNom_User() {
        return nom_User;
    }

    public String getTelephone() {
        return telephone;
    }

    public Double getQtite() {
        return qtite;
    }

    public String getUserReserVid() {
        return userReserVid;
    }

    public String getCreated() {
        return created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setData_relation(Medicaments data_relation) {
        Data_relation = data_relation;
    }

    public void setNom_User(String nom_User) {
        this.nom_User = nom_User;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setQtite(Double qtite) {
        this.qtite = qtite;
    }

    public void setUserReserVid(String userReserVid) {
        this.userReserVid = userReserVid;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }






}

