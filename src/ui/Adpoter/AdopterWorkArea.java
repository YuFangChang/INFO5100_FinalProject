/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Adpoter;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.Animal.Animal;
import model.EcoSystem.EcoSystem;
import model.Enterprise.AdoptionEnterprise;
import model.Enterprise.AnimalShelterEnterprise;
import model.Enterprise.Enterprise;
import model.Network.Network;
import model.Organization.AdopterOrganization;
import model.Organization.Organization;
import model.UserAccount.UserAccount;
import model.WorkQueue.AdoptionRequest;
import model.WorkQueue.WorkRequest;

/**
 *
 * @author anitachen
 */
public class AdopterWorkArea extends javax.swing.JPanel {

    private JPanel workArea;
    private AdopterOrganization organization;
    private AdoptionEnterprise enterprise;
    private Network network;
    private EcoSystem ecosystem;
    private UserAccount userAccount;
    
    /**
     * Creates new form AdopterWorkArea
     */
    public AdopterWorkArea(JPanel userProcessContainer, UserAccount account, AdopterOrganization organization, AdoptionEnterprise enterprise, Network network, EcoSystem ecosystem) {
        initComponents();
        
        this.workArea = userProcessContainer;
        this.userAccount = account;
        this.organization = organization;
        this.enterprise = enterprise;
        this.network = network;
        this.ecosystem = ecosystem;
        
        String status = userAccount.getWorkQueue().getWorkRequestList().get(0).getStatus();
        txtAuthorizationStatus.setText(status);
        
        if (!txtAuthorizationStatus.getText().equalsIgnoreCase("Approved")){
            hideInfo();
            return;
        }
        
        populateAnimalTable();
        populateRequestTable();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAuthorizationStatus = new javax.swing.JLabel();
        txtAuthorizationStatus = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAnimalList = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        lblAnimalSelection = new javax.swing.JLabel();
        btnViewDetails = new javax.swing.JButton();
        btnSendRequest = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        lblAdoptionRequest = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAdoptionRequests = new javax.swing.JTable();

        lblAuthorizationStatus.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblAuthorizationStatus.setText("Authorization Status:");

        tblAnimalList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Name", "Sex", "Area", "Manager", "Animal Shelter"
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
        jScrollPane1.setViewportView(tblAnimalList);

        lblAnimalSelection.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblAnimalSelection.setText("Animal Selection");

        btnViewDetails.setText("View Animal Details");
        btnViewDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetailsActionPerformed(evt);
            }
        });

        btnSendRequest.setText("Send Adoption Request");
        btnSendRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendRequestActionPerformed(evt);
            }
        });

        lblAdoptionRequest.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblAdoptionRequest.setText("Your Adoption Request");

        tblAdoptionRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Manager", "Enterprise", "Status"
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
        jScrollPane2.setViewportView(tblAdoptionRequests);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAdoptionRequest)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnViewDetails)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnSendRequest))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAnimalSelection)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblAuthorizationStatus)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtAuthorizationStatus)
                                            .addGap(346, 346, 346))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAuthorizationStatus)
                    .addComponent(txtAuthorizationStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblAnimalSelection)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSendRequest)
                    .addComponent(btnViewDetails))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblAdoptionRequest)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendRequestActionPerformed

        int selectedRow = tblAnimalList.getSelectedRow();

        if (selectedRow >= 0) {
            
            Animal selectedAnimal = (Animal) tblAnimalList.getValueAt(selectedRow, 0);
            AdoptionRequest request = new AdoptionRequest();
            request.setMessage("Adoption Request");
            request.setAnimal(selectedAnimal);
            request.setSender(userAccount);
            request.setStatus("Pending Review");
            
            selectedAnimal.getManager().getWorkQueue().getWorkRequestList().add(request);
            userAccount.getWorkQueue().getWorkRequestList().add(request);           
            
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row first", "Warning", JOptionPane.WARNING_MESSAGE);
        }
                
        
    }//GEN-LAST:event_btnSendRequestActionPerformed

    private void btnViewDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetailsActionPerformed

        int selectedRow = tblAnimalList.getSelectedRow();
        
        if (selectedRow >= 0) {
            Animal selectedAnimal = (Animal) tblAnimalList.getValueAt(selectedRow, 0);
            
//            JPanel animalDetail = new MainScreen(mainWorkArea, ua, db4oUtil);
//            workArea.add("MainScreen", mainScreen);
//            CardLayout layout = (CardLayout) workArea.getLayout();
//            layout.next(workArea);
            
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row first", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        

    }//GEN-LAST:event_btnViewDetailsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSendRequest;
    private javax.swing.JButton btnViewDetails;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblAdoptionRequest;
    private javax.swing.JLabel lblAnimalSelection;
    private javax.swing.JLabel lblAuthorizationStatus;
    private javax.swing.JTable tblAdoptionRequests;
    private javax.swing.JTable tblAnimalList;
    private javax.swing.JTextField txtAuthorizationStatus;
    // End of variables declaration//GEN-END:variables

    private void hideInfo() {
        jSeparator1.setVisible(false);
        lblAnimalSelection.setVisible(false);
        jScrollPane1.setVisible(false);
        tblAnimalList.setVisible(false);
        btnSendRequest.setVisible(false);
        btnViewDetails.setVisible(false);
        jSeparator2.setVisible(false);
        lblAdoptionRequest.setVisible(false);
        jScrollPane2.setVisible(false);
        tblAdoptionRequests.setVisible(false);
    }

    private void populateAnimalTable() {

        DefaultTableModel model = (DefaultTableModel) tblAnimalList.getModel();
        model.setRowCount(0);
        
        for (Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()) {
            if (e instanceof AnimalShelterEnterprise){
                for (Animal a : ((AnimalShelterEnterprise) e).getAnimalDirectory().getAnimalList()){
                    if (a.getAdoptor() == null && a.getManager() != null){
                        
                        Object[] row = new Object[5];
                        row[0] = a;
                        row[1] = a.getSex();
                        row[2] = a.getArea();
                        row[3] = a.getManager();
                        row[4] = a.getManager().getEnterprise();

                        model.addRow(row);
                    }        
                }
            }
        }     
    }

    private void populateRequestTable() {

        DefaultTableModel model = (DefaultTableModel) tblAdoptionRequests.getModel();
        model.setRowCount(0);
        
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()){
            if (request instanceof AdoptionRequest){
                
                Object[] row = new Object[5];
                row[0] = request.getAnimal().getId();
                row[1] = request.getAnimal().getName();
                row[2] = request.getAnimal().getManager();
                row[3] = request.getAnimal().getManager().getEnterprise();
                row[4] = request.getStatus();
                
                model.addRow(row);
            }
        }
    }
}

