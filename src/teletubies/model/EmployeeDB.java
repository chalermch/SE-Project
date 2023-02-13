package teletubies.model;

public class EmployeeDB {
    
    private int employeeid;
    private String firstname;
    private String lastname;
    private String password;
    private int age;
    private String address;
    private String phoneNumber;
    private String workstatus;
    private int employeelevel;
    
    public EmployeeDB(){

    }

    public EmployeeDB(int employeeid , String firstname , String lastname , String password , int age , String address, String phoneNumber, String workstatus , int employeelevel){
        this.employeeid = employeeid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.workstatus = workstatus;
        this.employeelevel = employeelevel;
    }

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

    public String getPasswordEmp() {
        return password;
    }

    public void setPasswordEmp(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWorkStatus() {
        return workstatus;
    }

    public void setWorkStatus(String workstatus) {
        this.workstatus = workstatus;
    }

    public int getEmployeeLevel() {
        return employeelevel;
    }

    public void setEmployeeLevel(int employeelevel) {
        this.employeelevel = employeelevel;
    }
}
