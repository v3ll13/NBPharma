package ht.queeny.nbpharma.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Register implements Serializable {

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getUserName() {
        return userName;
    }

    public String getCreated() {
        return created;
    }

    public String getUpdated() {
        return Updated;
    }

    private String confirmationPassword;
    private String email;
    private String password;
    private String telephone;
    private String userName;
    private String created;
    private String Updated;

    public void setConfirmationPassword(String confirmationPassword) {
        this.confirmationPassword = confirmationPassword;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setUpdated(String updated) {
        Updated = updated;
    }


    public static ArrayList<Register> fromListMap(List<Map> map) {
        ArrayList<Register> registers = new ArrayList();
        for (int i = 0; i < map.size(); i++) {
            Register regist = Register.fromMap(map.get(i));

            registers.add(regist);
        }
        return registers;
    }

    public static Register fromMap(Map map) {
        Register register = new Register();

        register.setEmail((String) map.get("Email"));
        register.setUserName((String) map.get("UserName"));


        return register;

    }
}