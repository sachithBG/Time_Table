/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.controllerImp;

import java.util.ArrayList;
import java.util.List;
import lk.camp.time_table.controller.DepartmentDeController;
import lk.camp.time_table.core.DepartmentDetails;
import lk.camp.time_table.dto.DepartmentDeDTO;
import lk.camp.time_table.service.DepartmentDeService;
import lk.camp.time_table.serviceImp.DepartmentDeServiceImp;

/**
 *
 * @author SACHI
 */
public class DepartmentDeControllerImp implements DepartmentDeController{

    private DepartmentDeService deService = new DepartmentDeServiceImp();
    
    @Override
    public boolean add(DepartmentDeDTO dto) throws Exception {
        DepartmentDetails lecture = new DepartmentDetails();
        lecture.setId(dto.getId());
        lecture.setDepartmentName(dto.getDName());
        
//        StudentDTO studentDTO = dto.getStudentDTO();
//        Students students =new Students(studentDTO.getSid(), studentDTO.getSname(), studentDTO.getSaddress(),
//                studentDTO.getTel());
//        payments.setStudent(students);
        
        boolean addStudents =deService.add(lecture);
        if (addStudents) {
            return true;
        }
        return false; 
    }

    @Override
    public boolean delete(int id) throws Exception {        
         boolean deleteItem = deService.delete(id);
        if (deleteItem) {
            return true;
        }
        return false;
    }

    @Override
    public boolean update(DepartmentDeDTO dtO) throws Exception {    
        DepartmentDetails searcStudents = new DepartmentDetails();
        searcStudents.setId(dtO.getId());
        searcStudents.setDepartmentName(dtO.getDName());
 
        boolean UpdateItem = deService.update(searcStudents);
        if (UpdateItem) {
            return true;
        }
        return false;  }

    @Override
    public DepartmentDeDTO search(int i) throws Exception {   
        DepartmentDetails searchDetails = deService.search(i);
        DepartmentDeDTO sdto =  new DepartmentDeDTO();
        
        sdto.setId(i);
        sdto.setDName(searchDetails.getDepartmentName());
        return sdto; }

    @Override
    public List<DepartmentDeDTO> getAll() throws Exception {        
        
        ArrayList<DepartmentDeDTO> allstudents = new ArrayList<>();
        List<DepartmentDetails> allStudent = deService.getAll();
        for (DepartmentDetails allStudentses : allStudent) {
            DepartmentDeDTO  dTO = new DepartmentDeDTO();
            dTO.setId(allStudentses.getId());
            dTO.setDName(allStudentses.getDepartmentName());
            
            allstudents.add(dTO);
        }
       
      return allstudents;
    }
}
    

