/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.controller;

import java.util.List;
import lk.camp.time_table.dto.TimeTblCorrectFormatDTO;

/**
 *
 * @author SACHI
 */
public interface TimeTblCorrectFormatController {
    public boolean addTimeTbl(TimeTblCorrectFormatDTO dto) throws Exception;
    public boolean deleteTimeTbl(int id) throws Exception;
    public boolean updateTimeTbl(TimeTblCorrectFormatDTO dtO) throws Exception;
    public TimeTblCorrectFormatDTO searchTimeTbl(int id) throws Exception;
    public List<TimeTblCorrectFormatDTO> getAllTimeTbl() throws Exception;
}
