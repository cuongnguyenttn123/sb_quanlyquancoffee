<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Tab Menu -->

<input id='billid' value='<c:out value="${billid}"></c:out>'
	type='hidden' />

<ul class="nav nav-tabs" id="myTab" role="tablist">
	<li class="nav-item"><a class="nav-link active" id="table-status-tab"
		data-toggle="tab" href="#table-status" role="tab"
		aria-controls="table-status" aria-selected="false">Trạng thái bàn</a></li>

	<c:if test="${dinnertable.getTablestatus().getTablestatusid() != 1 }">
		<!-- chặn hành động thêm hóa đơn của bàn không sử dụng -->
		<li class="nav-item" id="productList"><a class="nav-link" id="add-food-tab"
			data-toggle="tab" href="#add-food" role="tab"
			aria-controls="add-food" aria-selected="false">Thêm món ăn</a></li>

		<li class="nav-item" id="dinnerbill" ><a class="nav-link" id="bill-tab"
			data-toggle="tab" href="#bill" role="tab" aria-controls="bill"
			aria-selected="false">Hóa đơn</a></li>
	</c:if>

	<c:if test="${dtos != null }">
		<li class="nav-item">
			<div class="row">
				<div class="input-group">
					<button id="btnDoiBan" type="button"
						class="btn btn-inverse-dark btn-fw">Đổi bàn</button>
					<select class="form-control" id="selectDINNERTABLEID">
						<c:forEach items="${dinnertables}" var="dinnertable">
							<option
								id='<c:out value="${dinnertable.getDinnertableid() }"></c:out>'><c:out
									value="${dinnertable.getName() }"></c:out></option>
						</c:forEach>
					</select>
				</div>
			</div>
		</li>
	</c:if>
</ul>
<!-- End Tab Menu -->
<!-- Body Tab Menu -->
<div class="tab-content" id="nav-tabContent">
	<!-- Trạng thái bàn -->
	<div class="tab-pane fade active show" id="table-status" role="tabpanel"
		aria-labelledby="table-status-tab">
		<form class="forms-sample">
			<div class="row">
				<c:forEach items="${tableStatusDTOs}" var="tableStatusDTO">
					<div class="col-md-6">
						<div class="form-group">
							<div class="form-radio form-radio-flat">
								<label class="form-check-label"> <input type="radio"
									<c:if test="${dinnertable.getTablestatus().getTablestatusid() == tableStatusDTO.getTablestatusid()}">
														checked
													</c:if>
									class="form-check-input" name="tablestatusid"
									value='<c:out value="${tableStatusDTO.getTablestatusid()}"></c:out>'>
									<c:out value="${tableStatusDTO.getName() }"></c:out> <i
									class="input-helper"></i></label>
							</div>
						</div>
					</div>
				</c:forEach>

			</div>
			<div class="container-fluid clearfix">
				<span
					class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center"
					style="text-align: right; font-style: italic; font-size: 20px;">
					<button id="btnCapNhatTrangThaiBan" type="button"
						class="btn btn-primary">Cập nhật trạng thái</button>
				</span>
			</div>
		</form>
	</div>
	<!-- Trạng thái bàn [END]-->
	<c:if test="${dinnertable.getTablestatus().getTablestatusid() != 1 }">
		<!-- chặn hành động thêm hóa đơn của bàn không sử dụng -->
		<!-- Sản phẩm -->
		<div class="tab-pane fade " id="add-food"  role="tabpanel" aria-labelledby="add-food-tab">
			<div class="row add-food productlist" data-dinnertableid=${dinnertable.getDinnertableid()}>


			</div>
			<div
				class="d-flex align-items-center justify-content-between flex-wrap">
				<form
					class="mt-2 mt-md-0 d-none d-lg-block search-input btn btn-inverse-light btn-fw">
					<div class="input-group">
						<input id="inputSearch" style="border: 0;" type="text"
							class="form-control " placeholder="Tìm kiếm..."> <span
							id="btnSearch"
							class="input-group-addon d-flex align-items-center"><i
							class="icon-magnifier icons"></i></span>
					</div>
				</form>
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
			<div class="container-fluid clearfix">
				<span
					class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center"
					style="text-align: right; font-style: italic; font-size: 20px;">
					<button id='btnThemVaoHoaDon' type="button" class="btn btn-primary">Thêm
						vào hóa đơn</button>
				</span>
			</div>
		</div>
		<!-- Sản phẩm [END]-->
		<!-- Hóa đơn -->
		<div class="tab-pane fade " id="bill" role="tabpanel"
			aria-labelledby="bill-tab">
			<div class="tab-pane fade active show showbilldinner" data-dinnertableid=${dinnertable.getDinnertableid()} id="add-food" role="tabpanel" aria-labelledby="add-food-tab">

				<!-- </div> -->
			</div>
		</div>
		<!-- Hóa đơn [END]-->
	</c:if>
</div>
<!-- End Body Tab Menu -->
<script src="<c:out value="/resources/ajax-jquery/loadTable.js"/>"></script>
<script src="<c:out value="/resources/ajax-jquery/admin/index-update.js"/>"></script>