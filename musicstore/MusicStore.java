/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicstore;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
/**
 *
 * @author 
 */
public class MusicStore {
    /**
     * @param args the command line arguments
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
    
        //defined customers hardcoded to login with
        ArrayList<Customer> c=new ArrayList<Customer>();
        c=Customer.readfile();
 for(int j=0;j<c.size();j++)
        Store.customers.add(c.get(j));
 
        ArrayList<Instrument> i=new ArrayList<Instrument>();
        i=Instrument.readfile();
 for(int j=0;j<i.size();j++)
        Store.instruments.add(i.get(j));
        loginMenu();
        // TODO code application logic here
        
        
    }
    static void loginMenu() throws IOException{
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome!\nChoose Option:\nPress->(1)Customer\nPress->(2)Manager");
        int choice = input.nextInt();
        if(choice==1)
        {
            System.out.println("Choose\nPress->(1)SignUp\nPress->(2)LogIn");
            choice = input.nextInt();
            if(choice == 1)
            {
                System.out.println("Enter Your Details");
                System.out.print("Username: ");
                String usrname = input.next();
                System.out.print("Password: ");
                String Password = input.next();
                System.out.print("PhoneNum: ");
                String PhoneNum = input.next();
                Customer c1 = new Customer();
                c1.signUp(usrname,Password,PhoneNum);
                Store.customers.add(c1);
                Customer.filewriter(Store.customers);
                MusicStore.menu(c1);
            }
            else if(choice == 2)
            {
                System.out.println("Enter Your Username & Password");
                System.out.print("Username: ");
                String usrname = input.next();
                System.out.print("Password: ");
                String Password = input.next();
                int c = Customer.login(usrname,Password);
                if(c==0) {
                	MusicStore.loginMenu();
                }
                else {
                Customer c1=Store.customers.get(c);
                	MusicStore.menu(c1);
                }
            }
            if(choice == 1 && choice == 2)
            {
                System.out.println("Choose the instrument you want to buy:");
            }
        }
        else if(choice == 2)
        {
            System.out.println("Enter Your Username & Password");
            System.out.print("Username: ");
            String usrname = input.next();
            System.out.print("Password: ");
            String Password = input.next();
            if(Manager.login(usrname, Password)==false){
                System.out.println("Enter a valid username and password");
                	MusicStore.loginMenu();
            }
            System.out.println("Choose Option:\n1-> show reports\n3->close program");
            int ch = input.nextInt();
            if(ch == 1)
            {
                Report.showReports();
            }
            else if(ch == 2)
            {
                MusicStore.loginMenu();
            }
        }
    }
    static void menu(Customer cust) throws IOException
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Welcome to our system!\nChoose:\nPress(1)->Search for an instrument by name\nPress(2)->LogOut");
        int c = input.nextInt();
        if(c==1)
        {
            System.out.println("Type The name:");
            String n = input.next();
           cust.search(n);
        }
        else
        {
            MusicStore.loginMenu();
        }
    }
}
