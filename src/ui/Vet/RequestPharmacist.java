package ui.Vet;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Image;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.WorkQueue.PharmacistWorkRequest;
import model.UserAccount.UserAccount;
import model.Animal.AnimalDirectory;
import model.Animal.Animal;
import model.Network.Network;
import model.Enterprise.Enterprise;
import model.EcoSystem.EcoSystem;
import model.Organization.Organization;
import model.Organization.TreatmentOrganization;
import model.Organization.VetOrganization;
import model.WorkQueue.MedCareRequest;
import model.WorkQueue.WorkRequest;

/**
 *
 * @author ariel
 */
public class RequestPharmacist extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private EcoSystem ecoSystem;
    private MedCareRequest request;
    private AnimalDirectory animalDirectory;
    private Animal animal;
    Network network;

    /**
     * Creates new form RequestLabTestJPanel
     */
    public RequestPharmacist(JPanel userProcessContainer, MedCareRequest request, UserAccount userAccount,
            Enterprise enterprise, Animal animal, AnimalDirectory animalDirectory, EcoSystem ecoSystem) {

        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        this.userAccount = userAccount;
        this.enterprise = enterprise;
        this.animal = animal;
        this.animalDirectory = animalDirectory;
        this.ecoSystem = ecoSystem;
        for (Network net : ecoSystem.getNetworkList()) {
            for (Enterprise e : net.getEnterpriseDirectory().getEnterpriseList()) {
                if (e.equals(enterprise)) {
                    network = net;
                }
            }
        }

        populatePtTable();
    }

    public void populatePtTable() {
        
        DefaultTableModel model = (DefaultTableModel) tblWorkRequests.getModel();
        model.setRowCount(0);
        for (WorkRequest phrequest : userAccount.getWorkQueue().getWorkRequestList()) {
            if (phrequest instanceof MedCareRequest || phrequest instanceof PharmacistWorkRequest) {
                if (phrequest.getAnimal().getId() == animal.getId()) {
                    Object[] row = new Object[model.getColumnCount()];
                    row[0] = phrequest;
                    row[1] = phrequest.getAnimal().getId();
                    row[2] = phrequest.getReceiver();
                    row[3] = phrequest.getStatus();
                    if (phrequest instanceof MedCareRequest) {
                        String result = ((MedCareRequest) phrequest).getVetResult();
                        row[4] = result == null ? "Waiting" : result;
                    } else if (phrequest instanceof PharmacistWorkRequest) {
                        String result = ((PharmacistWorkRequest) phrequest).getResult();
                        row[4] = result == null ? "Waiting" : result;
                    }
                    model.addRow(row);
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

        btnRequestTest = new javax.swing.JButton();
        lblMessage = new javax.swing.JLabel();
        txtMessage = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblWorkRequests = new javax.swing.JTable();
        icon = new javax.swing.JLabel();
        lblMessageTitle = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRequestTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icon_send.png"))); // NOI18N
        btnRequestTest.setText("Request");
        btnRequestTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestTestActionPerformed(evt);
            }
        });
        add(btnRequestTest, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 455, -1, -1));

        lblMessage.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblMessage.setText("Message: ");
        add(lblMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, -1, -1));
        add(txtMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, 400, 40));

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitle.setText("Request Pharmaceutical Therapy");
        add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, -1, -1));

        tblWorkRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Message", "Animal ID", "Recipient", "Status", "Result"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(tblWorkRequests);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 890, 250));

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icon_vet2Ph.png"))); // NOI18N
        add(icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, -1, -1));

        lblMessageTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblMessageTitle.setText("Create New Request");
        add(lblMessageTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnRequestTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestTestActionPerformed

          String message = txtMessage.getText();
        if (message.equals("") || message.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter something to send.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        PharmacistWorkRequest request = new PharmacistWorkRequest();
        request.setMessage(message);
        request.setSender(userAccount);
        request.setStatus("Pending");
        request.setAnimal(animal);

        network.getWorkQueue().getWorkRequestList().add(request);
        userAccount.getWorkQueue().getWorkRequestList().add(request);

        JOptionPane.showMessageDialog(this, "Pharmaceutical Therapy Request sent","Information",JOptionPane.INFORMATION_MESSAGE);
        populatePtTable();
        txtMessage.setText("");
        /**
         * userProcessContainer.remove(this); Component[] componentArray =
         * userProcessContainer.getComponents(); Component component =
         * componentArray[componentArray.length - 1]; VetAnimalDetail panel =
         * (VetAnimalDetail) component; CardLayout layout = (CardLayout)
         * userProcessContainer.getLayout();
         * layout.previous(userProcessContainer); populatePtTable();
*
         */
    }//GEN-LAST:event_btnRequestTestActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

    }//GEN-LAST:event_btnBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRequestTest;
    private javax.swing.JLabel icon;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblMessageTitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblWorkRequests;
    private javax.swing.JTextField txtMessage;
    // End of variables declaration//GEN-END:variables
}
