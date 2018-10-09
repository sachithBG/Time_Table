/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.controllerImp;

import java.util.ArrayList;
import java.util.List;
import lk.camp.time_table.controller.TimeTblCorrectFormatController;
import lk.camp.time_table.core.TimeTblCorrectFormat;
import lk.camp.time_table.dto.TimeTblCorrectFormatDTO;
import lk.camp.time_table.service.TimeTblCorrectFormatService;
import lk.camp.time_table.serviceImp.TimeTblCorrectFormatServiceImp;

/**
 *
 * @author SACHI
 */
public class TimeTblCorrectFormatControllerImp implements TimeTblCorrectFormatController{
    private TimeTblCorrectFormatService formatService = new TimeTblCorrectFormatServiceImp();

    @Override
    public boolean addTimeTbl(TimeTblCorrectFormatDTO dto) throws Exception {
    
        TimeTblCorrectFormat correctft = new TimeTblCorrectFormat();
        correctft.setId(dto.getId());
        correctft.setTimePeriod(dto.getTimePeriod());
        correctft.setSortOrder(dto.getSortOrder());
        correctft.setMonday(dto.getMonday());
        correctft.setTuesday(dto.getThursday());
        correctft.setWednesday(dto.getWednesday());
        correctft.setFriday(dto.getFriday());
        correctft.setSaturday(dto.getSaturday());
        correctft.setThursday(dto.getThursday());
        
        boolean addSubjects = formatService.addTimeTbl(correctft);
        if (addSubjects) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteTimeTbl(int id) throws Exception {
    
        boolean deleteItem = formatService.deleteTimeTbl(id);
        if (deleteItem) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateTimeTbl(TimeTblCorrectFormatDTO dtO) throws Exception {
    
        TimeTblCorrectFormat correctft = new TimeTblCorrectFormat();
        correctft.setId(dtO.getId());
        correctft.setTimePeriod(dtO.getTimePeriod());
        correctft.setSortOrder(dtO.getSortOrder());
        correctft.setMonday(dtO.getMonday());
        correctft.setTuesday(dtO.getThursday());
        correctft.setWednesday(dtO.getWednesday());
        correctft.setFriday(dtO.getFriday());
        correctft.setSaturday(dtO.getSaturday());
        correctft.setThursday(dtO.getThursday());
        boolean updateSubjects = formatService.updateTimeTbl(correctft);
        if (updateSubjects) {
            return true;
        }
        return false;
    }

    @Override
    public TimeTblCorrectFormatDTO searchTimeTbl(int id) throws Exception {
    
        TimeTblCorrectFormat correctft = formatService.searchTimeTbl(id);
        TimeTblCorrectFormatDTO ttcfdto =  new TimeTblCorrectFormatDTO();
        ttcfdto.setId(correctft.getId());
        ttcfdto.setTimePeriod(correctft.getTimePeriod());
        ttcfdto.setSortOrder(correctft.getSortOrder());
        ttcfdto.setMonday(correctft.getMonday());
        ttcfdto.setTuesday(correctft.getThursday());
        ttcfdto.setWednesday(correctft.getWednesday());
        ttcfdto.setFriday(correctft.getFriday());
        ttcfdto.setSaturday(correctft.getSaturday());
        return ttcfdto;
    }

    @Override
    public List<TimeTblCorrectFormatDTO> getAllTimeTbl() throws Exception {
    
        ArrayList<TimeTblCorrectFormatDTO> arrayList = new ArrayList<>();
        List<TimeTblCorrectFormat> allFormats  = formatService.getAllTimeTbl();
        for (TimeTblCorrectFormat correctft : allFormats) {
            TimeTblCorrectFormatDTO formatDTO = new TimeTblCorrectFormatDTO();
            formatDTO.setId(correctft.getId());
            formatDTO.setTimePeriod(correctft.getTimePeriod());
            formatDTO.setSortOrder(correctft.getSortOrder());
            formatDTO.setMonday(correctft.getMonday());
            formatDTO.setTuesday(correctft.getThursday());
            formatDTO.setWednesday(correctft.getWednesday());
            formatDTO.setFriday(correctft.getFriday());
            formatDTO.setSaturday(correctft.getSaturday());
            arrayList.add(formatDTO);
        }       
      return arrayList;
    }
    
}
