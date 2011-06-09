<%-- 
    Document   : index
    Created on : 25.05.2011, 17:59:12
    Author     : MacYser
--%>

<%@page contentType="text/html" 
		pageEncoding="UTF-8" 
		session="true"
		errorPage="WEB-INF/jspf/error.jsp"
		isErrorPage="true"
		%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>jProject</title>
		<link rel="stylesheet" href="style.css" type="text/css" />
		<%@include file="WEB-INF/jspf/javascript.jsp" %>
    </head>
    <body>
        <div id="banner">
<!--BANNER-->
			<a href="/jProject/">
				<img id="logo" src="images/logo_red.png" alt="jProject"/>
			</a>
<!--BANNER-END-->	
		</div>
		
		<div id="outercontainer" >
			<div id="navbarback">
<!--NAVBARBACK-->
				<%@include file="WEB-INF/jspf/login.jsp" %>
<!--NAVBARBACK-END-->			
			</div>
			<div id="container" >
				<div id="navi" >
	<!--NAVI-->
			 		<a class="buttonleft" href="/jProject/">Projekte</a>
			 		<a class="buttonleft" href="/jProject/">Content</a>
			 		<a class="buttonleft" href="/jProject/">Wiki</a>
	<!--NAVI-END-->
				</div>
				<div id="outer" >
			 		<div id="inner">
			 			<div id="left" >
	<!--LEFT-->
							<jsp:include page='WEB-INF/jspf/leftnavi.jsp' />	
	<!--LEFT-END-->
			   			</div>
	<!--RIGHT-->		<!--<div id="right" >
	
							<h2>Menue rechts</h2>-->
	<!--RIGHT-END-->
						</div>
						
						<div id="content" >
	<!--CONTENT-->
							<%//Wenn nicht eingeloggt => Startseite%>
							<c:choose>

								<c:when test="${sessionScope.aktUser != null}">
									<%//Wenn kein ContentFile => Projectuebersicht%>
									<c:choose>
										<c:when test="${contentFile != null}">
											<jsp:include page='<%= "WEB-INF/jspf/"+(String)request.getAttribute("contentFile") %>' />
										</c:when>
										<c:otherwise>
											Projectübersicht!
										</c:otherwise>
									</c:choose>

								</c:when>
								<c:when test="${triedLogin == true}">
									<%//Wenn kein ContentFile => Projectuebersicht%>
									<jsp:include page='WEB-INF/jspf/error.jsp' />

								</c:when>
								<c:otherwise>
									<jsp:include page='WEB-INF/jspf/welcome.jsp' />
								</c:otherwise>
							</c:choose>		
	<!--CONTENT-END-->
						</div>
					</div><!--end inner -->
				</div><!--end outer -->
	<!--FOOTER-->		
			 	<div id="footer">
			 	</div>
			
			</div><!--end container-->
		</div><!--end outercontainer-->
		<div id="impressum">
	<!--IMPRESSUM-->	
			<jsp:include page='WEB-INF/jspf/impressum.jsp' />
	<!--IMPRESSUM-->	
		</div>
    </body>
</html>
