/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import businesslogicinterface.PostforprojectsDelegationInt;
import businesslogicinterface.ProjectDelegationInt;
import businesslogicinterface.UsersDelegationInt;
import cruds.PostforprojectsCrudImplementation;
import crudsinterface.PostforprojectsCrudInterface;
import pojos.Postforprojects;
import pojos.Projectsforusers;
import pojos.Users;

/**
 *
 * @author hassan
 */
public class PostforprojectsDelegation implements PostforprojectsDelegationInt {

    @Override
    public boolean delegateInsert(String pId, String post, String uId) {
        boolean flag=false;
        int id1 = Integer.parseInt(uId);
        int id2 = Integer.parseInt(pId);
        UsersDelegationInt ud = new UsersDelegation();
        ProjectDelegationInt delegationInt = new ProjectDelegation();
        Projectsforusers p = delegationInt.delegateSelect(id2);
        int id = Integer.parseInt(uId);
        Users u = ud.delegateSelect(id);
        Postforprojects q = new Postforprojects(p, u, post);
        PostforprojectsCrudInterface crud = new PostforprojectsCrudImplementation();
       if( crud.insert(q)){
         flag=true;  
       };
return flag;
    }

    @Override
    public Postforprojects delegateSelect(int id) {

        PostforprojectsCrudInterface crud = new PostforprojectsCrudImplementation();
        return crud.select(id);

    }

    @Override
    public void delegateUpdate(Integer id, Postforprojects postforprojects) {

        PostforprojectsCrudInterface crud = new PostforprojectsCrudImplementation();
        crud.update(id, postforprojects);

    }

    @Override
    public void delegateDelete(Integer id) {

        PostforprojectsCrudInterface crud = new PostforprojectsCrudImplementation();
        crud.delete(id);

    }

}
