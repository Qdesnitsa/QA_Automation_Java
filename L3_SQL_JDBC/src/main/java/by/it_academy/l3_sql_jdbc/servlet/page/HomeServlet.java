package by.it_academy.l3_sql_jdbc.servlet.page;

import by.it_academy.l3_sql_jdbc.dao.exception.DAOException;
import by.it_academy.l3_sql_jdbc.dao.impl.AccountDAOImpl;
import by.it_academy.l3_sql_jdbc.dao.impl.UserDAOImpl;
import by.it_academy.l3_sql_jdbc.dao.repository.AccountDAO;
import by.it_academy.l3_sql_jdbc.entity.Account;
import by.it_academy.l3_sql_jdbc.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends BasePageServlet {
    public HomeServlet() {
        super("/page/home.jsp", true);
    }

    @Override()
    protected void setData(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            HttpSession session = request.getSession();
            session.setAttribute("name",request.getParameter("name"));
            Optional<User> user = new UserDAOImpl().findUserByEmail(request.getParameter("email"));
            List<Account> accounts = new AccountDAOImpl().findByUserId(user.get().getId());
            session.setAttribute("user_id",user.get().getId());
            session.setAttribute("accounts",accounts);
            //session.setAttribute("currency",request.getParameter("type"));
            getServletContext().getRequestDispatcher("/page/home.jsp").forward(request, response);
        } catch (DAOException | ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
