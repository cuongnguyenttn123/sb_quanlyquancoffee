
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row section social-section">
	<div class="col-lg-6 grid-margin stretch-card">
		<!--form mask starts-->
		<div class="card">
			<div class="card-body">
				<h4 class="card-title">Danh sách sản phẩm</h4>
				<div class="form-group row">
					<table class="table table-striped">
						<thead>
						<tr>
							<th>Sản phẩm</th>
							<th>Số lượng</th>
							<th>Đơn giá</th>
							<th>Thành tiền</th>
							<th>Tùy Chọn</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach items="${productDTOs}" var="productDTO">
							<tr>
								<td class="py-1"><c:out value="${productDTO.getName() }"></c:out></td>
								<td><input type="number" min="1" value="<c:out
								 value='${productDTO.getNumber() }'></c:out>" /></td>
								<td><label class="badge badge-warning"> <c:out
										value="${productDTO.getPrice() }"></c:out>
								</label></td>
								<td><c:out
										value="${productDTO.getPrice()*productDTO.getNumber() }"></c:out>
								</td>
								<td><button type="button" class="btn btn-primary" id="btnXoaSanPham">Xóa</button></td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
				<h4 class="card-title">Tổng tiền toàn bộ sản phẩm: ${tongtien} VND</h4>
			</div>
		</div>
		<!--form mask ends-->
	</div>
	<div class="col-lg-6 grid-margin stretch-card">
		<!--form mask starts-->
		<div class="card">
			<div class="card-body">
				<h4 class="card-title">Thông tin khách hàng</h4>
				<form method="post" action="/user/pay-cart" class="forms-sample">
					<input id="listCart" name="listCart" type="hidden"
						value="<c:out value='${listCart }'></c:out>"
						class="form-control form-control-sm"> <input
						id="listNumberProduct2" name="listNumberProduct2" type="hidden"
						value="<c:out value='${listNumberProduct }'></c:out>"
						class="form-control form-control-sm">
					<div class="form-group">
						<label for="name" class="col-sm-12 col-form-label">Họ tên</label>
						<input id="name" name="name" type="text"
							class="form-control form-control-sm" placeholder="Họ tên:(*)">
					</div>
					<div class="form-group">
						<label for="address" class="col-sm-12 col-form-label">Địa chỉ</label>
						<input id="address" name="address" type="text"
							class="form-control form-control-sm" placeholder="Địa chỉ:(*)">
					</div>
					<div class="form-group">
						<label for="phone" class="col-sm-12 col-form-label">Số điện thọai</label>
						<input id="phone" name="phone" type="text"
							class="form-control form-control-sm"
							placeholder="Số điện thọai:(*)">
					</div>

					<div class="form-group">
						<label for="pass" class="col-sm-12 col-form-label">Password Kiểm tra hàng</label>
						<input id="pass" name="pass" type="password"
							   class="form-control form-control-sm"
							   placeholder="Password Kiểm tra hàng">
					</div>
					<div class="form-group">
						<label for="startdatetime" class="col-sm-12 col-form-label">Ngày giao hàng</label>
						 <input id="startdatetime"
							name="startdatetime" type="date"
							class="form-control form-control-sm">
					</div>
					<div class="form-group">
						<label for="notice" class="col-sm-12 col-form-label">Ghi chú</label>
						<textarea id="notice" name="notice" class="form-control"
							placeholder="Ghi chú:" rows="3"></textarea>
					</div>
					<div class="form-group">
						<label for="voucherName" class="col-sm-12 col-form-label">Mã giảm giá</label>
						<input id="voucherName" name="voucherName" type="text"
							class="form-control form-control-sm" placeholder="Mã giảm giá:">
					</div>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<button id="btnPayCart" type="submit" class="btn btn-success mr-2">Hoàn
						tất</button>
					<a href="/index" class="btn btn-light">Hủy</a>
				</form>
			</div>
		</div>
		<!--form mask ends-->
	</div>