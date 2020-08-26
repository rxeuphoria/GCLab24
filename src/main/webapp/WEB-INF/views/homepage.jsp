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
					<th>Name</th><th>Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="party" items="${parties}">
					<tr>
						<td>${party.name}</td>
						<td>${party.date }</td>
						<td><a class="btn btn-danger" href="/delete?id=${party.id}">Delete</a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<footer>
	<p><a href="/vote">Vote here</a></p>
	<p><a href="/review">Standings</a></p>
	</footer>
</body>
</html>