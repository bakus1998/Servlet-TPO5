import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "bookServlet", urlPatterns = {"/bookServlet"})
public class StartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookname = req.getParameter("bookname");
        System.out.println(bookname);
        SqlConnection sqlConnection = new SqlConnection();
        List<Book> checker =sqlConnection.search(bookname);
        PrintWriter writer = resp.getWriter();
        if(checker.size()!=0){
            String htmlRespone = "<html>";
            for (int i = 0; i < checker.size(); i++) {
                htmlRespone+= checker.get(i) + "<br/>";
            }
            htmlRespone +="<form action=\"index.html\">\n" +
                    "    <input type=\"submit\" value=\"Click back\" />\n" +
                    "</form>";
            htmlRespone += "</html>";
            writer.println(htmlRespone);
        }else{
            resp.sendRedirect("index_not_found.html");
        }

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
