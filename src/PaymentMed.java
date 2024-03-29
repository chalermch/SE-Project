
import java.awt.CardLayout;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import teletubies.Order;
import teletubies.Payment;
import teletubies.database.DatabaseHandler;
import teletubies.model.EmployeeDB;
import teletubies.model.SaleOrderDB;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author acer
 */
public class PaymentMed extends javax.swing.JFrame {

    /**
     * Creates new form PaymentMed
     */
    private Order order;
    private int empid;
    private ArrayList <Integer> foodid;
    private GetOrder gO;
//    private Main m;
    
    public PaymentMed() {
        initComponents();
        
    }
    
    public PaymentMed(Order order , int empid , ArrayList <Integer> foodid,GetOrder gO,Main m) {
        this.order= order;
        this.empid =empid;
        this.foodid = foodid;
        this.gO = gO;
//        this.m = m;
        initComponents();
        TotalPayment.setText("total payment : "+(int)order.getTotalPrice());
        qrTotalpayment.setText("total payment : "+(int)order.getTotalPrice());
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paymentPanel = new javax.swing.JPanel();
        paymentSelect = new javax.swing.JPanel();
        cashPaymentSelect = new javax.swing.JLabel();
        qrPaymentSelect = new javax.swing.JLabel();
        cashImgPaymentSelect = new javax.swing.JLabel();
        qrImgPaymentSelect = new javax.swing.JLabel();
        titlePaymentSelect = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cashPanel = new javax.swing.JPanel();
        TotalPayment = new javax.swing.JLabel();
        showPanelNumber = new javax.swing.JTextField();
        totalPaymentPayButton = new javax.swing.JButton();
        number7 = new javax.swing.JLabel();
        number8 = new javax.swing.JLabel();
        number9 = new javax.swing.JLabel();
        number4 = new javax.swing.JLabel();
        number5 = new javax.swing.JLabel();
        number6 = new javax.swing.JLabel();
        number2 = new javax.swing.JLabel();
        number1 = new javax.swing.JLabel();
        number3 = new javax.swing.JLabel();
        number0 = new javax.swing.JLabel();
        totalPaymentBackspace = new javax.swing.JLabel();
        totalPaymentAC = new javax.swing.JLabel();
        qrPanel = new javax.swing.JPanel();
        qrPayment = new javax.swing.JLabel();
        qrTotalpayment = new javax.swing.JLabel();
        doneButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Teletubbies Cafe");
        setResizable(false);

        paymentPanel.setBackground(new java.awt.Color(255, 255, 255));
        paymentPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
        paymentPanel.setPreferredSize(new java.awt.Dimension(800, 650));
        paymentPanel.setLayout(null);

        paymentSelect.setBackground(new java.awt.Color(250, 250, 250));

        cashPaymentSelect.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        cashPaymentSelect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cashPaymentSelect.setText("Cash");

        qrPaymentSelect.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        qrPaymentSelect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        qrPaymentSelect.setText("QR Payment");

        cashImgPaymentSelect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cash.png"))); // NOI18N
        cashImgPaymentSelect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cashImgPaymentSelectMouseClicked(evt);
            }
        });

        qrImgPaymentSelect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/qrpay.png"))); // NOI18N
        qrImgPaymentSelect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                qrImgPaymentSelectMouseClicked(evt);
            }
        });

        titlePaymentSelect.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titlePaymentSelect.setForeground(new java.awt.Color(0, 102, 255));
        titlePaymentSelect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titlePaymentSelect.setText("Payment Select");

        javax.swing.GroupLayout paymentSelectLayout = new javax.swing.GroupLayout(paymentSelect);
        paymentSelect.setLayout(paymentSelectLayout);
        paymentSelectLayout.setHorizontalGroup(
            paymentSelectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentSelectLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(paymentSelectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(qrImgPaymentSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cashImgPaymentSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(qrPaymentSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cashPaymentSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(43, Short.MAX_VALUE))
            .addComponent(titlePaymentSelect, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        paymentSelectLayout.setVerticalGroup(
            paymentSelectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentSelectLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(titlePaymentSelect)
                .addGap(35, 35, 35)
                .addComponent(cashImgPaymentSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 124, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cashPaymentSelect)
                .addGap(28, 28, 28)
                .addComponent(qrImgPaymentSelect)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(qrPaymentSelect)
                .addGap(122, 122, 122))
        );

        paymentPanel.add(paymentSelect);
        paymentSelect.setBounds(23, 22, 244, 612);

        jPanel1.setPreferredSize(new java.awt.Dimension(490, 604));
        jPanel1.setLayout(new java.awt.CardLayout());

        cashPanel.setBackground(new java.awt.Color(250, 250, 250));

        TotalPayment.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TotalPayment.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TotalPayment.setText("total payment : 00");

        showPanelNumber.setEditable(false);
        showPanelNumber.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        showPanelNumber.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        showPanelNumber.setText("0");
        showPanelNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPanelNumberActionPerformed(evt);
            }
        });

        totalPaymentPayButton.setBackground(new java.awt.Color(0, 102, 255));
        totalPaymentPayButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        totalPaymentPayButton.setForeground(new java.awt.Color(255, 255, 255));
        totalPaymentPayButton.setText("Pay");
        totalPaymentPayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalPaymentPayButtonActionPerformed(evt);
            }
        });

        number7.setBackground(new java.awt.Color(255, 255, 255));
        number7.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        number7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        number7.setText("7");
        number7.setBorder(new javax.swing.border.MatteBorder(null));
        number7.setOpaque(true);
        number7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                number7MouseClicked(evt);
            }
        });

        number8.setBackground(new java.awt.Color(255, 255, 255));
        number8.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        number8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        number8.setText("8");
        number8.setBorder(new javax.swing.border.MatteBorder(null));
        number8.setOpaque(true);
        number8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                number8MouseClicked(evt);
            }
        });

        number9.setBackground(new java.awt.Color(255, 255, 255));
        number9.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        number9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        number9.setText("9");
        number9.setBorder(new javax.swing.border.MatteBorder(null));
        number9.setOpaque(true);
        number9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                number9MouseClicked(evt);
            }
        });

        number4.setBackground(new java.awt.Color(255, 255, 255));
        number4.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        number4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        number4.setText("4");
        number4.setBorder(new javax.swing.border.MatteBorder(null));
        number4.setOpaque(true);
        number4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                number4MouseClicked(evt);
            }
        });

        number5.setBackground(new java.awt.Color(255, 255, 255));
        number5.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        number5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        number5.setText("5");
        number5.setBorder(new javax.swing.border.MatteBorder(null));
        number5.setOpaque(true);
        number5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                number5MouseClicked(evt);
            }
        });

        number6.setBackground(new java.awt.Color(255, 255, 255));
        number6.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        number6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        number6.setText("6");
        number6.setBorder(new javax.swing.border.MatteBorder(null));
        number6.setOpaque(true);
        number6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                number6MouseClicked(evt);
            }
        });

        number2.setBackground(new java.awt.Color(255, 255, 255));
        number2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        number2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        number2.setText("2");
        number2.setBorder(new javax.swing.border.MatteBorder(null));
        number2.setOpaque(true);
        number2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                number2MouseClicked(evt);
            }
        });

        number1.setBackground(new java.awt.Color(255, 255, 255));
        number1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        number1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        number1.setText("1");
        number1.setBorder(new javax.swing.border.MatteBorder(null));
        number1.setOpaque(true);
        number1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                number1MouseClicked(evt);
            }
        });

        number3.setBackground(new java.awt.Color(255, 255, 255));
        number3.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        number3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        number3.setText("3");
        number3.setBorder(new javax.swing.border.MatteBorder(null));
        number3.setOpaque(true);
        number3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                number3MouseClicked(evt);
            }
        });

        number0.setBackground(new java.awt.Color(255, 255, 255));
        number0.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        number0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        number0.setText("0");
        number0.setBorder(new javax.swing.border.MatteBorder(null));
        number0.setOpaque(true);
        number0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                number0MouseClicked(evt);
            }
        });

        totalPaymentBackspace.setBackground(new java.awt.Color(255, 255, 255));
        totalPaymentBackspace.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        totalPaymentBackspace.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalPaymentBackspace.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/left-arrow.png"))); // NOI18N
        totalPaymentBackspace.setBorder(new javax.swing.border.MatteBorder(null));
        totalPaymentBackspace.setOpaque(true);
        totalPaymentBackspace.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                totalPaymentBackspaceMouseClicked(evt);
            }
        });

        totalPaymentAC.setBackground(new java.awt.Color(255, 255, 255));
        totalPaymentAC.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        totalPaymentAC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalPaymentAC.setText("AC");
        totalPaymentAC.setBorder(new javax.swing.border.MatteBorder(null));
        totalPaymentAC.setOpaque(true);
        totalPaymentAC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                totalPaymentACMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout cashPanelLayout = new javax.swing.GroupLayout(cashPanel);
        cashPanel.setLayout(cashPanelLayout);
        cashPanelLayout.setHorizontalGroup(
            cashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cashPanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(cashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cashPanelLayout.createSequentialGroup()
                        .addComponent(number7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(number8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(number9, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(totalPaymentPayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(cashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TotalPayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(showPanelNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(cashPanelLayout.createSequentialGroup()
                        .addComponent(number4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(number5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(number6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cashPanelLayout.createSequentialGroup()
                        .addComponent(number1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(number2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(number3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cashPanelLayout.createSequentialGroup()
                        .addComponent(totalPaymentAC, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(number0, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalPaymentBackspace, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        cashPanelLayout.setVerticalGroup(
            cashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cashPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(TotalPayment)
                .addGap(18, 18, 18)
                .addComponent(showPanelNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(number7, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(number8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(number9, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(number4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(number5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(number6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(number1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(number2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(number3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cashPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(totalPaymentAC, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(number0, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(totalPaymentBackspace, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(totalPaymentPayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(cashPanel, "card2");

        qrPanel.setBackground(new java.awt.Color(250, 250, 250));

        qrPayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/myQR.png"))); // NOI18N

        qrTotalpayment.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        qrTotalpayment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        qrTotalpayment.setText("total payment : 00");

        doneButton.setBackground(new java.awt.Color(204, 204, 204));
        doneButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        doneButton.setText("Done");
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout qrPanelLayout = new javax.swing.GroupLayout(qrPanel);
        qrPanel.setLayout(qrPanelLayout);
        qrPanelLayout.setHorizontalGroup(
            qrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, qrPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(qrTotalpayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(qrPanelLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(qrPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 72, Short.MAX_VALUE))
            .addGroup(qrPanelLayout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(doneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        qrPanelLayout.setVerticalGroup(
            qrPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qrPanelLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(qrPayment)
                .addGap(18, 18, 18)
                .addComponent(qrTotalpayment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(doneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel1.add(qrPanel, "card3");

        paymentPanel.add(jPanel1);
        jPanel1.setBounds(290, 20, 490, 604);

        getContentPane().add(paymentPanel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void showPanelNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPanelNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showPanelNumberActionPerformed

    private void totalPaymentPayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalPaymentPayButtonActionPerformed
        try {
            Payment pay = new Payment(order);
            order.setOrderStatus();
            double change = Double.parseDouble(showPanelNumber.getText());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.ENGLISH);
            Date date = new Date();
            if (Double.parseDouble(showPanelNumber.getText())  - order.getTotalPrice() >= 0  ){
                pay.setPaymentStatus();
            } else {
                JOptionPane.showMessageDialog(null, "Not Enough Money!","Alert",JOptionPane.ERROR_MESSAGE);
                showPanelNumber.setText("0");
            }
             if (pay.getPaymentStatus()){
                //add Order to Kitchen for chef
                KitchenWindow.addOrder(order);
                for(int i = 0;i < foodid.size();i++){
                             DatabaseHandler.insertOrder(new DatabaseHandler(),new SaleOrderDB(order.getOrderID(),order.getOrderQuantity().get(i),order.getTotalPrice(),order.getOrderStatus(),foodid.get(i),empid,Double.parseDouble(showPanelNumber.getText()),"cash",dateFormat.format(date)));
                 }
                EmployeeDB emp = DatabaseHandler.findEmployeeById(new DatabaseHandler(), empid);
                
                //add order into QueueCustomerPanel
                QueueCustomerPanel.addCookingTable(order);
                //add into Exchange Panel and open Exchange
                new Exchange(emp,pay,change,gO).setVisible(true);
                
                GetOrder.plusOrder();
                //destroy panel
                dispose();
             }
        } 
        catch (Exception ex) {
            ex.printStackTrace();
            return;
        } 
    }//GEN-LAST:event_totalPaymentPayButtonActionPerformed

    private void cashImgPaymentSelectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cashImgPaymentSelectMouseClicked
        CardLayout card = (CardLayout)jPanel1.getLayout();
        card.show(jPanel1,"card2");
    }//GEN-LAST:event_cashImgPaymentSelectMouseClicked

    private void qrImgPaymentSelectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qrImgPaymentSelectMouseClicked
       CardLayout card = (CardLayout)jPanel1.getLayout();
        card.show(jPanel1,"card3");
    }//GEN-LAST:event_qrImgPaymentSelectMouseClicked

    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButtonActionPerformed
         try {   
            Payment pay = new Payment(order);
            order.setOrderStatus();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.ENGLISH);
            Date date = new Date();
            for(int i = 0;i < foodid.size();i++){
                if (pay.getPaymentStatus()){
                    //add Order to Kitchen for chef
                    KitchenWindow.addOrder(order);
                    DatabaseHandler.insertOrder(new DatabaseHandler(),new SaleOrderDB(order.getOrderID(),order.getOrderQuantity().get(i),order.getTotalPrice(),order.getOrderStatus(),foodid.get(i),empid,Double.parseDouble(showPanelNumber.getText()),"cash",dateFormat.format(date)));
                }
            }
            //add order into KitchenWindow
            KitchenWindow.addOrder(order);
            //add order into QueueCustomerPanel
            QueueCustomerPanel.addCookingTable(order);
            //add into database
            EmployeeDB emp = DatabaseHandler.findEmployeeById(new DatabaseHandler(), empid);
            //print bill
            new Receipt(emp.getFirstName() + " " + emp.getLastName(),pay,gO).setVisible(true);
            //order plus one;
            GetOrder.plusOrder();
            //destroy panel
            dispose();
        } 
        catch (Exception ex) {
            ex.printStackTrace();
            return;
        } 
    }//GEN-LAST:event_doneButtonActionPerformed

    private void number1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_number1MouseClicked
        String s = showPanelNumber.getText();
        String num = "1";
        if (s.equals("0")){
            showPanelNumber.setText(num);
        } else {
            showPanelNumber.setText(s+num); 
        }
    }//GEN-LAST:event_number1MouseClicked

    private void number2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_number2MouseClicked
        String s = showPanelNumber.getText();
        String num = "2";
        if (s.equals("0")){
            showPanelNumber.setText(num);
        } else {
            showPanelNumber.setText(s+num); 
        }
    }//GEN-LAST:event_number2MouseClicked

    private void number3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_number3MouseClicked
        String s = showPanelNumber.getText();
        String num = "3";
        if (s.equals("0")){
            showPanelNumber.setText(num);
        } else {
            showPanelNumber.setText(s+num); 
        }
    }//GEN-LAST:event_number3MouseClicked

    private void number4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_number4MouseClicked
        String s = showPanelNumber.getText();
        String num = "4";
        if (s.equals("0")){
            showPanelNumber.setText(num);
        } else {
            showPanelNumber.setText(s+num); 
        }
    }//GEN-LAST:event_number4MouseClicked

    private void number5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_number5MouseClicked
        String s = showPanelNumber.getText();
        String num = "5";
        if (s.equals("0")){
            showPanelNumber.setText(num);
        } else {
            showPanelNumber.setText(s+num); 
        }
    }//GEN-LAST:event_number5MouseClicked

    private void number6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_number6MouseClicked
        String s = showPanelNumber.getText();
        String num = "6";
        if (s.equals("0")){
            showPanelNumber.setText(num);
        } else {
            showPanelNumber.setText(s+num); 
        }
    }//GEN-LAST:event_number6MouseClicked

    private void number7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_number7MouseClicked
        String s = showPanelNumber.getText();
        String num = "7";
        if (s.equals("0")){
            showPanelNumber.setText(num);
        } else {
            showPanelNumber.setText(s+num); 
        }
    }//GEN-LAST:event_number7MouseClicked

    private void number8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_number8MouseClicked
        String s = showPanelNumber.getText();
        String num = "8";
        if (s.equals("0")){
            showPanelNumber.setText(num);
        } else {
            showPanelNumber.setText(s+num); 
        }
    }//GEN-LAST:event_number8MouseClicked

    private void number9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_number9MouseClicked
        String s = showPanelNumber.getText();
        String num = "9";
        if (s.equals("0")){
            showPanelNumber.setText(num);
        } else {
            showPanelNumber.setText(s+num); 
        }
    }//GEN-LAST:event_number9MouseClicked

    private void number0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_number0MouseClicked
        String s = showPanelNumber.getText();
        String num = "0";
        if (s.equals("0")){
            showPanelNumber.setText(num);
        } else {
            showPanelNumber.setText(s+num); 
        }
    }//GEN-LAST:event_number0MouseClicked

    private void totalPaymentBackspaceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_totalPaymentBackspaceMouseClicked
        String s = showPanelNumber.getText();
        if (s.length() == 1 && !s.equals("0")){
            showPanelNumber.setText("0");    
        }
        else if (!s.equals("0")){
            showPanelNumber.setText(s.substring(0, s.length() - 1));        
        } 
    }//GEN-LAST:event_totalPaymentBackspaceMouseClicked

    private void totalPaymentACMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_totalPaymentACMouseClicked
       showPanelNumber.setText("0");   
    }//GEN-LAST:event_totalPaymentACMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PaymentMed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentMed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentMed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentMed.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaymentMed().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TotalPayment;
    private javax.swing.JLabel cashImgPaymentSelect;
    private javax.swing.JPanel cashPanel;
    private javax.swing.JLabel cashPaymentSelect;
    private javax.swing.JButton doneButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel number0;
    private javax.swing.JLabel number1;
    private javax.swing.JLabel number2;
    private javax.swing.JLabel number3;
    private javax.swing.JLabel number4;
    private javax.swing.JLabel number5;
    private javax.swing.JLabel number6;
    private javax.swing.JLabel number7;
    private javax.swing.JLabel number8;
    private javax.swing.JLabel number9;
    private javax.swing.JPanel paymentPanel;
    private javax.swing.JPanel paymentSelect;
    private javax.swing.JLabel qrImgPaymentSelect;
    private javax.swing.JPanel qrPanel;
    private javax.swing.JLabel qrPayment;
    private javax.swing.JLabel qrPaymentSelect;
    private javax.swing.JLabel qrTotalpayment;
    private javax.swing.JTextField showPanelNumber;
    private javax.swing.JLabel titlePaymentSelect;
    private javax.swing.JLabel totalPaymentAC;
    private javax.swing.JLabel totalPaymentBackspace;
    private javax.swing.JButton totalPaymentPayButton;
    // End of variables declaration//GEN-END:variables
}
