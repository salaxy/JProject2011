<%-- 
    Document   : index
    Created on : 25.05.2011, 17:59:12
    Author     : MacYser
--%>

<%@page contentType="text/html" 
		pageEncoding="UTF-8" 
		session="true"
		errorPage="WEB-INF/jspf/contenterror.jsp"
		isErrorPage="true"
		%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>jProject</title>
		<link rel="stylesheet" href="style.css" type="text/css" />
			

		<%@include file="WEB-INF/jspf/layout/javascript.jsp" %>
    </head>
    <body>
        <div id="banner">
<!--BANNER-->
			<a href="/jProject/">
				<img id="logo" src="images/logo_red_alpha.png" alt="jProject"/>
			</a>
<!--BANNER-END-->	
		</div>
		
		<div id="outercontainer" >
			<div id="navbarback">
<!--NAVBARBACK-->
				<%@include file="WEB-INF/jspf/layout/login.jsp" %>
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
							<jsp:include page='WEB-INF/jspf/layout/leftnavi.jsp' />	
	<!--LEFT-END-->
			   			</div>
	<!--RIGHT-->		<!--<div id="right" >
	
							<h2>Menue rechts</h2>-->
	<!--RIGHT-END-->
						</div>
						
						<div id="content" >
	<!--CONTENT-->
							
							<jsp:include page='WEB-INF/jspf/layout/content.jsp' />
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
			<jsp:include page='WEB-INF/jspf/layout/impressum.jsp' />
	<!--IMPRESSUM-->	
		</div>
    </body>
</html>
