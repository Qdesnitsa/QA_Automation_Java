<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
    <style>
        .add_btn, .subtract_btn, .sign_out, .create {
            height: 40px;
            width: 150px;
            font-weight: 600;
            font-size: 12px;
            margin-top: 20px;
        }

        .sign_out, .show_accounts {
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
        .msg {
            text-align: center;
            color: red;
            font-size: large;
        }
    </style>
</head>
<body>
<h4>
    <button type="submit" class="sign_out">
        Sign out
    </button>
</h4>
<h2>Hello, ${name} !</h2>
<div class="total">List of your accounts and balances:</div>
<c:forEach var="account" items="${accounts}">
    <div class="total">
        Account ID = ${account.getAccount_id()};
        Balance = ${account.getBalance()} ${account.getCurrency()}
    </div>
</c:forEach>
<div class="msg"><br>
<c:if test="${message != null}">
    <h4> <c:out value="${message}" default="guest" /></h4>
</c:if>
</div>
<table class="table" align="center">
    <form action="ActionServlet" method="POST">
        <caption>
            <h2>Operations with my accounts</h2>
            <fieldset>
                <legend>Enter account id and sum of operation</legend>
                <table>
                    <tr>
                        <th width="33%">
                            Enter account ID<br/>
                            <input
                                    type="text"
                                    name="account_id"
                                    class="account_id"
                                    placeholder="account id"
                                    pattern="[\d]+"
                            /><br/>
                        </th>
                        <th width="33%">
                            Enter sum of operation<br/>
                            <input
                                    type="text"
                                    name="sum"
                                    class="sum"
                                    placeholder="sum"
                                    pattern="[[\d]+[.]?[0-9]{3}]"
                            /><br/>
                        </th>
                    </tr>
                </table>
                <div class="action_account">
                    <button type="submit" class="add_btn" name="replenish">
                        Replenish an account
                    </button>

                    <button type="submit" class="subtract_btn" name="withdraw">
                        Withdraw money
                    </button>
                </div>
                </div>
            </fieldset>

            <fieldset>
                <legend>Enter currency type of new account</legend>
                <table>
                    <tr>
                        <th width="33%">
                            Enter type of currency<br/>
                            <select name="type" class="type">
                                <option value="BYN" selected>BYN</option>
                                <option value="RUB">RUB</option>
                                <option value="PLN">PLN</option>
                                <option value="USD">USD</option>
                                <option value="EUR">EUR</option>
                                <option value="GBP">GBP</option>
                                <option value="CAD">CAD</option>
                                <option value="CNY">CNY</option>
                                <option value="NZD">NZD</option>
                                <option value="CHF">CHF</option>
                            </select>
                        </th>
                    </tr>
                </table>

                    <button type="submit" class="create" name="create">
                        Create new account
                    </button>
                </div>
                </div>
            </fieldset>

        </caption>
        <button type="submit" class="show_accounts" name="show_accounts">
            Update list and balances of my accounts
        </button>
    </form>
</table>

</body>
</html>
