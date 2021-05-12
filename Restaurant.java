package com.company;

import java.util.ArrayList;

public class Restaurant {
    private final String name;
    private ArrayList<Food> foodarr;
    private int rewardPoints=0;
    private final String status="Normal";
    protected int discount=0;

    public Restaurant(String name) {
        this.name = name;
        foodarr=new ArrayList<>();
    }

    public ArrayList<Food> getFoodarr() {
        return foodarr;
    }

    public void addFood(Food food) {
        foodarr.add(food);

    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public void displayfood(){
        for(int i=0;i<foodarr.size();i++){
            foodarr.get(i).display2(name);
        }
    }
    public int findfood(int foodid){
        for(int i=0;i<foodarr.size();i++){
            if(foodarr.get(i).getId()==foodid){
                return i;
            }
        }
        return 20;


    }
    public float calculatevalue(float sum){
        float a=(float)discount;
        float b=(a/100)*sum;
        float c=sum-b;
        return c;
    }
    public void addreward(float a){
        rewardPoints=rewardPoints+(int)a;
    }
    public void displayrest(){
        System.out.println(name+", Reward Points - "+rewardPoints+", Discount = "+0);
    }



}
