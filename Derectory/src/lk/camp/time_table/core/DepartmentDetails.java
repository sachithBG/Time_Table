/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author SACHI
 */
@Entity
public class DepartmentDetails {
    
    private int id;
    private String departmentName;

    public DepartmentDetails() {
    }

    public DepartmentDetails(int id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    /**
     * @return the id
     */
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the departmentName
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * @param departmentName the departmentName to set
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

      
}
