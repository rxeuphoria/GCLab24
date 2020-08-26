<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>review</title>
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
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>