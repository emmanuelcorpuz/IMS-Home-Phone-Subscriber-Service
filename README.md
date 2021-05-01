# IMS-Home-Phone-Subscriber-Service

Functionalities:
- GET:         /ims/subscriber/{phoneNumber}
Retrieve the subscriber identified by the provided phone number
- PUT:          /ims/subscriber/{phoneNumber}
Add or update a subscriber identified by the provided phone number.
- DELETE:       /ims/subscriber/{phoneNumber}
Remove the subscriber identified by the phone number.

Database (MySQL):
- you can run the telme.sql in \IMS-Home-Phone-Subscriber-Service\ims\src\main\resources directory for the creation of the database and tables, as well as the test data/records.

Testing:
- i used Postman app for the testing of the webservice apis (https://web.postman.co/workspace/My-Workspace~3f617f40-75bd-4881-8214-3844d42f804b/request/15617058-87b3cc61-5dd9-4e0e-8395-5598406efdbc). you can also used curl or any of your favorite REST testing tool.
