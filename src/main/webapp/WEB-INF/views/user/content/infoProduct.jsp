
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-lg-8">
	<div id="product_details" class="carousel slide" data-ride="carousel">
		<img class="d-block w-100 col-lg-12"
			 src="../resources/images/my-images/<c:out value="${image}" />">
	</div>
</div>
<div class="col-lg-4">
	<div class="card-body">
		<div class="card rounded border mb-2 alert-success">
			<div class="card-body p-3">
				<div class="media">
					<div class="media-body">
						<p class="mb-0 text-muted detail-product-name">
							<c:out value="${product.getName()}" />
						</p>
					</div>
				</div>
			</div>
		</div>
		<div class="card rounded border mb-2 alert-danger">
			<div class="card-body p-3">
				<div class="media">

					<div class="media-body">
						<p class="mb-0 text-muted detail-product-price">
							<c:out value="${old_prPrice}đ" />
						</p>
						<c:if test="${new_Price != null}">
							<p class="mb-0 text-muted detail-product-price">
								<c:out value="${new_Price.getPrice()}đ" />
							</p>
							<p class="mb-0 text-muted detail-product-price">
								<c:out value="Áp dụng ${new_Price.getStartdatetime()}" />
							</p>
						</c:if>
						</p>
					</div>
				</div>
			</div>
		</div>
		<div class="card rounded border mb-2 alert-info">
			<div class="card-body p-3">
				<div class="media">
					<div class="media-body">
						<p class="mb-0 text-muted">
							<c:out value="${product.getDescription()}" />
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

