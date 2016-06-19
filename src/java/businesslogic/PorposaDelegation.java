/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import businesslogicinterface.PorposaDelegationInt;
import cruds.PorposaCrudImplementation;
import cruds.ProjectCrudImplementation;
import cruds.UsersCrudImplementation;
import crudsinterface.PorposaCrudInterface;
import crudsinterface.ProjectCrudInterface;
import crudsinterface.UsersCrudInterface;
import java.util.ArrayList;
import java.util.Date;
import pojos.Porposa;
import pojos.Projectsforusers;
import pojos.Users;

/**
 *
 * @author hassan
 */
public class PorposaDelegation implements PorposaDelegationInt {

  

    @Override
    public Porposa delegateSelect(Integer id) {

        PorposaCrudInterface crud = new PorposaCrudImplementation();
        return crud.select(id);

    }

    @Override
    public void delegateUpdate(Integer id, Porposa porposa) {

        PorposaCrudInterface crud = new PorposaCrudImplementation();
        crud.update(id, porposa);

    }

    @Override
    public void delegateDelete(Integer id) {

        PorposaCrudInterface crud = new PorposaCrudImplementation();
        crud.delete(id);

    }
     @Override
    public boolean delegateInsert(Porposa porposa) {

        PorposaCrudInterface crud = new PorposaCrudImplementation();
        return (crud.insert(porposa));

    }

    @Override
    public boolean delegateInsert(String price, String startDate, String deadLine, String projectId, String SuplierId, String projectStatus) {
      boolean flag;
        Porposa p= new Porposa();
         Projectsforusers pu=new Projectsforusers();
          Users u=new Users();
       PorposaCrudInterface cr = new PorposaCrudImplementation();
       ProjectCrudInterface pp=new ProjectCrudImplementation();
       int pid=Integer.parseInt(projectId);
        pu=pp.selectProject(pid);
       UsersCrudInterface crud = new UsersCrudImplementation();
      int uid=Integer.parseInt(SuplierId);
        u=crud.select(uid);
        p.setPrice(Integer.parseInt(price));
        p.setStartDatePor(new Date());
        p.setDeadLinePor(new Date());
        p.setProjectsforusers(pu);
        p.setUsers(u);
        p.setStatusOfPorposa(projectStatus);
        flag= cr.insert(p); 
  return flag;
    }
      @Override
public ArrayList<Object> projectsIds(int porId){
  PorposaCrudInterface cr = new PorposaCrudImplementation();
     ArrayList<Object> pIds=new ArrayList<>();
     pIds=cr.projectsIds(porId);
     return pIds;
}
 @Override
    public ArrayList<Porposa> delegateSelectPorposaHQL(int id) {

        PorposaCrudInterface crud = new PorposaCrudImplementation();
        return crud.selectPorposeHQL(id);

    }
}
