/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cruds;

import pojos.Replying;

/**
 *
 * @author hassan
 */
public interface ReplyingCrudInt {

    public void insert(Replying replying);

    public Replying select(Integer id);

    public void update(Integer id, Replying replying);

    public void delete(Integer id);

}
