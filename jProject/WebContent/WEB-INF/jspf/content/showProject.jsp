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
		<jsp:include page='../showProjectInfo.jsp' />
	</div>
	
	<div id="rightBox">
		<jsp:include page='../addMember.jsp' />
	</div>
	
	<br />
	<div id="rightBox">
		<jsp:include page='../selfdeleteMember.jsp' />
	</div>
	
	<br />
</div>

<div id="leftcontent">
	<h1>Member</h1>
	<jsp:include page='../showAllMember.jsp' />
</div>
<div id="contentcontentsmall">
	
	<h1>${member.user}</h1>
	
	<div id="rightBox">
		<jsp:include page='../deleteMember.jsp' />
	</div>
	<div id="infoBoxSmall">
		<h3>User Info</h3>
		<jsp:include page='../showMemberInfo.jsp' />
	</div>
	<div id="infoBoxSmall">
		<jsp:include page='../changeMemberSettings.jsp' />
	</div>
</div>

<div id="footercontent">
	<div id="allComments41Project">
		<input value="Show Comments" type="button" onclick="getShowAllComments41ProjectJSON('${project.name}');" />
	</div>
</div>
