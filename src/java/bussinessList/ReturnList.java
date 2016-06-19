/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussinessList;

import businesslogic.SkilltableDelegation;
import businesslogic.SkilltableDelegation;
import cruds.ImagesProjectCrudImplementation;
import cruds.TagCrudImplementation;
import crudsinterface.ImagesProjectCrudInterface;
import crudsinterface.TagCrudInterface;
import java.util.ArrayList;
import java.util.List;
import pojos.Category;
import pojos.Phoneofuser;
import pojos.Projectsimages;
import pojos.Skilltable;
import pojos.Tags;

/**
 *
 * @author m@pc
 */
public class ReturnList {
    
    public List<Phoneofuser> returnMobiles(List<String> ph) {
        List<Phoneofuser> phones = new ArrayList<>();
        for (int i = 0; i < ph.size(); i++) {
            Phoneofuser p = new Phoneofuser();
            p.setPhoneNumber(ph.get(i));
            p.setPhoneType("mobiles");
            phones.add(p);
        }
        return phones;
    }
    
    public List<Phoneofuser> returnPhones1(List<String> ph) {
        List<Phoneofuser> phones = new ArrayList<>();
        for (int i = 0; i < ph.size(); i++) {
            Phoneofuser p = new Phoneofuser();
            p.setPhoneNumber(ph.get(i));
            p.setPhoneType("phones");
            phones.add(p);
        }
        return phones;
    }
    
    public List<Phoneofuser> returnPhones1(List<Phoneofuser> ph1, List<Phoneofuser> ph2) {
        List<Phoneofuser> phones = new ArrayList<>();
        for (int i = 0; i < ph1.size(); i++) {
            Phoneofuser p = new Phoneofuser();
            phones.add(ph1.get(i));
        }
        for (int i = 0; i < ph2.size(); i++) {
            Phoneofuser p = new Phoneofuser();
            phones.add(ph2.get(i));
        }
        return phones;
    }
    
    public List<Integer> returnSkills(List<String> sk) {
        List<Integer> skills = new ArrayList<>();
        for (int i = 0; i < sk.size(); i++) {
            int x = Integer.parseInt(sk.get(i));
            skills.add(x);
        }
        return skills;
    }
    
    public List<Skilltable> returnSkillsAll(List<Integer> skk) {
        SkilltableDelegation d = new SkilltableDelegation();
        List<Skilltable> skills = new ArrayList<>();
        for (int i = 0; i < skk.size(); i++) {
            Skilltable st = new Skilltable();
            st = d.delegateSelect(skk.get(i));
            skills.add(st);
        }
        return skills;
    }
    
    public List<Projectsimages> returnImagesAll(List<String> skk) {
        List<Projectsimages> ps = new ArrayList<>();
        for (int i = 0; i < skk.size(); i++) {
            Projectsimages p = new Projectsimages();
            p.setImageUrl(skk.get(i));
           ImagesProjectCrudInterface crudInterface = new ImagesProjectCrudImplementation();
            crudInterface.insertImageProject(p);
            ps.add(p);
        }
        return ps;
    }
    
    public List<Tags> returnTagsAll(List<String> skk, Category cat) {
        List<Tags> ps = new ArrayList<>();
        for (int i = 0; i < skk.size(); i++) {
            Tags p = new Tags();
            TagCrudInterface crudInterface = new TagCrudImplementation();
            p.setTagDescription(skk.get(i));
            p.setCategory(cat);
            TagCrudInterface forProjectsInterface = new TagCrudImplementation();
            forProjectsInterface.insertTag(p);
            ps.add(p);
        }
        return ps;
    }
    
}
