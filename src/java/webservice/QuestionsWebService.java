/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import businesslogic.PorposaDelegation;
import businesslogic.PostforprojectsDelegation;
import businesslogic.ProjectDelegation;
import businesslogic.ReplyingDelegation;
import businesslogicinterface.PorposaDelegationInt;
import businesslogicinterface.PostforprojectsDelegationInt;
import businesslogicinterface.ProjectDelegationInt;
import businesslogicinterface.ReplyingDelegationInt;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import pojos.Projectsforusers;

/**
 *
 * @author m@pc
 */
@Path("/ask")
public class QuestionsWebService {

    @POST
    @Path("/addQuestion")
    public Response askAndReply(MultivaluedMap<String, String> val) throws JSONException {
        PostforprojectsDelegationInt pd = new PostforprojectsDelegation();
        boolean flag = pd.delegateInsert(val.getFirst("pId"), val.getFirst("post"), val.getFirst("sId"));
        JSONObject outputJsonObj = new JSONObject();
        if (flag) {

            outputJsonObj.put("output", "Question sent succesfuly");

        } else {

            outputJsonObj.put("output", "error for send question please try again");

        }

        return Response.status(200).entity(outputJsonObj).build();
    }

    @POST
    @Path("/getQuestion")
    public Response GetProjectWithQuestion(MultivaluedMap<String, String> val) throws JSONException {
        int id = Integer.parseInt(val.getFirst("uId"));
        int footer = Integer.parseInt(val.getFirst("footer"));
        ProjectDelegationInt delegationInt = new ProjectDelegation();
        PorposaDelegationInt pD = new PorposaDelegation();
        ArrayList<Object> projects = new ArrayList<>();
        ArrayList<Object> projectsWithQuestions = new ArrayList<>();
        ArrayList<Projectsforusers> pWork = delegationInt.selectProjects(id);
        ArrayList<Object> pHire = pD.projectsIds(id);
        for (int i = 0; i < pWork.size(); i++) {
            projects.add(pWork.get(i));
        }
        for (int j = 0; j< pHire.size(); j++) {
            projects.add(pHire.get(j));
        }
        for (int k = footer; k < 10 && k< +projects.size(); k++) {
            projectsWithQuestions.add(projects.get(k));
        }
        Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        Map<String, Object> map = new HashMap();
        map.put("satatus", true);
        map.put("projectsWithQuestions", projectsWithQuestions);
        return Response.status(200).entity(g.toJson(map)).build();
    }
     @POST
    @Path("/insertReply")
    public Response insertReplyForQuestion(MultivaluedMap<String, String> val) throws JSONException {
        String id = val.getFirst("qId");
        String comment = val.getFirst("comment");
         Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        Map<String, Object> map = new HashMap();
         ReplyingDelegationInt delegationInt = new ReplyingDelegation();
       if(delegationInt.delegateInsert(id, comment)){
           map.put("satatus", true); 
              map.put("comment", "comment sent"); 
       }else{
            map.put("satatus", false);
             map.put("comment", "comment  not sent");
       }
       
       
      
      
        return Response.status(200).entity(g.toJson(map)).build();
    }
}
