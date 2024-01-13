## CS Funding System - User Guide

:wave: Hello World! 

**CS Funding System** is a web application for :man_judge:**administrators**, :man_teacher:**professors** and :man_office_worker:**secretaries** of the :computer:[Department of Computer Science and Engineering](https://cse.sustech.edu.cn/) in the :school:[Southern University of Science and Technology](https://www.sustech.edu.cn/) to manage the :moneybag:<u>funds</u> and :dollar:<u>reimbursements</u>.

Developers of CS Funding System: 

:man:[Yuwei Xiao](https://github.com/Xavier-Shaw), :woman:[Zhe Ding](https://github.com/DingZ0115), :woman:[Shimin Luo](https://github.com/FffffeiXIN), :man:[Sirui Lee](https://github.com/Siri-Lee), :man:[Dazhi FENG](https://github.com/dazhi0619)

---

This document provides guidance and instructions for users of the CS Funding System, it aims to empower users with the knowledge and understanding necessary to navigate and utilize the CS Funding System. It also serves as a comprehensive guide to assist users in effectively managing funds and reimbursements.

### Contents

This User Guide includes: 

* [Getting Started](#Start)
* [Using CS Funding System](#Using)
* [Your Profile](#Profile)

---

### <span id="Start">Getting Started</span>

Two kinds of roles are designed for our CS Funding System, please clarify your role and find corresponding part to get started.

#### For :man_judge:Administrator

You are responsible for managing the funds, reimbursements, members.

In CS Funding System, you are able to:

* [Distribute Funds](#DistributeFund)
* [Review and Approve Reimbursement](#ReviewAndApproveReimbursement)
* [Manage Users and their Permission](#ManageUsers)
* [Manage User's Research Group](#ManageUserGroup)
* [Manage Research Groups](#ManageGroups)

#### For :man_teacher:Professor & :man_office_worker:Secretary

You are responsible for applying and checking reimbursements.

In CS Funding System, you are able to:

* [Apply for Reimbursement](#ApplyReimbursement)
* [Check and Modify Reimbursement](#CheckAndModifyReimbursement)
* [Check Group Members](#CheckMember)

#### For :bust_in_silhouette:All Roles

* [Check Funding Information](#CheckFunding)
* [Check Notifications](#CheckNotifications)

---

### <span id="Using">Using CS Funding System</span>

:mega:Here are the available functions of the CS Funding System.

---

#### <span id="DistributeFunds">Distribute Funds</span>

> Who can use this feature?
>
> :man_judge:Administrator

In `课题组金额分配` section, we offer a **pre-distribution** function for administrators in order to help them get a clear overview of the money distributions and therefore better arrange the money distributions.

**Steps:**

1. :eyes:Select the Fund and check its current Usage
2. :eyes:Select Research Group
3. :heavy_dollar_sign:Input the amount you want to distribute
4. :dollar:Click `分配` to pre-distribute the money
5. :negative_squared_cross_mark:Click `取消分配` to cancel the pre-distribution
6. :white_check_mark:Click `提交分配` to confirm and submit your distribution

---

#### <span id="ReviewAndApproveReimbursement">Review and Approve Reimbursement</span>

> Who can use this feature?
>
> :man_judge:Administrator

In `报销申请管理` section, administrators can review and approve the reimbursements.

**Steps:**

1. :eyes:Select the status of the reimbursements
2. :eyes:Review the reimbursements
3. :negative_squared_cross_mark:Click `拒绝` to refuse the reimbursement and give feedback
4. :white_check_mark:Click `同意` to approve the reimbursement

---

#### <span id="ManageUsers">Manage Users and their Permission</span>s

> Who can use this feature?
>
> :man_judge:Administrator

In `用户（权限）管理` section, administrators can check current users and mange their permissions.

**Steps:**

1. :eyes:Browse the list of current users with their brief information
2. :lock:Click `Block User` to limit the right of the user to apply for reimbursement
3. :key:Click `Unblock User` to resume the right of the user to apply for reimbursement

---

#### <span id="ManageUserGroup">Manage User's Research Group</span>

> Who can use this feature?
>
> :man_judge:Administrator

In `用户（权限）管理` section, administrators can check and manage the research group of each users.

**Steps:**

1. :eyes:Browse the list of current users with their research group information
2. :mag:Click `添加课题组` if you want to add current user into a new research group
3. :eyes:Browse the list of available research groups for current user
4. :white_check_mark:Select a research group and click `确认` to add

---

#### <span id="ManageGroups">Manage Research Group</span>s

> Who can use this feature?
>
> :man_judge:Administrator

In `课题组管理` section, administrators can check the research groups and the brief information of their funding usage. 

**Steps:**

1. :eyes:Browse the list of current research groups
2. :eyes:Hover on the pie chart to check the brief funding information
3. :eyes:Check the usage of funds using the table visualization 
4. :mag:Click `查看详情` to check the detail usage of funds

---

#### <span id="ApplyReimbursement">Apply for Reimbursement</span>

> Who can use this feature?
>
> :man_teacher:Professors & :man_office_worker:Secretaries

In `报销申请` section, professors and secretaries can apply for reimbursement. We offer a `save` function to save the current application so that users can have extra time to figure out the required information.

**Steps:**

1. :eyes:Select Fund and Research Group and check the Usage 
2. :eyes:Input the amount you want to reimburse
3. :eyes:Select the type of your reimbursement
4. :writing_hand:Write an abstract and additional information for your reimbursement
5. :page_with_curl:Click `暂存` to save your application in the working area  
6. :white_check_mark:Click `提交` to submit your application

---

#### <span id="CheckAndModifyReimbursement">Check and Modify Reimbursement</span>

> Who can use this feature?
>
> :man_teacher:Professors & :man_office_worker:Secretaries

In `报销申请管理` section, professors and secretaries can check their submitted reimbursements. They are also able to modify the refused and saved reimbursements, then submit the modified reimbursements to administrators.

**Steps:**

1. :eyes:Select the status of the reimbursements
2. :leftwards_arrow_with_hook:Click `撤销申请` to recall the reimbursement of the status `待处理`
3. :writing_hand:Click `修改申请` to modify the reimbursement of the status `拒绝` and `草稿箱`

---

#### <span id="CheckMember">Check Group Members</span>

> Who can use this feature?
>
> :man_teacher:Professors & :man_office_worker:Secretaries

In `课题组管理` section, professors and secretaries can check the information of their enrolled research group and the group members.

**Steps:**

1. :eyes:Select the research group
2. :eyes:Browse the list of group members

---

#### <span id="CheckFunding">Check Funding Information</span>

> Who can use this feature?
>
> :bust_in_silhouette:All Users

In `课题组经费使用情况`(professors & secretaries) or `经费管理`(administrators) section, users can check the detailed usage of funds.

**Steps:**

1. :eyes:For administrators, select the research group
2. :eyes:For professors & secretaries, select the type of table
3. :mag:Get insights of the usage of funds using the chart and table
4. :white_check_mark:Click `导出表格` to **export** the table as a file 

---

#### <span id="CheckNotifications">Check Notifications</span>

> Who can use this feature?
>
> :bust_in_silhouette:All Users

In `消息中心` section, users can check the received notifications.

For administrators, you will get notifications about the submitted reimbursements.

For professors and secretaries, you will get notifications about the status of your submitted reimbursements.

---

### <span id="Profile">Your Profile</span>

In `个人中心` section, you can get an overview of your basic information.

Moreover, you are able to:

* :alien:Change Avatar
* :email:Change Email

















