package by.it_academy.l3_sql_jdbc.servlet.page;

import by.it_academy.l3_sql_jdbc.dao.exception.DAOException;
import by.it_academy.l3_sql_jdbc.dao.impl.AccountDAOImpl;
import by.it_academy.l3_sql_jdbc.dao.repository.AccountDAO;
import by.it_academy.l3_sql_jdbc.entity.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Optional;

@WebServlet(name = "ActionServlet", value = "/ActionServlet")
public class ActionServlet extends BasePageServlet {
    private final String MSG_ACCOUNT_EXISTS = "Account in this currency already exists.";
    private final String MSG_ACCOUNT_SUCCESS = "Account is successfully added.";

    public ActionServlet() {
        super("/page/home.jsp", false);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setAttribute("user_id", session.getAttribute("user_id"));
        AccountDAO accountDAO = new AccountDAOImpl();
        if (request.getParameter("replenish") != null) {
            // Invoke FirstServlet job here.
        } else if (request.getParameter("withdraw") != null) {
            // Invoke SecondServlet job here.
        } else if (request.getParameter("create") != null) {
            try {
                if(Optional.empty().equals(accountDAO.getBalanceByCurrencyAndUserId(
                        Integer.parseInt(String.valueOf(session.getAttribute("user_id"))),
                        Account.Currency.valueOf(request.getParameter("type"))))) {

                    Account account = new Account.Builder()
                            .setCurrency(Account.Currency.valueOf(request.getParameter("type")))
                            .setBalance(BigDecimal.valueOf(0))
                            .setUser_id(Integer.parseInt(String.valueOf(session.getAttribute("user_id"))))
                            .build();
                    try {
                        accountDAO.addAccount(account);
                    } catch (DAOException e) {
                        throw new RuntimeException(e);
                    }
                    request.setAttribute("message",MSG_ACCOUNT_SUCCESS);
                    getServletContext().getRequestDispatcher("/page/home.jsp").forward(request, response);
                } else {
                    request.setAttribute("message",MSG_ACCOUNT_EXISTS);
                    getServletContext().getRequestDispatcher("/page/home.jsp").forward(request, response);
                }
            } catch (DAOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
