<%-- 
    Document   : comment
    Created on : 20.06.2011, 23:28:45
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
hallo 
<form method='POST' action='${aktServlet}'>
	<input name='do' value='UpdateComment' type='hidden' />
	<input name='commentId' value='"+comment.id+"' type='hidden' />
	<div id='comment'>
		<div id='commentheader'>
			<h1>"+ comment.id +" | "+ comment.user +"
				<div id='commentbuttons'>
					<form method='POST' action='${aktServlet}'>
						<input name='do' value='DeleteComment' type='hidden' />
						<input name='commentId' value='"+comment.id+"' type='hidden' />
						<input value='Delete' type='submit' >
							<img src='../../../images/delete.png' alt='delete' />
						</input>
					</form>
					<input value='Update' type='submit'>
						<img src='../../../images/update.png' alt='update' />
					</input>
				</div>
			</h1>
		</div>
		<div id='commentbody'>
			<textarea name='entry' cols='75' rows='15'>
				"+ comment.entry +"
			</textarea>
		</div>
	</div>
</form>