package ht.queeny.nbpharma.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by root on 8/22/18.
 */

public class Medicaments implements Serializable {

    private String nomMedicament; //in database
    private String dateExpi; //in database
    private String imageEndroit;


    public String getNomMedicament() {
        return nomMedicament;
    }

    public String getDateExpi() {
        return dateExpi;
    }

    public String getImageEndroit() {
        return imageEndroit;
    }

    public void setNomMedicament(String nomMedicament) {
        this.nomMedicament = nomMedicament;
    }

    public void setDateExpi(String dateExpi) {
        this.dateExpi = dateExpi;
    }

    public void setImageMedicament(String imageMedicament) {
        this.imageEndroit = imageEndroit;
    }


    public static ArrayList<Medicaments> fromListMap(List<Map> map) {

        ArrayList<Medicaments> medicament = new ArrayList();

        for (int i = 0; i < map.size(); i++) {
                Medicaments medicaments = new Medicaments();
            medicaments.setNomMedicament((String) map.get(i).get("NomMedicament"));
            medicaments.setDateExpi((String) map.get(i).get("DateExpiration"));
            medicaments.setImageMedicament((String) map.get(i).get("imageExpiration"));


            medicament.add(medicaments);
        }
        return medicament;
    }

}