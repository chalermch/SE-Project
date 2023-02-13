package teletubies;

public class Cashier extends Employee {
    
    public Cashier(int employeeID,String employeeFirstName,String employeeLastName,int age,String phoneNumber,String address){
        super(employeeID, employeeFirstName, employeeLastName, age, phoneNumber, address);
    }

    private void makeOrder(){
        Order.createOrder(null, null, null);
    }

    public boolean checkOrderStatus(){
        return false;
    }

}
