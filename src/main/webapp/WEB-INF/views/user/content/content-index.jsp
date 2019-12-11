
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="row section social-section">
	<div class="row">
		<!-- Display Product -->
		<c:forEach items="${productDTOs}" var="productDTO">
			<div class="col-lg-2 col-md-6 " style="">
				<div class="product">
					<img style="height: 200px; width: 100%" class="d-block w-100 col-lg-12 img-<c:out value="${productDTO.getProductid()}"/> "
							src='../resources/images/my-images/<c:out value="${productDTO.getImage()}" />'
							alt='<c:out value="${alt}" />'>
					<div class="product-body">
						<p class="product-category">
							<c:out
								value="${productDTO.getCategoryproductNAME()}" />
						</p>
						<h3 class="product-name product-name-<c:out value="${productDTO.getProductid()}" />">
							<c:out value="${productDTO.getName()}" />
						</h3>
						<h4 class="product-price product-price-<c:out value="${productDTO.getProductid()}" />">
							<c:if test="${productDTO.getNewPrice()!=null}">
								<!-- new price -->
								<c:out value="${productDTO.getNewPrice().getPrice()}" />
								<del class="product-old-price">
									<c:out value="${productDTO.getPrice()}đ" />
								</del>
							</c:if>
							<c:if test="${productDTO.getNewPrice()==null}">
								<c:out value="${productDTO.getPrice()}đ" />
							</c:if>
						</h4>
						<div class="product-rating">
							<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i> <i class="fa fa-star"></i> <i
								class="fa fa-star"></i>
						</div>
						<div class="product-btns">
							<button id="IDsanpham" title="Quan tâm" class="add-to-wishlist"
								tabindex="-1">
								<i class="fa fa-heart-o"></i>
							</button>
							<button title="Xem đánh giá" class="add-to-compare" tabindex="-1">
								<i class="fa fa-star-half-empty"></i>
							</button>
							<button
								data-PId='<c:out value="${productDTO.getProductid()}"></c:out>'
								title="Xem nhanh" class="quick-view btn-View" tabindex="-1"
								data-toggle="modal" data-target="#exampleModal">
								<i class="fa fa-eye"></i>
							</button>
							<button
								data-PId='<c:out value="${productDTO.getProductid()}"></c:out>'
								title="Thêm vào giỏ" class="quick-view btn-add-to-cart"
								tabindex="-1">
								<i class="fa fa-shopping-cart"></i>
							</button>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
		<!-- End Display Product -->
		<!-- Detail Product -->
		<div class="modal fade show detail-product" id="exampleModal"
			tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-body">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
						<div id="detail-product" class="container row"></div>
					</div>
				</div>
			</div>
		</div>
		<!-- End Detail Product -->
	</div>
</div>

<div
	class="align-items-center justify-content-between flex-wrap container"
	style="text-align: center;">
	<a id="viewMore" data-startPosition = '<c:out value="${startPosition }"></c:out>'
		class="btn btn-inverse-light btn-rounded btn-fw btn-see-more">Xem
		thêm</a>
</div>
	<script src="../resources/ajax-jquery/user-index-search.js"></script>