/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.serviceImp;

import java.util.List;
import lk.camp.time_table.core.LectureHall;
import lk.camp.time_table.repo.LectureHallRepo;
import lk.camp.time_table.repoImp.LectureHallRepoImp;
import lk.camp.time_table.service.LectureHallService;

/**
 *
 * @author SACHI
 */
public class LectureHallServiceImp implements LectureHallService{

    LectureHallRepo lectureHallRepo = new LectureHallRepoImp();
    
    @Override
    public boolean add(LectureHall dto) throws Exception {
    
        return lectureHallRepo.add(dto);
    }

    @Override
    public boolean delete(int id) throws Exception {
    
        return lectureHallRepo.delete(id);
    }

    @Override
    public boolean update(LectureHall dto) throws Exception {
    
        return lectureHallRepo.update(dto);
    }

    @Override
    public LectureHall search(int i) throws Exception {
    
        return lectureHallRepo.search(i);
    }

    @Override
    public List<LectureHall> getAll() throws Exception {
    
        return lectureHallRepo.getAll();
    }
    
}
