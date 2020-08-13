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

 Date: 14/08/2020 00:02:25
*/


-- ----------------------------
-- Table structure for goods
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[goods]') AND type IN ('U'))
	DROP TABLE [dbo].[goods]
GO

CREATE TABLE [dbo].[goods] (
  [name] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [price] decimal(18,2)  NOT NULL,
  [image] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [id] int  IDENTITY(1,1) NOT NULL,
  [demc] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [ishot] int  NULL,
  [cid] int  NULL
)
GO

ALTER TABLE [dbo].[goods] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of goods
-- ----------------------------
SET IDENTITY_INSERT [dbo].[goods] ON
GO

INSERT INTO [dbo].[goods] ([name], [price], [image], [id], [demc], [ishot], [cid]) VALUES (N'姿忆秀五分袖宽松衬衫女2018夏装新款竖条纹\r\n', N'88.00', N'goods_002.png', N'2', NULL, N'0', N'1')
GO

INSERT INTO [dbo].[goods] ([name], [price], [image], [id], [demc], [ishot], [cid]) VALUES (N'梵希蔓短袖雪纺衬衫短款2018夏季新款女装韩\r\n', N'176.00', N'goods_003.png', N'3', NULL, N'0', NULL)
GO

INSERT INTO [dbo].[goods] ([name], [price], [image], [id], [demc], [ishot], [cid]) VALUES (N'电脑椅家用电竞椅 人体工学椅子座椅网布转椅可躺老板椅办公椅', N'269.00', N'goods_005.png', N'5', NULL, N'0', NULL)
GO

INSERT INTO [dbo].[goods] ([name], [price], [image], [id], [demc], [ishot], [cid]) VALUES (N'电脑椅家用座椅办公椅主播椅子游戏椅网吧电竞椅可躺午休', N'699.00', N'goods_006.png', N'6', NULL, N'0', NULL)
GO

INSERT INTO [dbo].[goods] ([name], [price], [image], [id], [demc], [ishot], [cid]) VALUES (N'百图 立领条纹衬衫女套头短袖百搭雪纺衫上\r\n', N'179.00', N'goods_007.png', N'7', NULL, N'0', NULL)
GO

INSERT INTO [dbo].[goods] ([name], [price], [image], [id], [demc], [ishot], [cid]) VALUES (N'不锈钢卫浴室柜组合小户型挂墙式洗手洗脸盆池卫生间厕所洗漱台盆', N'305.00', N'goods_008.png', N'8', NULL, N'0', NULL)
GO

INSERT INTO [dbo].[goods] ([name], [price], [image], [id], [demc], [ishot], [cid]) VALUES (N'北欧双盆浴室柜组合简约卫浴柜镜柜卫生间洗手盆洗脸盆洗漱台盆柜', N'900.00', N'goods_009.png', N'9', NULL, N'0', NULL)
GO

INSERT INTO [dbo].[goods] ([name], [price], [image], [id], [demc], [ishot], [cid]) VALUES (N'简约现代浴室柜洗手盆柜组合洗脸卫生间小户型厕所洗漱台卫浴吊柜', N'948.00', N'goods_10.png', N'10', NULL, N'0', NULL)
GO

INSERT INTO [dbo].[goods] ([name], [price], [image], [id], [demc], [ishot], [cid]) VALUES (N'三只鸟旅行箱拉杆箱女铝框20寸行李箱万向轮24寸学生密码箱登机箱', N'268.00', N'goods_11.png', N'11', NULL, N'0', NULL)
GO

INSERT INTO [dbo].[goods] ([name], [price], [image], [id], [demc], [ishot], [cid]) VALUES (N'全铝镁铝合金拉杆箱金属旅行箱子男女万向轮行李箱商务学生登机箱', N'375.00', N'goods_12.png', N'12', NULL, N'0', NULL)
GO

INSERT INTO [dbo].[goods] ([name], [price], [image], [id], [demc], [ishot], [cid]) VALUES (N'床上双人电脑桌 台式电脑桌家用笔记本电脑桌 ', N'89.00', N'goods_13.png', N'13', NULL, N'0', NULL)
GO

INSERT INTO [dbo].[goods] ([name], [price], [image], [id], [demc], [ishot], [cid]) VALUES (N'男童鞋儿童运动鞋2018春秋新款夏季网面休闲透气小白网鞋女童鞋子', N'79.00', N'goods_14.png', N'14', NULL, N'0', NULL)
GO

INSERT INTO [dbo].[goods] ([name], [price], [image], [id], [demc], [ishot], [cid]) VALUES (N'暗暗', N'122.01', N'', N'23', N'啊是擦上', N'0', N'2')
GO

INSERT INTO [dbo].[goods] ([name], [price], [image], [id], [demc], [ishot], [cid]) VALUES (N'爸爸妈妈和姐姐', N'74.01', N'', N'25', N'我是你的就动手动脚', N'1', N'4')
GO

INSERT INTO [dbo].[goods] ([name], [price], [image], [id], [demc], [ishot], [cid]) VALUES (N'妈妈', N'12.64', N'', N'26', N'八八八', N'0', N'5')
GO

INSERT INTO [dbo].[goods] ([name], [price], [image], [id], [demc], [ishot], [cid]) VALUES (N'阿迪斯', N'12.32', N'', N'28', N'啊打首发', N'0', N'3')
GO

SET IDENTITY_INSERT [dbo].[goods] OFF
GO


-- ----------------------------
-- Auto increment value for goods
-- ----------------------------
DBCC CHECKIDENT ('[dbo].[goods]', RESEED, 28)
GO


-- ----------------------------
-- Indexes structure for table goods
-- ----------------------------
CREATE NONCLUSTERED INDEX [IX_goods]
ON [dbo].[goods] (
  [name] ASC
)
GO


-- ----------------------------
-- Primary Key structure for table goods
-- ----------------------------
ALTER TABLE [dbo].[goods] ADD CONSTRAINT [PK_goods] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Foreign Keys structure for table goods
-- ----------------------------
ALTER TABLE [dbo].[goods] ADD CONSTRAINT [FK_goods_category] FOREIGN KEY ([cid]) REFERENCES [dbo].[category] ([cid]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

