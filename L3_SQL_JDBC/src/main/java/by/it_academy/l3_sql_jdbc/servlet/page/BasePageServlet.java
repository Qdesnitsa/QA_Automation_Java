package by.it_academy.l3_sql_jdbc.servlet.page;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public abstract class BasePageServlet extends HttpServlet {
    private String page;
    private boolean pageAvailableOnlyForAuthorizedRequest;

    public BasePageServlet(String page, boolean authorizedAccess) {
        this.page = page;
        this.pageAvailableOnlyForAuthorizedRequest = authorizedAccess;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String isRequestAuthorized = (String) session.getAttribute("isRequestAuthorized");
        request.setAttribute("isRequestAuthorized", isRequestAuthorized);
        try {
            this.setData(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.goToPage(this.page, request, response);
    }

    protected void goToPage(String page, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        getServletContext().getRequestDispatcher(page).forward(request, response);
    }

    protected void setData(HttpServletRequest request, HttpServletResponse response) throws SQLException {

    }
}
