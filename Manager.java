/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Pc
 */
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
public class Manager extends Person{
    //constructors
    public static ArrayList<Report> reports = new ArrayList<Report>();

    public Manager(String username, String password, String phone_number) {
        super(username, password, phone_number);
    }
    
    public void addInstrument(String Name,String id, float price, String Type)
    {
        Instrument i = new Instrument(Name,id,price,Type);
        Store.instruments.add(i);
    }
    
    public static boolean login(String Name, String password) {
        boolean valid = false;//to check the availabilty of the input
        
        
            if (Store.manager.getUsername().equals(Name)&&Store.manager.getPassword().equals(password))
            {
                valid = true;
                System.out.println("Successfull");
            }
        return valid;
    }
}

