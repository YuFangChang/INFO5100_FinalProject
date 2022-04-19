/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Enterprise;


import model.Network.Network;
import java.util.ArrayList;
import javax.swing.Action;
import model.Enterprise.Enterprise.Type;

/**
 *
 * @author anitachen
 */
public class EnterpriseDirectory {
    
    private ArrayList<Enterprise> enterpriseList;
   
    public EnterpriseDirectory(){
        enterpriseList = new ArrayList<Enterprise>();
    }   
    
    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }
    
    //Create enterprise
    public Enterprise createAndAddEnterprise(Type type){
        
        Enterprise enterprise = null;

        if (type.getValue().equals(Type.AnimalShelter.getValue())) {
            enterprise = new AnimalShelterEnterprise();
            enterpriseList.add(enterprise);
        } 
        else if (type.getValue().equals(Type.MedicalCare.getValue())) {
            enterprise = new MedicalCareEnterprise();
            enterpriseList.add(enterprise);
        } 
        else if (type.getValue().equals(Type.Adoption.getValue())) {
            enterprise = new AdoptionEnterprise();
            enterpriseList.add(enterprise);
        }
        else if (type.getValue().equals(Type.Volunteer.getValue())) {
            enterprise = new VolunteerEnterprise();
            enterpriseList.add(enterprise);
        }

        return enterprise;
    }

    public boolean isUnique(String name){
        for(Enterprise enterprise : enterpriseList){
            if(name.equalsIgnoreCase(enterprise.getName())){
                return false;
            }
        }
        return true;
    }
}
