# sept2019-java-tours-SerialSeries
Project 2 - To watch/watched series tracker


Serial Series is a website with the purpose to optimise user experience.

The user can use it like a bookmark.

Each user insert every series he watched or want to watch.


# How to install
Install mysql:
`sudo apt-get install mysql`

## Setup mysql
Create the database:
`CREATE DATABASE serialSeries;`

Create a user on mysql:
`CREATE USER user_name@localhost IDENTIFIED BY user_password;`

Give the user all grants:
`GRANT ALL ON serialSeries.* TO user_name@localhost`

Use the dump:
`mysql -u user_name -p -D serialSeries < dump.sql`

Java version 8 or higher

Change the Database's file in the project (repository package) and insert your user_name and user_password

Now you can use the application
