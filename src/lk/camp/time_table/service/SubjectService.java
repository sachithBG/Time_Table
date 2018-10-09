/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.service;

import java.util.List;
import lk.camp.time_table.core.Subjects;

/**
 *
 * @author SACHI
 */
public interface SubjectService {
    public boolean addSubjects(Subjects dto) throws Exception;
    public boolean deleteSubjects(int id) throws Exception;
    public boolean updateSubjects(Subjects dto) throws Exception;
    public Subjects searchSubjects(int id) throws Exception;
    public List<Subjects> getAllSubjects() throws Exception;
}
