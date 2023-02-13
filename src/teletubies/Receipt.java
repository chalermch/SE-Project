package teletubies;

public class Receipt{
private int receiptID;
private Order order;
private Payment payment;

public int createReceiptID(){
    return 0;
    //do some thing here
}
public void Receipt(Order order,Payment payment){
    this.order = order;
    this.payment= payment;
}
public void showReceipt(){
    //do some thing here
}
}