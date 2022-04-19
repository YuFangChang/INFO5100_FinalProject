/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.AnimalRegistorRole;

import model.EcoSystem.EcoSystem;
import model.UserAccount.UserAccount;
import model.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.Enterprise.AnimalShelterEnterprise;
import model.Network.Network;
import model.Organization.AnimalRegisterOrganization;

/**
 *
 * @author raunak
 */
public class AnimalRegistorWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel workArea;
    private AnimalRegisterOrganization organization;
    private EcoSystem ecoSystem;
    private UserAccount userAccount;
    
    
    public AnimalRegistorWorkAreaJPanel(JPanel workArea, UserAccount account, AnimalRegisterOrganization organization, EcoSystem ecoSystem) {
        initComponents();
        
        this.workArea = workArea;
        this.organization = organization;
        this.ecoSystem = ecoSystem;
        this.userAccount = account;
        
        
    }


    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        requestVolunteerJButton = new javax.swing.JButton();
        registerAnimalJButton = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        requestVolunteerJButton.setText("Request Volunteer");
        requestVolunteerJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestVolunteerJButtonActionPerformed(evt);
            }
        });

        registerAnimalJButton.setText("Register Animal");
        registerAnimalJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerAnimalJButtonActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setText("Animal Registor Work Area");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(requestVolunteerJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerAnimalJButton)
                    .addComponent(lblTitle))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblTitle)
                .addGap(31, 31, 31)
                .addComponent(registerAnimalJButton)
                .addGap(18, 18, 18)
                .addComponent(requestVolunteerJButton)
                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 287, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 33, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 33, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 258, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 26, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 27, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void requestVolunteerJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestVolunteerJButtonActionPerformed

        RequestVolunteerJPanel requestVolunteerJPanel = new RequestVolunteerJPanel();
        workArea.add("requestVolunteerJPanel", workArea);

        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.next(workArea);

    }//GEN-LAST:event_requestVolunteerJButtonActionPerformed

    private void registerAnimalJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerAnimalJButtonActionPerformed

        RegistorAnimalJPanel registorAnimalJPanel = new RegistorAnimalJPanel(workArea, userAccount);
        workArea.add("registorAnimalJPanel", registorAnimalJPanel);
        
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.next(workArea);
    }//GEN-LAST:event_registerAnimalJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JButton registerAnimalJButton;
    private javax.swing.JButton requestVolunteerJButton;
    // End of variables declaration//GEN-END:variables
}
