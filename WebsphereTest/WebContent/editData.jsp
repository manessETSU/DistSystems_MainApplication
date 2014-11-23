<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% ResultSet res = (ResultSet) request.getAttribute("EditData"); %>
<%while( res.next()){ %>
<form method="post" action="updateData">
<table>
<tr><td>Id:</td><td><input type="text" name="id" value=<%=res.getString("id") %>></td></tr>
<tr><td>First Name:</td><td><input type="text" name="first_name"  value=<%=res.getString("first_name")%>></td></tr>
<tr><td>Last Name:</td><td><input type="text" name="last_name"  value=<%=res.getString("last_name")%>></td></tr>
<tr><td>Date of Birth:</td><td><input type="text" name="dob"  value=<%=res.getString("dob")%>></td></tr>

<tr><td></td><td><input type="submit" value="Update" value="update"></td></tr>
</table>
</form>
<%} %>
</body>
</html>