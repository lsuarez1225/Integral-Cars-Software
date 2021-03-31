// Función de creación de clientes.
$(document).ready(function () {

    $("#modalWorkOrderForm").submit(function (event) {
	
		var form = document.getElementById('modalWorkOrderForm');
	
		event.preventDefault();
		event.stopPropagation();
	
		if (form.checkValidity()){
	        peticionAjax();
		}
    });

});

function peticionAjax () {
		
	var data = {};
	data["identificationType"] = $("#selectDocumentType").val();
	data["nid"] = $("#txtNid").val();
	data["city"] = $("#selectCity").val();
	data["businessName"] = $("#txtBusinessName").val();
	data["direction"] = $("#txtDrections").val();
	data["firstName"] = $("#txtFirstName").val();
	data["lastName"] = $("#txtLastName").val();
	data["contactName"] = $("#txtContactName").val();
	data["phone1"] = $("#txtPhone1").val();
	data["phone2"] = $("#txtPhone2").val();
	data["email"] = $("#txtEmail").val();
	data["web"] = $("#txtWeb").val();
	data["active"] = $("#chekboxActive").is(":checked");
	
	$("#btnSend").prop("disabled", true);
	
	var request = $.ajax({
		url: "/saveWorkOrder",
		contentType: "application/json",
		method: "POST",
		data: JSON.stringify(data),
		dataType: 'html',
		cache: false
	});
	 
	request.done(function( response, textStatus, jqXHR ) {
		var obj = JSON.parse(response);
		$('#workOrderModal').modal('hide');
		$('#modalWorkOrderForm').find("input, textarea").val("");
		window.location.replace("/workOrders");
	});
	 
	request.fail(function( jqXHR, textStatus, errorThrown ) {
		alert( "Request failed: " + textStatus );
	});
	
	request.always(function () {
		$("#btnSend").prop("disabled", false);
	});
}