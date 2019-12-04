/**
 * 
 */

$(".stretch-card").click(function() {
	$("#dinnertableid").val($(this).attr("data-dinnertableid"));
	
	var dinnertableid = $(this).attr("data-dinnertableid");
	_modalContent(dinnertableid, 0, "");
	
	$('#exampleModal').modal('show');
});

$("#close-modal").click(function() {
	$('.modal-body').html('');
	 $('#exampleModal').modal('hide');
});

function _modalContent(dinnertableid, startPosition, inputSearch) {
	$.get("/admin/index-modal", {
		dinnertableid:dinnertableid,
		startPosition : startPosition,
		inputSearch: inputSearch
	}, function(data, status) {
		$('.modal-body').html(data);
	});
}
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




