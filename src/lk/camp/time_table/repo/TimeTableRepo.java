/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.repo;

import java.util.List;
import lk.camp.time_table.core.TimeTable;

/**
 *
 * @author SACHI
 */
public interface TimeTableRepo {
    
    public boolean add(TimeTable dto) throws Exception;
    public boolean delete(String id) throws Exception;
    public boolean update(TimeTable dto) throws Exception;
    public TimeTable search(String i) throws Exception;
    public List<TimeTable> getAll() throws Exception;
}
