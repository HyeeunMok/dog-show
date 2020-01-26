<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.fastsloth.beans.Dog" %>

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
        <link rel="stylesheet" type="text/css" href="resources/css/newpages.css">
        <link href="https://fonts.googleapis.com/css?family=Lato:100,300,300i,400" rel="stylesheet" type="text/css">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Edit Info</title>

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
           		
        <section class="secion-features js--section-features" id="c">
            <div class="row">
            <h3 id="register-text">You can update.</h3>
            <p id=register-text>You've Entry number is ${dog.number}</p>
          
            <form action="EditDog" method="get" class="table-form">
            <input type="hidden" value = "${dog.number}" name="number" />
                <div class="row">
                    <div class="col span-1-of-3" id="alignRight">
                    <label>Name</label>
                    </div>
                    <div class="col span-2-of-5">
                    <input type="text" name="dogName" value="${dog.name}" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col span-1-of-3" id="alignRight">
                    <label>Owner Name</label>
                    </div>
                    <div class="col span-2-of-5">
                    <input type="text" name="ownerName" value="${dog.ownerName}" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col span-1-of-3" id="alignRight">
                    <label for="title">Breed</label>
                    </div>
                    <div class="col span-2-of-5">
                    <input type="text" name="breed" value="${dog.breed}" required>
                    </div>
                </div>
                <div class="row">
                <p id=register-text>You've chosen ${dog.group}</p>
                    <div class="col span-1-of-3" id="alignRight">
                    <label>Group</label>
                    </div>
                    <div class="col span-2-of-5">
                    <select name="group" id="group">
                    <option ${g1Selected} value="Group 1: Sporting Dogs">Group 1: Sporting Dogs</option>
                        <option ${g2Selected} value="Group 2: Hounds">Group 2: Hound</option>
                        <option ${g3Selected} value="Group 3: Working Dogs">Group 3: Working Dogs</option>
                        <option ${g4Selected} value="Group 4: Terriers">Group 4: Terriers</option>
                        <option ${g5Selected} value="Group 5: Toys">Group 5: Toys</option>
                        <option ${g6Selected} value="Group 6: Non-sporting Dogs">Group 6: Non-Sporting</option>
                        <option ${g7Selected} value="Group 7: Herding">Group 7: Herding</option>
                    </select>
                    </div>
                </div>
                
                <div class="row">
                <p id=register-text>You've chosen ${dog.gender}. If you want to change, select it</p>
                    <div class="col span-1-of-3" id="alignRight">
                    <label>Gender</label>
                    </div>
                    <div class="col span-1-of-4">
                        <div class="question-column" >
                            <input type="radio" class="big" name="genderChoice" value="Male" ${maleSelected} required> Male
                          </div>
                          <div class="question-column">
                            <input type="radio" class="big" name="genderChoice" value="Female" ${femaleSelected}> Female
                          </div>
                    </div>
                </div>
        
                <div class="row">
                <p id=register-text>You've chosen ${dog.dogClass}. If you want to change, select it</p>
                    <div class="col span-1-of-3" id="alignRight">
                    <label>Class</label>
                    </div>
                    <div class="col span-1-of-4">
                        <div class="question-column" >
                            <input type="radio" class="big" name="classChoice" value="Class" ${classSelected} required> Class
                          </div>
                          <div class="question-column">
                            <input type="radio" class="big" name="classChoice" value="Specialty" ${specialtySelected}> Specialty
                          </div>
                    </div>
                </div>
                <div class="row">
                <p id=register-text>*You can choose multiple days.</p>
                    <div class="col span-1-of-3" id="alignRight">
                    <label>Date</label>
                    </div>
                    <div class="col span-2-of-5">
                        <label id="container">Day 1
						  <input type="checkbox" name="day1" ${day1On}>
						  <span id="checkmark"></span>
						</label>
						<label id="container">Day 2
						  <input type="checkbox" name="day2" ${day2On}>
						  <span id="checkmark"></span>
						</label>
						<label id="container">Day 3
						  <input type="checkbox" name="day3" ${day3On}>
						  <span id="checkmark"></span>
						</label>
                    </div>
                </div>
                <div class="row">
                    <div class="col span-1-of-3" id="alignRight">
                    <label for="title">Email</label>
                    </div>
                    <div class="col span-2-of-5">
                    <input type="email" name="email" id="email" value="${dog.email}" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col span-1-of-3" id="alignRight">
                    <label for="title">Password</label>
                    </div>
                    <div class="col span-2-of-5">
                    <input type="password" name="password" value="${dog.password}" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col span-1-of-3">
                        <label> </label>
                    </div>
                    <div class="col span-2-of-5" class="btn btn-full">
                        <input type="submit" id="submit" value="Update">
                        <a class="btn btn-ghost" href="DeleteDog?num=${dog.number}">Delete</a>
                    </div>
                </div>
            </form>
            
            
            </div>
        </section>

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