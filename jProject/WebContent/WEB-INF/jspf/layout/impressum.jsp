<%-- 
    Document   : impressum
    Created on : 08.06.2011, 13:43:28
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<br /><br /><br />
<!--
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
-->
<br /><br />
<c:choose>
	<c:when test="${isAdmin == true}">
		<a href="AdminServlet?do=OpenAdminconsole">Adminconsole</a>
	</c:when>
</c:choose>
<br />
Michael Koppen, Vereinsstraße 33a, 14770 Brandenburg an der Havel, Tel.: 1234/56789, Fax 1234/56789, koppen@fh-brandenburg.de<br />
Inhaltlich Verantwortlicher gemäß § 55 Abs. 2 RStV: Michael Koppen<br />
Haftungshinweis: Trotz sorgfältiger inhaltlicher Kontrolle übernehmen wir keine Haftung für die Inhalte externer Links. <br />
Für den Inhalt der verlinkten Seiten sind ausschließlich deren Betreiber verantwortlich.<br />
Des Weiteren übernehmen wir keinerlei Haftung für hochgeladenen Content der Benutzer.<br /><br />
&copy; Michael Koppen, Andy Klay, Tino Reuschel