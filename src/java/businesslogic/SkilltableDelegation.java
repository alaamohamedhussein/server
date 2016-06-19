/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import businesslogicinterface.SkilltableDelegationInt;
import cruds.SkilltableCrudImplementation;
import crudsinterface.SkilltableCrudInterface;
import java.util.ArrayList;
import pojos.Skilltable;

/**
 *
 * @author hassan
 */
public class SkilltableDelegation implements SkilltableDelegationInt {

    @Override
    public void delegateInsert(Skilltable skilltable) {

        SkilltableCrudInterface crud = new SkilltableCrudImplementation();
        crud.insert(skilltable);

    }

    @Override
    public Skilltable delegateSelect(int id) {

        SkilltableCrudInterface crud = new SkilltableCrudImplementation();
        return crud.select(id);

    }

    @Override
    public void delegateUpdate(Integer id, Skilltable skilltable) {

        SkilltableCrudInterface crud = new SkilltableCrudImplementation();
        crud.update(id, skilltable);

    }

    @Override
    public void delegateDelete(Integer id) {

        SkilltableCrudInterface crud = new SkilltableCrudImplementation();
        crud.delete(id);

    }

    @Override
    public ArrayList<Skilltable> selectSkills() {
  SkilltableCrudInterface crud = new SkilltableCrudImplementation();
        return crud.selectSkills();    }

    
}
