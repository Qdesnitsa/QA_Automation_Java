package by.it_academy.l3_sql_jdbc.servlet.api;

import by.it_academy.l3_sql_jdbc.dao.impl.UserDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AuthApiServlet", value = "/authApiServlet")
public class AuthApiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
