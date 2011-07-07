<%-- 
    Document   : showUserInfo
    Created on : 09.06.2011, 21:33:09
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="topcontent">
	<h1>${user}´s Info</h1>
</div>

<div id="contentcontentbig">	
	<div id="infoBoxBig">
		<h3>User Info</h3>
		<jsp:include page="../showUserInfo.jsp" />
	</div>
	
	<div id="rightBox">
		<c:choose>
			<c:when test="${sessionScope.isAllowedShowUserSettings == true}">
				<form method="POST" action="${sessionScope.aktServlet}">
					<input name="do" value="ShowUserSettings" type="hidden" />
					<input name="loginName" value="${user}" type="hidden" />
					<input value="Bearbeiten" type="submit" />
			</c:when>
		</c:choose>
	</div>
					
	<div id="rightBox">
		<!--TODO REALISIERUNG-->
		<c:choose>
			<c:when test="${sessionScope.isAllowedDeleteUser == true}">
				<form method="POST" action="${sessionScope.aktServlet}">
					<input name="do" value="DeleteUser" type="hidden" />
					<input name="loginName" value="${user}" type="hidden" />
					<input value="Löschen" type="submit" />
			</c:when>
		</c:choose>
	</div>
</div>


<div id="footercontent">
	
</div>

