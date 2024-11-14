import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creating instance for CRUD operations
        BookDAO bookDAO = new BookDAO();

        // Creating scanner stream for user input
        Scanner user_input = new Scanner(System.in);

        // This block of code will keep running until user chooses to exit
        while (true) {
            // Printing to the terminal instructions
            System.out.println("Book Library");
            System.out.println("Choose action:");
            System.out.println("Add - 1");
            System.out.println("View - 2");
            System.out.println("Update - 3");
            System.out.println("Delete - 4");
            System.out.println("Exit - 5");
            System.out.println("Enter the number of the operation you want, and follow the prompts");

            try {
                // User inputs instruction
                int user_action = user_input.nextInt();
                user_input.nextLine();

                switch (user_action) {
                    // Case for adding book to the database
                    case 1:
                        System.out.print("ID: ");
                        int id = user_input.nextInt();
                        user_input.nextLine();

                        System.out.print("Title: ");
                        String title = user_input.nextLine();

                        System.out.print("Author: ");
                        String author = user_input.nextLine();

                        System.out.print("Year published: ");
                        int year_published = user_input.nextInt();
                        user_input.nextLine();

                        System.out.print("Genre: ");
                        String genre = user_input.nextLine();

                        // Creating instance of Book
                        Book book = new Book(id, title, author, year_published, genre);

                        // Adding book to the database with method from BookDAO
                        bookDAO.addBook(book);
                        break;

                    case 2:
                        // Case for reading book from the database
                        System.out.print("Input book id: ");
                        int bookID = user_input.nextInt();

                        // Reading book from database and printing it
                        String result = bookDAO.readBook(bookID);
                        System.out.println(result);
                        break;

                    case 3:
                        // Case for editing book in database
                        System.out.print("Input book id you want to edit: ");
                        int editBookID = user_input.nextInt();
                        user_input.nextLine();

                        System.out.print("Enter the new title: ");
                        String newTitle = user_input.nextLine();

                        System.out.print("Enter the new author: ");
                        String newAuthor = user_input.nextLine();

                        System.out.print("Enter the new publication year: ");
                        int newYearPublished = user_input.nextInt();
                        user_input.nextLine();

                        System.out.print("Enter the new genre: ");
                        String newGenre = user_input.nextLine();

                        // Creating instance of new updated book
                        Book updatedBook = new Book(editBookID, newTitle, newAuthor, newYearPublished, newGenre);

                        // Method for updating book in database from BookDAO
                        bookDAO.updateBook(editBookID, newTitle, newAuthor, newYearPublished, newGenre);
                        break;

                    case 4:
                        // Case for deleting book from database
                        System.out.print("Input book title to delete book: ");
                        String titleBook = user_input.nextLine();

                        // Method for deleting book from BookDAO
                        bookDAO.deleteBook(titleBook);
                        break;

                    case 5:
                        // Exit the loop and terminate the program
                        System.out.println("Exiting the program. Goodbye!");
                        user_input.close();
                        return;

                    default:
                        System.out.println("Invalid action! Try Again.");
                }

            } catch (Exception e) {
                System.out.println("Error: You need to enter a valid action number.");
                e.printStackTrace();
                user_input.nextLine();  // Clear the buffer in case of invalid input
            }
        }
    }
}
