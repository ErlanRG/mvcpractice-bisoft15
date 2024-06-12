package org.conexionmysql;

import controller.CourseController;
import view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello MySQL!");
        ConsoleView consoleView = new ConsoleView();
        CourseController courseController = new CourseController(consoleView);
        String courseName = "Ingles";
        int estado = 1;
        courseController.agregarCurso(courseName, estado);
    }
}