/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.service;

import java.util.List;
import lk.camp.time_table.core.TimeTblCorrectFormat;

/**
 *
 * @author SACHI
 */
public interface TimeTblCorrectFormatService {
  
    public boolean addTimeTbl(TimeTblCorrectFormat dto) throws Exception;
    public boolean deleteTimeTbl(int id) throws Exception;
    public boolean updateTimeTbl(TimeTblCorrectFormat dto) throws Exception;
    public TimeTblCorrectFormat searchTimeTbl(int id) throws Exception;
    public List<TimeTblCorrectFormat> getAllTimeTbl() throws Exception;
}
