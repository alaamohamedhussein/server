/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import businesslogic.CategoryDelegation;
import businesslogic.PortofolioforuserDelegation;
import businesslogic.UsersDelegation;
import businesslogicinterface.CategoryDelegationInt;
import businesslogicinterface.PortofolioforuserDelegationInt;
import businesslogicinterface.UsersDelegationInt;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import pojos.Category;
import pojos.Portofolioforuser;
import pojos.Users;

/**
 *
 * @author m@pc
 */
@Path("/portofolio")
public class PortofolioWebService {

    public static ArrayList<Portofolioforuser> PortofoliosForUser = new ArrayList<>();
    //public static int checkDate = new Date().getDay();
     public static int checkDate = 3;
    PortofolioforuserDelegationInt por = new PortofolioforuserDelegation();
    UsersDelegationInt o = new UsersDelegation();
    CategoryDelegationInt cat = new CategoryDelegation();

    @GET
    @Path("/getPortofolioRandom")
    public Response selectPortofolioRandom(@QueryParam("categoryId") int categoryId, @QueryParam("footer") int footer) throws Exception {
        String message = "";
        Map<String, Object> map = new HashMap();
       
        Gson g = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
         
            Category catt = cat.delegateSelect(categoryId);
            ArrayList<Portofolioforuser> portofoliosAll = por.selectPortofolios(catt);
        if (checkDate == new Date().getDay()) {
            ArrayList<Portofolioforuser> portofolios = new ArrayList<>();
            for (int i = footer; i < 4 && i < PortofoliosForUser.size(); i++) {
                portofolios.add(PortofoliosForUser.get(i));
            }
            map.put("satatus", true);
            map.put("portofolios", portofolios);
        }else{
            footer=0;
            PortofoliosForUser = por.selectPortofolios(catt);
            ArrayList<Portofolioforuser> portofolios = new ArrayList<>();
            for (int i = footer; i < 4 && i < PortofoliosForUser.size(); i++) {
                portofolios.add(PortofoliosForUser.get(i));
            }
            map.put("satatus", true);
            map.put("portofolios", portofolios);  
        }
        return Response.status(200).entity(g.toJson(map)).build();
    }

    @POST
    @Path("/getUser")
    public Response selectUser(MultivaluedMap<String, String> val) throws Exception {
        String message = "";
        int id = Integer.parseInt(val.getFirst("portId"));
        Users u = o.delegateSelect(por.selectUser(id).getUserId());

        Gson g = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        Map<String, Object> map = new HashMap();
        map.put("satatus", true);
        map.put("user", u);

        return Response.status(200).entity(g.toJson(map)).build();
    }
   @POST
    @Path("/insertPortofolio")
    public Response InsertPortofolio(MultivaluedMap<String, String> val) throws Exception {
        
        String message = "";
        String portDescription =val.getFirst("description");
        int uId =Integer.parseInt(val.getFirst("uId"));
        int cId = Integer.parseInt(val.getFirst("cId"));
        String names =val.getFirst("name");
         String contents =val.getFirst("content");
      boolean output= por.delegateInsert(uId,cId,names,contents,portDescription);
        Gson g = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        Map<String, Object> map = new HashMap();
        map.put("satatus", true);
        map.put("user", "inserted succesfuly");

        return Response.status(200).entity(g.toJson(map)).build();
    }
}
