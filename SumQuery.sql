Create database web_prj
 CREATE TABLE [dbo].[tbl_cartegory](
	[cartegory_id] [int] IDENTITY(1,1) NOT NULL,
	[cartegory_name] [nvarchar](30) NOT NULL,
)
 CREATE TABLE [dbo].[tbl_brand](
	[brand_id] [int] IDENTITY(1,1) NOT NULL,
	[cartegory_id] [int] NOT NULL,
	[brand_name] [nvarchar](30) NULL,
	)
 CREATE TABLE tbl_product_detail (
    product_id INT PRIMARY KEY,
    product_img_desc_1 NVARCHAR(255) not null,
    product_img_desc_2 NVARCHAR(255) not null,
    product_img_desc_3 NVARCHAR(255) not null,
    product_img_desc_4 NVARCHAR(255) not null,
    product_color NVARCHAR(50) not null,
    product_intro Nvarchar(500) not null,
    product_prever NVARCHAR(500) not null
);
 CREATE TABLE tbl_product (
    product_id INT PRIMARY KEY  IDENTITY ,
    product_quantity INT NOT NULL,
    product_name NVARCHAR(50) NOT NULL,
    cartegory_id INT NOT NULL,
    brand_id INT NOT NULL,
    product_price FLOAT NOT NULL,
    product_price_sale FLOAT ,
    product_img NVARCHAR(255) NOT NULL,
    product_desc NVARCHAR(Max) NOT NULL,
);
 create table tbl_account(
   id_account int Identity primary key,
   username nvarchar(50) unique,
   email nvarchar(80) unique,
   password nvarchar(20) not null,
   role int not null
 )
create table tbl_product_done(
   id_done int primary key identity ,
   username nvarchar(50) not null ,
   product_id int not null,
   product_quantity int not null,
   product_size varchar not null,
   name_custom nvarchar(30) not null,
   phone_number varchar(10) not null,
   province nvarchar(30) not null,
   districts nvarchar(30) not null,
   address nvarchar(70) not null,
   product_done_price float not null
)
-- Tạo khóa ngoại cho bảng tbl_brand tham chiếu đến cartegory_id trong bảng tbl_cartegory
ALTER TABLE [dbo].[tbl_brand]
ADD CONSTRAINT FK_tbl_brand_tbl_cartegory FOREIGN KEY (cartegory_id) REFERENCES [dbo].[tbl_cartegory](cartegory_id);

-- Tạo khóa ngoại cho bảng tbl_product tham chiếu đến cartegory_id trong bảng tbl_cartegory
ALTER TABLE [dbo].[tbl_product]
ADD CONSTRAINT FK_tbl_product_tbl_cartegory FOREIGN KEY (cartegory_id) REFERENCES [dbo].[tbl_cartegory](cartegory_id);

-- Tạo khóa ngoại cho bảng tbl_product tham chiếu đến brand_id trong bảng tbl_brand
ALTER TABLE [dbo].[tbl_product]
ADD CONSTRAINT FK_tbl_product_tbl_brand FOREIGN KEY (brand_id) REFERENCES [dbo].[tbl_brand](brand_id);

-- Tạo khóa ngoại cho bảng tbl_product_done tham chiếu đến product_id trong bảng tbl_product
ALTER TABLE [dbo].[tbl_product_done]
ADD CONSTRAINT FK_tbl_product_done_tbl_product FOREIGN KEY (product_id) REFERENCES [dbo].[tbl_product](product_id);
-- Tạo khóa ngoại cho bảng tbl_product_done tham chiếu đến username trong bảng tbl_account
ALTER TABLE [dbo].[tbl_product_done]
ADD CONSTRAINT FK_tbl_product_done_tbl_account FOREIGN KEY (username) REFERENCES [dbo].[tbl_account](username);
-- Tạo khóa ngoại cho bảng tbl_product_detail tham chiếu đến product_id trong bảng tbl_product
ALTER TABLE [dbo].[tbl_product_detail]
ADD CONSTRAINT FK_tbl_product_detail_tbl_product FOREIGN KEY (product_id) REFERENCES [dbo].[tbl_product](product_id);
-- 3 sản phẩm được mua nhiều nhất
SELECT TOP 3
    product_id,
    COUNT(product_id) AS total_quantity_sold
FROM
    tbl_product_done
GROUP BY
    product_id
ORDER BY
    COUNT(product_id) DESC;
	--  sản phẩm được mua nhiều nhất
SELECT TOP 1
    product_id,
    COUNT(product_id) AS total_quantity_sold
FROM
    tbl_product_done
GROUP BY
    product_id
ORDER BY
    COUNT(product_id) DESC;
	-- người mua nhiều nhất
	SELECT TOP 1
    username,
    COUNT(*) AS total_products_bought
FROM
    tbl_product_done
GROUP BY
    username
ORDER BY
    COUNT(*) DESC;
	-- 3 người mua nhiều nhất
		SELECT TOP 3
    username,
    COUNT(*) AS total_products_bought
FROM
    tbl_product_done
GROUP BY
    username
ORDER BY
    COUNT(*) DESC;
	-- 3 sản phẩm được mua ít nhất
	SELECT TOP 3
    product_id,
    COUNT(product_id) AS total_quantity_sold
FROM
    tbl_product_done
GROUP BY
    product_id
ORDER BY
    COUNT(product_id) ASC;
select * from tbl_product_done
DELETE FROM tbl_product_done where id_done=95