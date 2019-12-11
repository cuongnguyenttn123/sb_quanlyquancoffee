$(function(){
	
    $(".remove").click(function() {
        $.post("/admin/product/remove",{
            productid : $(this).attr("data-productid")
        }, function(data, status){
            $("#result-tbody").html(data);
			$("#result-tbody").fadeToggle(3000);
			_list(link,1);// at loadTable.js
        });
    });
    
    $(".edit").click(function() {
        $.get("/admin/product/edit",{
            productid : $(this).attr("data-productid")
         }, function(data, status){
             $("#product_form").html(data);
         });
    });

    var files = [];
    $("#image").change(function(event) {
        files = event.target.files;
        var forms = new FormData();
        forms.append("file", files[0]);
        $.ajax({
            url: "/api/upload",
            type:"POST",
            data:forms,
            contentType:false,
            processData: false,
            enctype: "multipart/form-data",
            success: function (value) {
               $("#nameImage").val(value);
            }
        })
    })
    
    
});