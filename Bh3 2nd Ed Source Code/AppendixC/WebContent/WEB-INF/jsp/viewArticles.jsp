<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <head><title>View Paper - Spring/Hibernate Application</title></head>
   <body>
      <h1>${paper.title}</h1>
      <c:forEach var="article" items="${paper.articles}">
         <h2>${article.headline}</h2>
         <i>By ${article.byline}</i><br />
         <p>${article.content}</p>
      </c:forEach>
      <hr />
      <p><a href=".">List all Papers</a> <a href="createArticle.do?paperId=${paper.id}">Create a New Article</a></p>
   </body>
</html>