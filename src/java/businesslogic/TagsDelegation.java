/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import businesslogicinterface.TagsDelegationInt;
import cruds.CategoryCrudImplementation;
import cruds.TagCrudImplementation;
import crudsinterface.CategoryCrudInterface;
import crudsinterface.TagCrudInterface;
import pojos.Category;
import pojos.Tags;

/**
 *
 * @author m@pc
 */
public class TagsDelegation   implements TagsDelegationInt{

     @Override
    public boolean delegateInsert(int id,String description) {
  CategoryCrudInterface categoryCrudInterface = new CategoryCrudImplementation();
        Category categorytable = categoryCrudInterface.selectCategory(id);
        Tags tagstable = new Tags( description);
        tagstable.setCategory(categorytable);
        TagCrudInterface uc = new TagCrudImplementation();
        return (uc.insertTag(tagstable));
    }

    @Override
    public Tags delegateSelect(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delegateUpdate(int id, Tags tag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delegateDelete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
}
