import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "showAllBooks", urlPatterns = {"/showAllBooks"})
public class ShowAllBookServlet extends HttpServlet{


    @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            if(req.getParameter("showAllOk")!=null){
                SqlConnection sqlConnection = new SqlConnection();
                sqlConnection.MySqlConnection();
                System.out.println("Button clicked!");
            }

        PrintWriter writer = resp.getWriter();
        String htmlRespone = "<html>";

        for (int i = 0; i < Book.allBooks.size(); i++) {
            htmlRespone+= Book.allBooks.get(i) + "<br/>";
        }

        htmlRespone +="<form action=\"index.html\">\n" +
                "    <input type=\"submit\" value=\"Click back\" />\n" +
                "</form>";

        htmlRespone += "</html>";
        writer.println(htmlRespone);
        }


        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            super.doGet(req, resp);
        }


}
