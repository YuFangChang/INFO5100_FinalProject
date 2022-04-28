/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.AnimalManagerRole;


import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Animal.Animal;
import model.EcoSystem.EcoSystem;
import model.Enterprise.AnimalShelterEnterprise;
import model.Enterprise.Enterprise;
import model.Network.Network;
import model.Organization.Organization;
import model.Organization.VetOrganization;
import model.UserAccount.UserAccount;
import model.WorkQueue.MedCareRequest;

/**
 *
 * @author raunak
 */
public class RequestMedicalCareJPanel extends javax.swing.JPanel {

    private JPanel workArea;
    private UserAccount account;
    private Enterprise enterprise;
    private Network network;
    private Animal animal;
    
    public RequestMedicalCareJPanel(JPanel workArea, UserAccount account, AnimalShelterEnterprise enterprise, Network network, Animal animal) {
        initComponents();
        
        this.workArea = workArea;
        this.account = account;
        this.enterprise = enterprise;
        this.network = network;
        this.animal = animal;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRequestVet = new javax.swing.JButton();
        lblMessage = new javax.swing.JLabel();
        txtSendMedicalCareMessage = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        btnRequestVet.setText("Request Vet");
        btnRequestVet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestVetActionPerformed(evt);
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
        lblTitle.setText("Send Medical Care Request to Vet");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRequestVet)
                    .addComponent(lblMessage)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(18, 18, 18)
                        .addComponent(lblTitle))
                    .addComponent(txtSendMedicalCareMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(446, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(lblTitle))
                .addGap(55, 55, 55)
                .addComponent(lblMessage)
                .addGap(18, 18, 18)
                .addComponent(txtSendMedicalCareMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRequestVet)
                .addContainerGap(293, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRequestVetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestVetActionPerformed

        
        String requestVetMessage = txtSendMedicalCareMessage.getText();
        if(requestVetMessage.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter something to send.");
            return;
        }
        
        MedCareRequest request = new MedCareRequest();
        request.setMessage(requestVetMessage);
        request.setSender(account);
        request.setStatus("Pending for Vet");
        request.setAnimal(animal);
        
        network.getWorkQueue().getWorkRequestList().add(request);
        animal.getWorkQueue().getWorkRequestList().add(request);
        
        JOptionPane.showMessageDialog(null, "Medical Request sent");
        txtSendMedicalCareMessage.setText("");
        
//        Organization org = null;
//        for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
//            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
//            if (organization instanceof VetOrganization){
//                org = organization;
//                break;
//            }
//            }
//        }
//        if (org!=null){
//            org.getWorkQueue().getWorkRequestList().add(request);
//            account.getWorkQueue().getWorkRequestList().add(request);
//        }
//        
//        JOptionPane.showMessageDialog(null, "Request message sent");
//        txtSendMedicalCareMessage.setText("");
        
    }//GEN-LAST:event_btnRequestVetActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        
        workArea.remove(this);
        Component[] componentArray = workArea.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ManageAnimalJPanel dwjp = (ManageAnimalJPanel) component;
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.previous(workArea);


    }//GEN-LAST:event_btnBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRequestVet;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtSendMedicalCareMessage;
    // End of variables declaration//GEN-END:variables
}
