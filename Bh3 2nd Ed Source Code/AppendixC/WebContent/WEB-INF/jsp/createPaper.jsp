<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <head><title>Create Paper - Spring/Hibernate Application</title></head>
   <body>
      <h1>Create a New Paper</h1>
      <form action="createPaper.do" method="post">
        <spring:bind path="paperForm.title">
        	${status.errorMessage}<br />
      		<input type="text" name="title" value="${status.value}"/>
        </spring:bind>
      	<input type="submit" name="command" value="Create"/>
      </form>
   </body>
</html>