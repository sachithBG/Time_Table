/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.repoImp;

import java.io.Serializable;
import java.util.List;
import lk.camp.time_table.configuretion.RegistretionConfiguretion;
import lk.camp.time_table.core.LectureDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import lk.camp.time_table.repo.LectureDetailsRepo;

/**
 *
 * @author SACHI
 */
public class LectureDetailsRepoImp  implements LectureDetailsRepo{

        private SessionFactory sessionFactory = RegistretionConfiguretion.getSessionFactory();

    
    @Override
    public boolean add(LectureDetails dto) throws Exception {
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
        LectureDetails entity = new LectureDetails();
        entity.setId(id);
        openSession.delete(entity);
        beginTransaction.commit();
        openSession.close();
        return true;
    }

    @Override
    public boolean update(LectureDetails dto) throws Exception {
            Session openSession = sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        openSession.update(dto);
        beginTransaction.commit();
        openSession.close();
        return true;   
    }

    @Override
    public LectureDetails search(int i) throws Exception {
      
        Session openSession = sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        LectureDetails get =(LectureDetails) openSession.get(LectureDetails.class, i);
        beginTransaction.commit();
        openSession.close();
        return get;
    }

    @Override
    public List<LectureDetails> getAll() throws Exception {
        
        Session openSession = sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        List<LectureDetails> list = openSession.createQuery("from LectureDetails").list();
        beginTransaction.commit();
        openSession.close();
        return list;
    }


    
}
