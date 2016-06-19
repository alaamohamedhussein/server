package businesslogicinterface;


import java.util.ArrayList;
import pojos.Porposa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hassan
 */
public interface PorposaDelegationInt {

    public boolean delegateInsert(String price,String startDate,String deadLine,String projectId,String SuplierId,String projectStatus);

    public Porposa delegateSelect(Integer id);

    public void delegateUpdate(Integer id, Porposa porposa);

    public void delegateDelete(Integer id);
    
    public boolean delegateInsert(Porposa porposa);
    
    public ArrayList<Object> projectsIds(int porId);
    
    public ArrayList<Porposa> delegateSelectPorposaHQL(int id);
}
