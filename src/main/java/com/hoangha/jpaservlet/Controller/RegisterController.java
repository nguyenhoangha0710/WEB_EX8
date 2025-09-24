package com.hoangha.jpaservlet.Controller;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.hoangha.jpaservlet.DAO.AccountDAO;
import com.hoangha.jpaservlet.DTO.AccountDTO;

import java.io.IOException;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
    private AccountDAO dao = new AccountDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. Lấy dữ liệu từ form
        String gmail = req.getParameter("gmail");
        String password = req.getParameter("password");
        String confirm = req.getParameter("confirm");

        // 2. Kiểm tra mật khẩu xác nhận
        if (!password.equals(confirm)) {
            req.setAttribute("errorMsg", "Mật khẩu và xác nhận mật khẩu không khớp!");
            req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
            return;
        }

        // 3. Kiểm tra Gmail đã tồn tại chưa
        if (dao.checkLogin(gmail, password) != null) {
            req.setAttribute("errorMsg", "Tài khoản đã tồn tại!");
            req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
            return;
        }

        // 4. Tạo user mới
        AccountDTO user = new AccountDTO();
        user.setGmail(gmail);
        user.setPassword(password);

        // 5. Lưu vào DB
        boolean created = dao.addUser(user);

        if (created) {
            req.setAttribute("successMsg", "Đăng ký thành công! Bạn có thể đăng nhập.");
        } else {
            req.setAttribute("errorMsg", "Có lỗi xảy ra khi tạo tài khoản!");
        }

        // 6. Quay lại trang đăng ký với thông báo
        req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
    }
}

