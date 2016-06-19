/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import businesslogic.DetailsDelegation;
import businesslogicinterface.DetailsDelegationInt;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import pojos.Details;

/**
 *
 * @author hassan
 */
@Path("/details")
public class DetailsWebService {

    @POST
    @Path("/updateComment")
    public Response updateComment(MultivaluedMap<String, String> val) throws Exception {

        DetailsDelegationInt detailsDelegationInt = new DetailsDelegation();
        int userId = Integer.parseInt(val.getFirst("userId"));
        int projectId = Integer.parseInt(val.getFirst("projectId"));
        int porposaId = Integer.parseInt(val.getFirst("porposaId"));
        String comment = val.getFirst("Comment");
        Details details = detailsDelegationInt.delegateSetCommint(userId, projectId, porposaId, comment);
        Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        Map<String, Object> map = new HashMap();
        map.put("satatus", details);
        return Response.status(200).entity(g.toJson(map)).build();
    }

    @POST
    @Path("/updateRate")
    public Response updateRate(MultivaluedMap<String, String> val) throws Exception {
        DetailsDelegationInt detailsDelegationInt = new DetailsDelegation();
        int userId = Integer.parseInt(val.getFirst("userId"));
        int projectId = Integer.parseInt(val.getFirst("projectId"));
        int porposaId = Integer.parseInt(val.getFirst("porposaId"));
        int rate = Integer.parseInt(val.getFirst("rate"));
        Details details = detailsDelegationInt.delegateSetRate(userId, projectId, porposaId, rate);
        Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        Map<String, Object> map = new HashMap();
        map.put("satatus", details);
        return Response.status(200).entity(g.toJson(map)).build();
    }

}
