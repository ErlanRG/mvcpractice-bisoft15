package org.cenfotec.mvcpractice.controller;

import org.cenfotec.mvcpractice.dao.BookDAO;
import org.cenfotec.mvcpractice.model.BookModel;
import org.cenfotec.mvcpractice.model.ConnectionModel;
import org.cenfotec.mvcpractice.view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class BookController {
    private ConsoleView consoleView;
    private BookDAO bookDAO;

    public BookController(ConsoleView consoleView) {
        this.consoleView = consoleView;
        Connection connection = ConnectionModel.getConnection();
        this.bookDAO = bookDAO;
    }

    public void addBook (String name, String author, int publicationYear,int booksAvailables){
        BookModel book = new BookModel(name, author, publicationYear, booksAvailables);
        try {
            bookDAO.addBook(book);
            consoleView.showMessage("Libro agregado correctamente");
        } catch (SQLException e) {
            consoleView.errorMessage("Error al agregar el libro: " + e.getMessage());
        }
    }

    public List<BookModel> getAllBooks() {
        List<BookModel> books = new ArrayList<>();
        try {
            books = bookDAO.findAll();
        } catch (SQLException e) {
            consoleView.errorMessage("Error al consultar los libros: " + e.getMessage());
        }
        return books;
    }

    public void updateBook(BookModel book) {
        try {
            bookDAO.updateBook(book);
            consoleView.showMessage("Libro actualizada correctamente");
        } catch (SQLException e) {
            consoleView.errorMessage("Error al actualizar el libro: " + e.getMessage());
        }
    }

    public void deleteBook(BookModel book) {
        try {
            bookDAO.deleteBook(book);
            consoleView.showMessage("Libro eliminado correctamente");
        } catch (SQLException e) {
            consoleView.errorMessage("Error al eliminar el libro: " + e.getMessage());
        }
    }
}
