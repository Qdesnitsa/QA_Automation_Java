package by.it_academy.l3_sql_jdbc.servlet.page;

import by.it_academy.l3_sql_jdbc.dao.exception.DAOException;
import by.it_academy.l3_sql_jdbc.dao.impl.UserDAOImpl;
import by.it_academy.l3_sql_jdbc.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends BasePageServlet {
    public HomeServlet() {
        super("/page/home.jsp", true);
    }

    @Override()
    protected void setData(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            User user = new UserDAOImpl().findAll().get(0);
            request.setAttribute("name", user.getName());
        } catch (DAOException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
