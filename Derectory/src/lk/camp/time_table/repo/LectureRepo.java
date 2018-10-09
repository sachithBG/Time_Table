/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.repo;

import java.util.List;
import lk.camp.time_table.core.Lecture;

/**
 *
 * @author SACHI
 */
public interface LectureRepo {
    public boolean add(Lecture dto) throws Exception;
    public boolean delete(String id) throws Exception;
    public boolean update(Lecture dto) throws Exception;
    public Lecture search(String i) throws Exception;
    public List<Lecture> getAll() throws Exception;
}
