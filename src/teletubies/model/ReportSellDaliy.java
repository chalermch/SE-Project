package teletubies.model;

public class ReportSellDaliy {
    private int orderid;
    private int employeeid;
    private String foodname;
    private int foodprice;
    private int quantity;
    private double totalprice;
    private String saletimestamp;
    
    public ReportSellDaliy(int orderid, int employeeid, String foodname, int foodprice, int quantity, double totalprice, String saletimestamp) {
        this.orderid = orderid;
        this.employeeid = employeeid;
        this.foodname = foodname;
        this.foodprice = foodprice;
        this.quantity = quantity;
        this.totalprice = totalprice;
        this.saletimestamp = saletimestamp;
    }

    public ReportSellDaliy() {
    }

    public int getOrderID() {
        return orderid;
    }

    public void setOrderID(int orderid) {
        this.orderid = orderid;
    }

    public int getEmployeeID() {
        return employeeid;
    }

    public void setEmployeeID(int employeeid) {
        this.employeeid = employeeid;
    }

    public String getFoodName() {
        return foodname;
    }

    public void setFoodName(String foodname) {
        this.foodname = foodname;
    }

    public int getFoodPrice() {
        return foodprice;
    }

    public void setFoodPrice(int foodprice) {
        this.foodprice = foodprice;
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

    public void setTotalPrice(double totalprice) {
        this.totalprice = totalprice;
    }

    public String getSaleTimestamp() {
        return saletimestamp;
    }

    public void setSaleTimestamp(String saletimestamp) {
        this.saletimestamp = saletimestamp;
    }
    

}