/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 5.7.25-log : Database - eas
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`eas` /*!40100 DEFAULT CHARACTER SET utf32 */;

USE `eas`;

/*Table structure for table `cla` */

DROP TABLE IF EXISTS `cla`;

CREATE TABLE `cla` (
  `Cno` int(11) NOT NULL AUTO_INCREMENT COMMENT '班级号',
  `Cname` varchar(30) NOT NULL COMMENT '班级名称',
  `Xno` int(11) NOT NULL COMMENT '所属系',
  PRIMARY KEY (`Cno`),
  KEY `Xno` (`Xno`),
  CONSTRAINT `cla_ibfk_1` FOREIGN KEY (`Xno`) REFERENCES `sdept` (`Xno`)
) ENGINE=InnoDB AUTO_INCREMENT=614 DEFAULT CHARSET=utf32;

/*Data for the table `cla` */

insert  into `cla`(`Cno`,`Cname`,`Xno`) values 
(213,'交通B',2);
insert  into `cla`(`Cno`,`Cname`,`Xno`) values 
(311,'软件工程A',3);
insert  into `cla`(`Cno`,`Cname`,`Xno`) values 
(513,'化学C',5);
insert  into `cla`(`Cno`,`Cname`,`Xno`) values 
(613,'行政管理A',6);

/*Table structure for table `claroom` */

DROP TABLE IF EXISTS `claroom`;

CREATE TABLE `claroom` (
  `Rno` int(11) NOT NULL COMMENT '教室号',
  `Raddr` varchar(30) NOT NULL COMMENT '教室地址',
  PRIMARY KEY (`Rno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `claroom` */

insert  into `claroom`(`Rno`,`Raddr`) values 
(110,'电子楼202');
insert  into `claroom`(`Rno`,`Raddr`) values 
(113,'电子楼201');
insert  into `claroom`(`Rno`,`Raddr`) values 
(213,'电子楼203');
insert  into `claroom`(`Rno`,`Raddr`) values 
(313,'电子楼204');
insert  into `claroom`(`Rno`,`Raddr`) values 
(403,'电子楼205');
insert  into `claroom`(`Rno`,`Raddr`) values 
(507,'电子楼206');

/*Table structure for table `cour` */

DROP TABLE IF EXISTS `cour`;

CREATE TABLE `cour` (
  `Courceno` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程号',
  `Courcename` varchar(30) NOT NULL COMMENT '课程名称',
  `Credit` int(11) NOT NULL COMMENT '学分',
  `Courcedirector` int(11) NOT NULL COMMENT '授课教师',
  PRIMARY KEY (`Courceno`),
  KEY `Courcedirector` (`Courcedirector`),
  CONSTRAINT `cour_ibfk_1` FOREIGN KEY (`Courcedirector`) REFERENCES `tcher` (`Tno`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5004 DEFAULT CHARSET=utf8;

/*Data for the table `cour` */

insert  into `cour`(`Courceno`,`Courcename`,`Credit`,`Courcedirector`) values 
(1001,'大学心理',4,3561);
insert  into `cour`(`Courceno`,`Courcename`,`Credit`,`Courcedirector`) values 
(2001,'音乐鉴赏',3,4215);
insert  into `cour`(`Courceno`,`Courcename`,`Credit`,`Courcedirector`) values 
(3001,'软件工程',4,2315);
insert  into `cour`(`Courceno`,`Courcename`,`Credit`,`Courcedirector`) values 
(4001,'山水画鉴赏',4,1813);
insert  into `cour`(`Courceno`,`Courcename`,`Credit`,`Courcedirector`) values 
(5001,'制药',4,3154);

/*Table structure for table `elect` */

DROP TABLE IF EXISTS `elect`;

CREATE TABLE `elect` (
  `Sno` int(30) NOT NULL COMMENT '学号',
  `Courceno` int(11) NOT NULL COMMENT '课程号',
  `Grade` double NOT NULL COMMENT '成绩',
  PRIMARY KEY (`Sno`,`Courceno`),
  KEY `Courceno` (`Courceno`),
  CONSTRAINT `elect_ibfk_1` FOREIGN KEY (`Sno`) REFERENCES `studt` (`Sno`) ON DELETE CASCADE,
  CONSTRAINT `elect_ibfk_2` FOREIGN KEY (`Courceno`) REFERENCES `cour` (`Courceno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `elect` */

insert  into `elect`(`Sno`,`Courceno`,`Grade`) values 
(1814080901,1001,86);
insert  into `elect`(`Sno`,`Courceno`,`Grade`) values 
(1814080902,2001,95);
insert  into `elect`(`Sno`,`Courceno`,`Grade`) values 
(1814080903,3001,96);
insert  into `elect`(`Sno`,`Courceno`,`Grade`) values 
(1814080904,4001,84);
insert  into `elect`(`Sno`,`Courceno`,`Grade`) values 
(1814080905,5001,76);

/*Table structure for table `occupy` */

DROP TABLE IF EXISTS `occupy`;

CREATE TABLE `occupy` (
  `Cno` int(11) NOT NULL COMMENT '班级号',
  `Rno` int(11) NOT NULL COMMENT '教室号',
  `Stime` datetime NOT NULL COMMENT '上课时间',
  `Usetime` int(11) NOT NULL DEFAULT '0' COMMENT '占用学时',
  PRIMARY KEY (`Cno`,`Rno`,`Stime`),
  KEY `Rno` (`Rno`),
  CONSTRAINT `occupy_ibfk_1` FOREIGN KEY (`Rno`) REFERENCES `claroom` (`Rno`),
  CONSTRAINT `occupy_ibfk_2` FOREIGN KEY (`Cno`) REFERENCES `cla` (`Cno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `occupy` */

insert  into `occupy`(`Cno`,`Rno`,`Stime`,`Usetime`) values 
(213,110,'2019-05-05 09:20:00',40);
insert  into `occupy`(`Cno`,`Rno`,`Stime`,`Usetime`) values 
(311,113,'2019-04-26 08:00:00',80);
insert  into `occupy`(`Cno`,`Rno`,`Stime`,`Usetime`) values 
(513,213,'2019-04-07 10:00:00',80);
insert  into `occupy`(`Cno`,`Rno`,`Stime`,`Usetime`) values 
(613,313,'2019-04-15 14:00:00',40);

/*Table structure for table `sdept` */

DROP TABLE IF EXISTS `sdept`;

CREATE TABLE `sdept` (
  `Xno` int(11) NOT NULL AUTO_INCREMENT COMMENT '系号',
  `Xname` varchar(30) NOT NULL COMMENT '系名称',
  `Xdirector` int(11) NOT NULL COMMENT '系主任',
  PRIMARY KEY (`Xno`),
  KEY `Xdirector` (`Xdirector`),
  CONSTRAINT `sdept_ibfk_1` FOREIGN KEY (`Xdirector`) REFERENCES `tcher` (`Tno`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `sdept` */

insert  into `sdept`(`Xno`,`Xname`,`Xdirector`) values 
(1,'土木学院',1813);
insert  into `sdept`(`Xno`,`Xname`,`Xdirector`) values 
(2,'交通学院',5451);
insert  into `sdept`(`Xno`,`Xname`,`Xdirector`) values 
(3,'计算机学院',2315);
insert  into `sdept`(`Xno`,`Xname`,`Xdirector`) values 
(4,'生科学院',3154);
insert  into `sdept`(`Xno`,`Xname`,`Xdirector`) values 
(5,'化工学院',4562);
insert  into `sdept`(`Xno`,`Xname`,`Xdirector`) values 
(6,'管理学院',3561);

/*Table structure for table `studt` */

DROP TABLE IF EXISTS `studt`;

CREATE TABLE `studt` (
  `Sno` int(30) NOT NULL AUTO_INCREMENT COMMENT '学号',
  `Sname` varchar(30) NOT NULL COMMENT '姓名',
  `Ssex` varchar(4) NOT NULL COMMENT '性别',
  `Sage` int(11) NOT NULL COMMENT '年龄',
  `Smajor` varchar(30) NOT NULL COMMENT '专业',
  `Cno` int(11) NOT NULL COMMENT '所属班级',
  PRIMARY KEY (`Sno`),
  KEY `Cno` (`Cno`),
  CONSTRAINT `studt_ibfk_1` FOREIGN KEY (`Cno`) REFERENCES `cla` (`Cno`)
) ENGINE=InnoDB AUTO_INCREMENT=1814080909 DEFAULT CHARSET=utf8;

/*Data for the table `studt` */

insert  into `studt`(`Sno`,`Sname`,`Ssex`,`Sage`,`Smajor`,`Cno`) values 
(1814080901,'李艺','男',19,'软件工程',513);
insert  into `studt`(`Sno`,`Sname`,`Ssex`,`Sage`,`Smajor`,`Cno`) values 
(1814080902,'叶子豪','男',20,'软件工程',513);
insert  into `studt`(`Sno`,`Sname`,`Ssex`,`Sage`,`Smajor`,`Cno`) values 
(1814080903,'陈槟炜','男',20,'软件工程',513);
insert  into `studt`(`Sno`,`Sname`,`Ssex`,`Sage`,`Smajor`,`Cno`) values 
(1814080904,'贝伟豪','女',18,'思政教育',311);
insert  into `studt`(`Sno`,`Sname`,`Ssex`,`Sage`,`Smajor`,`Cno`) values 
(1814080905,'林智豪','男',21,'数学教育',213);
insert  into `studt`(`Sno`,`Sname`,`Ssex`,`Sage`,`Smajor`,`Cno`) values 
(1814080906,'全豪杰','女',20,'商务英语',613);

/*Table structure for table `tcher` */

DROP TABLE IF EXISTS `tcher`;

CREATE TABLE `tcher` (
  `Tno` int(11) NOT NULL AUTO_INCREMENT COMMENT '教工号',
  `Tname` varchar(30) NOT NULL COMMENT '姓名',
  `Tsex` varchar(10) NOT NULL COMMENT '性别',
  `Tage` int(11) NOT NULL COMMENT '年龄',
  PRIMARY KEY (`Tno`)
) ENGINE=InnoDB AUTO_INCREMENT=5477 DEFAULT CHARSET=utf8;

/*Data for the table `tcher` */

insert  into `tcher`(`Tno`,`Tname`,`Tsex`,`Tage`) values 
(1813,'陈强','男',58);
insert  into `tcher`(`Tno`,`Tname`,`Tsex`,`Tage`) values 
(2315,'陈忆群','男',29);
insert  into `tcher`(`Tno`,`Tname`,`Tsex`,`Tage`) values 
(3154,'王俊欢','男',29);
insert  into `tcher`(`Tno`,`Tname`,`Tsex`,`Tage`) values 
(3561,'杨小霞','女',32);
insert  into `tcher`(`Tno`,`Tname`,`Tsex`,`Tage`) values 
(4215,'郭海鹰','女',27);
insert  into `tcher`(`Tno`,`Tname`,`Tsex`,`Tage`) values 
(4562,'李晓霞','男',31);
insert  into `tcher`(`Tno`,`Tname`,`Tsex`,`Tage`) values 
(5451,'吕绪洋','男',30);

/*Table structure for table `tching` */

DROP TABLE IF EXISTS `tching`;

CREATE TABLE `tching` (
  `Tno` int(11) NOT NULL COMMENT '教工号',
  `Cno` int(11) NOT NULL COMMENT '班级号',
  `Courceno` int(11) NOT NULL COMMENT '课程号',
  `Teachtime` datetime NOT NULL COMMENT '授课时间',
  PRIMARY KEY (`Tno`,`Cno`,`Courceno`),
  KEY `Cno` (`Cno`),
  KEY `Courceno` (`Courceno`),
  CONSTRAINT `tching_ibfk_1` FOREIGN KEY (`Tno`) REFERENCES `tcher` (`Tno`) ON DELETE CASCADE,
  CONSTRAINT `tching_ibfk_2` FOREIGN KEY (`Cno`) REFERENCES `cla` (`Cno`),
  CONSTRAINT `tching_ibfk_3` FOREIGN KEY (`Courceno`) REFERENCES `cour` (`Courceno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tching` */

insert  into `tching`(`Tno`,`Cno`,`Courceno`,`Teachtime`) values 
(2315,213,1001,'2019-04-07 08:00:00');
insert  into `tching`(`Tno`,`Cno`,`Courceno`,`Teachtime`) values 
(3561,311,2001,'2019-04-15 09:20:00');
insert  into `tching`(`Tno`,`Cno`,`Courceno`,`Teachtime`) values 
(4215,213,3001,'2019-05-05 09:20:00');
insert  into `tching`(`Tno`,`Cno`,`Courceno`,`Teachtime`) values 
(4562,513,5001,'2019-05-25 15:40:00');
insert  into `tching`(`Tno`,`Cno`,`Courceno`,`Teachtime`) values 
(5451,613,4001,'2019-04-26 14:00:00');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(30) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`) values 
(1,'admin','123456');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
