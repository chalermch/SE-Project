/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
import java.awt.CardLayout;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import teletubies.database.DatabaseHandler;
import teletubies.model.MenuDB;
import teletubies.Food;
import teletubies.Order;
/**
 *
 * @author koko
 */
public class GetOrder extends javax.swing.JPanel {

    /**
     * Creates new form GetOrder
     */
    
    private static int [] foodnum = new int[16];
    private static ArrayList <String> foodname = new ArrayList <String>();
    private static ArrayList <Integer> foodqty = new ArrayList <Integer>();
    private static ArrayList <Food> orderdata = new ArrayList <Food>();
    private static int ordernumber = 1;
    
    //for insertDB
    private JPanel contain;
    private JPanel loginPanel;
    private JTextField empIDField;
    
    private static ArrayList <Integer> foodid = new ArrayList <Integer>();
    private int empid;
    
    private KitchenWindow kw;
    
    public GetOrder() {
            initComponents();
            foodnum1.setVisible(false);
            bin1.setVisible(false);
            foodnum2.setVisible(false);
            bin2.setVisible(false);
            foodnum3.setVisible(false);
            bin3.setVisible(false);
            foodnum4.setVisible(false);
            bin4.setVisible(false);
            foodnum5.setVisible(false);
            bin5.setVisible(false);
            foodnum6.setVisible(false);
            bin6.setVisible(false);
            foodnum7.setVisible(false);
            bin7.setVisible(false);
            foodnum8.setVisible(false);
            bin8.setVisible(false);
            foodnum9.setVisible(false);
            bin9.setVisible(false);
            foodnum10.setVisible(false);
            bin10.setVisible(false);
            foodnum11.setVisible(false);
            bin11.setVisible(false);
            foodnum12.setVisible(false);
            bin12.setVisible(false);
            foodnum13.setVisible(false);
            bin13.setVisible(false);
            foodnum14.setVisible(false);
            bin14.setVisible(false);
            foodnum15.setVisible(false);
            bin15.setVisible(false);
    }
    
    //collect data in row into object Order
    public Order getOrderInTable(){
        Order order;
        int orderid = ordernumber;
        
        //get data in jtable
        int numRow = orderTable.getRowCount();
        
        for(int i = 0 ; i < numRow ; i++){
            Food f;
            
            int id = Integer.valueOf(orderTable.getValueAt(i,0).toString());
            String name = orderTable.getValueAt(i,1).toString();
            int qty = Integer.valueOf(orderTable.getValueAt(i,2).toString());
            int mixprice = Integer.valueOf(orderTable.getValueAt(i,3).toString());
            int price = (mixprice / qty);
            
            /*System.out.print("id :" + id + " , ");
            System.out.print("name : " + name + " , ");
            System.out.print("price : " + price);
            System.out.println();*/
            
            f = new Food(id , name , price);
            orderdata.add(f);
            
            foodname.add(name);
            foodqty.add(qty);
            
            foodid.add(id);
        }
        
        int total = Integer.valueOf(orderTotalLabel.getText());
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.ENGLISH);
        Date date = new Date();
        
        order = new Order(orderid , foodname , foodqty , orderdata , total , dateFormat.format(date));
        
        /*System.out.println(orderid);
        System.out.println(orderstatus);
        System.out.println(orderdata);
        System.out.println(foodname);
        System.out.println(foodqty);
        System.out.println(total);
        System.out.println(orderdate);*/
        
        return order;
    }
    //set Employee cashier name
    public void setEmpname(String username){
        employeeNameLabel.setText(username);
    }
    
    //increase food number
    public void increaseFoodNum(int num){
        foodnum[num] += 1;
    }
    
    //decrease food number string
    public void decreaseFoodNum(int num){
        if(foodnum[num] > 0){
            foodnum[num] -= 1;
        }
    }
    
    public static void plusOrder(){
        ordernumber++;
    }
    
    //clear all table and data in order
    public static void clearOrder(){
        //all food quantity mix for insert into database
        foodid.clear();
        
        foodname.clear();
        foodqty.clear();
        orderdata.clear();
        DefaultTableModel model = (DefaultTableModel)orderTable.getModel(); 
        int rows = model.getRowCount(); 
        for(int i = rows - 1; i >=0; i--)
        {
           model.removeRow(i); 
        }
        
        for(int i = 0 ; i < foodnum.length ; i++){
            foodnum[i] = 0;
        }
        foodnum1.setText("0");
        foodnum2.setText("0");
        foodnum3.setText("0");
        foodnum4.setText("0");
        foodnum5.setText("0");
        foodnum6.setText("0");
        foodnum7.setText("0");
        foodnum8.setText("0");
        foodnum9.setText("0");
        foodnum10.setText("0");
        foodnum11.setText("0");
        foodnum12.setText("0");
        foodnum13.setText("0");
        foodnum14.setText("0");
        foodnum15.setText("0");
        
        //clear price
        orderTotalLabel.setText("0");
        
        foodnum1.setVisible(false);
        bin1.setVisible(false);
        foodnum2.setVisible(false);
        bin2.setVisible(false);
        foodnum3.setVisible(false);
        bin3.setVisible(false);
        foodnum4.setVisible(false);
        bin4.setVisible(false);
        foodnum5.setVisible(false);
        bin5.setVisible(false);
        foodnum6.setVisible(false);
        bin6.setVisible(false);
        foodnum7.setVisible(false);
        bin7.setVisible(false);
        foodnum8.setVisible(false);
        bin8.setVisible(false);
        foodnum9.setVisible(false);
        bin9.setVisible(false);
        foodnum10.setVisible(false);
        bin10.setVisible(false);
        foodnum11.setVisible(false);
        bin11.setVisible(false);
        foodnum12.setVisible(false);
        bin12.setVisible(false);
        foodnum13.setVisible(false);
        bin13.setVisible(false);
        foodnum14.setVisible(false);
        bin14.setVisible(false);
        foodnum15.setVisible(false);
        bin15.setVisible(false);
    }
    
    //calculate price * quantity
    public void calPrice(){
        int numRow = orderTable.getRowCount();
        int total = 0;
        
        for(int i = 0 ; i < numRow ; i++){
            int value = Integer.valueOf(orderTable.getValueAt(i,3).toString());
            total += value;
        }
        String totals = String.valueOf(total);
        orderTotalLabel.setText(totals);
    }
    
    //add data to table format
    public void addTable(int id , String name , int qty , int price){
        DefaultTableModel dt = (DefaultTableModel) orderTable.getModel();
        int totalprice = qty * price;
        //if already add
        for(int row = 0 ; row < orderTable.getRowCount() ; row++){
            if(name.equals(orderTable.getValueAt(row, 1))){
                dt.removeRow(orderTable.convertRowIndexToModel(row));
            }
        }
        
        
        Vector v = new Vector();
        v.add(id);
        v.add(name);
        v.add(qty);
        v.add(totalprice);
        
        dt.addRow(v);
    }
    
    //insert data to table from addTable Format
    public void insertTable(Food fooddata , String qty){
        int num = Integer.parseInt(qty);
        addTable(fooddata.getfoodID() , fooddata.getfoodName() , num , fooddata.getfoodPrice());
        
    }
    
    //get food data from database
    public Food getFoodData(String name){
        ArrayList <MenuDB> me;
        //System.out.println(name);
        Food f;
        try {
            me = DatabaseHandler.findMenuByName( new DatabaseHandler() , name);
            if (me != null) {
                //System.out.println(me.get(0).getFoodID() );
                f = new Food(me.get(0).getFoodID() , me.get(0).getFoodName() , me.get(0).getFoodPrice());
                return f;
            }
            else if(me == null){
                System.out.println("no food dat name" );
                return null;
            }
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(GetOrder.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(GetOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
     /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        orderPanel = new javax.swing.JPanel();
        showOrderScrollPane = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        payButton = new javax.swing.JButton();
        totalLabel = new javax.swing.JLabel();
        orderTotalLabel = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        employeeNameLabel = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        menuScrollPane = new javax.swing.JScrollPane();
        menuPanel = new javax.swing.JPanel();
        bin1 = new javax.swing.JLabel();
        foodnum1 = new javax.swing.JLabel();
        foodnum2 = new javax.swing.JLabel();
        bin2 = new javax.swing.JLabel();
        bin3 = new javax.swing.JLabel();
        foodnum3 = new javax.swing.JLabel();
        bin6 = new javax.swing.JLabel();
        foodnum6 = new javax.swing.JLabel();
        foodnum4 = new javax.swing.JLabel();
        bin4 = new javax.swing.JLabel();
        foodnum5 = new javax.swing.JLabel();
        bin5 = new javax.swing.JLabel();
        bin9 = new javax.swing.JLabel();
        foodnum9 = new javax.swing.JLabel();
        foodnum7 = new javax.swing.JLabel();
        bin7 = new javax.swing.JLabel();
        foodnum8 = new javax.swing.JLabel();
        bin8 = new javax.swing.JLabel();
        foodnum10 = new javax.swing.JLabel();
        bin10 = new javax.swing.JLabel();
        foodnum13 = new javax.swing.JLabel();
        bin13 = new javax.swing.JLabel();
        foodnum11 = new javax.swing.JLabel();
        bin11 = new javax.swing.JLabel();
        foodnum14 = new javax.swing.JLabel();
        bin14 = new javax.swing.JLabel();
        foodnum12 = new javax.swing.JLabel();
        bin12 = new javax.swing.JLabel();
        foodnum15 = new javax.swing.JLabel();
        bin15 = new javax.swing.JLabel();
        food3Button = new javax.swing.JButton();
        food2Button = new javax.swing.JButton();
        food1Button = new javax.swing.JButton();
        food1Name = new javax.swing.JLabel();
        food2Name = new javax.swing.JLabel();
        food3Name = new javax.swing.JLabel();
        food4Button = new javax.swing.JButton();
        food5Button = new javax.swing.JButton();
        food6Button = new javax.swing.JButton();
        food8Button = new javax.swing.JButton();
        food9Button = new javax.swing.JButton();
        food7Button = new javax.swing.JButton();
        food11Button = new javax.swing.JButton();
        food12Button = new javax.swing.JButton();
        food10Button = new javax.swing.JButton();
        food15Button = new javax.swing.JButton();
        food14Button = new javax.swing.JButton();
        food13Button = new javax.swing.JButton();
        food2Price = new javax.swing.JLabel();
        food1Price = new javax.swing.JLabel();
        food3Price = new javax.swing.JLabel();
        food5Price = new javax.swing.JLabel();
        food4Price = new javax.swing.JLabel();
        food6Price = new javax.swing.JLabel();
        food4Name = new javax.swing.JLabel();
        food5Name = new javax.swing.JLabel();
        food6Name = new javax.swing.JLabel();
        food8Price = new javax.swing.JLabel();
        food7Price = new javax.swing.JLabel();
        food9Price = new javax.swing.JLabel();
        food7Name = new javax.swing.JLabel();
        food8Name = new javax.swing.JLabel();
        food9Name = new javax.swing.JLabel();
        food11Price = new javax.swing.JLabel();
        food10Price = new javax.swing.JLabel();
        food12Price = new javax.swing.JLabel();
        food10Name = new javax.swing.JLabel();
        food11Name = new javax.swing.JLabel();
        food12Name = new javax.swing.JLabel();
        food14Price = new javax.swing.JLabel();
        food13Price = new javax.swing.JLabel();
        food15Price = new javax.swing.JLabel();
        food13Name = new javax.swing.JLabel();
        food14Name = new javax.swing.JLabel();
        food15Name = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setVerifyInputWhenFocusTarget(false);
        setLayout(null);

        orderPanel.setBackground(new java.awt.Color(255, 255, 255));

        orderTable.setBackground(new java.awt.Color(204, 204, 204));
        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Item", "Qty", "Price"
            }
        ));
        showOrderScrollPane.setViewportView(orderTable);

        payButton.setBackground(new java.awt.Color(0, 102, 255));
        payButton.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        payButton.setForeground(new java.awt.Color(255, 255, 255));
        payButton.setText("Pay");
        payButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payButtonActionPerformed(evt);
            }
        });

        totalLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        totalLabel.setText("Total:");

        orderTotalLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        orderTotalLabel.setText("00");

        logoutButton.setBackground(new java.awt.Color(255, 51, 51));
        logoutButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        employeeNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        employeeNameLabel.setText("Username + Lastname");

        deleteButton.setBackground(new java.awt.Color(204, 204, 204));
        deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout orderPanelLayout = new javax.swing.GroupLayout(orderPanel);
        orderPanel.setLayout(orderPanelLayout);
        orderPanelLayout.setHorizontalGroup(
            orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(orderPanelLayout.createSequentialGroup()
                        .addComponent(employeeNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(payButton, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(orderPanelLayout.createSequentialGroup()
                                .addComponent(totalLabel)
                                .addGap(18, 18, 18)
                                .addComponent(orderTotalLabel)
                                .addGap(238, 238, 238)
                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(showOrderScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        orderPanelLayout.setVerticalGroup(
            orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(employeeNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(showOrderScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(orderPanelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(orderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalLabel)
                            .addComponent(orderTotalLabel)))
                    .addGroup(orderPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(payButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        add(orderPanel);
        orderPanel.setBounds(720, 0, 560, 720);

        menuScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        menuScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        menuScrollPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuScrollPane.setPreferredSize(new java.awt.Dimension(1280, 720));
        menuScrollPane.setVerifyInputWhenFocusTarget(false);

        menuPanel.setBackground(new java.awt.Color(255, 255, 255));
        menuPanel.setPreferredSize(new java.awt.Dimension(727, 1116));
        menuPanel.setLayout(null);

        bin1.setBackground(new java.awt.Color(51, 51, 51));
        bin1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        bin1.setForeground(new java.awt.Color(255, 255, 255));
        bin1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bin1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bin.png"))); // NOI18N
        bin1.setToolTipText("");
        bin1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        bin1.setOpaque(true);
        bin1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bin1MouseClicked(evt);
            }
        });
        menuPanel.add(bin1);
        bin1.setBounds(20, 70, 50, 50);

        foodnum1.setBackground(new java.awt.Color(51, 51, 51));
        foodnum1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        foodnum1.setForeground(new java.awt.Color(255, 255, 255));
        foodnum1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foodnum1.setText("1");
        foodnum1.setToolTipText("");
        foodnum1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        foodnum1.setOpaque(true);
        menuPanel.add(foodnum1);
        foodnum1.setBounds(20, 20, 50, 50);

        foodnum2.setBackground(new java.awt.Color(51, 51, 51));
        foodnum2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        foodnum2.setForeground(new java.awt.Color(255, 255, 255));
        foodnum2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foodnum2.setText("1");
        foodnum2.setToolTipText("");
        foodnum2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        foodnum2.setOpaque(true);
        menuPanel.add(foodnum2);
        foodnum2.setBounds(250, 20, 50, 50);

        bin2.setBackground(new java.awt.Color(51, 51, 51));
        bin2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        bin2.setForeground(new java.awt.Color(255, 255, 255));
        bin2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bin.png"))); // NOI18N
        bin2.setToolTipText("");
        bin2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        bin2.setOpaque(true);
        bin2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bin2MouseClicked(evt);
            }
        });
        menuPanel.add(bin2);
        bin2.setBounds(250, 70, 50, 50);

        bin3.setBackground(new java.awt.Color(51, 51, 51));
        bin3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        bin3.setForeground(new java.awt.Color(255, 255, 255));
        bin3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bin3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bin.png"))); // NOI18N
        bin3.setToolTipText("");
        bin3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        bin3.setOpaque(true);
        bin3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bin3MouseClicked(evt);
            }
        });
        menuPanel.add(bin3);
        bin3.setBounds(480, 70, 50, 50);

        foodnum3.setBackground(new java.awt.Color(51, 51, 51));
        foodnum3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        foodnum3.setForeground(new java.awt.Color(255, 255, 255));
        foodnum3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foodnum3.setText("1");
        foodnum3.setToolTipText("");
        foodnum3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        foodnum3.setOpaque(true);
        menuPanel.add(foodnum3);
        foodnum3.setBounds(480, 20, 50, 50);

        bin6.setBackground(new java.awt.Color(51, 51, 51));
        bin6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        bin6.setForeground(new java.awt.Color(255, 255, 255));
        bin6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bin6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bin.png"))); // NOI18N
        bin6.setToolTipText("");
        bin6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        bin6.setOpaque(true);
        bin6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bin6MouseClicked(evt);
            }
        });
        menuPanel.add(bin6);
        bin6.setBounds(480, 290, 50, 50);

        foodnum6.setBackground(new java.awt.Color(51, 51, 51));
        foodnum6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        foodnum6.setForeground(new java.awt.Color(255, 255, 255));
        foodnum6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foodnum6.setText("1");
        foodnum6.setToolTipText("");
        foodnum6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        foodnum6.setOpaque(true);
        menuPanel.add(foodnum6);
        foodnum6.setBounds(480, 240, 50, 50);

        foodnum4.setBackground(new java.awt.Color(51, 51, 51));
        foodnum4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        foodnum4.setForeground(new java.awt.Color(255, 255, 255));
        foodnum4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foodnum4.setText("1");
        foodnum4.setToolTipText("");
        foodnum4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        foodnum4.setOpaque(true);
        menuPanel.add(foodnum4);
        foodnum4.setBounds(20, 240, 50, 50);

        bin4.setBackground(new java.awt.Color(51, 51, 51));
        bin4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        bin4.setForeground(new java.awt.Color(255, 255, 255));
        bin4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bin4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bin.png"))); // NOI18N
        bin4.setToolTipText("");
        bin4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        bin4.setOpaque(true);
        bin4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bin4MouseClicked(evt);
            }
        });
        menuPanel.add(bin4);
        bin4.setBounds(20, 290, 50, 50);

        foodnum5.setBackground(new java.awt.Color(51, 51, 51));
        foodnum5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        foodnum5.setForeground(new java.awt.Color(255, 255, 255));
        foodnum5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foodnum5.setText("1");
        foodnum5.setToolTipText("");
        foodnum5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        foodnum5.setOpaque(true);
        menuPanel.add(foodnum5);
        foodnum5.setBounds(250, 240, 50, 50);

        bin5.setBackground(new java.awt.Color(51, 51, 51));
        bin5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        bin5.setForeground(new java.awt.Color(255, 255, 255));
        bin5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bin5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bin.png"))); // NOI18N
        bin5.setToolTipText("");
        bin5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        bin5.setOpaque(true);
        bin5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bin5MouseClicked(evt);
            }
        });
        menuPanel.add(bin5);
        bin5.setBounds(250, 290, 50, 50);

        bin9.setBackground(new java.awt.Color(51, 51, 51));
        bin9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        bin9.setForeground(new java.awt.Color(255, 255, 255));
        bin9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bin9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bin.png"))); // NOI18N
        bin9.setToolTipText("");
        bin9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        bin9.setOpaque(true);
        bin9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bin9MouseClicked(evt);
            }
        });
        menuPanel.add(bin9);
        bin9.setBounds(480, 500, 50, 50);

        foodnum9.setBackground(new java.awt.Color(51, 51, 51));
        foodnum9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        foodnum9.setForeground(new java.awt.Color(255, 255, 255));
        foodnum9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foodnum9.setText("1");
        foodnum9.setToolTipText("");
        foodnum9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        foodnum9.setOpaque(true);
        menuPanel.add(foodnum9);
        foodnum9.setBounds(480, 450, 50, 50);

        foodnum7.setBackground(new java.awt.Color(51, 51, 51));
        foodnum7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        foodnum7.setForeground(new java.awt.Color(255, 255, 255));
        foodnum7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foodnum7.setText("1");
        foodnum7.setToolTipText("");
        foodnum7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        foodnum7.setOpaque(true);
        menuPanel.add(foodnum7);
        foodnum7.setBounds(20, 450, 50, 50);

        bin7.setBackground(new java.awt.Color(51, 51, 51));
        bin7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        bin7.setForeground(new java.awt.Color(255, 255, 255));
        bin7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bin7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bin.png"))); // NOI18N
        bin7.setToolTipText("");
        bin7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        bin7.setOpaque(true);
        bin7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bin7MouseClicked(evt);
            }
        });
        menuPanel.add(bin7);
        bin7.setBounds(20, 500, 50, 50);

        foodnum8.setBackground(new java.awt.Color(51, 51, 51));
        foodnum8.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        foodnum8.setForeground(new java.awt.Color(255, 255, 255));
        foodnum8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foodnum8.setText("1");
        foodnum8.setToolTipText("");
        foodnum8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        foodnum8.setOpaque(true);
        menuPanel.add(foodnum8);
        foodnum8.setBounds(250, 450, 50, 50);

        bin8.setBackground(new java.awt.Color(51, 51, 51));
        bin8.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        bin8.setForeground(new java.awt.Color(255, 255, 255));
        bin8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bin8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bin.png"))); // NOI18N
        bin8.setToolTipText("");
        bin8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        bin8.setOpaque(true);
        bin8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bin8MouseClicked(evt);
            }
        });
        menuPanel.add(bin8);
        bin8.setBounds(250, 500, 50, 50);

        foodnum10.setBackground(new java.awt.Color(51, 51, 51));
        foodnum10.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        foodnum10.setForeground(new java.awt.Color(255, 255, 255));
        foodnum10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foodnum10.setText("1");
        foodnum10.setToolTipText("");
        foodnum10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        foodnum10.setOpaque(true);
        menuPanel.add(foodnum10);
        foodnum10.setBounds(20, 670, 50, 50);

        bin10.setBackground(new java.awt.Color(51, 51, 51));
        bin10.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        bin10.setForeground(new java.awt.Color(255, 255, 255));
        bin10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bin10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bin.png"))); // NOI18N
        bin10.setToolTipText("");
        bin10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        bin10.setOpaque(true);
        bin10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bin10MouseClicked(evt);
            }
        });
        menuPanel.add(bin10);
        bin10.setBounds(20, 720, 50, 50);

        foodnum13.setBackground(new java.awt.Color(51, 51, 51));
        foodnum13.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        foodnum13.setForeground(new java.awt.Color(255, 255, 255));
        foodnum13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foodnum13.setText("1");
        foodnum13.setToolTipText("");
        foodnum13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        foodnum13.setOpaque(true);
        menuPanel.add(foodnum13);
        foodnum13.setBounds(20, 890, 50, 50);

        bin13.setBackground(new java.awt.Color(51, 51, 51));
        bin13.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        bin13.setForeground(new java.awt.Color(255, 255, 255));
        bin13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bin13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bin.png"))); // NOI18N
        bin13.setToolTipText("");
        bin13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        bin13.setOpaque(true);
        bin13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bin13MouseClicked(evt);
            }
        });
        menuPanel.add(bin13);
        bin13.setBounds(20, 940, 50, 50);

        foodnum11.setBackground(new java.awt.Color(51, 51, 51));
        foodnum11.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        foodnum11.setForeground(new java.awt.Color(255, 255, 255));
        foodnum11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foodnum11.setText("1");
        foodnum11.setToolTipText("");
        foodnum11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        foodnum11.setOpaque(true);
        menuPanel.add(foodnum11);
        foodnum11.setBounds(250, 670, 50, 50);

        bin11.setBackground(new java.awt.Color(51, 51, 51));
        bin11.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        bin11.setForeground(new java.awt.Color(255, 255, 255));
        bin11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bin11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bin.png"))); // NOI18N
        bin11.setToolTipText("");
        bin11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        bin11.setOpaque(true);
        bin11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bin11MouseClicked(evt);
            }
        });
        menuPanel.add(bin11);
        bin11.setBounds(250, 720, 50, 50);

        foodnum14.setBackground(new java.awt.Color(51, 51, 51));
        foodnum14.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        foodnum14.setForeground(new java.awt.Color(255, 255, 255));
        foodnum14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foodnum14.setText("1");
        foodnum14.setToolTipText("");
        foodnum14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        foodnum14.setOpaque(true);
        menuPanel.add(foodnum14);
        foodnum14.setBounds(250, 890, 50, 50);

        bin14.setBackground(new java.awt.Color(51, 51, 51));
        bin14.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        bin14.setForeground(new java.awt.Color(255, 255, 255));
        bin14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bin14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bin.png"))); // NOI18N
        bin14.setToolTipText("");
        bin14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        bin14.setOpaque(true);
        bin14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bin14MouseClicked(evt);
            }
        });
        menuPanel.add(bin14);
        bin14.setBounds(250, 940, 50, 50);

        foodnum12.setBackground(new java.awt.Color(51, 51, 51));
        foodnum12.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        foodnum12.setForeground(new java.awt.Color(255, 255, 255));
        foodnum12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foodnum12.setText("1");
        foodnum12.setToolTipText("");
        foodnum12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        foodnum12.setOpaque(true);
        menuPanel.add(foodnum12);
        foodnum12.setBounds(480, 670, 50, 50);

        bin12.setBackground(new java.awt.Color(51, 51, 51));
        bin12.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        bin12.setForeground(new java.awt.Color(255, 255, 255));
        bin12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bin12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bin.png"))); // NOI18N
        bin12.setToolTipText("");
        bin12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        bin12.setOpaque(true);
        bin12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bin12MouseClicked(evt);
            }
        });
        menuPanel.add(bin12);
        bin12.setBounds(480, 720, 50, 50);

        foodnum15.setBackground(new java.awt.Color(51, 51, 51));
        foodnum15.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        foodnum15.setForeground(new java.awt.Color(255, 255, 255));
        foodnum15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foodnum15.setText("1");
        foodnum15.setToolTipText("");
        foodnum15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        foodnum15.setOpaque(true);
        menuPanel.add(foodnum15);
        foodnum15.setBounds(480, 890, 50, 50);

        bin15.setBackground(new java.awt.Color(51, 51, 51));
        bin15.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        bin15.setForeground(new java.awt.Color(255, 255, 255));
        bin15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bin15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Bin.png"))); // NOI18N
        bin15.setToolTipText("");
        bin15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        bin15.setOpaque(true);
        bin15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bin15MouseClicked(evt);
            }
        });
        menuPanel.add(bin15);
        bin15.setBounds(480, 940, 50, 50);

        food3Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/PadThaiKungSod.png"))); // NOI18N
        food3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                food3ButtonActionPerformed(evt);
            }
        });
        menuPanel.add(food3Button);
        food3Button.setBounds(479, 22, 212, 157);

        food2Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/KarPowKaiKonTalay.png"))); // NOI18N
        food2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                food2ButtonActionPerformed(evt);
            }
        });
        menuPanel.add(food2Button);
        food2Button.setBounds(249, 22, 212, 157);

        food1Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/KaikonKungSod.png"))); // NOI18N
        food1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                food1ButtonActionPerformed(evt);
            }
        });
        menuPanel.add(food1Button);
        food1Button.setBounds(19, 22, 212, 157);

        food1Name.setBackground(new java.awt.Color(255, 255, 255));
        food1Name.setText("Shrimp Chili Creamy Omelet");
        menuPanel.add(food1Name);
        food1Name.setBounds(19, 185, 212, 14);

        food2Name.setText("Seafood Creamy Omelet ");
        menuPanel.add(food2Name);
        food2Name.setBounds(249, 185, 212, 14);

        food3Name.setBackground(new java.awt.Color(255, 153, 153));
        food3Name.setText("Pad Thai Shrimp");
        menuPanel.add(food3Name);
        food3Name.setBounds(479, 185, 212, 14);

        food4Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/RamyeonOnsen.png"))); // NOI18N
        food4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                food4ButtonActionPerformed(evt);
            }
        });
        menuPanel.add(food4Button);
        food4Button.setBounds(19, 238, 212, 157);

        food5Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/brownsugartoast.png"))); // NOI18N
        food5Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                food5ButtonActionPerformed(evt);
            }
        });
        menuPanel.add(food5Button);
        food5Button.setBounds(249, 238, 212, 157);

        food6Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bubbletea.png"))); // NOI18N
        food6Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                food6ButtonActionPerformed(evt);
            }
        });
        menuPanel.add(food6Button);
        food6Button.setBounds(479, 238, 212, 157);

        food8Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/chocolatelavacake.png"))); // NOI18N
        food8Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                food8ButtonActionPerformed(evt);
            }
        });
        menuPanel.add(food8Button);
        food8Button.setBounds(249, 454, 212, 157);

        food9Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/coco.png"))); // NOI18N
        food9Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                food9ButtonActionPerformed(evt);
            }
        });
        menuPanel.add(food9Button);
        food9Button.setBounds(479, 454, 212, 157);

        food7Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/carrotcake.png"))); // NOI18N
        food7Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                food7ButtonActionPerformed(evt);
            }
        });
        menuPanel.add(food7Button);
        food7Button.setBounds(19, 454, 212, 157);

        food11Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/coldlimetea.png"))); // NOI18N
        food11Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                food11ButtonActionPerformed(evt);
            }
        });
        menuPanel.add(food11Button);
        food11Button.setBounds(249, 670, 212, 157);

        food12Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/crapecake.png"))); // NOI18N
        food12Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                food12ButtonActionPerformed(evt);
            }
        });
        menuPanel.add(food12Button);
        food12Button.setBounds(479, 670, 212, 157);

        food10Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/coldgreentea.png"))); // NOI18N
        food10Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                food10ButtonActionPerformed(evt);
            }
        });
        menuPanel.add(food10Button);
        food10Button.setBounds(19, 670, 212, 157);

        food15Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/spagethiBlack.png"))); // NOI18N
        food15Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                food15ButtonActionPerformed(evt);
            }
        });
        menuPanel.add(food15Button);
        food15Button.setBounds(479, 886, 212, 157);

        food14Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fudgybrownie.png"))); // NOI18N
        food14Button.setToolTipText("");
        food14Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                food14ButtonActionPerformed(evt);
            }
        });
        menuPanel.add(food14Button);
        food14Button.setBounds(249, 886, 212, 157);

        food13Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/creamcheesegarlicbread.png"))); // NOI18N
        food13Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                food13ButtonActionPerformed(evt);
            }
        });
        menuPanel.add(food13Button);
        food13Button.setBounds(19, 886, 212, 157);

        food2Price.setBackground(new java.awt.Color(255, 255, 255));
        food2Price.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        food2Price.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        food2Price.setText("80฿");
        menuPanel.add(food2Price);
        food2Price.setBounds(249, 207, 212, 25);

        food1Price.setBackground(new java.awt.Color(255, 255, 255));
        food1Price.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        food1Price.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        food1Price.setText("80฿");
        menuPanel.add(food1Price);
        food1Price.setBounds(19, 207, 212, 25);

        food3Price.setBackground(new java.awt.Color(255, 255, 255));
        food3Price.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        food3Price.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        food3Price.setText("70฿");
        menuPanel.add(food3Price);
        food3Price.setBounds(479, 207, 212, 25);

        food5Price.setBackground(new java.awt.Color(255, 255, 255));
        food5Price.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        food5Price.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        food5Price.setText("30฿");
        menuPanel.add(food5Price);
        food5Price.setBounds(255, 423, 204, 25);

        food4Price.setBackground(new java.awt.Color(255, 255, 255));
        food4Price.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        food4Price.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        food4Price.setText("120฿");
        menuPanel.add(food4Price);
        food4Price.setBounds(25, 423, 204, 25);

        food6Price.setBackground(new java.awt.Color(255, 255, 255));
        food6Price.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        food6Price.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        food6Price.setText("40฿");
        menuPanel.add(food6Price);
        food6Price.setBounds(485, 423, 204, 25);

        food4Name.setBackground(new java.awt.Color(255, 255, 255));
        food4Name.setText("Korean Instant Noodles with Onsen Egg");
        menuPanel.add(food4Name);
        food4Name.setBounds(19, 401, 191, 14);

        food5Name.setText("Brown Sugar Toast");
        menuPanel.add(food5Name);
        food5Name.setBounds(255, 401, 204, 14);

        food6Name.setBackground(new java.awt.Color(255, 153, 153));
        food6Name.setText("Bubble Tea");
        menuPanel.add(food6Name);
        food6Name.setBounds(485, 401, 204, 14);

        food8Price.setBackground(new java.awt.Color(255, 255, 255));
        food8Price.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        food8Price.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        food8Price.setText("50฿");
        menuPanel.add(food8Price);
        food8Price.setBounds(249, 639, 204, 25);

        food7Price.setBackground(new java.awt.Color(255, 255, 255));
        food7Price.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        food7Price.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        food7Price.setText("50฿");
        menuPanel.add(food7Price);
        food7Price.setBounds(19, 639, 204, 25);

        food9Price.setBackground(new java.awt.Color(255, 255, 255));
        food9Price.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        food9Price.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        food9Price.setText("50฿");
        menuPanel.add(food9Price);
        food9Price.setBounds(479, 639, 204, 25);

        food7Name.setBackground(new java.awt.Color(255, 255, 255));
        food7Name.setText("Carrot Cake");
        menuPanel.add(food7Name);
        food7Name.setBounds(19, 617, 204, 14);

        food8Name.setText("Chocolate Lava Cake");
        menuPanel.add(food8Name);
        food8Name.setBounds(249, 617, 204, 14);

        food9Name.setBackground(new java.awt.Color(255, 153, 153));
        food9Name.setText("Cocoa");
        menuPanel.add(food9Name);
        food9Name.setBounds(479, 617, 204, 14);

        food11Price.setBackground(new java.awt.Color(255, 255, 255));
        food11Price.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        food11Price.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        food11Price.setText("60฿");
        menuPanel.add(food11Price);
        food11Price.setBounds(249, 855, 204, 25);

        food10Price.setBackground(new java.awt.Color(255, 255, 255));
        food10Price.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        food10Price.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        food10Price.setText("40฿");
        menuPanel.add(food10Price);
        food10Price.setBounds(19, 855, 204, 25);

        food12Price.setBackground(new java.awt.Color(255, 255, 255));
        food12Price.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        food12Price.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        food12Price.setText("60฿");
        menuPanel.add(food12Price);
        food12Price.setBounds(479, 855, 204, 25);

        food10Name.setBackground(new java.awt.Color(255, 255, 255));
        food10Name.setText("Cold Green Tea");
        menuPanel.add(food10Name);
        food10Name.setBounds(19, 833, 204, 14);

        food11Name.setText("Cold Lime Tea");
        menuPanel.add(food11Name);
        food11Name.setBounds(249, 833, 204, 14);

        food12Name.setBackground(new java.awt.Color(255, 153, 153));
        food12Name.setText("Crape Cake");
        menuPanel.add(food12Name);
        food12Name.setBounds(479, 833, 204, 14);

        food14Price.setBackground(new java.awt.Color(255, 255, 255));
        food14Price.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        food14Price.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        food14Price.setText("60฿");
        menuPanel.add(food14Price);
        food14Price.setBounds(248, 1070, 205, 25);

        food13Price.setBackground(new java.awt.Color(255, 255, 255));
        food13Price.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        food13Price.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        food13Price.setText("50฿");
        menuPanel.add(food13Price);
        food13Price.setBounds(19, 1070, 204, 25);

        food15Price.setBackground(new java.awt.Color(255, 255, 255));
        food15Price.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        food15Price.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        food15Price.setText("120฿");
        menuPanel.add(food15Price);
        food15Price.setBounds(480, 1070, 203, 25);

        food13Name.setBackground(new java.awt.Color(255, 255, 255));
        food13Name.setText("Cream Cheese Garlic Bread");
        menuPanel.add(food13Name);
        food13Name.setBounds(19, 1048, 232, 14);

        food14Name.setText("Fudgy Brown");
        menuPanel.add(food14Name);
        food14Name.setBounds(257, 1048, 224, 14);

        food15Name.setBackground(new java.awt.Color(255, 153, 153));
        food15Name.setText("Black Spaghetti");
        menuPanel.add(food15Name);
        food15Name.setBounds(487, 1048, 224, 14);

        menuScrollPane.setViewportView(menuPanel);

        add(menuScrollPane);
        menuScrollPane.setBounds(0, 0, 720, 720);

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents
    //press pay and show payment way then kill previous order
    private void payButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payButtonActionPerformed
        contain = (JPanel) getParent();
        loginPanel = (JPanel) contain.getComponent(0);
        empIDField = (JTextField) loginPanel.getComponent(2);
        empid = Integer.valueOf(empIDField.getText());    
        
        Main main = (Main)getTopLevelAncestor();
//        main.removeAll();
        new PaymentMed(getOrderInTable(),empid,foodid,this,main).setVisible(true);
    }//GEN-LAST:event_payButtonActionPerformed

    public void setTotalLabel(JLabel totalLabel) {
        this.totalLabel = totalLabel;
    }
//press food
    private void food3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_food3ButtonActionPerformed
        foodnum3.setVisible(true);
        bin3.setVisible(true);
        
        //get food quantity
        int num = 3;
        increaseFoodNum(num);
        foodnum3.setText(String.valueOf(foodnum[num]));
        
        //insert data to table
        Food foodData = getFoodData(food3Name.getText());
        insertTable(foodData , foodnum3.getText());
        
        calPrice();
    }//GEN-LAST:event_food3ButtonActionPerformed

    private void food2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_food2ButtonActionPerformed
        foodnum2.setVisible(true);
        bin2.setVisible(true);
        
        //get food quantity
        int num = 2;
        increaseFoodNum(num);
        foodnum2.setText(String.valueOf(foodnum[num]));
        
        //insert data to table
        Food foodData = getFoodData("Seafood Creamy Omelet");
        insertTable(foodData , foodnum2.getText());
        
        calPrice();
    }//GEN-LAST:event_food2ButtonActionPerformed

    private void food5ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_food5ButtonActionPerformed
        foodnum5.setVisible(true);
        bin5.setVisible(true);
        
        //get food quantity
        int num = 5;
        increaseFoodNum(num);
        foodnum5.setText(String.valueOf(foodnum[num]));
        
        //insert data to table
        Food foodData = getFoodData(food5Name.getText());
        insertTable(foodData , foodnum5.getText());
        
        calPrice();
    }//GEN-LAST:event_food5ButtonActionPerformed

    private void food6ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_food6ButtonActionPerformed
        foodnum6.setVisible(true);
        bin6.setVisible(true);
        
        //get food quantity
        int num = 6;
        increaseFoodNum(num);
        foodnum6.setText(String.valueOf(foodnum[num]));
        
        //insert data to table
        Food foodData = getFoodData(food6Name.getText());
        insertTable(foodData , foodnum6.getText());
        
        calPrice();
    }//GEN-LAST:event_food6ButtonActionPerformed

    private void food8ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_food8ButtonActionPerformed
        foodnum8.setVisible(true);
        bin8.setVisible(true);
        
        //get food quantity
        int num = 8;
        increaseFoodNum(num);
        foodnum8.setText(String.valueOf(foodnum[num]));
        
        //insert data to table
        Food foodData = getFoodData(food8Name.getText());
        insertTable(foodData , foodnum8.getText());
        
        calPrice();
    }//GEN-LAST:event_food8ButtonActionPerformed

    private void food9ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_food9ButtonActionPerformed
        foodnum9.setVisible(true);
        bin9.setVisible(true);
        
        //get food quantity
        int num = 9;
        increaseFoodNum(num);
        foodnum9.setText(String.valueOf(foodnum[num]));
        
        //insert data to table
        Food foodData = getFoodData(food9Name.getText());
        insertTable(foodData , foodnum9.getText());
        
        calPrice();
    }//GEN-LAST:event_food9ButtonActionPerformed

    private void food11ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_food11ButtonActionPerformed
        foodnum11.setVisible(true);
        bin11.setVisible(true);
        
        //get food quantity
        int num = 11;
        increaseFoodNum(num);
        foodnum11.setText(String.valueOf(foodnum[num]));
        
        //insert data to table
        Food foodData = getFoodData(food11Name.getText());
        insertTable(foodData , foodnum11.getText());
        
        calPrice();
    }//GEN-LAST:event_food11ButtonActionPerformed

    private void food12ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_food12ButtonActionPerformed
       foodnum12.setVisible(true);
        bin12.setVisible(true);
        
        //get food quantity
        int num = 12;
        increaseFoodNum(num);
        foodnum12.setText(String.valueOf(foodnum[num]));
        
        //insert data to table
        Food foodData = getFoodData(food12Name.getText());
        insertTable(foodData , foodnum12.getText());
        
        calPrice();
    }//GEN-LAST:event_food12ButtonActionPerformed

    private void food15ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_food15ButtonActionPerformed
        foodnum15.setVisible(true);
        bin15.setVisible(true);
        
        //get food quantity
        int num = 15;
        increaseFoodNum(num);
        foodnum15.setText(String.valueOf(foodnum[num]));
        
        //insert data to table
        Food foodData = getFoodData(food15Name.getText());
        insertTable(foodData , foodnum15.getText());
        
        calPrice();
    }//GEN-LAST:event_food15ButtonActionPerformed

    private void food14ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_food14ButtonActionPerformed
        foodnum14.setVisible(true);
        bin14.setVisible(true);
        
        //get food quantity
        int num = 14;
        increaseFoodNum(num);
        foodnum14.setText(String.valueOf(foodnum[num]));
        
        //insert data to table
        Food foodData = getFoodData(food14Name.getText());
        insertTable(foodData , foodnum14.getText());
        
        calPrice();
    }//GEN-LAST:event_food14ButtonActionPerformed

    private void food13ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_food13ButtonActionPerformed
        foodnum13.setVisible(true);
        bin13.setVisible(true);
        
        //get food quantity
        int num = 13;
        increaseFoodNum(num);
        foodnum13.setText(String.valueOf(foodnum[num]));
        
        //insert data to table
        Food foodData = getFoodData(food13Name.getText());
        insertTable(foodData , foodnum13.getText());
        
        calPrice();
    }//GEN-LAST:event_food13ButtonActionPerformed

    private void food10ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_food10ButtonActionPerformed
        foodnum10.setVisible(true);
        bin10.setVisible(true);
        
        //get food quantity
        int num = 10;
        increaseFoodNum(num);
        foodnum10.setText(String.valueOf(foodnum[num]));
        
        //insert data to table
        Food foodData = getFoodData(food10Name.getText());
        insertTable(foodData , foodnum10.getText());
        
        calPrice();
    }//GEN-LAST:event_food10ButtonActionPerformed

    private void food7ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_food7ButtonActionPerformed
        foodnum7.setVisible(true);
        bin7.setVisible(true);
        
        //get food quantity
        int num = 7;
        increaseFoodNum(num);
        foodnum7.setText(String.valueOf(foodnum[num]));
        
        //insert data to table
        Food foodData = getFoodData(food7Name.getText());
        insertTable(foodData , foodnum7.getText());
        
        calPrice();
    }//GEN-LAST:event_food7ButtonActionPerformed

    private void food4ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_food4ButtonActionPerformed
        foodnum4.setVisible(true);
        bin4.setVisible(true);
        
        //get food quantity
        int num = 4;
        increaseFoodNum(num);
        foodnum4.setText(String.valueOf(foodnum[num]));
        
        //insert data to table
        Food foodData = getFoodData(food4Name.getText());
        insertTable(foodData , foodnum4.getText());
        
        calPrice();
    }//GEN-LAST:event_food4ButtonActionPerformed

    private void food1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_food1ButtonActionPerformed
        foodnum1.setVisible(true);
        bin1.setVisible(true);
        
        //get food quantity
        int num = 1;
        increaseFoodNum(num);
        foodnum1.setText(String.valueOf(foodnum[num]));
        
        //insert data to table
        Food foodData = getFoodData(food1Name.getText());
        insertTable(foodData , foodnum1.getText());
        
        calPrice();
    }//GEN-LAST:event_food1ButtonActionPerformed

    
    
    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        JPanel contain = (JPanel)getParent();
        CardLayout card = (CardLayout)contain.getLayout();
        card.show(contain,"loginPage");
        JPanel loginPage = (JPanel)contain.getComponent(0);
        JTextField inputID = (JTextField)loginPage.getComponent(2);
        JPasswordField inputPass = (JPasswordField)loginPage.getComponent(5);
        inputID.setText("");
        inputPass.setText("");
        LoginPanel login = (LoginPanel) contain.getComponent(0);
        login.getEmp().logOut(empid);
        //clear all thing in GetOrder page
        clearOrder();
    }//GEN-LAST:event_logoutButtonActionPerformed

    
    
    //press bin
    private void bin1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bin1MouseClicked
        int num = 1;
        decreaseFoodNum(num);
        foodnum1.setText(String.valueOf(foodnum[num]));
        
        Food foodData = getFoodData(food1Name.getText());
        insertTable(foodData , foodnum1.getText());
        
        calPrice();
        
        if(foodnum1.getText().equals("0")){
                foodnum1.setVisible(false);
                bin1.setVisible(false);
        }
    }//GEN-LAST:event_bin1MouseClicked

    private void bin2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bin2MouseClicked
        int num = 2;
        decreaseFoodNum(num);
        foodnum2.setText(String.valueOf(foodnum[num]));
        
        Food foodData = getFoodData(food2Name.getText());
        insertTable(foodData , foodnum2.getText());
        
        calPrice();
        
        if(foodnum2.getText().equals("0")){
                foodnum2.setVisible(false);
                bin2.setVisible(false);
        }
    }//GEN-LAST:event_bin2MouseClicked

    private void bin3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bin3MouseClicked
        int num = 3;
        decreaseFoodNum(num);
        foodnum3.setText(String.valueOf(foodnum[num]));
        
        Food foodData = getFoodData(food3Name.getText());
        insertTable(foodData , foodnum3.getText());
        
        calPrice();
        
        if(foodnum3.getText().equals("0")){
                foodnum3.setVisible(false);
                bin3.setVisible(false);
        }
    }//GEN-LAST:event_bin3MouseClicked

    private void bin4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bin4MouseClicked
        int num = 4;
        decreaseFoodNum(num);
        foodnum4.setText(String.valueOf(foodnum[num]));
        
        Food foodData = getFoodData(food4Name.getText());
        insertTable(foodData , foodnum4.getText());
        
        calPrice();
        
        if(foodnum4.getText().equals("0")){
                foodnum4.setVisible(false);
                bin4.setVisible(false);
        }
    }//GEN-LAST:event_bin4MouseClicked

    private void bin5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bin5MouseClicked
        int num = 5;
        decreaseFoodNum(num);
        foodnum5.setText(String.valueOf(foodnum[num]));
        
        Food foodData = getFoodData(food5Name.getText());
        insertTable(foodData , foodnum5.getText());
        
        calPrice();
        
        if(foodnum5.getText().equals("0")){
                foodnum5.setVisible(false);
                bin5.setVisible(false);
        }
    }//GEN-LAST:event_bin5MouseClicked

    private void bin6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bin6MouseClicked
        int num = 6;
        decreaseFoodNum(num);
        foodnum6.setText(String.valueOf(foodnum[num]));
        
        Food foodData = getFoodData(food6Name.getText());
        insertTable(foodData , foodnum6.getText());
        
        calPrice();
        
        if(foodnum6.getText().equals("0")){
                foodnum6.setVisible(false);
                bin6.setVisible(false);
        }
    }//GEN-LAST:event_bin6MouseClicked

    private void bin7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bin7MouseClicked
        int num = 7;
        decreaseFoodNum(num);
        foodnum7.setText(String.valueOf(foodnum[num]));
        
        Food foodData = getFoodData(food7Name.getText());
        insertTable(foodData , foodnum7.getText());
        
        calPrice();
        
        if(foodnum7.getText().equals("0")){
                foodnum7.setVisible(false);
                bin7.setVisible(false);
        }
    }//GEN-LAST:event_bin7MouseClicked

    private void bin8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bin8MouseClicked
        int num = 8;
        decreaseFoodNum(num);
        foodnum8.setText(String.valueOf(foodnum[num]));
        
        Food foodData = getFoodData(food8Name.getText());
        insertTable(foodData , foodnum8.getText());
        
        calPrice();
        
        if(foodnum8.getText().equals("0")){
                foodnum8.setVisible(false);
                bin8.setVisible(false);
        }
    }//GEN-LAST:event_bin8MouseClicked

    private void bin9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bin9MouseClicked
        int num = 9;
        decreaseFoodNum(num);
        foodnum9.setText(String.valueOf(foodnum[num]));
        
        Food foodData = getFoodData(food9Name.getText());
        insertTable(foodData , foodnum9.getText());
        
        calPrice();
        
        if(foodnum9.getText().equals("0")){
                foodnum9.setVisible(false);
                bin9.setVisible(false);
        }
    }//GEN-LAST:event_bin9MouseClicked

    private void bin10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bin10MouseClicked
        int num = 10;
        decreaseFoodNum(num);
        foodnum10.setText(String.valueOf(foodnum[num]));
        
        Food foodData = getFoodData(food10Name.getText());
        insertTable(foodData , foodnum10.getText());
        
        calPrice();
        
        if(foodnum10.getText().equals("0")){
                foodnum10.setVisible(false);
                bin10.setVisible(false);
        }
    }//GEN-LAST:event_bin10MouseClicked

    private void bin11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bin11MouseClicked
        int num = 11;
        decreaseFoodNum(num);
        foodnum11.setText(String.valueOf(foodnum[num]));
        
        Food foodData = getFoodData(food11Name.getText());
        insertTable(foodData , foodnum11.getText());
        
        calPrice();
        
        if(foodnum11.getText().equals("0")){
                foodnum11.setVisible(false);
                bin11.setVisible(false);
        }
    }//GEN-LAST:event_bin11MouseClicked

    private void bin12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bin12MouseClicked
        int num = 12;
        decreaseFoodNum(num);
        foodnum12.setText(String.valueOf(foodnum[num]));
        
        Food foodData = getFoodData(food12Name.getText());
        insertTable(foodData , foodnum12.getText());
        
        calPrice();
        
        if(foodnum12.getText().equals("0")){
                foodnum12.setVisible(false);
                bin12.setVisible(false);
        }
    }//GEN-LAST:event_bin12MouseClicked

    private void bin13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bin13MouseClicked
        int num = 13;
        decreaseFoodNum(num);
        foodnum13.setText(String.valueOf(foodnum[num]));
        
        Food foodData = getFoodData(food13Name.getText());
        insertTable(foodData , foodnum13.getText());
        
        calPrice();
        
        if(foodnum13.getText().equals("0")){
                foodnum13.setVisible(false);
                bin13.setVisible(false);
        }
    }//GEN-LAST:event_bin13MouseClicked

    private void bin14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bin14MouseClicked
        int num = 14;
        decreaseFoodNum(num);
        foodnum14.setText(String.valueOf(foodnum[num]));
        
        Food foodData = getFoodData(food14Name.getText());
        insertTable(foodData , foodnum14.getText());
        
        calPrice();
        
        if(foodnum14.getText().equals("0")){
                foodnum14.setVisible(false);
                bin14.setVisible(false);
        }
    }//GEN-LAST:event_bin14MouseClicked

    private void bin15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bin15MouseClicked
        int num = 15;
        decreaseFoodNum(num);
        foodnum15.setText(String.valueOf(foodnum[num]));
        
        Food foodData = getFoodData(food15Name.getText());
        insertTable(foodData , foodnum15.getText());
        
        calPrice();
        
        if(foodnum15.getText().equals("0")){
                foodnum15.setVisible(false);
                bin15.setVisible(false);
        }
    }//GEN-LAST:event_bin15MouseClicked

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        DefaultTableModel dt = (DefaultTableModel) orderTable.getModel();
        int rw = orderTable.getSelectedRow();
        //change food quantity in menu
        String r = dt.getValueAt(orderTable.getSelectedRow(),1).toString();
        String rd = dt.getValueAt(orderTable.getSelectedRow(),3).toString();
        int minus = Integer.valueOf(rd);
        int total = Integer.valueOf(orderTotalLabel.getText());
        String totalPrice = String.valueOf(total - minus);
        switch(r){
            case "Shrimp Chili Creamy Omelet":
                foodnum1.setText("0");
                orderTotalLabel.setText(totalPrice);
                foodnum[1] = 0;
                foodnum1.setVisible(false);
                bin1.setVisible(false);
                break;
            case "Seafood Creamy Omelet":
                foodnum2.setText("0");
                orderTotalLabel.setText(totalPrice);
                foodnum[2] = 0;
                foodnum2.setVisible(false);
                bin2.setVisible(false);
                break;
            case "Pad Thai Shrimp":
                foodnum3.setText("0");
                orderTotalLabel.setText(totalPrice);
                foodnum[3] = 0;
                foodnum3.setVisible(false);
                bin3.setVisible(false);
                break;
            case "Korean Instant Noodles with Onsen Egg":
                foodnum4.setText("0");
                orderTotalLabel.setText(totalPrice);
                foodnum[4] = 0;
                foodnum4.setVisible(false);
                bin4.setVisible(false);
                break;
            case "Brown Sugar Toast":
                foodnum5.setText("0");
                orderTotalLabel.setText(totalPrice);
                foodnum[5] = 0;
                foodnum5.setVisible(false);
                bin5.setVisible(false);
                break;
            case "Bubble Tea":
                foodnum6.setText("0");
                orderTotalLabel.setText(totalPrice);
                foodnum[6] = 0;
                foodnum6.setVisible(false);
                bin6.setVisible(false);
                break;
            case "Carrot Cake":
                foodnum7.setText("0");
                orderTotalLabel.setText(totalPrice);
                foodnum[7] = 0;
                foodnum7.setVisible(false);
                bin7.setVisible(false);
                break;
            case "Chocolate Lava Cake":
                foodnum8.setText("0");
                orderTotalLabel.setText(totalPrice);
                foodnum[8] = 0;
                foodnum8.setVisible(false);
                bin8.setVisible(false);
                break;
            case "Cocoa":
                foodnum9.setText("0");
                orderTotalLabel.setText(totalPrice);
                foodnum[9] = 0;
                foodnum9.setVisible(false);
                bin9.setVisible(false);
                break;
            case "Cold Green Tea":
                foodnum10.setText("0");
                orderTotalLabel.setText(totalPrice);
                foodnum[10] = 0;
                foodnum10.setVisible(false);
                bin10.setVisible(false);
                break;
            case "Cold Lime Tea":
                foodnum11.setText("0");
                orderTotalLabel.setText(totalPrice);
                foodnum[11] = 0;
                foodnum11.setVisible(false);
                bin11.setVisible(false);
                break;
            case "Crape Cake":
                foodnum12.setText("0");
                orderTotalLabel.setText(totalPrice);
                foodnum[12] = 0;
                foodnum12.setVisible(false);
                bin12.setVisible(false);
                break;
            case "Cream Cheese Garlic Bread":
                foodnum13.setText("0");
                orderTotalLabel.setText(totalPrice);
                foodnum[13] = 0;
                foodnum13.setVisible(false);
                bin13.setVisible(false);
                break;
            case "Fudgy Brown":
                foodnum14.setText("0");
                orderTotalLabel.setText(totalPrice);
                foodnum[14] = 0;
                foodnum14.setVisible(false);
                bin14.setVisible(false);
                break;
            case "Black Spaghetti":
                foodnum15.setText("0");
                orderTotalLabel.setText(totalPrice);
                foodnum[15] = 0;
                foodnum15.setVisible(false);
                bin15.setVisible(false);
                break;
        }
        
        dt.removeRow(rw);
    }//GEN-LAST:event_deleteButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel bin1;
    private static javax.swing.JLabel bin10;
    private static javax.swing.JLabel bin11;
    private static javax.swing.JLabel bin12;
    private static javax.swing.JLabel bin13;
    private static javax.swing.JLabel bin14;
    private static javax.swing.JLabel bin15;
    private static javax.swing.JLabel bin2;
    private static javax.swing.JLabel bin3;
    private static javax.swing.JLabel bin4;
    private static javax.swing.JLabel bin5;
    private static javax.swing.JLabel bin6;
    private static javax.swing.JLabel bin7;
    private static javax.swing.JLabel bin8;
    private static javax.swing.JLabel bin9;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel employeeNameLabel;
    private javax.swing.JButton food10Button;
    private javax.swing.JLabel food10Name;
    private javax.swing.JLabel food10Price;
    private javax.swing.JButton food11Button;
    private javax.swing.JLabel food11Name;
    private javax.swing.JLabel food11Price;
    private javax.swing.JButton food12Button;
    private javax.swing.JLabel food12Name;
    private javax.swing.JLabel food12Price;
    private javax.swing.JButton food13Button;
    private javax.swing.JLabel food13Name;
    private javax.swing.JLabel food13Price;
    private javax.swing.JButton food14Button;
    private javax.swing.JLabel food14Name;
    private javax.swing.JLabel food14Price;
    private javax.swing.JButton food15Button;
    private javax.swing.JLabel food15Name;
    private javax.swing.JLabel food15Price;
    private javax.swing.JButton food1Button;
    private javax.swing.JLabel food1Name;
    private javax.swing.JLabel food1Price;
    private javax.swing.JButton food2Button;
    private javax.swing.JLabel food2Name;
    private javax.swing.JLabel food2Price;
    private javax.swing.JButton food3Button;
    private javax.swing.JLabel food3Name;
    private javax.swing.JLabel food3Price;
    private javax.swing.JButton food4Button;
    private javax.swing.JLabel food4Name;
    private javax.swing.JLabel food4Price;
    private javax.swing.JButton food5Button;
    private javax.swing.JLabel food5Name;
    private javax.swing.JLabel food5Price;
    private javax.swing.JButton food6Button;
    private javax.swing.JLabel food6Name;
    private javax.swing.JLabel food6Price;
    private javax.swing.JButton food7Button;
    private javax.swing.JLabel food7Name;
    private javax.swing.JLabel food7Price;
    private javax.swing.JButton food8Button;
    private javax.swing.JLabel food8Name;
    private javax.swing.JLabel food8Price;
    private javax.swing.JButton food9Button;
    private javax.swing.JLabel food9Name;
    private javax.swing.JLabel food9Price;
    private static javax.swing.JLabel foodnum1;
    private static javax.swing.JLabel foodnum10;
    private static javax.swing.JLabel foodnum11;
    private static javax.swing.JLabel foodnum12;
    private static javax.swing.JLabel foodnum13;
    private static javax.swing.JLabel foodnum14;
    private static javax.swing.JLabel foodnum15;
    private static javax.swing.JLabel foodnum2;
    private static javax.swing.JLabel foodnum3;
    private static javax.swing.JLabel foodnum4;
    private static javax.swing.JLabel foodnum5;
    private static javax.swing.JLabel foodnum6;
    private static javax.swing.JLabel foodnum7;
    private static javax.swing.JLabel foodnum8;
    private static javax.swing.JLabel foodnum9;
    private javax.swing.JButton logoutButton;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JScrollPane menuScrollPane;
    private javax.swing.JPanel orderPanel;
    private static javax.swing.JTable orderTable;
    private static javax.swing.JLabel orderTotalLabel;
    private javax.swing.JButton payButton;
    private javax.swing.JScrollPane showOrderScrollPane;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
}
