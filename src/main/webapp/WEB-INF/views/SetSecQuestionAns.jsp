<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question Ans</title>
</head>
<body>
	<h2>SetSecQuestionAns</h2>



	<form method="post" action="savequestionans">
		Question : <select name="question">
			<option value="Your school name">Your school name</option>
			<option value="First Bank Who Provide CreditCard">First Bank
				Who Provide CreditCard</option>
			<option value="First Job Company Name">First Job Company
				Name</option>
		</select> <br>
		<br> Ans : <input type="text" name="ans"><br>
		<br> <input type="submit" value="SetQuestion" />
	</form>
	<br>
	<br>
	<h3>Current Security Question Ans</h3>
	<table border="1">
		<tr>
			<th>Question</th>
			<th>Ans</th>
		</tr>
		<c:forEach items="${allQuestions}" var="q">
			<tr>
				<td>${q.question }</td>
				<td>${q.ans}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>