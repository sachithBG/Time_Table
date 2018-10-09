/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.core;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author sachith
 */
@Entity
public class Student {
    
    private String regNo;
    private String userName;
    private String department;
    private String YearAndSemester;
    private String password;

    public Student() {
    }

    public Student(String regNo, String userName, String department, String YearAndSemester, String password) {
        this.regNo = regNo;
        this.userName = userName;
        this.department = department;
        this.YearAndSemester = YearAndSemester;
        this.password = password;
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

    /**
     * @return the password
     */
    @Id
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
