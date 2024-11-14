//Class for initializing book instance
public class Book {
    private int id;
    private String title;
    private String author;
    private int year_published;
    private String genre;

    //Constructor for each new book
    public Book(int id, String title, String author, int year_published, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year_published = year_published;
        this.genre = genre;
    }
    //Setters and getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear_published() {
        return year_published;
    }

    public void setYear_published(int year_published) {
        this.year_published = year_published;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
