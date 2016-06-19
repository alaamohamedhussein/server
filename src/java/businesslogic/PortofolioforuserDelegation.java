/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import businesslogicinterface.CategoryDelegationInt;
import businesslogicinterface.PortofolioforuserDelegationInt;
import businesslogicinterface.PortofolioiamgesDelegationInt;
import businesslogicinterface.UsersDelegationInt;
import cruds.PortofolioforuserCrudImplementation;
import crudsinterface.PortofolioforuserCrudInterface;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.binary.Base64;
import pojos.Category;
import pojos.Portofolioforuser;
import pojos.Portofolioimages;
import pojos.Users;

/**
 *
 * @author hassan
 */
public class PortofolioforuserDelegation implements PortofolioforuserDelegationInt{
public static int i =0;
    @Override
    public boolean delegateInsert(int uId,int cId,String names,String contents,String portDescription) {
         boolean flag=false;
         PortofolioforuserCrudInterface crud = new PortofolioforuserCrudImplementation();
         Portofolioforuser p=new Portofolioforuser();
         CategoryDelegationInt cat = new CategoryDelegation();
         Category cate =cat.delegateSelect(cId);
         UsersDelegationInt user = new UsersDelegation();
         Users u = user.delegateSelect(uId);
         List<String> imgList = Arrays.asList((names.split(",")));
         List<String> imgList1 = Arrays.asList((contents.split(",")));
         List<String> imgList2 = new ArrayList();
         for(int i=0;i<imgList.size()&& i< imgList1.size();i++){
             String s =  postMsg2(imgList.get(i), imgList1.get(i));
             System.out.println(s);
             imgList2.add(s);
         }
         p.setUsers(u);
         p.setCategory(cate);
         p.setPortofolioDescription(portDescription);
         boolean x=crud.insert(p);
         if(x==true){
             flag=true;
         }
         PortofolioiamgesDelegationInt tp=new PortofolioiamgesDelegation();
         for(int i=0;i<imgList2.size();i++){
             Portofolioimages   pImag=new Portofolioimages ();
             pImag.setPortfolioImageUrl(imgList2.get(i));
             pImag.setPortofolioforuser(p);
             
             tp.delegateInsert(pImag);
         }
          return flag;
    }

    @Override
    public Portofolioforuser delegateSelect(Integer id) {

        PortofolioforuserCrudInterface crud = new PortofolioforuserCrudImplementation();
        return crud.select(id);

    }

    @Override
    public void delegateUpdate(Integer id, Portofolioforuser portofolioforuser) {

        PortofolioforuserCrudInterface crud = new PortofolioforuserCrudImplementation();
        crud.update(id, portofolioforuser);

    }

    @Override
    public void delegateDelete(Integer id) {

        PortofolioforuserCrudInterface crud = new PortofolioforuserCrudImplementation();
        crud.delete(id);

    }
    
    
    
    
    @Override
    public ArrayList<Portofolioforuser> selectPortofolios(Category cat) {
        PortofolioforuserCrudInterface crud = new PortofolioforuserCrudImplementation();
        ArrayList<Portofolioforuser> portofolios = new ArrayList<>();
        portofolios=crud.selectPortofolios(cat);
        return portofolios;
    }
    
  
    @Override
    public Users selectUser(int pId) {
 PortofolioforuserCrudInterface crud = new PortofolioforuserCrudImplementation();
    return    crud.selectUser(pId);    }

public String postMsg2(String file,String image) {
         String fileName = file;
        System.out.println(image);
        i=i++;
      String filePath = "/home/alaa/Desktop/itiProjectServer/web/images/portofolio/" + (i++)+fileName;
       String path="/images/portofolio/"+(i)+fileName;
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
        String s=imageDataString.replaceAll(" ", "+");
        return Base64.decodeBase64(s.getBytes());
    }
    
     public String photo() throws FileNotFoundException, IOException{
           String imageDataString="";
        for(int i=0;i<3;i++){
         String fileName = "1.png";
        String filePath = "D:\\king\\" + fileName;
        File file = new File(filePath);
            FileInputStream imageInFile = new FileInputStream(file);
            byte imageData[] = new byte[(int) file.length()];
            imageInFile.read(imageData);
             imageDataString = imageDataString.concat(","+encodeImage(imageData));
            //inputStream.read(imageBytes);
        }
     return   imageDataString;  
    }
    
      public static String encodeImage(byte[] imageByteArray) {
        byte[]   bytesEncoded = Base64.encodeBase64(imageByteArray);
        return new String(bytesEncoded);
  
      }}