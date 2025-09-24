<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    .login-container {
        max-width: 400px;
        margin: 50px auto;
        padding: 30px 40px;
        box-shadow: 0 0 15px rgba(0,0,0,0.1);
        border-radius: 8px;
        font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
        background-color: #fff;
    }

    .login-container h2 {
        text-align: center;
        margin-bottom: 25px;
        color: #2c2c72; /* màu tím đậm giống ảnh footer */
    }

    .form-group {
        margin-bottom: 20px;
    }

    .form-group label {
        display: block;
        font-weight: 600;
        margin-bottom: 8px;
        color: #2c2c72;
    }

    .form-group input {
        width: 100%;
        padding: 10px 12px;
        border: 1px solid #ccc;
        border-radius: 4px;
        font-size: 16px;
        transition: border-color 0.3s;
    }

    .form-group input:focus {
        border-color: #5a4fcf; /* màu tím nhẹ */
        outline: none;
    }

    .login-btn {
        width: 100%;
        padding: 12px;
        background: linear-gradient(90deg, #5a4fcf, #7f73f5);
        color: white;
        font-weight: 700;
        font-size: 18px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        transition: background 0.3s;
    }

    .login-btn:hover {
        background: #3e3ca6;
    }

    .forgot-password {
        display: block;
        margin-top: 15px;
        text-align: center;
        color: #5a4fcf;
        font-weight: 600;
        text-decoration: none;
        cursor: pointer;
        transition: color 0.3s;
    }
    .forgot-password:hover {
        color: #3e3ca6;
        text-decoration: underline;
    }

    .error-message {
        margin-top: 15px;
        text-align: center;
        color: #d9534f; /* màu đỏ lỗi */
        font-weight: 600;
    }
</style>

<div class="login-container">
    <h2>Đăng nhập</h2>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <div class="form-group">
            <label for="username">Gmail</label>
            <input type="text" id="username" name="username" placeholder="Nhập gmail" required>
        </div>

        <div class="form-group">
            <label for="password">Mật khẩu</label>
            <input type="password" id="password" name="password" placeholder="Nhập mật khẩu" required>
        </div>

        <button type="submit" class="login-btn">Đăng nhập</button>

        <a href="${pageContext.request.contextPath}/view/forgotPassword.jsp" class="forgot-password">Quên mật khẩu?</a>
    </form>

    <c:if test="${not empty errorMsg}">
        <p class="error-message">${errorMsg}</p>
    </c:if>

    <p style="text-align:center; margin-top: 20px; color: #2c2c72;">
        Chưa có tài khoản?
        <a href="${pageContext.request.contextPath}/view/register.jsp" style="color: #5a4fcf; font-weight: 600; text-decoration: none;">
            Đăng ký ngay
        </a>
    </p>
</div>