package com.hoangha.jpaservlet.Controller;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.hoangha.jpaservlet.DAO.AccountDAO;

import java.io.IOException;


@WebServlet("/resetPassword")
public class ResetPasswordController extends HttpServlet {
    private AccountDAO usersDAO = new AccountDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String newPass = req.getParameter("newPass");
        String confirmPass = req.getParameter("confirmPass");

        if (!newPass.equals(confirmPass)) {
            req.setAttribute("errorMsg", "Mật khẩu xác nhận không khớp!");
            req.setAttribute("email", email);
            RequestDispatcher rd = req.getRequestDispatcher("/view/resetPassword.jsp");
            rd.forward(req, resp);
            return;
        }

        boolean updated = usersDAO.updatePassword(email, newPass);
        if (updated) {
            resp.sendRedirect(req.getContextPath() + "/login"); // quay lại trang login
        } else {
            req.setAttribute("errorMsg", "Có lỗi xảy ra, vui lòng thử lại!");
            RequestDispatcher rd = req.getRequestDispatcher("/view/resetPassword.jsp");
            rd.forward(req, resp);
        }
    }
}

