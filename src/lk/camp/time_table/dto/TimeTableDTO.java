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
public class TimeTableDTO {
    private String sucode;
    private int tblOrder;
    private String subject;
    private String year;
    private String semester;
    private String lecture;
    private String date;
    private String time;
    private String latestUpdatedTime;

    public TimeTableDTO() {
    }

    public TimeTableDTO(String sucode, int tblOrder, String subject, String year, String semester, String lecture, String date, String time, String latestUpdatedTime) {
        this.sucode = sucode;
        this.tblOrder = tblOrder;
        this.subject = subject;
        this.year = year;
        this.semester = semester;
        this.lecture = lecture;
        this.date = date;
        this.time = time;
        this.latestUpdatedTime = latestUpdatedTime;
    }

    /**
     * @return the sucode
     */
    public String getSucode() {
        return sucode;
    }

    /**
     * @param sucode the sucode to set
     */
    public void setSucode(String sucode) {
        this.sucode = sucode;
    }

    /**
     * @return the tblOrder
     */
    public int getTblOrder() {
        return tblOrder;
    }

    /**
     * @param tblOrder the tblOrder to set
     */
    public void setTblOrder(int tblOrder) {
        this.tblOrder = tblOrder;
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
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @return the semester
     */
    public String getSemester() {
        return semester;
    }

    /**
     * @param semester the semester to set
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * @return the lecture
     */
    public String getLecture() {
        return lecture;
    }

    /**
     * @param lecture the lecture to set
     */
    public void setLecture(String lecture) {
        this.lecture = lecture;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the latestUpdatedTime
     */
    public String getLatestUpdatedTime() {
        return latestUpdatedTime;
    }

    /**
     * @param latestUpdatedTime the latestUpdatedTime to set
     */
    public void setLatestUpdatedTime(String latestUpdatedTime) {
        this.latestUpdatedTime = latestUpdatedTime;
    }

    
}
