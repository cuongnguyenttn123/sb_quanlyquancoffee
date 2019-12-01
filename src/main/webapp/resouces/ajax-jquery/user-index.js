/*nav-search*/
$(function() {
	$('.nav-search input').click(function() {
		$('.nav-search button').css({
			"background-color" : "#4c4c4c",
			"color" : "white"
		});
	});
	$('.nav-search input').mouseleave(function() {
		$('.nav-search button').css({
			"background-color" : "#d4c9c9",
			"color" : "#4e4e4e"
		});
	});
});
/* End nav-search */
/*-------------------------------------------------------------------------*/
/* Quan tam */
$(function() {
	$('.add-to-wishlist').click(function() {
		// alert($(".add-to-wishlist").attr("id"));
		var class_exist = $(".add-to-wishlist > i").attr("class");
		// alert(class_exist);
		var address = "#" + $(".add-to-wishlist").attr("id") + " i";
		// alert(address);
		if (class_exist.search("fa-heart-o") != -1) {
			// exist
			$(address).addClass("fa-heart");
			$(address).removeClass("fa-heart-o");
		} else {
			// not exist
			$(address).addClass("fa-heart-o");
			$(address).removeClass("fa-heart");
		}
	});
});
/* End Quan tam */
/* Navs */
$(function() {
	$('#myTab li:first-child a').tab('show');
});
/* End Navs */
/* Add row table */
$(function() {
	$('.btn-light').click(function() {
		for (var i = 0; i < 1000; i++) {
			$("#btn-add").fadeToggle("slow");
		}
	});
	$('#btn-add')
			.click(
					function() {
						var text = '<tr class=""><td></td><td class="btn-menu-products"<button class="btn btn-light" data-toggle="modal" data-target="#exampleModal-2" data-whatever="@mdo"><i class="  icon-wallet"></i>Chọn món</button></td><td><form><input class="form-input-quanlity" type="text" placeholder=""></form></td><td></td><td></td></tr>';
						$("#sortable-table-2 tbody").append(text);

					});
})
/* End Add row table */
/* Box-chat */
$(function() {
	$("#btn-show").show();
	$("#btn-hidden").hide();
	$("#display-chat").hide();
	$("#btn-show").click(function() {
		$("#btn-show").hide();
		$("#btn-hidden").show();
		$("#display-chat").show();
		$("#div-box-chat").css("height", "250px");
	});
	$("#btn-hidden").click(function() {
		$("#btn-show").show();
		$("#btn-hidden").hide();
		$("#display-chat").hide();
		$("#div-box-chat").css("height", "37px");
	});
})
/* End Box-chat */
/* View product */
function _viewProduct(productid) {
	 $.post("/infoProduct",{
		 			productid:productid
			    }, function(data, status){
						$("#detail-product").html(data);
			    });
};
/* View product [END] */
/* Add to cart */

/* Add to cart [END] */
/* Count number product in cart */
	function CountProductInCart(){
		return $(".product-widget").length;
	};
/* Count number product in cart [END] */
/* Show number product in cart */
 function showNumberProductInCart(){
	 $("#dropdownMenuButton div").text(CountProductInCart());
	 $(".cart-summary small").text(CountProductInCart()+ " sản phẩm được chọn");
 };
/* Show number product in cart [END] */
/* Tolal price product */
function sumPriceProduct( old_number, new_number, price){
	var sumPrice = $(".cart-summary h5").text();
	sumPrice = Number(sumPrice);
	sumPrice += new_number*price - old_number*price;
	/* set Total price */
	$(".cart-summary h5").text("" + sumPrice);
};
function changeTolalPrice(PId){
	var strPrice = $("#number-product-" + PId).attr("price-value");
	var old_number = Number($("#number-product-" + PId).attr("old-value"));
	var new_number = $("#number-product-" + PId).val();
	sumPriceProduct( old_number, new_number, strPrice);
	/* set value attribute old-value of input */
	$("#number-product-"+PId).attr("old-value" , new_number);
};

/* Toal price product [END] */
$(function () {

	$(".btn-View").click(function() {
		_viewProduct($(this).attr("data-PId"));
	});

	$(".btn-add-to-cart").click(function(){
		var PId = $(this).attr("data-PId");
		var	price;
		var Name = $(".product-name-"+ PId).text();
		if($(".product-price-"+ PId +" del").text()!= ""){
			price = $(".product-price-"+ PId +" del").text();
		}
		else{
			price = $(".product-price-"+ PId).text();
		}
		price = price.trim().substring(0, price.trim().length - 1);
		Name = Name.trim();
		console.log(Name);
		$.ajax({
			url:"/user/gio-hang",
			type:"GET",
			data:{
				PId:PId,
				price:price,
				Name : Name
			},
			success: function (value) {
				$(".qty").html(value);
				$(".cart-summary").html("<small>"+ value+" sản phẩm được chọn</small>");
			}
		})
		$('#btnPay').show();
	});

	$("#btnClean").click(function(){
		$('#btnPay').hide();
		$('.product-widget').remove();
		$.ajax({
			url:"/user/reset",
				type:"GET",
				data:{
			},
			success: function (value) {
				$(".qty").html(value);
			}
		})
		showNumberProductInCart();
	});
	
	$("#btnPay").click(function() {

		var listNumberProduct="";
		var num = $(".cart-list input[type=number]").length;
		var input = $(".cart-list input[type=number]");
		for (var i = 0; i < num; i++) {
			listNumberProduct += input.eq(i).val()+"~";
		}

		$("#listNumberProduct").val(listNumberProduct);
	});
});
