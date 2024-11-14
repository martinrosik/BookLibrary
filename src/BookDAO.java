import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Class for CRUD operations over database
public class BookDAO {

    //Method for adding book to database
    public void addBook(Book book) {
        //Sql query for inserting row
        String sql = "INSERT INTO books (id, title, author, year_published, genre) VALUES (?, ?, ?, ?, ?)";

        //Connection to database
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, book.getId());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setInt(4, book.getYear_published());
            ps.setString(5, book.getGenre());
            ps.executeUpdate();
            System.out.println("Book added successfully!");

            //Catching error and priting it to terminal
        } catch (SQLException e) {
            System.out.println("Book already exists!");
        }
    }

    //Method for reading book from database
    public String readBook(int id) {
        //Sql query to selecting row from database
        String sql = "SELECT * FROM books WHERE id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int bookId = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                int yearPublished = rs.getInt("year_published");
                String genre = rs.getString("genre");

                //Returning informations about book
                return String.format("ID: %d, Title: %s, Author: %s, Year Published: %d, Genre: %s",
                        bookId, title, author, yearPublished, genre);
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println("Error retrieving book: " + e.getMessage());
        }
        return "No book found with ID: " + id;
    }

    //Method for updating book in database
    public void updateBook(int id, String title, String author, int yearPublished, String genre) {
        //Sql query to updating row in database
        String sql = "UPDATE books SET title = ?, author = ?, year_published = ?, genre = ? WHERE id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, title);
            ps.setString(2, author);
            ps.setInt(3, yearPublished);
            ps.setString(4, genre);
            ps.setInt(5, id);

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Book updated successfully!");
            } else {
                System.out.println("No book found with the provided ID.");
            }

        } catch (SQLException e) {
            System.err.println("Error editing book: " + e.getMessage());
        }
    }

    //Method for deleting book
    public void deleteBook(String title) {
        //Sql query for deleting row in database
        String sql = "DELETE FROM books WHERE title = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, title);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Book deleted successfully!");
            } else {
                System.out.println("No book found with the given title.");
            }
        } catch (SQLException e) {
            System.err.println("Error deleting book: " + e.getMessage());
        }
    }

}
