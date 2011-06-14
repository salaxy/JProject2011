<%-- 
    Document   : javascript
    Created on : 08.06.2011, 13:49:19
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--<script src="js/jquery-1.6.1.min.js"></script>-->
<script src="js/mootools-1.2.1-core.js"></script>
<script type="text/javascript">
	
	/*
	function getShowAllComments41ProjectJSON(projectName) {
		alert("hallo"+projectName);
		
		jQuery.getJSON('DataServlet?do=ShowAllComments41Project&projectName='+projectName, function(data) {
			var items = [];
			alert("was here");
			$.each(data, function(key, val) {
				items.push('<li id="' + key + '">' + val + '</li>');
			});

			$('<div/>', {
				'class': 'comment',
				html: items.join('')
			}).appendTo('#allComments41Project');
		});
		
	}
	
	
	
	$("#showComments41Project").click(function(event){
		alert("Thanks for visiting! ");
	});
	
	
	
		
	
	function getShowAllComments41ProjectJSON(projectName){
		$.getJSON('DataServlet?do=ShowAllComments41Project&projectName='+projectName, function(data) {
			var items = [];
			alert("was here");
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

	function updateShowAllComments41Document(json){
		var newContent = '';
		alert(json);
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
	
	function updateShowAllComments41Project(json){
		var newContent = '';
		//alert(json);
		json.comment.each(function(comment){
			//alert("im in");
			/*TODO EDITBUTTON, DELETEBUTTON, usw.*/
			newContent += comment.id+' - '+comment.user+"<br/>"+comment.entry;
		});
		alert(newContent);
		$('allComments41Project').set('html', newContent);
	}
	function getShowAllComments41ProjectJSON(projectName){
		var jsonRequest = new Request.JSON({
			url: "DataServlet?do=ShowAllComments41Project&projectName="+projectName,
			onComplete: updateShowAllComments41Project
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
	*/
</script>
