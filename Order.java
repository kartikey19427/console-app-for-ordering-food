package com.company;

import java.util.ArrayList;

public class Order {
    private Food food;
    private String Restaurname;
    private int deliverycharge;
    private int itemquantity;

    public Order(Food food,String Restaurname, int deliverycharge,int itemquantity) {
        this.Restaurname = Restaurname;
        this.deliverycharge = deliverycharge;
        this.food=food;
        this.itemquantity=itemquantity;
    }


    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getItemquantity() {
        return itemquantity;
    }

    public void setItemquantity(int itemquantity) {
        this.itemquantity = itemquantity;
    }

    public String getRestaurname() {
        return Restaurname;
    }

    public void setRestaurname(String restaurname) {
        Restaurname = restaurname;
    }

    public int getDeliverycharge() {
        return deliverycharge;
    }

    public void setDeliverycharge(int deliverycharge) {
        this.deliverycharge = deliverycharge;
    }
    public int findrestaurant(Company company){
        for(int i=0;i<company.getRestaurants().size();i++){
            if(company.getRestaurants().get(i).getName().equals(this.Restaurname)){
                return i;
            }
        }
        System.out.println(200000);
        return 20;
    }
    public void orderdisplay(){
        System.out.println(food.getId()+ " "+getRestaurname()+" "+food.getName()+" "+ food.getPrice()+" "+itemquantity+" " +food.getCategory()+" "+deliverycharge);
    }


}
