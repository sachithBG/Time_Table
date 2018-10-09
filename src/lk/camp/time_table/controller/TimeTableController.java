/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.controller;

import java.util.List;
import lk.camp.time_table.dto.TimeTableDTO;


/**
 *
 * @author SACHI
 */
public interface TimeTableController {
    public boolean add(TimeTableDTO dto) throws Exception;
    public boolean delete(String id) throws Exception;
    public boolean update(TimeTableDTO dtO) throws Exception;
    public TimeTableDTO search(String i) throws Exception;
    public List<TimeTableDTO> getAll() throws Exception;
}
