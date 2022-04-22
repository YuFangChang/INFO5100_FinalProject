/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.AnimalRegistorRole;

import ui.AnimalRegistorRole.*;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.EcoSystem.EcoSystem;
import model.Enterprise.AnimalShelterEnterprise;
import model.Enterprise.Enterprise;
import model.Network.Network;
import model.Organization.AnimalRegisterOrganization;
import model.Organization.Organization;
import model.Organization.VolunteerOrganization;
import model.UserAccount.UserAccount;
import model.WorkQueue.VolunteerRequest;
import model.WorkQueue.WorkRequest;
import ui.AnimalManagerRole.ManageAnimalJPanel;

/**
 *
 * @author raunak
 */
public class RequestVolunteerJPanel extends javax.swing.JPanel {

        private JPanel workArea;
        private UserAccount account;
        private AnimalRegisterOrganization organization;
        private AnimalShelterEnterprise enterprise;
        private Network network;
        private EcoSystem ecosystem;
    

    public RequestVolunteerJPanel(JPanel userProcessContainer, UserAccount account, AnimalRegisterOrganization animalRegisterOrganization, AnimalShelterEnterprise animalShelterEnterprise, Network network, EcoSystem ecosystem) {
        initComponents();

        this.workArea = workArea;
        this.account = account;
        this.organization = organization;
        this.enterprise = enterprise;
        this.network = network;
        this.ecosystem = ecosystem;
        
        populateVolunteerRequestTable();
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRequestVolunteer = new javax.swing.JButton();
        lblMessage = new javax.swing.JLabel();
        txtRequestVolunteerMessage = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSentVolunteerRequest = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        btnRequestVolunteer.setText("Request");
        btnRequestVolunteer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestVolunteerActionPerformed(evt);
            }
        });

        lblMessage.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblMessage.setText("Message:");

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setText("Send Volunteer Request");

        tblSentVolunteerRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Message", "Sender", "Volunteer Manager", "Volunteer Assigned", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblSentVolunteerRequest);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnBack)
                        .addGap(18, 18, 18)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRequestVolunteer)
                            .addComponent(lblMessage)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtRequestVolunteerMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(lblTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtRequestVolunteerMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRequestVolunteer)
                .addGap(137, 137, 137))
        );
    }// </editor-fold>//GEN-END:initComponents
    public void populateVolunteerRequestTable(){
        DefaultTableModel model = (DefaultTableModel) tblSentVolunteerRequest.getModel();
        
        model.setRowCount(0);
        
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
            if (request instanceof VolunteerRequest){
            Object[] row = new Object[4];
            row[0] = request.getMessage();
            row[1] = request.getSender();
            row[2] = request.getReceiver();
            row[3] = ((VolunteerRequest) request).getAssignedVolunteer() == null ? null : ((VolunteerRequest) request).getAssignedVolunteer().getName();
            row[4] = request.getStatus();

            model.addRow(row);
            }
        }
    }
    
    private void btnRequestVolunteerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestVolunteerActionPerformed

        String requestVolunteerMessage = txtRequestVolunteerMessage.getText();
        if(requestVolunteerMessage.equals("") || requestVolunteerMessage.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter something to send.");
            return;
        }
        VolunteerRequest request = new VolunteerRequest();
        request.setMessage(requestVolunteerMessage);
        request.setSender(account);
        request.setStatus("Sent");
        
        Organization org = null;
        for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof VolunteerOrganization){
                org = organization;
                break;
            }
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
            account.getWorkQueue().getWorkRequestList().add(request);
        }
        
        JOptionPane.showMessageDialog(null, "Request message sent");
        txtRequestVolunteerMessage.setText("");
        
    }//GEN-LAST:event_btnRequestVolunteerActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        
        workArea.remove(this);
        Component[] componentArray = workArea.getComponents();
        Component component = componentArray[componentArray.length - 1];
        AnimalRegistorWorkAreaJPanel arwajp = (AnimalRegistorWorkAreaJPanel) component;
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.previous(workArea);


    }//GEN-LAST:event_btnBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRequestVolunteer;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblSentVolunteerRequest;
    private javax.swing.JTextField txtRequestVolunteerMessage;
    // End of variables declaration//GEN-END:variables
}
