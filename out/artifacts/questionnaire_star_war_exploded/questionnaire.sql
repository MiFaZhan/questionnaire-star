DROP DATABASE IF EXISTS questionnaire;
CREATE DATABASE IF NOT EXISTS questionnaire;

USE questionnaire;


/*用户表*/
DROP TABLE IF EXISTS `user`; 
CREATE TABLE IF NOT EXISTS `user`(
	user_id INT PRIMARY KEY AUTO_INCREMENT,
	user_nick VARChAR(20),
	user_login VARChAR(20),
	user_pass VARChAR(32)
);

INSERT INTO `user`(user_nick,user_login,user_pass) VALUES('张三','admin','A66ABB5684C45962D887564F08346E8D');
INSERT INTO `user`(user_nick,user_login,user_pass) VALUES('李四','lisi','1B539B60601B934441308049A9526E7D');
INSERT INTO `user`(user_nick,user_login,user_pass) VALUES('王五','wangwu','D36E3F7DE66577DF5BA7660F8CD113C6');

/*问卷类型表*/
DROP TABLE IF EXISTS questionnairetype;
CREATE TABLE IF NOT EXISTS questionnairetype(
	questionnairetype_id INT PRIMARY KEY AUTO_INCREMENT,
	questionnairetype_desc VARChAR(50)
);
INSERT INTO questionnairetype(questionnairetype_desc) VALUES('情感评测');
INSERT INTO questionnairetype(questionnairetype_desc) VALUES('性格测试');
INSERT INTO questionnairetype(questionnairetype_desc) VALUES('消费调查');
INSERT INTO questionnairetype(questionnairetype_desc) VALUES('就业调查');
/*问卷表*/
DROP TABLE IF EXISTS questionnaire;
CREATE TABLE IF NOT EXISTS questionnaire(
	questionnaire_id INT PRIMARY KEY AUTO_INCREMENT,
	questionnaire_title VARChAR(50),
	questionnairetype_id INT
);
INSERT INTO questionnaire(questionnaire_title, questionnairetype_id) VALUES('大学生网购调查问卷', 3);
INSERT INTO questionnaire(questionnaire_title, questionnairetype_id) VALUES('大学生恋爱问卷', 1);
INSERT INTO questionnaire(questionnaire_title, questionnairetype_id) VALUES('九宫格测试', 2);
INSERT INTO questionnaire(questionnaire_title, questionnairetype_id) VALUES('大学生就业调查', 4);

SELECT * FROM `user`;
SELECT questionnairetype_id,questionnairetype_desc FROM questionnairetype;
SELECT questionnaire_id,questionnaire_title,questionnairetype_id FROM questionnaire;

/*题目表*/
DROP TABLE IF EXISTS subject;
CREATE TABLE IF NOT EXISTS subject(
	subject_id INT PRIMARY KEY AUTO_INCREMENT,
	subject_title VARChAR(50),
	choice_one VARChAR(50),
	choice_two VARChAR(50),
	choice_three VARChAR(50),
	choice_four VARChAR(50),
	questionnaire_id INT
);
INSERT INTO subject(subject_title, choice_one, choice_two, choice_three, choice_four,questionnaire_id) VALUES('你所在的年级？','大一','大二','大三','大四',1);
INSERT INTO subject(subject_title, choice_one, choice_two, choice_three, choice_four,questionnaire_id) VALUES('你在网上主要购买哪些东西？','服饰鞋帽','饰品','电子产品','生活日用品',1);
INSERT INTO subject(subject_title, choice_one, choice_two, choice_three, choice_four,questionnaire_id) VALUES('你所在的年级？','大一','大二','大三','大四',2);
INSERT INTO subject(subject_title, choice_one, choice_two, choice_three, choice_four,questionnaire_id) VALUES('你现在的感情状况是？','正在恋爱','单身','刚失恋','有正在追求的对象',2);

SELECT subject_title,choice_one,choice_two,choice_three,choice_four,questionnaire_id FROM subject;

SELECT user_pass FROM user WHERE user_login = 'admin';