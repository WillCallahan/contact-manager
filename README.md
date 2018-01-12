# Contact Manager

Simple contact manager application.

## API Access

The API can be accessed at https://k1nu70dya2.execute-api.us-east-1.amazonaws.com/prod/persons

NOTE: Please allow time for the API to process; the Spring Framework adds a rather heavy load
to the architecture. If a request fails, please attempt to make the request again.

## Operations

- [GET /persons][persons] - Gets all instances of people in the database
- [GET /persons/count][persons] - Gets the count of all instances of people in the database
- [GET /persons/`{id}`][persons] - Gets a person by its `id`
- [POST /persons][persons] - Creates a new instance of a person
- [PUT /persons/`{id}`][persons] - Updates an existing person with a matching `id`
- [DELETE /persons/`{id}`][persons] - Deletes a persons with a matching `id`

### Sample Data

The following can be used as data to provide to the API

#### Headers

| Header | Value |
| :------: | :-----: |
| Content-Type | application/json |
| Accept | application/json |

#### Request Body

```json
{
	"id": null,
	"firstName": "Jane",
	"lastName": "Doe",
	"primaryEmail": "callahan043@connect.wcsu.edu",
	"secondaryEmailList": [
		"callahanwilliam@callahanwilliam.com"
	],
	"addressList": [
		{
			"street": "A Street",
			"city": "A Town Somewhere",
			"state": "Connecticut",
			"postalCode": "06812"
		}
	],
	"phoneList": [
		{
			"phoneNumber": "012-345-6789",
			"phoneType": 3
		}
	]
}
```

The following is an example of the output from the API

```json
[{"id":"441a72a8-e84b-492b-b4a6-2e90e59d70c9","firstName":"Jane","lastName":"Doe","primaryEmail":"callahan043@connect.wcsu.edu","secondaryEmailList":null,"addressList":null,"phoneList":[{"phoneNumber":"012-345-6789","phoneType":3}],"links":[]}]
```

## Building

To build the project, type `mvn package -Denv=production` into the CLI.

### Build Dependencies

Ensure that you have the following dependencies installed on your system before building the project.

- Maven

## Technologies

- AWS DynamoDB
- AWS API Gateway
- AWS Lambda
- SpringFramework
- Maven
- Java 8

[persons]: https://k1nu70dya2.execute-api.us-east-1.amazonaws.com/prod/persons
[persons-count]: https://k1nu70dya2.execute-api.us-east-1.amazonaws.com/prod/persons/count