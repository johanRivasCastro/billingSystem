$(document).ready( function () {
	 var table = $('#invoicesTable').DataTable({
					
			"sAjaxSource": "/rest/invoices",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			      { "mData": "id"},
			      { "mData": "description" },
		          { "mData": "client.name" },
				  { "mData": "createdAt" },
				  { "mData": "user.username" },
				  { "mData": "total" },
				  { mRender: function (data, type, row) {
		                return '<a href="/invoice/details/'+row.id+'"><button class="text-warning"><span><i class="fas fa-info"></i></span></button> </a><button  class="text-danger" id="'+row.id+'"><span><i class="fas fa-file-pdf"></i></span></button>'
		              },
		              className:"center"
			     }
			]
	 });
	 
	
});