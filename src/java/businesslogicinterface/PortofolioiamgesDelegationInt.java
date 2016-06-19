/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogicinterface;

import pojos.Portofolioimages;

/**
 *
 * @author hassan
 */
public interface PortofolioiamgesDelegationInt {

    public void delegateInsert(Portofolioimages p);

    public Portofolioimages delegateSelect(Integer id);

    public void delegateUpdate(Integer id, Portofolioimages p);

    public void delegateDelete(Integer id);

}
