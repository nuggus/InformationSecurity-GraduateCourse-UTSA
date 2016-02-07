NOTE: you need to install mySQL DB in server machine and create a database by name nuggu and then create table "mybooks" with below schema:
configure database name in mysql as "nuggu" and password as "abc@123"
Database name: nuggu
Table name: mybooks
+----------+--------------+------+
| Field         | Type         	| 
+----------+--------------+------+
| bookid        | varchar(10)   | 
| bookname      | varchar(100)  | 
| author        | varchar(100)  | 
| price         | float         | 
| category      | varchar(100)  | 
| copies        | int(11)       |  
+----------+--------------+------+


then insert values into above table for bookIds: isbn-118,isbn-86,isbn-666,isbn-996

To compile and run mybooks.com follow below steps:

STEP 1: compile all java files by using javac(java compiler).
javac BookClient.java BookServer.java BookServerImpl.java BookServerInterface.java BookServiceAttribute.java ConnectionEstablishment.java RetrieveRow.java

STEP2: stub generation using rmic command as
              rmic BookServerImpl

STEP 3: start rmiregistry 

STEP 4:start server

java -cp mysql-connector-java-5.1.31-bin.jar;.BookServer <<ipaddress/localhost>>

STEP 5: open a new command prompt and run client program by giving ipaddress of server if server is on different machine or give localhost if server is on same machine.

java BookClient <<ipaddress/localhost>>

STEP 5: select appropriate options and navigate.

NOTE:
1)if you get port already in use make sure port number used in code is free from use.
2)make sure etc/hosts file is configured correctly with actual machine address instead of default values.
