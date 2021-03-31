// Función de creación de clientes.
$(document).ready(function () {

    $("#modalVehicleForm").submit(function (event) {
	
		var form = document.getElementById('modalVehicleForm');
	
		event.preventDefault();
		event.stopPropagation();
	
		if (form.checkValidity()){
	        peticionAjax();
		}
    });

	$("#selectModel").change(function() {
		printSelectLine($("#selectModel").val());
	});

});

function printSelectLine (model) {
	
	$("#selectLine").html("");
	
	if (model) {
	
		var data = {};
		data["model"] = model;
		
		$("#selectLine").prop("disabled", true);
		
		var request = $.ajax({
			url: "/vehicles/lines",
			contentType: "application/json",
			method: "GET",
			data: data,
			dataType: 'html',
			cache: false
		});
		 
		request.done(function( response, textStatus, jqXHR ) {
			
			var obj = JSON.parse(response);
			
			if (obj.status == 'OK') {
				var objLines = obj.object;
				$.each(objLines, function(k, v){
					$("#selectLine").append("<option value="+objLines[k].id+">"+objLines[k].name+"</option>");
				})
			}
		});
		 
		request.fail(function( jqXHR, textStatus, errorThrown ) {
			alert( "Request failed: " + textStatus );
		});
		
		request.always(function () {
			$("#selectLine").prop("disabled", false);
			$("#btnSend").prop("disabled", false);
		});
	}
}

function peticionAjax () {
		
	var data = {};
	data["plate"] = $("#txtPlate").val();
	data["yearModel"] = $("#txtYearModel").val();
	data["vehicleModelLine"] = parseInt($("#selectLine").val());
	data["color"] = $("#txtColor").val();
	data["fuelType"] = parseInt($("#selectFuelType").val());
	data["motorNumber"] = $("#txtMotorNumber").val();
	data["chassisNumber"] = $("#txtChassisNumber").val();
	
	$("#btnSend").prop("disabled", true);
	
	var request = $.ajax({
		url: "/saveVehicle",
		contentType: "application/json",
		method: "POST",
		data: JSON.stringify(data),
		dataType: 'html',
		cache: false
	});
	 
	request.done(function( response, textStatus, jqXHR ) {
		var obj = JSON.parse(response);
		$('#vehicleModal').modal('hide');
		$('#modalVehicleForm').find("input, textarea").val("");
		window.location.replace("/vehicles");
	});
	 
	request.fail(function( jqXHR, textStatus, errorThrown ) {
		alert( "Request failed: " + textStatus );
	});
	
	request.always(function () {
		$("#btnSend").prop("disabled", false);
	});
}