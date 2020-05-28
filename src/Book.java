import java.util.*;

public class Book {
    protected int id;
    private String title;
    private String author;
    private String date;

    public static List<Book> allBooks = new LinkedList<>();

    public Book(int id, String title, String author,String date){
        this.id=id;
        this.title=title;
        this.author=author;
        this.date=date;
        System.out.println("Book Object was created: " + author);
    }

    @Override
    public String toString() {
        return "<h2><b>"+id+". </b>"+title + "</h2>"
                +"<b>author: </b>" + author +", <b>date: </b>" + date + "<br>";
    }
}
