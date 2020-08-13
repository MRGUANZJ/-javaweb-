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

 Date: 14/08/2020 00:02:37
*/


-- ----------------------------
-- Table structure for longin
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[longin]') AND type IN ('U'))
	DROP TABLE [dbo].[longin]
GO

CREATE TABLE [dbo].[longin] (
  [id] int  IDENTITY(1,1) NOT NULL,
  [username] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [password] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL,
  [tephone] varchar(50) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[longin] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of longin
-- ----------------------------
SET IDENTITY_INSERT [dbo].[longin] ON
GO

INSERT INTO [dbo].[longin] ([id], [username], [password], [tephone]) VALUES (N'1', N'myte', N'12345', N'1234567')
GO

INSERT INTO [dbo].[longin] ([id], [username], [password], [tephone]) VALUES (N'2', N'wuli', N'147', N'122')
GO

INSERT INTO [dbo].[longin] ([id], [username], [password], [tephone]) VALUES (N'3', N'wulitu', N'12345', N'12345')
GO

INSERT INTO [dbo].[longin] ([id], [username], [password], [tephone]) VALUES (N'5', N'pp', N'1234', N'147258')
GO

SET IDENTITY_INSERT [dbo].[longin] OFF
GO


-- ----------------------------
-- Auto increment value for longin
-- ----------------------------
DBCC CHECKIDENT ('[dbo].[longin]', RESEED, 11)
GO


-- ----------------------------
-- Primary Key structure for table longin
-- ----------------------------
ALTER TABLE [dbo].[longin] ADD CONSTRAINT [PK_longin] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO

