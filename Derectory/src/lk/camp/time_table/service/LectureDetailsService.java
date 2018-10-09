/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.service;

import java.util.List;
import lk.camp.time_table.core.LectureDetails;

/**
 *
 * @author SACHI
 */
public interface LectureDetailsService {
    
    public boolean add(LectureDetails dto) throws Exception;
    public boolean delete(int id) throws Exception;
    public boolean update(LectureDetails dto) throws Exception;
    public LectureDetails search(int i) throws Exception;
    public List<LectureDetails> getAll() throws Exception;
}
