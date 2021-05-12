package com.company;

public class SpecialCustomer extends Customer {
    private final String status="Special";

    public SpecialCustomer(String name, String address) {
        super(name, address);
    }

    @Override
    public void deductDelivery(Company company){
        company.addDeliveryMoney(20);
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
