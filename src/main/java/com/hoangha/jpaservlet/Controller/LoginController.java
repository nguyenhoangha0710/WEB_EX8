package com.hoangha.jpaservlet.Controller;


import com.hoangha.jpaservlet.DAO.AccountDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
//import com.hoangha.jpaservlet.DAO.AccountDAO;
import com.hoangha.jpaservlet.DTO.AccountDTO;

import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/view/loginView.jsp");
        rd.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Nhan du lieu o day
        // B1   : Nhan tham so
        // B2 : Xu ly bai toan
        //B3 : Phan hoi ket qua
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Giả lập check tài khoản (thực tế sẽ lấy từ DB qua Model)

        AccountDAO dao = new AccountDAO();
        var user = dao.checkLogin(username, password);
        if (user != null) {
            // Lưu user vào session
            HttpSession session = req.getSession();
            session.setAttribute("gmail", username);

            // Redirect sang trang home
//            req.setAttribute("errorMsg", "Hehe");
            resp.sendRedirect(req.getContextPath() + "/home");
        } else {
            // Gửi lỗi về lại login.jsp
            req.setAttribute("errorMsg", "Sai tên đăng nhập hoặc mật khẩu!");
            RequestDispatcher rd = req.getRequestDispatcher("/view/loginView.jsp");
            rd.forward(req, resp);

        }
    }
}

