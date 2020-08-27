<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>details</title>
</head>
<body>
	<c:out value="${party.name}" />
	<c:out value="${party.date}" />
	<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="rsvp" items="${party.rsvps}">
					<tr>
						<td>${rsvp.attendee}</td>
						<td>${rsvp.comment}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>