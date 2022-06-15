<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
    <meta charset="UTF-8" />
    <style>
        body {
            background-color: #ffe4e1;
        }
        H2 {
            font-size: 40px;
        }
        DIV.container {
            margin-top: 100px;
            text-align: center;
            vertical-align: middle;
        }
        DIV.input-form {
            height: 40px;
            padding-bottom: 20px;
        }
        .form-control {
            height: 30px;
            width: 300px;
        }
        .login_btn {
            height: 40px;
            width: 100px;
            font-weight: 600;
            font-size: 16px;
        }
        .card-footer {
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="card">
        <div class="card-header">
            <h2>Sign In</h2>
        </div>
        <div class="card-body">
            <form>
                <div class="input-form">
                    <input
                            type="text"
                            required
                            class="form-control"
                            placeholder="email"
                            pattern="[a-zA-Z]{1}[a-zA-Z\d\u002E\u005F]+@([a-zA-Z]+\u002E){1,2}[a-zA-Z]+"
                    />
                </div>
                <div class="input-form">
                    <input
                            type="password"
                            required
                            class="form-control"
                            placeholder="password"
                    />
                </div>
                <div class="form-group">
                    <button type="submit" id="submit" class="login_btn">
                        Sign In
                    </button>
                </div>
            </form>
        </div>
        <div class="card-footer">
            <div class="have-account">
                Don't have an account?<a href="/L3_SQL_JDBC/sign-up">Sign Up</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>


