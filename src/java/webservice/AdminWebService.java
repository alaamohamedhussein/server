/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import businesslogic.AdminDelegation;
import businesslogic.ProjectDelegation;
import businesslogic.UsersDelegation;
import businesslogicinterface.AdminDelegationInt;
import businesslogicinterface.ProjectDelegationInt;
import businesslogicinterface.UsersDelegationInt;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import pojos.Admin;
import pojos.Users;
import static webservice.ProjectWebService.ProjectsForUser;

/**
 *
 * @author m@pc
 */
@Path("/admin")
public class AdminWebService {

    @POST
    @Path("/login")
    public Response login(MultivaluedMap<String, String> val) throws Exception {

        AdminDelegationInt usersDelegationInt = new AdminDelegation();
        Admin ad = usersDelegationInt.delegateSelectEP(val.getFirst("email"), val.getFirst("password"));
        Gson g = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        Map<String, Object> map = new HashMap();
        map.put("message", "login Succesfuly");
        map.put("admin", ad);

        return Response.status(200).entity(g.toJson(map)).build();
    }

    @GET
    @Path("/getAllUsers")
    public Response getUsers(MultivaluedMap<String, String> val) throws Exception {

        UsersDelegationInt user = new UsersDelegation();
        ArrayList<Users> u = user.selectAllUsers();
        Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().serializeNulls().create();
        Map<String, Object> map = new HashMap();
        map.put("satatus", true);
        map.put("users", u);
        System.out.println(u);
        //System.out.println(out);
        return Response.status(200).entity(g.toJson(map)).build();
    }
    
      @GET
    @Path("/getAllProject")
    public Response selectLastProject() throws Exception {
        ProjectDelegationInt delegationInt = new ProjectDelegation();
       ProjectsForUser=delegationInt.selectAllProjects();   
      Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();      
     String out=g.toJson(ProjectsForUser);
      Map<String, Object> map =new HashMap();
      map.put("satatus", true);
      map.put("projects",  ProjectsForUser);    
     System.out.println(out);
        return Response.status(200).entity(g.toJson(map)).build();
    }
}
