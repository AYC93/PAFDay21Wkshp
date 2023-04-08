package prac.app.model;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Order {
    private int id;
    private int customerId;
    private String items;
    private double price;

    public Order(int id, int customerId, String items, double price) {
        this.id = id;
        this.items = items;
        this.price = price;
        this.customerId = customerId;
    }

    public Order() {
    }
    
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    
    public int getCustomerId() {return customerId;}
    public void setCustomerId(int customerId) {this.customerId = customerId;}
    
    public String getItems() {return items;}
    public void setItems(String items) {this.items = items;}
    
    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    @Override
    public String toString() {
        return "Order [id=" + id + ", customerId=" + customerId + ", items=" + items + ", price=" + price + "]";
    }

    public JsonObject toJson(){
        return Json.createObjectBuilder()
                .add("id", this.getId())
                .add("items", this.getItems())
                .add("price", this.getPrice())
                .add("employee_id", this.getCustomerId())
                .build();
    }


}
