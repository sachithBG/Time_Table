/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.dto;

/**
 *
 * @author SACHI
 */
public class DepartmentDeDTO {
    private int id;
    private String DName;

    public DepartmentDeDTO() {
    }

    public DepartmentDeDTO(int id, String DName) {
        this.id = id;
        this.DName = DName;
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
     * @return the DName
     */
    public String getDName() {
        return DName;
    }

    /**
     * @param DName the DName to set
     */
    public void setDName(String DName) {
        this.DName = DName;
    }
}
