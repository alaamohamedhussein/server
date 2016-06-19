/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import businesslogic.PorposaDelegation;
import businesslogic.ProjectDelegation;
import businesslogicinterface.PorposaDelegationInt;
import businesslogicinterface.ProjectDelegationInt;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONObject;
import pojos.Projectsforusers;

/**
 *
 * @author hassan
 */
@Path("/project")
public class ProjectWebService {
public static  ArrayList<Projectsforusers> ProjectsForUser =new ArrayList<>();
    @POST
    @Path("/Project")
    public Response selectUser(MultivaluedMap<String, String> val) throws Exception {

        ProjectDelegationInt delegationInt = new ProjectDelegation();
        boolean flag = delegationInt.delegateInsert(val.getFirst("projectName"), val.getFirst("projectDescription"), Integer.parseInt(val.getFirst("budget")), Date.valueOf(val.getFirst("startDate")), Date.valueOf(val.getFirst("projectDeadLine")), val.getFirst("name"),val.getFirst("content"), val.getFirst("skilltables"), val.getFirst("tagsofprojectses"), Integer.parseInt(val.getFirst("userId")), Integer.parseInt(val.getFirst("categoryId")));
        JSONObject outputJsonObj = new JSONObject();
        if (flag) {

            outputJsonObj.put("output", "tureInsert");

        } else {

            outputJsonObj.put("output", "there is some empty data please inter it");

        }

        return Response.status(200).entity(outputJsonObj).build();
    }
     @GET
    @Path("/getLastProject")
    public Response selectLastProject(@QueryParam("footer") int footer) throws Exception {
        System.out.println("in web service mona");
        ProjectDelegationInt delegationInt = new ProjectDelegation();
       ProjectsForUser=delegationInt.selectLastInterd();
        ArrayList<Projectsforusers> portofolios =new ArrayList<>();
     for(int i= footer; i<4 && i<ProjectsForUser.size() ;i++){
     portofolios.add(ProjectsForUser.get(i));
     }
      Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();      
     String out=g.toJson(portofolios);
      Map<String, Object> map =new HashMap();
      map.put("satatus", true);
      map.put("projects",  portofolios);    
     System.out.println(out);
        return Response.status(200).entity(g.toJson(map)).build();
    }
     @GET
    @Path("/getBestProject")
    public Response selectBestProject() throws Exception {
        System.out.println("in web service mona");
        ProjectDelegationInt delegationInt = new ProjectDelegation();
       ProjectsForUser=delegationInt.selectBestProjects();
      Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();      
     String out=g.toJson( ProjectsForUser);
     Map<String, Object> map =new HashMap();
      map.put("satatus", true);
      map.put("bestProjects", ProjectsForUser);    
     System.out.println(out);
        return Response.status(200).entity(g.toJson(map)).build();
    }
    @POST
    @Path("/projectsOfUserWork")
     public Response selectAllProjectOfUser(MultivaluedMap<String, String> val) throws Exception {
        System.out.println("in web service mona");
        int id=Integer.parseInt(val.getFirst("uId"));
        ProjectDelegationInt delegationInt = new ProjectDelegation();
       ArrayList<Projectsforusers> categories=delegationInt.selectProjects(id);
      Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();      
     String out=g.toJson(categories);
      Map<String, Object> map =new HashMap();
      map.put("satatus", true);
      map.put("projectsOfUserWork", categories);    
     System.out.println(out);
        return Response.status(200).entity(g.toJson(map)).build();
    }
       @POST
    @Path("/projectsOfUserHire")
     public Response selectAllProjectOfUserHire(MultivaluedMap<String, String> val) throws Exception {
        System.out.println("in web service mona");
        int id=Integer.parseInt(val.getFirst("uId"));
        PorposaDelegationInt delegationInt = new PorposaDelegation();
       ArrayList<Object> categories=delegationInt.projectsIds(id);
      Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();      
     String out=g.toJson(categories);
      Map<String, Object> map =new HashMap();
      map.put("satatus", true);
      map.put("projectsOfUserHire", categories);    
     System.out.println(out);
        return Response.status(200).entity(g.toJson(map)).build();
    }
     @POST
    @Path("/getproject")
     public Response selectProject(MultivaluedMap<String, String> val) throws Exception {
        System.out.println("in web service mona");
        int id=Integer.parseInt(val.getFirst("pId"));
        ProjectDelegationInt delegationInt = new ProjectDelegation();
       Projectsforusers project=delegationInt.delegateSelect(id);
      Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();      
     String out=g.toJson(project);
      Map<String, Object> map =new HashMap();
      map.put("satatus", true);
      map.put("project", project);    
     System.out.println(out);
        return Response.status(200).entity(g.toJson(map)).build();
    }
     
}
