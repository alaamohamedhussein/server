/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import crudsinterface.ImagesProjectCrudInterface;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojos.Projectsimages;
import seesioncreator.SessionCreation;

/**
 *
 * @author m@pc
 */
public class ImagesProjectCrudImplementation  implements ImagesProjectCrudInterface{
    @Override
    public ArrayList<Projectsimages> selectProjectsimages() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Projectsimages selectProjectsimage(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertImageProject(Projectsimages img) {
        boolean flag=true;
      Session se = SessionCreation.getSessionFactory().openSession();
        try{
       se.getTransaction().begin();
       se.saveOrUpdate(img);
       se.getTransaction().commit();
        }catch(HibernateException ex){
            se.getTransaction().rollback();
            ex.printStackTrace();
            flag=false;
        }finally{
            se.close();
        }
        return flag;
    }

    @Override
    public boolean updateImageProject(Projectsimages img) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteImageProject(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   

    @Override
    public Projectsimages selectProjectsimage(String imgName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
