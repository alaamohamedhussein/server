/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogicinterface;

import java.util.ArrayList;
import pojos.Skilltable;
import pojos.Users;

/**
 *
 * @author hassan
 */
public interface SkilltableDelegationInt {

    public void delegateInsert(Skilltable skilltable);

    public Skilltable delegateSelect(int id);

    public void delegateUpdate(Integer id, Skilltable skilltableF);

     public ArrayList<Skilltable> selectSkills();
     
    public void delegateDelete(Integer id);

}
