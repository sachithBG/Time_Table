 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.controllerImp;

import java.util.ArrayList;
import java.util.List;
import lk.camp.time_table.controller.LecturesController;
import lk.camp.time_table.core.Lecture;
import lk.camp.time_table.dto.LectureDTO;
import lk.camp.time_table.serviceImp.LectureServiceImp;
import lk.camp.time_table.service.LectureService;

/**
 *
 * @author SACHI
 */
public class LectureControllerImp  implements LecturesController{

    private LectureService lectureService = new LectureServiceImp();
    
    @Override
    public boolean add(LectureDTO dto) throws Exception {
        Lecture lecture = new Lecture();
        lecture.setPwd(dto.getPwd());
        lecture.setNic(dto.getNic());
        lecture.setUserName(dto.getUserName());
        lecture.setPost(dto.getPost());
//        lecture.setDepartment(dto.getDepartment());
//        lecture.setSubject(dto.getSubject());
//        lecture.setCode(dto.getCode());
        
//        StudentDTO studentDTO = dto.getStudentDTO();
//        Students students =new Students(studentDTO.getSid(), studentDTO.getSname(), studentDTO.getSaddress(),
//                studentDTO.getTel());
//        payments.setStudent(students);
        
        boolean addStudents =lectureService.addLectures(lecture);
        if (addStudents) {
            return true;
        }
        return false;   
    }

    @Override
    public boolean delete(String id) throws Exception {
        
         boolean deleteItem = lectureService.deleteLectures(id);
        if (deleteItem) {
            return true;
        }
        return false;
    }
    @Override
    public boolean update(LectureDTO dtO) throws Exception {
            
        Lecture searcStudents = new Lecture();
        searcStudents.setPwd(dtO.getPwd());
        searcStudents.setNic(dtO.getNic());
        searcStudents.setUserName(dtO.getUserName());
        searcStudents.setPost(dtO.getPost());
//        searcStudents.setCode(dtO.getCode());
//        searcStudents.setDepartment(dtO.getDepartment());

        
        boolean UpdateItem = lectureService.updateLectures(searcStudents);
        if (UpdateItem) {
            return true;
        }
        return false;   
    }

    @Override
    public LectureDTO search(String i) throws Exception {
        
       Lecture searcStudents = lectureService.searchLectures(i);
        LectureDTO sdto =  new LectureDTO();
        
        sdto.setPwd(i);
        sdto.setNic(searcStudents.getNic());
        sdto.setUserName(searcStudents.getUserName());
        sdto.setPost(searcStudents.getPost());
//        sdto.setDepartment(searcStudents.getDepartment());
//        sdto.setCode(searcStudents.getCode());
//        sdto.setSubject(searcStudents.getSubject());
        return sdto;
    }

    @Override
    public List<LectureDTO> getAll() throws Exception {
        
            ArrayList<LectureDTO> allstudents = new ArrayList<>();
        List<Lecture> allStudent = lectureService.getAllLectures();
        for (Lecture allStudentses : allStudent) {
            LectureDTO  dTO = new LectureDTO();
            dTO.setNic(allStudentses.getNic());
            dTO.setPwd(allStudentses.getPwd());
            dTO.setUserName(allStudentses.getUserName());
            dTO.setPost(allStudentses.getPost());
//            dTO.setDepartment(allStudentses.getDepartment());
//            dTO.setSubject(allStudentses.getSubject());
//            dTO.setCode(allStudentses.getCode());
            
            allstudents.add(dTO);
        }
       
      return allstudents;
    }
    
}
