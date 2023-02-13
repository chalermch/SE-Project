package teletubies.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import teletubies.database.DatabaseHandler;

public class TimestampTable {

    /*
     * /เป็นการ update ค่าในตาราง
     * public static int updatetime(DatabaseHandler dbHandler, Timestamp time) {
     * String sql = "update teletubbies.time set name=?, GPA=? where FoodID=?";
     * int rowUpdated;
     * try {
     * rowUpdated = dbHandler.update(sql, time.getUsername(), time.getPassword(),
     * time.getId());
     * }
     * catch (SQLException ex ) {
     * 
     * rowUpdated = 0;
     * }
     * 
     * return rowUpdated;
     * }
     */

    // เป็นการลบค่าในตาราง
    public static int removeTimestamp(DatabaseHandler dbHandler, TimestampDB time) {
        String sql = "delete from teletubbies.Timestamp where SeqID = ? and EmployeeID = ?";

        int rowDeleted;
        try {
            rowDeleted = dbHandler.update(sql, time.getSeq(), time.getEmployeeID());
        } catch (SQLException ex) {
            rowDeleted = 0;
        }
        return rowDeleted;
    }

    // เป็นการเพิ่มค่าในตาราง
    public static int insertTimestamp(DatabaseHandler dbHandler, TimestampDB time) {
        String sql = "insert into teletubbies.Timestamp(Seq, EmployeeID, DateTimeLogIn, DateTimeLogOut)" +
                " values (?,?,?,?)";

        int rowInserted;
        try {
            rowInserted = dbHandler.update(sql, time.getSeq(), time.getEmployeeID(), time.getDateTimeLogIn(), time.getDateTimeLogOut());
            
        } catch (SQLException ex) {
            rowInserted = 0;
        }
        return rowInserted;
    }

    // การหาค่าในตารางโดยหาจากไอดี
    public static TimestampDB findtimeById(DatabaseHandler dbHandler, int seq, int empId) throws SQLException {
        String sql = "select * from teletubbies.Timestamp where Seq = ?";
        ResultSet rs;
        TimestampDB time = null;
        rs = dbHandler.query(sql, seq);
        if (rs.next()) {
            time = new TimestampDB();
            time.setSeq(rs.getInt("Seq"));
            time.setEmployeeID(rs.getInt("EmployeeID"));
            time.setDateTimeLogIn(rs.getString("DateTimeLogIn"));
            time.setDateTimeLogOut(rs.getString("DateTimeLogOut"));

        }
        return time;

    }

    // การหาค่าในตารางโดยหาชื่อที่ต้องการ
    public static ArrayList<TimestampDB> findtimeByEmployee(DatabaseHandler dbHandler, int empId) throws SQLException {
        String sql = "select * from teletubbies.Timestamp where EmployeeID = ?";
        ResultSet rs;
        ArrayList<TimestampDB> timeList = null;
        rs = dbHandler.query(sql, empId);
        timeList = extractTimestamp(rs);
        return timeList;

    }

    // การหาค่าในตารางโดยหาทั้งหมด
    public static ArrayList<TimestampDB> findAlltime(DatabaseHandler dbHandler) throws SQLException {
        String sql = "select * from teletubbies.Timestamp";
        ResultSet rs;
        ArrayList<TimestampDB> timeList = null;
        rs = dbHandler.query(sql);
        timeList = extractTimestamp(rs);
        return timeList;
    }

    // เป็นการนำค่าจาก database มาเก็บใว้ในรูปของ arraylist
    private static ArrayList<TimestampDB> extractTimestamp(ResultSet rs) {
        ArrayList<TimestampDB> timeList = new ArrayList<>();
        try {
            while (rs.next()) {
                TimestampDB time = new TimestampDB();
                try {
                    time = new TimestampDB();
                    time.setSeq(rs.getInt("Seq"));
                    time.setEmployeeID(rs.getInt("EmployeeID"));
                    time.setDateTimeLogIn(rs.getString("DateTimeLogIn"));
                    time.setDateTimeLogOut(rs.getString("DateTimeLogOut"));
                } catch (SQLException ex) {
                    Logger.getLogger(TimestampTable.class.getName()).log(Level.SEVERE, null, ex);
                }

                timeList.add(time);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TimestampTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (timeList.isEmpty()) {
            timeList = null;
        }
        return timeList;
    }
}