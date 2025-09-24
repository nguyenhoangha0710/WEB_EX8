package com.hoangha.jpaservlet.util;

import jakarta.servlet.http.HttpSession;

/**
 * Utility class để tạo header và footer HTML cố định cho toàn bộ ứng dụng
 */
public class HeaderFooter {

    /**
     * Tạo header HTML mặc định (không có session)
     */
    public static String getHeaderHtml() {
        return getHeaderHtml(null, null);
    }

    /**
     * Tạo header HTML với thông tin session và tên người dùng
     * @param session HttpSession hiện tại
     * @param fullName Tên đầy đủ của người dùng
     * @return HTML header
     */
    public static String getHeaderHtml(HttpSession session, String fullName) {
        boolean isLoggedIn = session != null && fullName != null;

        return """
        <!DOCTYPE html>
        <html lang="vi">
        <head>
            <meta charset="UTF-8" />
            <title>MyProducts - Quản lý sản phẩm hiệu quả</title>
            <meta name="viewport" content="width=device-width, initial-scale=1" />
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" />
            <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" rel="stylesheet" />
            <link href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" rel="stylesheet" />
            <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet" />
            <style>
                :root {
                    --primary-color: #4f46e5;
                    --primary-dark: #3730a3;
                    --secondary-color: #64748b;
                    --success-color: #10b981;
                    --warning-color: #f59e0b;
                    --danger-color: #ef4444;
                    --light-bg: #f8fafc;
                    --card-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1), 0 2px 4px -1px rgba(0, 0, 0, 0.06);
                }
                
                * {
                    font-family: 'Inter', sans-serif;
                }
                
                body {
                    background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
                    min-height: 100vh;
                }
                
                .navbar-primary {
                    background: linear-gradient(90deg, var(--primary-color), var(--primary-dark));
                    box-shadow: 0 2px 10px rgba(0,0,0,0.1);
                }
                
                .navbar-brand {
                    font-weight: 700;
                    font-size: 1.5rem;
                    color: #fff !important;
                }
                
                .nav-link {
                    color: #ddd !important;
                    font-weight: 500;
                    transition: all 0.3s ease;
                }
                
                .nav-link:hover {
                    color: #fff !important;
                    transform: translateY(-1px);
                }
                
                .dropdown-toggle {
                    color: #fff !important;
                    font-weight: 600;
                }
                
                .dropdown-toggle::after {
                    color: #fff;
                }
                
                .main-container {
                    background: rgba(255, 255, 255, 0.95);
                    backdrop-filter: blur(10px);
                    border-radius: 20px;
                    box-shadow: var(--card-shadow);
                    margin: 20px auto;
                    padding: 30px;
                    max-width: 1200px;
                }
                
                .header-section {
                    background: linear-gradient(135deg, var(--primary-color), var(--primary-dark));
                    color: white;
                    padding: 30px;
                    border-radius: 15px;
                    margin-bottom: 30px;
                    position: relative;
                    overflow: hidden;
                }
                
                .header-section::before {
                    content: '';
                    position: absolute;
                    top: -50%;
                    right: -50%;
                    width: 200%;
                    height: 200%;
                    background: radial-gradient(circle, rgba(255,255,255,0.1) 0%, transparent 70%);
                    animation: float 6s ease-in-out infinite;
                }
                
                @keyframes float {
                    0%, 100% { transform: translateY(0px) rotate(0deg); }
                    50% { transform: translateY(-20px) rotate(180deg); }
                }
                
                .page-title {
                    font-size: 2.5rem;
                    font-weight: 700;
                    margin: 0;
                    position: relative;
                    z-index: 1;
                }
                
                .page-subtitle {
                    font-size: 1.1rem;
                    opacity: 0.9;
                    margin: 10px 0 0 0;
                    position: relative;
                    z-index: 1;
                }
                
                .action-buttons {
                    display: flex;
                    gap: 15px;
                    flex-wrap: wrap;
                    margin-bottom: 25px;
                }
                
                .btn-custom {
                    border-radius: 10px;
                    padding: 12px 24px;
                    font-weight: 500;
                    transition: all 0.3s ease;
                    border: none;
                    position: relative;
                    overflow: hidden;
                }
                
                .btn-custom::before {
                    content: '';
                    position: absolute;
                    top: 0;
                    left: -100%;
                    width: 100%;
                    height: 100%;
                    background: linear-gradient(90deg, transparent, rgba(255,255,255,0.2), transparent);
                    transition: left 0.5s;
                }
                
                .btn-custom:hover::before {
                    left: 100%;
                }
                
                .btn-custom:hover {
                    transform: translateY(-2px);
                    box-shadow: 0 8px 25px rgba(0,0,0,0.15);
                }
                
                @media (max-width: 768px) {
                    .main-container {
                        margin: 10px;
                        padding: 20px;
                    }
                    
                    .page-title {
                        font-size: 2rem;
                    }
                    
                    .action-buttons {
                        flex-direction: column;
                    }
                }
            </style>
        </head>
        <body>
        <nav class="navbar navbar-expand-lg navbar-primary">
          <div class="container">
            <a class="navbar-brand" href="/">
                <i class="bi bi-box-seam me-2"></i>MyProducts
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" 
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon" style="filter: invert(1);"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
              <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link" href="/home">Bảng điều khiển</a></li>
                <li class="nav-item"><a class="nav-link" href="/products">Sản phẩm</a></li>
                <li class="nav-item"><a class="nav-link" href="/categories">Danh mục</a></li>
                <li class="nav-item"><a class="nav-link" href="/reports">Báo cáo</a></li>
                <li class="nav-item"><a class="nav-link" href="/settings">Cài đặt</a></li>
              </ul>
              <ul class="navbar-nav">
        """ +
                (isLoggedIn ?
                        """
                            <li class="nav-item dropdown">
                              <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                <i class="bi bi-person-circle me-1"></i>""" + fullName + """
                              </a>
                              <ul class="dropdown-menu dropdown-menu-end">
                                <li><a class="dropdown-item" href="/profile">
                                  <i class="bi bi-person me-2"></i>Thông tin tài khoản
                                </a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item text-danger" href="/logout">
                                  <i class="bi bi-box-arrow-right me-2"></i>Đăng xuất
                                </a></li>
                              </ul>
                            </li>
                        """
                        :
                        """
                            <li class="nav-item"><a class="nav-link" href="/login">Đăng nhập</a></li>
                            <li class="nav-item"><a class="btn btn-outline-light" href="/register">Đăng ký</a></li>
                        """
                ) +
                """
                      </ul>
                    </div>
                  </div>
                </nav>
                <div class="container-fluid">
                    <div class="main-container animate__animated animate__fadeInUp">
                """;
    }

    /**
     * Tạo footer HTML
     * @return HTML footer
     */
    public static String getFooterHtml() {
        return """
                    </div>
                </div>
        <footer class="text-center py-4 mt-auto" style="background-color: var(--primary-color); color: #fff;">
            <div class="container">
                <small>&copy; 2025 MyProducts - Phần mềm quản lý sản phẩm hiện đại và hiệu quả</small>
                <br />
                <small>
                    <a href="/privacy" class="text-white text-decoration-underline">Chính sách bảo mật</a> | 
                    <a href="/terms" class="text-white text-decoration-underline">Điều khoản sử dụng</a>
                </small>
            </div>
        </footer>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <script>
            // Add smooth scrolling
            document.querySelectorAll('a[href^="#"]').forEach(anchor => {
                anchor.addEventListener('click', function (e) {
                    e.preventDefault();
                    const target = document.querySelector(this.getAttribute('href'));
                    if (target) {
                        target.scrollIntoView({
                            behavior: 'smooth'
                        });
                    }
                });
            });
            
            // Add loading animation
            window.addEventListener('load', function() {
                const mainContainer = document.querySelector('.main-container');
                if (mainContainer) {
                    mainContainer.classList.add('animate__animated', 'animate__fadeInUp');
                }
            });
        </script>
        </body>
        </html>
        """;
    }

    /**
     * Tạo header HTML cho trang login (layout đặc biệt)
     * @return HTML header cho login
     */
    public static String getLoginHeaderHtml() {
        return """
        <!DOCTYPE html>
        <html lang="vi">
        <head>
            <meta charset="UTF-8" />
            <title>Đăng nhập hệ thống - MyProducts</title>
            <meta name="viewport" content="width=device-width, initial-scale=1" />
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" />
            <link href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" rel="stylesheet" />
            <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet" />
            <style>
                body {
                    background: linear-gradient(to right, #6b7280, #1f2937);
                    height: 100vh;
                    display: flex;
                    justify-content: center;
                    align-items: center;
                    font-family: 'Inter', sans-serif;
                }

                .card {
                    border-radius: 1rem;
                    backdrop-filter: blur(10px);
                }

                .error-message {
                    animation: shake 0.3s ease-in-out;
                }

                @keyframes shake {
                    0%, 100% { transform: translateX(0); }
                    25%, 75% { transform: translateX(-5px); }
                    50% { transform: translateX(5px); }
                }
            </style>
        </head>
        <body>
        """;
    }

    /**
     * Tạo footer HTML cho trang login
     * @return HTML footer cho login
     */
    public static String getLoginFooterHtml() {
        return """
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        </body>
        </html>
        """;
    }
}
