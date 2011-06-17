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
	
	/* CommentDocument AJAX */
	function updateShowAllComments41Document(json){
		var newContent = '';
		//alert(json);
		
		json.comment.each(function(comment){
			newContent+="\
	<div id='comment'>\n\
		<div id='commentheader'>\n\
			<h1>"+ comment.id +" | "+ comment.user +"</h1>\n\
		</div>\n\
		<div id='commentbody'>\n\
			"+ comment.entry +"\n\
		</div>\n\
	</div>"
			/*TODO EDITBUTTON, DELETEBUTTON, usw.
			newContent += comment.id+' - '+comment.user+"<br/>"+comment.entry;
			*/
		});
		
		
		$('allComments41Docu').set('html', newContent);
	}
	function getShowAllComments41DocumentJSON(documentId){
		if(!hide){
			var jsonRequest = new Request.JSON({
				url: "DataServlet?do=ShowAllComments41Docu&documentId="+documentId,
				onComplete: updateShowAllComments41Document
			}).get({'documentId':documentId});
			hide=true;
		}else{
			$('allComments41Docu').set('html', '');
			hide=false;
		};
	}
	
	/* CommentProject AJAX */
	function updateShowAllComments41Project(json){
		var newContent = '';
		//alert(json);
		json.comment.each(function(comment){
			newContent+="\
	<div id='comment'>\n\
		<div id='commentheader'>\n\
			<h1>"+ comment.id +" | "+ comment.user +"</h1>\n\
		</div>\n\
		<div id='commentbody'>\n\
			"+ comment.entry +"\n\
		</div>\n\
	</div>"
			/*TODO EDITBUTTON, DELETEBUTTON, usw.
			newContent += comment.id+' - '+comment.user+"<br/>"+comment.entry;
			*/
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
		var newContent = '';
		//alert(json);
		json.comment.each(function(comment){
			newContent+="\
	<div id='comment'>\n\
		<div id='commentheader'>\n\
			<h1>"+ comment.id +" | "+ comment.user +"</h1>\n\
		</div>\n\
		<div id='commentbody'>\n\
			"+ comment.entry +"\n\
		</div>\n\
	</div>"
			/*TODO EDITBUTTON, DELETEBUTTON, usw.
			newContent += comment.id+' - '+comment.user+"<br/>"+comment.entry;
			*/
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
		var newContent = '';
		//alert(json);
		json.comment.each(function(comment){
			newContent+="\
	<div id='comment'>\n\
		<div id='commentheader'>\n\
			<h1>"+ comment.id +" | "+ comment.user +"</h1>\n\
		</div>\n\
		<div id='commentbody'>\n\
			"+ comment.entry +"\n\
		</div>\n\
	</div>"
			/*TODO EDITBUTTON, DELETEBUTTON, usw.
			newContent += comment.id+' - '+comment.user+"<br/>"+comment.entry;
			*/
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
