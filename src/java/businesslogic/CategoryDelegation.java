/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import businesslogicinterface.CategoryDelegationInt;
import cruds.CategoryCrudImplementation;
import crudsinterface.CategoryCrudInterface;
import java.util.ArrayList;
import java.util.Random;
import pojos.Category;


/**
 *
 * @author m@pc
 */
public class CategoryDelegation implements CategoryDelegationInt{ 
@Override
    public boolean delegateInsert(String categoryName,String imageOfCategoryUrl) {
 CategoryCrudInterface uc = new CategoryCrudImplementation();
        Category categorytable=new Category();
        categorytable.setCategoryName(categoryName);
        categorytable.setImageOfCategoryUrl(imageOfCategoryUrl);
        return (uc.insertCategoty(categorytable));    }
    @Override
    public Category delegateSelect(int id) {
 CategoryCrudInterface uc = new CategoryCrudImplementation(); 
    return uc.selectCategory(id);}

    @Override
    public boolean delegateUpdate(int id, Category c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean  delegateDelete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Category> selectCategorys() {
 CategoryCrudInterface uc = new CategoryCrudImplementation();  
 ArrayList<Category> cats = uc.selectCategorys();
 return cats;
    }
     @Override
    public ArrayList<Category> selectCategorysRondem() {
 CategoryCrudInterface uc = new CategoryCrudImplementation();  
 ArrayList<Category> cats = uc.selectCategorys();
 return getRandom(cats);
    }
    
    
    
    public static ArrayList<Category> getRandom(ArrayList<Category> array) {
         ArrayList<Category> cat= new ArrayList<Category>();
        for(int i=0;i<array.size();i++){
            Category catt =new Category();
           //catt.setCategoryId(new Random().nextInt(array.get(i).getCategoryId()));
           catt.setCategoryId(new Random().nextInt(array.size()));
           catt.setCategoryName(array.get(i).getCategoryName());
           catt.setImageOfCategoryUrl(array.get(i).getImageOfCategoryUrl());
           cat.add(catt);
        }
   
    //array[rnd];

    return cat;
           
    }  
}
