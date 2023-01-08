package com.javarush.model;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String studentName;
    private Map<Subject, Integer> subjectMarkMap = new HashMap<>();

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Map<Subject, Integer> getSubjectMarkMap() {
        return subjectMarkMap;
    }

    public void setSubjectMarkMap(Map<Subject, Integer> subjectMarkMap) {
        this.subjectMarkMap = subjectMarkMap;
    }
}
