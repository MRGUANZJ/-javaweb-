/*
 Navicat Premium Data Transfer

 Source Server         : sql server
 Source Server Type    : SQL Server
 Source Server Version : 13001601
 Source Host           : LAPTOP-AH3OU4CL:1433
 Source Catalog        : shop
 Source Schema         : dbo

 Target Server Type    : SQL Server
 Target Server Version : 13001601
 File Encoding         : 65001

 Date: 14/08/2020 00:02:16
*/


-- ----------------------------
-- Table structure for category
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[category]') AND type IN ('U'))
	DROP TABLE [dbo].[category]
GO

CREATE TABLE [dbo].[category] (
  [cid] int  NOT NULL,
  [cname] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[category] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO [dbo].[category] ([cid], [cname]) VALUES (N'1', N'电脑办公')
GO

INSERT INTO [dbo].[category] ([cid], [cname]) VALUES (N'2', N'家具家居')
GO

INSERT INTO [dbo].[category] ([cid], [cname]) VALUES (N'3', N'鲜果时光')
GO

INSERT INTO [dbo].[category] ([cid], [cname]) VALUES (N'4', N'图书音响')
GO

INSERT INTO [dbo].[category] ([cid], [cname]) VALUES (N'5', N'服装')
GO


-- ----------------------------
-- Primary Key structure for table category
-- ----------------------------
ALTER TABLE [dbo].[category] ADD CONSTRAINT [PK_category] PRIMARY KEY CLUSTERED ([cid])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO

