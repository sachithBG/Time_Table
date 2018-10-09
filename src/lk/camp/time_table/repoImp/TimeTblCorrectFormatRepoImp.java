/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.repoImp;

import java.io.Serializable;
import java.util.List;
import lk.camp.time_table.configuretion.RegistretionConfiguretion;
import lk.camp.time_table.core.Subjects;
import lk.camp.time_table.core.TimeTblCorrectFormat;
import lk.camp.time_table.repo.TimeTblCorrectFormatRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author SACHI
 */
public class TimeTblCorrectFormatRepoImp implements TimeTblCorrectFormatRepo{
    
    private SessionFactory sessionFactory = RegistretionConfiguretion.getSessionFactory();

    @Override
    public boolean addTimeTbl(TimeTblCorrectFormat dto) throws Exception {
    
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
    public boolean deleteTimeTbl(int id) throws Exception {
    
        Session openSession = sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        Subjects entity = new Subjects();
        entity.setId(id);
        openSession.delete(entity);
        beginTransaction.commit();
        openSession.close();
        return true;
    }

    @Override
    public boolean updateTimeTbl(TimeTblCorrectFormat dto) throws Exception {
    
        Session openSession = sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
//        Subjects entity = new Subjects();
//        entity.setId(dto);
//        openSession.update(entity);
        openSession.update(dto);
        beginTransaction.commit();
        openSession.close();
        return true; 
    }

    @Override
    public TimeTblCorrectFormat searchTimeTbl(int id) throws Exception {
    
        Session openSession = sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        TimeTblCorrectFormat get = (TimeTblCorrectFormat) openSession.get(TimeTblCorrectFormat.class, id);
        beginTransaction.commit();
        openSession.close();
        return get;
    }

    @Override
    public List<TimeTblCorrectFormat> getAllTimeTbl() throws Exception {
    
        Session openSession = sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        List<TimeTblCorrectFormat> list = openSession.createQuery("from TimeTblCorrectFormat").list();
        beginTransaction.commit();
        openSession.close();
        return list;
    }
    
}
