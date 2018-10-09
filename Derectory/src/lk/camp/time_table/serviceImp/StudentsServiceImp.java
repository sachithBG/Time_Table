/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.serviceImp;

import java.util.List;
import lk.camp.time_table.core.Student;
import lk.camp.time_table.repo.StudentsRepo;
import lk.camp.time_table.repoImp.StudentsRepoImp;
import lk.camp.time_table.service.StudentsService;

/**
 *
 * @author SACHI
 */
public class StudentsServiceImp implements StudentsService{

    private StudentsRepo studentRepo = new StudentsRepoImp();
    
    @Override
    public boolean addStudents(Student dto) throws Exception {

        return studentRepo.add(dto);
    }

    @Override
    public boolean deleteStudents(String id) throws Exception {

        return studentRepo.delete(id);
    }

    @Override
    public boolean updateStudens(Student dto) throws Exception {

        return studentRepo.update(dto);
    }

    @Override
    public Student searchStudents(String i) throws Exception {

        return studentRepo.search(i);
    }

    @Override
    public List<Student> getAllstudents() throws Exception {

        return studentRepo.getAll();
    }

   
    
}
