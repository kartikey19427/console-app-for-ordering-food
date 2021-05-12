package com.company;

public class Authentic extends Restaurant {
    private final String status="Authentic";



    public Authentic(String restaurName) {
        super(restaurName);
    }

    @Override
    public void setDiscount(int discount) {
        this.discount=discount;
    }

    @Override
    public String getStatus() {
        return status;
    }
    @Override
    public void displayrest(){
        System.out.println(this.getName()+"(Authentic)"+", Reward Points - "+this.getRewardPoints()+", Discount = "+discount);
    }

}
