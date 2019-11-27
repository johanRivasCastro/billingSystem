$(document).ready( function () {
	 var table = $('#invoicesTable').DataTable({
		 
//		 <th>Id</th>
//			<th>Descripcion</th>
//			<th>Fecha</th>
//			<th>Vendedor</th>
//			<th>Total</th>
//			<th>Actions</th>
			 
			"sAjaxSource": "/rest/clients",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			      { "mData": "id"},
			      { "mData": "description" },
		          { "mData": "lastname" },
				  { "mData": "email" },
				  { "mData": "direction" },
				  { "mData": "identification" },
				  { "mData": "phone" },
				  { mRender: function (data, type, row) {
		                return '<button  class="text-warning" id="'+row.id+'"><span><i class="fas fa-pen"></i></span></button> <button  class="text-danger" id="'+row.id+'"><span><i class="fas fa-trash"></i></span></button>'
		              },
		              className:"center"
			     }
			]
	 });
	 
//
//	 $('#clientsTable tbody').on( 'click', 'button', function () {
//	        var actionId = this.id;  
//	        var actionClass = this.className;
//	        
//	        
//	        if(actionClass == "text-danger") {
//	        var url = '/deleteClient/'+actionId;
//	        $('#BtnDeleteClient').attr("href",url);
//	        $("#ModalDeleteClient").modal();
//	        }else{
//	        	$.get("/rest/client/"+actionId, function(client,status){
//	        		$('#client-id').val(client.id)
//	        		$('#edit-clientName').val(client.name)
//	        		$('#edit-clienLastname').val(client.lastname)
//	        		$('#edit-clientEmail').val(client.email)
//	        		$('#edit-clientDirection').val(client.direction)
//	        		$('#edit-clientPhone').val(client.phone)
//	        		$('#edit-clientIdentification').val(client.identification)
//	        		 $("#ModalEditClient").modal();
//	        	});
//	        	
//	        }
//	    } );
	
});