package org.cenfotec.mvcpractice.controller;


import org.cenfotec.mvcpractice.dao.LibraryDAO;
import org.cenfotec.mvcpractice.model.ConnectionModel;
import org.cenfotec.mvcpractice.model.LibraryModel;
import org.cenfotec.mvcpractice.view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class LibraryController {
    private ConsoleView consoleView;
    private LibraryDAO libraryDAO;

    public LibraryController(ConsoleView consoleView) {
        this.consoleView = consoleView;
        Connection connection = ConnectionModel.getConnection();
        this.libraryDAO = new LibraryDAO(connection);
    }
public void addLibrary (String name, String address){
    LibraryModel library = new LibraryModel(name, address);
    try {
        libraryDAO.addLibrary(library);
        consoleView.showMessage("Librería agregada con éxito");
    } catch (SQLException e) {
        consoleView.errorMessage("Error al agregar la librería: " + e.getMessage());
    }
}
    public List<LibraryModel> getAllLibraries() {
        List<LibraryModel> libraries = new ArrayList<>();
        try {
            libraries = libraryDAO.findAll();
        } catch (SQLException e) {
            consoleView.errorMessage("Error al consultar las librerías: " + e.getMessage());
        }
        return libraries;
    }

    public void updateLibrary(LibraryModel library) {
        try {
            libraryDAO.updateLibrary(library);
            consoleView.showMessage("Librería actualizada correctamente.");
        } catch (SQLException e) {
            consoleView.errorMessage("Error al actualizar la libraría: " + e.getMessage());
        }
    }

    public void deleteLibrary(LibraryModel library) {
        try {
            libraryDAO.deleteLibrary(library);
            consoleView.showMessage("Librería eliminada correctamente.");
        } catch (SQLException e) {
            consoleView.errorMessage("Error al eliminar la librería: " + e.getMessage());
        }
    }

}
