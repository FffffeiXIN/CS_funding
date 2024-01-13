

## CS Funding System - Developer Guide

:wave: Hello World!

**CS Funding System** is a web application for :man_judge:**administrators**, :man_teacher:**professors**, and :man_office_worker:**secretaries** of the :computer:[Department of Computer Science and Engineering](https://cse.sustech.edu.cn/) in the :school:[Southern University of Science and Technology](https://www.sustech.edu.cn/) to manage the :moneybag:<u>funds</u> and :dollar:<u>reimbursements</u>.

Developers of CS Funding System: 

:man:[Yuwei Xiao](https://github.com/Xavier-Shaw), :woman:[Zhe Ding](https://github.com/DingZ0115), :woman:[Shimin Luo](https://github.com/FffffeiXIN), :man:[Sirui Lee](https://github.com/Siri-Lee), :man:[Dazhi FENG](https://github.com/dazhi0619)

---

This documentation provides essential information and guidelines for developers working on the CS Funding System, it aims to assist developers in understanding the CS Funding System's technical aspects, enabling them to efficiently contribute to its development, maintenance, and enhancement. It also serves as a comprehensive reference guide to facilitate smooth collaboration and ensure the stability and scalability of the system.

### Contents

This Developer Guide includes: 

* **Entities**

  * [User Entity](#UserEntity)
  * [Research Group Entity](#GroupEntity)
  * [Notification Entity](#NotificationEntity)
  * [Fund Entity](#FundEntity)
  * [Expense Category Entity](#ExpenseCategoryEntity)
  * [Application Entity](#ApplicationEntity)
  * [MultiUsedTable Entity](#MultiUsedTableEntity)
  * [ExpenditureSummaryUser Entity](#ExpenditureUserEntity)
  * [ExpenditureSummary Entity](#ExpenditureEntity)
  * [AuthorizedFundingDetail Entity](#AuthorizedFundingEntity)
  * [ApplicationbWithApplicant Entity](#ApplicationWithApplicantEntity)

* **Methods**

  * [Application Controller](#Application)

  * [Expense Category Controller](#Expense)

  * [Funding Controller](#Funding)

  * [Manager Controller](#Manager)

  * [Notification Controller](#Notification)

  * [Research Group Controller](#Group)

  * [User Controller](#User)

---

### <span id="UserEntity">User Entity</span>

This file contains the User class, which represents a user in the CS Funding system. 

The `User` class has the following fields:

- `sid` (Integer): the user's unique identifier
- `name` (String): the user's name
- `role` (String): the user's role in the system
- `password` (String): the user's password
- `status` (String): the user's status
- `online` (Boolean): whether the user is currently online
- `email` (String): the user's email address
- `department` (String): the user's department
- `avatar` (String): the base64 data of the user's avatar image

---

### <span id="GroupEntity">Research Group Entity</span>

This file contains the `ResearchGroup` class, which represents a research group in the CS Funding system.

The `ResearchGroup` class has the following field:

- `name` (String): the name of the research group.

---

### <span id="NotificationEntity">Notification Entity</span>

This file contains the `Notification` class, which represents a notification in the CS Funding system.

The `Notification` class has the following fields:

- `id` (Integer): the unique identifier of the notification
- `user_id` (Integer): the user identifier associated with the notification
- `messages` (String): the content of the notification message
- `date` (String): the date when the notification was created.

---

### <span id="FundEntity">Fund Entity</span>

This file contains the `Fund` class, which represents a fund in the CS Funding system.

The `Fund` class has the following fields:

- `name` (String): the name of the fund
- `code` (String): the code associated with the fund
- `due_date` (Date): the due date of the fund
- `execution_rate` (String): the execution rate of the fund
- `total_available` (Double): the total amount of fund available
- `total_used` (Double): the total amount of fund used

---

### <span id="ExpenseCategoryEntity">Expense Category Entity</span>

This file contains the `ExpenseCategory` class, which represents an expense category in the CS Funding system.

The `ExpenseCategory` class has the following fields:

- `first` (String): the first level category of the expense
- `second` (String): the second level category of the expense

---

### <span id="ApplicationEntity">Application Entity</span>

This file contains the `Application` class, which represents an application in the CS Funding system.

The `Application` class has the following fields:

- `fund_name` (String): the name of the fund associated with the application
- `applicant_id` (Integer): the unique identifier of the applicant
- `group_name` (String): the name of the research group associated with the application
- `expense` (Double): the expense amount requested in the application
- `expense_category` (Integer): the category of the expense
- `abstracts` (String): the abstracts or summary of the application
- `result` (String): the result or outcome of the application
- `remarks` (String): additional remarks or notes related to the application
- `comment` (String): comments provided by reviewers or administrators
- `id` (Integer): the unique identifier of the application

---

### <span id="MultiUsedTableEntity">MultiUsedTable Entity</span>

This file contains the `_MultiUsedTable` class, which represents a multi-used table in the CS Funding system.

The `_MultiUsedTable` class has the following fields:

- `code` (String): the code associated with the table
- `fund_name` (String): the name of the fund associated with the table
- `due_date` (String): the due date of the table
- `total_sum` (Double): the total sum value
- `used_sum` (Double): the sum value that has been used
- `left_sum` (Double): the remaining sum value
- `current_execution_rate` (String): the current execution rate
- `qualified_rate` (String): the qualified rate value
- `qualified` (String): the qualification status
- `days_left` (String): the number of days left

---

### <span id="ExpenditureUserEntity">ExpenditureSummaryUser Entity</span>

This file contains the `_ExpenditureSummaryUser` class, which represents an expenditure summary for a user in the CS Funding system.

The `_ExpenditureSummaryUser` class has the following fields:

- `code` (String): the code associated with the summary
- `fund_name` (String): the name of the fund associated with the summary
- `due_date` (String): the due date of the summary
- `total_sum` (Double): the total sum value
- `used_sum` (Double): the sum value that has been used
- `left_sum` (Double): the remaining sum value
- `current_execution_rate` (String): the current execution rate
- `qualified` (String): the qualification status
- `days_left` (String): the number of days left

---

### <span id="ExpenditureEntity">ExpenditureSummary Entity</span>

This file contains the `_ExpenditureSummary` class, which represents an expenditure summary in the CS Funding system.

The `_ExpenditureSummary` class has the following fields:

- `code` (String): the code associated with the summary
- `fund_name` (String): the name of the fund associated with the summary
- `group_name` (String): the name of the research group associated with the summary
- `used` (Double): the amount of funds used
- `total` (Double): the total amount of funds allocated
- `usable_left` (Double): the remaining amount of funds that can be used
- `current_execution_rate` (String): the current execution rate
- `qualified` (String): the qualification status

---

### <span id="AuthorizedFundingEntity">AuthorizedFundingDetail Entity</span>

This file contains the `_AuthorizedFundingDetail` class, which represents authorized funding details in the CS Funding system.

The `_AuthorizedFundingDetail` class has the following fields:

- `code` (String): the code associated with the authorized funding detail
- `fund_name` (String): the name of the fund associated with the authorized funding detail
- `group_name` (String): the name of the research group associated with the authorized funding detail
- `total_sum` (Double): the total sum value
- `used_sum` (Double): the sum value that has been used
- `first_category` (String): the first level category associated with the authorized funding detail
- `second_category` (String): the second level category associated with the authorized funding detail

---

### <span id="ApplicationWithApplicantEntity">ApplicationWithApplicant Entity</span>

This file contains the `_ApplicationWithApplicant` class, which represents an application with its associated applicant details in the CS Funding system.

The `_ApplicationWithApplicant` class has the following fields:

- `application` (`Application`): an instance of the `Application` class representing the application details
- `applicant` (`User`): an instance of the `User` class representing the applicant details
- `expenseCategory` (`ExpenseCategory`): an instance of the `ExpenseCategory` class representing the expense category associated with the application

---

### <span id="Application">Application Controller</span>

This section contains the implementation of the `ApplicationController` class, which is responsible for handling HTTP requests related to funding applications.

The following endpoints are implemented in this class:

#### Apply for Funding
**API:** `POST /apply/applyFunding`

This endpoint is used to submit a funding application. It expects the following parameters:

- `id` (integer): the ID of the application (optional)
- `fundName` (string): the name of the funding opportunity
- `applicant` (string): the name of the applicant
- `group` (string): the name of the applicant's group
- `money` (double): the amount of funding requested
- `first_category` (string): the first category of the application
- `second_category` (string): the second category of the application
- `abstracts` (string): a brief summary of the application
- `remarks` (string): any additional remarks about the application
- `status` (string): the status of the application (optional)

It returns a `Result` object containing information about the success or failure of the operation.

#### Save Funding Application Draft
**API:** `POST /apply/applyFundingDraft`

This endpoint is used to save a draft of a funding application. It expects the same parameters as the `applyFunding` endpoint, except for the status parameter.

It returns a `Result` object containing information about the success or failure of the operation.

#### Approve Application
**API:** `POST /apply/approvalApplication`

This endpoint is used to update the `Result` and comment of a funding application. It expects the following parameters:

- `id` (integer): the ID of the application
- `Result` (string): the `Result` of the application (e.g. "approved", "rejected")
- `comment` (string): any comments about the application

It returns a `Result` object containing information about the success or failure of the operation.

#### Get Total Funding Application Count
**API:** `GET /apply/getTotalCount`

This endpoint is used to get the total number of funding applications. It expects the following parameter:

- `status` (string): the status of the applications to count (optional)

It returns a `Result` object containing the total count.

#### Get Funding Applications
**API:** `GET /apply/getApplications`

This endpoint is used to get a list of funding applications. It expects the following parameters:

- `limit` (integer): the maximum number of applications to return
- `offset` (integer): the number of applications to skip before returning results
- `status` (string): the status of the applications to return (optional)

It returns a `Result` object containing a list of applications.

#### Get Funding Applications by Group
**API:** `GET /apply/getApplicationsByGroup`

This endpoint is used to get a list of funding applications submitted by a specific group. It expects the following parameters:

- `group` (string): the name of the group
- `limit` (integer): the maximum number of applications to return
- `offset` (integer): the number of applications to skip before returning results
- `status` (string): the status of the applications to return (optional)

It returns a `Result` object containing a list of applications.

#### Get Funding Application Count by Group
**API:** `GET /apply/getApplicationCountByGroup`

This endpoint is used to get the total number of funding applications submitted by a specific group. It expects the following parameters:

- `group` (string): the name of the group
- `status` (string): the status of the applications to count (optional)

It returns a `Result` object containing the total count.

#### Delete Funding Application by ID
**API:** `GET /apply/deleteApplicationByID`

This endpoint is used to delete a funding application by its ID. It expects the following parameter:

- `id` (integer): the ID of the application to delete

It returns a `Result` object containing information about the success or failure of the operation.

---

### <span id="Expense">Expense Category Controller</span>

This section contains the implementation of the `ExpenseCategoryController` class, which is responsible for handling HTTP requests related to expense categories.

The following endpoints are implemented in this class:

#### Get All Expense Categories
**API:** `GET /categories/getAllExpenseCategories`

This endpoint is used to get the expense categories. 

It returns a `Result` object containing a list of all expense categories.

---

### <span id="Funding">Funding Controller</span>

This section contains the implementation of the `FundingController` class, which is responsible for handling HTTP requests related to funding information.

The following endpoints are available in this controller:

#### Get Funding Information by Group and Funding Name
**API:** `GET /funding/getFundingInfoByGroupAndFundingName`

This endpoint is used to retrieve funding information by group and funding name. It expects the following parameters:

- `funding` (string): the name of the funding
- `group` (string): the name of the research group

It returns a `Result` object containing the funding information.

#### Get All Funding Information
**API:** `GET /funding/getAllFundingInfo`

This endpoint is used to retrieve all funding information. It does not expect any parameters.

It returns a `Result` object containing all funding information.

#### Query Funding Information
**API:** `GET /funding/queryFundingInfo`

This endpoint is used to query funding information by the name of the research group. It expects the following parameter:

- `group` (string): the name of the research group

It returns a `Result` object containing the funding information.

#### Calculate Total Values by Funding Type
**API:** `GET /funding/multiTotalTable`

This endpoint is used to calculate the sum of total value and used value by funding type. It does not expect any parameters.

It returns a `Result` object containing the calculated values.

#### Retrieve Funding Authorization Details
**API:** `GET /funding/multiDetailTable`

This endpoint is used to retrieve funding authorization details. It does not expect any parameters.

It returns a `Result` object containing the authorization details.

#### Retrieve Funding Authorization Details by Group
**API:** `GET /funding/oneGroupMultiDetailTable`

This endpoint is used to retrieve funding authorization details by group name. It expects the following parameter:

- `group_name` (string): the name of the research group

It returns a `Result` object containing the authorization details.

#### Calculate Expenditure Summary
**API:** `GET /funding/calculateExpenditureSummary`

This endpoint is used to calculate the expenditure summary table. It does not expect any parameters.

It returns a `Result` object containing the calculated expenditure summary.

#### Calculate Expenditure Summary per User
**API:** `GET /funding/calculateExpenditureSummaryUser`

This endpoint is used to calculate the expenditure summary table per user. It expects the following parameter:

- `group` (string): the name of the research group

It returns a `Result` object containing the calculated expenditure summary per user.

#### Update Execution Rate
**API:** `GET /funding/updateExecutionRate`

This endpoint is used to update the execution rate. It expects the following parameters:

- `code` (string): the code of the funding
- `rate` (string): the new execution rate

It returns a `Result` object containing information about the success or failure of the operation.

#### Update Total Money by Execution Rate
**API:** `GET /funding/updateTotalMoneyByExecutionRate`

This endpoint is used to update the total money by execution rate. It does not expect any parameters.

It returns a `Result` object containing information about the success or failure of the operation.

---

### <span id="Manager">Manager Controller</span>

The `ManagerController` class is responsible for handling requests related to managing funds. 

The following endpoints are available in this controller:

#### Money Allocation

**API:** `GET /manager/moneyAllocation`

This endpoint allows the manager to allocate money to a specific group and fund. It expects the following parameters:

- `group_name` (string): the name of the group
- `fund_name` (string): the name of the fund
- `total` (double): the total amount of money to allocate

It returns a `Result` object containing information about the success or failure of the operation.

#### Total Money Allocation

**API:** `GET /manager/totalMoneyAllocation`

This endpoint allows the manager to allocate total money for a specific funding code. It expects the following parameters:

- `code` (string): the code of the funding
- `total` (double): the total amount of money to allocate

It returns a `Result` object containing information about the success or failure of the operation.

#### Total Money Check

**API:** `GET /manager/totalMoneyCheck`

This endpoint allows the manager to check the value of the total available money for a specific funding code. It expects the following parameter:

- `code` (string): the code of the funding

It returns a `Result` object containing information about the total available money.

#### Get Funds Info

**API:** `GET /manager/getFundsInfo`

This endpoint retrieves information about the funds, including their names, codes, total money, and more.

It returns a `Result` object containing information about the funds.

---

### <span id="Notification">Notification Controller</span>

The `NotificationController` class handles requests related to notifications. 

The following endpoints are available in this controller:

#### Get User Notification

**API:** `GET /notification/user`

This endpoint retrieves all notifications for a specific user. It expects the following parameter:

- `id` (integer): the ID of the user

It returns a `Result` object containing information about the success or failure of the operation and the user's notifications.

#### Delete All Notifications of User

**API:** `GET /notification/deleteAllNotificationOfUser`

This endpoint deletes all notifications for a specific user. It expects the following parameter:

- `id` (integer): the ID of the user

It returns a `Result` object containing information about the success or failure of the operation.

---

### <span id="Group">Research Group Controller</span>

The `ResearchGroupController` class is responsible for handling requests related to research groups. 

The following endpoints are available in this controller:

#### Get All Research Groups

**API:** `GET /groups/getAllResearchGroups`

This endpoint retrieves all research groups.

It does not require any parameters.

It returns a `Result` object containing information about the success or failure of the operation and the list of research groups.

---

### <span id="User">User Controller</span>

The `UserController` class handles requests related to user management. 

The following endpoints are available in this controller:

#### User Login

**API:** `POST /user/login`

This endpoint allows users to log in. It expects the following parameters:

- `id` (integer): the user ID
- `password` (string): the user's password

It returns a `Result` object containing information about the success or failure of the login operation.

#### Delete User

**API:** `GET /user/delete`

This endpoint allows the deletion of a user by their ID. It expects the following parameter:

- `id` (integer): the ID of the user to be deleted

It returns a `Result` object containing information about the success or failure of the deletion operation.

#### Get All Users

**API:** `GET /user/getAllUsers`

This endpoint retrieves all users.

It does not require any parameters.

It returns a `Result` object containing information about the success or failure of the operation and the list of users.

#### Get All Users by Group

**API:** `GET /user/getAllUsersByGroup`

This endpoint retrieves all users belonging to a specific group. It expects the following parameter:

- `group` (string): the group name

It returns a `Result` object containing information about the success or failure of the operation and the list of users.

#### Block User

**API:** `GET /user/blockUser`

This endpoint blocks a specific user. It expects the following parameter:

- `sid` (string): the user's unique identifier (e.g., student ID)

It returns a `Result` object containing information about the success or failure of the operation.

#### Unblock User

**API:** `GET /user/unBlockUser`

This endpoint unblocks a specific user. It expects the following parameter:

- `sid` (string): the user's unique identifier (e.g., student ID)

It returns a `Result` object containing information about the success or failure of the operation.

#### Register New User

**API:** `POST /user/register`

This endpoint allows the registration of a new user. It expects the following parameters:

- `name` (string): the user's name
- `sid` (integer): the user's unique identifier (e.g., student ID)
- `password` (string): the user's password
- `role` (string): the user's role
- `email` (string): the user's email address

It returns a `Result` object containing information about the success or failure of the registration operation.

#### Modify User's Password

**API:** `POST /user/modifyPasswd`

This endpoint allows the modification of a user's password. It expects the following parameters:

- `sid` (integer): the user's unique identifier (e.g., student ID)
- `password` (string): the new password

It returns a `Result` object containing information about the success or failure of the password modification operation.

#### Insert Group

**API:** `GET /user/insertGroup`

This endpoint inserts a research group relationship for a specific user. It expects the following parameters:

- `userid` (integer): the user ID
- `group` (string): the group name

It returns a `Result` object containing information about the success or failure of the operation.

#### Delete Group

**API:** `GET /user/deleteGroup`

This endpoint deletes a research group relationship for a specific user. It expects the following parameters:

- `userid` (integer): the user ID
- `group` (string): the group name

It returns a `Result` object containing information about the

