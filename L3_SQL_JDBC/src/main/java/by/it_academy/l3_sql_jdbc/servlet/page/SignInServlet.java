package by.it_academy.l3_sql_jdbc.servlet.page;

import by.it_academy.l3_sql_jdbc.dao.exception.DAOException;
import by.it_academy.l3_sql_jdbc.dao.impl.AccountDAOImpl;
import by.it_academy.l3_sql_jdbc.dao.impl.UserDAOImpl;
import by.it_academy.l3_sql_jdbc.entity.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "SignInServlet", value = "/sign-in")
public class SignInServlet extends BasePageServlet {
    private final String MSG_EMAIL_AND_PSW_NOT_MATCH = "Email or password is incorrect.";
    public SignInServlet() {
        super("/page/sign_in.jsp", false);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserDAOImpl userDao = null;
        try {
            userDao = new UserDAOImpl();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            if (!Optional.empty().equals(userDao.findUserByEmailAndPassword(
                    request.getParameter("email"), request.getParameter("password")))) {
                HttpSession session = request.getSession();
                session.setAttribute("email", request.getParameter("email"));
                session.setAttribute("name", userDao.findUserByEmail(request.getParameter("email")).get().getName());
                session.setAttribute("user_id",userDao.findUserByEmail(request.getParameter("email")).get().getId());
                userDao.findUserByEmail(request.getParameter("email"));
                List<Account> accounts = new AccountDAOImpl()
                        .findByUserId(userDao.findUserByEmail(request.getParameter("email")).get().getId());
                request.setAttribute("accounts",accounts);
                getServletContext().getRequestDispatcher("/page/home.jsp").forward(request, response);
            } else {
                request.setAttribute("message",MSG_EMAIL_AND_PSW_NOT_MATCH);
                getServletContext().getRequestDispatcher("/page/sign_in.jsp").forward(request, response);
            }
            //response.sendRedirect("/L3_SQL_JDBC/home");
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }
}
