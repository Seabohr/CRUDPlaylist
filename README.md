#CRUD Project

##Objective

The purpose of this project is to produce a full API and front end CRUD application as a demonstration of what we have learnt so far.

Thus I used:
-Jira Software Kanban board to layout and track tasks to be completed, and made assesments of task priority.
-Git/Github to upload work done so far, utilising Kanban integration to link pushes with tasks.
-Eclipse to write the Java.
-Spring Boot to implement the API.
-Using Mockito and Junit to test the backend.
-Workbench to implement a MySQL database.
-VSC to build a front end website, using HTML, CSS and Javascript.

##Kanban
Full Kanban board can be found here https://team-1624352241021.atlassian.net/jira/software/projects/CRUD/boards/3
I attempted to try to plan out each day as induvidual scrums but quickly found out that past scrums cannot be viewed, or atleast I could not find out how, thus a lot of the initial tasks and planning are gonne.

##Git/Github
I made sure to follow the main->development->feature branch model as much as possible, loosing track occasionally of the feature branch I was currently working on. However, by keeping the branch separation I always had a backup dev branch that I could go back to regardless of messing up a pull or push on a feature branch via git.

##Eclipse + Spring
Using a Spring framework, generating and writing the API was straight forward, taking care to follow SOLID principles, such as ensuring variables are private and accessing them though public getters and setters. I ended up implementing a get song by id method, dispite not needing it in the end, on the chance that I would require it later on in the Javascript.

##Testing
When going about generating and writing both my controller and services, I made sure to write the relevant tests first to ensure I got the correct output from the tested methods. Specifically, using Mockito to test my services and SpringBootTest with Junit for controller tests.

##MySQL Worbench
Implementing and connecting the relevant database was simple enough, I used Postman to verify my mappings and to add some songs to the database so that I would have some data to check against when implementing relevant Javascript.

##VSC
I decided to implement a basic HTML and CSS framework with Bootstrap to get an idea of the layout of the website before moving on to implementing features. Once I had an idea, I proceded to write Javascript and relied on Bootstraps Grid system to implement each feature to fufil the basic requrements of the five user stories I had originally written on the projects kanban board. I decided outside of basic functionallity and some ease of use, further CSS work would be outside of the MVP scope, and thus could be left out due to time constraints.

