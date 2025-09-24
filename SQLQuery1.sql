
SELECT * from Product

alter table Product add category int


-- Tạo bảng Category trong SQL Server
CREATE TABLE Category (
    id INT PRIMARY KEY IDENTITY(1,1),
    name NVARCHAR(100) NOT NULL,
    [describe] NVARCHAR(255)
);

-- Thêm dữ liệu liên quan đến điện thoại và máy tính
INSERT INTO Category (name, [describe]) VALUES
(N'Điện thoại', N'Sản phẩm điện thoại di động, smartphone'),
(N'Máy tính xách tay', N'Laptop các hãng như Dell, HP, MacBook...'),
(N'Máy tính để bàn', N'PC, máy bộ cho văn phòng và gaming'),
(N'Máy tính bảng', N'Tablet như iPad, Galaxy Tab...'),
(N'Phụ kiện điện thoại', N'Ốp lưng, tai nghe, sạc dự phòng...'),
(N'Phụ kiện máy tính', N'Chuột, bàn phím, màn hình, ổ cứng...');


UPDATE Category 
SET name = N'Điện thoại', 
    [describe] = N'Sản phẩm điện thoại di động, smartphone'
WHERE id = 1;

UPDATE Category 
SET name = N'Máy tính xách tay', 
    [describe] = N'Laptop các hãng như Dell, HP, MacBook...'
WHERE id = 2;

UPDATE Category 
SET name = N'Máy tính để bàn', 
    [describe] = N'PC, máy bộ cho văn phòng và gaming'
WHERE id = 3;

UPDATE Category 
SET name = N'Máy tính bảng', 
    [describe] = N'Tablet như iPad, Galaxy Tab...'
WHERE id = 4;

UPDATE Category 
SET name = N'Phụ kiện điện thoại', 
    [describe] = N'Ốp lưng, tai nghe, sạc dự phòng...'
WHERE id = 5;

UPDATE Category 
SET name = N'Phụ kiện máy tính', 
    [describe] = N'Chuột, bàn phím, màn hình, ổ cứng...'
WHERE id = 6;


ALTER TABLE Category 
ALTER COLUMN name NVARCHAR(100) COLLATE Vietnamese_CI_AS NOT NULL;

ALTER TABLE Category 
ALTER COLUMN [describe] NVARCHAR(255) COLLATE Vietnamese_CI_AS;


select * from Category

alter table Product add constraint FK_Product_Category foreign key (category) references Category (id)

select * from Category

INSERT INTO Product (code, name, price, category) VALUES
(N'DT001', N'iPhone 16 Pro Max', 32990000, 1),
(N'DT002', N'Samsung Galaxy S24 Ultra', 28990000, 1),
(N'DT003', N'Xiaomi 14', 18990000, 1),

(N'LT001', N'Dell XPS 13', 34000000, 2),
(N'LT002', N'MacBook Air M3', 29990000, 2),
(N'LT003', N'HP Spectre x360', 32000000, 2),

(N'PC001', N'PC Gaming RTX 4070', 45000000, 3),
(N'PC002', N'PC Văn phòng Core i5', 15000000, 3),

(N'TB001', N'iPad Pro M4 11 inch', 28990000, 4),
(N'TB002', N'Samsung Galaxy Tab S9 Ultra', 24990000, 4),

(N'PKD001', N'Tai nghe AirPods Pro 2', 5500000, 5),
(N'PKD002', N'Sạc nhanh Anker 65W', 1200000, 5),

(N'PKM001', N'Chuột Logitech MX Master 3S', 2800000, 6),
(N'PKM002', N'Màn hình Dell UltraSharp 27"', 8500000, 6);

SELECT * from Product
