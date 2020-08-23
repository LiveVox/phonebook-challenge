<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
	<title>PhoneBook</title>
	<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="<c:url value="/resources/css/styles.css"/>">
</head>
<body>
	<div class="container">
		<div class="pure-g">
			<div class="pure-u-1">
				<div class="header">
					<img class="logo" src="<c:url value="/resources/img/phonebook.png"/>"/>
					<p>v 1.0</p>
				</div>
				
			</div>
		</div>
		<div class="pure-g">
		    <div class="pure-u-sm-1 pure-u-1-3">
		    	<div class="box">
		    		<h2><i class="fa fa-user-plus"></i>New contact</h2>
		    		<form:form class="pure-form" method="POST" action="/PhoneBook/newContact" commandName="newContact">
					    <fieldset class="pure-group">
					        <form:input path="firstName" type="text" class="pure-input-1-2" placeholder="First Name" />
					        <form:errors path="firstName" cssClass="error"/>
					        <form:input path="lastName" type="text" class="pure-input-1-2" placeholder="Last Name" />
					        <form:errors path="lastName" cssClass="error"/>
					        <form:input path="phoneNumber" type="text" class="pure-input-1-2" placeholder="Phone" />
					        <form:errors path="phoneNumber" cssClass="error"/>
					    </fieldset>
					    <button type="submit" class="pure-button pure-input-1-2 pure-button-primary">
					    	<i class="fa fa-user-plus"></i>Add
					    </button>
					</form:form>
				</div>
			</div>
		    <div class="pure-u-sm-1 pure-u-1-3">
				<div class="box">
		    		<h2><i class="fa fa-search"></i>Search contact</h2>
		    		<form method="GET" action="/PhoneBook" class="pure-form">
		    			<fieldset class="pure-group">
					    	<input type="text" name="keyword" class="pure-input-1-2">
					     </fieldset>
					    <button type="submit" class="pure-button pure-input-1-2 pure-button-primary">
					    <i class="fa fa-search"></i>Search</button>
					</form>
				</div>
			</div>
			<div class="pure-u-sm-1 pure-u-1-3">
				<div class="box">
		    		<h2><i class="fa fa-users"></i> Contacts</h2>
					<c:if test="${empty contacts}">
						<div> Your phone book is empty!!!</div>
				
					</c:if>
	    			<c:if test="${not empty contacts}">
		    			<table class="pure-table">
						    <thead>
						        <tr>
						            <th>First Name</th>
						            <th>Last Name</th>
						            <th>Phone</th>
						        </tr>
						    </thead>
						
						    <tbody>
 								<c:forEach var="contact" items="${contacts}">
				       				<tr>
							            <td>${ contact.getFirstName() }</td>
							            <td>${ contact.getLastName() }</td>
							            <td>${ contact.getPhoneNumber() }</td>
							        </tr>
								</c:forEach>
						    </tbody>
						</table>					
					</c:if>

				</div>
			</div>
		</div>
	</div>
</body>
</html>