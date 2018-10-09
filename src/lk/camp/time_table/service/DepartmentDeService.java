/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.service;

import java.util.List;
import lk.camp.time_table.core.DepartmentDetails;

/**
 *
 * @author SACHI
 */
public interface DepartmentDeService {
    public boolean add(DepartmentDetails dto) throws Exception;
    public boolean delete(int id) throws Exception;
    public boolean update(DepartmentDetails dto) throws Exception;
    public DepartmentDetails search(int i) throws Exception;
    public List<DepartmentDetails> getAll() throws Exception;
}
