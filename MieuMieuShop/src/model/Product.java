package model;

import java.time.Instant;
import java.util.Comparator;

public class Product implements Comparator<Product> {
    private long id;
    private String name;
    private double price;
    private  int quantity;

    private Instant timeNow;

    private Instant timeUpdate;

    public Product(){

    }

    public Product(long id, String name, double price, int quantity ) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(long id, String name, double price, int quantity, Instant timeNow, Instant timeUpdate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.timeNow = timeNow;
        this.timeUpdate = timeUpdate;
    }

    public static Product parse(String record){
        String[] fields = record.split(",");
        long id = Long.parseLong(fields[0]);
        String name = fields[1];
        int quantity = Integer.parseInt(fields[2]);
        double price = Double.parseDouble(fields[3]);
        Instant timeNow = Instant.parse(fields[4]);
        String temp = fields[5];
        Instant timeUpdate = null;
        if (temp != null && !temp.equals("null")) timeUpdate = Instant.parse(temp);
        return new Product(id, name,price , quantity, timeNow, timeUpdate);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Instant getTimeNow() {
        return timeNow;
    }

    public void setTimeNow(Instant timeNow) {
        this.timeNow = timeNow;
    }

    public Instant getTimeUpdate() {
        return timeUpdate;
    }

    public void setTimeUpdate(Instant timeUpdate) {
        this.timeUpdate = timeUpdate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
    public int compare(Product o1 , Product o2){
        return  (int) (o1.getId()- o2.getId());
    }
}
