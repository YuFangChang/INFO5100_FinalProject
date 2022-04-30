/*
 * AdminWorkAreaJPanel.java
 *
 * Created on October 10, 2008, 8:50 AM
 */

package ui.AdministrativeRole;

import java.awt.CardLayout;
import javax.swing.JPanel;
import model.EcoSystem.EcoSystem;
import model.Enterprise.Enterprise;
import model.Network.Network;
import model.Organization.Organization;
import model.UserAccount.UserAccount;

/**
 *
 * @author  raunak
 */
public class AdminWorkAreaJPanel extends javax.swing.JPanel {
    
    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    private UserAccount userAccount; 
    /** Creates new form AdminWorkAreaJPanel */
    
    public AdminWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.ecoSystem = ecoSystem;
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnManageNetwork = new javax.swing.JButton();
        btnManageEnterprise = new javax.swing.JButton();
        btnManageOrganization = new javax.swing.JButton();
        btnManageUsers = new javax.swing.JButton();
        btnViewDashboard = new javax.swing.JButton();

        setBackground(new java.awt.Color(224, 227, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icon_admin.png"))); // NOI18N
        lblTitle.setText("System Admin Work Area");
        add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 29, -1, -1));

        btnManageNetwork.setBackground(new java.awt.Color(245, 245, 255));
        btnManageNetwork.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icon_network.png"))); // NOI18N
        btnManageNetwork.setText("Manage Network");
        btnManageNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageNetworkActionPerformed(evt);
            }
        });
        add(btnManageNetwork, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 81, 184, -1));

        btnManageEnterprise.setBackground(new java.awt.Color(245, 245, 255));
        btnManageEnterprise.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icon_enterprise.png"))); // NOI18N
        btnManageEnterprise.setText("Manage Enterprise");
        btnManageEnterprise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageEnterpriseActionPerformed(evt);
            }
        });
        add(btnManageEnterprise, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 135, 184, -1));

        btnManageOrganization.setBackground(new java.awt.Color(245, 245, 255));
        btnManageOrganization.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icon_organization.png"))); // NOI18N
        btnManageOrganization.setText("Manage Organizations");
        btnManageOrganization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageOrganizationActionPerformed(evt);
            }
        });
        add(btnManageOrganization, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 189, 184, -1));

        btnManageUsers.setBackground(new java.awt.Color(245, 245, 255));
        btnManageUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icon_role.png"))); // NOI18N
        btnManageUsers.setText("Manage Users");
        btnManageUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageUsersActionPerformed(evt);
            }
        });
        add(btnManageUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 243, 184, -1));

        btnViewDashboard.setBackground(new java.awt.Color(245, 245, 255));
        btnViewDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icon_dashboard.png"))); // NOI18N
        btnViewDashboard.setText("Dashboard");
        btnViewDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDashboardActionPerformed(evt);
            }
        });
        add(btnViewDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 297, 184, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageUsersActionPerformed

        ManageUserAccountJPanel muajp = new ManageUserAccountJPanel(userProcessContainer, ecoSystem);
        userProcessContainer.add("ManageUserAccountJPanel", muajp);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_btnManageUsersActionPerformed

    private void btnViewDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDashboardActionPerformed

        SysAdminDashboardJPanel sadjp = new SysAdminDashboardJPanel(userProcessContainer , ecoSystem,  userAccount.getNetwork());
        userProcessContainer.add("Dashboard", sadjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_btnViewDashboardActionPerformed

    private void btnManageEnterpriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageEnterpriseActionPerformed

        ManageEnterpriseJPanel mejp = new ManageEnterpriseJPanel(userProcessContainer, ecoSystem);
        userProcessContainer.add("ManageEnterpriseJPanel", mejp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_btnManageEnterpriseActionPerformed

    private void btnManageOrganizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageOrganizationActionPerformed

        ManageOrganizationJPanel mojp = new ManageOrganizationJPanel (userProcessContainer, ecoSystem);
        userProcessContainer.add("ManageOrganizationJPanel", mojp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_btnManageOrganizationActionPerformed

    private void btnManageNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageNetworkActionPerformed

        ManageNetworkJPanel mnjp = new ManageNetworkJPanel(userProcessContainer, ecoSystem);
        userProcessContainer.add("ManageNetworkJPanel",mnjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_btnManageNetworkActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageEnterprise;
    private javax.swing.JButton btnManageNetwork;
    private javax.swing.JButton btnManageOrganization;
    private javax.swing.JButton btnManageUsers;
    private javax.swing.JButton btnViewDashboard;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
    
}
