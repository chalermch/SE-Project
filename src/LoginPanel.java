
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import teletubies.Employee;
import teletubies.database.DatabaseHandler;
import teletubies.model.EmployeeDB;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
/**
 *
 * @author Hall_PC
 */
public class LoginPanel extends javax.swing.JPanel {

    /**
     * Creates new form Login
     */
    private Employee empLog;

    public LoginPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        textUsername = new javax.swing.JLabel();
        textinputUser = new javax.swing.JTextField();
        textPassword = new javax.swing.JLabel();
        LoginBtn = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        title.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        title.setText("Teletubbies");
        title.setToolTipText("");
        title.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(title);
        title.setBounds(440, 80, 270, 130);

        textUsername.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        textUsername.setForeground(new java.awt.Color(51, 153, 255));
        textUsername.setText("Username");
        add(textUsername);
        textUsername.setBounds(440, 230, 90, 30);

        textinputUser.setEditable(false);
        textinputUser.setForeground(new java.awt.Color(153, 153, 153));
        textinputUser.setText("Username");
        textinputUser.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textinputUser.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        textinputUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textBoxClicked(evt);
            }
        });
        textinputUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textinputUserActionPerformed(evt);
            }
        });
        add(textinputUser);
        textinputUser.setBounds(440, 270, 270, 50);

        textPassword.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        textPassword.setForeground(new java.awt.Color(0, 153, 255));
        textPassword.setText("Password");
        add(textPassword);
        textPassword.setBounds(440, 340, 90, 30);

        LoginBtn.setBackground(new java.awt.Color(0, 102, 255));
        LoginBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LoginBtn.setForeground(new java.awt.Color(255, 255, 255));
        LoginBtn.setText("Login");
        LoginBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        LoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBtnActionPerformed(evt);
            }
        });
        add(LoginBtn);
        LoginBtn.setBounds(500, 480, 145, 46);

        jPasswordField1.setEditable(false);
        jPasswordField1.setForeground(new java.awt.Color(153, 153, 153));
        jPasswordField1.setText("jPassw");
        jPasswordField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordField1MouseClicked(evt);
            }
        });
        add(jPasswordField1);
        jPasswordField1.setBounds(440, 380, 270, 50);
    }// </editor-fold>//GEN-END:initComponents

    private void textinputUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textinputUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textinputUserActionPerformed

    private void LoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBtnActionPerformed
        try {
            int empID = Integer.parseInt(textinputUser.getText());
            String empPass = String.valueOf(jPasswordField1.getPassword());
            JPanel contain = (JPanel) getParent();
            CardLayout card = (CardLayout) contain.getLayout();
            empLog = new Employee();
            switch (empLog.logIn(empID, empPass)) {
                case 1:
                    card.show(contain, "orderPage");
                    try {
                        EmployeeDB emp = DatabaseHandler.findEmployeeById(new DatabaseHandler(), empID);

                        JPanel get = (JPanel) getParent();
                        JPanel orderPanel = (JPanel) get.getComponent(6);
                        JPanel tablePanel = (JPanel) orderPanel.getComponent(0);
                        JLabel name = (JLabel) tablePanel.getComponent(0);
                        name.setText(emp.getFirstName() + " " + emp.getLastName());
                    } 
                    catch (Exception e) {
                        System.out.print(e);
                    }
                    break;
                case 3:
                    card.show(contain, "managerPage");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Wrong ID or Password", "Error", JOptionPane.ERROR_MESSAGE);
                    break;

            }
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Wrong ID or Password", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_LoginBtnActionPerformed

    public Employee getEmp() {
        return empLog;
    }

    private void textBoxClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textBoxClicked
        textinputUser.setText("");
        textinputUser.setEditable(true);
        textinputUser.setForeground(Color.black);
    }//GEN-LAST:event_textBoxClicked

    private void jPasswordField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField1MouseClicked
        jPasswordField1.setText("");
        jPasswordField1.setEditable(true);
        jPasswordField1.setForeground(Color.black);
    }//GEN-LAST:event_jPasswordField1MouseClicked

    public JTextField getTextinputUser() {
        return textinputUser;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginBtn;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JLabel textPassword;
    private javax.swing.JLabel textUsername;
    private javax.swing.JTextField textinputUser;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}