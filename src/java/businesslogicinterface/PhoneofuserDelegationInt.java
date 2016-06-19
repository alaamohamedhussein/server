/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogicinterface;

import pojos.Phoneofuser;
import pojos.Users;

/**
 *
 * @author hassan
 */
public interface PhoneofuserDelegationInt {

    public void delegateInsert(Phoneofuser p);

    public Phoneofuser delegateSelect(Integer id);

    public void delegateUpdate(Integer id, Phoneofuser p);

    public void delegateDelete(Integer id);

}
