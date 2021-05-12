package com.company;

import java.util.ArrayList;

public class Customer {
    private final String name;
    protected float reward=0;
    protected float wallet=1000;
    private final String address;
    private final String status="Normal";
    private ArrayList<Order> orderlist;

    public Customer(String name, String address) {
        this.name = name;
        this.address=address;
        orderlist=new ArrayList<>();
    }

    public float getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public float getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }
    public void deductDelivery(Company company){
        company.addDeliveryMoney(40);

    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
    public void addOrder(Order order) {
        orderlist.add(order);

    }

    public ArrayList<Order> getOrderlist() {
        return orderlist;
    }

    public void setOrderlist(ArrayList<Order> orderlist) {
        this.orderlist = orderlist;
    }
    public void displayOrderlist(){
        for(int i=0;i<orderlist.size();i++){
            System.out.println(orderlist.get(i).getFood().getId()+" "+orderlist.get(i).getRestaurname()+" "+orderlist.get(i).getFood().getName()+" "+orderlist.get(i).getFood().getPrice()+" "+orderlist.get(i).getItemquantity()+" "+orderlist.get(i).getFood().getOffer()+" off");
        }
    }
    public void calculatereward(Restaurant restaurant, float sum){
        if(restaurant.getStatus().equals("Authentic")){
            int a=(int)(sum/200);
            setReward(a*25);
        }
        if(restaurant.getStatus().equals("FastFood")){
            int a=(int)(sum/150);
            setReward(a*10);
        }
        if(restaurant.getStatus().equals("Normal")){
            int a=(int)(sum/100);
            setReward(a*5);
        }
    }
    public void reducewallet(float finalmoney){
        if(wallet-finalmoney<0){
            System.out.println("Insufficient funds");
        }
        else {
            wallet = wallet - finalmoney;
        }
    }
    public void displaycust(){
        System.out.println(name+", "+address+", "+wallet+"/-");
    }




}
