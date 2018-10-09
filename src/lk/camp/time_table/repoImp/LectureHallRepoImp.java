/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.repoImp;

import java.io.Serializable;
import java.util.List;
import lk.camp.time_table.configuretion.RegistretionConfiguretion;
import lk.camp.time_table.core.LectureHall;
import lk.camp.time_table.repo.LectureHallRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author SACHI
 */
public class LectureHallRepoImp implements LectureHallRepo{

    private SessionFactory sessionFactory = RegistretionConfiguretion.getSessionFactory();
    
    @Override
    public boolean add(LectureHall dto) throws Exception {
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
    public boolean delete(int id) throws Exception {
    
        Session openSession = sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        LectureHall entity = new LectureHall();
        entity.setId(id);
        openSession.delete(entity);
        beginTransaction.commit();
        openSession.close();
        return true;
    }

    @Override
    public boolean update(LectureHall dto) throws Exception {
    
        Session openSession = sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        openSession.update(dto);
        beginTransaction.commit();
        openSession.close();
        return true; 
    }

    @Override
    public LectureHall search(int i) throws Exception {
    
        Session openSession = sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        LectureHall get =(LectureHall) openSession.get(LectureHall.class, i);
        beginTransaction.commit();
        openSession.close();
        return get;
    }

    @Override
    public List<LectureHall> getAll() throws Exception {
    
        Session openSession = sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        List<LectureHall> list = openSession.createQuery("from LectureHall").list();
        beginTransaction.commit();
        openSession.close();
        return list;
    }
    
}
