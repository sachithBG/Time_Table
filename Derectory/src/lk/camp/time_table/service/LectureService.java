/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.service;

import java.util.List;
import lk.camp.time_table.core.Lecture;

/**
 *
 * @author SACHI
 */
public interface LectureService {
    public boolean addLectures(Lecture dto) throws Exception;
    public boolean deleteLectures(String id) throws Exception;
    public boolean updateLectures(Lecture dto) throws Exception;
    public Lecture searchLectures(String i) throws Exception;
    public List<Lecture> getAllLectures() throws Exception;
}
