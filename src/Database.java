package src;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class Database {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<String> bookTitles = new ArrayList<>();

    private File usersFile;
    private File booksFile;

    public Database() {
        try {
            // Load resources from the "data" directory
            InputStream usersStream = Database.class.getClassLoader().getResourceAsStream("data/Users");
            InputStream booksStream = Database.class.getClassLoader().getResourceAsStream("data/Books");

            // Create temporary directories
            usersFile = Files.createTempDirectory("Users").toFile();
            booksFile = Files.createTempDirectory("Books").toFile();

            // Copy resources to temporary directories if input streams are not null
            if (usersStream != null && booksStream != null) {
                Files.copy(usersStream, usersFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                Files.copy(booksStream, booksFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                // Close input streams
                usersStream.close();
                booksStream.close();
            } else {
                System.err.println("Failed to load resource streams.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user) {
        users.add(user);
        usernames.add(user.getUsername());
    }

    public int checkLogin(String username, String password) {
        int successLogin = -1;
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                successLogin = 1;
                break;
            }
        }
        return successLogin;
    }

    public User getUser(int index) {
        return users.get(index);
    }

    public void addBook(Book book) {
        books.add(book);
        bookTitles.add(book.getTitle());
    }
}
