jQuery(document).ready(function($) {
    var value = $('#valueid').val();
    if (value ==='HDH'){
        $('#progressbar_2').addClass('active');
        $('#progressbar_3').addClass('active');
    }else {
        if(value ==='XN'){
            $('#progressbar_2').addClass('active');
        }
        if(value ==='CTT'){
            $('#progressbar_2').addClass('active');
            $('#progressbar_3').addClass('active');
        }
        if(value ==='DTT'){
            $('#progressbar_2').addClass('active');
            $('#progressbar_3').addClass('active');
            $('#progressbar_4').addClass('active');
        }
    }

    $('#btnHuy').click(function () {
        var billId = $(this).val();
        $.ajax({
            url:"/user/huydonhang",
            type:"GET",
            data:{
                billId: billId
            },
            success: function (value) {
                if (value ==="success"){
                    $('.progressbar-container')
                        .html(
                            "<ul class=\"progressbar\">\n" +
                            "    <li class=\"active\" id= \"progressbar_1\"> Đang Chờ</li>\n" +
                            "    <li class=\"active\" id= \"progressbar_2\"> Hủy Đơn Hàng</li>\n" +
                            "</ul>");
                    $('#changer').html("Hủy Đơn Hàng Thành Công");
                }else {
                    alert("Hủy Đơn Hàng Không Thành Công, Vui Lòng Kiểm Tra Lại");
                }
            }
        })
    })

        
});