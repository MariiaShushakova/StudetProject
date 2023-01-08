package com.javarush.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Group {
    private String groupName;
    private List<Student> studentList = new ArrayList<>();

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
        Group group = (Group) o;
        return Objects.equals(getGroupName(), group.getGroupName()) && Objects.equals(getStudentList(), group.getStudentList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGroupName(), getStudentList());
    }
}
