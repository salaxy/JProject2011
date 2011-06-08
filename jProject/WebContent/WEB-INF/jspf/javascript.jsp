<%-- 
    Document   : javascript
    Created on : 08.06.2011, 13:49:19
    Author     : MacYser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
