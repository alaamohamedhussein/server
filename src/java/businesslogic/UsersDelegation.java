/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import businesslogicinterface.SkilltableDelegationInt;
import businesslogicinterface.UsersDelegationInt;
import bussinessList.ReturnList;
import cruds.UsersCrudImplementation;
import pojos.Users;
import crudsinterface.UsersCrudInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import pojos.Phoneofuser;
import pojos.Skilltable;
import validationsBusiness.ValidaionClass;

/**
 *
 * @author hassan
 */
public class UsersDelegation implements UsersDelegationInt {

  
    @Override
    public Users delegateSelect(int id) {

        UsersCrudInterface crud = new UsersCrudImplementation();
        return crud.select(id);

    }
 @Override
    public int delegateSelectId(String email) {

        UsersCrudInterface crud = new UsersCrudImplementation();
        Users u =crud.selectE(email).get(0);
        return u.getUserId();

    }
    @Override
    public boolean delegateInsert(String userEmail, String userImageUrl, String password, boolean gender, String userName, int ped, String country, String governorate, String city, String street, String summery, String profissionalTitle, String identifire, String mobile, String phones, String Skills) {
    UsersCrudInterface crud = new UsersCrudImplementation();
    boolean out=false;
    if(crud.selectE(userEmail).isEmpty()){
     ReturnList r=new ReturnList();
      SkilltableDelegationInt sd= new  SkilltableDelegation();
        PhoneofuserDelegation phd=new PhoneofuserDelegation();
        Users user= new Users();
        user.setUserEmail(userEmail);
        user.setUserImageUrl(userImageUrl);
        user.setPassword(password);
        user.setGender(gender);
        user.setUserName(userName);
        user.setPed(ped);
        user.setCountry(country);
        user.setGovernorate(governorate);
        user.setCity(city);
        user.setStreet(street);
        user.setSummery(summery);
        user.setProfessinalTiltle(profissionalTitle);
        user.setIdentefire(identifire);
        user.setRate(0);
        /////////////////////////////////////////////////////////////////mobiles
        List<String> mobiles = Arrays.asList(mobile.split(","));
        List<Phoneofuser> ph1= r.returnMobiles(mobiles);
        ////////////////////////////////////////////////////////////////phones
        List<String> phonesList= Arrays.asList(phones.split(","));
        List<Phoneofuser> ph2= r.returnPhones1(phonesList);
        /////////////////////////////////////////////////////////all phones of user
        List<Phoneofuser> ph3= r.returnPhones1(ph1,ph2);
        /////////////////////////////////////////////////////////Skills
        List<String> skList = Arrays.asList((Skills.split(",")));
        List<Integer>  sk=r.returnSkills(skList);
        List<Skilltable> stList=r.returnSkillsAll(sk);
        List<Users> uList= new ArrayList<>();
        uList.add(user);
        Set<Skilltable> sss =new HashSet(stList);
        Set<Users> uSet=new HashSet(uList);
        user.setSkilltables(sss);
        System.out.println(user.getSkilltables());
       
        if(ValidaionClass.insertNewUserValidate(userEmail, userImageUrl, password, gender, userName, ped, country, governorate, city, street, summery, profissionalTitle, identifire, mobile, phones, Skills)){
         out=crud.insert(user);  
        }else{
            out=false;
        }
    
        for(int i=0;i<stList.size();i++){
        stList.get(i).setUserses(uSet);
        sd.delegateInsert(stList.get(i));
       }
        ////////////////////////////////////////////////////////////////////////
        
         for(int i=0;i<ph3.size();i++){
          ph3.get(i).setUsers(user);
          phd.delegateInsert(ph3.get(i));
        }
    }else{
        out=false;
    } 
    return out;
    }

   @Override
    public boolean delegateUpdateUser(int id,String userEmail, String userImageUrl, String password, boolean gender, String userName, int ped, String country, String governorate, String city, String street, String summery, String profissionalTitle, String identifire, String mobile, String phones, String Skills) {
    UsersCrudInterface crud = new UsersCrudImplementation();
    boolean out=false;
    if(crud.selectE(userEmail).isEmpty()){
     ReturnList r=new ReturnList();
      SkilltableDelegationInt sd= new  SkilltableDelegation();
        PhoneofuserDelegation phd=new PhoneofuserDelegation();
        Users user= new Users();
        user.setUserId(id);
        user.setUserEmail(userEmail);
        user.setUserImageUrl(userImageUrl);
        user.setPassword(password);
        user.setGender(gender);
        user.setUserName(userName);
        user.setPed(ped);
        user.setCountry(country);
        user.setGovernorate(governorate);
        user.setCity(city);
        user.setStreet(street);
        user.setSummery(summery);
        user.setProfessinalTiltle(profissionalTitle);
        user.setIdentefire(identifire);
        user.setRate(0);
        /////////////////////////////////////////////////////////////////mobiles
        List<String> mobiles = Arrays.asList(mobile.split(","));
        List<Phoneofuser> ph1= r.returnMobiles(mobiles);
        ////////////////////////////////////////////////////////////////phones
        List<String> phonesList= Arrays.asList(phones.split(","));
        List<Phoneofuser> ph2= r.returnPhones1(phonesList);
        /////////////////////////////////////////////////////////all phones of user
        List<Phoneofuser> ph3= r.returnPhones1(ph1,ph2);
        /////////////////////////////////////////////////////////Skills
        List<String> skList = Arrays.asList((Skills.split(",")));
        List<Integer>  sk=r.returnSkills(skList);
        List<Skilltable> stList=r.returnSkillsAll(sk);
        List<Users> uList= new ArrayList<>();
        uList.add(user);
        Set<Skilltable> sss =new HashSet(stList);
        Set<Users> uSet=new HashSet(uList);
        user.setSkilltables(sss);
        System.out.println(user.getSkilltables());
       
        if(ValidaionClass.insertNewUserValidate(userEmail, userImageUrl, password, gender, userName, ped, country, governorate, city, street, summery, profissionalTitle, identifire, mobile, phones, Skills)){
         out=crud.insert(user);  
        }else{
            out=false;
        }
    
        for(int i=0;i<stList.size();i++){
        stList.get(i).setUserses(uSet);
        sd.delegateInsert(stList.get(i));
       }
        ////////////////////////////////////////////////////////////////////////
        
         for(int i=0;i<ph3.size();i++){
          ph3.get(i).setUsers(user);
          phd.delegateInsert(ph3.get(i));
        }
    }else{
        out=false;
    } 
    return out;
    }

    @Override
    public Users delegateSelectEP(String email, String password) {

        UsersCrudInterface crud = new UsersCrudImplementation();
        return crud.selectEP(email, password);

    }
 
    @Override
    public boolean delegateUpdate(int id, Users u) {
UsersCrudInterface crud = new UsersCrudImplementation();
        crud.update(id, u);
    return true;}

    @Override
    public boolean delegateDelete(int id) {

        UsersCrudInterface crud = new UsersCrudImplementation();
        crud.delete(id);
    return true;}
     @Override
    public ArrayList<Users> selectMaxRateUsers() {
         UsersCrudInterface crud = new UsersCrudImplementation();
         ArrayList<Users> usersAll= crud.selectMaxRateUsers(); 
         return  usersAll;
    }
     @Override
    public ArrayList<Users> selectAllUsers() {
         UsersCrudInterface crud = new UsersCrudImplementation();
         ArrayList<Users> usersAll= crud.selectAllUsers(); 
         return  usersAll;
    }
    
    
    
    @Override
    public Object delegateSelectUserHQL(int id) {

        UsersCrudInterface crud = new UsersCrudImplementation();
        return crud.selectUserHQL(id);

    }

}
