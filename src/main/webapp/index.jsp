<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Phần mềm quản lý sản phẩm</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
    <style>
        body {
            background-color: #f8f9fa;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        .feature-icon {
            font-size: 3rem;
            color: #0d6efd;
        }
        .product-card {
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            cursor: pointer;
        }
        .product-card:hover {
            transform: translateY(-10px);
            box-shadow: 0 8px 20px rgba(0,0,0,0.15);
        }
        .section-title {
            margin-bottom: 30px;
            font-weight: 600;
            color: #212529;
        }
    </style>
</head>
<body>

<main class="container my-5">
    <section>
        <h3 class="section-title text-center mb-4">Sản phẩm tiêu biểu</h3>
        <div class="row g-4">
            <div class="col-md-4 col-lg-3">
                <div class="card product-card h-100 shadow-sm">
                    <img src="https://images.unsplash.com/photo-1525547719571-a2d4ac8945e2?q=80&w=764&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" class="card-img-top" alt="Sản phẩm 1" />
                    <div class="card-body">
                        <h5 class="card-title">Laptop</h5>
                        <p class="card-text">Hiệu năng mạnh mẽ, thiết kế hiện đại, phù hợp cho công việc và giải trí.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4 col-lg-3">
                <div class="card product-card h-100 shadow-sm">
                    <img src="https://images.unsplash.com/photo-1595044426077-d36d9236d54a?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" class="card-img-top" alt="Sản phẩm 2" />
                    <div class="card-body">
                        <h5 class="card-title">Bàn phím cơ</h5>
                        <p class="card-text">Phím nhạy, độ bền cao, trải nghiệm gõ phím tuyệt vời cho dân công nghệ.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4 col-lg-3">
                <div class="card product-card h-100 shadow-sm">
                    <img src="https://images.unsplash.com/photo-1487215078519-e21cc028cb29?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" class="card-img-top" alt="Sản phẩm 3" />
                    <div class="card-body">
                        <h5 class="card-title">Tai nghe không dây</h5>
                        <p class="card-text">Âm thanh chất lượng cao, thiết kế tiện lợi, phù hợp di chuyển và làm việc.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4 col-lg-3">
                <div class="card product-card h-100 shadow-sm">
                    <img src="https://images.unsplash.com/photo-1587831990711-23ca6441447b?q=80&w=1331&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" class="card-img-top" alt="Sản phẩm 4" />
                    <div class="card-body">
                        <h5 class="card-title">Máy tính để bàn</h5>
                        <p class="card-text">Cấu hình mạnh mẽ, dễ nâng cấp, phù hợp cho công việc và chơi game.</p>
                    </div>
                </div>
            </div>
        </div>
    </section>

</main>

<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>