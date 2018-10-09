/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.controller;

import java.util.List;
import lk.camp.time_table.dto.DepartmentDeDTO;

/**
 *
 * @author SACHI
 */
public interface DepartmentDeController {
    public boolean add(DepartmentDeDTO dto) throws Exception;
    public boolean delete(int id) throws Exception;
    public boolean update(DepartmentDeDTO dtO) throws Exception;
    public DepartmentDeDTO search(int i) throws Exception;
    public List<DepartmentDeDTO> getAll() throws Exception;
}
