# Contact Manager

Simple contact manager application.

## API Access

The API can be accessed at https://k1nu70dya2.execute-api.us-east-1.amazonaws.com/prod/persons

### Operations

- [GET /persons][/persons] - Gets all instances of people in the database
- [GET /persons/`{id}`][/persons] - Gets a person by its `id`
- [POST /persons][/persons] - Creates a new instance of a person
- [PUT /persons-put/`{id}`][/persons] - Updates an existing person with a matching `id`
- [DELETE /persons-delete/`id`][/persons] - Deletes a persons with a matching `id`

### Sample Data

The following can be used as data to provide to the API

```json
{
  "id": null,
  "firstName": "Jane",
  "lastName": "Doe",
  "primaryEmail": "callahan043@connect.wcsu.edu",
  "secondaryEmail": "callahanwilliam@callahanwilliam.com",
  "address": {
    "street": "A Street",
    "city": "A Town Somewhere",
    "state": "Connecticut",
    "postalCode": "06812"
  },
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
[{"id":"1c3c6ad0-4a04-4477-92f1-7bbbe9ac5fc7","firstName":"william","lastName":"callahan","primaryEmail":"callahan043@connect.wcsu.edu","secondaryEmail":"callahanwilliam@callahanwilliam.com","address":{"street":"A Street","city":"A Town Somewhere","state":"Connecticut","postalCode":"06812"},"phoneList":[{"phoneNumber":"012-345-6789","phoneType":3}],"links":[]},{"id":"b9d5d29e-a4d1-4d3e-af05-ab9a915cd8b4","firstName":"Jane","lastName":"Doe","primaryEmail":"callahan043@connect.wcsu.edu","secondaryEmail":"callahanwilliam@callahanwilliam.com","address":{"street":"A Street","city":"A Town Somewhere","state":"Connecticut","postalCode":"06812"},"phoneList":[{"phoneNumber":"012-345-6789","phoneType":3}],"links":[]},{"id":"8bb4f2ee-0d5d-4afa-848d-2f6937f76bc2","firstName":"Jane","lastName":"Doe","primaryEmail":"callahan043@connect.wcsu.edu","secondaryEmail":"callahanwilliam@callahanwilliam.com","address":{"street":"A Street","city":"A Town Somewhere","state":"Connecticut","postalCode":"06812"},"phoneList":null,"links":[]},{"id":"de559553-a728-451e-bf10-a289ce33e553","firstName":"Jane","lastName":"Doe","primaryEmail":"callahan043@connect.wcsu.edu","secondaryEmail":"callahanwilliam@callahanwilliam.com","address":{"street":"A Street","city":"A Town Somewhere","state":"Connecticut","postalCode":"06812"},"phoneList":[{"phoneNumber":"012-345-6789","phoneType":3}],"links":[]},{"id":"e2d1f74b-c74e-4807-9c9c-c03ff3b312f5","firstName":"william","lastName":"callahan","primaryEmail":"callahan043@connect.wcsu.edu","secondaryEmail":"callahanwilliam@callahanwilliam.com","address":{"street":"A Street","city":"A Town Somewhere","state":"Connecticut","postalCode":"06812"},"phoneList":[{"phoneNumber":"012-345-6789","phoneType":3}],"links":[]},{"id":"9033906c-8bb4-4982-b203-4b83d7619567","firstName":"Jane","lastName":"Doe","primaryEmail":"callahan043@connect.wcsu.edu","secondaryEmail":"callahanwilliam@callahanwilliam.com","address":{"street":"A Street","city":"A Town Somewhere","state":"Connecticut","postalCode":"06812"},"phoneList":[{"phoneNumber":"012-345-6789","phoneType":3}],"links":[]},{"id":"7a688326-707b-4049-9550-8d30b695b762","firstName":"Jane","lastName":"Doe","primaryEmail":"callahan043@connect.wcsu.edu","secondaryEmail":"callahanwilliam@callahanwilliam.com","address":{"street":"A Street","city":"A Town Somewhere","state":"Connecticut","postalCode":"06812"},"phoneList":[{"phoneNumber":"012-345-6789","phoneType":3}],"links":[]},{"id":"ff765f85-1e70-4967-8105-5f38839c6bc1","firstName":"Jane","lastName":"Doe","primaryEmail":"callahan043@connect.wcsu.edu","secondaryEmail":"callahanwilliam@callahanwilliam.com","address":{"street":"A Street","city":"A Town Somewhere","state":"Connecticut","postalCode":"06812"},"phoneList":[{"phoneNumber":"012-345-6789","phoneType":3}],"links":[]},{"id":"fca1a8af-65dc-484c-98e9-76bdc6f02971","firstName":"Jane","lastName":"Doe","primaryEmail":"callahan043@connect.wcsu.edu","secondaryEmail":"callahanwilliam@callahanwilliam.com","address":{"street":"A Street","city":"A Town Somewhere","state":"Connecticut","postalCode":"06812"},"phoneList":[{"phoneNumber":"012-345-6789","phoneType":3}],"links":[]},{"id":"ab4dee38-6e2f-49b0-8ae4-8c652345505f","firstName":"william","lastName":"callahan","primaryEmail":"callahan043@connect.wcsu.edu","secondaryEmail":"callahanwilliam@callahanwilliam.com","address":{"street":"A Street","city":"A Town Somewhere","state":"Connecticut","postalCode":"06812"},"phoneList":[{"phoneNumber":"012-345-6789","phoneType":3}],"links":[]},{"id":"1051d000-b09a-4a03-9e54-8718af3682b6","firstName":"william","lastName":"callahan","primaryEmail":"callahan043@connect.wcsu.edu","secondaryEmail":"callahanwilliam@callahanwilliam.com","address":{"street":"A Street","city":"A Town Somewhere","state":"Connecticut","postalCode":"06812"},"phoneList":[{"phoneNumber":"012-345-6789","phoneType":3}],"links":[]},{"id":"683c4a17-6ed4-4c00-947b-311fa8bca4b0","firstName":"Jane","lastName":"Doe","primaryEmail":"callahan043@connect.wcsu.edu","secondaryEmail":"callahanwilliam@callahanwilliam.com","address":{"street":"A Street","city":"A Town Somewhere","state":"Connecticut","postalCode":"06812"},"phoneList":[{"phoneNumber":"012-345-6789","phoneType":3}],"links":[]},{"id":"6fb239c6-1ea7-4247-9b00-faf5e71a23fa","firstName":"Jane","lastName":"Doe","primaryEmail":"callahan043@connect.wcsu.edu","secondaryEmail":"callahanwilliam@callahanwilliam.com","address":{"street":"A Street","city":"A Town Somewhere","state":"Connecticut","postalCode":"06812"},"phoneList":[{"phoneNumber":"012-345-6789","phoneType":3}],"links":[]},{"id":"f6e237cb-9227-4266-9363-e36244c6d183","firstName":"william","lastName":"callahan","primaryEmail":"callahan043@connect.wcsu.edu","secondaryEmail":"callahanwilliam@callahanwilliam.com","address":{"street":"A Street","city":"A Town Somewhere","state":"Connecticut","postalCode":"06812"},"phoneList":[{"phoneNumber":"012-345-6789","phoneType":3}],"links":[]},{"id":"46ed3b4e-db96-420b-891f-afde729cea4b","firstName":"Jane","lastName":"Doe","primaryEmail":"callahan043@connect.wcsu.edu","secondaryEmail":"callahanwilliam@callahanwilliam.com","address":{"street":"A Street","city":"A Town Somewhere","state":"Connecticut","postalCode":"06812"},"phoneList":[{"phoneNumber":"012-345-6789","phoneType":3}],"links":[]},{"id":"9e0cb673-0130-4ecb-bfaf-b053ec0564a4","firstName":"william","lastName":"callahan","primaryEmail":"callahan043@connect.wcsu.edu","secondaryEmail":"callahanwilliam@callahanwilliam.com","address":{"street":"A Street","city":"A Town Somewhere","state":"Connecticut","postalCode":"06812"},"phoneList":[{"phoneNumber":"012-345-6789","phoneType":3}],"links":[]},{"id":"5f273d81-b200-4a2a-aa1f-ada088ac5689","firstName":"Jane","lastName":"Doe","primaryEmail":"callahan043@connect.wcsu.edu","secondaryEmail":"callahanwilliam@callahanwilliam.com","address":{"street":"A Street","city":"A Town Somewhere","state":"Connecticut","postalCode":"06812"},"phoneList":[{"phoneNumber":"012-345-6789","phoneType":3}],"links":[]},{"id":"927b0fd4-d73f-4ba8-80ef-5ff53d8e8426","firstName":"Jane","lastName":"Doe","primaryEmail":"callahan043@connect.wcsu.edu","secondaryEmail":"callahanwilliam@callahanwilliam.com","address":{"street":"A Street","city":"A Town Somewhere","state":"Connecticut","postalCode":"06812"},"phoneList":[{"phoneNumber":"012-345-6789","phoneType":3}],"links":[]}]
```

## Technologies

- AWS DynamoDB
- AWS API Gateway
- AWS Lambda
- SpringFramework
- Maven
- Java 8

[/persons](https://k1nu70dya2.execute-api.us-east-1.amazonaws.com/prod/persons)