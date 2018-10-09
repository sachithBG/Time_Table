/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.TM;

/**
 *
 * @author SACHI
 */
public class DepartmentTM {
    private int id;
    private String departmentName; 

    public DepartmentTM() {
    }

    public DepartmentTM(int id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    /**
     * @return the id
     */
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
