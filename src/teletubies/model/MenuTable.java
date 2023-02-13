package teletubies.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import teletubies.database.DatabaseHandler;

public class MenuTable {

        /*/เป็นการ update ค่าในตาราง 
        public static int updateMenu(DatabaseHandler dbHandler, Menu menu) {
            String sql = "update teletubbies.Menu set name=?, GPA=? where FoodID=?";
            int rowUpdated;
            try {
                rowUpdated = dbHandler.update(sql, menu.getUsername(), menu.getPassword(), menu.getId());
            }
            catch (SQLException ex ) {
                
                rowUpdated = 0;
            }
            
            return rowUpdated;
        }
        */
    
        //เป็นการลบค่าในตาราง
        public static int removeMenu(DatabaseHandler dbHandler, MenuDB menu) {
             String sql ="delete from teletubbies.Menu where FoodID = ?";
             
             int rowDeleted;
             try {
                rowDeleted = dbHandler.update(sql, menu.getFoodID());
             }
             catch (SQLException ex ) {
                 rowDeleted = 0;
             }
            return rowDeleted;
        }
    
        //เป็นการเพิ่มค่าในตาราง
        public static int insertMenu(DatabaseHandler dbHandler, MenuDB menu) {
             String sql = "insert into teletubbies.Menu(FoodID, FoodName, FoodPrice)" + 
                   " values (?,?,?)";
             
             int rowInserted;
             try {
                 rowInserted = dbHandler.update(sql, menu.getFoodID(), menu.getFoodName(), menu.getFoodPrice());
             }
             catch(SQLException ex ) {
                 rowInserted = 0;
             }
             return rowInserted;
        } 
    
        //การหาค่าในตารางโดยหาจากไอดี
        public static MenuDB findMenuById(DatabaseHandler dbHandler, int id) throws SQLException {
            String sql = "select * from teletubbies.Menu where FoodID = ?";
            ResultSet rs;
            MenuDB menu = null;
            rs = dbHandler.query(sql, id);
            if (rs.next()) {
               menu = new MenuDB();
               menu.setFoodID(rs.getInt("FoodID"));
               menu.setFoodName(rs.getString("FoodName"));
               menu.setFoodPrice(rs.getInt("FoodPrice"));
           }
            return menu;
            
        }
    
        //การหาค่าในตารางโดยหาชื่อที่ต้องการ
        public static ArrayList<MenuDB> findMenuByName(DatabaseHandler dbHandler, String name) throws SQLException {
            String sql = "select * from teletubbies.Menu where FoodName = ?";
            ResultSet rs;
            ArrayList<MenuDB> menuList = null;
            rs = dbHandler.query(sql, name);
            menuList = extractMenu(rs);
            return menuList;
            
        } 
    
        //การหาค่าในตารางโดยหาทั้งหมด
        public static ArrayList<MenuDB> findAllMenu(DatabaseHandler dbHandler) throws SQLException {
            String sql = "select * from teletubbies.Menu";
            ResultSet rs; 
            ArrayList<MenuDB> menuList = null;
            rs = dbHandler.query(sql);
            menuList = extractMenu(rs);
            return menuList;
        }
        
        //เป็นการนำค่าจาก database มาเก็บใว้ในรูปของ arraylist
        private static ArrayList<MenuDB> extractMenu(ResultSet rs) {
            ArrayList<MenuDB> menuList = new ArrayList<>();
            try {
                while(rs.next()) {
                    MenuDB menu = new MenuDB();
                    try {
                        menu.setFoodID(rs.getInt("FoodID"));
                        menu.setFoodName(rs.getString("FoodName"));
                        menu.setFoodPrice(rs.getInt("FoodPrice"));
                    } catch (SQLException ex) {
                        Logger.getLogger(MenuTable.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    menuList.add(menu);
                }
            } catch (SQLException ex) {
                Logger.getLogger(MenuTable.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(menuList.isEmpty()) {
                menuList = null;
            }
            return menuList;
        }
}
