package com.hoangha.jpaservlet.filter;



import jakarta.servlet.http.HttpSession;

public class HeaderFooter {

    public static String getHeaderHtml() {
        return getHeaderHtml(null, null);
    }

    public static String getHeaderHtml(HttpSession session, String fullName) {
        boolean isLoggedIn = session != null && fullName != null;

        return """
        <!DOCTYPE html>
        <html lang="vi">
        <head>
            <meta charset="UTF-8" />
            <title>MyProducts - Quản lý sản phẩm hiệu quả</title>
            <meta name="viewport" content="width=device-width, initial-scale=1" />
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
            <style>
                body {
                    background-color: #f8f9fa;
                    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                }
                .navbar-primary {
                    background: linear-gradient(90deg, #004085, #007bff);
                }
                .navbar-brand {
                    font-weight: 700;
                    font-size: 1.5rem;
                    color: #fff !important;
                }
                .nav-link {
                    color: #ddd !important;
                    font-weight: 500;
                }
                .nav-link:hover {
                    color: #fff !important;
                }
                .dropdown-toggle {
                    color: #fff !important;
                    font-weight: 600;
                }
                .dropdown-toggle::after {
                    color: #fff;
                }
                footer {
                    background-color: #004085;
                    color: #fff;
                }
            </style>
        </head>
        <body>
        <nav class="navbar navbar-expand-lg navbar-primary">
          <div class="container">
            <a class="navbar-brand" href="#">MyProducts</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" 
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon" style="filter: invert(1);"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
              <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link" href="/dashboard">Bảng điều khiển</a></li>
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
                                <i class="bi bi-person-circle"></i> """ + fullName + """
                  </a>
                  <ul class="dropdown-menu dropdown-menu-end">
                    <li><a class="dropdown-item" href="profile">
                      <i class="bi bi-person"></i> Thông tin tài khoản
                    </a></li>
                    <li><hr class="dropdown-divider"></li>
                    <li><a class="dropdown-item text-danger" href="logout">
                      <i class="bi bi-box-arrow-right"></i> Đăng xuất
                    </a></li>
                  </ul>
                </li>
            """
                        :
                        """
                            <li class="nav-item"><a class="nav-link" href="login">Đăng nhập</a></li>
                            <li class="nav-item"><a class="btn btn-outline-light" href="register">Đăng ký</a></li>
                        """
                ) +
                """
                      </ul>
                    </div>
                  </div>
                </nav>
                <main class="container my-4 pt-3">
                """;
    }

    public static String getFooterHtml() {
        return """
        </main>
        <footer class="text-center py-4 mt-auto">
            <div class="container">
                <small>&copy; 2025 MyProducts - Phần mềm quản lý sản phẩm hiện đại và hiệu quả</small>
                <br />
                <small><a href="/privacy" class="text-white text-decoration-underline">Chính sách bảo mật</a> | 
                <a href="/terms" class="text-white text-decoration-underline">Điều khoản sử dụng</a></small>
            </div>
        </footer>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Bootstrap Icons -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css" rel="stylesheet" />
        </body>
        </html>
        """;
    }
}