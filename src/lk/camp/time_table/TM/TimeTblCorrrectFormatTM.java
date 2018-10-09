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
public class TimeTblCorrrectFormatTM {
    private int id;
    private String timePeriod;
    private int sortOrder;
    private String Monday;
    private String Tuesday;
    private String Wednesday;
    private String Thursday;
    private String Friday;
    private String Saturday;

    public TimeTblCorrrectFormatTM() {
    }

    public TimeTblCorrrectFormatTM(int id, String timePeriod, int sortOrder, String Monday, String Tuesday, String Wednesday, String Thursday, String Friday, String Saturday) {
        this.id = id;
        this.timePeriod = timePeriod;
        this.sortOrder = sortOrder;
        this.Monday = Monday;
        this.Tuesday = Tuesday;
        this.Wednesday = Wednesday;
        this.Thursday = Thursday;
        this.Friday = Friday;
        this.Saturday = Saturday;
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
     * @return the timePeriod
     */
    public String getTimePeriod() {
        return timePeriod;
    }

    /**
     * @param timePeriod the timePeriod to set
     */
    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
    }

    /**
     * @return the sortOrder
     */
    public int getSortOrder() {
        return sortOrder;
    }

    /**
     * @param sortOrder the sortOrder to set
     */
    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * @return the Monday
     */
    public String getMonday() {
        return Monday;
    }

    /**
     * @param Monday the Monday to set
     */
    public void setMonday(String Monday) {
        this.Monday = Monday;
    }

    /**
     * @return the Tuesday
     */
    public String getTuesday() {
        return Tuesday;
    }

    /**
     * @param Tuesday the Tuesday to set
     */
    public void setTuesday(String Tuesday) {
        this.Tuesday = Tuesday;
    }

    /**
     * @return the Wednesday
     */
    public String getWednesday() {
        return Wednesday;
    }

    /**
     * @param Wednesday the Wednesday to set
     */
    public void setWednesday(String Wednesday) {
        this.Wednesday = Wednesday;
    }

    /**
     * @return the Thursday
     */
    public String getThursday() {
        return Thursday;
    }

    /**
     * @param Thursday the Thursday to set
     */
    public void setThursday(String Thursday) {
        this.Thursday = Thursday;
    }

    /**
     * @return the Friday
     */
    public String getFriday() {
        return Friday;
    }

    /**
     * @param Friday the Friday to set
     */
    public void setFriday(String Friday) {
        this.Friday = Friday;
    }

    /**
     * @return the Saturday
     */
    public String getSaturday() {
        return Saturday;
    }

    /**
     * @param Saturday the Saturday to set
     */
    public void setSaturday(String Saturday) {
        this.Saturday = Saturday;
    }

}
