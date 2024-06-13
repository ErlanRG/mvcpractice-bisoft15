package org.cenfotec.mvcpractice;

import org.cenfotec.mvcpractice.controller.PersonController;
import org.cenfotec.mvcpractice.controller.PersonRolController;
import org.cenfotec.mvcpractice.controller.RolController;
import org.cenfotec.mvcpractice.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello MySQL!");
        ConsoleView consoleView = new ConsoleView();
        PersonController personController = new PersonController(consoleView);
        RolController rolController = new RolController(consoleView);
        PersonRolController personRolController = new PersonRolController(consoleView);
    }
}