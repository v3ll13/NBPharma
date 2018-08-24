package ht.queeny.nbpharma.Models;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by root on 8/23/18.
 */

public class Categorie implements Serializable {


    private String description;
    private String objectId;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }



    public static ArrayList<Categorie> fromListMap(List<Map> map){
            ArrayList<Categorie> categories = new ArrayList();
            for(int i =0; i<map.size(); i++){
                Categorie prod = Categorie.fromMap(map.get(i));

                categories.add(prod);
            }
            return categories;
        }

        public static Categorie fromMap(Map map) {
            Categorie categorie = new Categorie();

            categorie.setDescription((String) map.get("description"));
            categorie.setObjectId((String) map.get("objectId"));


            return categorie;
        }
}
