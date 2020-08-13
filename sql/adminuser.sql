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

 Date: 14/08/2020 00:02:07
*/


-- ----------------------------
-- Table structure for adminuser
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[adminuser]') AND type IN ('U'))
	DROP TABLE [dbo].[adminuser]
GO

CREATE TABLE [dbo].[adminuser] (
  [id] int  IDENTITY(1,1) NOT NULL,
  [username] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [password] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[adminuser] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of adminuser
-- ----------------------------
SET IDENTITY_INSERT [dbo].[adminuser] ON
GO

INSERT INTO [dbo].[adminuser] ([id], [username], [password]) VALUES (N'1', N'admin', N'1234')
GO

SET IDENTITY_INSERT [dbo].[adminuser] OFF
GO


-- ----------------------------
-- Auto increment value for adminuser
-- ----------------------------
DBCC CHECKIDENT ('[dbo].[adminuser]', RESEED, 1)
GO

