package com.fengying.rx2test;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by huangjie on 2017/4/5.
 */
@Entity(nameInDb = "Course")
public class CourseModel {

    public CourseModel() {
        super();
    }



    @Generated(hash = 1888948308)
    public CourseModel(Long keyID, int courseID, String courseName, String memo) {
        this.keyID = keyID;
        this.courseID = courseID;
        this.courseName = courseName;
        this.memo = memo;
    }

    @Id(autoincrement = true)
    @Property(nameInDb = "KeyID")
    private Long keyID ;
    @Property(nameInDb = "CourseID")
    private int courseID;
    @Property(nameInDb = "CourseName")
    private String courseName;
    @Property(nameInDb = "Memo")
    private String memo;


    @Override
    public String toString() {
        return "CourseModel{" +
                "courseID=" + courseID +
                ", courseName='" + courseName + '\'' +
                '}';
    }



    public Long getKeyID() {
        return this.keyID;
    }



    public void setKeyID(Long keyID) {
        this.keyID = keyID;
    }



    public int getCourseID() {
        return this.courseID;
    }



    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }



    public String getCourseName() {
        return this.courseName;
    }



    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }



    public String getMemo() {
        return this.memo;
    }



    public void setMemo(String memo) {
        this.memo = memo;
    }



}
