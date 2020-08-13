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

 Date: 14/08/2020 00:01:53
*/


-- ----------------------------
-- Table structure for account
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[account]') AND type IN ('U'))
	DROP TABLE [dbo].[account]
GO

CREATE TABLE [dbo].[account] (
  [id] int  IDENTITY(1,1) NOT NULL,
  [uid] int  NULL,
  [money] decimal(18)  NULL
)
GO

ALTER TABLE [dbo].[account] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of account
-- ----------------------------
SET IDENTITY_INSERT [dbo].[account] ON
GO

INSERT INTO [dbo].[account] ([id], [uid], [money]) VALUES (N'2', N'1', N'1000')
GO

INSERT INTO [dbo].[account] ([id], [uid], [money]) VALUES (N'3', N'2', N'4222')
GO

INSERT INTO [dbo].[account] ([id], [uid], [money]) VALUES (N'4', N'1', N'2000')
GO

SET IDENTITY_INSERT [dbo].[account] OFF
GO


-- ----------------------------
-- Auto increment value for account
-- ----------------------------
DBCC CHECKIDENT ('[dbo].[account]', RESEED, 4)
GO


-- ----------------------------
-- Primary Key structure for table account
-- ----------------------------
ALTER TABLE [dbo].[account] ADD CONSTRAINT [PK_account] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Foreign Keys structure for table account
-- ----------------------------
ALTER TABLE [dbo].[account] ADD CONSTRAINT [FK_account_longin] FOREIGN KEY ([uid]) REFERENCES [dbo].[longin] ([id]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

