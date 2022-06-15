<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <style>
        .add_btn, .subtract_btn {
            height: 40px;
            width: 150px;
            font-weight: 600;
            font-size: 12px;
        }
        .action_account {
            height: 40px;
            padding-bottom: 15px;
        }
    </style>
</head>
<body>
    <h2>Hello, <%= request.getAttribute("name") %> !</h2>
    <div>List of your accounts and balances</div>
    <div class="action_account">
        <button type="submit" id="add_btn" class="add_btn">
            Replenish an account
        </button>
    </div>
    <div class="action_account">
        <button type="submit" id="subtract_btn" class="subtract_btn">
            Withdraw money
        </button>
    </div>
</body>
</html>
