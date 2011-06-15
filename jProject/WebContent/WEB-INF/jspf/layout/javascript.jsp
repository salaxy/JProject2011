<%-- 
    Document   : javascript
    Created on : 08.06.2011, 13:49:19
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--<script src="js/jquery-1.6.1.min.js"></script>-->
<script src="js/mootools-1.2.1-core.js"></script>
<script type="text/javascript">  
	/* CommentDocument AJAX */
	function updateShowAllComments41Document(json){
		var newContent = '';
		//alert(json);
		json.comment.each(function(comment){
			/*TODO EDITBUTTON, DELETEBUTTON, usw.*/
			newContent += comment.id+' - '+comment.user+"<br/>"+comment.entry;
		});
		$('allComments41Docu').set('html', newContent);
	}
	function getShowAllComments41DocumentJSON(documentId){
		var jsonRequest = new Request.JSON({
			url: "DataServlet?do=ShowAllComments41Document&documentId="+documentId,
			onComplete: updateShowAllComments41Document
		}).get({'documentId':documentId});
	}
	
	/* CommentProject AJAX */
	function updateShowAllComments41Project(json){
		var newContent = '';
		//alert(json);
		json.comment.each(function(comment){
			//alert("im in");
			/*TODO EDITBUTTON, DELETEBUTTON, usw.*/
			newContent += comment.id+' - '+comment.user+"<br/>"+comment.entry;
		});
		$('allComments41Project').set('html', newContent);
	}
	function getShowAllComments41ProjectJSON(projectName){
		var jsonRequest = new Request.JSON({
			url: "DataServlet?do=ShowAllComments41Project&projectName="+projectName,
			onComplete: updateShowAllComments41Project
		}).get({'projectName':projectName});
	}
	
	/* CommentSourcecode AJAX */
	function updateShowAllComments41Source(json){
		var newContent = '';
		//alert(json);
		json.comment.each(function(comment){
			//alert("im in");
			/*TODO EDITBUTTON, DELETEBUTTON, usw.*/
			newContent += comment.id+' - '+comment.user+"<br/>"+comment.entry;
		});
		$('allComments41Source').set('html', newContent);
	}
	function getShowAllComments41SourceJSON(sourcecodeId){
		var jsonRequest = new Request.JSON({
			url: "DataServlet?do=ShowAllComments41Source&sourcecodeId="+sourcecodeId,
			onComplete: updateShowAllComments41Source
		}).get({'sourcecodeId':sourcecodeId});
	}
	
	/* CommentTask AJAX */
	function updateShowAllComments41Task(json){
		var newContent = '';
		//alert(json);
		json.comment.each(function(comment){
			//alert("im in");
			/*TODO EDITBUTTON, DELETEBUTTON, usw.*/
			newContent += comment.id+' - '+comment.user+"<br/>"+comment.entry;
		});
		$('allComments41Task').set('html', newContent);
	}
	function getShowAllComments41TaskJSON(taskId){
		var jsonRequest = new Request.JSON({
			url: "DataServlet?do=ShowAllComments41Task&taskId="+taskId,
			onComplete: updateShowAllComments41Task
		}).get({'taskId':taskId});
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
