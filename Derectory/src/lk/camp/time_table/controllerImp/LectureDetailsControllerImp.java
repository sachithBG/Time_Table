/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.controllerImp;

import java.util.ArrayList;
import java.util.List;
import lk.camp.time_table.core.LectureDetails;
import lk.camp.time_table.dto.LectureDetailsDTO;
import lk.camp.time_table.serviceImp.LectureDetailsServiseImp;
import lk.camp.time_table.controller.LectureDetailsController;
import lk.camp.time_table.service.LectureDetailsService;

/**
 *
 * @author SACHI
 */
public class LectureDetailsControllerImp implements LectureDetailsController{

    private LectureDetailsService departmentService = new LectureDetailsServiseImp();
    
    
    @Override
    public boolean add(LectureDetailsDTO dto) throws Exception {
        
        LectureDetails description = new LectureDetails();
        description.setNicCode(dto.getNicCode());
        description.setDepaName(dto.getDepaName());
        description.setLectureName(dto.getLectureName());
        description.setScode(dto.getScode());
        description.setSubject(dto.getSubject());
        
        boolean addCourses = departmentService.add(description);
        if (addCourses) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) throws Exception {
        
        boolean deleteItem = departmentService.delete(id);
        if (deleteItem) {
            return true;
        }
        return false;
    }

    
    @Override
    public boolean update(LectureDetailsDTO dtO) throws Exception {
        
        LectureDetails courseDescription=new LectureDetails();
               
        courseDescription.setId(dtO.getId());
        courseDescription.setNicCode(dtO.getNicCode());
        courseDescription.setDepaName(dtO.getDepaName());
        courseDescription.setLectureName(dtO.getLectureName());
        courseDescription.setScode(dtO.getScode());
        courseDescription.setSubject(dtO.getSubject());
        
        boolean UpdateItem = departmentService.update(courseDescription);
        if (UpdateItem) {
            return true;
        }
        return false;
    }
        @Override
    public LectureDetailsDTO search(int i) throws Exception {
        
        LectureDetails courseDescription = departmentService.search(i);
        
        LectureDetailsDTO cddto =new LectureDetailsDTO();
        cddto.setId(i);
        cddto.setNicCode(courseDescription.getNicCode());
        cddto.setDepaName(courseDescription.getDepaName());
        cddto.setLectureName(courseDescription.getLectureName());
        cddto.setScode(courseDescription.getScode());
        cddto.setSubject(courseDescription.getSubject());
       
        return cddto;
    }

    @Override
    public List<LectureDetailsDTO> getAll() throws Exception {
       
            ArrayList<LectureDetailsDTO> courseDescriptionDTOs = new ArrayList<>();
        List<LectureDetails> allCourse = departmentService.getAll();   
        for (LectureDetails courseDescription : allCourse) {
            
            LectureDetailsDTO  dTO = new LectureDetailsDTO();
             
            dTO.setId(courseDescription.getId());
            dTO.setNicCode(courseDescription.getNicCode());
            dTO.setDepaName(courseDescription.getDepaName());
            dTO.setLectureName(courseDescription.getLectureName());
            dTO.setScode(courseDescription.getScode());
            dTO.setSubject(courseDescription.getSubject());
            
            courseDescriptionDTOs.add(dTO);
        }
       
      return courseDescriptionDTOs;
    }


    
}
