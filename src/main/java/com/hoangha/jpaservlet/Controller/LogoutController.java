package com.hoangha.jpaservlet.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        // Lấy session hiện tại
        HttpSession session = req.getSession(false);
        
        if (session != null) {
            // Xóa tất cả attributes trong session
            session.removeAttribute("gmail");
            session.removeAttribute("username");
            session.removeAttribute("fullName");
            session.removeAttribute("user");
            
            // Invalidate session
            session.invalidate();
        }
        
        // Redirect về trang login
        resp.sendRedirect(req.getContextPath() + "/login");
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
