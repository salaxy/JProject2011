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
						
<h3>Neuen Comment hinzufügen<input type='checkbox' onclick='showHideText(this,'addBox');' /></h3>
<fieldset id='addBox' style='display:none;'>
	<legend>Neuen Comment hinzufügen</legend>
	<form method='POST' action='${sessionScope.aktServlet}'>
		<input name='do' value='CommentProject' type='hidden' />
		<input name='projectName' value='${aktProject}' type='hidden' />
		<table border='0' cellspacing='3'>
			<tbody>
				<tr>
					<td>
						<label for='entry'>Comment:</label><br />
						<textarea name='entry' cols='75' rows='1'>Comment</textarea>
					</td>
				</tr>
				<tr>
					<td>
						<input value='Add' type='submit' />
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</fieldset>


<div id='comment'>\n\
	<h1>"+ comment.id +" | "+ comment.user +"\
		<form method='POST' action='${aktServlet}'>\n\
			<input name='do' value='DeleteComment' type='hidden' />\n\
			<input name='commentId' value='"+comment.id+"' type='hidden' />\n\
			<input value='Delete' type='submit' >\n\
				<img src='../../../images/delete.png' alt='delete' />\n\
			</input>\n\
		</form>\n\
	</h1>\n\
	<form method='POST' action='${aktServlet}'>\n\
		<input name='do' value='UpdateComment' type='hidden' />\n\
		<input name='commentId' value='"+comment.id+"' type='hidden' />\n\
		<textarea name='entry' cols='75' rows='4'>"+ comment.entry +"</textarea>\n\
		<input value='Update' type='submit'>\n\
			<img src='../../../images/update.png' alt='update' />\n\
		</input>\n\
	</form>\n\
</div>\n\