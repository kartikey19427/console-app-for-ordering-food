package com.company;

public class EliteCustomer extends Customer {
    private String status="Elite";


    public EliteCustomer(String name, String address) {
        super(name, address);
    }

    @Override
    public String getStatus() {
        return status;
    }
    @Override
    public void displaycust(){
        System.out.println(this.getName()+"("+status+")"+", "+this.getAddress()+", "+wallet+"/-");
    }
}
