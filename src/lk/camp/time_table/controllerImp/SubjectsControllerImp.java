/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.controllerImp;

import java.util.ArrayList;
import java.util.List;
import lk.camp.time_table.controller.SubjectsController;
import lk.camp.time_table.core.Subjects;
import lk.camp.time_table.dto.SubjectsDTO;
import lk.camp.time_table.service.SubjectService;
import lk.camp.time_table.serviceImp.SubjectsServiceImp;

/**
 *
 * @author SACHI
 */
public class SubjectsControllerImp implements SubjectsController{
   
    private SubjectService subjectService = new SubjectsServiceImp();
         
    @Override
    public boolean addSubjects(SubjectsDTO dto) throws Exception {
    
        Subjects subjects = new Subjects();
        subjects.setScode(dto.getScode());
        subjects.setSname(dto.getSname());
        
        boolean addSubjects = subjectService.addSubjects(subjects);
        if (addSubjects) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteSubjects(int id) throws Exception {
    
        boolean deleteItem = subjectService.deleteSubjects(id);
        if (deleteItem) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateSubjects(SubjectsDTO dtO) throws Exception {
    
        Subjects subjects = new Subjects();
        subjects.setId(dtO.getId());
        subjects.setScode(dtO.getScode());
        subjects.setSname(dtO.getSname());
        boolean updateSubjects = subjectService.updateSubjects(subjects);
        if (updateSubjects) {
            return true;
        }
        return false;
    }

    @Override
    public SubjectsDTO searchSubjects(int id) throws Exception {
    
        Subjects searchSubjects = subjectService.searchSubjects(id);
        SubjectsDTO sdto =  new SubjectsDTO();
        
        sdto.setId(searchSubjects.getId());
        sdto.setScode(searchSubjects.getScode());
        sdto.setSname(searchSubjects.getSname());
        return sdto;
    }

    @Override
    public List<SubjectsDTO> getAllSubjects() throws Exception {
    
        ArrayList<SubjectsDTO> arrayList = new ArrayList<>();
        List<Subjects> allSubjects = subjectService.getAllSubjects();
        for (Subjects allSubject : allSubjects) {
            SubjectsDTO subjectsDTO = new SubjectsDTO();
            subjectsDTO.setId(allSubject.getId());
            subjectsDTO.setScode(allSubject.getScode());
            subjectsDTO.setSname(allSubject.getSname());
            arrayList.add(subjectsDTO);
        }       
      return arrayList;
    }
    
}
