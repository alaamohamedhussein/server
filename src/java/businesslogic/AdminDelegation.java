/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import businesslogicinterface.AdminDelegationInt;
import crudsinterface.AdminInterface;
import pojos.Admin;

/**
 *
 * @author m@pc
 */
public class AdminDelegation implements AdminDelegationInt{

    @Override
    public Admin delegateSelectEP(String email, String password) {
        AdminInterface ad=new cruds.AdminCrud();
        return ad.selectEP(email, password);//To change body of generated methods, choose Tools | Templates.
    }
    
}
