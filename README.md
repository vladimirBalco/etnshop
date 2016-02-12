# Installation
Prerequisites:

1. mysql
2. gradle
3. java
 
Basic Steps:

1. Create database in your Mysql server. 
2. Create table from the file etnshop.sql. 
3. Create folder C:/Users/indexes and make sure that user has all privileges (write, read etc)
4. Go to file application.properties and change the name of the database, username and password according to settings in your mysql server and verify that hibernate.search.default.indexBase = C:/Users/indexes (folder created in step 3)
5. From command line go to path where is your etnshop unpacked
6. Write 'gradle jettyRun' in command line and hit enter

First start:

1. Go to your browser and write http://localhost:8080/etnshop/admin
2. Click on button with caption 'Do fulltext indexing'. Products which are already in your database will be indexed for fulltext search. This is not needed when products are created within the etnshop application

Ordinary start:

1. Go to your browser and write http://localhost:8080/etnshop/


