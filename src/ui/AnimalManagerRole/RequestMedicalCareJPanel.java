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
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRequestVet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icon_send.png"))); // NOI18N
        btnRequestVet.setText("Request Vet");
        btnRequestVet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestVetActionPerformed(evt);
            }
        });
        add(btnRequestVet, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 193, -1, -1));

        lblMessage.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblMessage.setText("Message:");
        add(lblMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 117, -1, -1));
        add(txtSendMedicalCareMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 149, 217, -1));

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 33, -1, -1));

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setText("Send Medical Care Request to Vet");
        add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 38, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnRequestVetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestVetActionPerformed
        
        String requestVetMessage = txtSendMedicalCareMessage.getText();
        if(requestVetMessage.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please enter something to send.","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        MedCareRequest request = new MedCareRequest();
        request.setMessage(requestVetMessage);
        request.setSender(account);
        request.setStatus("Pending for Vet");
        request.setAnimal(animal);
        
        network.getWorkQueue().getWorkRequestList().add(request);
        animal.getWorkQueue().getWorkRequestList().add(request);
        
        JOptionPane.showMessageDialog(this, "Medical Request sent","Information",JOptionPane.INFORMATION_MESSAGE);
        txtSendMedicalCareMessage.setText("");
        
    }//GEN-LAST:event_btnRequestVetActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        
        workArea.remove(this);
        Component[] componentArray = workArea.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ViewOngingAnimalJPanel voajp = (ViewOngingAnimalJPanel) component;
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
