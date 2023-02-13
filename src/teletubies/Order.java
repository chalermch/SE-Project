package teletubies;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private int orderID;
    private boolean orderStatus = false;
    private ArrayList<String> orderFoodName;
    private ArrayList<Integer> orderQuantity;
    private ArrayList<Food> food;
    private double totalPrice;
    private String orderDate;
    
    public Order(){
        
    }
    
    public Order(int orderID,ArrayList<String> orderFoodName,ArrayList<Integer> orderQuantity,ArrayList<Food> food,double totalPrice,String orderDate){
        this.orderID = orderID;
        this.orderFoodName = orderFoodName;
        this.orderQuantity = orderQuantity;
        this.food = food;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
    }

    public void setOrderStatus() {
        this.orderStatus = true;
    }

    public static void createOrder(ArrayList<String> foodname,ArrayList<String> quantity,ArrayList<LocalDateTime> orderDate){
        
    }
    public void checkOrderStatus(){
        //do some thing here
    }
    public void notifyToChef(){
        //do some thing here
    }
    public void notifyToCustomer(){
        //do some thing here
    }
    public void notifyToCashier(String orderID){
        //do some thing here(orderID)
    }

    public int getOrderID() {
        return orderID;
    }

    public boolean getOrderStatus() {
        return orderStatus;
    }

    public ArrayList<String> getOrderFoodName() {
        return orderFoodName;
    }

    public ArrayList<Integer> getOrderQuantity() {
        return orderQuantity;
    }

    public ArrayList<Food> getFood() {
        return food;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getOrderDate() {
        return orderDate;
    }

}
