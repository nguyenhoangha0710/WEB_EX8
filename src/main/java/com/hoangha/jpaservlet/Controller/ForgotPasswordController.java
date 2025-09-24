package com.hoangha.jpaservlet.Controller;

import com.hoangha.jpaservlet.DAO.AccountDAO;
import com.hoangha.jpaservlet.DTO.ProductDTO;
import com.hoangha.jpaservlet.Service.ProductService;
import com.hoangha.jpaservlet.Service.impl.ProductServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/forgotPassword")
public class ForgotPasswordController extends HttpServlet {
    private AccountDAO usersDAO = new AccountDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");

        if (usersDAO.checkEmailExists(email)) {
            // Nếu email tồn tại, chuyển sang trang reset mật khẩu
            req.setAttribute("email", email); // truyền email sang
            RequestDispatcher rd = req.getRequestDispatcher("/view/resetPassword.jsp");
            rd.forward(req, resp);
        } else {
            // Email không tồn tại
            req.setAttribute("errorMsg", "Email không tồn tại trong hệ thống!");
            RequestDispatcher rd = req.getRequestDispatcher("/view/forgotPassword.jsp");
            rd.forward(req, resp);
        }
    }
}