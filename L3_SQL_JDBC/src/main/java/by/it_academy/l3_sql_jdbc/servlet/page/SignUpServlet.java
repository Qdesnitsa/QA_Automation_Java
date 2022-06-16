package by.it_academy.l3_sql_jdbc.servlet.page;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "SignUpServlet", value = "/sign-up")
public class SignUpServlet extends BasePageServlet {
    public SignUpServlet() {
        super("/page/sign_up.jsp", false);
    }
}
