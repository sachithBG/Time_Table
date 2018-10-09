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
public class StudentTM {
    private String password;
    private String userName;
    private String regNo;
    private String department;
    private String YearAndSemester;
    

    public StudentTM() {
    }

    public StudentTM(String password, String userName, String regNo, String department, String YearAndSemester) {
        this.password = password;
        this.userName = userName;
        this.regNo = regNo;
        this.department = department;
        this.YearAndSemester = YearAndSemester;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the regNo
     */
    public String getRegNo() {
        return regNo;
    }

    /**
     * @param regNo the regNo to set
     */
    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * @return the YearAndSemester
     */
    public String getYearAndSemester() {
        return YearAndSemester;
    }

    /**
     * @param YearAndSemester the YearAndSemester to set
     */
    public void setYearAndSemester(String YearAndSemester) {
        this.YearAndSemester = YearAndSemester;
    }

}
