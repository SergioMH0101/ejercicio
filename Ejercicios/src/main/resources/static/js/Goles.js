function GolesController(opcion) {
	$("#msg").hide();
	$("#msg").removeClass("alert-success").addClass("alert-danger");
	
	switch(opcion){

case "get":
		
		$.ajax({
			type : "post",
			url : "/Goles/get",
			data : "equ_cod="+$("#equ_cod").val(),
			success : function(res) {
				console.log(res);
				if (res == null || res == "") {
					$("#msg").show();
					$("#msg").html("No se encontraron registros.");
				} else {
					result="<table>"
					result+="<tr>"
					result+="<th>RUT</th>"
					result+="<th>EQU_COD</th>"
					result+="<th>GOL_CANTIDAD</th>"
					result+="</tr>"

					goles="";
					$.each(res, function(k,v) {
						$("#jug_nombre").val(v.jug_nombre);
						$("#equ_cod").val(v.equ_cod);
						result+="<tr>";
						result+="<td>"+v.jug_rut+"</td>";
						result+="<td>"+v.equ_cod+"</td>";
						result+="<td>"+v.gol_cantidad+"</td>";
						result+="</tr>";
						goles+=v.goles+",";
					});
	
					goles.substr(0,goles.length-1)

					
					result+="</table>"
					
					$("#goles").html(result);
				}
			},
			error : function() {
				$("#msg").show();
				$("#msg").html("Error en busqueda.");
			}
		});       			
		break;
				case "update":
					var jobJSON = 
						{
							'jug_rut': $("#jug_rut").val(),
							'gol_cantidad': $("#gol_cantidad").val(),
						};

				    var postData = JSON.stringify(JSON);

					$.ajax({
						type : "post",
						url : "/Goles/update",
						data : postData,
						contentType : "application/json; charset=utf-8",
						dataType : "json",
						success : function(res) {
							if (res == 1) {
								$("#msg").removeClass("alert-danger").addClass("alert-success");
								$("#msg").show();
								$("#msg").html("Registro modificado correctamente.");
							} else {
								$("#msg").show();
								$("#msg").html("No se pudo modificar el registro.");
							}
						},
						error : function() {
							$("#msg").show();
							$("#msg").html("No se pudo modificar el registro.");
						}
					});       	
			    break;
				default:
					$("#msg").show();
					$("#msg").html("Opción incorrecta.");
	}
}