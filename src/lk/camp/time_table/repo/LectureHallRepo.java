/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.repo;

import java.util.List;
import lk.camp.time_table.core.LectureHall;

/**
 *
 * @author SACHI
 */
public interface LectureHallRepo {
    public boolean add(LectureHall dto) throws Exception;
    public boolean delete(int id) throws Exception;
    public boolean update(LectureHall dto) throws Exception;
    public LectureHall search(int i) throws Exception;
    public List<LectureHall> getAll() throws Exception;
}
