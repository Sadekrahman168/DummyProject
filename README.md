# Dummy Application

[![Apache License 2](https://img.shields.io/badge/license-ASF2-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0.txt)

## Table of Contents

- [Features](#installation)
- [Setup and Installation](#features)
- [API Documentation](#contributing)
- [FAQ](#faq)
- [License](#license)

## Features

This application Supports Following Features:
* Create, Read, Update, Delete City ( Entity )
* Accepts a number, N, and returns a JSON array with the first N Fibonacci numbers
* Basic Hello world REST end point to get a 'Hello world' message.
* Simulate Deadlock situation.
* REST endpoint that accepts a JSON object containing a paragraph of text and returns a JSON array of objects in order. Also has the flexibility to set ascending or descendng order. Default is asc.
* A REST endpoint that queries an external REST service.
* View thread dump.
* View Metrcis.
* View Application health.
* Content Negotiation : User can request for either json or xml response.
* A Complete UI to test all API

## Technology Stack

* Spring
* Spring Boot
* HSQL
* Swagger
* Junit, Mockito
* JaCoCo
* JDK 1.8+

## Setup and Installation.

### Clone

- Clone this repo to your local machine using :  

### Setup

#### Run the Application with Maven plugin

> Go to root folder, open terminal and run following command

```shell
$ mvn clean install
```

> After then start the Aplication

```shell
$ mvn spring-boot:run

```
#### Run the Application with IDE
Import the maven prjoject on your IDE

```shell
Right click : Run as Maven clean
Right click : Run as Maven install
Right click : Run as Spring Boot App

```
`If Everything goes well, Application will be running on port 8080` and applcation root context will be : <a href="http://localhost:8080/DummyApp/">App</a>

## API Documentation

> The best way to test the API is through the swagger UI, click the Link below :

<a href="http://localhost:8080/DummyApp/swagger-ui.html">Api Testing Page</a>

> When propmted for authetication provide
```shell
user name : root
password : password
```
### Testing REQ [ 1 ] : "Hello World" REST endpoint
```shell
- On the UI hover over and click  "REQ [ 1 ] Hello World API : Hello World Resource" and

- click on `GET` after then click on `Try it out!`

- Scroll Down to see the results.
```

You can also try it with CURL
```shell
curl -u root:password -X GET --header 'Accept: application/json' 'http://localhost:8080/DummyApp/hello/'
```
### Testing REQ [ 2 ] : Testing unique words and thier counts / frequencies.
```shell
- On the UI hover over and click  REQ [ 2 ] Frequency processing API and

- click on `POST`

- Here we have two parameters : 'sort' is defaulted to 'asc' . On the 'text' Text box supply your text

- after then click on `Try it out!`

- Scroll Down to see the results.
```

You can also try it with CURL

```shell
curl -u root:password -X POST --header 'Accept: application/json' -d 'Test' 'http://localhost:8080/DummyApp/count'
```

### Testing REQ [ 3 ] : Returns a JSON array with the first N Fibonacci numbers.
```shell
- On the UI hover over and click  REQ [ 3 ] Number Utility API and

- click on `POST`

- on the fiboNumber text Box supply your number and

- after then click on `Try it out!`

- Scroll Down to see the results.
```

You can also try it with CURL
```shell
curl -u root:password  -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' 'http://localhost:8080/DummyApp/number/fibonacci/3'
```

## Testing REQ [ 4 ] : Endpoint that creates two threads that become deadlocked with each other.
```shell
- On the UI hover over and click  REQ [ 4 ] Consumer Producer API  and

- after then click on `Try it out!`

- Scroll Down to see the results.
```

You can also try it with CURL

```shell
curl -u root:password -X GET --header 'Accept: application/json' 'http://localhost:8080/DummyApp/producerconsumer/'
```

## Testing REQ [ 5 ] : Endpoints that add, query, and delete rows in a database
```shell
- On the UI hover over and click  REQ [ 5 ] City API to perform CRUD operation  and
```

Here we have 5 different APIs

* `GET city/` : Get All the Cities

> Getting All the Cities :

```shell

Click on GET /city

after then click on `Try it out!`

Scroll Down to see the results.

```
You can also try it with CURL

```shell
curl -u root:password -X GET --header 'Accept: application/json' 'http://localhost:8080/DummyApp/city'
```

* `POST city/` : Create a New City.
> Ceate a City :

Click on `POST /city` , On city text Box supply your json as below

```shell
{
  "description": "My city",
  "name": "Foo bar",
  "totalPopulation": 1200
}
```
>  after then click on `Try it out!`, Scroll Down to see the results.

With CURL :

```shell

curl -u root:password -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{ \
   "description": "test", \
   "name": "test", \
   "totalPopulation": 1 \
 }'

```


* `PUT city/` : Update an existing city .

Click on `PUT /city` , On dto text Box supply your json as below

```shell
{
  "code":1,
  "description": "My city",
  "name": "Foo bar",
  "totalPopulation": 1200
}
```
>  after then click on `Try it out!`, Scroll Down to see the results.

With CURL :

```shell

curl -u root:password -X PUT --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{ \
   "code": 1, \
   "description": "test", \
   "name": "test", \
   "totalPopulation": 1 \
 }'

```

* `DELETE city/{id}` : Delete an existing city .
Click on `DELETE /city/{id}`, on the id text box supply city id
>  after then click on `Try it out!`, Scroll Down to see the results.
With CURL :

```shell

curl -u root:password -X DELETE --header 'Accept: application/json' 'http://localhost:8080/DummyApp/city/1'

```
* `GET city/{id}` : Get all cities by name.
Click on `GET /city/{name}`.  On name text Box supply your city name (e.g KC) to query
>  after then click on `Try it out!`, Scroll Down to see the results.

With CURL :

```shell

curl -u root:password -X GET --header 'Accept: application/json' 'http://localhost:8080/DummyApp/city/KC'

```


## Testing REQ [ 6 ] : queries an external REST service using Spring RestTemplate.
```shell
- On the UI hover over and click  REQ [ 6 ] External API  and
```
We have Three different APIs

`externaldata/` : Get All the POST

`externaldata/post/{id}` : Get a POST using ID

`externaldata/post/{userid}` : Get All posts for an individual userid.

To test any of the API mentioned above :
```shell
- Clik on it ( e.g `/externaldata/` )

- after then click on `Try it out!`

- Scroll Down to see the results.
```
`You can also try it with CURL`

```shell
curl -u root:password -X GET --header 'Accept: application/json' 'http://localhost:8080/DummyApp/externaldata/'
```


## Contributing

> Sadek Rahman

## FAQ

- **Where do find the code coverage Reort**
    - /target/jacoco-ut/index.html

- **Can't run server on the port specified**
    - Change `server.port = {new port}` located in src/main/resources/application.properties. Or provide a JVM option when you run the server from command line.    

- **How do I make a REST call to get Response in XML format?**
    - make your call as follow :
    ```shell
    curl -u root:password -X GET --header 'Accept: application/xml' 'http://localhost:8081/DummyApp/hello/'
    ```



---

## Support

Reach out to me at one of the following places!

## License

[![License](http://img.shields.io/:license-mit-blue.svg?style=flat-square)](http://badges.mit-license.org)

- **[MIT license](http://opensource.org/licenses/mit-license.php)**
- Copyright 2015 © 
