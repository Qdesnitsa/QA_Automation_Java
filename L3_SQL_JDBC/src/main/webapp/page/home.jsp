<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
    <style>
        .add_btn, .subtract_btn, .sign_out {
            height: 40px;
            width: 150px;
            font-weight: 600;
            font-size: 12px;
        }

        .sign_out {
            position: relative;
            left: 50%;
            transform: translate(-50%, 0);
        }
        .action_account {
            height: 40px;
            padding-bottom: 15px;
        }
        H2, .total {
            text-align: center;
        }
    </style>
</head>
<body>
<h4><button type="submit" class="sign_out">
    Sign out
</button></h4>
    <h2>Hello, ${name} !</h2>
    <div class="total">List of your accounts and balances:</div>
    <c:forEach var="account" items="${accounts}">
        <div class="total">
            Account ID = ${account.getAccount_id()};
            Balance = ${account.getBalance()} ${account.getCurrency()}
        </div>
    </c:forEach>

    <table class="table" align="center">
        <form action="/L3_SQL_JDBC/home" method="POST">
        <caption>
            <h2>Operations with my accounts</h2>
            <fieldset>
                <legend>Replenishment operation</legend>
                <table>
                    <tr>
                        <th width="33%">
                            Enter account ID<br />
                            <input
                                    type="text"
                                    name="ID"
                                    class="account_id"
                                    placeholder="account id"
                                    pattern="[\d]"
                            /><br />
                        </th>
                        <th width="33%">
                            Enter sum of operation<br />
                            <input
                                    type="text"
                                    name="sum"
                                    class="sum"
                                    placeholder="sum"
                                    pattern="[\d]"
                            /><br />
                        </th>
                    </tr>
                </table>
                <div class="action_account">
                    <button type="submit" id="add_btn" class="add_btn">
                        Replenish an account
                    </button>
                </div>
            </fieldset>

            <fieldset>
                <legend>Withdrawal operation</legend>
                <table>
                    <tr>
                        <th width="33%">
                            Enter account ID<br />
                            <input
                                    type="text"
                                    name="ID"
                                    class="account_id"
                                    placeholder="account id"
                                    pattern="[\d]"
                            /><br />
                        </th>
                        <th width="33%">
                            Enter sum of operation<br />
                            <input
                                    type="text"
                                    name="sum"
                                    class="sum"
                                    placeholder="sum"
                                    pattern="[\d]"
                            /><br />
                        </th>
                    </tr>
                </table>
                <div class="action_account">
                    <button type="submit" id="subtract_btn" class="subtract_btn">
                        Withdraw money
                    </button>
                </div>
            </fieldset>
        </caption>
        </form>
    </table>

</body>
</html>
