<%-- 
    Document   : addMember
    Created on : 15.06.2011, 17:23:26
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h2>Neuen Member hinzufügen</h2><br />
<form method="POST" action="JProjectServlet">
	<input name="do" value="AddMember" type="hidden" />
	<input value="MemberLoginName" name="loginName" type="text" size="20" maxlength="30"><br />
	<input value="Add" type="submit" />
	<!--
	req.getParameter("userLoginName"), 
	req.getParameter("projectName"), 
	req.getParameter("rolle")
	-->
</form>
