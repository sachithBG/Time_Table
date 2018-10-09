/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.controllerImp;

import java.util.ArrayList;
import java.util.List;
import lk.camp.time_table.controller.StudentsController;
import lk.camp.time_table.core.Student;
import lk.camp.time_table.dto.StudentDTO;
import lk.camp.time_table.service.StudentsService;
import lk.camp.time_table.service.SubjectService;
import lk.camp.time_table.serviceImp.StudentsServiceImp;
import lk.camp.time_table.serviceImp.SubjectsServiceImp;

/**
 *
 * @author SACHI
 */
public class StudentsControllerImp implements StudentsController{
    private StudentsService studentsService = new StudentsServiceImp();
    
    @Override
    public boolean add(StudentDTO dto) throws Exception {
       
        Student students = new Student();
        students.setRegNo(dto.getRegNo());
        students.setUserName(dto.getUserName());
        students.setDepartment(dto.getDepartment());
        students.setYearAndSemester(dto.getYearAndSemester());
        students.setPassword(dto.getPassword());
        
        boolean addStudents = studentsService.addStudents(students);
        if (addStudents) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
          
        boolean deleteItem = studentsService.deleteStudents(id);
        if (deleteItem) {
            return true;
        }
        return false;
    }

    @Override
    public boolean update(StudentDTO dtO) throws Exception {
        
        Student searcStudents = new Student();
        searcStudents.setRegNo(dtO.getRegNo());
        searcStudents.setUserName(dtO.getUserName());
        searcStudents.setDepartment(dtO.getDepartment());
        searcStudents.setYearAndSemester(dtO.getYearAndSemester());
        searcStudents.setPassword(dtO.getPassword());
        boolean UpdateItem = studentsService.updateStudens(searcStudents);
        if (UpdateItem) {
            return true;
        }
        return false;
    }

    @Override
    public StudentDTO search(String i) throws Exception {
       
        Student searcStudents = studentsService.searchStudents(i);
        StudentDTO sdto =  new StudentDTO();
        
        sdto.setRegNo(searcStudents.getRegNo());
        sdto.setUserName(searcStudents.getUserName());
        sdto.setDepartment(searcStudents.getDepartment());
        sdto.setYearAndSemester(searcStudents.getYearAndSemester());
        sdto.setPassword(searcStudents.getPassword());
        return sdto;
    }

    @Override
    public List<StudentDTO> getAll() throws Exception {
       
        
         ArrayList<StudentDTO> allstudents = new ArrayList<>();
        List<Student> allStudent = studentsService.getAllstudents();
        for (Student allStudentses : allStudent) {
            StudentDTO  dTO = new StudentDTO();
            dTO.setRegNo(allStudentses.getRegNo());
            dTO.setUserName(allStudentses.getUserName());
            dTO.setDepartment(allStudentses.getDepartment());
            dTO.setYearAndSemester(allStudentses.getYearAndSemester());
            dTO.setPassword(allStudentses.getPassword());
            allstudents.add(dTO);
        }
       
      return allstudents;
    }
    
}
