/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.service;

import java.util.List;
import lk.camp.time_table.core.TimeTable;

/**
 *
 * @author SACHI
 */
public interface TimeTableService {
    public boolean addTimeTable(TimeTable dto) throws Exception;
    public boolean deleteTimeTable(String id) throws Exception;
    public boolean updateTimeTable(TimeTable dto) throws Exception;
    public TimeTable searchTimeTable(String i) throws Exception;
    public List<TimeTable> getAllTimeTable() throws Exception;
}
