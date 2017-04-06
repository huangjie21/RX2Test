package com.fengying.rx2test;

/**
 * Created by huangjie on 2017/4/5.
 */


public class CourseModel {
    public CourseModel() {
        super();
    }

    private int courseID;
    private String courseName;

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "CourseModel{" +
                "courseID=" + courseID +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
