import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class SqlConnection {
    private String driverName = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost/book?serverTimezone=UTC";
    public void MySqlConnection(){
        try {
            Class.forName(driverName);
            Connection connection = DriverManager.getConnection(url,"root","");
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM `book`");
            Book.allBooks = new LinkedList<>();
            while(resultSet.next()){
             Book toAdd =new Book(resultSet.getInt(1),
                     resultSet.getString(2),
                     resultSet.getString(3),
                     resultSet.getString(4));

             Book.allBooks.add(toAdd);
            }
            System.out.println(Book.allBooks.size());
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Book> search (String str){
        List<Book> toRet = new LinkedList<>();
        try{
            Class.forName(driverName);
            Connection connection = DriverManager.getConnection(url,"root","");
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM `book` WHERE title='"+str+"'");
            System.out.println("SELECT");
            while(resultSet.next()){
                Book toAdd =new Book(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4));

                toRet.add(toAdd);
                System.out.println(toRet);
            }
            System.out.println(Book.allBooks.size());
            connection.close();
        }catch (Exception e){
        }
        return toRet;
    }
}
