create database DeOn

use DeOn
create table DanhMuc(
	MaDM nvarchar(20) primary key not null,
	TenDanhMuc nvarchar(50), 
	NguoiQuanLi nvarchar(50),
	GhiChu nvarchar(50)

)

create table TinTuc(
	MaTT nvarchar(20) primary key not null,
	TieuDe nvarchar(50),
	NoiDungTT nvarchar(50),
	LienKet nvarchar(50),
	MaDM nvarchar(20)FOREIGN KEY REFERENCES DanhMuc(MaDM)
	
)

insert into DanhMuc(MaDM,TenDanhMuc,NguoiQuanLi,GhiChu)
values('DM1','OK','Tu Uyen','hehe');



insert into TinTuc(MaTT,TieuDe,NoiDungTT,LienKet,MaDM)
values('TT1','Tieu de','hihi','HQ','DM1');

select *from DanhMuc
select *from TinTuc

--lay tin tuc theo danh muc

select MaTT,TieuDe,NoiDungTT,LienKet
 from TinTuc as tt
join DanhMuc as dm
on tt.MaDM = dm.MaDM
where dm.MaDM = 'DM1'