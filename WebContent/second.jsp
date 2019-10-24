<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Book ID</th>
					<th scope="col">Book Name</th>
					<th scope="col">Book Author</th>
					<th scope="col">Book Genre</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="z">
					<form action="UserServlet" method="post">
					<tr>
						<input type="hidden" name="bid" value="${z.bookId}"/>
						<th scope="row">${z.bookId}</th>
						<td>${z.bookName}</td>
						<td>${z.bookAuthor}</td>
						<td>${z.bookType}</td>
						<td><input type="submit" class="btn btn-primary btn-block" value="Add Reviews">
						</td>
					</tr>
					</form>
				</c:forEach>
			</tbody>
		</table>
		
		<table class="table">
			<thead class="thead">
				<tr>
					<th scope="col">Book ID</th>
					<th scope="col">Book Name</th>
					<th scope="col">Book Author</th>
					<th scope="col">Book Genre</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="z">
					<form action="ViewAllReviews" method="post">
					<tr>
						<input type="hidden" name="bid" value="${z.bookId}"/>
						<th scope="row">${z.bookId}</th>
						<td>${z.bookName}</td>
						<td>${z.bookAuthor}</td>
						<td>${z.bookType}</td>
						<td><input type="submit" class="btn btn-primary btn-block" value="View all Reviews">
						</td>
					</tr>
					</form>
				</c:forEach>
			</tbody>
		</table>
	</div>


	

		<!-- jQuery library -->
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

		<!-- Latest compiled JavaScript -->
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</body>
</html>