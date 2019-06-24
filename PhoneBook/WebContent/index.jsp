<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
	<title>PhoneBook</title>
	<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="css/styles.css">

	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="./js/phonebook.js"></script>
</head>
<body onload="loadContacts();">
	<div class="container">
		<div class="pure-g">
			<div class="pure-u-1">
				<div class="header">
					<img class="logo" src="img/phonebook.png"/>
					<p>v 1.0</p>
				</div>

			</div>
		</div>
		<div class="pure-g">
		    <div class="pure-u-sm-1 pure-u-1-3">
		    	<div class="box">
		    		<h2><i class="fa fa-user-plus"></i>New contact</h2>
		    		<form class="pure-form">
					    <fieldset class="pure-group">
					        <input type="text" class="pure-input-1-2" placeholder="First Name" onchange="setContact('name',this.value)" required id="name">
					        <input type="text" class="pure-input-1-2" placeholder="Last Name" onchange="setContact('lastname',this.value)" required id="lastname">
					        <input type="tel" class="pure-input-1-2" placeholder="Phone" onchange="setContact('phone',this.value)" required maxlength=15 id="phone">
					    </fieldset>
					    <button type="button" onclick="addContact();" class="pure-button pure-input-1-2 pure-button-primary">
					    	<i class="fa fa-user-plus"></i>Add
						</button>
					</form>
				</div>
			</div>
		    <div class="pure-u-sm-1 pure-u-1-3">
				<div class="box">
		    		<h2><i class="fa fa-search"></i>Search contact</h2>
		    		<form class="pure-form">
		    			<fieldset class="pure-group">
					    	<input type="text" class="pure-input-1-2" id="keyWord" required>
					     </fieldset>
					    <button type="button" onclick="searchContact($('#keyWord').val());" class="pure-button pure-input-1-2 pure-button-primary">
					    <i class="fa fa-search"></i>Search</button>
					</form>
				</div>
			</div>
			<div class="pure-u-sm-1 pure-u-1-3">
				<div class="box">
		    		<h2><i class="fa fa-users"></i> Contacts</h2>
	    			<table class="pure-table" style="overflow:scroll; height:100px;">
					    <thead>
					        <tr>
					            <th>First Name</th>
					            <th>Last Name</th>
					            <th>Phone</th>
					        </tr>
					    </thead>

					    <tbody id="contactTable"></tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>