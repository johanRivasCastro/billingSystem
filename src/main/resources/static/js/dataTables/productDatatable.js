$(document).ready( function () {
	 var table = $('#productsTable').DataTable({
			"sAjaxSource": "/rest/products",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			      { "mData": "id"},
		          { "mData": "name" },
				  { "mData": "price" },
				  { "mData": "stock" },
				  { "mData": "iva" },
				  { mRender: function (data, type, row) {
		                return '<button  class="text-warning" id="'+row.id+'"><span><i class="fas fa-pen"></i></span></button> <button  class="text-danger" id="'+row.id+'"><span><i class="fas fa-trash"></i></span></button>'
		              },
		              className:"center"
			     }
			]
	 });
	 	 
	 $('#productsTable tbody').on( 'click', 'button', function () {
	        var actionId = this.id;  
	        var actionClass = this.className;
	        
	        
	        if(actionClass == "text-danger") {
	        var url = '/deleteProduct/'+actionId;
	        $('#BtnDeleteProduct').attr("href",url);
	        $("#ModalDeleteProduct").modal();
	        }else{
	        	$.get("/rest/product/"+actionId, function(product,status){
	        		$('#product-id').val(product.id)
	        		$('#edit-name').val(product.name)
	        		$('#edit-price').val(product.price)
	        		$('#edit-existences').val(product.stock)
	        		$('#edit-iva').val(product.iva)
	        		 $("#ModalEditProduct").modal();
	        	});
	        	
	        }
	    } );
	
});
