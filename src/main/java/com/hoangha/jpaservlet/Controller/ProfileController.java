package com.hoangha.jpaservlet.Controller;

import com.hoangha.jpaservlet.DTO.UserDTO;
import com.hoangha.jpaservlet.Service.UserService;
import com.hoangha.jpaservlet.Service.impl.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "profileController", urlPatterns = {"/profile"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 30,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100    // 50 MB
)
public class ProfileController extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String gmail = (String) session.getAttribute("gmail");

        if (gmail != null && !gmail.isEmpty()) {
            UserDTO user = userService.getUserByGmail(gmail);
            if (user != null) {
                req.setAttribute("user", user);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/view/profile.jsp");
                dispatcher.forward(req, resp);
                return;
            }
        }
        resp.sendRedirect(req.getContextPath() + "/view/loginView.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        String gmail = (String) session.getAttribute("gmail");

        if (gmail != null && !gmail.isEmpty()) {
            UserDTO user = userService.getUserByGmail(gmail);

            // Lấy dữ liệu từ form
            String address = req.getParameter("address");
            String fullname = req.getParameter("fullname");
            String phone = req.getParameter("phone");

            // Xử lý ảnh upload
            Part imagePart = req.getPart("image");
            byte[] imageBytes = null;

            if (imagePart != null && imagePart.getSize() > 0) {
                if (imagePart.getSize() > 5 * 1024 * 1024) {
                    req.setAttribute("user", user);
                    req.setAttribute("errorMessage", "Ảnh không được vượt quá 5MB!");
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/view/profile.jsp");
                    dispatcher.forward(req, resp);
                    return;
                }
                try (InputStream inputStream = imagePart.getInputStream()) {
                    imageBytes = inputStream.readAllBytes();
                }
            } else {
                imageBytes = user.getProduct_image(); // giữ ảnh cũ nếu không upload mới
            }

            // Update thông tin user
            boolean updated = userService.updateUserProfile(gmail, address, fullname, phone, imageBytes);

            if (updated) {
                UserDTO updatedUser = userService.getUserByGmail(gmail);
                session.setAttribute("user", updatedUser); // cập nhật lại session
                req.setAttribute("user", updatedUser);
                req.setAttribute("successMessage", "Cập nhật thông tin thành công!");
            } else {
                req.setAttribute("user", user);
                req.setAttribute("errorMessage", "Không thể cập nhật thông tin.");
            }

            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/profile.jsp");
            dispatcher.forward(req, resp);

        } else {
            resp.sendRedirect(req.getContextPath() + "/view/loginView.jsp");
        }
    }
}
