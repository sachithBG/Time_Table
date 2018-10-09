/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.repoImp;

import java.io.Serializable;
import java.util.List;
import lk.camp.time_table.configuretion.RegistretionConfiguretion;
import lk.camp.time_table.core.Student;
import lk.camp.time_table.repo.StudentsRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author SACHI
 */
public class StudentsRepoImp implements StudentsRepo{

    private SessionFactory sessionFactory = RegistretionConfiguretion.getSessionFactory();
    
      @Override
    public boolean add(Student dto) throws Exception {
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
        
        Student search = search(id);
        Student students = new Student(search.getRegNo(),search.getUserName(),search.getDepartment(), search.getYearAndSemester(), search.getPassword());
       
//        Set<Payments> payme=new HashSet<>();
//        for (Payments payments : payme) {
//            System.out.println("payment ="+payments.getAmount());
//            Payments payments1 = new Payments(payments.getPid(), payments.getDat(), payments.getAmount(), students);
//            payme.add(payments);
            
//        }
//        Set<Register> register=new HashSet<>();
//        for (Register register1 : register) {
//            System.out.println("YearAndSemester ="+register1.getBatch());
//            Register register2 = new Register(register1.getRid(), register1.getBatch(), register1.getCourse(), students);
//            register.add(register2);
//        }
//        
//        students.setOrderDetail(payme);
//        students.setRegisters(register);   
        Student entity = new Student();
        entity.setPassword(id);
        openSession.delete(entity);
        beginTransaction.commit();
        openSession.close();
        return true;
    }
    @Override
    public boolean update(Student dto) throws Exception {
        Session openSession = sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        openSession.update(dto);
        beginTransaction.commit();
        openSession.close();
        return true;   
    }

    @Override
    public Student search(String id) throws Exception {
        
        
        Session openSession = sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        Student get = (Student) openSession.get(Student.class, id);
        beginTransaction.commit();
        openSession.close();
        return get;
    }

    @Override
    public List<Student> getAll() throws Exception {
       
        Session openSession = sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        List<Student> list = openSession.createQuery("from Student").list();
        beginTransaction.commit();
        openSession.close();
        return list;
    }

}
