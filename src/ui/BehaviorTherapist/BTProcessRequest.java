/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.BehaviorTherapist;

import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Animal.Animal;
import model.Animal.AnimalDirectory;
import model.EcoSystem.EcoSystem;
import model.Enterprise.Enterprise;
import model.Network.Network;
import model.Organization.Organization;
import model.Organization.TreatmentOrganization;
import model.Role.BehaviorTherapistRole;
import model.Role.Role;
import model.UserAccount.UserAccount;
import model.WorkQueue.MedCareRequest;
import model.WorkQueue.BTWorkRequest;
import ui.BehaviorTherapist.BTWorkArea;

/**
 *
 * @author ariel
 */
public class BTProcessRequest extends javax.swing.JPanel {

   private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private EcoSystem ecoSystem;
    BTWorkRequest request;
    private Animal animal;
    private AnimalDirectory animalDirectory;
    Network network;

    /**
     * Creates new form ProcessWorkRequestJPanel
     */
    public BTProcessRequest(JPanel userProcessContainer, BTWorkRequest request, UserAccount userAccount, Enterprise enterprise,
            Animal animal, AnimalDirectory animalDirectory, EcoSystem ecoSystem, TreatmentOrganization treatmentOrganization) {
        initComponents();
          this.userProcessContainer = userProcessContainer;
        this.request = request;
        this.userAccount = userAccount;
        this.enterprise = enterprise;
        this.animal = animal;
        this.animalDirectory = animalDirectory;
        this.ecoSystem = ecoSystem;
        for (Network net : ecoSystem.getNetworkList()) {
            for (Enterprise ent : net.getEnterpriseDirectory().getEnterpriseList()) {
                if (ent.equals(enterprise)) {
                    network = net;
                }
            }
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

        btnBack = new javax.swing.JButton();
        txtResults = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        lblResult = new javax.swing.JLabel();

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        txtResults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtResultsActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setText("Result Submission");

        btnSubmit.setText("Submit Result");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        lblResult.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblResult.setText("Result:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(359, 359, 359)
                        .addComponent(lblTitle)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 266, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblResult)
                        .addGap(239, 239, 239))
                    .addComponent(btnSubmit, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtResults, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(255, 255, 255))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addGap(14, 14, 14)
                .addComponent(lblTitle)
                .addGap(33, 33, 33)
                .addComponent(lblResult)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtResults, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSubmit)
                .addContainerGap(389, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        if (txtResults.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter message");
        } else {
            request.setResult(txtResults.getText());
            request.setStatus("Delivered");
            MedCareRequest temp = new MedCareRequest();
            temp.setStatus("Medically Fit");
            temp.setMessage("Child has been medicated");
            temp.setSender(userAccount);
            temp.setVetResult("completed");
            temp.getAnimal().setId(request.getAnimal().getId());
            temp.getAnimal().setName(request.getAnimal().getName());
            if (this.animalDirectory != null && this.animalDirectory.getAnimalList().size() > 0) {
                for (Animal animal : this.animalDirectory.getAnimalList()) {
                    /**          if (request.getAnimal().getId() == animal.getId()) {
                        if ("Acquired".equalsIgnoreCase(temp.getStatus())) {
                            //  animal.setMedicalHelp(false);
                            temp.setIsAcquiredReq(false);
                        } else {
                            temp.setIsAcquiredReq(true);
                        }
                        break;
                    }     **/
                }
            }
            Organization org = null;
            for (Network network : ecoSystem.getNetworkList()) {
                for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {
                    for (Organization organization : ent.getOrganizationDirectory().getOrganizationList()) {
                        Role role = null;
                        if (organization instanceof TreatmentOrganization && role instanceof BehaviorTherapistRole) {
                            org = organization;
                            break;
                        }
                    }
                }
            }
            if (org != null) {
                enterprise.getWorkQueue().getWorkRequestList().add(temp);
                userAccount.getWorkQueue().getWorkRequestList().add(temp);
                //    ecoSystem.getWorkQueue().getWorkRequestList().add(temp);
            }
        }
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        BTWorkArea panel = (BTWorkArea) component;
        panel.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void txtResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtResultsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtResultsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel lblResult;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtResults;
    // End of variables declaration//GEN-END:variables
}
