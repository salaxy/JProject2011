<%-- 
    Document   : index
    Created on : 25.05.2011, 17:59:12
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>jProject</title>
		<link rel="stylesheet" href="style.css" type="text/css" />
		<script type="text/javascript">
			
			function updateShowProjectList(json){
				var newContent = '';
				//alert(json);
				json.project(function(project){
					newContent += project.name+' - '+project.status+"<br/>";
				});
				$('targetBox').set('html', newContent);
			}
			function getShowProjectJSON(projectName){
				var jsonRequest = new Request.JSON({
					url: "JProjectServlet?do=ShowProject&projectName="+projectName,
					onComplete: updateShowProjectList
				}).get({'projectName':projectName});
			}
			/*
			function updateSongList(json){
				var newContent = '';
				//alert(json);
				json.songs.each(function(song){
					newContent += song.nr+' - '+song.titel+"<br/>";
				});
				$('targetBox').set('html', newContent);
			}
			function getSongsHTML(cdid){
				var songRequest = new Request.HTML({
					url: "fernbedienung?do=ajax",
					update: $('targetBox')
				}).get({'cdid': cdid});
			}
			function getSongsJSON(cdid){
				var jsonRequest = new Request.JSON({
					url: "fernbedienung?do=ajax",
					onComplete: updateSongList
				}).get({'cdid': cdid});
			}
	 *
	 */
		</script>
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
				<%@include file="WEB-INF/login.jspf" %>
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
							<h2><img src="images/sticky_red.png" alt="" height="15" width="15">
							</img>Projekte</h2>
							<div id="projects">
								<%@include file="WEB-INF/showAllOwnProjects.jspf" %>
							</div>
							<br /><br />
							<h2><img src="images/sticky_red.png" alt="" height="15" width="15">
							</img>Weitere<br />Funktionen</h2>
	<!--LEFT-END -->
			   			</div>
	<!--RIGHT -->		<!--<div id="right" >
	
							<h2>Menue rechts</h2>
	
						</div>--><!--RIGHT-END -->
						
						<div id="content" >
	<!--CONTENT -->
							<c:choose>
								<c:when test="${sessionScope.loggedIn == true}">
								<%@include file="WEB-INF/jspf/${contentFile}" %>
								</c:when>
								<c:otherwise>
									WelcomePage! About!
								</c:otherwise>
							</c:choose>
							<!--<br />
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
								</p>-->
								
							
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
