
$(document).ready(function() {
	$('#nombre').blur(function() {
		$.ajax({
			url : 'GetUserServlet',
			data : {
				nombre : $('#nombre').val()
			},
			success : function(responseText) {
				$('#ajaxGetUserServletResponse').text(responseText);
			}
		});
	});
});