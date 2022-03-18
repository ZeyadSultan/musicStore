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
public class Instrument {
    private String name;
    private String id;
    private float price;
    private String Type;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public float getPrice() {
        return price;
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
    
    public Instrument(String name, String id, float price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getType() {
        return Type;
    }

    public Instrument(String name, String id, float price, String Type) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.Type = Type;
    }
    
    
}
