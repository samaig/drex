# Drex (Java Reactive Spring boot API example app)

Drex is an example java reactive application for accessing and exposing apis. In this example, I'm using the New York Times Developer API
from [New York Times Developer API.](https://developer.nytimes.com/apis)

You can clone or fork this repository and modify it to your requirements.

## Setup & Installation
mysql db - (you can use any db of your choice)

#### If using another db
- amend the spring.datasource connection properties in the `application.yml` file with the correct values for your db

# Create Database
- create database with name: drex
```sql
CREATE DATABASE drex
```

- apply flyway SQL changes to database
```maven
mvn clean compile flyway:migrate
```

#### Using xampp
- download xampp and set up instructions: [here](https://www.apachefriends.org/index.html)

#### Using Docker
- Install docker from [here](https://www.docker.com/get-started/)
  Run commands below to pull the my-sql docker image, phpMyAdmin image and connect them together:
- Pull MySQL latest Image from docker hub:

```docker
docker pull mysql:latest
# For M1 mac run:
docker pull --platform linux/x86_64 mysql
```

- Run MySQL container:
```docker
docker run --name mysql-db -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=<insert password> mysql:latest
# For M1 mac run:
docker run --platform linux/x86_64 --name mysql-db -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=<insert password> mysql:latest
```

```
--name gives a name to the image, 
-d means docker will run the image in the background in detached mode
-p tells docker which port to run mysql on
-e is used to pass a value to the running container environment 
MYSQL_ROOT_PASSWORD is the container environment variable for the password
```

- You can use [DataGrip](https://www.jetbrains.com/datagrip/download/#section=mac) for managing the database.

- If you want to use PHPMyAdmin for managing the database, Pull PhpMyAdmin latest image from docker hub:

```docker
docker pull phpmyadmin/phpmyadmin:latest
```

- Connect with MySQL:
```docker
docker run --name loc-phpmyadmin -d --link mysql-db:db -p 8081:80 phpmyadmin/phpmyadmin
```

```
--link connects and gives access to another container. 
Here we are giving the admin access to the MySQL container.
```

## API provider
Using New York Times open api. [Link](https://developer.nytimes.com/apis)

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.