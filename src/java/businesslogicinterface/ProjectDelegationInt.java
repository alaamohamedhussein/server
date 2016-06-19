/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogicinterface;

import java.util.ArrayList;
import java.util.Date;
import pojos.Projectsforusers;

/**
 *
 * @author m@pc
 */
public interface ProjectDelegationInt {

    public boolean delegateInsert(String projectName, String projectDescription, int budget, Date startDate, Date projectDeadLine, String projectsimageses,String content, String skilltables, String tagsofprojectses, int userId, int categoryid) ;

    public Projectsforusers delegateSelect(int id);

    public void delegateUpdate(int id, Projectsforusers p);

    public void delegateDelete(int id);
    
       public ArrayList<Projectsforusers> selectProjects(int id);
               
    public ArrayList<Projectsforusers> selectLastInterd();
    
    public ArrayList<Projectsforusers> selectBestProjects();
    
     public ArrayList<Projectsforusers> selectAllProjects();
}
