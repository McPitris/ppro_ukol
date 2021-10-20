<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Detail položky</title>
</head>
<style>
	@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;700&display=swap');
	*{
		font-family: 'Montserrat', sans-serif;
	}
	body{
		width: 100%;
	}
	.err {
		color : red;
	}
	div{
		width: 70%;
		margin: auto;
		text-align: center;
	}
	table{
		margin: auto;
	}
	input[type="submit"]{
		width: 200px;
		height: 30px;
	}

</style>
<body>
<div>
	<h1>Detail položky</h1>
	<%--@elvariable id="inzerat" type="cz"--%>
	<form:form modelAttribute="inzerat">
		<table>

			<tr>
				<td>Kategorie</td>
				<td>

				<form:select path="kategorie">
						<form:option value="Moto">Moto</form:option>
						<form:option value="Notebooky">Notebooky</form:option>
						<form:option value="Retro">Retro</form:option>
				</form:select>
				</td>
				<td><form:errors path="kategorie" cssClass="err"/></td>
			</tr>
			<tr>
				<td>Text</td>
				<td><form:input path="text" size="10"/> Kč</td>
				<td><form:errors path="text" cssClass="err"/></td>
			</tr>
			<tr>
				<td>Cena</td>
				<td><form:input path="cena" size="5"/> %</td>
				<td><form:errors path="cena" cssClass="err"/></td>
			</tr>
			<tr>
				<td>
					<span style="color:red">Zadej heslo pro správu inzerátu:</span>
				</td>
				<td>
					<input type="text" name="heslo" id="pw">
				</td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<input type="submit" value="Uložit"/>	
				</td>
				<td colspan="3" align="center">

				</td>
			</tr>
		</table>
	</form:form>
</div>
</body>
</html>