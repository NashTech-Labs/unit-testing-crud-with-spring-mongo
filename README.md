# _spring-mongo_  
It's a basic CRUD application understanding.
It consists of basics commands with which we can simply connect to mongo cluster.  

We need to keep following points in focus:  
## Points to focus
  1. We need application.yml to define connection
  2. We need an interface to access database into our code.(ex.- PersonRepositoryDao)

## Prerequisites
1. Must have docker installed(Otherwise install mongo and open the connection manually).
2. Postman
## Before Running on Local Machine
In order to set up the service locally.  
1. Make sure docker-compose is up and running in the project root directory
2. Open postman and hit on the services using the endpoints provided in code.
    * /person:- POST call(Use the body provided in model/Person)
    * /person:- GET call(Will list the values in database)
    * /person/{id}:- GET call(Will list specific value in that id.)
    * /person/update/{id}:- PUT call(Can change the value as of specific id)
    * /person/delete/{id}:- DELETE call(Will delete the values of specific id).