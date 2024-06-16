package org.cenfotec.mvcpractice;

import org.cenfotec.mvcpractice.view.Menu;
import org.cenfotec.mvcpractice.view.Utils;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Utils utils = new Utils();

        int opc;

        do {
            menu.mainMenu();
            opc = utils.readInt();
            menu.processMainMenuOpt(opc);
        } while (opc != 0);
    }
}