$(document).ready(function(){
	
	// Activated the table
	var tableClient = $('#tableClient').DataTable({
		"autoWidth": false,
		"columnDefs": [
			{"targets": [ 0 ],
		     "visible": false,
		     "searchable": true}
		],
		"ajax": {
			"url": "/springMvcCrud/employeeJsonData",
			"type": "POST",
			"success" :  function(data){
				$.each(data, function(ind, obj){
					
					tableClient.row.add([
						obj.id,
						"<input type='checkbox' value='"+obj.id+"' id=''>",
						obj.name,
						obj.email,
						obj.address,
						obj.telephone
						
					]).draw();
				});
			}
		},
	});
	
	/* $("#pickerDateBirth").datetimepicker({
		 format: 'DD/MM/YYYY'
	 });
    */
	
	$(window).load(function() {
		
	});
	
	$("#buttonSearch").click(function(){
		tableClient.clear().draw();
		tableClient.ajax.reload();
		
	});
	
	$("#buttonEdit").click(function(){
		$(this).callAjax("editEmployee", "");
		
		$(".form-control").val("");
		
	});
	
	$("#buttonDelete").click(function(){
		
		var valuesChecked = $("#tableClient input[type='checkbox']:checkbox:checked").map(
			     					function () {
			     						return this.value;
			     					}).get().join(",");
		
		$(this).callAjax("deleteClient", valuesChecked);
		
	});
	
	$.fn.callAjax = function( method, checkeds ){
		$.ajax({
			type: "POST",
			url: "/springMvcCrud/" + method,
			dataType: "json",
			timeout : 100000,
			data: { name: $("#name").val(), email: $("#email").val(), address: $("#address").val(), 
						telephone: $("#telephone").val(), checked: checkeds },
			
			success: function(data){
				tableClient.clear().draw();
				tableClient.ajax.reload();
			},
			error: function(e){
				alert("ERROR: ", e);
			}
		});
	} 
	 
});


