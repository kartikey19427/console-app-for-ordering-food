package com.company;

public class Food {
    private String name;
    private int quantity;
    private static int idnum=0;
    private int id;
    private int price;
    private float offer;
    private String category;

    public Food(String name, int quantity, int price, String category, float offer) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
        this.offer=offer;
        idnum=idnum+1;
        this.id=idnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public float getOffer() {
        return offer;
    }

    public void setOffer(float offer) {
        this.offer = offer;
    }

    public void display(){

        System.out.println(id+" "+name+" "+price+" "+quantity+" "+offer+"% "+"off "+category);
    }

    public void display2(String restname){

        System.out.println(id+" "+restname+" - "+name+" "+price+" "+quantity+" "+offer+"% "+"off "+category);
    }
    public float itemDiscPrice(int quantity){
        float a=price*quantity;
        float discount=(offer/100)*a;
        float finalprice=a-discount;
        return finalprice;


    }
    public void redquantity(int num){
        this.quantity=quantity-num;
    }


}
