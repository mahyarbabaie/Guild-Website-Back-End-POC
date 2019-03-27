DROP DATABASE  IF EXISTS `guild_website_poc_app`;

CREATE DATABASE  IF NOT EXISTS `guild_website_poc_app`;
USE `guild_website_poc_app`;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
                       `accountId` int        NOT NULL AUTO_INCREMENT,
                       `username` varchar(50) NOT NULL,
                       `email` varchar(50)    NOT NULL,
                       `hash` varchar(128)    NOT NULL,
                       `salt` varchar(50)     NOT NULL,
                       PRIMARY KEY (`accountId`)
) ENGINE=InnoDB AUTO_INCREMENT=1





