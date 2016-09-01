/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : menu

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2016-09-01 13:33:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `z_cart`
-- ----------------------------
DROP TABLE IF EXISTS `z_cart`;
CREATE TABLE `z_cart` (
  `cartId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`cartId`),
  KEY `fk_ddd` (`userId`),
  CONSTRAINT `fk_ddd` FOREIGN KEY (`userId`) REFERENCES `z_user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of z_cart
-- ----------------------------
INSERT INTO `z_cart` VALUES ('1', '33');
INSERT INTO `z_cart` VALUES ('2', '34');
INSERT INTO `z_cart` VALUES ('3', '35');
INSERT INTO `z_cart` VALUES ('4', '36');

-- ----------------------------
-- Table structure for `z_cart_menu`
-- ----------------------------
DROP TABLE IF EXISTS `z_cart_menu`;
CREATE TABLE `z_cart_menu` (
  `cart_menuId` int(11) NOT NULL AUTO_INCREMENT,
  `menuName` varchar(64) NOT NULL,
  `menuPrice` double NOT NULL,
  `menuImage` varchar(100) DEFAULT NULL,
  `cartId` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT '1',
  `sellerId` int(11) DEFAULT NULL,
  PRIMARY KEY (`cart_menuId`),
  KEY `fk_wwww` (`cartId`),
  CONSTRAINT `fk_wwww` FOREIGN KEY (`cartId`) REFERENCES `z_cart` (`cartId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of z_cart_menu
-- ----------------------------
INSERT INTO `z_cart_menu` VALUES ('1', '鸡蛋炒粉', '8', 'SellerMenuImages/鸡蛋炒粉.jpg', '4', '2', '5');

-- ----------------------------
-- Table structure for `z_order`
-- ----------------------------
DROP TABLE IF EXISTS `z_order`;
CREATE TABLE `z_order` (
  `orderId` int(11) NOT NULL,
  `orderTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `orderPrice` double DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `orderStatus` int(11) DEFAULT '0',
  `sellerId` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderId`),
  KEY `fk_ttt` (`sellerId`),
  KEY `fk_tttt` (`userId`),
  CONSTRAINT `fk_ttt` FOREIGN KEY (`sellerId`) REFERENCES `z_seller` (`sellerId`),
  CONSTRAINT `fk_tttt` FOREIGN KEY (`userId`) REFERENCES `z_user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of z_order
-- ----------------------------
INSERT INTO `z_order` VALUES ('0', '2016-08-30 11:52:52', null, null, '0', null);
INSERT INTO `z_order` VALUES ('1', '2016-08-30 14:32:04', '8', '33', '0', '5');
INSERT INTO `z_order` VALUES ('2', '2016-08-30 14:32:16', '517.5', '33', '0', '3');
INSERT INTO `z_order` VALUES ('3', '2016-08-30 14:32:16', '318.5', '33', '0', '3');
INSERT INTO `z_order` VALUES ('4', '2016-08-30 14:33:58', '34.5', '33', '0', '3');
INSERT INTO `z_order` VALUES ('5', '2016-08-30 14:35:00', '91', '33', '0', '3');
INSERT INTO `z_order` VALUES ('6', '2016-08-30 14:35:00', '34.5', '33', '0', '3');
INSERT INTO `z_order` VALUES ('7', '2016-08-30 14:35:51', '91', '33', '0', '3');
INSERT INTO `z_order` VALUES ('8', '2016-08-30 15:26:18', '34.5', '33', '0', '3');
INSERT INTO `z_order` VALUES ('9', '2016-08-31 11:55:52', '690', '33', '0', '3');
INSERT INTO `z_order` VALUES ('10', '2016-09-01 09:09:55', '16', '33', '0', '5');
INSERT INTO `z_order` VALUES ('11', '2016-09-01 11:09:13', '16', '33', '0', '5');
INSERT INTO `z_order` VALUES ('12', '2016-09-01 11:09:13', '69', '33', '0', '3');
INSERT INTO `z_order` VALUES ('13', '2016-09-01 11:09:45', '34.5', '33', '0', '3');

-- ----------------------------
-- Table structure for `z_order_menu`
-- ----------------------------
DROP TABLE IF EXISTS `z_order_menu`;
CREATE TABLE `z_order_menu` (
  `order_menuId` int(11) NOT NULL AUTO_INCREMENT,
  `menuName` varchar(64) NOT NULL,
  `menuPrice` double NOT NULL,
  `menuImage` varchar(32) DEFAULT NULL,
  `amount` int(11) DEFAULT '1',
  `orderId` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_menuId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of z_order_menu
-- ----------------------------
INSERT INTO `z_order_menu` VALUES ('4', '鸡蛋炒粉', '8', 'SellerMenuImages/鸡蛋炒粉.jpg', '1', '1');
INSERT INTO `z_order_menu` VALUES ('5', '红烧猪肉', '34.5', 'SellerMenuImages/3.jpg', '15', '2');
INSERT INTO `z_order_menu` VALUES ('6', '红烧 ', '45.5', 'SellerMenuImages/4.jpg', '7', '3');
INSERT INTO `z_order_menu` VALUES ('7', '红烧猪肉', '34.5', 'SellerMenuImages/3.jpg', '1', '4');
INSERT INTO `z_order_menu` VALUES ('8', '红烧 ', '45.5', 'SellerMenuImages/4.jpg', '2', '5');
INSERT INTO `z_order_menu` VALUES ('9', '红烧猪肉', '34.5', 'SellerMenuImages/3.jpg', '1', '6');
INSERT INTO `z_order_menu` VALUES ('10', '红烧 ', '45.5', 'SellerMenuImages/4.jpg', '2', '7');
INSERT INTO `z_order_menu` VALUES ('11', '红烧猪肉', '34.5', 'SellerMenuImages/3.jpg', '1', '8');
INSERT INTO `z_order_menu` VALUES ('12', '红烧猪肉', '34.5', 'SellerMenuImages/3.jpg', '20', '9');
INSERT INTO `z_order_menu` VALUES ('13', '鸡蛋炒粉', '8', 'SellerMenuImages/鸡蛋炒粉.jpg', '2', '10');
INSERT INTO `z_order_menu` VALUES ('14', '鸡蛋炒粉', '8', 'SellerMenuImages/鸡蛋炒粉.jpg', '2', '11');
INSERT INTO `z_order_menu` VALUES ('15', '红烧猪肉', '34.5', 'SellerMenuImages/3.jpg', '2', '12');
INSERT INTO `z_order_menu` VALUES ('16', '红烧猪肉', '34.5', 'SellerMenuImages/3.jpg', '1', '13');

-- ----------------------------
-- Table structure for `z_seller`
-- ----------------------------
DROP TABLE IF EXISTS `z_seller`;
CREATE TABLE `z_seller` (
  `sellerId` int(11) NOT NULL AUTO_INCREMENT,
  `sellerName` varchar(32) NOT NULL,
  `sellerAddress` varchar(32) DEFAULT NULL,
  `sellerLogo` varchar(32) DEFAULT NULL,
  `sellerPositiveAccount` int(11) DEFAULT '0',
  `sellerNagetiveAccount` int(11) DEFAULT '0',
  `storeName` text,
  `storeType` varchar(32) DEFAULT NULL,
  `password` varchar(32) NOT NULL,
  `balance` double DEFAULT '0',
  PRIMARY KEY (`sellerId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of z_seller
-- ----------------------------
INSERT INTO `z_seller` VALUES ('3', '1', '江西省宁都县', 'sellerLogo/黄焖鸡.jpg', '0', '0', '飘香黄焖鸡', '快餐便当', '1', '1915');
INSERT INTO `z_seller` VALUES ('4', '2', null, 'SellerMenuImages/4.jpg', '0', '0', '七里香餐馆', null, '2', '0');
INSERT INTO `z_seller` VALUES ('5', '3', '厦门软件园二期1号楼', 'sellerLogo/沙县小吃.jpg', '0', '0', '沙县小吃', '快餐便当', '3', '40');
INSERT INTO `z_seller` VALUES ('6', '4', '厦门软件园二期2号楼', 'sellerLogo/竹筒饭.jpg', '0', '0', '竹筒饭', '快餐便当', '4', '0');
INSERT INTO `z_seller` VALUES ('7', '5', '厦门软件园二期3号楼', 'sellerLogo/飘香鸭.jpg', '0', '0', '飘香鸭', '快餐便当', '5', '0');
INSERT INTO `z_seller` VALUES ('8', 'wo', '中国', null, '0', '0', null, null, '12', '0');
INSERT INTO `z_seller` VALUES ('9', 'we', '中国', 'sellerLogo/1.jpg', '0', '0', '水果沙拉', '果蔬生鲜', '12', '0');
INSERT INTO `z_seller` VALUES ('10', 'a', 'dffddfd', 'sellerLogo/3.png', '0', '0', 'dfdsfddfd', '快餐便当', 'a', '0');

-- ----------------------------
-- Table structure for `z_seller_menu`
-- ----------------------------
DROP TABLE IF EXISTS `z_seller_menu`;
CREATE TABLE `z_seller_menu` (
  `seller_menuId` int(11) NOT NULL AUTO_INCREMENT,
  `menuName` varchar(64) NOT NULL,
  `menuPrice` double NOT NULL,
  `sellerId` int(11) DEFAULT NULL,
  `menuImage` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`seller_menuId`),
  KEY `fk_RRR` (`sellerId`),
  CONSTRAINT `fk_RRR` FOREIGN KEY (`sellerId`) REFERENCES `z_seller` (`sellerId`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of z_seller_menu
-- ----------------------------
INSERT INTO `z_seller_menu` VALUES ('42', '红烧猪肉', '34.5', '3', 'SellerMenuImages/3.jpg');
INSERT INTO `z_seller_menu` VALUES ('43', '红烧 ', '45.5', '3', 'SellerMenuImages/4.jpg');
INSERT INTO `z_seller_menu` VALUES ('44', '鸡蛋炒粉', '8', '5', 'SellerMenuImages/鸡蛋炒粉.jpg');
INSERT INTO `z_seller_menu` VALUES ('45', 'dfdf', '34', '3', 'SellerMenuImages/io.jpg');
INSERT INTO `z_seller_menu` VALUES ('46', '苹果xxx', '12', '9', 'SellerMenuImages/1.jpg');
INSERT INTO `z_seller_menu` VALUES ('47', 'xxxxxx', '23', '10', 'SellerMenuImages/1.png');

-- ----------------------------
-- Table structure for `z_user`
-- ----------------------------
DROP TABLE IF EXISTS `z_user`;
CREATE TABLE `z_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(32) NOT NULL,
  `userPassword` varchar(32) NOT NULL,
  `userStatus` int(11) DEFAULT '1',
  `userImage` blob,
  `userAccount` double DEFAULT '0',
  `phone` varchar(12) DEFAULT NULL,
  `address` varchar(54) DEFAULT NULL,
  `type` int(11) DEFAULT '0',
  `gender` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of z_user
-- ----------------------------
INSERT INTO `z_user` VALUES ('33', '1', '1', '1', null, '1230368', null, null, '0', '男');
INSERT INTO `z_user` VALUES ('34', '2', '2', '1', null, '0', null, null, '0', '男');
INSERT INTO `z_user` VALUES ('35', '3', '3', '1', null, '0', null, null, '0', '男');
INSERT INTO `z_user` VALUES ('36', 'we', '12', '1', null, '0', null, null, '0', null);
DROP TRIGGER IF EXISTS `mytrigger`;
DELIMITER ;;
CREATE TRIGGER `mytrigger` AFTER INSERT ON `z_user` FOR EACH ROW BEGIN
     insert into z_cart(userId) values(new.userId);
END
;;
DELIMITER ;
