# dog-show

**The website works best in Chrome.

Use the following credentials to log in:

Handler name: Kyle
Password: notReal

To make dummy dogs:
 
Click "Register" to go to the register page (Day 1) which also has a "Create Dummy" button.

Add the following roles to your tomcat-users.xml file on the server:

	<role rolename="Member"/>
	<role rolename="Handler"/>
	<user username="Member" password="notReal" roles="Member"/>
	<user username="Handler" password="notReal" roles="Handler"/>
	<user username="George" password="notReal" roles="Member"/>
	<user username="Kyle" password="notReal" roles="Handler"/>

