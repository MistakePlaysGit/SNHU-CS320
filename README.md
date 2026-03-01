CS 300 Portfolio — Software Testing and Quality Assurance
Peyton Cedotal

Reflection:

How can I ensure that my code, program, or software is functional and secure?

Writing tests is the most reliable method I have found. In this course I wrote JUnit tests for every validation rule and service operation, which forced me to think through failure cases just as carefully as the normal ones. Input validation - rejecting nulls, enforcing length limits, verifying formats - is also the first line of defense against bad data entering the system.

How do I interpret user needs and incorporate them into a program?

I treat the requirements document as the source of truth and map each requirement directly to a test case. For this project every field constraint the customer specified became its own test, which gave me confidence the program does what was actually asked for rather than what I assumed.

How do I approach designing software?

I start with the requirements and work outward - identify what data needs to be stored, what rules govern it, and what operations need to be supported, then build from there. I prefer keeping things simple and writing tests alongside the code rather than after, because it catches design problems while they are still easy to fix.

Files included:

Contact.java
ContactService.java
ContactTest.java
ContactServiceTest.java
Appointment.java
AppointmentService.java
AppointmentTest.java
TaskTest.java
TaskServiceTest.java
Task.java
CS-320_Project_2_Peyton_Cedotal.docx
