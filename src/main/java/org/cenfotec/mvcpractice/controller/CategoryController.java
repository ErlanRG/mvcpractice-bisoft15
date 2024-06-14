package org.cenfotec.mvcpractice.controller;

import org.cenfotec.mvcpractice.dao.BookCategoryDAO;
import org.cenfotec.mvcpractice.dao.CategoryDAO;
import org.cenfotec.mvcpractice.model.CategoryModel;
import org.cenfotec.mvcpractice.model.ConnectionModel;
import org.cenfotec.mvcpractice.view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class CategoryController {
    private ConsoleView consoleView;
    private CategoryDAO categoryDAO;
    private BookCategoryDAO bookCategoryDAO;

    public CategoryController(ConsoleView consoleView) {
        this.consoleView = consoleView;
        Connection connection = ConnectionModel.getConnection();
        this.categoryDAO = new CategoryDAO (connection);
        this.bookCategoryDAO = new BookCategoryDAO (connection);
    }
    public void addCategory(String name, String description) {
        CategoryModel category = new CategoryModel(name, description);
        try {
            categoryDAO.addCategory(category);
            consoleView.showMessage("Categoría agregada con éxito");
        } catch (SQLException e) {
            consoleView.errorMessage("Error al agregar la categoría: " + e.getMessage());
        }
    }

    public List<CategoryModel> getAllCategories() {
        List<CategoryModel> categories = new ArrayList<>();
        try {
            categories = categoryDAO.findAll();
        } catch (SQLException e) {
            consoleView.errorMessage("Error al consultar las categorías: " + e.getMessage());
        }
        return categories;
    }

    public void updateCategory(CategoryModel category) {
        try {
            categoryDAO.updateCategory(category);
            consoleView.showMessage("Categoría actualizada correctamente.");
        } catch (SQLException e) {
            consoleView.errorMessage("Error al actualizar la categoría: " + e.getMessage());
        }
    }

    public void deleteCategory(CategoryModel category) {
        try {
            categoryDAO.deleteCategory(category);
            consoleView.showMessage("Categoría eliminada correctamente.");
        } catch (SQLException e) {
            consoleView.errorMessage("Error al eliminar la categoría: " + e.getMessage());
        }
    }


}
