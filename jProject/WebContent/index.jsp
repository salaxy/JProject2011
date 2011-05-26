<%-- 
    Document   : index
    Created on : 25.05.2011, 17:59:12
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>jProject</title>
		<link rel="stylesheet" href="style.css" type="text/css" />
    </head>
    <body>
        <div id="banner">
<!--BANNER-->
			
	
			<a href="#">
				<img id="logo" src="images/logo_red.png" alt="jProject"/>
			</a>
<!--BANNER-END -->	
		</div>
		
		<div id="outercontainer" >
			<div id="navbarback">
<!--NAVBARBACK -->
<c:if test="${loggenIn == true}">
				<form class="buttonright" method="GET" action="JProjectServlet">
					
					<input name="do" value="Login" type="submit">
					<input value="Benutzername" name="loginName"	type="text"		size="15" maxlength="50">
					<input value="Password"		name="password"		type="password" size="10" maxlength="30">
					
					
				</form>
</c:if><c:otherwise>
				Hallo ${aktUser.getLoginName()}
</c:otherwise>
<!--NAVBARBACK-END -->			
			</div>
			<div id="container" >
				<div id="navi" >
	<!--NAVI -->
			 		<a class="buttonleft" href="#">Projekte</a>
			 		<a class="buttonleft" href="#">Content</a>
			 		<a class="buttonleft" href="#">Wiki</a>
	<!--NAVI-END -->
				</div>
				<div id="outer" >
			 		<div id="inner">
			 			<div id="left" >
	<!--LEFT -->
			 				<h2>Menue links</h2>
			 				<!--
							<p>
								<a href="http://validator.w3.org/check?uri=http%3A%2F%2Fintensivstation.ch%2Ffiles%2Ftemplates%2F2%2Ftemplate-3.html">
									<img src="http://www.intensivstation.ch/files/WEB-INF/images/buttons/xhtml10.gif" alt="" width="80" height="15" border="0"/>
								</a>
								<br/>
								<a href="http://jigsaw.w3.org/css-validator/validator?uri=http%3A%2F%2Fintensivstation.ch%2Ffiles%2Ftemplates%2F2%2F3.css&warning=2&profile=css2&usermedium=all">
									<img src="http://www.intensivstation.ch/files/WEB-INF/images/buttons/css.gif" alt="" width="80" height="15" border="0"/>
								</a>
								<br />
							-->
	<!--LEFT-END -->
			   			</div>
<!--RIGHT -->			<!--<div id="right" >
	
							<h2>Menue rechts</h2>
	
						</div>--><!--RIGHT-END -->
						
						<div id="content" >
	<!--CONTENT -->
							<br />
							<h1>Content</h1>
								<p>
									Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.
									<br /><br /><a href="javascript:history.back()">zur&#252;ck</a>
								</p>
							<h1>Content</h1>
								<p>
									Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.
									<br /><br /><a href="javascript:history.back()">zur&#252;ck</a>
								</p>
							<h1>Content</h1>
								<p>
									Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.
									<br /><br /><a href="javascript:history.back()">zur&#252;ck</a>
								</p>
								
							
	<!--CONTENT-END -->
						</div><!--end content -->
					</div><!--end inner -->
				</div><!--end outer -->
	<!--FOOTER -->		
			 	<div id="footer">
			 	</div>
			
			</div><!--end container -->
		</div><!--end outercontainer -->
		<div id="impressum">
			<br /><br /><br />
			<p>
			    <a href="http://validator.w3.org/check?uri=referer"><img
			        src="http://www.w3.org/Icons/valid-xhtml11"
			        alt="Valid XHTML 1.1" height="15" width="44" /></a>
			    <a href="http://jigsaw.w3.org/css-validator/check/referer">
			        <img style="border:0;width:44px;height:15px"
			            src="http://jigsaw.w3.org/css-validator/WEB-INF/images/vcss"
			            alt="CSS ist valide!" />
			    </a>
			</p>
			<br /><br />
			Copyright Galileo Press GmbH 2005<br />
			Galileo Press GmbH, Rheinwerkallee 4, 53227 Bonn, Tel.: 0228.42150.0, Fax 0228.42150.77, info@galileo-press.de
		</div>
    </body>
</html>
