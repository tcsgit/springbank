-- This CLP file was created using DB2LOOK Version 8.2

-- Timestamp: 10/2/2009 4:47:56 PM

-- Database Name: BANK           

-- Database Manager Version: DB2/NT Version 8.2.9          

-- Database Codepage: 1252

-- Database Collating Sequence is: UNIQUE





CONNECT TO BANK;



------------------------------------------------

-- DDL Statements for table "IS95592 "."OPERATOR"

------------------------------------------------

 

 CREATE TABLE "IS95592 "."OPERATOR"  (

		  "OPERATOR_ID" BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (  

		    START WITH +1  

		    INCREMENT BY +1  

		    MINVALUE +1  

		    MAXVALUE +9223372036854775807  

		    NO CYCLE  

		    NO CACHE  

		    NO ORDER ) , 

		  "OPERATOR_ALIAS" VARCHAR(25) NOT NULL , 

		  "OPERATOR_PASSWORD" VARCHAR(25) NOT NULL , 

		  "OPERATOR_FULLNAME" VARCHAR(25) NOT NULL )   

		 IN "USERSPACE1" ; 



-- DDL Statements for primary key on Table "IS95592 "."OPERATOR"



ALTER TABLE "IS95592 "."OPERATOR" 

	ADD CONSTRAINT "CC1245934485921" PRIMARY KEY

		("OPERATOR_ID");







------------------------------------------------

-- DDL Statements for table "IS95592 "."ACCOUNT"

------------------------------------------------

 

 CREATE TABLE "IS95592 "."ACCOUNT"  (

		  "ACCOUNT_ID" BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (  

		    START WITH +1  

		    INCREMENT BY +1  

		    MINVALUE +1  

		    MAXVALUE +9223372036854775807  

		    NO CYCLE  

		    NO CACHE  

		    NO ORDER ) , 

		  "ACCOUNT_NUMBER" VARCHAR(25) NOT NULL , 

		  "ACCOUNT_BALANCE" DOUBLE NOT NULL , 

		  "CUSTOMER_ID" BIGINT NOT NULL )   

		 IN "USERSPACE1" ; 



-- DDL Statements for primary key on Table "IS95592 "."ACCOUNT"



ALTER TABLE "IS95592 "."ACCOUNT" 

	ADD CONSTRAINT "CC1245935420643" PRIMARY KEY

		("ACCOUNT_ID");







------------------------------------------------

-- DDL Statements for table "IS95592 "."CUSTOMER"

------------------------------------------------

 

 CREATE TABLE "IS95592 "."CUSTOMER"  (

		  "CUSTOMER_ID" BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (  

		    START WITH +1  

		    INCREMENT BY +1  

		    MINVALUE +1  

		    MAXVALUE +9223372036854775807  

		    NO CYCLE  

		    NO CACHE  

		    NO ORDER ) , 

		  "CUSTOMER_NUMBER" VARCHAR(25) NOT NULL , 

		  "CUSTOMER_PASSWORD" VARCHAR(25) NOT NULL , 

		  "CUSTOMER_NAME" VARCHAR(25) NOT NULL , 

		  "CUSTOMER_SURNAME" VARCHAR(25) NOT NULL , 

		  "CUSTOMER_ADDRESS" VARCHAR(50) NOT NULL )   

		 IN "USERSPACE1" ; 



-- DDL Statements for primary key on Table "IS95592 "."CUSTOMER"



ALTER TABLE "IS95592 "."CUSTOMER" 

	ADD CONSTRAINT "CC1246523217774" PRIMARY KEY

		("CUSTOMER_ID");

















-- DDL Statements for foreign keys on Table "IS95592 "."ACCOUNT"



ALTER TABLE "IS95592 "."ACCOUNT" 

	ADD CONSTRAINT "CC1246523711592" FOREIGN KEY

		("CUSTOMER_ID")

	REFERENCES "IS95592 "."CUSTOMER"

		("CUSTOMER_ID")

	ON DELETE NO ACTION

	ON UPDATE NO ACTION

	ENFORCED

	ENABLE QUERY OPTIMIZATION;





COMMIT WORK;



CONNECT RESET;



TERMINATE;

-- Specified SCHEMA is: IS95592

-- The db2look utility will consider only the specified tables 

-- Creating DDL for table(s)



-- Schema name is ignored for the Federated Section

;