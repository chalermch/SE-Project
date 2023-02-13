package teletubies.model;

public class TimestampDB{

    private int seq;
    private int employeeid;
    private String datetimelogin;
    private String datetimelogout;

    public TimestampDB(){

    }

    public TimestampDB(int employeeid , String datetimelogout){
        this.employeeid = employeeid;
        this.datetimelogout = datetimelogout;
    }

    public TimestampDB(int employeeid , String datetimelogin , String datetimelogout){
        this.employeeid = employeeid;
        this.datetimelogin = datetimelogin;
        this.datetimelogout = datetimelogout;
    }

    public TimestampDB(int seq , int employeeid , String datetimelogin , String datetimelogout){
        this.seq = seq;
        this.employeeid = employeeid;
        this.datetimelogin = datetimelogin;
        this.datetimelogout = datetimelogout;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getEmployeeID() {
        return employeeid;
    }

    public void setEmployeeID(int employeeid) {
        this.employeeid = employeeid;
    }

    public String getDateTimeLogIn() {
        return datetimelogin;
    }

    public void setDateTimeLogIn(String datetimelogin) {
        this.datetimelogin = datetimelogin;
    }

    public String getDateTimeLogOut() {
        return datetimelogout;
    }

    public void setDateTimeLogOut(String datetimelogout) {
        this.datetimelogout = datetimelogout;
    }
}
