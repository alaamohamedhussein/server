/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogicinterface;

import pojos.Tags;
import pojos.Tagsofprojects;

/**
 *
 * @author m@pc
 */
public interface TagsDelegationInt {
   public boolean delegateInsert(int id,String description);

    public Tags delegateSelect(int id);

    public void delegateUpdate(int id, Tags tag);

    public void delegateDelete(int id);   
}
