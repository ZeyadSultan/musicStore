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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Pc
 */
public class Customer extends Person{
    public int recurringCounter = 0;
    public static int foundCustomer;
    Scanner input = new Scanner(System.in);
    
    public Customer()
    {

    }
    
    public Customer(String username, String password, String mob_number) {
        super(username, password, mob_number);
    }
    static ArrayList<Customer> readfile()throws IOException{
    	ArrayList<Customer> c=new ArrayList<Customer>();
    	Customer c1;
    	String n,d,T;
    	Scanner fileinput=new Scanner(new File("C:\\Users\\hesha\\OneDrive\\Desktop\\customer.txt"));
    while(fileinput.hasNextLine()) {
    	n=fileinput.next();
    	d=fileinput.next();
    	T=fileinput.nextLine();
    	c1=new Customer(n,d,T);
    	c.add(c1);
    }
    return c;		
    }

    public static int login(String Name, String password) {
        boolean valid = false;//to check the availabilty of the input
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < Store.customers.size(); i++) {
            if (Store.customers.get(i).getUsername().equals(Name)&&Store.customers.get(i).getPassword().equals(password))
            {
                valid = true;
                foundCustomer=i;
                return i;
            }
        }
        return 0; 
    }    
    public void signUp(String uname,String pass, String phoneNum) {
        this.setUsername(uname);
        this.setPassword(pass);
        this.setMob_number(phoneNum);  
    }
    public static void filewriter(ArrayList<Customer> c) throws IOException {
    	File f = new File ("C:\\Users\\hesha\\OneDrive\\Desktop\\customer.txt");
        FileWriter fw = new FileWriter(f,true);
        BufferedWriter b = new BufferedWriter(fw);
        b.write("\n");
        b.write(c.get(c.size()-1).getUsername());
        b.write(" ");
        b.write(c.get(c.size()-1).getPassword());
        b.write(" ");
        b.write(c.get(c.size()-1).getMob_number());
        b.close(); 
    }
    public void search(String name) throws IOException{
        for(int i = 0; i < Store.instruments.size();i++)
        {
            if(name.equals(Store.instruments.get(i).name))
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
                	System.out.println("not found");
                    MusicStore.menu(this);
                }
            }
            
        }
    }
    public int buy(int i) throws IOException
    {
        boolean insurance = false;
        recurringCounter++;
        double price = Store.instruments.get(i).getPrice();

        if(recurringCounter%2 == 1)
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
    
