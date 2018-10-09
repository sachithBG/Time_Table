/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.controller;

import java.util.List;
import lk.camp.time_table.dto.StudentDTO;


/**
 *
 * @author SACHI
 */
public interface StudentsController {
    public boolean add(StudentDTO dto) throws Exception;
    public boolean delete(String id) throws Exception;
    public boolean update(StudentDTO dtO) throws Exception;
    public StudentDTO search(String i) throws Exception;
    public List<StudentDTO> getAll() throws Exception;
}
