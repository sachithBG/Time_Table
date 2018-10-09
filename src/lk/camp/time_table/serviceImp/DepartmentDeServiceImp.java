/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.serviceImp;

import java.util.List;
import lk.camp.time_table.core.DepartmentDetails;
import lk.camp.time_table.repo.DepartmentDeRepo;
import lk.camp.time_table.repoImp.DepartmentDeRepoImp;
import lk.camp.time_table.service.DepartmentDeService;

/**
 *
 * @author SACHI
 */
public class DepartmentDeServiceImp implements DepartmentDeService{

    private DepartmentDeRepo departmentDeRepo = new DepartmentDeRepoImp();
    
    @Override
    public boolean add(DepartmentDetails dto) throws Exception {

        return departmentDeRepo.add(dto);
    }

    @Override
    public boolean delete(int id) throws Exception {

        return departmentDeRepo.delete(id);
    }

       @Override
    public boolean update(DepartmentDetails dto) throws Exception {
    return departmentDeRepo.update(dto);   
    }

    @Override
    public DepartmentDetails search(int i) throws Exception {

        return departmentDeRepo.search(i);
    }

    @Override
    public List<DepartmentDetails> getAll() throws Exception {

        return departmentDeRepo.getAll();
    }
}
