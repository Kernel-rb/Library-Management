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
        String data = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(usersFile));
            String line;
            while ((line = reader.readLine()) != null) {
                data += line;
            }
            reader.close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }

        if (!data.equals("") || !data.isEmpty()) {
            String[] usersData = data.split("<NewUser/>");
            for (String userData : usersData) {
                String[] user = userData.split("<N/>");
                if (user.length == 4) { // Ensure the array has enough elements
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
        }
    }

    public void saveUsers() {
        String data = "";
        for(User user : users) {
            data += user.toString() + "<NewUser/> \n";
        }
        try{
            PrintWriter writer = new PrintWriter(new FileWriter(usersFile));
            writer.print(data);
            writer.close();
        }catch(Exception e){
            System.err.println(e.toString());
        }
    }


    public void getBooks() {
        String data = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(booksFile));
            String line;
            while ((line = reader.readLine()) != null) {
                data += line;
            }
            reader.close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }

        if (!data.equals("") || !data.isEmpty()) {
            String[] booksData = data.split("<NewBook/>");
            for (String bookData : booksData) {
                Book book = parseBook(bookData);
                books.add(book);
                bookTitles.add(book.getTitle());
            }
        }
    }

    public Book parseBook(String data ){
        String[] bookData = data.split("<N/>");
        Book book  = new Book();
        book.setTitle(bookData[0]);
        book.setAuthor(bookData[1]);
        book.setGenre(bookData[2]);
        book.setPublisher(bookData[3]);
        book.setQuantity(Integer.parseInt(bookData[4]));
        book.setPrice(Double.parseDouble(bookData[5]));
        book.setBarrowcopies(Integer.parseInt(bookData[6]));
        return book;
    }
    

    public void saveBooks() {
        String data = "";
        for(Book book : books) {
            data += book.toString2() + "<NewBook/> \n";
        }
        try{
            PrintWriter writer = new PrintWriter(new FileWriter(booksFile));
            writer.print(data);
            writer.close();
        }catch(Exception e){
            System.err.println(e.toString());
        }
    }



}
