/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Enterprise;

import model.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author MyPC1
 */
public class MedicalCareEnterprise extends Enterprise {
    
    public MedicalCareEnterprise(String name){
        super(name,Type.MedicalCare);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
    
}