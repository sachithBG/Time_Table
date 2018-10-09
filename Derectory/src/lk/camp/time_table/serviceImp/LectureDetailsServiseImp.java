/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.serviceImp;

import java.util.List;
import lk.camp.time_table.core.LectureDetails;
import lk.camp.time_table.repoImp.LectureDetailsRepoImp;
import lk.camp.time_table.repo.LectureDetailsRepo;
import lk.camp.time_table.service.LectureDetailsService;

/**
 *
 * @author SACHI
 */
public class LectureDetailsServiseImp implements LectureDetailsService{

    private LectureDetailsRepo courseDeRepo = new LectureDetailsRepoImp();
    
    @Override
    public boolean add(LectureDetails dto) throws Exception {

        return courseDeRepo.add(dto);
    }

    @Override
    public boolean delete(int id) throws Exception {

        return courseDeRepo.delete(id);
    }

       @Override
    public boolean update(LectureDetails dto) throws Exception {
    return courseDeRepo.update(dto);   
    }

    @Override
    public LectureDetails search(int i) throws Exception {

        return courseDeRepo.search(i);
    }

    @Override
    public List<LectureDetails> getAll() throws Exception {

        return courseDeRepo.getAll();
    }
  
}
