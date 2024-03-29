
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import teletubies.database.DatabaseHandler;
import teletubies.model.EmployeeDB;
import teletubies.model.EmployeeReport;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
/**
 *
 * @author Hall_PC
 */
public class ReportEmpPanel extends javax.swing.JPanel {

    /**
     * Creates new form ReportEmpPanel
     */
    public ReportEmpPanel() {
        initComponents();
        ReportEmpGen();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reportEmpTitleLabel = new javax.swing.JLabel();
        CookingTableScrollPane = new javax.swing.JScrollPane();
        cookingTable = new javax.swing.JTable();

        setLayout(null);

        reportEmpTitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        reportEmpTitleLabel.setText("Report_Employee");
        add(reportEmpTitleLabel);
        reportEmpTitleLabel.setBounds(440, 10, 420, 80);

        cookingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "emp ID", "FirstName", "Lastname", "Phone Number", "Address", "Level of Work", "Login TimeStamp", "Logout TimeStamp"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        cookingTable.setAlignmentX(-10.0F);
        cookingTable.setGridColor(new java.awt.Color(0, 102, 255));
        cookingTable.setRowHeight(40);
        cookingTable.setRowMargin(5);
        CookingTableScrollPane.setViewportView(cookingTable);

        add(CookingTableScrollPane);
        CookingTableScrollPane.setBounds(40, 110, 1180, 550);
    }// </editor-fold>//GEN-END:initComponents

    //Show report employee on gui
    public void ReportEmpGen() {
        DefaultTableModel empModel = (DefaultTableModel) cookingTable.getModel();
        try {
            ArrayList<EmployeeReport> employeeReportDBs = DatabaseHandler.findAllReportEmployee(new DatabaseHandler());
            int length = employeeReportDBs.size();
            if (length > 0) {
                for (int i = 0; i < length; i++) {
                    empModel.addRow(new Object[]{employeeReportDBs.get(i).getEmployeeID(),
                        employeeReportDBs.get(i).getFirstName(),
                        employeeReportDBs.get(i).getLastName(),
                        employeeReportDBs.get(i).getPhoneNumber(),
                        employeeReportDBs.get(i).getAddress(),
                        employeeReportDBs.get(i).getEmployeelevel(),
                        employeeReportDBs.get(i).getDateLogIn(),
                        employeeReportDBs.get(i).getDateLogOut()});
                }
            }
        } catch (Exception e) {
            System.err.println("Error!");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane CookingTableScrollPane;
    private javax.swing.JTable cookingTable;
    private javax.swing.JLabel reportEmpTitleLabel;
    // End of variables declaration//GEN-END:variables
}
