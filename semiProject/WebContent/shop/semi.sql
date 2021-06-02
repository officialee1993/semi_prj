/*
 *   2021-06-01  ver 0.1
 * - Sales_stats 테이블 date 형식으로 변경
 * - Q_board(문의게시판) q_b_category(문의유형<상품문의,배송문의,기타문의>) 추가 //
 * */


/* Drop Tables */

DROP TABLE A_reply CASCADE CONSTRAINTS;
DROP TABLE A_board CASCADE CONSTRAINTS;
DROP TABLE O_list CASCADE CONSTRAINTS;
DROP TABLE Storages CASCADE CONSTRAINTS;
DROP TABLE Orders CASCADE CONSTRAINTS;
DROP TABLE Basket CASCADE CONSTRAINTS;
DROP TABLE P_img CASCADE CONSTRAINTS;
DROP TABLE Q_reply CASCADE CONSTRAINTS;
DROP TABLE Q_board CASCADE CONSTRAINTS;
DROP TABLE Product CASCADE CONSTRAINTS;
DROP TABLE Category CASCADE CONSTRAINTS;
DROP TABLE Members CASCADE CONSTRAINTS;
DROP TABLE Q_A CASCADE CONSTRAINTS;
DROP TABLE Sales_stats CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE A_board /*후기게시판*/
(
	a_b_num number(20) NOT NULL,
	a_b_name varchar2(20) NOT NULL,
	a_b_title varchar2(20) NOT NULL,
	a_b_content varchar2(500) NOT NULL,
	wr_id varchar2(20) NOT NULL,
	wr_date date NOT NULL,
	o_num number(20) NOT NULL,
	p_num number(20) NOT NULL,
	PRIMARY KEY (a_b_num)
);


CREATE TABLE A_reply  /*후기댓글*/
(
	a_r_no number(20) NOT NULL,
	wr_id varchar2(20) NOT NULL,
	a_r_content varchar2(500) NOT NULL,
	wr_date date NOT NULL,
	a_b_num number(20) NOT NULL,
	PRIMARY KEY (a_r_no)
);


CREATE TABLE Basket
(
	b_num number(20) NOT NULL,
	p_count number(20) NOT NULL,
	p_num number(20) NOT NULL,
	id varchar2(20) NOT NULL,
	PRIMARY KEY (b_num)
);


CREATE TABLE Category
(
	cg_id number(20) NOT NULL,
	cg_name varchar2(20) NOT NULL,
	p_id number(20) NOT NULL,
	PRIMARY KEY (cg_id)
);


CREATE TABLE Members
(
	id varchar2(20) NOT NULL,
	pwd varchar2(20) NOT NULL,
	name varchar2(20) NOT NULL,
	phone varchar2(20) NOT NULL,
	email varchar2(20) NOT NULL,
	address varchar2(20) NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE Orders
(
	o_num number(20) NOT NULL,
	rec_name varchar2(20) NOT NULL,
	rec_phone varchar2(20) NOT NULL,
	rec_addr varchar2(20) NOT NULL,
	all_sum_price number(20) NOT NULL,
	payname varchar2(20) NOT NULL,
	o_date date NOT NULL,
	o_state varchar2(20) NOT NULL,
	id varchar2(20) NOT NULL,
	p_num number(20) NOT NULL,
	b_num number(20) NOT NULL,
	PRIMARY KEY (o_num)
);


CREATE TABLE O_list
(
	o_count varchar2(20) NOT NULL,
	o_num number(20) NOT NULL,
	s_num number(20) NOT NULL
);


CREATE TABLE Product
(
	p_num number(20) NOT NULL,
	p_name varchar2(20) NOT NULL,
	p_count number(20) NOT NULL,
	p_price number(20) NOT NULL,
	p_click_num number(20) NOT NULL,
	p_date date NOT NULL,
	ori_img_name varchar2(180) NOT NULL,
	save_img_name varchar2(180) NOT NULL,
	cg_id number(20) NOT NULL,
	PRIMARY KEY (p_num)
);


CREATE TABLE P_img
(
	p_i_num number(20) NOT NULL,
	p_num number(20) NOT NULL
);


CREATE TABLE Q_A /*문의게시판 답변*/
(
	q_a_num number(20) NOT NULL,
	q_a_title varchar2(20) NOT NULL,
	q_a_content varchar2(20) NOT NULL,
	q_a_date date NOT NULL,
	PRIMARY KEY (q_a_num)
);


CREATE TABLE Q_board /*문의게시판*/
(
	q_b_num number(20) NOT NULL,
	id varchar2(20) NOT NULL,
	q_b_category varchar2(20) NOT NULL,
	q_b_title varchar2(20) NOT NULL,
	q_b_content varchar2(1000) NOT NULL,
	q_b__pwd varchar2(20) NOT NULL,
	wr_date date NOT NULL,
	q_b_state varchar2(20) NOT NULL,
	p_num number(20) NOT NULL,
	
	PRIMARY KEY (q_b_num)
);


CREATE TABLE Q_reply
(
	q_r_num number(20) NOT NULL,
	wr_id varchar2(20),
	q_r_content varchar2(1000),
	wr_date date,
	q_b_num number(20) NOT NULL,
	PRIMARY KEY (q_r_num)
);


CREATE TABLE Sales_stats
(
	all_Sales number(20) NOT NULL,
	p_price varchar2(20) NOT NULL,
	o_date date,
	p_count number(20) NOT NULL
);


CREATE TABLE Storages
(
	s_num number(20) NOT NULL,
	s_count number(20),
	p_size varchar2(20) NOT NULL,
	o_num number(20) NOT NULL,
	p_num number(20) NOT NULL,
	PRIMARY KEY (s_num)
);



/* Create Foreign Keys */

ALTER TABLE A_reply
	ADD FOREIGN KEY (a_b_num)
	REFERENCES A_board (a_b_num)
;


ALTER TABLE Orders
	ADD FOREIGN KEY (b_num)
	REFERENCES Basket (b_num)
;


ALTER TABLE Category
	ADD FOREIGN KEY (p_id)
	REFERENCES Category (cg_id)
;


ALTER TABLE Product
	ADD FOREIGN KEY (cg_id)
	REFERENCES Category (cg_id)
;


ALTER TABLE Basket
	ADD FOREIGN KEY (id)
	REFERENCES Members (id)
;


ALTER TABLE Orders
	ADD FOREIGN KEY (id)
	REFERENCES Members (id)
;


ALTER TABLE Q_board
	ADD FOREIGN KEY (id)
	REFERENCES Members (id)
;


ALTER TABLE A_board
	ADD FOREIGN KEY (o_num)
	REFERENCES Orders (o_num)
;


ALTER TABLE O_list
	ADD FOREIGN KEY (o_num)
	REFERENCES Orders (o_num)
;


ALTER TABLE Storages
	ADD FOREIGN KEY (o_num)
	REFERENCES Orders (o_num)
;


ALTER TABLE A_board
	ADD FOREIGN KEY (p_num)
	REFERENCES Product (p_num)
;


ALTER TABLE Basket
	ADD FOREIGN KEY (p_num)
	REFERENCES Product (p_num)
;


ALTER TABLE Orders
	ADD FOREIGN KEY (p_num)
	REFERENCES Product (p_num)
;


ALTER TABLE P_img
	ADD FOREIGN KEY (p_num)
	REFERENCES Product (p_num)
;


ALTER TABLE Q_board
	ADD FOREIGN KEY (p_num)
	REFERENCES Product (p_num)
;


ALTER TABLE Storages
	ADD FOREIGN KEY (p_num)
	REFERENCES Product (p_num)
;


ALTER TABLE Q_reply
	ADD FOREIGN KEY (q_b_num)
	REFERENCES Q_board (q_b_num)
;


ALTER TABLE O_list
	ADD FOREIGN KEY (s_num)
	REFERENCES Storages (s_num)
;



/* Comments */

COMMENT ON COLUMN Q_board.wr_date IS '
';