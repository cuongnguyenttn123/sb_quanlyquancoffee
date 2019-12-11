
$(".stretch-card").click(function() {

	$("#dinnertableid").val($(this).attr("data-dinnertableid"));
	
	var dinnertableid = $(this).attr("data-dinnertableid");
	$.get("/admin/index-modal", {
		dinnertableid:dinnertableid

	}, function(data, status) {
		$('.modal-body').html(data);
	});
	
	$('#exampleModal').modal('show');


});

$("#close-modal").click(function() {
	$('.modal-body').html('');
	 $('#exampleModal').modal('hide');
	$(".productlist").html('');
	$(".showbilldinner").html('');
});

$("#userorderList").click(function () {
	$.ajax({
		url: "/admin/getlistuserorder",
		type: "GET",
		success: function (data) {
			console.log(data);
			$('#listuserorder').toggle();
			$('#listuserorder').html(data);
		}
	})
});
$(document).on('click', '#productList', function() {
	var dinnertableid = $('.productlist').attr("data-dinnertableid");
	$.ajax({
		url:"/admin/index/product",
		type:"GET",
		data:{
			dinnertableid:dinnertableid,
			startPosition : 0,
			inputSearch: ""
		},
		success: function (value) {
			$(".productlist").html(value);
		}
	})
});

$(document).on('click', '#dinnerbill', function() {
	var dinnertableid = $('.showbilldinner').attr("data-dinnertableid");
	$.ajax({
		url:"/admin/index/bill",
		type:"GET",
		data:{
			dinnertableid:dinnertableid
		},
		success: function (value) {
			$(".showbilldinner").html(value);
		}
	})
});



