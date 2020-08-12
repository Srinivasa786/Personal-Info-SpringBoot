# Personal-Info-SpringBoot

Test the below servics using postman or Advanced rest client

person Service : POST http://localhost:8080/person-service/api/v1/person -- create person

{

"firstName": "Srinivasa", "lastName": "Duggempudi", "addresses": [ {

"addressID": 2, "street": "LB Nagar", "city": "Hyd", "state": "Telangana", "postalCode": "1111122" }, {

"addressID": 1, "street": "HayathNagar", "city": "Hyd", "state": "Telangana", "postalCode": "1111111" }]

}

PUT - http://localhost:8080/person-service/api/v1/person/100 -- Update Person

input:

{ "personID": 100, "firstName": "Srinivasa", "lastName": "Duggempudi" }

GET : http://localhost:8080/person-service/api/v1/person/100 -- Retrive person

GET - http://localhost:8080/person-service/api/v1/persons -- Retrive all the persons

Delete : http://localhost:8080/person-service/api/v1/person/100 -- delete Person

Address Service: GET - http://localhost:8080/person-service/api/v1/addresses -- Get All address.

GET - http://localhost:8080/person-service/api/v1/address/person/100 - GetAddressBypersonID

GET - http://localhost:8080/person-service/api/v1/address/person/100?addressid=1 - GetAddress by personid and addressid

PUT - http://localhost:8080/person-service/api/v1/address/1/person/100

{ "personID": 100, "addressID": 1, "street": "HayathNagar", "city": "Hyd", "state": "Telangana", "postalCode": "1111111" }

POST : http://localhost:8080/person-service/api/v1/address

{ "personID": 100, "addressID": 3, "street": "LB NAGAR", "city": "BANG", "state": "Telangana", "postalCode": "1111111" }

Delete - http://localhost:8080/person-service/api/v1/address/1/person/100

DB ;- http://localhost:8080/person-service/h2
