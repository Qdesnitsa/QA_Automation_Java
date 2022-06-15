<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Registration</title>
    <meta charset="UTF-8"/>
    <%= request.getAttribute("isRequestAuthorized") %>
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

        .name, .address, .email, .password, .check_password {
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
            <h2>Registration form</h2>
        </div>
        <div class="card-body">
            <form action="/L3_SQL_JDBC/api/sign-up" method="POST">
                <div class="input-form">
                    <input type="text"
                           name="name"
                           required class="name"
                           placeholder="name"/>
                </div>
                <div class="input-form">
                    <input
                            type="text"
                            class="address"
                            name="address"
                            placeholder="address"
                    />
                </div>
                <div class="input-form">
                    <input
                            type="text"
                            required
                            class="email"
                            name="email"
                            placeholder="email"
                            pattern="[a-zA-Z]{1}[a-zA-Z\d\u002E\u005F]+@([a-zA-Z]+\u002E){1,2}[a-zA-Z]+"
                    />
                </div>
                <div class="input-form">
                    <input
                            type="password"
                            required
                            class="password"
                            name="password"
                            placeholder="password"
                    />
                </div>
                <div class="input-form">
                    <input
                            type="password"
                            required
                            class="check_password"
                            placeholder="repeat password"
                    />
                </div>
                <div class="error"></div>
                <div class="form-group">
                    <button type="submit" id="submit" class="login_btn">
                        Sign up
                    </button>
                </div>
            </form>
        </div>
        <div class="card-footer">
            <div class="have-account">
                Already have an account?<a href="/L3_SQL_JDBC/sign-in"> Sign In</a>
            </div>
        </div>
    </div>
</div>
<script
        src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
        crossorigin="anonymous"
></script>
<script>
    $(document).ready(function ($) {
        $(".check_password").on("keyup", function () {
            var input1 = $(".password").val();
            var input2 = $(".check_password").val();

            if (input1 != "" && input2 === "") {
                $(".check_password").css("backgroundColor", "white");
                $(".password").css("backgroundColor", "white");
            } else if (input1 != input2) {
                $(".error").html("Passwords do not match. Please try again.");
                $("#submit").attr("disabled", "disabled");
                $(".check_password").css("backgroundColor", "lightpink");
                $(".password").css("backgroundColor", "lightpink");
            } else {
                $("#submit").removeAttr("disabled");
                $(".error").html("");
                $(".check_password").css("backgroundColor", "white");
                $(".password").css("backgroundColor", "white");
            }
        });
    });

    var button = document.querySelector("button");
    var input = document.querySelector("input");

    button.addEventListener(
        "click",
        function () {
            if (input.value === "") {
                $(".error").html("All fields are mandatory.");
            }
        },
        false
    );
</script>
</body>
</html>
