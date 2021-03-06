<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="col-md-5 d-flex align-items-stretch">
		<div class="row flex-grow">
			<div class="col-12 grid-margin">
				<div class="card">
					<div class="card-body">
						<h4 class="card-title">Hóa đơn chi tiết</h4>
						<p id="result-form" class="card-description"></p>
						<form id="billDetail_form" class="forms-sample">
						</form>
						<br>
						<table  id="tBodyDetail" class="table table-striped">
							
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-7 grid-margin stretch-card">
		`
		<div class="card">
			<div class="card-body">
				<h4 class="card-title">Danh sách hoá đơn</h4>
				<p id="result-tbody" class="card-description">
					<code></code>
				</p>
				<table id="order-listing" class="table table-hover">
					<thead>
						<tr>
							<th></th>
							<th>ID</th>
							<th>Bàn</th>
							<th>Ngày thanh toán</th>
							<th>Tổng tiền</th>
							<th>Tình trạng</th>
							<th>Cập nhập lần cuối</th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
				<nav>
					<input id="totalPage"
						value="
						<c:if test="${totalPage == null}">
							1
						</c:if>
						<c:if test="${totalPage != null}">
							<c:out value="${totalPage}" />
						</c:if>"
						type="hidden">
					<ul class="pagination separated pagination-secondary">

					</ul>
				</nav>
			</div>
		</div>
	</div>
</div>