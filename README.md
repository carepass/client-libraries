CarePass Java Client Libraries
=============================

The goal of these libraries is to remove the need for a CarePass developer to manage the baseline connectivity and data un-packing of interacting with the CarePass APIs.

About CarePass APIs
===================
Read all about the available API's at https://developer.carepass.com

Quick Start: Examples you can use
=================================
For an example of how to use the API, including key configuration, see `/carepass-api/src/main/java/com/aetna/carepass/CarePassApplication.java` in the source

Adding the CarePass Java Client Libraries to Your Project
========================================================

The Java Client library for CarePass is a Maven project.  While it is not available in a Maven repository, you may download it and build it locally.  It will load it's own dependencies from external repositories.

1.  The code for the project can be found here:  <https://github.com/carepass/client-libraries/tree/Java>
2.  If you do not already have Maven installed, it can be downloaded here: <http://maven.apache.org/download.html>
3.  Once you have downloaded the code and installed Maven, build the project by using `mvn clean install`

You can then add the built project to your own maven project with the below dependency:

	<dependency>
		<groupId>com.aetna.carepass</groupId>
		<artifactId>carepass-api</artifactId>
	</dependency>
	
For an example of how to use the API, including key configuration, see `/carepass-api/src/main/java/com/aetna/carepass/CarePassApplication.java` in the source
