/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package musicstore;
import java.util.ArrayList;

/**
 *
 * @author Pc
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pc
 */
public abstract class Person {
    private String username;
    private String password;
    private String mob_number;    

    //constructors
    public Person(){    
    }
    
    public Person(String username, String password, String mob_number) {
        this.username = username;
        this.password = password;
        this.mob_number = mob_number;
    }
    //setters and getters

    public String getMob_number() {
        return mob_number;
    }

    public void setMob_number(String mob_number) {
        this.mob_number = mob_number;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }      

}

