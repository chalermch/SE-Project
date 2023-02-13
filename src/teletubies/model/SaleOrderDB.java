package teletubies.model;


public class SaleOrderDB {
    private int orderid;
    private int quantity;
    private double totalprice;
    private boolean orderstatus;
    private int foodid;
    private int employeeid;
    private double cash;
    private String payMethod;
    private String timestamp;

    public SaleOrderDB(){

    }

    public SaleOrderDB(int orderid, int quantity, int totalprice, boolean orderstatus, int foodid, int employeeid , String timestamp){
        this.orderid = orderid;
        this.quantity = quantity;
        this.totalprice = totalprice;
        this.orderstatus = orderstatus;
        this.foodid = foodid;
        this.employeeid = employeeid;
        this.timestamp = timestamp;
    }

    public SaleOrderDB(int orderid, int quantity, double totalprice, boolean orderstatus, int foodid, int employeeid, double cash, String payMethod, String timestamp) {
        this.orderid = orderid;
        this.quantity = quantity;
        this.totalprice = totalprice;
        this.orderstatus = orderstatus;
        this.foodid = foodid;
        this.employeeid = employeeid;
        this.cash = cash;
        this.payMethod = payMethod;
        this.timestamp = timestamp;
    }

     
    
    public int getOrderID() {
        return orderid;
    }

    public void setOrderID(int orderid) {
        this.orderid = orderid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalprice;
    }

    public void setTotalPrice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean getOrderStatus() {
        return orderstatus;
    }

    public void setOrderStatus(boolean orderstatus) {
        this.orderstatus = orderstatus;
    }

    public int getFoodID() {
        return foodid;
    }

    public void setFoodID(int foodid) {
        this.foodid = foodid;
    }

    public int getEmployeeID() {
        return employeeid;
    }

    public void setEmployeeID(int employeeid) {
        this.employeeid = employeeid;
    }
    
    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }
    
    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }


    public String getTimestamp(){
        return timestamp;
    }

    public void setTimestamp(String timestamp){
        this.timestamp = timestamp;
    }

}
