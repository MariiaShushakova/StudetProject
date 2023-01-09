package com.javarush.controller;

import com.javarush.model.Model;
import com.javarush.view.View;

public class Controller {
    private static final Model model = new Model();
    private static final View view = new View();

    public void execute(){
        while (true) {

            int command = view.printMenuAndReadCommand();

            if (command == 1) view.printBooleanResult(model.addGroup(view.readGroupName()));
            else if (command == 2) view.printBooleanResult(model.addStudent(view.readStudentName(), view.readGroupName()));
            else if (command == 3) view.printBooleanResult(model.addSubject(view.readGroupName(), view.readStudentName(), view.readSubjectName(), view.readMark()));
            else if (command == 4) view.printAll(model.getGroups());
            else if (command == 5) view.printSubjects(model.findSubjectByStudentName(view.readStudentName(), view.readGroupName()));
            else if (command == 6) view.printGroup(model.findGroupByStudentName(view.readStudentName()));
            else if (command == 7) view.printGroups(model.findGroupBySubjectName(view.readSubjectName()));
            else if (command == 8) view.printStudentMarks(model.getAllStudents(view.readGroupName()));
            else if (command == 9) view.printBooleanResult(model.addSubject(view.readGroupName(), view.readStudentName(), view.readSubjectName(), view.readMark()));
            else if (command == 10) view.printBooleanResult(model.deleteGroupByGroupName(view.readGroupName()));
            else if (command == 11) break;
            else view.printCommand();
        }
    }
}
