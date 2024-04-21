package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Database {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<String> bookTitles = new ArrayList<>();

    private File usersFile = new File("C:\\Users\\petmk\\Desktop\\Library-Management\\data\\Users.txt");
    private File booksFile = new File("C:\\Users\\petmk\\Desktop\\Library-Management\\data\\Books.txt");

    public Database() {
        if (!usersFile.exists()) {
            usersFile.getParentFile().mkdirs();
        }
        if (!booksFile.exists()) {
            booksFile.getParentFile().mkdirs();
        }
        getUsers();
        getBooks();
    }

    public void addUser(User user) {
        users.add(user);
        usernames.add(user.getUsername());
        saveUsers();
    }

    public boolean addBook(Book book) {
        if (checkBookExists(book)) {
            System.out.println("\u001B[31mBook Already Exists\u001B[0m");
            return false;
        } else {
            books.add(book);
            bookTitles.add(book.getTitle());
            saveBooks();
            return true;
        }
    }

    public boolean checkBookExists(Book book) {
        for (Book existingBook : books) {
            if (existingBook.getTitle().equals(book.getTitle())) {
                return true;
            }
        }
        return false;
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

    public void getUsers() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(usersFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] user = line.split("<N/>");
                if (user.length == 4) { 
                    if (user[3].equals("Admin")) {
                        User newUser = new Admin(user[0], user[1], user[2], user[3]);
                        users.add(newUser);
                        usernames.add(newUser.getUsername());
                    } else {
                        User newUser = new NormalUser(user[0], user[1], user[2], user[3]);
                        users.add(newUser);
                        usernames.add(newUser.getUsername());
                    }
                }
            }
            reader.close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }


    public void saveUsers() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(usersFile));
            for (User user : users) {
                writer.println(user.toString() + "<NewUser/>");
            }
            writer.close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public boolean deleteUser(User user) {
        if (users.remove(user)) {
            usernames.remove(user.getUsername());
            saveUsers();
            return true;
        } else {
            return false;
        }
    }

    public void getBooks() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(booksFile));
            StringBuilder data = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line).append("\n");
            }
            reader.close();
            String[] bookData = data.toString().split("<NewBook/>");
            for (String bookLine : bookData) {
                Book book = parseBook(bookLine);
                books.add(book);
                bookTitles.add(book.getTitle());
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public Book parseBook(String data) {
        String[] lines = data.split("\n");
        Book book = new Book();
        for (String line : lines) {
            if (!line.trim().isEmpty()) { // Skip empty lines
                String[] parts = line.split(" : ");
                if (parts.length == 2) {
                    switch (parts[0].trim()) {
                        case "Title":
                            book.setTitle(parts[1].trim());
                            break;
                        case "Author":
                            book.setAuthor(parts[1].trim());
                            break;
                        case "Genre":
                            book.setGenre(parts[1].trim());
                            break;
                        case "Publisher":
                            book.setPublisher(parts[1].trim());
                            break;
                        case "Quantity":
                            book.setQuantity(Integer.parseInt(parts[1].trim()));
                            break;
                        case "Price":
                            book.setPrice(Double.parseDouble(parts[1].trim()));
                            break;
                        case "Barrow Copies":
                            book.setBarrowcopies(Integer.parseInt(parts[1].trim()));
                            break;
                        default:
                            System.err.println("Unknown field: " + parts[0]);
                    }
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }
        }
        return book;
    }
    

    public void saveBooks() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(booksFile));
            for (Book book : books) {
                writer.println(book.toString2() + "<NewBook/>");
            }
            writer.close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
