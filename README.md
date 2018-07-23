# Problem Statement

Below is employee data of a small company. It represents the hierarchical relationship among employees. CEO of the company doesn't have a manager. Employee Name id Manager id 

| Employee Name  | id | manager id |
| --- | --- |
| Alan | 100 |150 |
| Martin | 220 |100 |
| Jamie | 150 | |
| Alex | 275 |100 |
| Steve | 400 |150 |
| David | 190 |400 |
 
Design a suitable representation of this data. Feel free to choose any database (RDBMS, inmemory database etc), file system or even a data structure like List or Map. Then write code (in any language and framework) that displays the organisation hierarchy as below: 

| Employee Name  | id | manager id |
| --- | --- |
| Jamie |  | |
|  | Alan | |
|  |  | Matin |
|  |  |Alex |
|  | Steve | |
|  |  |David | 
 
The result can be simply displayed on the console, or HTML page or even a file; whatever suits you.  Try to cover all the possible scenarios, for example an employee with no manager, a manager who is not valid employee; etc. Pay more attention on writing the actual logic of representing the employee tabular data into the hierarchical format. 

# Solution

## EBook Microservice
This microservice will expose employee hierarchy to the  UI. we will choose spring boot for rapid development of microservice. This is written as microservice so that it can be scaled based on the load. Ideally this can be run as docker container within any Container Orchestration Platform like kubernetes platform.

**GetHierarchy Operation**

Request method : GET
Header : Allow Cross Origins
URL : api/hierarchy
Respone: Sorted Array of Hierarchy object containing employee name and level
[{"employeeName":"Jamie","level":1},
{"employeeName":"Alan","level":2},
{"employeeName":"Alex","level":3},
{"employeeName":"Martin","level":3},
{"employeeName":"Steve","level":2},
{"employeeName":"David","level":3}]

## Database

This microservice is using postresql10 which supports Common Table Expressions for writing recursive query. For JPA unit testing we will be using in memory h3 database. If prefferred option is oracle then we can use CONNECT BY clause.

## Ebook UI
Angular will be chosen for front end for rapid development. component for <app-hierarcy> can be created which can be re-used at multiple pages depending on requirement. hierarchy service will be written to fetct the data from the server.

## Further Enhancement
Pagination should be added.
Ideally on clicking specific employee, their reportee should be fetched.
Increase unit test coverage.
