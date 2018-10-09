/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.repoImp;

import java.io.Serializable;
import java.util.List;
import lk.camp.time_table.configuretion.RegistretionConfiguretion;
import lk.camp.time_table.core.TimeTable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import lk.camp.time_table.repo.TimeTableRepo;

/**
 *
 * @author SACHI
 */
public class TimeTableRepoImp implements TimeTableRepo{

        private SessionFactory sessionFactory = RegistretionConfiguretion.getSessionFactory();

    @Override
    public boolean add(TimeTable dto) throws Exception {
       
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
        
        TimeTable search = search(id);
//        TimeTable register = new TimeTable(search.getId(),
//                search.getSubject(),search.getYear(),search.getSemester(),
//                search.getLecture() , search.getDate(),search.getTime(),
//                search.getLatestUpdatedTime());
        TimeTable entity = new  TimeTable();
        entity.setSucode(id);
        openSession.delete(entity);
        beginTransaction.commit();
        System.out.println("ok");
        openSession.close();
        return true;
    }

    @Override
    public boolean update(TimeTable dto) throws Exception {
        
        
        Session openSession = sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        openSession.update(dto);
        beginTransaction.commit();
        openSession.close();
        return true;
    }

    @Override
    public TimeTable search(String i) throws Exception {
        
        Session openSession = sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        TimeTable get = (TimeTable) openSession.get(TimeTable.class, i);
        beginTransaction.commit();
        openSession.close();
        return get;
    }

    @Override
    public List<TimeTable> getAll() throws Exception {
        
        Session openSession = sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        List<TimeTable> list = openSession.createQuery("from TimeTable").list();
        beginTransaction.commit();
        openSession.close();
        return list;
    }
    
}
