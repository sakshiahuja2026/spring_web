<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Profile</title>
</head>
<body>
	<h2>Profile Images</h2>
	<table border="1">

		<tr>
			<th>Image</th>
			<th>Action</th>
		</tr>

		<c:forEach items="${profiles }" var="p">
			<tr>
				<td><img src="${p.imgUrl}" height="200px" width="200px" /></td>
				<td><a href="deleteprofile?profileId=${p.profileId}">Delete</a>
			</tr>

		</c:forEach>
	</table>

</body>
</html>