package com.javarush.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//https://www.youtube.com/watch?v=d79-fPULFa4 (1.29min View)
public class Model {

    private static final List<Group> groups = new ArrayList<>();

    public boolean addGroup(String groupName){
        for (Group group: groups) {
            if (group.getGroupName().equals(groupName)){
                return false;
            }
        }
        Group group = new Group();
        group.setGroupName(groupName);
        groups.add(group);

        return true;
    }

    public boolean addStudent(String studentName, String groupName){
        for (Group group: groups) {
            if (group.getGroupName().equals(groupName)){
                Student student = new Student();
                student.setStudentName(studentName);
                group.getStudentList().add(student);
                return true;
            }
        }
        return false;
    }

    public boolean addSubject(String groupName, String studentName, String subjectName, int mark){
        for (Group group: groups) {
            if (group.getGroupName().equals(groupName)){
                for(Student student : group.getStudentList()){
                    if(student.getStudentName().equals(studentName)){
                        Subject subject = new Subject(subjectName);
                        student.getSubjectMarkMap().put(subject, mark);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Set<Subject> findSubjectByStudentName(String nameStudent, String groupName){
        for (Group group:groups) {
            if(group.getGroupName().equals(groupName)){
                for (Student student:group.getStudentList()) {
                    if (student.getStudentName().equals(nameStudent)){
                        return student.getSubjectMarkMap().keySet();
                    }
                }
            }
        }
        return new HashSet<>();
    }

    public Group findGroupByStudentName(String nameStudent){
        for (Group group:groups) {
            for (Student student:group.getStudentList()) {
                if (student.getStudentName().equals(nameStudent)){
                    return group;
                }
            }

        }
        return null;
    }

    public Set<Group> findGroupBySubjectName(String subjectName){
        Set<Group> groupResult = new HashSet<>();

        for (Group group:groups) {
            for (Student student:group.getStudentList()) {
                for (Subject subject: student.getSubjectMarkMap().keySet()) {
                    if (subject.getName().equals(subjectName)) {
                        groupResult.add(group);
                        break;
                    }
                }
            }

        }
        return groupResult;
    }

    public List<Student> getAllStudents(String groupName){
        for (Group group: groups) {
            if (group.getGroupName().equals(groupName)){
                return group.getStudentList();
            }
        }

        return  new ArrayList<>();
    }

    public boolean deleteGroupByGroupName(String groupName){
        int indexToDelete = -1;
        for (int i = 0; i < groups.size(); i++) {
            if(groups.get(i).getGroupName().equals(groupName)){
                indexToDelete = i;
                break;
            }
        }

        if(indexToDelete > -1){
            groups.remove(indexToDelete);
            return true;
        }
        return false;
    }
}
