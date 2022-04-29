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
import model.WorkQueue.AnimalManagerRequest;

/**
 *
 * @author anitachen
 */
public class ManageAnimalJPanel extends javax.swing.JPanel {

    private JPanel workArea;
    private AnimalShelterEnterprise enterprise;
    private AnimalDirectory animalDirectory;
    private AnimalManagementOrganization organization;
    private UserAccount userAccount;
    private Network network;
    private EcoSystem ecosystem;
    
    public ManageAnimalJPanel(JPanel userProcessContainer, UserAccount account, AnimalManagementOrganization animalManagerOrganization, AnimalShelterEnterprise animalShelterEnterprise, Network network, EcoSystem ecosystem) {
        initComponents();
        
        this.workArea = userProcessContainer;
        this.network = network;
        this.ecosystem = ecosystem;
        this.enterprise = animalShelterEnterprise;
        this.organization = animalManagerOrganization;
        this.userAccount = account;
        this.animalDirectory = enterprise.getAnimalDirectory();
        
        populateAssignAnimalToMeRequestTable();
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
        lblTitle = new javax.swing.JLabel();
        btnViewDetial = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        tblAnimalManagerWorkArea.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Message", "ID", "Name", "Registor", "Manager", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAnimalManagerWorkArea);

        btnAssignAnimalToMe.setText("Assign to me");
        btnAssignAnimalToMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignAnimalToMeActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setText("Manage Animal");

        btnViewDetial.setText("View Animal Detail");
        btnViewDetial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblTitle)
                            .addGap(0, 566, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnAssignAnimalToMe)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnViewDetial))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblTitle)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAssignAnimalToMe)
                    .addComponent(btnViewDetial))
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignAnimalToMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignAnimalToMeActionPerformed
        
        int selectedRow = tblAnimalManagerWorkArea.getSelectedRow();

        if (selectedRow >= 0) {
            WorkRequest request = (WorkRequest) tblAnimalManagerWorkArea.getValueAt(selectedRow, 0);
            if (request.getStatus().equalsIgnoreCase("Adopted")) {
                JOptionPane.showMessageDialog(null, "This animal has been adopted.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                if (request.getReceiver() != null) {
                    JOptionPane.showMessageDialog(null, "This animal has a manager. Please select another one.", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                } else {
                    //把自己變成reciver, 把animal的manager變成自己
                    request.setReceiver(userAccount);
                    request.getAnimal().setManager(userAccount);
                    request.setStatus("Managed");
                    userAccount.getWorkQueue().getWorkRequestList().add(request);
                    populateAssignAnimalToMeRequestTable();
                    JOptionPane.showMessageDialog(null, "Animal assigned to you.","Information",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Select a row to process.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }


    }//GEN-LAST:event_btnAssignAnimalToMeActionPerformed

    private void btnViewDetialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetialActionPerformed
        
        
        int selectedRow = tblAnimalManagerWorkArea.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row first");
            return;
        }
        
        WorkRequest wr = (WorkRequest) tblAnimalManagerWorkArea.getValueAt(selectedRow, 0);
        if (wr.getReceiver() != userAccount) {
            JOptionPane.showMessageDialog(null, "This animal is not assigned to you.");
            return;
        }
        
        if (wr.getAnimal().getAdoptor() != null){
            JOptionPane.showMessageDialog(null, "This animal is adopted.");
            return;
        }
        
        AnimalManagerRequest request = (AnimalManagerRequest) wr;
        ViewOngingAnimalJPanel viewOngoingAnimalJPanel = new ViewOngingAnimalJPanel(workArea, userAccount, request.getAnimal(), enterprise, network);
        workArea.add("viewOngoingAnimalJPanel", viewOngoingAnimalJPanel);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.next(workArea);
        
    }//GEN-LAST:event_btnViewDetialActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssignAnimalToMe;
    private javax.swing.JButton btnViewDetial;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblAnimalManagerWorkArea;
    // End of variables declaration//GEN-END:variables

    public void populateAssignAnimalToMeRequestTable(){
        DefaultTableModel model = (DefaultTableModel) tblAnimalManagerWorkArea.getModel();
        
        model.setRowCount(0);
        
        for (WorkRequest request : enterprise.getWorkQueue().getWorkRequestList()){
            if (request instanceof AnimalManagerRequest){
                Object[] row = new Object[6];
                row[0] = request;
                row[1] = request.getAnimal().getId();
                row[2] = request.getAnimal();
                row[3] = request.getSender();
                row[4] = request.getReceiver() == null ? null : request.getReceiver();
                row[5] = request.getStatus();

                model.addRow(row);
            }            
        }
    }
}
