/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import businesslogic.SkilltableDelegation;
import businesslogic.UsersDelegation;
import businesslogicinterface.SkilltableDelegationInt;
import businesslogicinterface.UsersDelegationInt;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.apache.commons.codec.binary.Base64;
import org.codehaus.jettison.json.JSONObject;
import pojos.Skilltable;
import pojos.Users;

/**
 *
 * @author hassan
 */
@Path("/authentication")
public class Authentication {

    public static int i = 0;

    @GET
    @Path("/getSkills")
    public Response getAllSkills() {
        SkilltableDelegationInt s = new SkilltableDelegation();
        Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().serializeNulls().create();
        ArrayList<Skilltable> skills = s.selectSkills();
        Map<String, Object> map = new HashMap();
        map.put("satatus", true);
        map.put("skills", skills);
        return Response.status(200).entity(g.toJson(map)).build();
    }

    @POST
    @Path("/register")
    public Response register(MultivaluedMap<String, String> val) throws Exception {

        UsersDelegation ud = new UsersDelegation();
        String userEmail = val.getFirst("userEmail");;
        String userImageUrl = val.getFirst("name");
        String image = val.getFirst("content");
//        String userImageUrl = "1.png";
//        String image = photo();
        String password = val.getFirst("password");
        boolean gender = Boolean.parseBoolean(val.getFirst("gender"));
        String userName = val.getFirst("userName");
        int ped = Integer.parseInt("0");
        String country = val.getFirst("country");
        String governorate = val.getFirst("governorate");
        String city = val.getFirst("ciry");
        String street = val.getFirst("street");
        String summery = val.getFirst("summery");
        String profissionalTitle = val.getFirst("Title");
        String identifire = val.getFirst("identifire");
        /////////////////////////////////////////////////////////////////mobiles
        String mobile = val.getFirst("mobiles");
        //////////////////////////////////////////////////////////////////phones
        String phones = val.getFirst("phones");
        //////////////////////////////////////////////////////////////////Skills
        String Skills = val.getFirst("skill");
        String imagePath = postMsg2(userImageUrl, image);
        Boolean output = ud.delegateInsert(userEmail, imagePath, password, gender, userName, ped, country, governorate, city, street, summery, profissionalTitle, identifire, mobile, phones, Skills);
        JSONObject outputJsonObj1 = new JSONObject();
        System.out.println(output);
        if (output == true) {
            //  int id =ud.delegateSelectId(userEmail);
            // postMsg2(userImageUrl,image);
            System.out.println(output);
            outputJsonObj1.put("output", "ture Insert");
        } else {
            outputJsonObj1.put("output", "Try Another  Email please");
        }
        return Response.status(200).entity(outputJsonObj1).build();
    }

    @POST
    @Path("/login")
    public Response login(MultivaluedMap<String, String> val) throws Exception {

        String message = "login Failed";
        UsersDelegationInt usersDelegationInt = new UsersDelegation();
        Users u = usersDelegationInt.delegateSelectEP(val.getFirst("email"), val.getFirst("pass"));
        if (u.getUserId() != null) {

            message = "login Succesfuly";

        }
        Gson g = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        Map<String, Object> map = new HashMap();
        map.put("message", message);
        map.put("user", u);

        return Response.status(200).entity(g.toJson(map)).build();
    }

    public String postMsg2(String file, String image) {
        String fileName = file;
        System.out.println(image);
        i = i++;
        String filePath = "/home/alaa/Desktop/itiProjectServer/web/images/user/" + (i++) + fileName;
        String path = "/images/user/" + (i) + fileName;
        try {
            byte[] imageByteArray = decodeImage(image);

            // Write a image byte array into file system
            FileOutputStream imageOutFile = new FileOutputStream(filePath);
            imageOutFile.write(imageByteArray);

            imageOutFile.close();

            System.out.println("Image Successfully Manipulated!");
        } catch (FileNotFoundException e) {
            System.out.println("Image not found" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the Image " + ioe);
        }
        return path;
    }

    public static byte[] decodeImage(String imageDataString) {
        String s = imageDataString.replaceAll(" ", "+");
        return Base64.decodeBase64(s.getBytes());
    }

    public String photo() throws FileNotFoundException, IOException {
        String fileName = "1.png";
        String filePath = "D:\\king\\" + fileName;
        File file = new File(filePath);
        FileInputStream imageInFile = new FileInputStream(file);
        byte imageData[] = new byte[(int) file.length()];
        imageInFile.read(imageData);
        String imageDataString = encodeImage(imageData);
        //inputStream.read(imageBytes);

        return imageDataString;
    }

    public static String encodeImage(byte[] imageByteArray) {
        byte[] bytesEncoded = Base64.encodeBase64(imageByteArray);
        return new String(bytesEncoded);
    }

}
