/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.repoImp;

import java.io.Serializable;
import java.util.List;
import lk.camp.time_table.configuretion.RegistretionConfiguretion;
import lk.camp.time_table.core.Lecture;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import lk.camp.time_table.repo.LectureRepo;

/**
 *
 * @author SACHI
 */
public class LectureRepoImp implements LectureRepo{
    private SessionFactory sessionFactory = RegistretionConfiguretion.getSessionFactory();

    @Override
    public boolean add(Lecture dto) throws Exception {
        Session openSession = sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        Serializable save = openSession.save(dto);
        beginTransaction.commit();
        openSession.close();
        if (save != null) {
            return true;
        }
        return false;  
    }
    @Override
    public boolean delete(String id) throws Exception {
        
        Session openSession = sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        Lecture entity = new Lecture();
        entity.setPwd(id);
        openSession.delete(entity);
        beginTransaction.commit();
        openSession.close();
        return true;
    }


    @Override
    public boolean update(Lecture dto) throws Exception {
            Session openSession = sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        openSession.update(dto);
        beginTransaction.commit();
        openSession.close();
        return true;   
    }

    @Override
    public Lecture search(String i) throws Exception {
        
        Session openSession = sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        Lecture get = (Lecture) openSession.get(Lecture.class, i);
        beginTransaction.commit();
        openSession.close();
        return get;
    }

    @Override
    public List<Lecture> getAll() throws Exception {
       
        Session openSession = sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        List<Lecture> list = openSession.createQuery("from Lecture").list();
        beginTransaction.commit();
        openSession.close();
        return list;
    }



    
}
