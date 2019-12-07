<%@ page import="java.util.List" %>
<%@ page import="com.thecoffeshop.DTO.ProductDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- partial:../resources/partials/_navbar.html -->
<nav
	style="background: url(../resources/images/background2.jpg); background-size: cover;"
	class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row nav-bar-display-product">
	<div class="text-center navbar-brand-wrapper ">
		<a class="navbar-brand brand-logo logo" href="/index"><img
			src="../resources/images/logo-full.png" alt="logo"></a> <a
			class="navbar-brand brand-logo-mini logo" href="index.html"><img
			src="../resources/images/logo.png" alt="logo"></a>
	</div>
	<div
		class="navbar-menu-wrapper d-flex align-items-center nav-bar-display-product-ul">
		<ul class="navbar-nav ml-lg-auto">
			<li class="nav-item">
				<div class="row">
					<div class="header-search">
						<div class='form-check form-check-flat nav-search checkBox-search'>
							<label class='form-check-label'> <input
								id='inputIsHotDeal' type='checkbox' class='form-check-input'>
								Bán chạy nhất <i class='input-helper'></i>
							</label>
						</div>
					</div>
					<div class="header-search">
						<div class='form-check form-check-flat nav-search checkBox-search'>
							<label class='form-check-label'> <input id='inputPriceAZ'
								type='checkbox' class='form-check-input'> Sắp xếp giá
								tăng <i class='input-helper'></i>
							</label>
						</div>
					</div>
					<div class="header-search">
						<div class='form-check form-check-flat nav-search checkBox-search'>
							<label class='form-check-label'> <input id='inputPriceZA'
								type='checkbox' class='form-check-input'> Sắp xếp giá
								giảm <i class='input-helper'></i>
							</label>
						</div>
					</div>
					<div class="header-search">
						<select class="form-control form-control-sm nav-search"
							id="selectCategoryProduct">
							<option value="-1">Phân loại</option>
							<c:forEach items="${categoryProducts}" var="categoryProduct">
								<option
									<c:if test="${cgPrdId!=null && cgPrdId==categoryProduct.getCategoryproductid()}">
													<c:out value="selected" />
											</c:if>
									value='<c:out value = "${categoryProduct.getCategoryproductid()}" />'>
									<c:out value="${categoryProduct.getName() }" />
								</option>
							</c:forEach>
						</select>
					</div>
					<div class="header-search">
						<div class="nav-search">
							<input id="inputSearch" class="input" placeholder="Từ khóa ...">
							<button id="btnSearch" type="button" class="search-btn">
								<i class="icon-magnifier icons"></i>
							</button>
						</div>
					</div>
					<div class="header-ctn">
						<div class="dropdown">
							<a href="book-table"> <i class="icon-call-out"></i> <span>Đặt bàn ngay</span>
							</a>
						</div>
						<!-- Cart -->
						<div class="dropdown">
							<a id="dropdownMenuButton" class="dropdown-toggle"
								data-toggle="dropdown" aria-expanded="false"> <i
								class="fa fa-shopping-cart"></i> <span>Giỏ hàng</span>
								<c:if test="${soluonggiohang <=0 || soluonggiohang == null}">
									<div class="qty">0</div>
								</c:if>

								<c:if test="${soluonggiohang > 0}">
									<div class="qty" id="gio_hang">${soluonggiohang}</div>
								</c:if>

							</a>
							<div class="dropdown-menu cart-dropdown your-card" aria-labelledby="dropdownMenuButton" style="width: 310px;">
								<div class="cart-list"></div>
								<div class="cart-summary">
									<small>${soluonggiohang} sản phẩm được chọn</small>
								</div>
								<div class="cart-btns row">
									<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
										<button type="button" class="btn btn-outline-primary" id="btnClean">Làm mới</button>
									</div>
									<c:if test="${customer != null}">
										<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
											<button type="button" class="btn btn-outline-primary"><a href="/user/viewsbill">Check Order</a></button>
										</div>
									</c:if>
									<c:if test="${customer == null}">
										<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
											<button type="button" class="btn btn-outline-primary"><a href="/user/login">Đăng Nhập</a></button>
										</div>
									</c:if>
									<c:if test="${soluonggiohang > 0}">
										<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
											<button class="btn btn-danger" id="btnPay"><a href="/user/order-product">Car Pay</a></button>
										</div>
									</c:if>



								</div>
							</div>
						</div>
						<!-- /Cart -->
					</div>
					<!--  -->
				</div>
			</li>
		</ul>
	</div>

	<!-- form hidden -->
	<input id="cgPrdId"
		value='<c:out value="${cgPrdId}" />' type="hidden" /> <input
		id="strSearch" value='<c:out value="${strSearch}" />' type="hidden" />
	<input id="isHotDeal" value='<c:out value="${isHotDeal}" />'
		type="hidden" /> <input id="priceAZ"
		value='<c:out value="${priceAZ}" />' type="hidden" /> <input
		id="priceZA" value='<c:out value="${priceZA}" />' type="hidden" />
	<!-- form hidden [END]-->
</nav>
<!-- partial ends -->