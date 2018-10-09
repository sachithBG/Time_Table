/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.controller;

import java.util.List;
import lk.camp.time_table.dto.SubjectsDTO;

/**
 *
 * @author SACHI
 */
public interface SubjectsController {
    public boolean addSubjects(SubjectsDTO dto) throws Exception;
    public boolean deleteSubjects(int id) throws Exception;
    public boolean updateSubjects(SubjectsDTO dtO) throws Exception;
    public SubjectsDTO searchSubjects(int id) throws Exception;
    public List<SubjectsDTO> getAllSubjects() throws Exception;
}
