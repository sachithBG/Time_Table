/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.controller;

import java.util.List;
import lk.camp.time_table.dto.LectureDTO;

/**
 *
 * @author SACHI
 */
public interface LecturesController {
    public boolean add(LectureDTO dto) throws Exception;
    public boolean delete(String id) throws Exception;
    public boolean update(LectureDTO dtO) throws Exception;
    public LectureDTO search(String i) throws Exception;
    public List<LectureDTO> getAll() throws Exception;
}
