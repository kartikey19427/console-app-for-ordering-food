package com.company;

import java.util.ArrayList;

public class Company {
    private float balance=0;
    private int deliveryMoney=0;
    private ArrayList<Order> orders;
    private ArrayList<Customer> customers;
    private ArrayList<Restaurant> restaurants;

    public Company(){
        orders=new ArrayList<>();
        customers=new ArrayList<>();
        restaurants=new ArrayList<>();


    }


    public float getBalance() {
        return balance;
    }

    public void addBalance(float i){
        this.balance=this.balance+i;

    }

    public int getDeliveryMoney() {
        return deliveryMoney;
    }

    public void addDeliveryMoney(int i) {
        this.deliveryMoney = this.deliveryMoney+i;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public ArrayList<Restaurant> getRestaurants() {
        return restaurants;
    }
    public void displayCustomers() {
        for(int i=0;i<customers.size();i++) {
            if (customers.get(i).getStatus().equals("Elite")) {
                System.out.println(Integer.toString(i+1) + " " + customers.get(i).getName()+" (Elite)");

            }
            else
            if (customers.get(i).getStatus().equals("Special")) {
                System.out.println(Integer.toString(i+1) + " " + customers.get(i).getName()+" (Special)");

            }
            else{
                System.out.println(Integer.toString(i+1) + " " + customers.get(i).getName());
            }
        }
    }

    public void displayRestaurants(){
        for(int i=0;i<restaurants.size();i++) {
            if (restaurants.get(i).getStatus().equals("FastFood")) {
                System.out.println(Integer.toString(i+1) + " " + restaurants.get(i).getName()+" (Fast Food)");

            }
            else
            if (restaurants.get(i).getStatus().equals("Authentic")) {
                System.out.println(Integer.toString(i+1) + " " + restaurants.get(i).getName()+" (Authentic)");

            }
            else{
                System.out.println(Integer.toString(i+1) + " " + restaurants.get(i).getName());
            }
        }
    }
    public void take1percent(float money){
        float a=money/100;
        balance=balance+a;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
    public void addOrder(Order order){
        orders.add(order);
    }
    public void compdisplay(){
        System.out.println("Total Company balance - INR "+balance+"/-");
        System.out.println("Total Delivery Charges Collected - INR "+balance+"/-");

    }
    public void displayorders(){
        for(int i=0;i<orders.size();i++){
            orders.get(i).orderdisplay();
        }
    }


}
