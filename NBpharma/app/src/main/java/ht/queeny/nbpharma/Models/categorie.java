package ht.queeny.nbpharma.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by root on 8/23/18.
 */

public class categorie implements Serializable {


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



    public static ArrayList<categorie> fromListMap(List<Map> map){
            ArrayList<categorie> categories = new ArrayList();
            for(int i =0; i<map.size(); i++){
                categorie prod = categorie.fromMap(map.get(i));

                categories.add(prod);
            }
            return categories;
        }

        public static categorie fromMap(Map map) {
            categorie categorie = new categorie();

            categorie.setDescription((String) map.get("description"));
            categorie.setObjectId((String) map.get("objectId"));


            return categorie;
        }
}
