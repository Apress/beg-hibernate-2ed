<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <head><title>View Papers - Spring/Hibernate Application</title></head>
   <body>
      <h1>Available Papers</h1>
      <c:forEach var="paper" items="${papers}">
         <h2><a href="viewArticles.do?paper=${paper.id}">${paper.title}</a></h2>
         
		 <ul>
			 <c:forEach var="article" items="${paper.articles}">
	         	<li>${article.headline} <i>by ${article.byline}</i></li>
	      	 </c:forEach>
      	 </ul>

      </c:forEach>
      <hr />
      <p><a href="createPaper.do">Create a New Paper</a></p>
   </body>
</html>