/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Organization;

import model.Role.Role;
import java.util.ArrayList;
import model.Role.VolunteerManagerRole;

/**
 *
 * @author anitachen
 */
public class VolunteerManagementOrganization extends Organization{

    public VolunteerManagementOrganization() {
        super(Organization.Type.VolunteerManagement.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new VolunteerManagerRole());
        return roles;
    }
    
}
