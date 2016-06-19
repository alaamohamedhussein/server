/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import businesslogic.PorposaDelegation;
import businesslogicinterface.PorposaDelegationInt;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import pojos.Porposa;

/**
 *
 * @author m@pc
 */
@Path("/porposa")
public class PorposerWebService {

    @POST
    @Path("/insertPorposer")
    public Response register(MultivaluedMap<String, String> val) throws Exception {

        PorposaDelegation ud = new PorposaDelegation();
        String price = val.getFirst("price");;
        String startDate = val.getFirst("startDate");
        String deadLine = val.getFirst("deadLine");
        String projectId = val.getFirst("pId");
        String SuplierId = val.getFirst("uId");
        String projectStatus = "applying";
        Boolean output = ud.delegateInsert(price, startDate, deadLine, projectId, SuplierId, projectStatus);
        JSONObject outputJsonObj1 = new JSONObject();
        if (output == true) {
            outputJsonObj1.put("output", "tureInsert");
        } else {
            outputJsonObj1.put("output", "there is some empty data please inter it");
        }
        return Response.status(200).entity(outputJsonObj1).build();
    }

    @GET
    @Path("/getPorposals")
    public Response projectById(@QueryParam("pId") int projectId) throws Exception {
        boolean flag = false;
        PorposaDelegationInt porposaDelegationInt = new PorposaDelegation();
        ArrayList<Porposa> porposa = porposaDelegationInt.delegateSelectPorposaHQL(projectId);
        Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().serializeNulls().create();
        Map<String, Object> map = new HashMap();
        if (porposa.size() > 0) {

            flag = true;

        }
        map.put("satatus", flag);
        map.put("projectPorposa", porposa);
        return Response.status(200).entity(g.toJson(map)).build();
    }

}
