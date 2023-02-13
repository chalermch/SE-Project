package teletubies.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import teletubies.database.DatabaseHandler;

public class SaleOrderTable {

    /*
     * /เป็นการ update ค่าในตาราง
     * public static int updateOrder(DatabaseHandler dbHandler, SaleOrder order) {
     * String sql = "update teletubbies.Order set name=?, GPA=? where FoodID=?";
     * int rowUpdated;
     * try {
     * rowUpdated = dbHandler.update(sql, Order.getUsername(), Order.getPassword(),
     * Order.getId());
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
    public static int removeSaleOrder(DatabaseHandler dbHandler, SaleOrderDB order) {
        String sql = "delete from teletubbies.SaleOrder where OrderID = ?";

        int rowDeleted;
        try {
            rowDeleted = dbHandler.update(sql, order.getOrderID());
        } catch (SQLException ex) {
            rowDeleted = 0;
        }
        return rowDeleted;
    }

    // เป็นการเพิ่มค่าในตาราง
    public static int insertOrder(DatabaseHandler dbHandler, SaleOrderDB order) {
        String sql = "insert into teletubbies.SaleOrder(OrderID, Quantity, TotalPrice, OrderStatus, FoodID, EmployeeID, cash , PaymentMethod , SaleTimestamp)" +
                " values (?,?,?,?,?,?,?,?,?)";

        int rowInserted;
        try {
            rowInserted = dbHandler.update(sql, order.getOrderID(), order.getQuantity(), order.getTotalPrice(), order.getOrderStatus(), order.getFoodID(), order.getEmployeeID(), order.getCash(), order.getPayMethod(), order.getTimestamp());
        } catch (SQLException ex) {
            rowInserted = 0;
        }
        return rowInserted;
    }

    // การหาค่าในตารางโดยหาจากไอดี
    public static SaleOrderDB findOrderById(DatabaseHandler dbHandler, int id) throws SQLException {
        String sql = "select * from teletubbies.SaleOrder where OrderID = ?";
        ResultSet rs;
        SaleOrderDB order = null;
        rs = dbHandler.query(sql, id);
        if (rs.next()) {
            order = new SaleOrderDB();
            order.setOrderID(rs.getInt("OrderID"));
            order.setQuantity(rs.getInt("Quantity"));
            order.setTotalPrice(rs.getInt("TotalPrice"));
            order.setOrderStatus(rs.getBoolean("OrderStatus"));
            order.setFoodID(rs.getInt("FoodID"));
            order.setEmployeeID(rs.getInt("EmployeeID"));
            order.setCash(rs.getDouble("cash"));
            order.setTimestamp(rs.getString("SaleTimestamp"));
        }
        return order;

    }

    // การหาค่าในตารางโดยหาชื่อที่ต้องการ
    public static ArrayList<SaleOrderDB> findOrderByName(DatabaseHandler dbHandler, String name) throws SQLException {
        String sql = "select * from teletubbies.SaleOrder where name = ?";
        ResultSet rs;
        ArrayList<SaleOrderDB> orderList = null;
        rs = dbHandler.query(sql, name);
        orderList = extractSaleOrder(rs);
        return orderList;

    }

    // การหาค่าในตารางโดยหาทั้งหมด
    public static ArrayList<SaleOrderDB> findAllOrder(DatabaseHandler dbHandler) throws SQLException {
        String sql = "select * from teletubbies.SaleOrder";
        ResultSet rs;
        ArrayList<SaleOrderDB> orderList = null;
        rs = dbHandler.query(sql);
        orderList = extractSaleOrder(rs);
        return orderList;
    }

    // เป็นการนำค่าจาก database มาเก็บใว้ในรูปของ arraylist
    private static ArrayList<SaleOrderDB> extractSaleOrder(ResultSet rs) {
        ArrayList<SaleOrderDB> orderList = new ArrayList<>();
        try {
            while (rs.next()) {
                SaleOrderDB order = new SaleOrderDB();
                try {
                    order.setOrderID(rs.getInt("OrderID"));
                    order.setQuantity(rs.getInt("Quantity"));
                    order.setTotalPrice(rs.getInt("TotalPrice"));
                    order.setOrderStatus(rs.getBoolean("OrderStatus"));
                    order.setFoodID(rs.getInt("FoodID"));
                    order.setEmployeeID(rs.getInt("EmployeeID"));
                    order.setCash(rs.getDouble("cash"));
                    order.setTimestamp(rs.getString("SaleTimestamp"));
                } catch (SQLException ex) {
                    Logger.getLogger(SaleOrderTable.class.getName()).log(Level.SEVERE, null, ex);
                }

                orderList.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SaleOrderTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (orderList.isEmpty()) {
            orderList = null;
        }
        return orderList;
    }
}