/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Organization;

import model.Role.AnimalManagementRole;
import model.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class AnimalManagementOrganization extends Organization{

    public AnimalManagementOrganization() {
        super(Organization.Type.AnimalRegister.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new AnimalRegisterRole());
        return roles;
    }
     
}