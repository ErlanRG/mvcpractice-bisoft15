package org.cenfotec.mvcpractice.dao;

import org.cenfotec.mvcpractice.model.LoanModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoanDAO {
    private Connection connection;

    public LoanDAO(Connection connection) {this.connection = connection;}

    //Añadir//
    public void addLoan(LoanModel loan) throws  SQLException{
        String query = "INSERT_INTO 'RAN_NAR_'('id_libro', 'id_persona', 'fehca_prestamo', 'fecha_devolucion') VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, loan.getIdBook());
            stmt.setInt(2, loan.getIdPerson());
            stmt.setDate(3, loan.getDateLoan());
            stmt.setDate(4, (Date) loan.getDateDevolution());
            stmt.execute();
        } catch (SQLException e) {
            throw e;
        }
    }

    //Mostrar//
    public List<LoanModel> findAll() throws SQLException {
        List<LoanModel> loans = new ArrayList<>();
        String query = "SELECT * FROM RAN_NAR_Loan";
        try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {
                LoanModel loan = new LoanModel();
                loan.setId(rs.getInt("id"));
                loan.setIdBook(rs.getInt("id_libro"));
                loan.setIdPerson(rs.getInt("id_persona"));
                loan.setDateLoan(rs.getDate("fecha_prestamo"));
                loan.setDateDevolution(rs.getDate("fecha_devolucion"));
                loans.add(loan);
            }
        } catch (SQLException e) {
            throw e;
        }
        return loans;
    }

    //Buscar por id//
    public LoanModel findById(int id) throws SQLException {
        LoanModel loan = null;
        String query = "SELECT * FROM RAN_NAR_Loan WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    loan = new LoanModel();
                    loan.setId(rs.getInt("id"));
                    loan.setIdBook(rs.getInt("id_libro"));
                    loan.setIdPerson(rs.getInt("id_persona"));
                    loan.setDateLoan(rs.getDate("fecha_prestamo"));
                    loan.setDateDevolution(rs.getDate("fecha_devolucion"));
                }
            }
        }
        return loan;
    }

    //Modificar//
    public void updateLoan(LoanModel loan) throws  SQLException{
        String query = "UPDATE 'RAN_NAR_Loan'SET 'id_Libro' = ?, 'id_persona'=?, 'fecha_prestamo' = ?, 'fehca_devolucion' = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, loan.getIdBook());
            stmt.setInt(2, loan.getIdPerson());
            stmt.setDate(3, loan.getDateLoan());
            stmt.setDate(4, (Date) loan.getDateDevolution());
            stmt.execute();
        } catch (SQLException e) {
            throw e;
        }
    }

    //Eliminar//
    public void deleteRole(LoanModel loan) throws SQLException {
        String query = "DELETE FROM `RAN_NAR_Loan` WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, loan.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

}
