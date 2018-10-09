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
public class Subjects {
   private int id;
   private String scode;
   private String sname;

    public Subjects() {
    }

    public Subjects(int id, String scode, String sname) {
        this.id = id;
        this.scode = scode;
        this.sname = sname;
    }

    /**
     * @return the id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
