/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import cruds.ProjectCrudImplementation;
import java.util.Date;
import pojos.Projectsforusers;

/**
 *
 * @author hassan
 */
public class Test {

    public static void main(String[] args) {

//        Category cat = new Category();
//        cat.setCategoryName("الاثاث");
//        cat.setImageOfCategoryUrl("mmmm");
//        InsertingClass.insertCategory(cat);
/////////////////////////////////////////////////////////////////
//        Skilltable skl = new Skilltable();
//        skl.setSkillName("انتريهات");
//        InsertingClass.insertSkill(skl);
//        Skilltable skl1 = new Skilltable();
//        skl1.setSkillName("انتريهات");
//
/////////////////////////////////////////////////////////////////
//        Users u = new Users("monaadelrabea@gmail.com", "monaImage", "mamaandbaba", true, "monyAdel", 1000, "مصر", "الغربية", "كفر الزيات", "java devolper", "mona");
//        u.getSkilltables().add(skl);
//        u.getSkilltables().add(skl1);
//        UsersDelegation in = new UsersDelegation();
//        in.delegateInsert(u);
//        skl1.getUserses().add(u);
//        InsertingClass.insertSkill(skl1);
/////////////////////////////////////////////////////////////////
//        ReturnList r = new ReturnList();
//        String Skills = "8,9,10,11,12";
//        List<String> sk = Arrays.asList((Skills.split(",")));
//        List<Integer> ss = r.returnSkills(sk);
//        List<Skilltable> st = r.returnSkillsAll(ss);
//        List<Users> uu = new ArrayList<>();
//        uu.add(u);
//        Set<Skilltable> sss = new HashSet(st);
//        Set<Users> e = new HashSet(uu);
//        u.setSkilltables(sss);
//        System.out.println(u.getSkilltables());
//        in.delegateInsert(u);
//        for (int i = 0; i < st.size(); i++) {
//            st.get(i).setUserses(e);
//            InsertingClass.insertSkill(st.get(i));
//        }
/////////////////////////////////////////////////////////////////
//        Tags tag = new Tags();
//        tag.setTagDescription("الوان بني");
//        tag.setCategory(cat);
//        InsertingClass.insertTag(tag);
/////////////////////////////////////////////////////////////////
//        Projectsforusers P = new Projectsforusers();
//        P.setProjectName("mmmmmmmmmmmmmmmmmmmm");
//        P.setProjectDescription("nnnnnnnnnn");
//        P.setBudget(10000);
//        P.setStartDate(new Date());
//        P.setProjectDeadLine(new Date());
//        P.setCategory(cat);
//        P.setUsers(u);
//        P.getSkilltables().add(skl);
//        P.getSkilltables().add(skl1);
//        InsertingClass.insertProject(P);
/////////////////////////////////////////////////////////////////
//        Projectsimages im = new Projectsimages();
//        im.setImageUrl("mmmmm");
//        im.setProjectsforusers(P);
//        InsertingClass.insertImageForProject(im);
/////////////////////////////////////////////////////////////////
//        Tagsofprojects tp = new Tagsofprojects();
//        tp.setTags(tag);
//        tp.setProjectsforusers(P);
//        InsertingClass.insertTagsOfProjects(tp);
/////////////////////////////////////////////////////////////////
//        Details d = new Details();
//        DetailsId s = new DetailsId(1, 19);
//        d.setId(s);
//        Porposa por = InsertingClass.insertPorposa(1);
//        Projectsforusers pp = InsertingClass.selectPro(19);
//        d.setPorposa(por);
//        d.setProjectsforusers(pp);
//        d.setRateForOwner(5);
//        d.setRateForSuppliers(10);
//        d.setCommentFromOwner("fine");
//        d.setCommentFromSuppliers("good");
//        d.setStatusOfProjects("running");
//        InsertingClass.insertDetatils(d);
//        Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
//        SkilltableDelegationInt s = new SkilltableDelegation();
//        Skilltable n = s.delegateSelect(89);
//        String out = g.toJson(n);
//        System.out.println(out);
        ProjectCrudImplementation b=new ProjectCrudImplementation();
     Projectsforusers o= b.selectProject(1);
    System.out.println( new Date());
    }

}
