/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import static businesslogic.PortofolioforuserDelegation.i;
import businesslogicinterface.CategoryDelegationInt;
import businesslogicinterface.ProjectDelegationInt;
import businesslogicinterface.TagsForProjectDelegationInt;
import businesslogicinterface.UsersDelegationInt;
import bussinessList.ReturnList;
import cruds.ImagesProjectCrudImplementation;
import cruds.ProjectCrudImplementation;
import crudsinterface.ImagesProjectCrudInterface;
import crudsinterface.ProjectCrudInterface;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.binary.Base64;
import pojos.Projectsforusers;
import pojos.Projectsimages;
import pojos.Skilltable;
import pojos.Tags;
import pojos.Tagsofprojects;

/**
 *
 * @author m@pc
 */
public class ProjectDelegation implements ProjectDelegationInt {
  public static int i=0;
    @Override
    public boolean delegateInsert(String projectName, String projectDescription, int budget, Date startDate, Date projectDeadLine, String projectsimageses,String content, String skilltables, String tagsofprojectses, int userId, int categoryid) {
//        try {
//            content=photo();
           // SkilltableDelegationInt delegationInt=new SkilltableDelegation();
            Projectsforusers p = new Projectsforusers();
            p.setProjectName(projectName);
            p.setProjectDescription(projectDescription);
            p.setBudget(budget);
            p.setStartDate(startDate);
            p.setProjectDeadLine(projectDeadLine);
            UsersDelegationInt delegationInt = new UsersDelegation();
            p.setUsers(delegationInt.delegateSelect(userId));
            CategoryDelegationInt categoryDelegationInt = new CategoryDelegation();
            p.setCategory(categoryDelegationInt.delegateSelect(categoryid));
            List<String> skList = Arrays.asList((skilltables.split(",")));
            ReturnList returnList = new ReturnList();
            List<Skilltable> list1 = returnList.returnSkillsAll(returnList.returnSkills(skList));
            Set<Skilltable> set1 = new HashSet<>(list1);
            p.setSkilltables(set1);
            List<String> imgList = Arrays.asList((projectsimageses.split(",")));
            List<String> imgList1 = new ArrayList();
            for(int i=0;i<imgList.size();i++){
                String s =  postMsg2(imgList.get(i), content);
                System.out.println(s);
                imgList1.add(s);
            }
            List<Tags> list = returnList.returnTagsAll(Arrays.asList((tagsofprojectses.split(","))), categoryDelegationInt.delegateSelect(categoryid));
            ProjectCrudInterface uc;
            uc = new ProjectCrudImplementation();
            uc.insertProject(p);  
            TagsForProjectDelegationInt forProjectDelegationInterface=new TagaForProjectDelegationImplementation();
             for(int i=0;i<list.size();i++){
             Tagsofprojects tp = new Tagsofprojects();
             tp.setTags(list.get(i));
             tp.setProjectsforusers(p);
             forProjectDelegationInterface.delegateInsert(tp);
            } 
              ImagesProjectCrudInterface tp = new ImagesProjectCrudImplementation();
              for(int i=0;i<imgList1.size();i++){
           Projectsimages  pImag=new Projectsimages();
              pImag.setImageUrl(imgList1.get(i));
              pImag.setProjectsforusers(p);
             tp.insertImageProject(pImag);
            }
//        } catch (IOException ex) {
//            Logger.getLogger(ProjectDelegation.class.getName()).log(Level.SEVERE, null, ex);
//        }
         return true;
    }

    @Override
    public Projectsforusers delegateSelect(int id) {
        
         ProjectCrudInterface uc;
        uc = new ProjectCrudImplementation();
      return  uc.selectProject(id);
    }

    @Override
    public void delegateUpdate(int id, Projectsforusers p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delegateDelete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Projectsforusers> selectLastInterd() {
          System.out.println("in delegation mona");
        ArrayList<Projectsforusers> projects =new ArrayList<>();
         ProjectCrudInterface pc;
        pc = new ProjectCrudImplementation();
      projects =  pc.selectLastInterd();
        return projects;
    }
    @Override
   public ArrayList<Projectsforusers> selectProjects(int id){
      ArrayList<Projectsforusers> projects =new ArrayList<>();
         ProjectCrudInterface pc;
        pc = new ProjectCrudImplementation();
      projects =  pc.selectProjects(id);
        return projects;   
   }

    @Override
    public ArrayList<Projectsforusers> selectBestProjects() {
     ArrayList<Projectsforusers> projects =new ArrayList<>();
         ProjectCrudInterface pc;
        pc = new ProjectCrudImplementation();
      projects =  pc.selectBestProjects();
        return projects;     }
    @Override
    public ArrayList<Projectsforusers> selectAllProjects() {
     ArrayList<Projectsforusers> projects =new ArrayList<>();
         ProjectCrudInterface pc;
        pc = new ProjectCrudImplementation();
      projects =  pc.selectAllProjects();
        return projects;     }
    
      public String postMsg2(String file,String image) {
        
        String fileName = file;
        System.out.println("mona");
        String filePath = "/home/alaa/Desktop/itiProjectServer/web/images/project/"+(i++) + fileName;
         String path="/images/project/"+(i)+fileName;
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
        String d = imageDataString.replaceAll(" ", "+");
       // return Base64.decodeBase64(imageDataString.getBytes());
        return Base64.decodeBase64(d.getBytes());
    }
    
     public String photo() throws FileNotFoundException, IOException{
          String fileName = "1.png";
        String filePath = "D:\\king\\" + fileName;
        File file = new File(filePath);
            FileInputStream imageInFile = new FileInputStream(file);
            byte imageData[] = new byte[(int) file.length()];
            imageInFile.read(imageData);
            String imageDataString = encodeImage(imageData);
            //inputStream.read(imageBytes);
      
     return   imageDataString;  
    }
    
      public static String encodeImage(byte[] imageByteArray) {
        byte[]   bytesEncoded = Base64.encodeBase64(imageByteArray);
        return new String(bytesEncoded);
    }
    
}
