/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogicinterface;

import pojos.Tagsofprojects;

/**
 *
 * @author m@pc
 */
public interface TagsForProjectDelegationInt {
     public void delegateInsert(Tagsofprojects tfp);

    public Tagsofprojects delegateSelect(int id);

    public void delegateUpdate(int id, Tagsofprojects tfp);

    public void delegateDelete(int id); 
}
