package ui.Basic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import model.Network.Network;
import model.Enterprise.Enterprise;
import model.Organization.Organization;
import model.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.EcoSystem.DB4OUtil;
import model.EcoSystem.EcoSystem;
import model.Enterprise.AdoptionEnterprise;
import model.Organization.AdopterOrganization;
import model.Role.AdopterRole;
import model.WorkQueue.AdopterAuthorizationRequest;

/**
 *
 * @author anitachen
 */
public class LoginScreen extends javax.swing.JPanel {
    JPanel mainWorkArea;
    EcoSystem ecoSystem;
    DB4OUtil db4oUtil;

    
    
    public LoginScreen(JPanel mainWorkArea, EcoSystem ecoSystem, DB4OUtil dB4OUtil) {
        initComponents();
        this.mainWorkArea = mainWorkArea;
        this.ecoSystem = ecoSystem;
        this.db4oUtil = dB4OUtil;
        
        populateNetworkCombo();
        populateEnterpriseCombo();
        populateOrganizationCombo();
        
//        System.out.println(ecoSystem.getSystemAdmin().getUsername());
//        System.out.println(ecoSystem.getSystemAdmin().getPassword());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblLogIn = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        pwdPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        jSeparator = new javax.swing.JSeparator();
        lblRegister = new javax.swing.JLabel();
        lblNewUserName = new javax.swing.JLabel();
        txtNewUserName = new javax.swing.JTextField();
        lblNewPassword = new javax.swing.JLabel();
        pwdNewPassword = new javax.swing.JPasswordField();
        lblName = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        lblNetwork = new javax.swing.JLabel();
        cmbNetworkList = new javax.swing.JComboBox();
        lblEnterprise = new javax.swing.JLabel();
        cmbEnterpriseList = new javax.swing.JComboBox();
        lblEnterprise1 = new javax.swing.JLabel();
        cmbOrganizationList = new javax.swing.JComboBox();
        txtName = new javax.swing.JTextField();
        lblLogin2 = new javax.swing.JLabel();
        lblRegister1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(254, 236, 236));

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icon_title.png"))); // NOI18N

        lblLogIn.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblLogIn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogIn.setText("Log In");

        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUser.setText("Username:");

        lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPassword.setText("Password:");

        btnLogin.setBackground(new java.awt.Color(0, 102, 153));
        btnLogin.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lblRegister.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblRegister.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegister.setText("Register as Adoptor");

        lblNewUserName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNewUserName.setText("Username:");

        lblNewPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNewPassword.setText("Password:");

        lblName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblName.setText("Name:");

        btnRegister.setBackground(new java.awt.Color(0, 102, 0));
        btnRegister.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(233, 233, 233));
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        lblNetwork.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNetwork.setText("Network:");

        cmbNetworkList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblEnterprise.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEnterprise.setText("Enterprise:");

        cmbEnterpriseList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbEnterpriseList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEnterpriseListActionPerformed(evt);
            }
        });

        lblEnterprise1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblEnterprise1.setText("Organization:");

        cmbOrganizationList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbOrganizationList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrganizationListActionPerformed(evt);
            }
        });

        lblLogin2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icon_login.png"))); // NOI18N

        lblRegister1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblRegister1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegister1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icon_adopt.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lblEnterprise)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbEnterpriseList, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lblNewUserName)
                                .addGap(18, 18, 18)
                                .addComponent(txtNewUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(btnRegister))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblName)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNewPassword)
                                        .addGap(18, 18, 18)
                                        .addComponent(pwdNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblRegister1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addComponent(lblNetwork)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cmbNetworkList, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(lblEnterprise1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbOrganizationList, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(78, 78, 78)
                .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUser)
                        .addGap(25, 25, 25)
                        .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPassword)
                        .addGap(27, 27, 27)
                        .addComponent(pwdPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lblLogin2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmbEnterpriseList, cmbNetworkList, cmbOrganizationList});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {pwdNewPassword, txtName, txtNewUserName});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitle)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblLogin2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(lblLogIn)
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(lblUser))
                                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPassword)
                                    .addComponent(pwdPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(btnLogin))
                            .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(lblRegister1)
                        .addGap(18, 18, 18)
                        .addComponent(lblRegister)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbNetworkList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNetwork))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEnterprise)
                            .addComponent(cmbEnterpriseList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEnterprise1)
                            .addComponent(cmbOrganizationList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(lblNewUserName))
                            .addComponent(txtNewUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(lblNewPassword))
                            .addComponent(pwdNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblName))
                        .addGap(18, 18, 18)
                        .addComponent(btnRegister))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        
//        JPanel mainScreen = new MainScreen(mainWorkArea, ecoSystem);
//        mainWorkArea.add("MainScreen", mainScreen);
//        CardLayout layout = (CardLayout) mainWorkArea.getLayout();
//        layout.next(mainWorkArea);
        
        // Get userName
        String userName = txtUserName.getText();
       
        // Get Password
        char[] passwordCharArray = pwdPassword.getPassword();
        String password = String.valueOf(passwordCharArray);
//        boolean flag = false;

        if (userName.equals(ecoSystem.getSystemAdmin().getUsername()) &&
            password.equals(ecoSystem.getSystemAdmin().getPassword())) {
            JPanel mainScreen = new MainScreen(mainWorkArea, ecoSystem.getSystemAdmin(), ecoSystem, db4oUtil);
            mainWorkArea.add("MainScreen", mainScreen);
            CardLayout layout = (CardLayout) mainWorkArea.getLayout();
            layout.next(mainWorkArea);
        } else  {
            
            for (UserAccount ua : ecoSystem.getUserAccountDirectory().getUserAccountList()){
                if (userName.equals(ua.getUsername()) && password.equals(ua.getPassword())) {
                    JPanel mainScreen = new MainScreen(mainWorkArea, ua, db4oUtil);
                    mainWorkArea.add("MainScreen", mainScreen);
                    CardLayout layout = (CardLayout) mainWorkArea.getLayout();
                    layout.next(mainWorkArea);
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Invalid login.", "Warning", JOptionPane.WARNING_MESSAGE);
        } 
//        
//        else {
//            JOptionPane.showMessageDialog(this, "Invalid login.", "Warning", JOptionPane.WARNING_MESSAGE);            
//        }

//
//        UserAccount userAccount = null;
//
//        for (Organization organization : ecoSystem.getOrganizationDirectory().getOrganizationList()){
//            userAccount = organization.getUserAccountDirectory().authenticateUser(userName, password);
//            if (userAccount != null){
//
//                JPanel mainScreen = new ui.Basic.MainScreen(mainWorkArea, userAccount, organization, enterprise, network,ecoSystem);
//                mainWorkArea.add("MainScreen", mainScreen);
//                CardLayout layout = (CardLayout) mainWorkArea.getLayout();
//                layout.next(mainWorkArea);
//
//                flag = true;
//                break;
//            }
//        }
//
//        if (flag == false) {
//            JOptionPane.showMessageDialog(null, "Invalid User Name/ Password.");
//            return;
//        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        
        Network selectedNetwork = (Network) cmbNetworkList.getSelectedItem();
        Enterprise selectedEnterprise = (AdoptionEnterprise) cmbEnterpriseList.getSelectedItem();
        Organization selecOrganization = (AdopterOrganization) cmbOrganizationList.getSelectedItem();
        
        String newUser = txtName.getText();
        String newUserName = txtNewUserName.getText();
        String newUserPassword = String.valueOf(pwdNewPassword.getPassword());
        
        
        if (selectedNetwork != null && selectedEnterprise != null && selectedEnterprise != null
                && !newUser.isEmpty() && !newUserName.isEmpty() && !newUserPassword.isEmpty()){
            
            // create new account
            if (ecoSystem.getUserAccountDirectory().userNameIsUnique(newUserName)){
            UserAccount newUserAccount = ecoSystem.getUserAccountDirectory().createUserAccount(newUserName, newUserPassword, new AdopterRole(), selectedNetwork, selectedEnterprise, selecOrganization);
            newUserAccount.setName(newUser);
            JOptionPane.showMessageDialog(null, "User Account added successfully.", "Information", JOptionPane.INFORMATION_MESSAGE);
            txtNewUserName.setText("");
            pwdNewPassword.setText("");
            txtName.setText("");
                      
            // create work request
            AdopterAuthorizationRequest request = new AdopterAuthorizationRequest();
            request.setMessage("New User");
            request.setSender(newUserAccount);
            request.setStatus("Pending Review");
            
            selectedEnterprise.getWorkQueue().getWorkRequestList().add(request);
            newUserAccount.getWorkQueue().getWorkRequestList().add(request);
            
            } else {
                JOptionPane.showMessageDialog(null, "User Account already existed","Warning",JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "All fields cannot be blank","Warning",JOptionPane.WARNING_MESSAGE);
        }
        
        
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void cmbEnterpriseListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEnterpriseListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEnterpriseListActionPerformed

    private void cmbOrganizationListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrganizationListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbOrganizationListActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JComboBox cmbEnterpriseList;
    private javax.swing.JComboBox cmbNetworkList;
    private javax.swing.JComboBox cmbOrganizationList;
    private javax.swing.JSeparator jSeparator;
    private javax.swing.JLabel lblEnterprise;
    private javax.swing.JLabel lblEnterprise1;
    private javax.swing.JLabel lblLogIn;
    private javax.swing.JLabel lblLogin2;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNetwork;
    private javax.swing.JLabel lblNewPassword;
    private javax.swing.JLabel lblNewUserName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRegister;
    private javax.swing.JLabel lblRegister1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPasswordField pwdNewPassword;
    private javax.swing.JPasswordField pwdPassword;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNewUserName;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables

    private void populateNetworkCombo() {

        cmbNetworkList.removeAllItems();

        if (!ecoSystem.getNetworkList().isEmpty()){
            for (Network n : ecoSystem.getNetworkList()){
                cmbNetworkList.addItem(n);
            }
        }

    }

    private void populateEnterpriseCombo() {
        
        cmbEnterpriseList.removeAllItems();
        
        Network network = (Network) cmbNetworkList.getSelectedItem();
        
        if (network != null ){
            for (Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()){
                if (e instanceof AdoptionEnterprise) cmbEnterpriseList.addItem(e);
            }
        }
    }

    private void populateOrganizationCombo() {

        cmbOrganizationList.removeAllItems();
        
        Network network = (Network) cmbNetworkList.getSelectedItem();
        
        if (network != null ){
            for (Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()){
                for (Organization o : e.getOrganizationDirectory().getOrganizationList()){
                    if (o instanceof AdopterOrganization) cmbOrganizationList.addItem(o);
                };
            }
        }
       
    }
}
