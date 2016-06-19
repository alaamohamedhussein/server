/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogicinterface;

import pojos.Postforprojects;

/**
 *
 * @author hassan
 */
public interface PostforprojectsDelegationInt {

   public boolean delegateInsert(String pId,String post,String uId);

    public Postforprojects delegateSelect(int id);

    public void delegateUpdate(Integer id, Postforprojects postforprojects);

    public void delegateDelete(Integer id);

}
