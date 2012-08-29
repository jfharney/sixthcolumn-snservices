<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>TestPage</title>
	
	<script type="text/javascript" src='<c:url value="/scripts/jquery-1.4.4.min.js" />'></script>
	
	
	
</head>
<body>

<h1>Test page</h1>

<!--  <a href="#" class="xml_link">XML</a> -->

<br />

Enter SD: <input type="text" name="sdname" id="sdtext" />
<a href="#" class="json_link">JSON</a>


<div id="json_result" style="margin-top:50px">
	
</div>

</body>
</html>

<script type="text/javascript">



(function ($) {
	
	$('a.json_link').click( function() {
		
		var sdId = $('input#sdtext').val();
		
		//http://localhost:8080/sixthcolumn-snservices/service/sn?returnType=json
				
		var queryString = 'http://localhost:8080/sixthcolumn-snservices/service/sn/' + sdId;

		//alert('querying... ' + queryString);
		
		
		jQuery.ajax({
			url: queryString,
			dataType: 'json',
			type: 'GET',
			success: function(data) {
				$('div#json_result').empty();
				$('div#json_result').append('<span>' + data.jm + '</span>');
			},
			error: function(){
				alert('error');
			}
		
		});
	});
	
	$('a.xml_link').click( function() {
		var queryString = 'http://localhost:8080/sixthcolumn-snservices/service/sn?returnType=xml';

		alert('querying... ' + queryString);
		
		jQuery.ajax({
			url: queryString,
			type: 'GET',
			success: function(data) {
				alert('data: ' + data + ' data item: ' + data.SD);
				$('div#json_result').empty();
				$('div#json_result').append('<span>' + data.SD + '</span>');
			},
			error: function(){
				alert('error');
			}
		
		});
	});
	
	/*
	jQuery.ajax({
		url: queryString,
		dataType: 'json',
		type: 'GET',
		success: function(data) {
			alert('data: ' + data + ' data item: ' + data.SD);
		},
		error: function(){
			alert('error');
		}
	
	});
	*/
	
}(jQuery));

</script>