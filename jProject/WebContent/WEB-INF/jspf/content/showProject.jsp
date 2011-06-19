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
	
	<div id="infoBoxBig">
		<!--TODO OUTSOURCING SHOWPROJECTINFO-->
		<h3>Project Info</h3>
		<fieldset>
			<legend>Projekt Info</legend>
			<table border="0" cellspacing="3">
				<tbody>
					<tr>
						<td>Anzahl Member:</td>
						<td>${anzMember}</td>
					</tr>
					<tr>
						<td>Anzahl Dokumente:</td>
						<td>${anzDocu}</td>
					</tr>
					<tr>
						<td>Anzahl Sourcecodes:</td>
						<td>${anzSource}</td>
					</tr>
					<tr>
						<td>Anzahl Tasks:</td>
						<td>${anzTask}</td>
					</tr>
				</tbody>
			</table>
		</fieldset>
	</div>
	
	<div id="rightBox">
		<jsp:include page='../addMember.jsp' />
	</div>
	
	<br />
	<div id="rightBox">
		<!--TODO OUTSOURCING DELETEMEMBER-->
		<c:choose>
			<c:when test="${aktServlet != 'AdminServlet'}">
				<form method="POST" action="${sessionScope.aktServlet}">
					<input name="do" value="DeleteMember" type="hidden" />
					<input name="loginName" value="${sessionScope.aktUser}" type="hidden" />
					<input value="Eigene Mitgliedschaft beenden" type="submit">
				</form>
			</c:when>
		</c:choose>
	</div>
	
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
	<h1>${member.user}</h1>
	<div id="infoBoxSmall">
		<c:choose>
			<c:when test="${sessionScope.isAllowedAddMember == true}">
				<h3>Einstellungen eines Members ändern</h3>
				<fieldset>
					<legend>Einstellungen dieses Members ändern</legend>
					<form method="POST" action="${sessionScope.aktServlet}">
						<input name="do" value="AddMember" type="hidden" />
						<input name="loginName" value="${member.user}" type="hidden" />
						<table border="0" cellspacing="3">
							<tbody>
								<tr>
									<td>
										<label for="rolle">Rolle:</label><br />
										<input name="rolle" value="${member.projectRole}" type="text" size="20" maxlength="30" />
									</td>
								</tr>
								<tr>
									<td>
										<input value="Einstellungen ändern" type="submit">
									</td>
								</tr>
							</tbody>
						</table>
					</form>
				</fieldset>
			</c:when>
		</c:choose>
	</div>
	<div id="rightBox">
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
</div>

<div id="footercontent">
	
	<input value="Show Comments" type="button" onclick="getShowAllComments41ProjectJSON('${project.name}');" />
	<div id="allComments41Project">
		
	</div>
</div>
