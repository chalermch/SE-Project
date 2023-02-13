package teletubies;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

import javax.xml.crypto.Data;


import teletubies.database.DatabaseHandler;
import teletubies.model.*;

public class Employee{
    private String employeeFirstName;
    private String employeeLastName;
    private String employeePassword;
    private String phoneNumber;
    private String address;
    private String employeeWorkstatus;

    private int employeelevel;
    private int employeeID;
    private int age;

    private TimestampDB timelog;

    private DatabaseHandler dbHandler;

    public Employee(){
        try {
            dbHandler = new DatabaseHandler();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Employee(int employeeID,String employeeFirstName,String employeeLastName,int age,String phoneNumber,String address){
        this.employeeID = employeeID;
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
        try {
            dbHandler = new DatabaseHandler();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Employee(int employeeid , String firstname , String lastname , String password , int age , String address, String phoneNumber, String workstatus , int employeelevel){
        this.employeeID = employeeid;
        this.employeeFirstName = firstname;
        this.employeeLastName = lastname;
        this.employeePassword = password;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.employeeWorkstatus = workstatus;
        this.employeelevel = employeelevel;
        try {
            dbHandler = new DatabaseHandler();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int logIn(int employeeID , String employeepassword){
        try {
            EmployeeDB emp = DatabaseHandler.findEmployeeById(dbHandler, employeeID);
            int empID = emp.getEmployeeID(); String empPassword = emp.getPasswordEmp();
            if (employeeID == empID && employeepassword.equalsIgnoreCase(empPassword)){
                Date nowDate = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
                timelog = new TimestampDB(employeeID,formatter.format(nowDate),null);
                return emp.getEmployeeLevel();
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void logOut(int employeeID){
        try {
            Date nowDate = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
            timelog.setDateTimeLogOut(formatter.format(nowDate));  
            DatabaseHandler.insertTimestamp(dbHandler, timelog);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    public void clearOrder(String orderID){

    }
}