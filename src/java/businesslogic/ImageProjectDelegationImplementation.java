/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import businesslogicinterface.ImageProjectDelegationInterface;
import cruds.ImagesProjectCrudImplementation;
import crudsinterface.ImagesProjectCrudInterface;
import java.util.ArrayList;
import pojos.Projectsimages;

/**
 *
 * @author m@pc
 */
public class ImageProjectDelegationImplementation implements ImageProjectDelegationInterface {

    @Override
    public ArrayList<Projectsimages> delegateSelectImages() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Projectsimages delegateSelect(int id) {
        Projectsimages c = new Projectsimages();
        return c;
    }

    @Override
    public void delegateInsert(Projectsimages img) {
        ImagesProjectCrudInterface im;
        im = new ImagesProjectCrudImplementation();
        im.insertImageProject(img);
    }

    @Override
    public void delegateUpdate(Projectsimages img, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteImageProject(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Projectsimages delegateSelect(String imgName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
