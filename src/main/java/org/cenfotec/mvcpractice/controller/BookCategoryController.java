package org.cenfotec.mvcpractice.controller;

import org.cenfotec.mvcpractice.dao.BookCategoryDAO;
import org.cenfotec.mvcpractice.dao.CategoryDAO;
import org.cenfotec.mvcpractice.model.BookCategoryModel;
import org.cenfotec.mvcpractice.model.ConnectionModel;
import org.cenfotec.mvcpractice.model.PersonModel;
import org.cenfotec.mvcpractice.view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookCategoryController {
    private ConsoleView consoleView;
    private BookCategoryDAO bookCategoryDAO;
    private CategoryDAO categoryDAO;

    public BookCategoryController (ConsoleView consoleView){
        this.consoleView = consoleView;
        Connection connection = ConnectionModel.getConnection();
        this.bookCategoryDAO = new BookCategoryDAO(connection);
        this.categoryDAO = new CategoryDAO(connection);
    }

    public void addBookCategory (int idBook, int idCategory){
        BookCategoryModel bookCategory = new BookCategoryModel(idBook, idCategory);

        try{
            bookCategoryDAO.addBookCategory(bookCategory);
            consoleView.showMessage("Rol ID: " + bookCategory.getIdCategory() + " fue agregado correctamente al Libro ID: " + bookCategory.getIdBook());
        } catch (SQLException e){
            consoleView.errorMessage("Error al agregar la relación: " + e.getMessage());
        }
    }


    public void deleteBookCategory(BookCategoryModel bookCategory) {
        try {
            bookCategoryDAO.deleteBookCategory(bookCategory);
            consoleView.showMessage("Categoría de libro eliminada correctamente");
        } catch (SQLException e) {
            consoleView.errorMessage("Error al eliminar la categoría de libro: " + e.getMessage());
        }
    }

}
