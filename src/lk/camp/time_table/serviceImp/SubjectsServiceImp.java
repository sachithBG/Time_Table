/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.serviceImp;

import java.util.List;
import lk.camp.time_table.core.Subjects;
import lk.camp.time_table.repo.SubjectsRepo;
import lk.camp.time_table.repoImp.SubjectsRepoImp;
import lk.camp.time_table.service.SubjectService;

/**
 *
 * @author SACHI
 */
public class SubjectsServiceImp implements SubjectService{
    private SubjectsRepo subjectsRepo = new SubjectsRepoImp();

    @Override
    public boolean addSubjects(Subjects dto) throws Exception {
    
        return subjectsRepo.addSubjects(dto);
    }

    @Override
    public boolean deleteSubjects(int id) throws Exception {
    
        return subjectsRepo.deleteSubjects(id);
    }

    @Override
    public boolean updateSubjects(Subjects dto) throws Exception {
    
        return subjectsRepo.updateSubjects(dto);
    }

    @Override
    public Subjects searchSubjects(int id) throws Exception {
    
        return subjectsRepo.searchSubjects(id);
    }

    @Override
    public List<Subjects> getAllSubjects() throws Exception {
    
        return subjectsRepo.getAllSubjects();
    }

    
}
