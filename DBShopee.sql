--CREATE DATABASE
CREATE DATABASE Shopee
--DROP DATABASE Shopee
USE Shopee
-- CREATE TABLE
--1. User table
CREATE TABLE [Users](
	id INT IDENTITY (1,1) PRIMARY KEY,
	username VARCHAR(50),
	password VARCHAR(30),
	nickname VARCHAR(50),
	email VARCHAR(40),
	phone_number NUMERIC(10,0),
	address VARCHAR(50),
	roleId INT,
);

--SELECT * FROM [Users]
--DROP TABLE [Users]

--2. Brand table
CREATE TABLE Brands(
     id INT PRIMARY KEY,
     name VARCHAR(20),
     image VARCHAR(200)
);
--SELECT * FROM Brands
--DROP TABLE Brands

--3.Category table 
CREATE TABLE Category(
     id INT IDENTITY(1,1) PRIMARY KEY,
     name VARCHAR(20),
     image VARCHAR(200)
);
--SELECT * FROM Category
--DROP TABLE Category

--4.Product table
CREATE TABLE Product(
      id INT IDENTITY (1,1) PRIMARY KEY,
      category_id INT FOREIGN KEY REFERENCES Category(id),
      title NVARCHAR(100),
      price NUMERIC(10,2),
      quantity INT,
      discount INT,
      description NVARCHAR(500),
      status INT,
      brand_id INT FOREIGN KEY REFERENCES Brands(id),
      image VARCHAR(200)
);
--SELECT * FROM Product
--DROP TABLE Product

--5.Order table
CREATE TABLE [Orders](
      id INT IDENTITY(1,1) PRIMARY KEY,
      [user_id] INT FOREIGN KEY REFERENCES [Users](id),
      order_date VARCHAR(15),
      total_money NUMERIC(10,2),
	  [status] INT
);
SELECT * FROM [Orders]
SELECT * FROM OrderDetail
--DROP TABLE [Orders]
--DELETE FROM Orders

--6.OrderDetail table
CREATE TABLE OrderDetail(
      id INT IDENTITY(1,1),
      order_id INT FOREIGN KEY REFERENCES [Orders](id),
      product_id INT FOREIGN KEY REFERENCES Product(id),
      price NUMERIC(10,2),
      quantity INT,
      total_money NUMERIC(10,2),  
);
--SELECT * FROM OrderDetail
--DROP TABLE OrderDetail
--DELETE FROM OrderDetail

--Insert DATA 
--Insert data Users (role = 1 => admin / role = 2 => customer)
INSERT INTO [Users] Values ('admin','123', 'ADMIN','admin@123.com','123456789','Ha Noi', 1)
INSERT INTO [Users] Values ('trungkien','123', 'Trung Kien','kien@123.com','123456789','Ha Noi', 2)				
--Insert data Category

INSERT INTO Category Values ('Laptop','https://img.tgdd.vn/imgt/f_webp,fit_outside,quality_100/https://cdn.tgdd.vn//content/icon-laptop-96x96-1.png'), 
							('Smartphone','https://img.tgdd.vn/imgt/f_webp,fit_outside,quality_100/https://cdn.tgdd.vn//content/icon-phone-96x96-2.png'),
							('Smartwatch','https://img.tgdd.vn/imgt/f_webp,fit_outside,quality_100/https://cdn.tgdd.vn//content/icon-smartwatch-96x96-1.png'),
							('Tablet','https://img.tgdd.vn/imgt/f_webp,fit_outside,quality_100/https://cdn.tgdd.vn//content/icon-tablet-96x96-1.png')

--Insert data Brands
INSERT INTO Brands Values (1,'Apple','https://cdn.tgdd.vn/Brand/1/logo-iphone-220x48.png'), 
							(2,'Asus','https://cdn.tgdd.vn/Brand/1/logo-asus-149x40.png'),
							(3,'Dell','https://cdn.tgdd.vn/Brand/1/logo-dell-149x40.png'),
							(4,'Samsung','https://cdn.tgdd.vn/Brand/1/samsungnew-220x48-1.png')
--DELETE FROM Brands
--INSERT data Product
-- Laptop (Pro_id = 1)
INSERT INTO Product VALUES (1,'MacBook Air with M1 chip', 999,10,5,'Apple M1 chip delivers powerful CPU, GPU, and machine learning performance',2,1,'https://cdn.tgdd.vn/Products/Images/44/231244/macbook-air-m1-2020-gold-01-org.jpg')
INSERT INTO Product VALUES (1,'Laptop Asus TUF Gaming F15',799,10,5,'Smoothly run office applications on Word, Excel, PowerPoint, ... to battle hit games thanks to the Intel Core i5 10300H processor combined with the powerful NVIDIA GeForce GTX 1650 4 GB discrete graphics card.',2,2,'https://cdn.tgdd.vn/Products/Images/44/279259/asus-tuf-gaming-fx506lhb-i5-hn188w-600x600.jpeg')
INSERT INTO Product VALUES (1,'Laptop Dell Vostro 3510 i5 1135G7/8GB/512GB/2GB MX350/OfficeHS/Win11 (P112F002BBL) ', 799.86,10,5,'Powered by the powerful Intel Core i5 Tiger Lake 1135G7 chip, operating on a base clock of 2.4 GHz and overclocking up to 4.2 GHz in Turbo Boost mode, the Dell Vostro 3510 effortlessly tackles tasks like composing. Drafting contracts on Word, entering data and statistics via Excel, creating presentations with PowerPoint, ... or basic graphic design on Adobe home applications are equally effective.',2,3,'https://cdn.tgdd.vn/Products/Images/44/266280/dell-vostro-3510-i5-1135g7-8gb-512gb-2gb-600x600.jpg')
INSERT INTO Product VALUES (1,'Laptop Apple MacBook Air M2 2022', 1399,17,5,'The class that comes from the appearance of Apple MacBook Air is undeniable and it is difficult for any product line in the same segment to surpass it. Still a sturdy monolithic metal shell with square, luxurious edges, but this year MacBook Air 2022 has escaped from the inherently gentle design language and put on a new look similar to " senior" MacBook Pro.',2,1,'https://cdn.tgdd.vn/Products/Images/44/282827/apple-macbook-air-m2-2022-xam-600x600.jpg')
INSERT INTO Product VALUES (1,'Laptop Apple MacBook Pro 16 M1 Pro 2021',1759,10,5,'The 16-inch MacBook Pro is powered by the advanced M1 Pro processor equipped with 10 CPU cores (8 high-performance cores + 2 power-saving cores) that deliver up to 70% faster performance than the M1, for the ability to smoothly handle all tasks from the most basic to the most demanding such as image editing, high-resolution video editing,... Not only has fast response time, but also optimizes significant power savings. power.',2,1,'https://cdn.tgdd.vn/Products/Images/44/253636/apple-macbook-pro-16-m1-pro-2021-10-core-cpu-600x600.jpg')
INSERT INTO Product VALUES (1,'Laptop Dell Vostro 5410 i5 11320H', 899,5,5,'Possessing an elegant and sophisticated design style and impressive specifications for a variety of needs from study - office laptops to basic entertainment, the Dell Vostro 5410 i5 laptop will be an option that brings satisfaction for you.',2,3,'https://cdn.tgdd.vn/Products/Images/44/267695/dell-vostro-5410-i5-11320h-8gb-512gb-office-h-s-600x600.jpg')
INSERT INTO Product VALUES (1,'Laptop Asus VivoBook 15X OLED i5/12500H',899,15,5,'Owning a 15.6-inch screen, the Asus VivoBook laptop is neatly designed with a trendy blue-coated plastic frame. Although it is finished with plastic material, the device proved to be quite solid, not deformed when I applied a strong force to weak areas such as the lid and keyboard.',2,2,'https://cdn.tgdd.vn/Products/Images/44/284257/asus-vivobook-15x-oled-a1503za-i5-l1290w-040722-050332-600x600.jpg')

-- Smartphone (Pro_id = 2)
INSERT INTO Product VALUES (2,'iPhone 14 Pro Max',1099,10,5,'Brighter 6.7” Super Retina XDR display¹ featuring Always-On, which keeps your info at a glance Dynamic Island, a magical new way to interact with iPhone',2,1,'https://cdn.tgdd.vn/Products/Images/42/251192/iphone-14-pro-max-vang-thumb-600x600.jpg')
INSERT INTO Product VALUES (2,'iPhone 14 Pro',999,10,5,'Brighter 6.1” Super Retina XDR display¹ featuring Always-On, which keeps your info at a glance Dynamic Island, a magical new way to interact with iPhone Emergency SOS via satellite² and Crash Detection — groundbreaking features designed to save lives³',2,1,'https://cdn.tgdd.vn/Products/Images/42/247508/iphone-14-pro-tim-thumb-600x600.jpg')
INSERT INTO Product VALUES (2,'iPhone 11',499,10,5,'Apple has officially launched a trio of iPhone 11 super products, in which the 64GB iPhone 11 version has the cheapest price but is still upgraded as strongly as the iPhone XR launched before. Powerful upgrade of the camera Talking about upgrades, the camera is the most improved point on the new iPhone generation.',2,1,'https://cdn.tgdd.vn/Products/Images/42/153856/iphone-11-trang-600x600.jpg')
INSERT INTO Product VALUES (2,'iPhone 14',799,10,5,'6.1-inch Super Retina XDR display¹ that’s sharp, vibrant, and bright Awesome all-day battery life with up to 20 hours video playback² Emergency SOS via satellite³ and Crash Detection — groundbreaking features designed to save lives⁴',2,1,'https://cdn.tgdd.vn/Products/Images/42/240259/iPhone-14-thumb-do-600x600.jpg')
INSERT INTO Product VALUES (2,'iPhone 14 Plus',899,10,5,'6.7-inch Super Retina XDR display¹ that’s sharp, vibrant, and bright iPhone 14 Plus has our best battery life ever.² Emergency SOS via satellite³ and Crash Detection — groundbreaking features designed to save lives⁴',2,1,'https://cdn.tgdd.vn/Products/Images/42/245545/iPhone-14-plus-thumb-den-600x600.jpg')
INSERT INTO Product VALUES (2,'iPhone 12',599,10,5,'6.1-inch Super Retina XDR displayfootnote¹ for great contrast and incredible color accuracy Advanced dual-camera system with Night mode and Dolby Vision HDR recording Superpowerful A14 Bionic chip',2,1,'https://cdn.tgdd.vn/Products/Images/42/213031/iphone-12-den-new-2-600x600.jpg')
INSERT INTO Product VALUES (2,'iPhone 13',699,10,5,'6.1-inch Super Retina XDR display¹ Advanced dual-camera system for incredible low-light photos and videos A15 Bionic with 4-core GPU for lightning-fast performance Ceramic Shield, tougher than any smartphone glass. And water resistance.²',2,1,'https://cdn.tgdd.vn/Products/Images/42/223602/iphone-13-starlight-1-600x600.jpg')

--SELECT * FROM Product
--DELETE FROM Product 
