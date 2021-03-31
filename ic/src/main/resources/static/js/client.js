// Función de creación de clientes.
$(document).ready(function () {

    $("#modalClientForm").submit(function (event) {
	
		var form = document.getElementById('modalClientForm');
	
		event.preventDefault();
		event.stopPropagation();
	
		if (form.checkValidity()){
	        ajaxSaveClient();
		}
    });

});

function ajaxSaveClient () {
		
	var data = {};
	data["nidType"] = parseInt($("#selectDocumentType").val());
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
		url: "/saveClient",
		contentType: "application/json",
		method: "POST",
		data: JSON.stringify(data),
		dataType: 'html',
		cache: false
	});
	 
	request.done(function( response, textStatus, jqXHR ) {
		var obj = JSON.parse(response);
		$('#clientModal').modal('hide');
		$('#modalClientForm').find("input, textarea").val("");
		window.location.replace("/clients");
	});
	 
	request.fail(function( jqXHR, textStatus, errorThrown ) {
		alert( "Request failed: " + textStatus );
	});
	
	request.always(function () {
		$("#btnSend").prop("disabled", false);
	});
}

function ajaxListVehicles(idClient) {
	
	var data = {};
	data["id"] = idClient;
	
	$("#tbodyVehicleModalList").html("");
	
	var request = $.ajax({
		url: "/listVehicles",
		contentType: "application/json",
		method: "GET",
		data: data,
		dataType: 'html',
		cache: false
	});
	 
	request.done(function( response, textStatus, jqXHR ) {
		var obj = JSON.parse(response);
		var objVehicle = obj.object.vehicle; 
		$.each(objVehicle, function(k, v){
			$("#tbodyVehicleModalList").append("<tr>");
			$("#tbodyVehicleModalList").append("<td>"+objVehicle[k].plate+"</td>");
			$("#tbodyVehicleModalList").append("<td>"+objVehicle[k].vehicleModelLine.vehicleModel.name+"</td>");
			$("#tbodyVehicleModalList").append("<td>"+objVehicle[k].vehicleModelLine.name+"</td>");
			$("#tbodyVehicleModalList").append("<td>"+objVehicle[k].yearModel+"</td>");
			$("#tbodyVehicleModalList").append("</tr>");
		});
		
	});
	 
	request.fail(function( jqXHR, textStatus, errorThrown ) {
		alert( "Request failed: " + textStatus );
	});
	
	request.always(function () {
		
	});
}
