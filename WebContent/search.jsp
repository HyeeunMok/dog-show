<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Fast Sloth Club is great.">
        <link rel="stylesheet" type="text/css" href="vendors/css/normalize.css">
        <link rel="stylesheet" type="text/css" href="vendors/css/grid.css">
        <link rel="stylesheet" type="text/css" href="vendors/css/animate.css">
        <link rel="stylesheet" type="text/css" href="vendors/css/ionicons.min.css">
        <link rel="stylesheet" type="text/css" href="resources/css/search.css">
        <link rel="stylesheet" type="text/css" href="resources/css/queries.css">
        <link href="https://fonts.googleapis.com/css?family=Lato:100,300,300i,400" rel="stylesheet" type="text/css">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Dog Show Search</title>

    </head>
    <body>
        <header>
            <nav>
                <div class="row">
                    <div class="logo">
                        <i class="ion-ios-paw icon-big"><h6 id="logo-text">Dog Show March 1-3, 2019<br><br>Fast Sloth Club</h6></i>
                    </div>
                    <ul class="main-nav js--main-nav">
                        <li><a href="index.html">Home</a></li>
                        <li><a href="GetDog">Dog List</a></li>
                        <li><a href="ShowList?date=1">Show List</a></li>
                        <li><a href="winners.jsp">Winners</a></li>
                        <li><a href="search.jsp">Find</a></li>
                        <li><a href="HandlerPage">Handler</a></li>
                        <li><a href="register1.jsp">Register</a></li>
                    </ul>
                    <a class="mobile-nav-icon js--nav-icon"><i class="ion-navicon-round"></i></a>
                </div>
            </nav>
        </header>
		<h1 id="register-text">Entrants</h1>
	 <div class="registrationbox js--section-features" id="c">
	  
	  <form action="Search" method="get">
	  <p style="color: red; font-size: 12px; float: right;">*Search one or multiple parameters</p><br>
	  	
	  	<label for="number">Number</label>
	    <input type="text" id="number" name="number">
	  	
	    <label for="name">Name</label>
	    <input type="text" id="dogname" name="dogname">
	
	    <label for="owner">Owner Name</label>
	    <input type="text" id="ownername" name="ownerName">
	
	    <label for="breed">Breed</label>
	    <input type="text" id="breed" name="breed">
	    
	    <label for="group">Group</label><select name="dogGroup">
	      <option></option>
		  <option>Group 1: Sporting Dogs</option>
		  <option>Group 2: Hounds</option>
		  <option>Group 3: Working Dogs</option>
		  <option>Group 4: Terriers</option>
		  <option>Group 5: Toys</option>
		  <option>Group 6: Non-sporting Dogs</option>
		  <option>Group 7: Herding</option>
		</select>

	    <input type="submit" value="Search">
	</form>
</div>    
        <footer>
            <div class="row">
                <div class="col span-1-of-2">
                    <ul class="footer-nav">
                        <li><a href="https://www.linkedin.com/in/hyeeunmok/">About me</a></li>
                        <li><a href="https://github.com/HyeeunMok">GitHub</a></li>
                    </ul>
                </div>
                <div class="col span-1-of-2">
                    <ul class="social-links">
                        <li><a href="https://github.com/HyeeunMok"><i class="ion-social-github"></i></a></li>
                        <li><a href="https://www.linkedin.com/in/hyeeunmok/"><i class="ion-social-linkedin-outline"></i></a></li>
                        <li><a href="https://www.facebook.com/hyeeun.mok.5"><i class="ion-social-facebook"></i></a></li>
                        <li><a href="mailto:hyeeuni.mok@gmail.com" target="_top"><i class="ion-ios-email"></i></a></li>
                    </ul>
                </div>
            </div>
            <div class="row">
                <p>
                    Copyright &copy; 2018 by Hyeeun Mok & Sean Roy. All rights reserved.
                </p>
            </div>

        </footer>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/selectivizr@1.0.3/selectivizr.min.js"></script>
        <script src="vendors/js/jquery.waypoints.min.js"></script>
        <script src="https://maps.google.com/maps/api/js?sensor=true"></script>
        <script src="resources/js/script.js"></script>
        <script src="resources/js/gmaps.js"></script>

    </body>
</html>