package com.company;

public class FastFood extends Restaurant {
    private final String status="FastFood";
    private int discount=0;

    public FastFood(String restaurName) {
        super(restaurName);
    }

    @Override
    public void setDiscount(int discount) {
        super.setDiscount(discount);
    }

    @Override
    public String getStatus() {
        return status;
    }
    @Override
    public void displayrest(){
        System.out.println(this.getName()+"(Fast Food)"+", Reward Points - "+this.getRewardPoints()+", Discount = "+discount);
    }
}
