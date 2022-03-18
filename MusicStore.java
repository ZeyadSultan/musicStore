/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicstore;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Pc
 */
public class MusicStore {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //defined customers hardcoded to login with
        Customer customer0 = new Customer("Boodi", "12345","01010101010");
        Customer customer1 = new Customer("Mohamed", "12345","01010101010");
        Customer customer2 = new Customer("Omar", "12345","01010101010");
        Customer customer3 = new Customer("Sultan", "12345","01010101010");
        Store.customers.add(customer0);
        Store.customers.add(customer1);
        Store.customers.add(customer2);
        Store.customers.add(customer3);
        
        //adding instruments hardcoded to search and every instrument has instrument type
        Store.manager.addInstrument("guitar", "0", 100,"instrument");
        Store.manager.addInstrument("violin", "1", 120,"instrument");
        Store.manager.addInstrument("drums", "2", 140,"instrument");
        Store.manager.addInstrument("keyboard", "3", 180,"instrument");
        Store.manager.addInstrument("strings", "0", 100,"instrument part");
        Store.manager.addInstrument("symbals", "1", 100, "instrument part");
        Store.manager.addInstrument("ampilifiers", "3", 100,"instrument part");
        
        loginMenu();
        // TODO code application logic here
        
        
    }
    static void loginMenu(){
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
                MusicStore.menu(c1);
            }
            else if(choice == 2)
            {
                System.out.println("Enter Your Username & Password");
                System.out.print("Username: ");
                String usrname = input.next();
                System.out.print("Password: ");
                String Password = input.next();
                Customer c1 = Customer.login(usrname,Password);
                MusicStore.menu(c1);
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
            while(Manager.login(usrname, Password)==false){
                System.out.println("Enter a valid username and password");
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
    static void menu(Customer cust)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Welcome to our system!\nChoose:\nPress(1)->Search for an instrument by name\nPress(2)->LogOut");
        int c = input.nextInt();
        if(c==1)
        {
            System.out.println("Type The name:");
            String Name = input.next();
            cust.search(Name);
        }
        else
        {
            MusicStore.loginMenu();
        }
    }
}
