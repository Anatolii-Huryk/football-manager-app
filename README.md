# Football-manager-app
___
## Introduction
This is a simple football manager simulator where 
you can do various operations 
with both football clubs and footballers

___
## Project structure

The structure of this project consists of 3 levels:
* Data access layer (DAO).
* Application layer (service).
* Presentation layer (controllers).

___
## Technologies:
* H2
* Spring boot
* JPARepository
* Lombok
___

## Inject
- POST - add two football clubs of two players
___
## Football club

- POST - add football club.
- POST - add many football clubs.
- GET - get football club by id.
- GET - get all football clubs.
- PUT - transfer of a player from one club to another.
- DELETE - delete football club.

___

## Player

- POST - add player.
- POST - add many players.
- GET - get player by id.
- DELETE - delete player by id.

___

## Transfer

- POST - add transfer.
- POST - add many transfers.
- GET - get transfer by id.
- DELETE - delete transfer by id

___

## How to use application
1. H2 base is the default, but you can put any, just change the data in
   application.properties
2. If you want you can use postman or another application from which you can make HTTP requests.
3. You can use "/inject" and add standard football clubs and standard players.
4. Enjoy!

