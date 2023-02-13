package teletubies.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import teletubies.database.DatabaseHandler;

public class EmployeeTable {

    /*/เป็นการ update ค่าในตาราง 
    public static int updateEmployee(DatabaseHandler dbHandler, Employee emp) {
        String sql = "update teletubbies.Employee set name=?, GPA=? where EmployeeID=?";
        int rowUpdated;
        try {
            rowUpdated = dbHandler.update(sql, emp.getUsername(), emp.getPassword(), emp.getId());
        }
        catch (SQLException ex ) {
            
            rowUpdated = 0;
        }
        
        return rowUpdated;
    }
     */
    //เป็นการลบค่าในตาราง
    public static int removeEmployee(DatabaseHandler dbHandler, EmployeeDB emp) {
        String sql = "delete from teletubbies.Employee where EmployeeID = ?";

        int rowDeleted;
        try {
            rowDeleted = dbHandler.update(sql, emp.getEmployeeID());
        } catch (SQLException ex) {
            rowDeleted = 0;
        }
        return rowDeleted;
    }

    //เป็นการเพิ่มค่าในตาราง
    public static int insertEmployee(DatabaseHandler dbHandler, EmployeeDB emp) {
        String sql = "insert into teletubbies.Employee(EmployeeID, FirstName, LastName, passEmp, Age, Address, phonNumber, WorkStatus, EmployeeLevel)"
                + " values (?,?,?,?,?,?,?,?,?)";

        int rowInserted;
        try {
            rowInserted = dbHandler.update(sql, emp.getEmployeeID(), emp.getFirstName(), emp.getLastName(), emp.getPasswordEmp(), emp.getAge(), emp.getAddress(), emp.getPhoneNumber(), emp.getWorkStatus(), emp.getEmployeeLevel());
        } catch (SQLException ex) {
            rowInserted = 0;
        }
        return rowInserted;
    }

    //การหาค่าในตารางโดยหาจากไอดี
    public static EmployeeDB findEmployeeById(DatabaseHandler dbHandler, int id) throws SQLException {
        String sql = "select * from teletubbies.Employee where EmployeeID = ?";
        ResultSet rs;
        EmployeeDB emp = null;
        rs = dbHandler.query(sql, id);
        if (rs.next()) {
            emp = new EmployeeDB();
            emp.setEmployeeID(rs.getInt("EmployeeID"));
            emp.setFirstName(rs.getString("FirstName"));
            emp.setLastName(rs.getString("LastName"));
            emp.setPasswordEmp(rs.getString("passEmp"));
            emp.setAge(rs.getInt("Age"));
            emp.setAddress(rs.getString("Address"));
            emp.setPhoneNumber(rs.getString("phonNumber"));
            emp.setWorkStatus(rs.getString("WorkStatus"));
            emp.setEmployeeLevel(rs.getInt("EmployeeLevel"));
        }
        return emp;

    }

    //การหาค่าในตารางโดยหาชื่อที่ต้องการ
    public static ArrayList<EmployeeDB> findEmployeeByName(DatabaseHandler dbHandler, String name) throws SQLException {
        String sql = "select * from teletubbies.Employee where name = ?";
        ResultSet rs;
        ArrayList<EmployeeDB> empList = null;
        rs = dbHandler.query(sql, name);
        empList = extractEmployee(rs);
        return empList;

    }

    //การหาค่าในตารางโดยหาทั้งหมด
    public static ArrayList<EmployeeDB> findAllEmployee(DatabaseHandler dbHandler) throws SQLException {
        String sql = "select * from teletubbies.Employee";
        ResultSet rs;
        ArrayList<EmployeeDB> empList = null;
        rs = dbHandler.query(sql);
        empList = extractEmployee(rs);
        return empList;
    }

    //เป็นการนำค่าจาก database มาเก็บใว้ในรูปของ arraylist
    private static ArrayList<EmployeeDB> extractEmployee(ResultSet rs) {
        ArrayList<EmployeeDB> empList = new ArrayList<>();
        try {
            while (rs.next()) {
                EmployeeDB emp = new EmployeeDB();
                try {
                    emp.setEmployeeID(rs.getInt("EmployeeID"));
                    emp.setFirstName(rs.getString("FirstName"));
                    emp.setLastName(rs.getString("LastName"));
                    emp.setPasswordEmp(rs.getString("passEmp"));
                    emp.setAge(rs.getInt("Age"));
                    emp.setAddress(rs.getString("Address"));
                    emp.setPhoneNumber(rs.getString("phonNumber"));
                    emp.setWorkStatus(rs.getString("WorkStatus"));
                    emp.setEmployeeLevel(rs.getInt("EmployeeLevel"));
                } catch (SQLException ex) {
                    Logger.getLogger(EmployeeTable.class.getName()).log(Level.SEVERE, null, ex);
                }

                empList.add(emp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (empList.isEmpty()) {
            empList = null;
        }
        return empList;
    }
}
