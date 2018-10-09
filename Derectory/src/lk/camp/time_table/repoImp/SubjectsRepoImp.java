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
import lk.camp.time_table.repo.SubjectsRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author SACHI
 */
public class SubjectsRepoImp implements SubjectsRepo{
    
    private SessionFactory sessionFactory = RegistretionConfiguretion.getSessionFactory();

    @Override
    public boolean addSubjects(Subjects dto) throws Exception {
    
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
    public boolean deleteSubjects(int id) throws Exception {
    
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
    public boolean updateSubjects(Subjects dto) throws Exception {
    
        Session openSession = sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        Subjects s = new Subjects(dto.getId(), dto.getScode(), dto.getSname());
        System.out.println("IDvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv"+dto.getId());
//        Subjects entity = new Subjects();
//        entity.setId(id);
//        openSession.delete(entity);
        openSession.update(s);
        beginTransaction.commit();
        openSession.close();
        return true;
    }

    @Override
    public Subjects searchSubjects(int id) throws Exception {
    
        Session openSession = sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        Subjects get = (Subjects) openSession.get(Subjects.class, id);
        beginTransaction.commit();
        openSession.close();
        return get;
    }

    @Override
    public List<Subjects> getAllSubjects() throws Exception {
    
        Session openSession = sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        List<Subjects> list = openSession.createQuery("from Subjects").list();
        beginTransaction.commit();
        openSession.close();
        return list;
    }
    
}
