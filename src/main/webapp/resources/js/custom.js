$(document).ready(function () {
    $(".muangay").click(function () {
        var masanpham = $(this).closest("tr").find(".masanpham").attr("data-masanpham");
        var tensanpham = $(this).closest("tr").find(".masanpham").text();
        var mamau = $(this).closest("tr").find(".mausanpham").attr("data-mamau");
        var tenmau = $(this).closest("tr").find(".mausanpham").text();
        var masize = $(this).closest("tr").find(".masize").attr("data-size");
        var tensize = $(this).closest("tr").find(".masize").text();
        var soluong = $(this).closest("tr").find(".soluong").attr("data-soluong");
        var giatien = $(this).closest("tr").find(".giatien").attr("data-giatien");
        $.ajax({
            url: "/api/xuly",
            type:"get",
            data:{
                maSanPham: masanpham,
                tenSanPham: tensanpham,
                maMau : mamau,
                tenMau : tenmau,
                maSize : masize,
                tenSize : tensize,
                soLuong : soluong,
                giaTien : giatien
            }
        }).done(function () {
        })
    })

    var files = [];
    $("#hinhanh").change(function(event) {
        files = event.target.files;
        var forms = new FormData();
        forms.append("file", files[0]);
        $.ajax({
            url: "/api/xulyupload",
            type:"POST",
            data:forms,
            contentType:false,
            processData: false,
            enctype: "multipart/form-data",
            success: function (value) {

            }
        })
    })
    $("#themthongtin").click(function (event) {
        event.preventDefault();
        var formData = $("#form-nguoimua").serializeArray();
        json = {};
        $.each(formData, function(i, field){
            json[field.name] = field.value;
        });


        $.ajax({
            url: "/api/nguoinhan",
            type:"POST",
            data:{
                dataJson : JSON.stringify(json)
            },
            success: function (value) {
                console.log(value);
                $("#tennguoimua").val(value.tenSanPham);
            }
        })
    })
})