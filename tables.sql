drop table if exists USERS;
drop table if exists PERSONS;

CREATE TABLE USERS(
	USER_ID      INT NOT NULL AUTO_INCREMENT,
	USER_NAME    VARCHAR(30) NOT NULL,
	FIRST_NAME   VARCHAR(30) NOT NULL,
	LAST_NAME    VARCHAR(30) NOT NULL,
	EMAIL        VARCHAR(30) NULL,
	CREATE_USERID    INT,
	CREATE_TIMESTAMP TIMESTAMP NULL DEFAULT '0000-00-00 00:00:00',
	UPDATE_USERID    INT,
	UPDATE_TIMESTAMP TIMESTAMP NULL DEFAULT '0000-00-00 00:00:00',
	PRIMARY KEY(USER_ID)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;


CREATE TABLE PERSONS (
  PERSON_ID   INT NOT NULL AUTO_INCREMENT,
  FIRST_NAME  VARCHAR(30) NOT NULL,
  LAST_NAME   VARCHAR(30) NOT NULL,
  PRIMARY KEY(PERSON_ID)  
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;   

------------------------------------------------------------------------------------------------------
drop table if exists CUSTOMERS;
drop table if exists ORDERS;

CREATE TABLE CUSTOMERS(
	CUSTOMER_ID      INT NOT NULL AUTO_INCREMENT,
	NAME             VARCHAR(30) NOT NULL,
	ADDRESS          VARCHAR(30) NULL,
	PHONE_NUMBER     VARCHAR(30) NULL,
	EMAIL            VARCHAR(30) NULL,
	COUNTRY          VARCHAR(30) NULL,
	CITY             VARCHAR(30) NULL,	
	CREATE_USERID    INT,
	CREATE_TIMESTAMP TIMESTAMP NULL DEFAULT '0000-00-00 00:00:00',
	UPDATE_USERID    INT,
	UPDATE_TIMESTAMP TIMESTAMP NULL DEFAULT '0000-00-00 00:00:00',
	PRIMARY KEY(CUSTOMER_ID)	
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;

CREATE TABLE ORDERS(
	ORDER_ID         INT NOT NULL AUTO_INCREMENT,
	ORDER_DATE	     TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00',
	DELIVERY_DATE    TIMESTAMP NULL DEFAULT NULL,
	PAYMENT_METHOD   VARCHAR(10) NOT NULL DEFAULT 'CASH',
	STATUS           VARCHAR(10) NOT NULL DEFAULT 'PAID',
	DISCOUNT         NUMERIC NULL DEFAULT 0,
	ORDER_TOTAL      NUMERIC NULL DEFAULT 0,
	CUSTOMER_ID      INT NULL,
	CREATE_USERID    INT,
	CREATE_TIMESTAMP TIMESTAMP NULL DEFAULT '0000-00-00 00:00:00',
	UPDATE_USERID    INT,
	UPDATE_TIMESTAMP TIMESTAMP NULL DEFAULT '0000-00-00 00:00:00',
	PRIMARY KEY(ORDER_ID),
	INDEX FK_CUSTOMER (CUSTOMER_ID),
	CONSTRAINT FK_DEPT FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMERS (CUSTOMER_ID)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;	


SELECT * FROM CUSTOMERS LEFT JOIN ORDERS ON (CUSTOMERS.CUSTOMER_ID = ORDERS.CUSTOMER_ID);