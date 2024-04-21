package src;


public class Book {
    private String title;
    private String author;
    private String genre;
    private String publisher;
    private String status;
    private int  quantity;
    private double price;
    private int barrowcopies;

    public Book(){
        
    };

    public Book(String title, String author, String genre, String publisher, String status, int quantity, double price, int barrowcopies) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.status = status;
        this.quantity = quantity;
        this.price = price;
        this.barrowcopies = barrowcopies;
    }

    public String toString() {
        String text = "Book Title: " + title + 
                        "\nAuthor: " + author + 
                        "\nGenre: " + genre + 
                        "\nPublisher: " + publisher + 
                        "\nStatus: " + status + 
                        "\nQuantity: " + String.valueOf(quantity) +
                        "\nPrice: " + String.valueOf(price) +
                        "\nBarrow Copies: " + String.valueOf(barrowcopies);
        return text;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getStatus() {
        return status;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getBarrowcopies() {
        return barrowcopies;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBarrowcopies(int barrowcopies) {
        this.barrowcopies = barrowcopies;
    }

    public String toString2(){
        String text = title + "<N/>" + author + "<N/>" + genre + "<N/>" + publisher + "<N/>" + status + "<N/>" + String.valueOf(quantity) + "<N/>" + String.valueOf(price) + "<N/>" + String.valueOf(barrowcopies);
        return text;
    }
}
