/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.serviceImp;

import java.util.List;
import lk.camp.time_table.core.TimeTable;
import lk.camp.time_table.repoImp.TimeTableRepoImp;
import lk.camp.time_table.repo.TimeTableRepo;
import lk.camp.time_table.service.TimeTableService;

/**
 *
 * @author SACHI
 */
public class TimeTableServiceImp implements TimeTableService{

    private  TimeTableRepo timeTableRepo = new TimeTableRepoImp();
    
    @Override
    public boolean addTimeTable(TimeTable dto) throws Exception {
    return timeTableRepo.add(dto);
    }

    @Override
    public boolean deleteTimeTable(String id) throws Exception {
    return timeTableRepo.delete(id);
    }

    @Override
    public boolean updateTimeTable(TimeTable dto) throws Exception {
    return timeTableRepo.update(dto);
    }

    @Override
    public TimeTable searchTimeTable(String i) throws Exception {
    return timeTableRepo.search(i);
    }

    @Override
    public List<TimeTable> getAllTimeTable() throws Exception {
    return timeTableRepo.getAll();
    }
    
}
