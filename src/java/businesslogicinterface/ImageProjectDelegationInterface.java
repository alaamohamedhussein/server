/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogicinterface;

import java.util.ArrayList;
import pojos.Projectsimages;

/**
 *
 * @author m@pc
 */
public interface ImageProjectDelegationInterface {

    public ArrayList<Projectsimages> delegateSelectImages();

    public Projectsimages delegateSelect(int id);

    public Projectsimages delegateSelect(String imgName);

    public void delegateInsert(Projectsimages img);

    public void delegateUpdate(Projectsimages img, int id);

    public void deleteImageProject(int id);
}
