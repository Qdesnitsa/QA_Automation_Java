package by.it_academy.l3_sql_jdbc.servlet.page;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "AuthServlet", value = "/auth")
public class AuthServlet extends BasePageServlet {
    public AuthServlet() {
        super("/page/auth.jsp", false);
    }
}
