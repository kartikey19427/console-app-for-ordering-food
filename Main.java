package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Company Zotato=new Company();
    static int a=0;
    static void startLogin(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to Zotato:");
        System.out.println("1) Enter as Restaurant Owner");
        System.out.println("2) Enter as Customer");
        System.out.println("3) Check User Details");
        System.out.println("4) Company Amount Details");
        System.out.println("5) Exit");
        int query=sc.nextInt();
        if(query==1){
            restaurantLogin();

        }
        else
        if(query==2){
            customerLogin();

        }
        else
        if(query==3){
            checkuserdetails();

        }
        else
        if(query==4){
            Zotato.compdisplay();

        }
        else
        if(query==5){
            a++;
        }



    }
    static void restaurantLogin(){
        Zotato.displayRestaurants();
        Scanner sc =new Scanner(System.in);
        int query=sc.nextInt();
        restSettings(query-1);

    }
    static void restSettings(int restnum){
        Zotato.getRestaurants().get(restnum);
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome " +Zotato.getRestaurants().get(restnum).getName());
        System.out.println("1) Add item");
        System.out.println("2) Edit item");
        System.out.println("3) Print Rewards");
        System.out.println("4) Discount on bill value");
        System.out.println("5) Exit");
        int query=sc.nextInt();
        switch (query) {
            case 1:
                addfooditem(restnum);

                break;

            case 2:
                editfooditem(restnum);

                break;

            case 3:
                printreward(restnum);
                restSettings(restnum);

                break;

            case 4:
                if(Zotato.getRestaurants().get(restnum).getStatus().equals("Authentic") || Zotato.getRestaurants().get(restnum).getStatus().equals("FastFood")) {
                    Enterdiscountvalue(restnum);
                }
                else {
                    restSettings(restnum);
                }

                break;

            case 5:
                startLogin();

                break;
        }


    }
    static void addfooditem(int restnum){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter food item details");
        System.out.println("Food name:");
        String foodname=sc.nextLine();
        System.out.println("item price:");
        int itemprice=sc.nextInt();
        System.out.println("item quantity:");
        int itemquantity=sc.nextInt();
        System.out.println("item category:");
        String category=sc.next();
        System.out.println("Offer:");
        float offer=sc.nextFloat();
        Food food=new Food(foodname,itemquantity,itemprice,category,offer);
        Zotato.getRestaurants().get(restnum).addFood(food);
        food.display();
        restSettings(restnum);



    }
    static void editfooditem(int restnum){
        System.out.println("Choose item by code");
        Zotato.getRestaurants().get(restnum).displayfood();
        Scanner sc=new Scanner(System.in);
        int foodid=sc.nextInt();
        int arrindex=Zotato.getRestaurants().get(restnum).findfood(foodid);
        changeFoodAttribute(arrindex, restnum);


    }
    static void changeFoodAttribute(int arrindex, int restnum){
        System.out.println("Choose an attribute to edit:");
        System.out.println("1) Name");
        System.out.println("2) Price");
        System.out.println("3) Quantity");
        System.out.println("4) Category");
        System.out.println("5) Offer");
        Scanner sc=new Scanner(System.in);
        int query=sc.nextInt();
        switch (query) {
            case 1:
                System.out.print("Enter new name - ");
                String name=sc.nextLine();
                Zotato.getRestaurants().get(restnum).getFoodarr().get(arrindex).setName(name);
                Zotato.getRestaurants().get(restnum).getFoodarr().get(arrindex).display2(Zotato.getRestaurants().get(restnum).getName());
                restSettings(restnum);
                break;

            case 2:
                System.out.print("Enter the new price - ");
                int price=sc.nextInt();
                Zotato.getRestaurants().get(restnum).getFoodarr().get(arrindex).setPrice(price);
                Zotato.getRestaurants().get(restnum).getFoodarr().get(arrindex).display2(Zotato.getRestaurants().get(restnum).getName());
                restSettings(restnum);

                break;

            case 3:
                System.out.print("Enter the new quantity - ");
                int quantity=sc.nextInt();
                Zotato.getRestaurants().get(restnum).getFoodarr().get(arrindex).setQuantity(quantity);
                Zotato.getRestaurants().get(restnum).getFoodarr().get(arrindex).display2(Zotato.getRestaurants().get(restnum).getName());
                restSettings(restnum);

                break;

            case 4:
                System.out.print("Enter new category - ");
                String category=sc.next();
                Zotato.getRestaurants().get(restnum).getFoodarr().get(arrindex).setCategory(category);
                Zotato.getRestaurants().get(restnum).getFoodarr().get(arrindex).display2(Zotato.getRestaurants().get(restnum).getName());
                restSettings(restnum);

                break;

            case 5:
                System.out.print("Enter new offer - ");
                float offer=sc.nextFloat();
                Zotato.getRestaurants().get(restnum).getFoodarr().get(arrindex).setOffer(offer);
                Zotato.getRestaurants().get(restnum).getFoodarr().get(arrindex).display2(Zotato.getRestaurants().get(restnum).getName());
                restSettings(restnum);

                break;
        }


    }
    static void printreward(int restnum){
        System.out.println("Reward Points: "+Zotato.getRestaurants().get(restnum).getRewardPoints());

    }
    static  void Enterdiscountvalue(int restnum){
        Scanner sc=new Scanner(System.in);
        System.out.print("Offer on bill value: ");
        int discountvalue=sc.nextInt();
        Zotato.getRestaurants().get(restnum).setDiscount(discountvalue);
        restSettings(restnum);



    }
    static void customerLogin(){
        Zotato.displayCustomers();
        Scanner sc =new Scanner(System.in);
        int query=sc.nextInt();
        custSettings(query-1);

    }
    static void custSettings(int custnum){
        Zotato.getCustomers().get(custnum);
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome " +Zotato.getCustomers().get(custnum).getName());
        System.out.println("1) Select Restaurant");
        System.out.println("2) Checkout cart");
        System.out.println("3) Reward won");
        System.out.println("4) Print the recent orders");
        System.out.println("5) Exit");
        int query=sc.nextInt();

        switch (query) {
            case 1:
                Chooserestaurant(custnum);
                break;

            case 2:
                checkout(custnum);


                break;

            case 3:
                System.out.println("Rewards won - "+Zotato.getCustomers().get(custnum).getReward());


                break;

            case 4:
                Zotato.displayorders();


                break;

            case 5:
                startLogin();

                break;
        }


    }
    static void Chooserestaurant(int custnum){
        System.out.println("Choose Restaurant");
        Zotato.displayRestaurants();
        Scanner sc =new Scanner(System.in);
        int query=sc.nextInt();
        itemselect(custnum, query-1);


    }

    static void itemselect(int custnum, int restnum){
        System.out.println("Choose item by code");
        Zotato.getRestaurants().get(restnum).displayfood();
        Scanner sc=new Scanner(System.in);
        int foodid=sc.nextInt();
        int arrindex=Zotato.getRestaurants().get(restnum).findfood(foodid);
        System.out.println("Enter item quantity - ");
        int itemquatity=sc.nextInt();
        ArrayList<Order> oder=Zotato.getCustomers().get(custnum).getOrderlist();
        if(Zotato.getCustomers().get(custnum).getStatus().equals("Normal")) {
            if(oder.size()==0){
                Zotato.getCustomers().get(custnum).addOrder(new Order(Zotato.getRestaurants().get(restnum).getFoodarr().get(arrindex), Zotato.getRestaurants().get(restnum).getName(), 40, itemquatity));

            }else {
                for (int i = 0; i < Zotato.getCustomers().get(custnum).getOrderlist().size(); i++) {
                    if (oder.get(i).getFood().getId() == foodid) {
                        oder.get(i).setItemquantity(oder.get(i).getItemquantity() + itemquatity);
                        break;
                    } else if (i == oder.size() - 1 && oder.get(i).getFood().getId() != foodid) {
                        Zotato.getCustomers().get(custnum).addOrder(new Order(Zotato.getRestaurants().get(restnum).getFoodarr().get(arrindex), Zotato.getRestaurants().get(restnum).getName(), 40, itemquatity));

                    }

                }
            }

        }
        else
        if(Zotato.getCustomers().get(custnum).getStatus().equals("Elite")) {
            if (oder.size() == 0) {
                Zotato.getCustomers().get(custnum).addOrder(new Order(Zotato.getRestaurants().get(restnum).getFoodarr().get(arrindex), Zotato.getRestaurants().get(restnum).getName(), 0, itemquatity));

            } else{
                for (int i = 0; i < Zotato.getCustomers().get(custnum).getOrderlist().size(); i++) {
                    if (oder.get(i).getFood().getId() == foodid) {
                        oder.get(i).setItemquantity(oder.get(i).getItemquantity() + itemquatity);
                        break;
                    } else if (i == oder.size() - 1 && oder.get(i).getFood().getId() != foodid) {
                        Zotato.getCustomers().get(custnum).addOrder(new Order(Zotato.getRestaurants().get(restnum).getFoodarr().get(arrindex), Zotato.getRestaurants().get(restnum).getName(), 0, itemquatity));

                    }

                }
            }

        }
        else
        if(Zotato.getCustomers().get(custnum).getStatus().equals("Special")) {
            if(oder.size()==0){
                Zotato.getCustomers().get(custnum).addOrder(new Order(Zotato.getRestaurants().get(restnum).getFoodarr().get(arrindex), Zotato.getRestaurants().get(restnum).getName(), 20, itemquatity));

            }
            else {
                for (int i = 0; i < Zotato.getCustomers().get(custnum).getOrderlist().size(); i++) {
                    if (oder.get(i).getFood().getId() == foodid) {
                        oder.get(i).setItemquantity(oder.get(i).getItemquantity() + itemquatity);
                        break;
                    } else if (i == oder.size() - 1 && oder.get(i).getFood().getId() != foodid) {
                        Zotato.getCustomers().get(custnum).addOrder(new Order(Zotato.getRestaurants().get(restnum).getFoodarr().get(arrindex), Zotato.getRestaurants().get(restnum).getName(), 20, itemquatity));

                    }

                }
            }

        }
        System.out.println("Items added to cart");
        custSettings2(custnum, restnum);

    }



    static void custSettings2(int custnum, int restnum){
        Zotato.getCustomers().get(custnum);
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome " +Zotato.getCustomers().get(custnum).getName());
        System.out.println("Customer menu");
        System.out.println("1) Search item");
        System.out.println("2) Checkout cart");
        System.out.println("3) Reward won");
        System.out.println("4) Print the recent orders");
        System.out.println("5) Exit");
        int query=sc.nextInt();
        switch (query) {
            case 1:
                itemselect(custnum, restnum);
                break;

            case 2:
                checkout(custnum);
                break;

            case 3:
                System.out.println("Rewards won - "+Zotato.getCustomers().get(custnum).getReward());

                break;

            case 4:
                Zotato.displayorders();

                break;

            case 5:
                custSettings(custnum);

                break;
        }


    }
    static void checkout(int custnum){
        Scanner sc=new Scanner(System.in);
        if(Zotato.getCustomers().get(custnum).getOrderlist().size()==0){
            System.out.println("Cart empty!");
            custSettings(custnum);
        }
        else{
            System.out.println("Items in Cart - ");
            Zotato.getCustomers().get(custnum).displayOrderlist();
            int restnum=Zotato.getCustomers().get(custnum).getOrderlist().get(0).findrestaurant(Zotato);
            if(Zotato.getCustomers().get(custnum).getStatus().equals("Normal")){
                System.out.println(1);
                Customer c=Zotato.getCustomers().get(custnum);
                float sum=0;
                for(int i=0;i<c.getOrderlist().size();i++) {
                    float finprice = c.getOrderlist().get(i).getFood().itemDiscPrice(c.getOrderlist().get(i).getItemquantity());
                    sum=sum+finprice;
                }
                if(Zotato.getRestaurants().get(restnum).getStatus().equals("Authentic")){
                    float aftresDisPrice=Zotato.getRestaurants().get(restnum).calculatevalue(sum);
                    if(aftresDisPrice>100){
                        aftresDisPrice=aftresDisPrice-50;
                    }
                    float a=c.getReward();
                    aftresDisPrice=aftresDisPrice-a;
                    c.setReward(0);
                    c.deductDelivery(Zotato);
                    c.calculatereward(Zotato.getRestaurants().get(restnum),aftresDisPrice);
                    float abc=c.getReward();
                    Zotato.getRestaurants().get(restnum).addreward(abc);

                    aftresDisPrice=aftresDisPrice+40;
                    System.out.println("Delivery charge - "+ 40+"/-");
                    System.out.println("Total order value - "+ aftresDisPrice+"/-");
                    System.out.println("    Proceed to checkout");
                    int confirmation=sc.nextInt();
                    Zotato.take1percent(aftresDisPrice);
                    int totalquantity=0;
                    for(int i=0;i<c.getOrderlist().size();i++){
                        totalquantity=totalquantity+c.getOrderlist().get(i).getItemquantity();
                        Zotato.addOrder(c.getOrderlist().get(i));

                        int qunity=c.getOrderlist().get(i).getItemquantity();
                        c.getOrderlist().get(i).getFood().redquantity(qunity);
                    }
                    c.reducewallet(aftresDisPrice);
                    System.out.println(totalquantity+ " items successfully bought for INR "+aftresDisPrice+"/-");
                    c.getOrderlist().clear();





                } else
                if(Zotato.getRestaurants().get(restnum).getStatus().equals("FastFood")){
                    float aftresDisPrice=Zotato.getRestaurants().get(restnum).calculatevalue(sum);
                    float a=c.getReward();
                    aftresDisPrice=aftresDisPrice-a;
                    c.setReward(0);
                    c.deductDelivery(Zotato);
                    c.calculatereward(Zotato.getRestaurants().get(restnum),aftresDisPrice);
                    float abc=c.getReward();
                    Zotato.getRestaurants().get(restnum).addreward(abc);
                    aftresDisPrice=aftresDisPrice+40;
                    System.out.println("Delivery charge - "+ 40+"/-");
                    System.out.println("Total order value - "+ aftresDisPrice+"/-");
                    System.out.println("    Proceed to checkout");
                    int confirmation=sc.nextInt();
                    Zotato.take1percent(aftresDisPrice);
                    int totalquantity=0;
                    for(int i=0;i<c.getOrderlist().size();i++){
                        totalquantity=totalquantity+c.getOrderlist().get(i).getItemquantity();
                        Zotato.addOrder(c.getOrderlist().get(i));
                        int qunity=c.getOrderlist().get(i).getItemquantity();
                        c.getOrderlist().get(i).getFood().redquantity(qunity);
                    }
                    c.reducewallet(aftresDisPrice);
                    System.out.println(totalquantity+ " items successfully bought for INR "+aftresDisPrice+"/-");
                    c.getOrderlist().clear();





                } else
                if(Zotato.getRestaurants().get(restnum).getStatus().equals("Normal")){
                    float aftresDisPrice=Zotato.getRestaurants().get(restnum).calculatevalue(sum);
                    float a=c.getReward();
                    aftresDisPrice=aftresDisPrice-a;
                    c.setReward(0);
                    c.deductDelivery(Zotato);
                    c.calculatereward(Zotato.getRestaurants().get(restnum),aftresDisPrice);
                    float abc=c.getReward();
                    Zotato.getRestaurants().get(restnum).addreward(abc);
                    aftresDisPrice=aftresDisPrice+40;
                    System.out.println("Delivery charge - "+ 40+"/-");
                    System.out.println("Total order value - "+ aftresDisPrice+"/-");
                    System.out.println("    Proceed to checkout");
                    int confirmation=sc.nextInt();
                    Zotato.take1percent(aftresDisPrice);
                    int totalquantity=0;
                    for(int i=0;i<c.getOrderlist().size();i++){
                        totalquantity=totalquantity+c.getOrderlist().get(i).getItemquantity();
                        Zotato.addOrder(c.getOrderlist().get(i));
                        int qunity=c.getOrderlist().get(i).getItemquantity();
                        c.getOrderlist().get(i).getFood().redquantity(qunity);
                    }
                    c.reducewallet(aftresDisPrice);
                    System.out.println(totalquantity+ " items successfully bought for INR "+aftresDisPrice+"/-");
                    c.getOrderlist().clear();





                }


            } else
            if(Zotato.getCustomers().get(custnum).getStatus().equals("Elite")){
                Customer c=Zotato.getCustomers().get(custnum);
                float sum=0;
                for(int i=0;i<c.getOrderlist().size();i++) {
                    float finprice = c.getOrderlist().get(i).getFood().itemDiscPrice(c.getOrderlist().get(i).getItemquantity());
                    sum=sum+finprice;
                }
                if(Zotato.getRestaurants().get(restnum).getStatus().equals("Authentic")){
                    float aftresDisPrice=Zotato.getRestaurants().get(restnum).calculatevalue(sum);
                    if(aftresDisPrice>100){
                        aftresDisPrice=aftresDisPrice-50;
                    }
                    if(aftresDisPrice>200){
                        aftresDisPrice=aftresDisPrice-50;
                    }

                    float a=c.getReward();
                    aftresDisPrice=aftresDisPrice-a;
                    c.setReward(0);
                    c.calculatereward(Zotato.getRestaurants().get(restnum),aftresDisPrice);
                    float abc=c.getReward();
                    Zotato.getRestaurants().get(restnum).addreward(abc);
                    System.out.println("Delivery charge - "+ 0+"/-");
                    System.out.println("Total order value - "+ aftresDisPrice+"/-");
                    System.out.println("    Proceed to checkout");
                    int confirmation=sc.nextInt();
                    Zotato.take1percent(aftresDisPrice);
                    int totalquantity=0;
                    for(int i=0;i<c.getOrderlist().size();i++){
                        totalquantity=totalquantity+c.getOrderlist().get(i).getItemquantity();
                        Zotato.addOrder(c.getOrderlist().get(i));
                        int qunity=c.getOrderlist().get(i).getItemquantity();
                        c.getOrderlist().get(i).getFood().redquantity(qunity);
                    }
                    c.reducewallet(aftresDisPrice);
                    System.out.println(totalquantity+ " items successfully bought for INR "+aftresDisPrice+"/-");
                    c.getOrderlist().clear();





                } else
                if(Zotato.getRestaurants().get(restnum).getStatus().equals("FastFood")){
                    float aftresDisPrice=Zotato.getRestaurants().get(restnum).calculatevalue(sum);
                    if(aftresDisPrice>200){
                        aftresDisPrice=aftresDisPrice-50;
                    }
                    float a=c.getReward();
                    aftresDisPrice=aftresDisPrice-a;
                    c.setReward(0);
                    c.calculatereward(Zotato.getRestaurants().get(restnum),aftresDisPrice);
                    float abc=c.getReward();
                    Zotato.getRestaurants().get(restnum).addreward(abc);
                    System.out.println("Delivery charge - "+ 0+"/-");
                    System.out.println("Total order value - "+ aftresDisPrice+"/-");
                    System.out.println("    Proceed to checkout");
                    int confirmation=sc.nextInt();

                    Zotato.take1percent(aftresDisPrice);
                    int totalquantity=0;
                    for(int i=0;i<c.getOrderlist().size();i++){
                        totalquantity=totalquantity+c.getOrderlist().get(i).getItemquantity();
                        Zotato.addOrder(c.getOrderlist().get(i));
                        int qunity=c.getOrderlist().get(i).getItemquantity();
                        c.getOrderlist().get(i).getFood().redquantity(qunity);
                    }
                    c.reducewallet(aftresDisPrice);
                    System.out.println(totalquantity+ " items successfully bought for INR "+aftresDisPrice+"/-");
                    c.getOrderlist().clear();





                } else
                if(Zotato.getRestaurants().get(restnum).getStatus().equals("Normal")){
                    float aftresDisPrice=Zotato.getRestaurants().get(restnum).calculatevalue(sum);
                    if(aftresDisPrice>200){
                        aftresDisPrice=aftresDisPrice-50;
                    }
                    float a=c.getReward();
                    aftresDisPrice=aftresDisPrice-a;
                    c.setReward(0);
                    c.calculatereward(Zotato.getRestaurants().get(restnum),aftresDisPrice);
                    float abc=c.getReward();
                    Zotato.getRestaurants().get(restnum).addreward(abc);
                    System.out.println("Delivery charge - "+ 0+"/-");
                    System.out.println("Total order value - "+ aftresDisPrice+"/-");
                    System.out.println("    Proceed to checkout");
                    int confirmation=sc.nextInt();

                    Zotato.take1percent(aftresDisPrice);
                    int totalquantity=0;
                    for(int i=0;i<c.getOrderlist().size();i++){
                        totalquantity=totalquantity+c.getOrderlist().get(i).getItemquantity();
                        Zotato.addOrder(c.getOrderlist().get(i));
                        int qunity=c.getOrderlist().get(i).getItemquantity();
                        c.getOrderlist().get(i).getFood().redquantity(qunity);
                    }
                    c.reducewallet(aftresDisPrice);
                    System.out.println(totalquantity+ " items successfully bought for INR "+aftresDisPrice+"/-");
                    c.getOrderlist().clear();





                }


            } else
            if(Zotato.getCustomers().get(custnum).getStatus().equals("Special")){
                Customer c=Zotato.getCustomers().get(custnum);
                float sum=0;
                for(int i=0;i<c.getOrderlist().size();i++) {
                    float finprice = c.getOrderlist().get(i).getFood().itemDiscPrice(c.getOrderlist().get(i).getItemquantity());
                    sum=sum+finprice;
                }
                if(Zotato.getRestaurants().get(restnum).getStatus().equals("Authentic")){
                    float aftresDisPrice=Zotato.getRestaurants().get(restnum).calculatevalue(sum);
                    if(aftresDisPrice>100){
                        aftresDisPrice=aftresDisPrice-50;
                    }
                    if(aftresDisPrice>200){
                        aftresDisPrice=aftresDisPrice-25;
                    }

                    float a=c.getReward();
                    aftresDisPrice=aftresDisPrice-a;
                    c.setReward(0);
                    c.deductDelivery(Zotato);
                    c.calculatereward(Zotato.getRestaurants().get(restnum),aftresDisPrice);
                    float abc=c.getReward();
                    Zotato.getRestaurants().get(restnum).addreward(abc);
                    aftresDisPrice=aftresDisPrice+20;
                    System.out.println("Delivery charge - "+ 20+"/-");
                    System.out.println("Total order value - "+ aftresDisPrice+"/-");
                    System.out.println("    Proceed to checkout");
                    int confirmation=sc.nextInt();
                    Zotato.take1percent(aftresDisPrice);
                    int totalquantity=0;
                    for(int i=0;i<c.getOrderlist().size();i++){
                        totalquantity=totalquantity+c.getOrderlist().get(i).getItemquantity();
                        Zotato.addOrder(c.getOrderlist().get(i));
                        int qunity=c.getOrderlist().get(i).getItemquantity();
                        c.getOrderlist().get(i).getFood().redquantity(qunity);
                    }
                    c.reducewallet(aftresDisPrice);
                    System.out.println(totalquantity+ " items successfully bought for INR "+aftresDisPrice+"/-");
                    c.getOrderlist().clear();





                } else
                if(Zotato.getRestaurants().get(restnum).getStatus().equals("FastFood")){
                    float aftresDisPrice=Zotato.getRestaurants().get(restnum).calculatevalue(sum);
                    if(aftresDisPrice>200){
                        aftresDisPrice=aftresDisPrice-25;
                    }
                    float a=c.getReward();
                    aftresDisPrice=aftresDisPrice-a;
                    c.setReward(0);
                    c.deductDelivery(Zotato);
                    c.calculatereward(Zotato.getRestaurants().get(restnum),aftresDisPrice);
                    float abc=c.getReward();
                    Zotato.getRestaurants().get(restnum).addreward(abc);
                    aftresDisPrice=aftresDisPrice+20;
                    System.out.println("Delivery charge - "+ 20+"/-");
                    System.out.println("Total order value - "+ aftresDisPrice+"/-");
                    System.out.println("    Proceed to checkout");
                    int confirmation=sc.nextInt();

                    Zotato.take1percent(aftresDisPrice);
                    int totalquantity=0;
                    for(int i=0;i<c.getOrderlist().size();i++){
                        totalquantity=totalquantity+c.getOrderlist().get(i).getItemquantity();
                        Zotato.addOrder(c.getOrderlist().get(i));
                        int qunity=c.getOrderlist().get(i).getItemquantity();
                        c.getOrderlist().get(i).getFood().redquantity(qunity);
                    }
                    c.reducewallet(aftresDisPrice);
                    System.out.println(totalquantity+ " items successfully bought for INR "+aftresDisPrice+"/-");
                    c.getOrderlist().clear();





                } else
                if(Zotato.getRestaurants().get(restnum).getStatus().equals("Normal")){
                    float aftresDisPrice=Zotato.getRestaurants().get(restnum).calculatevalue(sum);
                    if(aftresDisPrice>200){
                        aftresDisPrice=aftresDisPrice-25;
                    }
                    float a=c.getReward();
                    aftresDisPrice=aftresDisPrice-a;
                    c.setReward(0);
                    c.deductDelivery(Zotato);
                    c.calculatereward(Zotato.getRestaurants().get(restnum),aftresDisPrice);
                    float abc=c.getReward();
                    Zotato.getRestaurants().get(restnum).addreward(abc);
                    aftresDisPrice=aftresDisPrice+20;
                    System.out.println("Delivery charge - "+ 20+"/-");
                    System.out.println("Total order value - "+ aftresDisPrice+"/-");
                    System.out.println("    Proceed to checkout");
                    int confirmation=sc.nextInt();

                    Zotato.take1percent(aftresDisPrice);
                    int totalquantity=0;
                    for(int i=0;i<c.getOrderlist().size();i++){
                        totalquantity=totalquantity+c.getOrderlist().get(i).getItemquantity();
                        Zotato.addOrder(c.getOrderlist().get(i));
                        int qunity=c.getOrderlist().get(i).getItemquantity();
                        c.getOrderlist().get(i).getFood().redquantity(qunity);
                    }
                    c.reducewallet(aftresDisPrice);
                    System.out.println(totalquantity+ " items successfully bought for INR "+aftresDisPrice+"/-");
                    c.getOrderlist().clear();





                }


            }


        }

    }
    static void checkuserdetails(){
        System.out.println("1) Customer List");
        System.out.println("2) Restaurant List");
        Scanner sc=new Scanner(System.in);
        int query=sc.nextInt();
        if(query==1){
            Zotato.displayCustomers();
            int query2=sc.nextInt();
            displaydetailc(query2-1);


        }
        else
            if(query==2){
                Zotato.displayRestaurants();
                int query2=sc.nextInt();
                displaydetailr(query2-1);

        }
    }
    static void displaydetailc(int custnum){
        Zotato.getCustomers().get(custnum).displaycust();


    }
    static void displaydetailr(int restnum){
        Zotato.getRestaurants().get(restnum).displayrest();

    }








    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Zotato.getCustomers().add(new EliteCustomer("Ram","Kolkata"));
        Zotato.getCustomers().add(new EliteCustomer("Sam","Pune"));
        Zotato.getCustomers().add(new SpecialCustomer("Tim","Noida"));
        Zotato.getCustomers().add(new Customer("Kim","Delhi"));
        Zotato.getCustomers().add(new Customer("Jim","Faridabad"));

        Zotato.getRestaurants().add(new Authentic("Shah"));
        Zotato.getRestaurants().add(new Restaurant("Ravi's"));
        Zotato.getRestaurants().add(new Authentic("The Chinese"));
        Zotato.getRestaurants().add(new FastFood("Wang's"));
        Zotato.getRestaurants().add(new Restaurant("Paradise"));

        while(a<1){
            startLogin();
        }




	// write your code here
    }
}
