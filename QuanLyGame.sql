use master
go

drop database QuanLyGame
go

create database QuanLyGame
go

use QuanLyGame
go

create table ChiNhanh
(
	MaCN NVARCHAR(20) PRIMARY KEY NOT NULL, 
	TenChiNhanh NVARCHAR(50) NOT NULL,
	MaQuanLy NVARCHAR(20) NOT NULL
)
go
insert into ChiNhanh values 
			('HN',N'Hà Nội','EQ754'),
            ('HCM',N'Hồ Chí Minh','EQ129'),
            ('DN',N'Đà Nẵng','EQ789');
go


create table TheLoai
(
	MaTL VARCHAR(5) PRIMARY KEY NOT NULL,
	TenTL NVARCHAR(50) NOT NULL,
	Hinh NVARCHAR(50) NOT NULL DEFAULT '',
	MoTa NVARCHAR(255) NOT NULL
)
go
insert into TheLoai values --Thể loại
			('PS',N'Playstation','PS.png','Không'),
			('PC',N'Personal Computer Game','PC.png','Không'),
			('VR',N'Virtual Reality Game','VR.png','Không');
go

create table PhongMay
(
	MaPM NVARCHAR(50) PRIMARY KEY NOT NULL,
	MucPhi FLOAT NOT NULL,
	ThoiLuong INT NOT NULL,
	GhiChu NVARCHAR(255) null,
	MaCN NVARCHAR(20) NOT NULL FOREIGN KEY REFERENCES ChiNhanh(MaCN),
	MaTL VARCHAR(5) NOT NULL FOREIGN KEY REFERENCES TheLoai(MaTL)
)
go

insert into PhongMay values  --Phòng máy
			('PM001','12000','60',N'Không','HN','PS'),
			('PM002','8000','60',N'Không','DN','PC'),
			('PM003','24000','60',N'Không','HCM','VR');
go

create table NhanVien
(
	MaNV NVARCHAR(7) NOT NULL PRIMARY KEY,
	HoTen NVARCHAR(50) NOT NULL,
	MatKhau NVARCHAR(24) NOT NULL,
	GioiTinh BIT DEFAULT 1 NOT NULL,
	VaiTro BIT DEFAULT(0),
	MaPM NVARCHAR(50) NOT NULl foreign key references PhongMay(MaPM)
)
go

insert into NhanVien values
			('ADMIN',N'Admin','123','1','1','PM001'),
			('XQ001',N'Diệp Quốc Đạt','123','1','1','PM001'),
			('TF009',N'Huỳnh Thị Như','456','0','0','PM003'),
			('TA123',N'Hoàng Xuân Vĩnh','111','1','0','PM001'),
			('UQ941',N'Tuyết Thư','abc','0','0','PM002'),
			('FZ143',N'Lan Anh','zxc','0','0','PM001'),
			('BM004',N'Lưu Trường Định','777','1','1','PM003'),
			('OP002',N'Lê Thành Luân','321','1','1','PM002');
go

create table NguoiChoi
(
	MaNC NVARCHAR(13) PRIMARY KEY NOT NULL,
	MatKhau VARCHAR(24) NOT NULL,
	MaPM NVARCHAR(50) NOT NULL FOREIGN KEY REFERENCES PhongMay(MaPM),
	TienNap FLOAT NOT NULL
)	
go
insert into NguoiChoi values  -- Người Chơi
			('Dat123','abcd','PM001','150000'),
			('Long754','864753','PM003','50000'),
			('Tienn','378435','PM001','25000'),
			('HuanNB','1479','PM003','15000'),
			('Ctza','naras','PM001','20000'),
			('Dinh999','faaa','PM002','500000'),
			('Tuyet310','vzxc','PM001','65000'),
			('BNV134','hasdjk','PM003','10000'),
			('NP001','0081','PM002','30000'),
			('HongP002','46534','PM003','10000'),
			('AB3213','ab3213','PM001','80000'),
			('PM0131','bbbb','PM003','50000'),
			('BZF01','987','PM002','20000'),
			('NP002','456','PM003','18000'),
			('FA414','abcd','PM001','13000'),
			('OTP183','1234','PM003','32000'),
			('NP003','0000','PM002','45000');
go

select * from NguoiChoi
go
select * from NhanVien
go
select * from ChiNhanh
go
select * from PhongMay
go
select * from TheLoai
go