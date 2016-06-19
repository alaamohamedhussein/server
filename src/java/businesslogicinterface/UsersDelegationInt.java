/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogicinterface;

import java.util.ArrayList;
import pojos.Users;

/**
 *
 * @author hassan
 */
public interface UsersDelegationInt {

    public boolean delegateInsert(String userEmail,String userImageUrl,String password,boolean gen, String userName,int ped, String country,String governorate,String city,String street,String summery,String profissionalTitle, String identifire, String mobile, String phones,String Skills);

      public boolean delegateUpdateUser(int id ,String userEmail, String userImageUrl, String password, boolean gender, String userName, int ped, String country, String governorate, String city, String street, String summery, String profissionalTitle, String identifire, String mobile, String phones, String Skills);
      
    public Users delegateSelect(int id);

    public boolean delegateUpdate(int id, Users u);

    public boolean delegateDelete(int id);
    
     public Users delegateSelectEP(String email, String password) ;
     
         public ArrayList<Users> selectMaxRateUsers();
         
         public int delegateSelectId(String email);
         
          public Object delegateSelectUserHQL(int id) ;
         
         public ArrayList<Users> selectAllUsers();

}
