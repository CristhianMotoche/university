# Sails commands
## Start a new application
The following command help us to create a **new sails** project.

```shell
$ sails new [application-name]
```

All the folders and files will be generated inside a folder with the [application-name].

For more commands, take a look at the following [link](<`2:#:http://sailsjs.com/documentation/reference/command-line-interface`> "CLI")<`4`>

## Start up
Go to your folder named [application-name]:

```
$ sails l
```

# Docker
## Start the Database DBMS
Start the docker container with the database:

```shell
$ docker run -d --name lambda -d -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=base -e MYSQL_USER=usuario -e MYSQL_PASSWORD=123456 mysql:latest
```

## Check docker containers running
```shell
$ docker ps -a
```

## Stop docker container
```shell
$ docker stop ([docker-container-id]|[docker-container-name])
```

Remove the container:
**NOTE:** You can only remove containers if you stop them.
```shell
$ docker stop ([docker-container-id]|[docker-container-name])
```

## Start the PostgreSQL DBMS
To use a database for PostgreSQL we'll use the following command:

```shell
$ docker run -d --name lambda -d -e POSTGRES_PASSWORD=123456 -e POSTGRES_USER=usuario -e POSTGRES_DB=base -p 5432:5423 -d postgres:latest
```
Environmental variables:
### POSTGRES_DB
This optional environment variable can be used to define a different name for the
default database that is created when the image is first started. If it is not specified,
then the value of POSTGRES_USER will be used.

### POSTGRES_USER
This optional environment variable is used in conjunction with POSTGRES_PASSWORD
to set a user and its password. This variable will create the specified user
with superuser power and a database with the same name. If it is not specified,
then the default user of postgres will be used.

### POSTGRES_PASSWORD
This environment variable is recommended for you to use the PostgreSQL image.
This environment variable sets the superuser password for PostgreSQL.
The default superuser is defined by the POSTGRES_USER environment variable.
In the above example, it is being set to "mysecretpassword".


## Start the MongoDB NoSQL Database
To start the container with the MongoDB instance. Run the following command:

```shell
$ docker run --name gamma -p 27017:27017 mongodb:latest
```

# NPM
## Install packages
To add packages:
```shell
$ npm install [package]
```
