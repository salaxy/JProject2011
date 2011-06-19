<%-- 
    Document   : showProject
    Created on : 07.06.2011, 18:40:08
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="topcontent">
	<jsp:include page='projectheader.jsp' />
</div>

<div id="contentcontentbig">
	<h1>${project}</h1>
	<table >
		<tr>
			<td width="500">
				Anzahl Member: ${anzMember}<br />
				Anzahl Dokumente: ${anzDocu}<br />
				Anzahl Sourcecodes: ${anzSource}<br />
				Anzahl Tasks: ${anzTask}<br />
			</td>
			<td>
				<jsp:include page='../addMember.jsp' />
			</td>
		</tr>
	</table>
	<br />
	<!--TODO IF NOT aktServlet == AdminServlet-->
	<form method="POST" action="${sessionScope.aktServlet}">
		<input name="do" value="DeleteMember" type="hidden" />
		<input name="loginName" value="${sessionScope.aktUser}" type="hidden" />
		<input value="Eigene Mitgliedschaft beenden" type="submit">
	</form>
	<br />
</div>

<div id="leftcontent">
	<!--TODO OUTSOURCING SHOWALLMEMBER-->
	<h1>Member</h1>
	<c:forEach items="${memberList}" var="member" varStatus="i">
		<a href="${sessionScope.aktServlet}?do=ShowProject&projectName=${sessionScope.aktProject}&loginName=${member.user}">(${member.projectRole}) ${member.user}</a><br>
	</c:forEach>
</div>
<div id="contentcontentsmall">
	
	<!--TODO OUTSOURCING SHOWMEMBER-->
	<h1>${member.user} | Rolle: ${member.projectRole}</h1>
	
	<c:choose>
		<c:when test="${sessionScope.isAllowedAddMember == true}">
			<form method="POST" action="${sessionScope.aktServlet}">
				<input name="do" value="AddMember" type="hidden" />
				<input name="loginName" value="${member.user}" type="hidden" />
				<input name="rolle" value="Rolle" type="text" size="20" maxlength="30" />
				<input value="Rechte dieses Members bearbeiten" type="submit">
			</form>
		</c:when>
	</c:choose>
	<br />
	<c:choose>
		<c:when test="${sessionScope.isAllowedDeleteMember == true}">
			<form method="POST" action="${sessionScope.aktServlet}">
				<input name="do" value="DeleteMember" type="hidden" />
				<input name="loginName" value="${member.user}" type="hidden" />
				<input value="Diesen Member löschen" type="submit">
			</form>
		</c:when>
	</c:choose>
	
</div>

<div id="footercontent">
	
	<input value="Show Comments" type="button" onclick="getShowAllComments41ProjectJSON('${project.name}');" />
	<div id="allComments41Project">
		
	</div>
</div>
