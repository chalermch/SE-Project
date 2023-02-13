package teletubies.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import teletubies.model.*;

public class DatabaseHandler {

    private Connection connection = null;
    private String url = "jdbc:mysql://localhost:3306/teletubbies";
    private String user = "root";
    private String password = "root";

    //เชื่อมกับฐานข้อมูล
    public DatabaseHandler() throws ClassNotFoundException, SQLException {
        connection = DriverManager.getConnection(url, user, password);
        if (connection != null) {
            System.out.println("Connected");
        } else {
            System.out.println("Connect faild");
        }
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    //เป็นการส่งค่าไปเก็บไว้ใน database
    public int update(String sql, Object... args) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i + 1, args[i]);
        }
        int result = ps.executeUpdate();
        return result;
    }

    //ดึงข้อมูลจาก database มาใช้
    public ResultSet query(String sql, Object... args) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
        }
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    //ถ้ากำหนด false จะทำให้เป็นการกำหนดว่าจะให้มีการควบคุม transaction ด้วยตนเอง 
    //(คือเมื่อมีการ execute แล้วคำสั่ง sql จะถูกเก็บไว้ก่อน และจะมีผลกับฐานข้อมูลจริง ๆ เมื่อมีการ commit)
    public void beginTransaction() throws SQLException {
        connection.setAutoCommit(false);
    }

    public void commit() throws SQLException {
        connection.commit();
    }

    public void rollback() throws SQLException {
        connection.rollback();
    }

    //EmployeeTable

    /*public static int updateEmployee(DatabaseHandler dbHandler, EmployeeDB emp) {
        return EmplyeeTable.updateEmployee(dbHandler , emp);
    }*/
    public static int removeEmployee(DatabaseHandler dbHandler, EmployeeDB emp) {
        return EmployeeTable.removeEmployee(dbHandler, emp);
    }

    public static int insertEmployee(DatabaseHandler dbHandler, EmployeeDB emp) {
        return EmployeeTable.insertEmployee(dbHandler, emp);
    }

    public static ArrayList<EmployeeDB> findEmployeeByName(DatabaseHandler dbHandler, String name) {
        try {
            return EmployeeTable.findEmployeeByName(dbHandler, name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<EmployeeDB> findAllEmployee(DatabaseHandler dbHandler) {
        try {
            return EmployeeTable.findAllEmployee(dbHandler);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static EmployeeDB findEmployeeById(DatabaseHandler dbHandler, int id) {
        try {
            return EmployeeTable.findEmployeeById(dbHandler, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*private static ArrayList<EmployeeDB> extractEmployee(ResultSet rs){
        return EmployeeTable.extractEmployee( rs);
    }*/
    //MenuTable

    /*public static int updateMenu(DatabaseHandler dbHandler, MenuDB MenuDB) {
        return MenuTable.updateMenu(dbHandler , MenuDB);
    }*/
    public static int removeMenu(DatabaseHandler dbHandler, MenuDB MenuDB) {
        return MenuTable.removeMenu(dbHandler, MenuDB);
    }

    public static int insertMenu(DatabaseHandler dbHandler, MenuDB MenuDB) {
        return MenuTable.insertMenu(dbHandler, MenuDB);
    }

    public static MenuDB findMenuById(DatabaseHandler dbHandler, int id) {
        try {
            return MenuTable.findMenuById(dbHandler, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<MenuDB> findMenuByName(DatabaseHandler dbHandler, String name) {
        try {
            return MenuTable.findMenuByName(dbHandler, name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<MenuDB> findAllMenu(DatabaseHandler dbHandler) {
        try {
            return MenuTable.findAllMenu(dbHandler);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*private static ArrayList<MenuDB> extractMenu(ResultSet rs) {
        return MenuTable.extractMenu( rs );
    }*/
    //SaleORderTable

    /*public static int updateOrder(DatabaseHandler dbHandler, SaleOrderDB order) {
        return SaleOrderTable.updateOrder( dbHandler,  order);
    }*/
    public static int removeSaleOrder(DatabaseHandler dbHandler, SaleOrderDB order) {
        return SaleOrderTable.removeSaleOrder(dbHandler, order);
    }

    public static int insertOrder(DatabaseHandler dbHandler, SaleOrderDB order) {
        return SaleOrderTable.insertOrder(dbHandler, order);
    }

    public static SaleOrderDB findOrderById(DatabaseHandler dbHandler, int id) {
        try {
            return SaleOrderTable.findOrderById(dbHandler, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<SaleOrderDB> findOrderByName(DatabaseHandler dbHandler, String name) {
        try {
            return SaleOrderTable.findOrderByName(dbHandler, name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<SaleOrderDB> findAllOrder(DatabaseHandler dbHandler) {
        try {
            return SaleOrderTable.findAllOrder(dbHandler);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*private static ArrayList<SaleOrderDB> extractSaleOrder(ResultSet rs) {
        return SaleOrderTable.extractSaleOrder( rs);
    }*/
    //TimestampTable

    /*public static int updatetime(DatabaseHandler dbHandler, TimestampDB time) {
        return TimestampTable.updatetime( dbHandler,  time );
    }*/
    public static int removeTimestamp(DatabaseHandler dbHandler, TimestampDB time) {
        return TimestampTable.removeTimestamp(dbHandler, time);
    }

    public static int insertTimestamp(DatabaseHandler dbHandler, TimestampDB time) {
        return TimestampTable.insertTimestamp(dbHandler, time);
    }

    public static TimestampDB findtimeById(DatabaseHandler dbHandler, int seq, int empId) {
        try {
            return TimestampTable.findtimeById(dbHandler, seq, empId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<TimestampDB> findtimeByEmployee(DatabaseHandler dbHandler, int empId) {
        try {
            return TimestampTable.findtimeByEmployee(dbHandler, empId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<TimestampDB> findAlltime(DatabaseHandler dbHandler) {
        try {
            return TimestampTable.findAlltime(dbHandler);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*private static ArrayList<TimestampDB> extractTimestamp(ResultSet rs){
        return TimestampTable.extractTimestamp( rs );
    }*/
    public static ArrayList<EmployeeReport> findAllReportEmployee(DatabaseHandler dbHandler) {
        try {
            return ReportTable.findAllReportEmployee(dbHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<ReportSellDaliy> findReportOrderByTime(DatabaseHandler dbHandler, String time) {
        try {
            return ReportTable.findReportOrderByTime(dbHandler, time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
