<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="table">
		<thead>
			<tr>
				<th>Name</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="party_option" items="${party_options}">
				<tr>
					<td>${party_option.name}</td>
					<td>${party_option.description }</td>
					<td>${party_option.votes }</td>
					<td><a href="/addVote?id=${party_option.id }">Vote here</a></td>
					<td><a class="btn btn-danger"
						href="/delete?id=${party_option.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>Add a Pizza!</p>
	<form action="/addPizza" method="post">
		<label for="name">Pizza name:</label> <input type="text" id="name"
			name="name"><br>
		<br> <label for="description">Toppings:</label> <input type="text"
			id="description" name="description"><br>
		<br> <input type="submit" value="Submit">
	</form>
	<a href="/">home</a>
</body>
</html>