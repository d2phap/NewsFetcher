CREATE DATABASE [dbNewsFetcher]
GO
USE [dbNewsFetcher]
GO
/****** Object:  Table [dbo].[Website]    Script Date: 11/08/2013 22:40:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Website](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](200) NULL,
	[url] [nvarchar](300) NULL,
 CONSTRAINT [PK_Website] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 11/08/2013 22:40:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[WebsiteID] [int] NOT NULL,
	[name] [nvarchar](200) NULL,
	[url] [nvarchar](300) NULL,
	[xpathlayout] [nvarchar](500) NULL,
	[link] [nvarchar](500) NULL,
	[title] [nvarchar](500) NULL,
	[image] [nvarchar](500) NULL,
	[date] [nvarchar](500) NULL,
	[description] [nvarchar](500) NULL,
	[nextpage] [nvarchar](500) NULL,
	[xpathnextpage] [nvarchar](500) NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Content]    Script Date: 11/08/2013 22:40:29 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Content](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[categoryID] [int] NOT NULL,
	[link] [nvarchar](500) NULL,
	[title] [nvarchar](500) NULL,
	[image] [nvarchar](500) NULL,
	[date] [nvarchar](500) NULL,
	[description] [nvarchar](500) NULL,
	[nextpage] [nvarchar](500) NULL,
 CONSTRAINT [PK_Content] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  ForeignKey [FK_Category_Website]    Script Date: 11/08/2013 22:40:29 ******/
ALTER TABLE [dbo].[Category]  WITH CHECK ADD  CONSTRAINT [FK_Category_Website] FOREIGN KEY([WebsiteID])
REFERENCES [dbo].[Website] ([id])
GO
ALTER TABLE [dbo].[Category] CHECK CONSTRAINT [FK_Category_Website]
GO
/****** Object:  ForeignKey [FK_Content_Category]    Script Date: 11/08/2013 22:40:29 ******/
ALTER TABLE [dbo].[Content]  WITH CHECK ADD  CONSTRAINT [FK_Content_Category] FOREIGN KEY([categoryID])
REFERENCES [dbo].[Category] ([id])
GO
ALTER TABLE [dbo].[Content] CHECK CONSTRAINT [FK_Content_Category]
GO
