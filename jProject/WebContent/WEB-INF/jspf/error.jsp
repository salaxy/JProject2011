<%-- 
    Document   : error
    Created on : 07.06.2011, 18:45:01
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<center>
	<h1><%@include file="layout/stickyRed.jsp" %>ERROR!</h1><br />
	${errorString}
	<br /><br /><a href="javascript:history.back()">zur&#252;ck</a>
</center>