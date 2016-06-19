/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogicinterface;

import java.util.ArrayList;
import pojos.Category;


/**
 *
 * @author m@pc
 */
public interface CategoryDelegationInt {
   
   public boolean delegateInsert(String categoryName,String imageOfCategoryUrl);
   
   public ArrayList<Category> selectCategorys();
   
    public ArrayList<Category> selectCategorysRondem();
   
    public Category delegateSelect(int id);

    public boolean delegateUpdate(int id, Category c);

    public boolean delegateDelete(int id);
}
