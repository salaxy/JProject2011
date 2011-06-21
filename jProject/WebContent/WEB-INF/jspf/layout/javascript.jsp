<%-- 
    Document   : javascript
    Created on : 08.06.2011, 13:49:19
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--<script src="js/jquery-1.6.1.min.js"></script>-->
<script src="js/mootools-1.2.1-core.js"></script>
<script type="text/javascript"> 
	var hide = false;

	function showHideText(box, id) {
		var elm = document.getElementById(id)
		elm.style.display = box.checked? "inline":"none"
	} 
	function confirmDeleteMember(){
		check = confirm('Wollen Sie diesen Member wirklich löschen?');
		return check;
	}
	function confirmSelfDeleteMember(){
		check = confirm('Wollen Sie Ihre Mitgliedschaft in diesem Projekt wirklich beenden?');
		return check;
	}
	
	/* CommentDocument AJAX */
	function updateShowAllComments41Document(json){
		var newContent = "\
			<h3>Neuen Comment hinzufügen</h3>\n\
			<fieldset>\n\
				<legend>Neuen Comment hinzufügen</legend>\n\
				<form method='POST' action='${sessionScope.aktServlet}'>\n\
					<input name='do' value='CommentDocu' type='hidden' />\n\
					<input name='documentId' value='${document.id}' type='hidden' />\n\
					<table border='0' cellspacing='3'>\n\
						<tbody>\n\
							<tr>\n\
								<td>\n\
									<label for='entry'>Comment:</label><br />\n\
									<textarea name='entry' cols='75' rows='1'>Comment</textarea>\n\
								</td>\n\
							</tr>\n\
							<tr>\n\
								<td>\n\
									<input value='Add' type='submit' />\n\
								</td>\n\
							</tr>\n\
						</tbody>\n\
					</table>\n\
				</form>\n\
			</fieldset>";
		//alert(json);
		json.comment.each(function(comment){
			newContent+="\
			<form method='POST' action='${aktServlet}'>\n\
				<input name='do' value='UpdateComment' type='hidden' />\n\
				<input name='commentId' value='"+comment.id+"' type='hidden' />\n\
				<div id='comment'>\n\
					<div id='commentheader'>\n\
						<h1>"+ comment.id +" | "+ comment.user +"\
							<div id='commentbuttons'>\n\
								<form method='POST' action='${aktServlet}'>\n\
									<input name='do' value='DeleteComment' type='hidden' />\n\
									<input name='commentId' value='"+comment.id+"' type='hidden' />";
							
			if(comment.isAllowedUpdateCommentAction){
				newContent+="\
									<input value='Delete' type='submit' >\n\
										<img src='../../../images/delete.png' alt='delete' />\n\
									</input>\n\
								</form>\n\
								<input value='Update' type='submit'>\n\
									<img src='../../../images/update.png' alt='update' />\n\
								</input>\n\
							</div>\n\
						</h1>\n\
					</div>\n\
					<div id='commentbody'>\n\
						<textarea name='entry' cols='75' rows='4'>"+ comment.entry +"</textarea>";
			}else{
				newContent+="\
								</form>\n\
							</div>\n\
						</h1>\n\
					</div>\n\
					<div id='commentbody'>\n\
						<textarea name='entry' cols='75' rows='1' readonly>"+ comment.entry +"</textarea>";
			}
			newContent+="\
					</div>\n\
				</div>\n\
			</form>";
		});
		$('allComments41Docu').set('html', newContent);
	}
	function getShowAllComments41DocumentJSON(documentId){
		if(!hide){
			var jsonRequest = new Request.JSON({
				url: "DataServlet?do=ShowAllComments41Docu&documentId="+documentId,
				onComplete: updateShowAllComments41Document
			}).get({'documentId':documentId});
			alert(jsonRequest.toSource());
			hide=true;
		}else{
			$('allComments41Docu').set('html', '');
			hide=false;
		};
	}
	
	/* CommentProject AJAX */
	function updateShowAllComments41Project(json){
		var newContent = "\
			<h3>Neuen Comment hinzufügen</h3>\n\
			<fieldset>\n\
				<legend>Neuen Comment hinzufügen</legend>\n\
				<form method='POST' action='${sessionScope.aktServlet}'>\n\
					<input name='do' value='CommentProject' type='hidden' />\n\
					<input name='projectName' value='${aktProject}' type='hidden' />\n\
					<table border='0' cellspacing='3'>\n\
						<tbody>\n\
							<tr>\n\
								<td>\n\
									<label for='entry'>Comment:</label><br />\n\
									<textarea name='entry' cols='75' rows='1'>Comment</textarea>\n\
								</td>\n\
							</tr>\n\
							<tr>\n\
								<td>\n\
									<input value='Add' type='submit' />\n\
								</td>\n\
							</tr>\n\
						</tbody>\n\
					</table>\n\
				</form>\n\
			</fieldset>";
		//alert(json);
		json.comment.each(function(comment){
			newContent+="\
			<form method='POST' action='${aktServlet}'>\n\
				<input name='do' value='UpdateComment' type='hidden' />\n\
				<input name='commentId' value='"+comment.id+"' type='hidden' />\n\
				<div id='comment'>\n\
					<div id='commentheader'>\n\
						<h1>"+ comment.id +" | "+ comment.user +"\
							<div id='commentbuttons'>\n\
								<form method='POST' action='${aktServlet}'>\n\
									<input name='do' value='DeleteComment' type='hidden' />\n\
									<input name='commentId' value='"+comment.id+"' type='hidden' />";
							
			if(comment.isAllowedUpdateCommentAction){
				newContent+="\
									<input value='Delete' type='submit' >\n\
										<img src='../../../images/delete.png' alt='delete' />\n\
									</input>\n\
								</form>\n\
								<input value='Update' type='submit'>\n\
									<img src='../../../images/update.png' alt='update' />\n\
								</input>\n\
							</div>\n\
						</h1>\n\
					</div>\n\
					<div id='commentbody'>\n\
						<textarea name='entry' cols='75' rows='4'>"+ comment.entry +"</textarea>";
			}else{
				newContent+="\
								</form>\n\
							</div>\n\
						</h1>\n\
					</div>\n\
					<div id='commentbody'>\n\
						<textarea name='entry' cols='75' rows='1' readonly>"+ comment.entry +"</textarea>";
			}
			newContent+="\
					</div>\n\
				</div>\n\
			</form>";
		});
		$('allComments41Project').set('html', newContent);
	}
	function getShowAllComments41ProjectJSON(projectName){
		if(!hide){
			var jsonRequest = new Request.JSON({
				url: "DataServlet?do=ShowAllComments41Project&projectName="+projectName,
				onComplete: updateShowAllComments41Project
			}).get({'projectName':projectName});
		
			hide=true;
		}else{
			$('allComments41Project').set('html', '');
			hide=false;
		};
	}
	
	/* CommentSourcecode AJAX */
	function updateShowAllComments41Source(json){
		var newContent = "\
			<h3>Neuen Comment hinzufügen</h3>\n\
			<fieldset>\n\
				<legend>Neuen Comment hinzufügen</legend>\n\
				<form method='POST' action='${sessionScope.aktServlet}'>\n\
					<input name='do' value='CommentSource' type='hidden' />\n\
					<input name='sourcecodeId' value='${sourcecode.id}' type='hidden' />\n\
					<table border='0' cellspacing='3'>\n\
						<tbody>\n\
							<tr>\n\
								<td>\n\
									<label for='entry'>Comment:</label><br />\n\
									<textarea name='entry' cols='75' rows='1'>Comment</textarea>\n\
								</td>\n\
							</tr>\n\
							<tr>\n\
								<td>\n\
									<input value='Add' type='submit' />\n\
								</td>\n\
							</tr>\n\
						</tbody>\n\
					</table>\n\
				</form>\n\
			</fieldset>";
		//alert(json);
		json.comment.each(function(comment){
			newContent+="\
			<form method='POST' action='${aktServlet}'>\n\
				<input name='do' value='UpdateComment' type='hidden' />\n\
				<input name='commentId' value='"+comment.id+"' type='hidden' />\n\
				<div id='comment'>\n\
					<div id='commentheader'>\n\
						<h1>"+ comment.id +" | "+ comment.user +"\
							<div id='commentbuttons'>\n\
								<form method='POST' action='${aktServlet}'>\n\
									<input name='do' value='DeleteComment' type='hidden' />\n\
									<input name='commentId' value='"+comment.id+"' type='hidden' />";
							
			if(comment.isAllowedUpdateCommentAction){
				newContent+="\
									<input value='Delete' type='submit' >\n\
										<img src='../../../images/delete.png' alt='delete' />\n\
									</input>\n\
								</form>\n\
								<input value='Update' type='submit'>\n\
									<img src='../../../images/update.png' alt='update' />\n\
								</input>\n\
							</div>\n\
						</h1>\n\
					</div>\n\
					<div id='commentbody'>\n\
						<textarea name='entry' cols='75' rows='4'>"+ comment.entry +"</textarea>";
			}else{
				newContent+="\
								</form>\n\
							</div>\n\
						</h1>\n\
					</div>\n\
					<div id='commentbody'>\n\
						<textarea name='entry' cols='75' rows='1' readonly>"+ comment.entry +"</textarea>";
			}
			newContent+="\
					</div>\n\
				</div>\n\
			</form>";
		});
		$('allComments41Source').set('html', newContent);
	}
	function getShowAllComments41SourceJSON(sourcecodeId){
		if(!hide){
			var jsonRequest = new Request.JSON({
				url: "DataServlet?do=ShowAllComments41Source&sourcecodeId="+sourcecodeId,
				onComplete: updateShowAllComments41Source
			}).get({'sourcecodeId':sourcecodeId});
		
			hide=true;
		}else{
			$('allComments41Source').set('html', '');
			hide=false;
		};
	}
	
	/* CommentTask AJAX */
	function updateShowAllComments41Task(json){
		var newContent = "\
			<h3>Neuen Comment hinzufügen</h3>\n\
			<fieldset>\n\
				<legend>Neuen Comment hinzufügen</legend>\n\
				<form method='POST' action='${sessionScope.aktServlet}'>\n\
					<input name='do' value='CommentTask' type='hidden' />\n\
					<input name='taskId' value='${task.id}' type='hidden' />\n\
					<table border='0' cellspacing='3'>\n\
						<tbody>\n\
							<tr>\n\
								<td>\n\
									<label for='entry'>Comment:</label><br />\n\
									<textarea name='entry' cols='75' rows='1'>Comment</textarea>\n\
								</td>\n\
							</tr>\n\
							<tr>\n\
								<td>\n\
									<input value='Add' type='submit' />\n\
								</td>\n\
							</tr>\n\
						</tbody>\n\
					</table>\n\
				</form>\n\
			</fieldset>";
		//alert(json);
		json.comment.each(function(comment){
			newContent+="\
			<form method='POST' action='${aktServlet}'>\n\
				<input name='do' value='UpdateComment' type='hidden' />\n\
				<input name='commentId' value='"+comment.id+"' type='hidden' />\n\
				<div id='comment'>\n\
					<div id='commentheader'>\n\
						<h1>"+ comment.id +" | "+ comment.user +"\
							<div id='commentbuttons'>\n\
								<form method='POST' action='${aktServlet}'>\n\
									<input name='do' value='DeleteComment' type='hidden' />\n\
									<input name='commentId' value='"+comment.id+"' type='hidden' />";
							
			if(comment.isAllowedUpdateCommentAction){
				newContent+="\
									<input value='Delete' type='submit' >\n\
										<img src='../../../images/delete.png' alt='delete' />\n\
									</input>\n\
								</form>\n\
								<input value='Update' type='submit'>\n\
									<img src='../../../images/update.png' alt='update' />\n\
								</input>\n\
							</div>\n\
						</h1>\n\
					</div>\n\
					<div id='commentbody'>\n\
						<textarea name='entry' cols='75' rows='4'>"+ comment.entry +"</textarea>";
			}else{
				newContent+="\
								</form>\n\
							</div>\n\
						</h1>\n\
					</div>\n\
					<div id='commentbody'>\n\
						<textarea name='entry' cols='75' rows='1' readonly>"+ comment.entry +"</textarea>";
			}
			newContent+="\
					</div>\n\
				</div>\n\
			</form>";
		});
		$('allComments41Task').set('html', newContent);
	}
	function getShowAllComments41TaskJSON(taskId){
		if(!hide){
			var jsonRequest = new Request.JSON({
				url: "DataServlet?do=ShowAllComments41Task&taskId="+taskId,
				onComplete: updateShowAllComments41Task
			}).get({'taskId':taskId});
		
			hide=true;
		}else{
			$('allComments41Task').set('html', '');
			hide=false;
		};
	}
	
	
	
	/* jQuery AJAX
		
	function getShowAllComments41ProjectJSON(projectName){
		$.getJSON('DataServlet?do=ShowAllComments41Project&projectName='+projectName, function(data) {
			var items = [];
			$.each(data, function(key, val) {
				items.push('<li id="' + key + '">' + val + '</li>');	
			});
			
			$('<div/>', {
				'class': 'comment',
				html: items.join('')
			}).appendTo('#allComments41Project');
		});
	}
	*/
</script>
