/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogicinterface;

import java.util.ArrayList;
import pojos.Category;
import pojos.Portofolioforuser;
import pojos.Users;

/**
 *
 * @author hassan
 */
public interface PortofolioforuserDelegationInt {

   public boolean delegateInsert(int uId,int cId,String names,String contents,String portDescription);

    public Portofolioforuser delegateSelect(Integer id);

    public void delegateUpdate(Integer id, Portofolioforuser portofolioforuser);

    public void delegateDelete(Integer id);
     public ArrayList<Portofolioforuser> selectPortofolios(Category cat) ;
 public Users selectUser(int pId);
}
