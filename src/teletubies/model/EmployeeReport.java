package teletubies.model;

public class EmployeeReport {

    private int employeeid;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String address;
    private int employeelevel;
    private String dateLogIn;
    private String dateLogOut;

    public int getEmployeeID() {
        return employeeid;
    }

    public void setEmployeeID(int employeeid) {
        this.employeeid = employeeid;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getEmployeelevel() {
        return employeelevel;
    }

    public void setEmployeelevel(int employeelevel) {
        this.employeelevel = employeelevel;
    }

    public String getDateLogIn() {
        return dateLogIn;
    }

    public void setDateLogIn(String dateLogIn) {
        this.dateLogIn = dateLogIn;
    }

    public String getDateLogOut() {
        return dateLogOut;
    }

    public void setDateLogOut(String dateLogOut) {
        this.dateLogOut = dateLogOut;
    }

}
