<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">

	<div class="col-md-10 grid-margin stretch-card">
		<div class="card">
			<div class="card-body">
				<h4 class="card-title">Danh sách hoá đơn</h4>
				<p id="result-tbody" class="card-description">
					<code></code>
				</p>
				<table id="order-listing" class="table table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>Tổng tiền</th>
							<th>Tình trạng</th>
							<th>Ngày thanh toán</th>
						</tr>
					</thead>
					<tbody>
						<jsp:include page="tBody.jsp"/>
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