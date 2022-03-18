/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicstore;

/**
 *
 * @author Pc
 */
public class Report {
    String custName;
    String insName;
    double price;
    boolean insurance;
    String instType;

    public Report(String custName, String insName, double price, boolean insurance, String instType) {
        this.custName = custName;
        this.insName = insName;
        this.instType = instType;
        this.price = price;
        this.insurance = insurance;
    }
    
    public static void showReports()
    {
        for(int i=0;i<Manager.reports.size();i++)
        {
            System.out.println("Report " + i+1 + ":");
            System.out.println("Customer Name: " + Manager.reports.get(i).custName);
            System.out.println("Instrument Name: " + Manager.reports.get(i).insName);
            System.out.println("Instrument Type: " + Manager.reports.get(i).instType);
            System.out.println("Insurance: " + Manager.reports.get(i).insurance);
            System.out.println("Price: " + Manager.reports.get(i).price);
            System.out.println("___________________________________________________________________");
        }
    }
}
