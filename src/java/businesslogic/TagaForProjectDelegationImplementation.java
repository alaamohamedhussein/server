/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import businesslogicinterface.TagsForProjectDelegationInt;
import cruds.TagsForProjectsImplementation;
import crudsinterface.TagsForProjectsInterface;
import pojos.Tagsofprojects;

/**
 *
 * @author m@pc
 */
public class TagaForProjectDelegationImplementation  implements TagsForProjectDelegationInt{

    @Override
    public void delegateInsert(Tagsofprojects tfp) {
 TagsForProjectsInterface tag;
     tag =  new TagsForProjectsImplementation();
     tag.insertTagsOfProjects(tfp);
    
    }

    @Override
    public Tagsofprojects delegateSelect(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delegateUpdate(int id, Tagsofprojects tfp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delegateDelete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
