/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogicinterface;

import pojos.Comments;

/**
 *
 * @author hassan
 */
public interface ReplyingDelegationInt {

    public boolean delegateInsert(String pId,String comment);

    public Comments delegateSelect(Integer id);

    public void delegateUpdate(Integer id, Comments replying);

    public void delegateDelete(Integer id);

}
