/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.repo;

import java.util.List;
import lk.camp.time_table.core.Student;

/**
 *
 * @author SACHI
 */
public interface StudentsRepo {
    public boolean add(Student dto) throws Exception;
    public boolean delete(String id) throws Exception;
    public boolean update(Student dto) throws Exception;
    public Student search(String i) throws Exception;
    public List<Student> getAll() throws Exception;
}
