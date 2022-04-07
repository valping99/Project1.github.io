use QuanLyGame
go

DROP PROC sp_ThongKeTheLoai
GO
CREATE PROC sp_ThongKeTheLoai
AS BEGIN
	SELECT
		TenTL TheLoai,
		COUNT(MaNC) SoNC,
		SUM(TienNap) DoanhThu
	FROM PhongMay pm
		JOIN NguoiChoi nc ON pm.MaPM=nc.MaPM
		JOIN TheLoai tl ON tl.MaTL=pm.MaTL
	GROUP BY TenTL
END
GO


DROP PROC sp_ThongKeChiNhanh
GO
CREATE PROC sp_ThongKeChiNhanh
AS BEGIN
	SELECT
		TenChiNhanh ChiNhanh,
		COUNT(distinct pm.MaPM),
		SUM(TienNap) DoanhThu,
		COUNT(distinct MaNV) MaNhanVien
	FROM ChiNhanh cn
		JOIN PhongMay pm ON pm.MaCN = cn.MaCN
		JOIN NguoiChoi nc ON pm.MaPM = nc.MaPM
		JOIN NhanVien nv ON pm.MaPM = nv.MaPM
	GROUP BY TenChiNhanh
END
GO

drop proc sp_NhanVien
go

CREATE PROC sp_NhanVien
(
@MaPM NVARCHAR(50)
)
AS BEGIN
	SELECT
		nv.MaNV,
		nv.HoTen,
		nv.GioiTinh,
		nv.VaiTro
	FROM NhanVien nv
		JOIN PhongMay pm ON nv.MaPM=pm.MaPM
	WHERE pm.MaPM = @MaPM
END
GO


DROP PROC sp_ThongKeNguoiChoi
GO
CREATE PROC sp_ThongKeNguoiChoi
(
@MaPM NVARCHAR(50)
)
AS BEGIN
	SELECT
		nc.MaNC,
		nc.MatKhau,
		SUM(TienNap),
		nc.TienNap,
		nc.MaPM
	FROM NguoiChoi nc
	JOIN PhongMay pm ON pm.MaPM = nc.MaPM
	WHERE pm.MaPM = @MaPM
	GROUP BY nc.MaNC,nc.MatKhau,TienNap,nc.MaPM
END
GO



DROP PROC sp_ThongKePhongMay
GO
CREATE PROC sp_ThongKePhongMay
AS BEGIN
	SELECT
		pm.MaPM PhongMay,
		COUNT(nc.MaNC) SoNC,
		SUM(TienNap) DoanhThu,
		MAX(TienNap) CaoNhat,
		MIN(TienNap) ThapNhat,
		cn.TenChiNhanh,
		tl.MaTL
	FROM PhongMay pm
		JOIN NguoiChoi nc ON pm.MaPM=nc.MaPM
		JOIN TheLoai tl ON tl.MaTL=pm.MaTL
		JOIN ChiNhanh cn ON cn.MaCN = pm.MaCN
	GROUP BY pm.MaPM,tl.MaTL,cn.TenChiNhanh
END
GO
