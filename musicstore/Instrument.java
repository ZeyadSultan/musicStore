/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicstore;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Pc
 */
public class Instrument {
    String name;
    String id;
    double price;
    String Type;
    public Instrument(String name, String id, double price, String Type) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.Type = Type;
    }
static ArrayList<Instrument> readfile()throws IOException{
	ArrayList<Instrument> i=new ArrayList<Instrument>();
	Instrument i1;
	String n,d,T;
	float p;
	Scanner fileinput=new Scanner(new File("C:\\Users\\hesha\\OneDrive\\Desktop\\instruments.txt"));
while(fileinput.hasNextLine()) {
	n=fileinput.next();
	d=fileinput.next();
	T=fileinput.next();
	p=fileinput.nextFloat();
	i1=new Instrument(n,d,p,T);
	i.add(i1);
}
return i;		
}
public void setType(String Type) {
    this.Type = Type;
}
public String getType() {
    return Type;
}
public void setName(String name) {
    this.name = name;
}

public void setId(String id) {
    this.id = id;
}

public void setPrice(float price) {
    this.price = price;
}
public String getName() {
    return name;
}

public String getId() {
    return id;
}

public double getPrice() {
    return price;
}
}