/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.serviceImp;

import java.util.List;
import lk.camp.time_table.core.Lecture;
import lk.camp.time_table.repoImp.LectureRepoImp;
import lk.camp.time_table.service.LectureService;
import lk.camp.time_table.repo.LectureRepo;

/**
 *
 * @author SACHI
 */
public class LectureServiceImp implements LectureService{

    private LectureRepo lectureRepo = new LectureRepoImp();


    @Override
    public boolean addLectures(Lecture dto) throws Exception {
    return lectureRepo.add(dto);
    }

    @Override
    public boolean deleteLectures(String id) throws Exception {
    return lectureRepo.delete(id);
    }

    @Override
    public boolean updateLectures(Lecture dto) throws Exception {
    return lectureRepo.update(dto);
    }

    @Override
    public Lecture searchLectures(String i) throws Exception {
    return lectureRepo.search(i);
    }

    @Override
    public List<Lecture> getAllLectures() throws Exception {
    return lectureRepo.getAll();
    }

   
    
}
