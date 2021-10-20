<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Katalog</title>
</head>
<style>
	@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;700&display=swap');
	*{
		font-family: 'Montserrat', sans-serif;
	}
	body{
		width: 100%;
		height: 100%;
	}
	#wrap{
		width: 70%;
		margin: auto;
		text-align: center;
		color: #34495e;
	}
	table{
		margin: auto;
		border-spacing: 0px;
		border-collapse: separate;
		color: #34495e;
	}
	th,td{
		padding: 20px;
		text-align: center;
	}
	th{
		background-color: #34495e;
		color: #ecf0f1;
	}
	button{
		width: 70px;
		padding: 5px 0px;
	}
	.addNew{
		width: 150px;
	}
</style>
<body>
<div id="wrap">
	<h1>Katalog</h1>
	<form>
	<select name="kategorie" onchange="this.form.submit()">
		<option selected value="">---</option>
		<option name="test" value="Moto">Moto</option>
		<option value="Notebooky">Notebooky</option>
		<option value="Retro">Retro</option>
	</select>
		<a href="/">
			<input type="button" value="Odebrat filtry">
		</a>
	</form>
	<table border="1">
			<tr>
				<th>Id</th>
				<th>Kategorie</th>
				<th>Text</th>
				<th>Cena</th>
				<th>Edit</th>
				<th>Heslo</th>
			</tr>
		<c:forEach var="p" items="${inzeraty}">
			<tr>
				<td>${p.id }</td>
				<td align="right">
						${p.kategorie }
				</td>
				<td align="center">
						${p.text }
				</td>
				<td align="right"> 
				<fmt:formatNumber pattern="#,##0.00 Kč" value="${p.cena }"/>
				</td>
				<td>
					<a href="inzeraty/add?id=${p.id}"><button>Edit</button></a>
				</td>
				<td>
					${p.hesloProUpravu}
				</td>


			</tr>
		</c:forEach>
	</table>
	<h1></h1>
	<a href="inzeraty/add"><button class="addNew">Přidat inzerát</button></a>

	<!--[<a href="sprava.do">Správa katalogu</a>]<br/>-->
</div>
</body>
</html>