/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.controllerImp;

import java.util.ArrayList;
import java.util.List;
import lk.camp.time_table.controller.TimeTableController;
import lk.camp.time_table.core.TimeTable;
import lk.camp.time_table.dto.TimeTableDTO;
import lk.camp.time_table.serviceImp.TimeTableServiceImp;
import lk.camp.time_table.service.TimeTableService;

/**
 *
 * @author SACHI
 */
public class TimeTableControllerImp implements TimeTableController{

    TimeTableService timeTableService = new TimeTableServiceImp();
    
    @Override
    public boolean add(TimeTableDTO dto) throws Exception {
        
        TimeTable timeTable =new TimeTable();
        
        timeTable.setSucode(dto.getSucode());
        timeTable.setTblOrder(dto.getTblOrder());
        timeTable.setSemester(dto.getSemester());
        timeTable.setSubject(dto.getSubject());
        timeTable.setLecture(dto.getLecture());
        timeTable.setYear(dto.getYear());
        timeTable.setDate(dto.getDate());
        timeTable.setTime(dto.getTime());
        timeTable.setLatestUpdatedTime(dto.getLatestUpdatedTime());
        
//        StudentDTO studentDTO = dto.getStudentDTO();
//        Students students =new Students(studentDTO.getSid(), studentDTO.getSname(),studentDTO.getSaddress(),
//                studentDTO.getTel());
//                
//       register.setStudents(students);
       
       
        boolean addStudents = timeTableService.addTimeTable(timeTable);
        if (addStudents) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
       
        
        boolean deleteItem = timeTableService.deleteTimeTable(id);
        if (deleteItem) {
            return true;
        }
        return false;
    }

    @Override
    public boolean update(TimeTableDTO dtO) throws Exception {
       
        TimeTable searcTable = new TimeTable();
        searcTable.setSucode(dtO.getSucode());
        searcTable.setTblOrder(dtO.getTblOrder());
        searcTable.setSubject(dtO.getSubject());
        searcTable.setLecture(dtO.getLecture());
        searcTable.setSemester(dtO.getSemester());
        searcTable.setYear(dtO.getYear());
        searcTable.setDate(dtO.getDate());
        searcTable.setTime(dtO.getTime());
        searcTable.setLatestUpdatedTime(dtO.getLatestUpdatedTime());
        
        boolean UpdateItem = timeTableService.updateTimeTable(searcTable);
        if (UpdateItem) {
            return true;
        }
        return false;
    }

    @Override
    public TimeTableDTO search(String i) throws Exception {
        
        TimeTable  table= timeTableService.searchTimeTable(i);
        TimeTableDTO tableDTO = new TimeTableDTO(table.getSucode(),table.getTblOrder(), table.getSubject(),
                table.getYear(),table.getSemester(), table.getLecture(),
                table.getDate(), table.getTime(), table.getLatestUpdatedTime());
        
//        Students students = register.getStudents();
//        
//        StudentDTO sdto =new StudentDTO(students.getSid(), students.getSname(), students.getAddress(), students.getTel());
//        RegisterDTO registerDTO =new RegisterDTO(register.getRid(), register.getBatch(),register.getCourse(), sdto);
//        return registerDTO;


          
           return tableDTO;
    }

    @Override
    public List<TimeTableDTO> getAll() throws Exception {
       
             ArrayList<TimeTableDTO> allRegister = new ArrayList<>();
        List<TimeTable> allStudent = timeTableService.getAllTimeTable();
        
        for (TimeTable register : allStudent) {
           
            TimeTableDTO rdto =new TimeTableDTO();
            
            rdto.setSucode(register.getSucode());
            rdto.setTblOrder(register.getTblOrder());
            rdto.setSubject(register.getSubject());
            rdto.setLecture(register.getLecture());
            rdto.setSemester(register.getSemester());
            rdto.setYear(register.getYear());
            rdto.setDate(register.getDate());
            rdto.setTime(register.getTime());
            rdto.setLatestUpdatedTime(register.getLatestUpdatedTime());
//            Students sdto = register.getStudents();
//            StudentDTO dTO = new StudentDTO(sdto.getSid(), sdto.getSname(), sdto.getAddress(), sdto.getTel());
//            rdto.setStudentDTO(dTO);
            allRegister.add(rdto);
        }
      return allRegister;
    }   
}
