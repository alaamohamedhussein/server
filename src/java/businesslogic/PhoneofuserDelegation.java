/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import businesslogicinterface.PhoneofuserDelegationInt;
import cruds.PhoneofuserCrudImplementation;
import crudsinterface.PhoneofuserCrudInterface;
import pojos.Phoneofuser;

/**
 *
 * @author hassan
 */
public class PhoneofuserDelegation implements PhoneofuserDelegationInt {

    @Override
    public void delegateInsert(Phoneofuser p) {

        PhoneofuserCrudInterface crud = new PhoneofuserCrudImplementation();
        crud.insert(p);

    }

    @Override
    public Phoneofuser delegateSelect(Integer id) {

        PhoneofuserCrudInterface crud = new PhoneofuserCrudImplementation();
        return (Phoneofuser) crud.select(id);

    }

    @Override
    public void delegateUpdate(Integer id, Phoneofuser p) {

        PhoneofuserCrudInterface crud = new PhoneofuserCrudImplementation();
        crud.update(id, p);

    }

    @Override
    public void delegateDelete(Integer id) {

        PhoneofuserCrudInterface crud = new PhoneofuserCrudImplementation();
        crud.delete(id);

    }

}
