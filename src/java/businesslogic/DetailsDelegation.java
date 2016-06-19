/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import businesslogicinterface.DetailsDelegationInt;
import businesslogicinterface.PorposaDelegationInt;
import cruds.DetailsCrudImplementation;
import crudsinterface.DetailsCrudInterface;
import java.util.ArrayList;
import pojos.Details;
import pojos.DetailsId;
import pojos.Porposa;
import pojos.Projectsforusers;
import pojos.Users;

/**
 *
 * @author m@pc
 */
public class DetailsDelegation implements DetailsDelegationInt {
    
    @Override
    public ArrayList<Details> selectDetails(int pId, int PrId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean delegateInsert(Details dt) {
        DetailsCrudInterface d;
        d = new DetailsCrudImplementation();
        return (d.insertDetails(dt));
    }
    
    @Override
    public Details delegateSelect(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void delegateUpdate(int id, Details d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void delegateDelete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Details delegateSetCommint(int userId, int projectId, int porposaId, String Comment) {
        
        DetailsCrudInterface crudInterface = new DetailsCrudImplementation();
        DetailsId detailsId = new DetailsId(porposaId, projectId);
        Details details = crudInterface.selectDetails(detailsId);
        PorposaDelegationInt delegationInt = new PorposaDelegation();
        Porposa porposa = delegationInt.delegateSelect(projectId);
        
        if (porposa.getStatusOfPorposa().equals("acceptance")) {
            
            UsersDelegation usersDelegation = new UsersDelegation();
            Users users = usersDelegation.delegateSelect(userId);
            
            ProjectDelegation projectDelegation = new ProjectDelegation();
            Projectsforusers projectsforusers = projectDelegation.delegateSelect(userId);
            
            if (users.getProjectsforuserses().contains(projectsforusers)) {
                
                details.setCommentFromOwner(Comment);
                
            } else {
                
                details.setCommentFromSuppliers(Comment);
                
            }
            
            delegateInsert(details);
            
        }
        
        return details;
        
    }
    
    @Override
    public Details delegateSetRate(int userId, int projectId, int porposaId, int rate) {
        
        DetailsCrudInterface crudInterface = new DetailsCrudImplementation();
        DetailsId detailsId = new DetailsId(porposaId, projectId);
        Details details = crudInterface.selectDetails(detailsId);
        PorposaDelegationInt delegationInt = new PorposaDelegation();
        Porposa porposa = delegationInt.delegateSelect(projectId);
        
        if (porposa.getStatusOfPorposa().equals("acceptance")) {
            
            UsersDelegation usersDelegation = new UsersDelegation();
            Users users = usersDelegation.delegateSelect(userId);
            
            ProjectDelegation projectDelegation = new ProjectDelegation();
            Projectsforusers projectsforusers = projectDelegation.delegateSelect(userId);
            
            if (users.getProjectsforuserses().contains(projectsforusers)) {
                
                details.setRateForOwner(rate);
                
            } else {
                
                details.setRateForSuppliers(rate);
                
            }
            
            delegateInsert(details);
            
        }
        
        return details;
        
    }
    
}
