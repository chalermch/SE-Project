package teletubies;

import teletubies.database.DatabaseHandler;
import teletubies.model.EmployeeDB;

public class Manager extends Employee {

    Manager() {
        super();
    }

    public void register(int employeeid, String firstname, String lastname, String password, int age, String address, String phoneNumber, String workstatus, int employeelevel) {
        try {
            DatabaseHandler.insertEmployee(new DatabaseHandler(), new EmployeeDB(employeeid, firstname, lastname, password, age, address, phoneNumber, workstatus, employeelevel));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void makeReport() {

    }
}
