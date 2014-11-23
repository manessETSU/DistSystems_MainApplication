<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*,db.*"%>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test</title>
</head>
<body>

Test page
<%
Connection conn = MySQL.connect();
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("Select * from patient_info.patient");
%>
<script type="text/javascript">
function editRecord(id){
	url="EditRecord";
	window.location.href="http://127.0.0.1:9081/WebsphereTest/"+url+"?id="+id;	
}

function deleteRecord(id){
	url="DeleteRecord";
	window.location.href="http://127.0.0.1:9081/WebsphereTest/"+url+"?id="+id;	
}
</script>
<form method="post" action="insertData">
<table>
<tr><td>Id:</td><td><input type="text" name="id"></td></tr>
<tr><td>First Name:</td><td><input type="text" name="first_name"></td></tr>
<tr><td>Last Name:</td><td><input type="text" name="last_name"></td></tr>
<tr><td>Date of Birth:</td><td><input type="text" name="dob"></td></tr>

<tr><td></td><td><input type="submit" value="Submit"></td></tr>
</table>
</form>
Patients:
<table>
<% 
while(rs.next()){	
%>	
	<tr>	
		<td><%=rs.getString(1)%></td>
		<td><%=rs.getString(2) %></td>
		<td><%=rs.getString(3) %></td>
		<td><%=rs.getString(4) %></td>
		<% String edit = "http://127.0.0.1:9081/WebsphereTest/editData?id=" + rs.getString(1); %>
		<td><a href="<%= edit %>">Edit</a></td>
		<% String delete = "http://127.0.0.1:9081/WebsphereTest/deleteData?id=" + rs.getString(1); %>
		<td><a href="<%= delete %>">Delete</a></td>		
	</tr>
	
<%
}
%>
</table>
<% 
MySQL.close(conn);
%>
</body>
</html>