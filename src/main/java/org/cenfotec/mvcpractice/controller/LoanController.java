package org.cenfotec.mvcpractice.controller;


import org.cenfotec.mvcpractice.dao.LoanDAO;
import org.cenfotec.mvcpractice.model.ConnectionModel;
import org.cenfotec.mvcpractice.model.LoanModel;
import org.cenfotec.mvcpractice.view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class LoanController {
    private ConsoleView consoleView;
    private LoanDAO loanDAO;

    public LoanController(ConsoleView consoleView) {
        this.consoleView = consoleView;
        Connection connection = ConnectionModel.getConnection();
        this.loanDAO = new LoanDAO(connection);
    }

    public void addLoan (int idBook, int idPerson, Date dateLoan, Date dateDevolution){
        LoanModel loan = new LoanModel(idBook, idPerson, dateLoan, dateDevolution);
        try {
            loanDAO.addLoan(loan);
            consoleView.showMessage("Préstamo agregado con éxito");
        } catch (SQLException e) {
            consoleView.errorMessage("Error al agregar  préstamo: " + e.getMessage());
        }
    }

    public List<LoanModel> getAllLoans() {
        List<LoanModel> loans = new ArrayList<>();
        try {
            loans = loanDAO.findAll();
        } catch (SQLException e) {
            consoleView.errorMessage("Error al consultar preéstamos: " + e.getMessage());
        }
        return loans;
    }

    public void updateLoans(LoanModel loan) {
        try {
            loanDAO.updateLoan(loan);
            consoleView.showMessage("Préstamo actualizado correctamente.");
        } catch (SQLException e) {
            consoleView.errorMessage("Error al actualizar préstamo: " + e.getMessage());
        }
    }

    public void deleteLoan(LoanModel loan) {
        try {
            loanDAO.deleteRole(loan);
            consoleView.showMessage("Préstamo eliminado correctamente.");
        } catch (SQLException e) {
            consoleView.errorMessage("Error al eliminar préstamo: " + e.getMessage());
        }
    }
}
