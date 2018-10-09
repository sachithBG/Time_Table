 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.camp.time_table.core;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author SACHI
 */
@Entity
public class Lecture {
    
     private String pwd;
     private String nic;     
     private String userName;
     private String post;
     private Set<LectureDetails> lectureDetailses =new HashSet<>();

    public Lecture() {
    }

    public Lecture(String pwd, String nic, String userName, String post) {
        this.pwd = pwd;
        this.nic = nic;
        this.userName = userName;
        this.post = post;
    }


    @Id
    public String getPwd() {
        return pwd;
    }

    /**
     * @param pwd the pwd to set
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * @return the nic
     */
    public String getNic() {
        return nic;
    }

    /**
     * @param nic the nic to set
     */
    public void setNic(String nic) {
        this.nic = nic;
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
     * @return the post
     */
    public String getPost() {
        return post;
    }

    /**
     * @param post the post to set
     */
    public void setPost(String post) {
        this.post = post;
    }

    /**
     * @return the lectureDetailses
     */
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "lecture")
    public Set<LectureDetails> getLectureDetailses() {
        return lectureDetailses;
    }

    /**
     * @param lectureDetailses the lectureDetailses to set
     */
    public void setLectureDetailses(Set<LectureDetails> lectureDetailses) {
        this.lectureDetailses = lectureDetailses;
    }


    /**
     * @return the departmentDescription
     */
//    @ManyToOne(cascade = CascadeType.ALL)
//    public Set<DepartmentDescription> getDepartmentDescription() {
//        return departmentDescription;
//    }
//
//    /**
//     * @param departmentDescription the departmentDescription to set
//     */
//    public void setDepartmentDescription(Set<DepartmentDescription> departmentDescription) {
//        this.departmentDescription = departmentDescription;
//    }

}
