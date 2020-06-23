

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Groups
-- ----------------------------
DROP TABLE IF EXISTS `Groups`;
CREATE TABLE `Groups` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `doamin` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of Groups
-- ----------------------------
BEGIN;
INSERT INTO `Groups` VALUES (1, 'intella', 'a1.intella.co');
INSERT INTO `Groups` VALUES (2, 'intella 潮', 'a2.intella.co');
INSERT INTO `Groups` VALUES (3, 'intella 信', 'a3.intella.co');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
