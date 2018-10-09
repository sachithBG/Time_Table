/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.core;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author SACHI
 */
@Entity
public class LectureDetails {

    private int id;
    private String nicCode;
    private String DepaName;
    private String LectureName;
    private String scode;
    private String subject;
    private Lecture lecture;

    public LectureDetails() {
    }

    public LectureDetails(int id, String nicCode, String DepaName, 
            String LectureName, String scode, String subject, Lecture lecture) {
        this.id = id;
        this.nicCode = nicCode;
        this.DepaName = DepaName;
        this.LectureName = LectureName;
        this.scode = scode;
        this.subject = subject;
        this.lecture = lecture;
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
     * @return the nicCode
     */
    public String getNicCode() {
        return nicCode;
    }

    /**
     * @param nicCode the nicCode to set
     */
    public void setNicCode(String nicCode) {
        this.nicCode = nicCode;
    }

    /**
     * @return the DepaName
     */
    public String getDepaName() {
        return DepaName;
    }

    /**
     * @param DepaName the DepaName to set
     */
    public void setDepaName(String DepaName) {
        this.DepaName = DepaName;
    }

    /**
     * @return the LectureName
     */
    public String getLectureName() {
        return LectureName;
    }

    /**
     * @param LectureName the LectureName to set
     */
    public void setLectureName(String LectureName) {
        this.LectureName = LectureName;
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
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }
    /**
     * @return the lecture
     */
    @ManyToOne(cascade = CascadeType.ALL)
    public Lecture getLecture() {
        return lecture;
    }

    /**
     * @param lecture the lecture to set
     */
    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }
    
}
