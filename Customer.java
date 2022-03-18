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
import java.util.Scanner;
/**
 *
 * @author Pc
 */
public class Customer extends Person{
    public int recurringCounter = -1;
    public static int foundCustomer;
    Scanner input = new Scanner(System.in);
    
    public Customer()
    {

    }
    
    public Customer(String username, String password, String mob_number) {
        super(username, password, mob_number);
    }
    
    public static Customer login(String Name, String password) {
        boolean valid = false;//to check the availabilty of the input
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < Store.customers.size(); i++) {
            if (Store.customers.get(i).getUsername().equals(Name)&&Store.customers.get(i).getPassword().equals(password))
            {
                valid = true;
                foundCustomer=i;
                break;
            }
        }
        return Store.customers.get(foundCustomer);
    }
    
    public void signUp(String uname,String pass, String phoneNum){
        this.setUsername(uname);
        this.setPassword(pass);
        this.setMob_number(phoneNum);
    }
    
    public void search(String name){
        for(int i = 0; i < Store.instruments.size();i++)
        {
            if(name.equals(Store.instruments.get(i).getName()))
            {
                System.out.println("ItemFound\n");
                System.out.println("Press->(1) if you want to buy and any other letter to go back");
                int choice = input.nextInt();
                if(choice == 1)
                {
                    buy(i);
                    break;
                }
                else
                {
                    MusicStore.menu(this);
                }
            }
            
        }
    }
    public int buy(int i)
    {
        boolean insurance = false;
        recurringCounter++;
        float price = Store.instruments.get(i).getPrice();

        if(recurringCounter == 0)
        {
            System.out.println("Price: " +price );
        }
        else
        {
            price = price * 0.9f;
            System.out.println("Price: " + price );
        }
        System.out.println("item bought successfully");
        System.out.println("Do you want insurance?\n (1)->yes / (else)->No");
        int c = input.nextInt();
        if(c == 1)
        {
            insurance = true;
        }
        else
            insurance = false;
        
        Report e = new Report(this.getUsername(),Store.instruments.get(i).getName(),price,insurance,Store.instruments.get(i).getType());
        Manager.reports.add(e);
        System.out.println("Choose Option:\n1-> go back\n2-> logout\n3->close program");
        int ch = input.nextInt();
        if(ch == 1)
        {
            MusicStore.menu(this);
        }
        else if(ch == 2)
        {
            MusicStore.loginMenu();
        }
        else
        {
            return 0;
        }
        return 1;
    }
}
    



