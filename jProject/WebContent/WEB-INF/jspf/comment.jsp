<%-- 
    Document   : comment
    Created on : 20.06.2011, 23:28:45
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
hallo 
<!--
<div id='comment'>
	<div id='commentheader'>
		<h1>"+ comment.id +" | "+ comment.user +"
			<div id='commentbuttons'>
				<a href='${aktServlet}?do=UpdateComment&commentId="+comment.id+"'>
					<img src='../../../images/update.png' alt='update' />
				</a>
				<a href='${aktServlet}?do=DeleteComment&commentId="+comment.id+"'>
					<img src='../../../images/delete.png' alt='delete' />
				</a>
			</div>
		</h1>
	</div>
	<div id='commentbody'>
		<form method='POST' action='${aktServlet}'>
			<textarea name='entry' cols='75' rows='15' readonly="+((comment.user != '${aktUser}') || ('${isAllowedUpdateCommentAction}' != 'true'))+">
				"+ comment.entry +"
			</textarea>
		</form>
	</div>
</div>"
-->