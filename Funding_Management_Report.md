# Final-report-2221

## 1. Metrics

### 1.1 Lines of Code
The cumulative count of front-end source code lines amounts to **5190**, showcasing the extent of coding dedicated to the user interface and client-side functionality. On the other hand, the back-end code accounts for **2,208 lines**, encapsulating the logic and operations handling server-side functionalities.
### 1.2 Number of modules/subprojects
The entire project consists of **two distinct modules**: the front end and the back end. These modules represent crucial components that work in harmony to deliver a comprehensive solution. The front end module primarily focuses on the user interface, providing an intuitive and engaging experience for users. On the other hand, the back end module handles the underlying logic, data processing, and database management, ensuring seamless functionality and efficient data handling. By dividing the project into these two modules, it becomes easier to manage, maintain, and enhance each component independently, ultimately resulting in a cohesive and robust system.
### 1.3 Number of packages
The project consists of various packages, with the front-end and back-end being the main components.

The front-end portion comprises a total of **9 packages**, each serving a specific purpose. These modules include assets, components, views, utils, and more. The assets module handles the management of project resources such as images, fonts, and styles. The components package houses reusable UI components that contribute to the overall user interface. The views module focuses on defining the different views or pages within the application. Additionally, the utils module contains utility functions or helper methods utilized throughout the front-end implementation.

On the other hand, the back-end encompasses **7distinct packages** , each fulfilling a particular role in the system. These packages encompass the config, controller, entity, mapper, and others. The config module handles the configuration and setup of the back-end environment, ensuring smooth execution of the system. The controller module serves as the intermediary between the user interface and the back-end logic, managing the flow of data and requests. The entity module represents the data models or database schemas used in the application. The mapper module is responsible for mapping data between different formats or structures, facilitating seamless communication within the system.

These modular divisions in both the front-end and back-end contribute to a well-organized and scalable project architecture, promoting code reusability, maintainability, and efficient development processes.
### 1.4 Number of source files
In the project, the front end consists of a total of **38 source files**, while the back end comprises **39 source files**.
### 1.5 Number of 3rd party dependencies
The front end of the project incorporates a total of **7 third-party dependencies**, which include element-plus, echarts, vuex, axios, and several others. These external libraries serve as crucial components in enhancing the functionality and features of the front-end application.

On the other hand, the back end of the project relies on **11 distinct third-party libraries**. Noteworthy examples among these libraries are mybatis, swagger, and postgresql, all of which play integral roles in supporting the back-end infrastructure and facilitating efficient data management and API documentation.

Collectively, this project encompasses a comprehensive utilization of **18 third-party libraries**. The incorporation of these external dependencies showcases the project's emphasis on leveraging established solutions to enhance its functionality, improve development efficiency, and leverage robust features provided by these libraries.
### 1.6 Maintainability of the project
####  1.6.1 Five metrics of teedy
The Teedy project has a total line count of **177,405**, divided into **three modules**: docs-core, docs-web, and docs-web-common. This indicates that the project has a significant scale and complexity. Additionally, it includes at least **33** packages and **733** source files, along with the utilization of **139** third-party libraries to enhance its functionality and features. This structure and scale may pose challenges for the maintenance team, requiring more attention and careful management.

#### 1.6.2 Comparative analysis of maintainability
1. Lines of code:
    * The total number of lines of code in this project is **7,398**, which is relatively small. A smaller codebase often implies easier understanding, modification, and testing.
    * A smaller codebase can reduce complexity and make it easier to track and fix potential issues.
    
2. Number of modules/subprojects
    * This project is divided into two modules: frontend and backend, with only **two modules**.
    * Having a smaller number of modules facilitates code organization and maintenance. Clear responsibilities between modules make it easier to understand and modify them.
    
3. Number of packages:
    * This project includes **16 packages**, which is relatively low. A well-structured package system aids in code organization and modular development.
    * A smaller number of packages can reduce dependencies between code components, making modifications and extensions more manageable and predictable.

4. Number of source files:
    * This project consists of **38 source files**. A smaller number of source files can reduce the complexity of individual files, making them easier to read and modify.
    * Proper splitting and organization of source files contribute to code maintainability, enabling easier understanding and maintenance of functional modules and components.

5. Number of 3rd party dependencies
    * This project utilizes **18 third-party libraries**. Appropriate usage of third-party libraries can improve development efficiency and enhance functionality.
    * Managing the versions and dependencies of third-party libraries is crucial for ensuring maintainability. Regular updates and maintenance of these libraries can address potential security vulnerabilities and performance issues.

Overall, this project exhibits some advantages in terms of maintainability. The smaller codebase, number of modules, packages, and source files contribute to easier understanding, modification, and maintenance. However, to ensure long-term maintainability, it is still important to emphasize good coding practices, documentation, code reviews, and test coverage. Additionally, fostering knowledge sharing and communication within the team and staying up to date with ongoing technical updates and maintenance are key factors in ensuring maintainability.

## 2. Documentation

### 2.1 GitHub URL
**Developer guide:**
https://github.com/FffffeiXIN/CS304-funding_Management_Front/blob/master/CS%20Funding%20System%20-%20Developer%20Guide.md

**User guide:**
https://github.com/FffffeiXIN/CS304-funding_Management_Front/blob/master/CS%20Funding%20System%20-%20User%20Guide.md

### 2.2 Screenshots
**Developer guide:**
![](https://md.cra.moe/uploads/upload_daaa6a554df1b3fea1f33119f222fe5d.png)
![](https://md.cra.moe/uploads/upload_f43cb29bbe26e2a14437890b869717cd.png)
![](https://md.cra.moe/uploads/upload_946a50beaf324944f86d8d3a88442fa6.png)
![](https://md.cra.moe/uploads/upload_c8c42c66a319aeee3417b5295d0498f1.png)

**User guide:**
![](https://md.cra.moe/uploads/upload_e28aadf30a543048b58a5fc263fb8a70.png)
![](https://md.cra.moe/uploads/upload_723503d2fa3d6aaccaef6e49e4a693d3.png)
![](https://md.cra.moe/uploads/upload_67e8338e4ef4f9bed449f9bbadf57e0a.png)

### 2.3 Brief description
**Developer guide:**
This documentation provides essential information and guidelines for developers working on the CS Funding System, it aims to assist developers in understanding the CS Funding System's technical aspects, enabling them to efficiently contribute to its development, maintenance, and enhancement. It also serves as a comprehensive reference guide to facilitate smooth collaboration and ensure the stability and scalability of the system.

**User guide:**
This document provides guidance and instructions for users of the CS Funding System, it aims to empower users with the knowledge and understanding necessary to navigate and utilize the CS Funding System. It also serves as a comprehensive guide to assist users in effectively managing funds and reimbursements.

## 3. Tests
### 3.1 Automated Testing
 - Tools we use: JUnit and Jacoco
 - Usage: For testing backend APIs
     - For most of the backend APIs that will be used when interacting with the front end, we design testing methods that cover most of the branches.
 - Source code & artifact: Due to the duplication of testing methods and the huge number of tests we invoked, we only demonstrate the source code of **two of them**. For the rest of the testing method, **the screenshot of testing results** will be shown below.
     - All the testing codes can be found on our project's github: https://github.com/FffffeiXIN/CS_funding.git
     - Test code for login function:
![](https://md.cra.moe/uploads/upload_cfb878f993c88bd8f6143f962edb9963.png)
     - Test code for check funding count function:
![](https://md.cra.moe/uploads/upload_902c71679244fece24756243703554ac.png)
     - Screenshot of testing results:
<img src="https://md.cra.moe/uploads/upload_f2cb0303cf67179dd9d87dc2ac25e985.png" alt="image-20230528223111944" style="zoom:50%;" />
<img src="https://md.cra.moe/uploads/upload_df672b70cd82137aa890b72c9e22440b.png" alt="image-20230528223111944" style="zoom:50%;" />
<img src="https://md.cra.moe/uploads/upload_2327f2ba0819428d4504795d092495ea.png" alt="image-20230528223111944" style="zoom:50%;" />
<img src="https://md.cra.moe/uploads/upload_d4a77047bcd6ee9f7d878efc41056bd5.png" alt="image-20230528223111944" style="zoom:50%;" />
<img src="https://md.cra.moe/uploads/upload_e2f604cc2d4f7e2381dca25082455c4e.png" alt="image-20230528223111944" style="zoom:50%;" />
<img src="https://md.cra.moe/uploads/upload_6169ee227443f21a443169afbff340bc.png" alt="image-20230528223111944" style="zoom:50%;" />
<img src="https://md.cra.moe/uploads/upload_024d8632374babdf2a0bf8508899b7a5.png" alt="image-20230528223111944" style="zoom:50%;" />
 - Test coverage report: We utilize automated tool "Jacoco" to help us generate the test coverage report. For practicality, we only generate the coverage report of `controller` folder, because all the APIs that will be used to interact with frontend are stored in this folder. As the screenshot shown below, the overall test coverage achieves **85%**. The rest of 15% not-tested APIs will also be invoked in the 85% tested APIs, so we did not design specific tests for them.
![](https://md.cra.moe/uploads/upload_69a58ee7d3322ea6fa0eae510fef991b.png)

### 3.2 Manually Testing
 - Tool we use: Swagger
 - Usage: For testing backend APIs
     - Considering the protential changes of backend methods and database framework, we also invoke manually testing for better flexibility.
 - Config code:
![](https://md.cra.moe/uploads/upload_27bd98f5b5ecea28d3d0d75e1a3465ec.png)
 - URL: http://localhost:8080/v2/api-docs
 - Screenshot of testing interface:
![](https://md.cra.moe/uploads/upload_63ba963cb44f09e0aee4cd1f4a3cbf02.png)
 - Test coverage: For each method we will design corresponding swagger tests.

## 4. Build

### 4.1 The technology for building the project

- Version control: Git
- Project management: Maven
- Unit test: JUnit
- Delivery platform: Dockerhub
- Automation platform: GitHub Actions

### 4.2 Explain the tasks executed in a build

We use GitHub Actions to automate the process. In a building process, there are 3 stages, namely testing, building, and publishing. For the testing stage, we manually use JUnit to test every API exposed to the frontend. After that, we push the code to GitHub, so Maven comes to build the project, package the classes and the dependencies, and produce a single JAR file. Docker will then build an image containing the JAR file and publish the image to Dockerhub.

### 4.3 Final artifacts description (e.g. how to run the built jar)

To run the JAR file, you can use

```
java -jar <name of the file.jar>
```

There is no other step needed to start the project.

More commonly, you can download and run the docker image using

```
docker pull dazhi0619/cs_funding:latest
docker run --rm --name cs_funding -p 8080:8080 dazhi0619/cs_funding
```

### 4.4 Related artifacts

- Building script: https://github.com/FffffeiXIN/CS_funding/blob/master/.github/workflows/maven.yml
- Final artifact: https://hub.docker.com/r/dazhi0619/cs_funding/tags


## 5. Deployment
### Containerization Technology

We use docker to containerize our backend. 

### 5.1 Containerization Script

Since we use GitHub Actions to automate the testing, building, and delivery process, the contarinerization script is in the same file as the building script: 

https://github.com/FffffeiXIN/CS_funding/blob/master/.github/workflows/maven.yml
![](https://md.cra.moe/uploads/upload_215d04b3dc24be01e4c8cb057159f16c.png)


### 5.2 A proof of successful containerization

Dockerhub link: https://hub.docker.com/r/dazhi0619/cs_funding/tags