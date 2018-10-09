/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.controller;

import java.util.List;
import lk.camp.time_table.dto.LectureDetailsDTO;

/**
 *
 * @author SACHI
 */
public interface LectureDetailsController {
    public boolean add(LectureDetailsDTO dto) throws Exception;
    public boolean delete(int id) throws Exception;
    public boolean update(LectureDetailsDTO dtO) throws Exception;
    public LectureDetailsDTO search(int i) throws Exception;
    public List<LectureDetailsDTO> getAll() throws Exception;
}
