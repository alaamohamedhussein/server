/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogicinterface;

/**
 *
 * @author m@pc
 */
public interface ImagesUserDelegationInterface {
   public void delegateInsert(Object obj);

    public Object delegateSelect(Integer id);

    public void delegateUpdate(Integer id, Object obj);

    public void delegateDelete(Integer id);  
}
