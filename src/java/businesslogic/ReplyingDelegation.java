/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import businesslogicinterface.ReplyingDelegationInt;
import cruds.PostforprojectsCrudImplementation;
import cruds.ReplyingCrudImplementation;
import crudsinterface.PostforprojectsCrudInterface;
import crudsinterface.ReplyingCrudInterface;
import pojos.Comments;
import pojos.Postforprojects;

/**
 *
 * @author hassan
 */
public class ReplyingDelegation implements ReplyingDelegationInt {

    @Override
    public boolean delegateInsert(String pId, String comment) {
        int id = Integer.parseInt(pId);
        ReplyingCrudInterface rCrud = new ReplyingCrudImplementation();
        PostforprojectsCrudInterface crud = new PostforprojectsCrudImplementation();
        Postforprojects p = crud.select(id);
        Comments c = new Comments(p, comment);
      return  rCrud.insert(c);

    }

    @Override
    public Comments delegateSelect(Integer id) {

        ReplyingCrudInterface crud = new ReplyingCrudImplementation();
        return crud.select(id);

    }

    @Override
    public void delegateUpdate(Integer id, Comments replying) {

        ReplyingCrudInterface crud = new ReplyingCrudImplementation();
        crud.update(id, replying);

    }

    @Override
    public void delegateDelete(Integer id) {

        ReplyingCrudInterface crud = new ReplyingCrudImplementation();
        crud.delete(id);

    }

}
