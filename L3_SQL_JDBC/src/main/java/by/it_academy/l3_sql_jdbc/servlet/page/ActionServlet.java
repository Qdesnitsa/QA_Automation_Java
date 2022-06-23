package by.it_academy.l3_sql_jdbc.servlet.page;

import by.it_academy.l3_sql_jdbc.dao.exception.DAOException;
import by.it_academy.l3_sql_jdbc.dao.impl.AccountDAOImpl;
import by.it_academy.l3_sql_jdbc.dao.impl.TransactionDAOImpl;
import by.it_academy.l3_sql_jdbc.dao.impl.UserDAOImpl;
import by.it_academy.l3_sql_jdbc.dao.repository.AccountDAO;
import by.it_academy.l3_sql_jdbc.dao.repository.TransactionDAO;
import by.it_academy.l3_sql_jdbc.dao.repository.UserDAO;
import by.it_academy.l3_sql_jdbc.entity.Account;
import by.it_academy.l3_sql_jdbc.entity.Transaction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "ActionServlet", value = "/ActionServlet")
public class ActionServlet extends BasePageServlet {
    private final String MSG_ACCOUNT_EXISTS = "Account in this currency already exists.";
    private final String MSG_ACCOUNT_SUCCESS = "Account is successfully added.";
    private final String MSG_REPLENISHMENT_SUCCESS = "Account is successfully replenished.";
    private final String MSG_TOO_BIG_TRANSACTION = "Transaction amount should not be greater then 100_000_000" +
            " and final balance greater then 2_000_000_000.";
    private final BigDecimal MAX_TRANSACTION_AMOUNT = BigDecimal.valueOf(100_000_000);
    private final BigDecimal MAX_BALANCE_AMOUNT = BigDecimal.valueOf(2_000_000_000);

    public ActionServlet() {
        super("/page/home.jsp", false);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setAttribute("user_id", session.getAttribute("user_id"));
        request.setAttribute("email", session.getAttribute("email"));
        AccountDAO accountDAO = new AccountDAOImpl();
        TransactionDAO transactionDAO = new TransactionDAOImpl();
        UserDAO userDAO;
        try {
            userDAO = new UserDAOImpl();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (request.getParameter("replenish") != null) {

            Transaction transaction = null;
            try {
                transaction = new Transaction.Builder()
                        .setTypeTransaction(Transaction.TypeTransaction.REPLENISHMENT)
                        .setAccount_id(accountDAO.findByAccountId(Integer.parseInt(request.getParameter("account_id")))
                                .get().getAccount_id())
                        .setAmount(BigDecimal.valueOf(Long.parseLong(request.getParameter("sum"))))
                        .build();
            } catch (DAOException e) {
                throw new RuntimeException(e);
            }
            BigDecimal currentBalance = null;
            try {
                currentBalance = accountDAO.getBalanceByCurrencyAndUserId(
                        Integer.parseInt(String.valueOf(session.getAttribute("user_id"))),
                        accountDAO.findByAccountId(Integer.parseInt(request.getParameter("account_id")))
                                .get().getCurrency()).get().getBalance();
            } catch (DAOException ex) {
                throw new RuntimeException(ex);
            }

            if (null == currentBalance) {
                currentBalance = BigDecimal.valueOf(0);
            }

            BigDecimal balanceAfterTransaction = currentBalance.add(transaction.getAmount());

            if (MAX_TRANSACTION_AMOUNT.compareTo(transaction.getAmount()) > 0 &&
                    MAX_BALANCE_AMOUNT.compareTo(balanceAfterTransaction) > 0) {
                try {
                    transactionDAO.add(transaction);
                } catch (DAOException ex) {
                    throw new RuntimeException(ex);
                }
                request.setAttribute("message", MSG_REPLENISHMENT_SUCCESS);
                getServletContext().getRequestDispatcher("/page/home.jsp").forward(request, response);
            } else {
                request.setAttribute("message", MSG_TOO_BIG_TRANSACTION);
                getServletContext().getRequestDispatcher("/page/home.jsp").forward(request, response);
            }
        } else if (request.getParameter("withdraw") != null) {


            // Invoke SecondServlet job here.

            
        } else if (request.getParameter("create") != null) {

            try {
                if (Optional.empty().equals(accountDAO.getBalanceByCurrencyAndUserId(
                        Integer.parseInt(String.valueOf(userDAO.findUserByEmail(String.valueOf(
                                session.getAttribute("email"))).get().getId())),
                        Account.Currency.valueOf(request.getParameter("type"))))) {

                    Account account = new Account.Builder()
                            .setCurrency(Account.Currency.valueOf(request.getParameter("type")))
                            .setBalance(BigDecimal.valueOf(0))
                            .setUser_id(Integer.parseInt(String.valueOf(userDAO.findUserByEmail(String.valueOf(
                                    session.getAttribute("email"))).get().getId())))
                            .build();
                    try {
                        accountDAO.addAccount(account);
                    } catch (DAOException e) {
                        throw new RuntimeException(e);
                    }

                    Transaction transaction = null;
                    transaction = new Transaction.Builder()
                            .setTypeTransaction(Transaction.TypeTransaction.REPLENISHMENT)
                            .setAccount_id(accountDAO.getBalanceByCurrencyAndUserId(
                                    Integer.parseInt(String.valueOf(userDAO.findUserByEmail(String.valueOf(
                                            session.getAttribute("email"))).get().getId())),Account.Currency.valueOf(
                                                    request.getParameter("type"))).get().getAccount_id())
                            .setAmount(BigDecimal.valueOf(0))
                            .build();
                    transactionDAO.add(transaction);

                    request.setAttribute("message", MSG_ACCOUNT_SUCCESS);
                    getServletContext().getRequestDispatcher("/page/home.jsp").forward(request, response);
                } else {
                    request.setAttribute("message", MSG_ACCOUNT_EXISTS);
                    getServletContext().getRequestDispatcher("/page/home.jsp").forward(request, response);
                }
            } catch (DAOException ex) {
                throw new RuntimeException(ex);
            }

        } else if (request.getParameter("show_accounts") != null) {
            try {
                List<Account> accounts = accountDAO.findByUserId(userDAO.findUserByEmail(String.valueOf(
                        session.getAttribute("email"))).get().getId());
                request.setAttribute("accounts", accounts);
                getServletContext().getRequestDispatcher("/page/home.jsp").forward(request, response);
            } catch (DAOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

