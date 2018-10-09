/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.serviceImp;

import java.util.List;
import lk.camp.time_table.core.TimeTblCorrectFormat;
import lk.camp.time_table.repo.TimeTblCorrectFormatRepo;
import lk.camp.time_table.repoImp.TimeTblCorrectFormatRepoImp;
import lk.camp.time_table.service.TimeTblCorrectFormatService;

/**
 *
 * @author SACHI
 */
public class TimeTblCorrectFormatServiceImp implements TimeTblCorrectFormatService{
    
    private TimeTblCorrectFormatRepo correctFormatRepo = new TimeTblCorrectFormatRepoImp();

    @Override
    public boolean addTimeTbl(TimeTblCorrectFormat dto) throws Exception {
    
        return correctFormatRepo.addTimeTbl(dto);
    }

    @Override
    public boolean deleteTimeTbl(int id) throws Exception {
    
        return correctFormatRepo.deleteTimeTbl(id);
    }

    @Override
    public boolean updateTimeTbl(TimeTblCorrectFormat dto) throws Exception {
    
        return correctFormatRepo.updateTimeTbl(dto);
    }

    @Override
    public TimeTblCorrectFormat searchTimeTbl(int id) throws Exception {
    
        return correctFormatRepo.searchTimeTbl(id);
    }

    @Override
    public List<TimeTblCorrectFormat> getAllTimeTbl() throws Exception {
    
        return correctFormatRepo.getAllTimeTbl();
    }
    
}
