//package by.it_academy.l3_sql_jdbc.servlet.api;
//
//import by.it_academy.l3_sql_jdbc.dao.exception.DAOException;
//import by.it_academy.l3_sql_jdbc.dao.impl.UserDAOImpl;
//import by.it_academy.l3_sql_jdbc.entity.User;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.sql.SQLException;
//
//@WebServlet(name = "SignUpApiServlet", value = "/api/sign-up")
//public class SignUpApiServlet extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        UserDAOImpl userDao = null;
//        try {
//            userDao = new UserDAOImpl();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        User user = new User.Builder()
//                .setAddress(request.getParameter("address"))
//                .setEmail(request.getParameter("email"))
//                .setName(request.getParameter("name"))
//                .setPassword(request.getParameter("password"))
//                .build();
//
//        try {
//            userDao.add(user);
//
//            response.sendRedirect("/L3_SQL_JDBC/home");
//        } catch (DAOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
