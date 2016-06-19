/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import businesslogic.TagsDelegation;
import businesslogicinterface.TagsDelegationInt;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author hassan
 */
@Path("/tags")
public class TagsWebService {

    @GET
    @Path("/insertTag")
    public Response insertTag(@QueryParam("categoryId") int categoryId, @QueryParam("tagDescription") String tagDescription) throws Exception {
 TagsDelegationInt tg=new TagsDelegation();
        String code = "";
        String message = "";

        if (tg.delegateInsert(categoryId, tagDescription)) {

            code += "1";
            message += "user exist";

        } else {
            code += "0";
            message += "user not exist";

        }

        JSONObject outputJsonObj1 = new JSONObject();
        outputJsonObj1.put("code", code);
        outputJsonObj1.put("message", message);

        return Response.status(200).entity(outputJsonObj1).build();
    }

}
