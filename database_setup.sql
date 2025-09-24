-- Script tạo database và bảng cho hệ thống quản lý sản phẩm
-- Sử dụng SQL Server

-- Tạo database (nếu chưa có)
-- CREATE DATABASE ProductManagement;
-- USE ProductManagement;

-- Tạo bảng Category
CREATE TABLE Category (
    id INT PRIMARY KEY IDENTITY(1,1),
    name NVARCHAR(100) NOT NULL,
    [describe] NVARCHAR(500)
);

-- Tạo bảng Product
CREATE TABLE Product (
    id INT PRIMARY KEY IDENTITY(1,1),
    code NVARCHAR(50) NOT NULL UNIQUE,
    name NVARCHAR(100) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    category INT NOT NULL,
    FOREIGN KEY (category) REFERENCES Category(id) ON DELETE CASCADE
);

-- Thêm dữ liệu mẫu
INSERT INTO Category (name, [describe]) VALUES 
('Điện tử', 'Các sản phẩm điện tử, công nghệ'),
('Thời trang', 'Quần áo, phụ kiện thời trang'),
('Gia dụng', 'Đồ dùng trong gia đình'),
('Thể thao', 'Dụng cụ và trang phục thể thao');

INSERT INTO Product (code, name, price, category) VALUES 
('LAP001', 'Laptop Dell XPS 13', 25000000, 1),
('LAP002', 'Laptop MacBook Air M2', 30000000, 1),
('PHONE001', 'iPhone 15 Pro', 35000000, 1),
('PHONE002', 'Samsung Galaxy S24', 25000000, 1),
('SHIRT001', 'Áo sơ mi nam', 500000, 2),
('PANTS001', 'Quần jean nữ', 800000, 2),
('CHAIR001', 'Ghế văn phòng', 2000000, 3),
('TABLE001', 'Bàn làm việc', 3000000, 3),
('BALL001', 'Bóng đá', 200000, 4),
('SHOE001', 'Giày chạy bộ', 1500000, 4);

-- Kiểm tra dữ liệu
SELECT c.name as CategoryName, COUNT(p.id) as ProductCount
FROM Category c
LEFT JOIN Product p ON c.id = p.category
GROUP BY c.id, c.name
ORDER BY c.name;

SELECT p.code, p.name, p.price, c.name as CategoryName
FROM Product p
JOIN Category c ON p.category = c.id
ORDER BY c.name, p.name;

