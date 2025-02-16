USE [master]
GO
/****** Object:  Database [DBShop]    Script Date: 18/09/2023 9:34:04 SA ******/
CREATE DATABASE [DBShop]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'DBShop', FILENAME = N'D:\DBShop.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'DBShop_log', FILENAME = N'D:\DBShop_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [DBShop] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DBShop].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [DBShop] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [DBShop] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [DBShop] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [DBShop] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [DBShop] SET ARITHABORT OFF 
GO
ALTER DATABASE [DBShop] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [DBShop] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [DBShop] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [DBShop] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [DBShop] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [DBShop] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [DBShop] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [DBShop] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [DBShop] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [DBShop] SET  DISABLE_BROKER 
GO
ALTER DATABASE [DBShop] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [DBShop] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [DBShop] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [DBShop] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [DBShop] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [DBShop] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [DBShop] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [DBShop] SET RECOVERY FULL 
GO
ALTER DATABASE [DBShop] SET  MULTI_USER 
GO
ALTER DATABASE [DBShop] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [DBShop] SET DB_CHAINING OFF 
GO
ALTER DATABASE [DBShop] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [DBShop] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [DBShop] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'DBShop', N'ON'
GO
ALTER DATABASE [DBShop] SET QUERY_STORE = OFF
GO
USE [DBShop]
GO
/****** Object:  Table [dbo].[Costomer]    Script Date: 18/09/2023 9:34:04 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Costomer](
	[CustomerID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Address] [nvarchar](50) NULL,
	[MobileNo] [nvarchar](50) NULL,
	[Birthdate] [datetime] NULL,
	[Email] [nvarchar](50) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 18/09/2023 9:34:04 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Description] [nvarchar](50) NULL,
	[Price] [float] NULL
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Costomer] ON 

INSERT [dbo].[Costomer] ([CustomerID], [Name], [Address], [MobileNo], [Birthdate], [Email]) VALUES (1, N'Mai', N'14 Nguyễn Văn Bảo', N'11111', CAST(N'2000-03-12T00:00:00.000' AS DateTime), N'mail@gmail.com')
INSERT [dbo].[Costomer] ([CustomerID], [Name], [Address], [MobileNo], [Birthdate], [Email]) VALUES (2, N'Lan', N'14 Nguyễn Văn Bảo', N'2222', CAST(N'2000-04-02T00:00:00.000' AS DateTime), N'lan@gmail.com')
INSERT [dbo].[Costomer] ([CustomerID], [Name], [Address], [MobileNo], [Birthdate], [Email]) VALUES (3, N'Minh', N'14 Nguyễn Văn Bảo', N'3333', CAST(N'2000-03-01T00:00:00.000' AS DateTime), N'minh@gmail.com')
SET IDENTITY_INSERT [dbo].[Costomer] OFF
SET IDENTITY_INSERT [dbo].[Product] ON 

INSERT [dbo].[Product] ([Id], [Name], [Description], [Price]) VALUES (1, N'Pepsi', N'Pepsicola', 5000)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Price]) VALUES (2, N'Coca', N'Cocacole', 5500)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Price]) VALUES (3, N'ChocoPie', N'Orion', 25000)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Price]) VALUES (4, N'Wall''s', N'Icream Wall', 12000)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Price]) VALUES (5, N'Pencil', N'Pencil ', 10000)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Price]) VALUES (1002, N'IPhone', N'Smart Phone', 13000000)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Price]) VALUES (1003, N'Dell', N'Desktop', 20000000)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Price]) VALUES (1004, N'Asus', N'Lapop', 16000000)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Price]) VALUES (6, N'Ruler', N'Ruler', 3000)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Price]) VALUES (7, N'Notebook', N'Book', 8000)
INSERT [dbo].[Product] ([Id], [Name], [Description], [Price]) VALUES (8, N'Pencil', N'Color Pencil ', 15000)
SET IDENTITY_INSERT [dbo].[Product] OFF
USE [master]
GO
ALTER DATABASE [DBShop] SET  READ_WRITE 
GO
