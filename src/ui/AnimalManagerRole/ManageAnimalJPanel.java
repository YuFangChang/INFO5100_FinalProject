/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.AnimalManagerRole;


import model.UserAccount.UserAccount;
import model.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.Animal.Animal;
import model.Animal.AnimalDirectory;
import model.EcoSystem.EcoSystem;
import model.Enterprise.AnimalShelterEnterprise;
import model.Enterprise.Enterprise;
import model.Network.Network;
import model.Organization.AnimalManagementOrganization;
import model.Organization.Organization;

/**
 *
 * @author raunak
 */
public class ManageAnimalJPanel extends javax.swing.JPanel {

    private JPanel workArea;
    private AnimalShelterEnterprise enterprise;
    private AnimalDirectory animalDirectory = enterprise.getAnimalDirectory();
    private Organization organization;
    private UserAccount userAccount;
    
    public ManageAnimalJPanel(JPanel userProcessContainer, UserAccount account , AnimalShelterEnterprise enterprise) {
        initComponents();
        
        this.workArea = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = account;
        
        populateAssingAnimalToMeRequestTable();
    }

    
    public void populateAssingAnimalToMeRequestTable(){
        DefaultTableModel model = (DefaultTableModel) tblAnimalManagerWorkArea.getModel();
        
        model.setRowCount(0);
        
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[4];
            row[0] = request.getAnimal().getId();
            row[1] = request.getAnimal().getName();
            row[2] = request.getSender().getName();
            row[3] = request.getReceiver() == null ? null : request.getReceiver().getName();
            row[4] = request.getStatus();

            model.addRow(row);
        }
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblAnimalManagerWorkArea = new javax.swing.JTable();
        btnAssignAnimalToMe = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        tblAnimalManagerWorkArea.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Registor", "Manager", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAnimalManagerWorkArea);
        if (tblAnimalManagerWorkArea.getColumnModel().getColumnCount() > 0) {
            tblAnimalManagerWorkArea.getColumnModel().getColumn(0).setResizable(false);
            tblAnimalManagerWorkArea.getColumnModel().getColumn(1).setResizable(false);
            tblAnimalManagerWorkArea.getColumnModel().getColumn(2).setResizable(false);
            tblAnimalManagerWorkArea.getColumnModel().getColumn(3).setResizable(false);
            tblAnimalManagerWorkArea.getColumnModel().getColumn(4).setResizable(false);
        }

        btnAssignAnimalToMe.setText("Assign to me");
        btnAssignAnimalToMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignAnimalToMeActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setText("Manage Animal");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(lblTitle)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRefresh))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAssignAnimalToMe))
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnRefresh))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAssignAnimalToMe)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignAnimalToMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignAnimalToMeActionPerformed
        
        int selectedRow = tblAnimalManagerWorkArea.getSelectedRow();

        if (selectedRow >= 0) {
            WorkRequest request = (WorkRequest) tblAnimalManagerWorkArea.getValueAt(selectedRow, 0);
            if (request.getMessage().equalsIgnoreCase("Completed")) {
                JOptionPane.showMessageDialog(null, "Request already processed.");
                return;
            } else {
                //把自己變成reciver, 把animal的manager變成自己
                request.setReceiver(userAccount);
                request.getAnimal().setManager(userAccount);
                request.setStatus("Pending");
                populateAssingAnimalToMeRequestTable();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Choose a reuest to process.");
            return;
        }
        
        
    }//GEN-LAST:event_btnAssignAnimalToMeActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed

        populateAssingAnimalToMeRequestTable();
        
    }//GEN-LAST:event_btnRefreshActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssignAnimalToMe;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblAnimalManagerWorkArea;
    // End of variables declaration//GEN-END:variables
}
