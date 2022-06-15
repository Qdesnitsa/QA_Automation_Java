package by.it_academy.l3_sql_jdbc.servlet.page;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SignInServlet", value = "/sign-in")
public class SignInServlet extends BasePageServlet {
    public SignInServlet() {
        super("/page/sign_in.jsp", false);
    }
}
