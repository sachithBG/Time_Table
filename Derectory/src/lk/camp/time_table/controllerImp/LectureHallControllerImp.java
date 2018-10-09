/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.controllerImp;

import java.util.ArrayList;
import java.util.List;
import lk.camp.time_table.controller.LectureHallController;
import lk.camp.time_table.core.LectureHall;
import lk.camp.time_table.dto.LectureHallDTO;
import lk.camp.time_table.service.LectureHallService;
import lk.camp.time_table.serviceImp.LectureHallServiceImp;

/**
 *
 * @author SACHI
 */
public class LectureHallControllerImp  implements LectureHallController{
    private LectureHallService  lectureHallService = new LectureHallServiceImp();
    @Override
    public boolean add(LectureHallDTO dto) throws Exception {
        LectureHall lectureHall = new LectureHall();
        lectureHall.setName(dto.getName());
        
        boolean add1 = lectureHallService.add(lectureHall);
        if (add1) {
            return true;
        }
        return false;   
    }

    @Override
    public boolean delete(int id) throws Exception {
    
        boolean deleteItem = lectureHallService.delete(id);
        if (deleteItem) {
            return true;
        }
        return false;
    }

    @Override
    public boolean update(LectureHallDTO dtO) throws Exception {
        LectureHall updateHall = new LectureHall();
        updateHall.setId(dtO.getId());
        updateHall.setName(dtO.getName());
        boolean UpdateItem = lectureHallService.update(updateHall);
        if (UpdateItem) {
            return true;
        }
        return false;   
    }

    @Override
    public LectureHallDTO search(int i) throws Exception {
        LectureHall searchHall = lectureHallService.search(i);
        LectureHallDTO lectureHallDTO = new LectureHallDTO();      
        lectureHallDTO.setId(searchHall.getId());
        lectureHallDTO.setName(searchHall.getName());
        return lectureHallDTO;   
    }

    @Override
    public List<LectureHallDTO> getAll() throws Exception {
         ArrayList<LectureHallDTO> allstudents = new ArrayList<>();
        List<LectureHall> allStudent = lectureHallService.getAll();
        for (LectureHall allStudentses : allStudent) {
            LectureHallDTO  dTO = new LectureHallDTO();
            dTO.setId(allStudentses.getId());
            dTO.setName(allStudentses.getName());
            allstudents.add(dTO);
        }
       
      return allstudents;   
    }
    
}
