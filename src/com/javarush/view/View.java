package com.javarush.view;

import com.javarush.model.Group;
import com.javarush.model.Student;
import com.javarush.model.Subject;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class View {
    private static final Scanner sc = new Scanner(System.in);

    public int printMenuAndReadCommand(){
        System.out.println("Command:");
        System.out.println("1 - add group;");
        System.out.println("2 - add student;");
        System.out.println("3 - add subject;");
        System.out.println("4 - print all;");
        System.out.println("5 - find all subjects by group and student;");
        System.out.println("6 - find group by student;");
        System.out.println("7 - find groups by subject;");
        System.out.println("8 - find marks by group;");
        System.out.println("9 - update mark;");
        System.out.println("10 - delete group;");
        System.out.println("11 - exit;");

        return sc.nextInt();
    }

    public String readGroupName(){
        System.out.println("Enter group name:");
        return sc.nextLine();
    }
    public String readStudentName(){
        System.out.println("Enter student name:");
        return sc.nextLine();
    }
    public String readSubjectName(){
        System.out.println("Enter subject name:");
        return sc.nextLine();
    }
    public int readMark(){
        System.out.println("Enter subject name:");
        return sc.nextInt();
    }
    public void printBooleanResult(boolean result){
        if (result) System.out.println("Success!");
        else System.out.println("Fail");
    }
    public void printSubjects(Set<Subject> subjects){
        System.out.println("Subject list is: ");
        System.out.println(subjects);
    }

    public void printGroup (Group group){
        System.out.println("Group is: ");
        System.out.println(group);
    }

    public void printGroups(Set<Group> groups){
        System.out.println("Group list is: ");
        System.out.println(groups);
    }

    public void printStudentMarks(List<Student> studentList){
        for (Student student:studentList) {
            System.out.println("Student name: " + student.getStudentName());
            for (Map.Entry<Subject,Integer> entry : student.getSubjectMarkMap().entrySet()){
                System.out.println(" " + entry.getKey().getName() + ", : mark :" + entry.getValue());
            }
        }
    }

    public void printAll(List<Group> groups){
        System.out.println("Current system data: ");
        System.out.println(groups);
    }

    public void printCommand(){
        System.out.println("There is no such command!");
    }
}
