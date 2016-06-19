/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogicinterface;

import pojos.Admin;

/**
 *
 * @author m@pc
 */
public interface AdminDelegationInt {
       public Admin delegateSelectEP(String email, String password) ;
}
