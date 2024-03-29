
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import teletubies.Order;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zucrem
 */
public class CustomerOrderPanel extends javax.swing.JPanel {

    /**
     * Creates new form OrderPanel
     */
    public CustomerOrderPanel() {
        initComponents();
    }

    public CustomerOrderPanel(Order order) {
        this.orderid = order.getOrderID();
        this.foodname = order.getOrderFoodName();
        this.qty = order.getOrderQuantity();
        initComponents();
        setOrder();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        orderPanel1 = new javax.swing.JPanel();
        orderNumberLabel = new javax.swing.JLabel();
        buttonDone = new javax.swing.JButton();

        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0));

        orderPanel1.setBackground(new java.awt.Color(204, 204, 204));
        orderPanel1.setPreferredSize(new java.awt.Dimension(300, 200));

        orderNumberLabel.setBackground(new java.awt.Color(255, 204, 204));
        orderNumberLabel.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        orderNumberLabel.setText("#0001");

        buttonDone.setBackground(new java.awt.Color(0, 102, 255));
        buttonDone.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        buttonDone.setForeground(new java.awt.Color(255, 255, 255));
        buttonDone.setText("Finish #0001");
        buttonDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout orderPanel1Layout = new javax.swing.GroupLayout(orderPanel1);
        orderPanel1.setLayout(orderPanel1Layout);
        orderPanel1Layout.setHorizontalGroup(
            orderPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonDone, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(orderPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(orderPanel1Layout.createSequentialGroup()
                    .addGap(70, 85, Short.MAX_VALUE)
                    .addComponent(orderNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 75, Short.MAX_VALUE)))
        );
        orderPanel1Layout.setVerticalGroup(
            orderPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, orderPanel1Layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addComponent(buttonDone, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(orderPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(orderPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(orderNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 120, Short.MAX_VALUE)))
        );

        add(orderPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDoneActionPerformed
        removeAll();
        revalidate();
        repaint();
        QueueCustomerPanel.removeFinishedTable(orderid);
    }//GEN-LAST:event_buttonDoneActionPerformed

    private void setOrder(){
        String id = String.format("%04d", orderid);
        orderNumberLabel.setText("#"+id);
        buttonDone.setText("Finish #"+id);
        GetOrder.clearOrder();
    }
    
    private int orderid;
    private List<String> foodname;    
    private List<Integer> qty;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDone;
    private javax.swing.JLabel orderNumberLabel;
    private javax.swing.JPanel orderPanel1;
    // End of variables declaration//GEN-END:variables
}
