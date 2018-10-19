/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import tp3.modeles.Operations;
import tp3.gestionnaires.GestionnaireOperation;


@Named(value = "OperationMBean")
@Dependent
public class GestionnaireOperationMBean {
    
        @EJB
    private GestionnaireOperation gestionnaireOperation;
    private Operations operations;

    public GestionnaireOperation getOperationMBean() {
        return gestionnaireOperation;
    }

    public Operations getOperations() {
        return operations;
    }

    public void setOperations(Operations operations) {
        this.operations = operations;
    }
    
    public List <Operations> getOperation(){
  
        return gestionnaireOperation.getAllOperation();
    
    }
            
    
    
    
}
