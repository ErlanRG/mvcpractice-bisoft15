package org.cenfotec.mvcpractice.dao;

import org.cenfotec.mvcpractice.model.BookModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class BookDAO {
    private Connection connection;

    public BookDAO(Connection connection) {
        this.connection = connection;
    }

    //Añadir un libro a la base de datos//

    public void addBook (BookModel book) throws SQLException{
        String query = "INSERT INTO 'RAN_NAR_BOOK' ('titulo', 'autor','anno publicacion','unidades disponibles') VALUES (?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setInt(3,book.getPublicationYear());
            stmt.setInt(4,book.getBooksAvailables());
            stmt.execute();
        }catch (SQLException e){
            throw e;
        }
    }
    //Mostrar todos los datos//
    public List<BookModel> findAll() throws SQLException{
        List<BookModel> books = new ArrayList<>();
        String query = "SELECT * FROM RAN_NAR_BOOK";

        try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery();) {
            while (rs.next()){
                BookModel book = new BookModel();
                book.setId(rs.getInt("id"));
                book.setAuthor(rs.getString("autor"));
                book.setPublicationYear(rs.getInt("anno_publicacion"));
                book.setBooksAvailables(rs.getInt("unidades_disponibles"));
                books.add(book);
            }
        }catch (SQLException e) {
            throw e;
        }
        return books;
    }

    //Encontrar libro por autor//
    public BookModel findBookByAuthor(String author) throws SQLException{
        BookModel book = null;
        String query = "SELECT * FROM 'RAN_NAR_BOOK' WHERE author = ? ";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, author);
            try (ResultSet rs = stmt.executeQuery()){
                if (rs.next()){
                    book = new BookModel();
                    book.setId(rs.getInt("id"));
                    book.setAuthor(rs.getString("autor"));
                    book.setPublicationYear(rs.getInt("anno_publicacion"));
                    book.setBooksAvailables(rs.getInt("unidades_disponibles"));
                }
            }
        }
        return book;
    }

    //Actualizar datos de un libro//
    public void updateBook (BookModel book) throws SQLException{
        String query = "UPDATE 'RAN_NAR_BOOK' SET 'titulo' =?, 'autor' = ?, 'anno_publicacion'=?, 'unidades_disponibles'=? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setInt(3, book.getPublicationYear());
            stmt.setInt(4, book.getPublicationYear());
            stmt.setInt(5, book.getId());
            stmt.executeUpdate();
        }catch (SQLException e) {
            throw e;
        }
    }

    //ELiminar libro//
    public void deleteLibro(BookModel book) throws SQLException {
        String query = "DELETE FROM `RAN_NAR_BOOK` WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, book.getId());
            stmt.execute();
        } catch (SQLException e) {
            throw e;
        }
    }

}
