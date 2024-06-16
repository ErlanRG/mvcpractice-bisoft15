package org.cenfotec.mvcpractice.view;

import java.util.Scanner;

public class Utils {
    public Utils() {
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void pressEnterToContinue() {
        System.out.println("Presione enter para continuar...");
        try {
            System.in.read();
        } catch (Exception ignored) {

        }
    }

    public int readInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Seleccione una opcion: ");
        return scanner.nextInt();
    }

    public String readString(String text) throws IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        String input = null;
        boolean accept = false;

        while (!accept) {
            try {
                System.out.print(text);
                input = scanner.nextLine();
                accept = true;
            } catch (Exception e) {
                throw new IllegalAccessException("El tipo de dato debe ser string");
            }
        }

        return input;
    }

    public boolean readBoolean(String text) throws IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        boolean response = false;
        boolean accept = false;

        while (!accept) {
            try {
                System.out.println(text);
                String input = scanner.nextLine().toLowerCase();
                if (input.equals("si") || input.equals("s")) {
                    response = true;
                    accept = true;
                } else if (input.equals("no") || input.equals("n")) {
                    accept = true;
                } else {
                    System.out.println("Error. Intente de nuevo");
                }
            } catch (Exception e) {
                throw new IllegalAccessException("La respuesta debe ser 'si', 'no', 's' o 'n'");
            }
        }
        return response;
    }
}
