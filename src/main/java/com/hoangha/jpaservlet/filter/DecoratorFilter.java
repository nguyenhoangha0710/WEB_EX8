package com.hoangha.jpaservlet.filter;



import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
//import model.User;
import java.io.IOException;
import java.io.PrintWriter;

public class DecoratorFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        String path = uri.substring(req.getContextPath().length());

        if (path.equals("/") || path.equals("") || path.endsWith(".jsp")
                || path.equals("/login") || path.equals("/register") || path.equals("/products") || path.equals("/home") || path.equals("/resetPassword")
        ||path.equals("/profile") ) {

            res.setCharacterEncoding("UTF-8");
            res.setContentType("text/html;charset=UTF-8");
            CharResponseWrapper responseWrapper = new CharResponseWrapper(res);

            chain.doFilter(request, responseWrapper);
            String originalContent = responseWrapper.toString();

            // Lấy thông tin session và user
            HttpSession session = req.getSession();
            String fullName = null;

            // Kiểm tra user trong session
//            User user = (User) session.getAttribute("user");
//            if (user != null) {
//                fullName = user.getFullname(); // Sử dụng username làm tên hiển thị
//            }

            PrintWriter out = res.getWriter();
//            System.out.println(fullName);
            // Sử dụng method có tham số để truyền thông tin session
            out.println(HeaderFooter.getHeaderHtml(session, fullName));
            out.println(originalContent);
            out.println(HeaderFooter.getFooterHtml());
            out.close();
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}