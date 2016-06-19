/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import businesslogicinterface.PortofolioiamgesDelegationInt;
import cruds.ImagesPortofolioCrudImplementation;
import crudsinterface.PortofolioiamgesCrudInterface;
import pojos.Portofolioimages;

/**
 *
 * @author hassan
 */
public class PortofolioiamgesDelegation implements PortofolioiamgesDelegationInt {

    @Override
    public void delegateInsert(Portofolioimages p) {

        PortofolioiamgesCrudInterface crud = new ImagesPortofolioCrudImplementation();
        crud.insertImagePortofolio(p);

    }

    @Override
    public Portofolioimages delegateSelect(Integer id) {

        PortofolioiamgesCrudInterface crud = new ImagesPortofolioCrudImplementation();
        return crud.select(id);

    }

    @Override
    public void delegateUpdate(Integer id, Portofolioimages p) {

        PortofolioiamgesCrudInterface crud = new ImagesPortofolioCrudImplementation();
        crud.update(id, p);

    }

    @Override
    public void delegateDelete(Integer id) {

        PortofolioiamgesCrudInterface crud = new ImagesPortofolioCrudImplementation();
        crud.delete(id);

    }

}
