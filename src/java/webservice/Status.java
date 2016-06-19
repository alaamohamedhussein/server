/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import businesslogic.DetailsDelegation;
import businesslogic.PorposaDelegation;
import businesslogic.ProjectDelegation;
import businesslogicinterface.DetailsDelegationInt;
import businesslogicinterface.PorposaDelegationInt;
import businesslogicinterface.ProjectDelegationInt;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import pojos.Details;
import pojos.DetailsId;
import pojos.Porposa;

/**
 *
 * @author hassan
 */
@Path("/status")
public class Status {

    @GET
    @Path("/updateStatus")
    public Response selectUser(@QueryParam("porposa") int porposa, @QueryParam("project") int project) throws Exception {
        PorposaDelegationInt delegationInt = new PorposaDelegation();
        Porposa porposa1 = delegationInt.delegateSelect(porposa);
        porposa1.setStatusOfPorposa("acceptance");
        DetailsDelegationInt delegationInt1 = new DetailsDelegation();
        ProjectDelegationInt delegationInt2 = new ProjectDelegation();
        Details details = new Details();
        DetailsId dId = new DetailsId(porposa, project);
        details.setId(dId);
        details.setPorposa(porposa1);
        details.setProjectsforusers(delegationInt2.delegateSelect(project));
        details.setStatusOfProjects("running");
        boolean test = delegationInt1.delegateInsert(details);
        boolean b = delegationInt.delegateInsert(porposa1);
        Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        Map<String, Object> map = new HashMap();
        map.put("satatus", test);
        return Response.status(200).entity(g.toJson(map)).build();
    }

    @GET
    @Path("/updateRefuseStatus")
    public Response refuseUser(@QueryParam("porposa") int porposa, @QueryParam("project") int project) throws Exception {
        PorposaDelegationInt delegationInt = new PorposaDelegation();
        Porposa porposa1 = delegationInt.delegateSelect(porposa);
        porposa1.setStatusOfPorposa("acceptance");
        DetailsDelegationInt delegationInt1 = new DetailsDelegation();
        ProjectDelegationInt delegationInt2 = new ProjectDelegation();
        Details details = new Details();
        DetailsId dId = new DetailsId(porposa, project);
        details.setId(dId);
        details.setPorposa(porposa1);
        details.setProjectsforusers(delegationInt2.delegateSelect(project));
        details.setStatusOfProjects("running");
        boolean test = delegationInt1.delegateInsert(details);
        boolean b = delegationInt.delegateInsert(porposa1);
        Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        Map<String, Object> map = new HashMap();
        map.put("satatus", test);
        return Response.status(200).entity(g.toJson(map)).build();
    }
}
