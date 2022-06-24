package by.it_academy.l3_sql_jdbc.servlet.page;

import by.it_academy.l3_sql_jdbc.dao.exception.DAOException;
import by.it_academy.l3_sql_jdbc.dao.impl.UserDAOImpl;
import by.it_academy.l3_sql_jdbc.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet(name = "SignUpServlet", value = "/sign-up")
public class SignUpServlet extends BasePageServlet {
    private static final String MSG_USER_EXISTS = "User with such email already exists.";

    public SignUpServlet() {
        super("/page/sign_up.jsp", false);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserDAOImpl userDao = null;
        try {
            userDao = new UserDAOImpl();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            if (Optional.empty().equals(userDao.findPasswordByEmail(request.getParameter("email")))) {
                HttpSession session = request.getSession();
                session.setAttribute("name", request.getParameter("name"));
                session.setAttribute("email", request.getParameter("email"));

                User user = new User.Builder()
                        .setAddress(request.getParameter("address"))
                        .setEmail(request.getParameter("email"))
                        .setName(request.getParameter("name"))
                        .setPassword(request.getParameter("password"))
                        .build();
                request.setAttribute("name", user.getName());
                request.setAttribute("email", user.getEmail());
                try {
                    userDao.add(user);
                    getServletContext().getRequestDispatcher("/page/home.jsp").forward(request, response);
                } catch (DAOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                request.setAttribute("message", MSG_USER_EXISTS);
                getServletContext().getRequestDispatcher("/page/sign_up.jsp").forward(request, response);
            }
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }
}
