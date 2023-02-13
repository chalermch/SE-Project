package teletubies;

import java.util.ArrayList;

public class Payment {
    
    private Order order;
    private boolean paymentStatus = false;
    
    public Payment() {
        
    }
    
    public Payment(Order order) {
        this.order = order;
    }
    
    public Order getOrder() {
        return order;
    }

    public boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus() {
        this.paymentStatus = true;
    }

}
