/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudsinterface;

import java.util.ArrayList;
import pojos.Postforprojects;

/**
 *
 * @author hassan
 */
public interface PostforprojectsCrudInterface {

    public boolean insert(Postforprojects postforprojects);

    public Postforprojects select(int id);

    public boolean update(int id, Postforprojects postforprojects);

    public boolean delete(int id);
    
      public ArrayList<Object> projectsIds(int porId);

}
