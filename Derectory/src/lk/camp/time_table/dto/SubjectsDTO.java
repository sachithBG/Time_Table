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
public class SubjectsDTO {
   private int id;
   private String scode;
   private String sname;

    public SubjectsDTO() {
    }

    public SubjectsDTO(int id, String scode, String sname) {
        this.id = id;
        this.scode = scode;
        this.sname = sname;
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
     * @return the scode
     */
    public String getScode() {
        return scode;
    }

    /**
     * @param scode the scode to set
     */
    public void setScode(String scode) {
        this.scode = scode;
    }

    /**
     * @return the sname
     */
    public String getSname() {
        return sname;
    }

    /**
     * @param sname the sname to set
     */
    public void setSname(String sname) {
        this.sname = sname;
    }
   
}
