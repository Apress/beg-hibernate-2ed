<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <head><title>Create Article - Spring/Hibernate Application</title></head>
   <body>
      <h1>Create a New Article</h1>
      <p>For the ${paper.title}</p>
      <form action="createArticle.do" method="post">
      	<input type="hidden" name="paperId" value="${paper.id}"/>
        <spring:bind path="articleForm.headline">
        	${status.errorMessage}<br />
	      	<i>Headline: </i><input type="text" name="headline" value="${status.value}"/><br />
        </spring:bind>
        <spring:bind path="articleForm.byline">
        	${status.errorMessage}<br />
	      	<i>By: </i><input type="text" name="byline" value="${status.value}"/><br />
        </spring:bind>
        <spring:bind path="articleForm.content">
        	${status.errorMessage}<br />
			<textarea name="content">${status.value}</textarea><br />
        </spring:bind>
      	<input type="submit" name="command" value="Create"/><br />
      </form>
   </body>
</html>
