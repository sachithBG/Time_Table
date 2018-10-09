/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.service;

import java.util.List;
import lk.camp.time_table.core.Student;

/**
 *
 * @author SACHI
 */
public interface StudentsService {
    public boolean addStudents(Student dto) throws Exception;
    public boolean deleteStudents(String id) throws Exception;
    public boolean updateStudens(Student dto) throws Exception;
    public Student searchStudents(String i) throws Exception;
    public List<Student> getAllstudents() throws Exception;
}
