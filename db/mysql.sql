CREATE TABLE `customer`
(
    `id`         bigint(20) NOT NULL AUTO_INCREMENT,
    `first_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
    `last_name`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
    `age`        int(11) DEFAULT NULL,
    `address`    varchar(255) COLLATE utf8mb4_bin                       DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;