/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogicinterface;

import java.util.ArrayList;
import pojos.Details;
import pojos.DetailsId;

/**
 *
 * @author m@pc
 */
public interface DetailsDelegationInt {

    public ArrayList<Details> selectDetails(int pId, int PrId);

    public boolean delegateInsert(Details d);

    public Details delegateSetRate(int userId, int projectId, int porposaId, int rate);

    public Details delegateSelect(int id);

    public void delegateUpdate(int id, Details d);

    public void delegateDelete(int id);

    public Details delegateSetCommint(int userId, int projectId, int porposaId, String Comment);
}
