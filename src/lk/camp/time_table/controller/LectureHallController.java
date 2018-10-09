/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.controller;

import java.util.List;
import lk.camp.time_table.dto.LectureHallDTO;

/**
 *
 * @author SACHI
 */
public interface LectureHallController {
    public boolean add(LectureHallDTO dto) throws Exception;
    public boolean delete(int id) throws Exception;
    public boolean update(LectureHallDTO dtO) throws Exception;
    public LectureHallDTO search(int i) throws Exception;
    public List<LectureHallDTO> getAll() throws Exception;
}
