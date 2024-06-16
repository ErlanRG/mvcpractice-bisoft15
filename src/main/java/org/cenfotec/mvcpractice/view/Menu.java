package org.cenfotec.mvcpractice.view;

import org.cenfotec.mvcpractice.controller.PersonController;
import org.cenfotec.mvcpractice.model.PersonModel;

import java.util.List;

public class Menu {
    private final Utils utils = new Utils();
    private final ConsoleView consoleView = new ConsoleView();
    private final PersonController personController = new PersonController(consoleView);

    public void mainMenu() {
        System.out.println("1. Administrar personas");
        System.out.println("2. Administrar roles");
        System.out.println("0. Salir");
    }

    public void processMainMenuOpt(int opc) throws IllegalAccessException {
        int subMenuOpc;
        switch (opc) {
            case 0: {
                System.exit(0);
            }

            case 1: {
                utils.clearScreen();
                System.out.println("Administrar personas");
                do {
                    personMenu();
                    subMenuOpc = utils.readInt();
                    processPersonMenuOpt(subMenuOpc);
                } while (subMenuOpc != 0);
                utils.pressEnterToContinue();
                break;
            }

            case 2: {
                utils.clearScreen();
                System.out.println("Administrar roles");
                utils.pressEnterToContinue();
                break;
            }

            default: {
                System.out.println("Opcion invalida");
            }
        }
    }

    private void personMenu() {
        System.out.println("1. Agregar persona");
        System.out.println("2. Modificar persona");
        System.out.println("3. Listar personas");
        System.out.println("4. Eliminar persona");
        System.out.println("0. Salir");
    }

    private void processPersonMenuOpt(int opc) throws IllegalAccessException {
        switch (opc) {
            case 0: {
                break;
            }

            case 1: {
                utils.clearScreen();
                System.out.println("Agregar persona");
                String name = utils.readString("Nombre: ");
                String lName = utils.readString("Apellido: ");
                String email = utils.readString("Email: ");
                String phone = utils.readString("Telefono: ");
                personController.addPerson(name, lName, email, phone);
                utils.pressEnterToContinue();
            }

            case 2: {
                utils.clearScreen();
                System.out.println("Modificar persona");
                String email = utils.readString("Ingrese email de persona a modificar: ");
                PersonModel p1 = personController.getPersonByEmail(email);
                System.out.println("Nombre anterior: " + p1.getName());
                String name = utils.readString("Nuevo nombre: ");
                p1.setName(name);
                System.out.println("Apellido anterior: " + p1.getLastName());
                String lName = utils.readString("Nuevo apellido: ");
                p1.setLastName(lName);
                System.out.println("Email anterior: " + p1.getEmail());
                email = utils.readString("Nuevo email: ");
                p1.setEmail(email);
                System.out.println("Telefono anterior: " + p1.getPhone());
                String phone = utils.readString("Nuevo telefono: ");
                p1.setPhone(phone);
                personController.updatePerson(p1);
                utils.pressEnterToContinue();
            }

            case 3: {
                utils.clearScreen();
                List<PersonModel> personList = personController.getAllPersons();
                for (PersonModel person : personList) {
                    System.out.println(person.toString());
                }
                utils.pressEnterToContinue();
            }

            case 4: {
                utils.clearScreen();
                System.out.println("Eliminar persona");
                String email = utils.readString("Ingrese email de persona a modificar: ");
                PersonModel p1 = personController.getPersonByEmail(email);
                if (p1 != null) {
                    boolean decision = utils.readBoolean("Seguro que desea eliminar a la siguiente persona? (S/N) " + p1.toString());
                    if (decision) {
                        personController.deletePerson(p1);
                    }
                } else {
                    System.out.println("Persona no encontrada");
                }
                utils.pressEnterToContinue();
            }

            default: {
                System.out.println("Opcion invalida");
            }
        }
    }

}
