<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<div>
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Number of Guests</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="party" items="${parties}">
					<tr>
						<td>${party.name}</td>
						<td>${party.date }</td>
						<td>${party.rsvps.size() }</td>
						<td><a href="/details?id=${party.id}">Details</a>
						<td><a class="btn btn-danger" href="/delete?id=${party.id}">Delete</a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<h2>RSVP below!</h2>
	<form action="/addRsvp" method="post">
		<label>Attendee</label> <input type="text" required name="attendee">
		<label>Comment</label> <input type="text" name="comment">
		
		<div>
			<label>Select a Party</label> <select name="party">
				<c:forEach var="party" items="${parties}">

					<option value="${party.id}">
						<c:out value="${party.name}" />
					</option>

				</c:forEach>
			</select>
		</div>
		<button type="submit" class="btn btn-warning">RSVP</button>
	</form>
	<footer>
		<p>
			<a href="/vote">Vote here</a>
		</p>
		<p>
			<a href="/review">Standings</a>
		</p>
	</footer>
</body>
</html>