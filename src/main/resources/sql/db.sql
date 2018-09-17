# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.19)
# Database: meeting_ticket
# Generation Time: 2018-09-12 10:50:41 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table author
# ------------------------------------------------------------

DROP TABLE IF EXISTS `author`;

CREATE TABLE `author` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '嘉宾主键',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `summary` varchar(255) DEFAULT NULL COMMENT '简介',
  `avatar_img_url` varchar(255) DEFAULT NULL COMMENT '头像',
  `positional_title` varchar(255) DEFAULT NULL COMMENT '职称',
  `profession` varchar(100) DEFAULT NULL COMMENT '从事行业',
  `company` varchar(100) DEFAULT NULL COMMENT '公司名称',
  `blog_site_url` varchar(255) DEFAULT NULL COMMENT '博客地址',
  `github_site_url` varchar(255) DEFAULT NULL COMMENT 'github地址',
  `interest` varchar(255) DEFAULT NULL COMMENT '兴趣爱好',
  `praise` int(11) DEFAULT '0' COMMENT '点赞数',
  `collection` int(11) DEFAULT '0' COMMENT '关注数',
  `del_flag` tinyint(1) DEFAULT '0' COMMENT '删除状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;

INSERT INTO `author` (`id`, `name`, `summary`, `avatar_img_url`, `positional_title`, `profession`, `company`, `blog_site_url`, `github_site_url`, `interest`, `praise`, `collection`, `del_flag`)
VALUES
	(4,'yuhongliang','目前从事前端开发，java开发相关工作','http://pd6hea2xj.bkt.clouddn.com/static/upload/images/2018/7/22/jl4qymkq.jpg','开发工程师','互联网IT行业','杭州淘淘搜科技有限公司','http://frontme.cn','https://github.com/ployer900','书法，户外运动',0,0,0),
	(14,'yuhongliang900','从事nodejs开发工作','https://p1.meituan.net/aichequan/a88918ba8699e15a5d16d5d7e09ad0022192.png','工程师','互联网IT行业','京东','http://brickjs.com','https://github.com/ployer900','美术，篮球，旅行',0,0,1),
	(23,'余鸿亮','2015年毕业，先后任职于杭州淘淘搜科技有限公司、京东。一直从事前端开发工作，工作内容主要为移动端web开发。期间也涉猎过其他技术，如java、python。等目前就职于美团点评。','http://pd6hea2xj.bkt.clouddn.com/static/upload/images/2018/7/28/jldgqqki.jpg','初级前端开发工程师','IT互联网行业','美团点评','http://brickjs.com','https://github.com/ployer900','美术、户外运动',0,0,0),
	(24,'yuhooooo','yuhooooo','http://pd6hea2xj.bkt.clouddn.com/static/upload/images/2018/7/29/jlew15as.jpg','','IT互联网餐饮行业','媒体','','','',0,0,1),
	(25,'谢国恩','毕业于郑州大学，8年技术从业经历，曾担任小牛电动技术主管、百合网架构师，现任嘟嘟科技技术总监。','http://pd6hea2xj.bkt.clouddn.com/static/upload/images/2018/8/7/jlrumqbw.jpg','','互联网','嘟嘟科技','','','',0,0,0),
	(26,'dameng','郑州某 Python 团队研发负责人，前 ThoughtWorks 工程师，混迹在各种编程语言圈的Pythoner, 擅长各种编程语言的Hello World程序的开发，译著有《Effective Ruby》中文版。','http://pd6hea2xj.bkt.clouddn.com/static/upload/images/2018/8/7/jlruo3p3.jpg','','互联网','无','','','',0,0,0);

/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table category
# ------------------------------------------------------------

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(60) NOT NULL COMMENT '类别名称',
  `type` int(11) DEFAULT '0' COMMENT '类型值',
  `create_time` varchar(45) DEFAULT NULL COMMENT '创建时间',
  `last_update_time` varchar(45) DEFAULT NULL COMMENT '最近更新时间',
  `position` tinyint(4) DEFAULT '0' COMMENT '放置位置（比如置顶等）',
  `is_hot` tinyint(4) DEFAULT '0' COMMENT '是否热门',
  `is_draft` tinyint(4) DEFAULT '1' COMMENT '是否为草稿，待发布',
  `is_expired` tinyint(4) DEFAULT '0' COMMENT '是否过期',
  `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table meet
# ------------------------------------------------------------

DROP TABLE IF EXISTS `meet`;

CREATE TABLE `meet` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) NOT NULL COMMENT '会议主题',
  `img_url` varchar(255) DEFAULT NULL COMMENT '主题图',
  `publisher` varchar(100) DEFAULT NULL COMMENT '发布者',
  `time` varchar(100) NOT NULL COMMENT '时间',
  `ticket_price` varchar(255) DEFAULT NULL COMMENT '票价',
  `addr` varchar(255) NOT NULL COMMENT '地址',
  `summary` mediumtext NOT NULL COMMENT '简介',
  `category_id` int(11) DEFAULT NULL,
  `comment_id` int(11) DEFAULT NULL COMMENT '评论标识，用于关联评论表',
  `comment` int(11) DEFAULT NULL COMMENT '评论数',
  `collection` int(11) DEFAULT NULL COMMENT '收藏数',
  `sponsor` varchar(200) NOT NULL COMMENT '主办方',
  `co_sponsor` varchar(200) DEFAULT NULL COMMENT '协办方',
  `publish` tinyint(4) DEFAULT '1' COMMENT '是否发布',
  `theme_ids` varchar(60) DEFAULT NULL COMMENT '主题ids',
  `out_of_date` tinyint(4) DEFAULT '0' COMMENT '是否过期',
  `del_flag` tinyint(1) DEFAULT '0' COMMENT '是否为删除态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `meet` WRITE;
/*!40000 ALTER TABLE `meet` DISABLE KEYS */;

INSERT INTO `meet` (`id`, `title`, `img_url`, `publisher`, `time`, `ticket_price`, `addr`, `summary`, `category_id`, `comment_id`, `comment`, `collection`, `sponsor`, `co_sponsor`, `publish`, `theme_ids`, `out_of_date`, `del_flag`)
VALUES
	(36,'UCan下午茶 2018-杭州站《企业的“数据困惑”该何去何从？》','http://pd6hea2xj.bkt.clouddn.com/static/upload/images/2018/7/15/jkv2puqj.jpg',NULL,'2018.08.15 19:49:46~2018.08.24 00:00:00','免费',' 浙江 杭州 独角兽路演中心','如今，已经进入大数据时代， 各种系统、应用、活动所产生的数据已经浩如烟海，数据已经不再仅仅是企业存储的信息，而是已经成为可以从中获取巨大商业价值的企业的战略资产，在这样的情况下，如何存储如此海量复杂的数据，如何从纷繁错综的数据中找到真正有价值的数据，如何更有效的保护数据，这都是在大数据时代困惑企业的难题。为此，UCloud将针对以上相关问题，于“UCan下午茶”2018 —— 杭州站为大家现身说法，答疑解惑。',0,0,0,0,'七牛云','七牛云',1,NULL,0,0),
	(37,'极客原创-UCan下午茶 2018-杭州站《企业的“数据困惑”该何去何从？》','http://pd6hea2xj.bkt.clouddn.com/static/upload/images/2018/7/28/jldhv98h.jpg',NULL,'2018-08-28 09:00~2018-09-04 16:00','50元每人（可现场支付）',' 浙江 杭州 独角兽路演中心','如今，已经进入大数据时代， 各种系统、应用、活动所产生的数据已经浩如烟海，数据已经不再仅仅是企业存储的信息，而是已经成为可以从中获取巨大商业价值的企业的战略资产，在这样的情况下，如何存储如此海量复杂的数据，如何从纷繁错综的数据中找到真正有价值的数据，如何更有效的保护数据，这都是在大数据时代困惑企业的难题。为此，UCloud将针对以上相关问题，于“UCan下午茶”2018 —— 杭州站为大家现身说法，答疑解惑。',0,NULL,0,0,'开源中国','开源中国、七牛云',1,NULL,0,0),
	(38,'aaa','http://pd6hea2xj.bkt.clouddn.com/static/upload/images/2018/7/29/jlejtd6r.jpg',NULL,'2018-08-29 00:00~2018-08-31 00:00','aaa','cc','cc',0,NULL,0,0,'aaa','qqqqq',1,NULL,0,1),
	(39,'China Cloud Native End User Conference 中国云原生用户大会','http://pd6hea2xj.bkt.clouddn.com/static/upload/images/2018/7/29/jlek2j2f.jpg',NULL,'2018-09-16 08:00~2018-09-16 18:30',' 168元/人（早鸟票）','浙江 杭州 （浙江杭州）滨江区长江南路336号杭州白马湖建国饭店','2018 中国云原生用户大会（ 2018 CEUC ）是由才云科技（ Caicloud ）、「K8sMeetup 中国社区」和「Kubeflow 社区」联合主办的聚焦中国行业应用与技术落地的盛会。\n\n2017 年 10 月，由 Caicloud、CNCF 及 「K8sMeetup 中国社区」联合在杭州举办的 Kubernetes 中国用户大会（KEUC, Kubernetes End User Conference ）会议 ，是迄今为止中国境内规模最大、实践技术最前沿 Kubernetes 领域盛会。作为 KEUC 的升级会议，2018 CEUC 将继续秉承 KEUC 开放协作、 技术共享的宗旨，致力于为业界带来最新开源技术、行业应用案例展示与最佳实践；对话 Cloud Native 领域中地区和国际技术专家，以实践经验与前沿视角为中国企业级行业用户，在业务部署和实践带来精准指引。',0,NULL,0,0,'才云、中国社区','网易云、七牛云、钛媒体、美通社、开源中国社区',1,NULL,0,0),
	(40,'【郑州】OSC源创会第79期报名开始','http://pd6hea2xj.bkt.clouddn.com/static/upload/images/2018/8/7/jlrur8mz.jpg',NULL,'2018-09-16 14:00~2018-09-16 17:30','50元/人（现场缴费，女士，开源软件作者，积分50以上者均免费，邀请满三个好友报名者免费，学生凭学生证免费）',' 河南 郑州 高新区长椿路梧桐街国家大学科技园2号楼A座郑州云士酒店六楼大会议室','在已有微微凉意的九月，源创会将来到河南探索这座处于十三朝古都洛阳和七朝古都开封之间的美丽城市——郑州，我们一如既往秉承着“自由，开放，分享”的思想，诚邀郑州的小伙伴们前来赴约，期待与你相见！',0,NULL,0,0,'开源中国、大象互联网圈','容联云通讯、UCLOUD、elastic',1,NULL,0,1),
	(41,'【郑州】OSC源创会第79期报名开始啦','http://pd6hea2xj.bkt.clouddn.com/static/upload/images/2018/8/7/jlrur8mz.jpg',NULL,'2018-09-16 14:00~2018-09-16 17:30','50元/人（现场缴费，女士，开源软件作者，积分50以上者均免费，邀请满三个好友报名者免费，学生凭学生证免费）',' 河南 郑州 高新区长椿路梧桐街国家大学科技园2号楼A座郑州云士酒店六楼大会议室','在已有微微凉意的九月，源创会将来到河南探索这座处于十三朝古都洛阳和七朝古都开封之间的美丽城市——郑州，我们一如既往秉承着“自由，开放，分享”的思想，诚邀郑州的小伙伴们前来赴约，期待与你相见！',0,NULL,0,0,'开源中国、大象互联网圈','容联云通讯、UCLOUD、elastic',1,NULL,0,1),
	(42,'【郑州】OSC源创会第79期报名开始','http://pd6hea2xj.bkt.clouddn.com/static/upload/images/2018/8/7/jlrur8mz.jpg',NULL,'2018-09-16 14:00~2018-09-16 17:30','50元/人（现场缴费，女士，开源软件作者，积分50以上者均免费，邀请满三个好友报名者免费，学生凭学生证免费）',' 河南 郑州 高新区长椿路梧桐街国家大学科技园2号楼A座郑州云士酒店六楼大会议室','在已有微微凉意的九月，源创会将来到河南探索这座处于十三朝古都洛阳和七朝古都开封之间的美丽城市——郑州，我们一如既往秉承着“自由，开放，分享”的思想，诚邀郑州的小伙伴们前来赴约，期待与你相见！',0,NULL,0,0,'开源中国、大象互联网圈','容联云通讯、UCLOUD、elastic',1,NULL,0,1),
	(43,'【郑州】OSC源创会第79期报名开始','http://pd6hea2xj.bkt.clouddn.com/static/upload/images/2018/8/7/jlrur8mz.jpg',NULL,'2018-09-16 14:00~2018-09-16 17:30','50元/人（现场缴费，女士，开源软件作者，积分50以上者均免费，邀请满三个好友报名者免费，学生凭学生证免费）',' 河南 郑州 高新区长椿路梧桐街国家大学科技园2号楼A座郑州云士酒店六楼大会议室','在已有微微凉意的九月，源创会将来到河南探索这座处于十三朝古都洛阳和七朝古都开封之间的美丽城市——郑州，我们一如既往秉承着“自由，开放，分享”的思想，诚邀郑州的小伙伴们前来赴约，期待与你相见！',0,NULL,0,0,'开源中国、大象互联网圈','容联云通讯、UCLOUD、elastic',1,NULL,0,1),
	(44,'【郑州】OSC源创会第79期报名开始','http://pd6hea2xj.bkt.clouddn.com/static/upload/images/2018/8/7/jlrur8mz.jpg',NULL,'2018-09-16 14:00~2018-09-16 17:30','50元/人（现场缴费，女士，开源软件作者，积分50以上者均免费，邀请满三个好友报名者免费，学生凭学生证免费）',' 河南 郑州 高新区长椿路梧桐街国家大学科技园2号楼A座郑州云士酒店六楼大会议室','在已有微微凉意的九月，源创会将来到河南探索这座处于十三朝古都洛阳和七朝古都开封之间的美丽城市——郑州，我们一如既往秉承着“自由，开放，分享”的思想，诚邀郑州的小伙伴们前来赴约，期待与你相见！',0,NULL,0,0,'开源中国、大象互联网圈','容联云通讯、UCLOUD、elastic',1,NULL,0,0);

/*!40000 ALTER TABLE `meet` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table theme
# ------------------------------------------------------------

DROP TABLE IF EXISTS `theme`;

CREATE TABLE `theme` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(100) NOT NULL COMMENT '主题名称',
  `content` text NOT NULL COMMENT '主题内容',
  `meet_id` int(11) DEFAULT '0' COMMENT '所属会议ID',
  `author_id` varchar(45) NOT NULL DEFAULT '' COMMENT '嘉宾ID',
  `del_flag` tinyint(1) DEFAULT '0' COMMENT '删除状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `theme` WRITE;
/*!40000 ALTER TABLE `theme` DISABLE KEYS */;

INSERT INTO `theme` (`id`, `title`, `content`, `meet_id`, `author_id`, `del_flag`)
VALUES
	(42,'nodejs服务搭建','nodejs服务搭建',36,'4',1),
	(43,'vue搭建cms','vue搭建cms',36,'14',1),
	(44,'数据库高可用容灾方案设计和实现','高可用容灾是搭建数据库服务的一个重要考量特性，搭建高可用数据库服务时有诸多问题需要解决，以保证最终的容灾效果。UCloud云数据库产品UDB在研发演进过程中，根据用户的需要不断完善和演进，现在已经形成一套完善的高可用架构体系。本讲座主要讲述了如何设计和运营一套完善的数据库高可用架构，保证在出现异常时能够及时恢复数据库服务，并保证数据的一致性。通过本讲座，听众可以了解数据库高可用容灾的经典架构，并了解数据库高可用容灾过程中一些常见问题和解决方案。',38,'23',0),
	(45,'新一代公有云分布式数据库UCloud Exodus','公有云2.0时代，云数据库新产品不断涌现。诸如AWS Aurora、阿里云PolarDB等，也包括我们这次要分享的UCloud Exodus。作为国内排名前三的云数据库团队，我们一直在思考， 在利用最新软硬件和分布式技术改造传统数据库的工作中， 除了分布式数据库所要求的更大和更快之外，是否还有其他更重要的用户价值？在此次UCloud Exodus的议题中，将分享我们的思考，以及Exodus的设计和实现。',37,'23',0),
	(46,'UCloud分布式KV存储系统','分布式KV存储系统在互联网公司中扮演着重要的角色，各类上层业务对于KV存储系统的高可用性, 可扩展性和数据一致性都有着很高的要求。UCloud存储部门在迭代升级分布式redis架构的同时，也一直致力于研发基于硬盘存储的大容量分布式KV系统。本次分享将着重介绍UCloud在大容量分布式KV系统设计方面的经验，以及应对线上业务高性能，高容量要求的系统架构。',44,'23',0),
	(47,'实时流计算技术及其应用','流计算今年开始进入大家的大数据选择行列，Flink/Spark Streaming大受欢迎。实时流计算，边缘计算，物联网，NB-IoT、智慧城市等词语越来越为人所熟知。流计算在物联网行业、车联网、互联网、智慧城市等行业快速落地，创造越来越大的价值。本次活动围绕实时流计算，探讨行业迎场景，技术开发细节，产品技术方案等现实遇到的问题。',44,'23',0),
	(48,'金融行业落地案例专场：重点关注金融企业云计算 IT 架构如何转型；推进 Fintech 落地的实践经验与案例','以云计算、大数据为核心的数字化建设作为金融 IT 架构转型的一项重要任务，目前正被金融机构纳入工作重点。传统金融数据中心正在分步实施云计算技术，并转型为快速部署、弹性扩展、快速响应、可计量、自服务的私有云平台；伴随 Fintech 技术的发展，分布式计算，大数据，人工智能也逐步落地到金融生产环境，Fintech 应用场景也成大家的关注焦点。',44,'23',0),
	(49,'制造业落地案例专场：探讨基于 Kubernetes 的容器技术如何助力智能制造','随着工业互联网的发展，如何在海量的工业级数据以及复杂的业务场景中合理的调配资源已经成为企业竞争优势差异化的利器。容器技术，作为 PaaS 平台服务，对上层业务，可以解决多少问题，可以带来多高价值，对下层资源，如何更大规模架构，如何充分挖掘数据，不同企业选择不同路径，设计不同架构，青睐不同算法。',44,'23',0),
	(50,'新零售电商落地案例专场：分享碰撞企业容器技术落地案例与实践','互联网行业引领着世界科技的前沿和发展，以电商为典型代表的互联网行业，如网易、京东、当当网、锦江电商，使用 Kubernetes 容器调度技术承载了绝大部分的应用和服务。从容器技术中获益的电商企业是如何从传统 IT 架构平滑转换到容器微服务架构，在开发、测试、生产、运维过程中大规模使用容器技术，企业为何如此契而不舍，过程中又积淀了哪些经验？',44,'23',0),
	(51,'能源/教育业落地案例专场：深度挖掘蕴含在能源企业中的 Cloud+黑科技','作为发展之本的传统能源行业，如何借助人工智能，云计算实现“供给侧”改革；面对高风险，恶劣的作业环境，借助“黑科技” 为安全生产保驾护航；在传统 IT 架构环境的产业升级和转型中，带来更好的安全可控和云计算实践。',44,'23',0),
	(52,'API first framework for Python','介绍 Python 开源框架 falsy 的使用，包含 api first development 的理念以及 swagger 和 falcon 在实际过程中的应注意的问题。',44,'26',0),
	(53,'Redis的核心技术与应用实践','Redis在互联网公司得到了广泛的使用，更有很多业务直接将其作为内存数据库使用，这对Redis跨数据中心支持能力提出了强烈的需求，高并发的访问，对系统的性能和高可用提出了严峻的挑战。本次演讲将分享在围绕Redis核心技术的探索与实践，以及应用过程中真实踩过的坑和对应决方案。',44,'25',0);

/*!40000 ALTER TABLE `theme` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `email` varchar(60) NOT NULL DEFAULT '' COMMENT '邮箱',
  `nick_name` varchar(255) DEFAULT '' COMMENT '昵称',
  `telephone` varchar(15) DEFAULT NULL COMMENT '手机号',
  `password` varchar(60) NOT NULL DEFAULT '' COMMENT '密码',
  `role` varchar(45) DEFAULT NULL COMMENT '角色',
  `permission` varchar(45) DEFAULT NULL COMMENT '权限',
  `create_time` date DEFAULT NULL COMMENT '用户创建时间',
  `update_time` date DEFAULT NULL COMMENT '更新时间',
  `login_time` date DEFAULT NULL COMMENT '登录时间',
  `last_login_time` date DEFAULT NULL COMMENT '上一次登录时间',
  `del_flag` tinyint(1) DEFAULT '0' COMMENT '删除状态（默认0）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;

INSERT INTO `user` (`id`, `email`, `nick_name`, `telephone`, `password`, `role`, `permission`, `create_time`, `update_time`, `login_time`, `last_login_time`, `del_flag`)
VALUES
	(1,'yuhongliang900@163.com','ployer900','15221236247','000000',NULL,NULL,NULL,NULL,NULL,NULL,0),
	(2,'a@163.com','',NULL,'admin',NULL,NULL,NULL,NULL,NULL,NULL,0);

/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;