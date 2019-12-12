<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<div class="tab-pane fade active show" id="add-food" role="tabpanel"
     aria-labelledby="add-food-tab">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>#</th>
            <th>Sản phẩm</th>
            <th>Đơn giá</th>
            <th>Số lượng</th>
            <th>Thành tiền</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:set var="i" scope="session" value="0" />
        <c:set var="j" scope="session" value="1" />
        <c:set var="trClass" scope="session" value="" />
        <c:forEach items="${dtos}" var="dto">

            <c:if test="${i == 0}">
                <c:set var="trClass" scope="session" value="table-info" />
            </c:if>
            <c:if test="${i == 1}">
                <c:set var="trClass" scope="session" value="table-warning" />
            </c:if>
            <c:if test="${i == 2}">
                <c:set var="trClass" scope="session" value="table-danger" />
            </c:if>
            <c:if test="${i == 3}">
                <c:set var="trClass" scope="session" value="table-success" />
            </c:if>
            <c:if test="${i == 4}">
                <c:set var="trClass" scope="session" value="table-primary" />
            </c:if>
            <tr id="product-remove-<c:out value="${dto.getProductid()}"></c:out>"
                data-productid="<c:out value="${dto.getProductid()}"></c:out>"
                class='<c:out value="${trClass}"></c:out>'>
                <td><c:out value="${j}"></c:out></td>
                <td><c:out value="${dto.getName()}"></c:out></td>
                <td><c:out value="${dto.getSinglePrice()}"></c:out></td>
                <td><c:out value="${dto.getQuantity()}"></c:out></td>
                <td><c:out value="${dto.getTotalPrice()}"></c:out></td>
                <td><label
                        data-productid='<c:out value="${dto.getProductid()}"></c:out>'
                        class="badge badge-danger remove-product"><i
                        class="fa fa-times"></i></label></td>
            </tr>

            <c:if test="${i == 4}">
                <c:set var="i" scope="session" value="0" />
            </c:if>
            <c:set var="i" scope="session" value="${i + 1}" />
            <c:set var="j" scope="session" value="${j + 1}" />
        </c:forEach>
        </tbody>
    </table>
    <div class="container clearfix">
					<span id="discount"
                          class="text-muted d-block text-center text-sm-left d-sm-inline-block"
                          style="text-align: right; color: #fd3258 !important; font-size: 15px;">Giảm giá
						:
					</span><br>
        <span id="totalPriceOLD"
              class="text-muted d-block text-center text-sm-left d-sm-inline-block"
              style="text-align: right; color: #fd3258 !important; font-size: 18px;">
					</span><br>
        <span id="totalPriceNEW"
              class="text-muted d-block text-center text-sm-left d-sm-inline-block"
              style="text-align: right; color: #fd3258 !important; font-size: 23px;">Tổng
						tiền: <c:out value="${totalPriceBill}đ"></c:out>
					</span>
        <span
                class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center"
                style="text-align: right; font-style: italic; font-size: 20px;">
						<p>
							Ngày lập:
							<c:out value="${bill.getStartdatetime()}"></c:out>
						</p>
						<div class="form-group row">
							<div class="col-sm-12">
								<div data-repeater-item="" class="d-flex mb-2">
									<div class="input-group mb-2 mr-sm-2 mb-sm-0">
										<input id='voucherName' type="text" class="form-control"
                                               placeholder="Mã giảm giá">
									</div>
									<button id="btnCheckVoucher" type="submit" class="btn btn-success btn-sm"> <i class="fa fa-check"></i></button>
								</div>
							</div>
						</div>
						<button id="btnLuuChinhSua" type="button" class="btn btn-primary">Lưu
							chỉnh sửa</button>
						<button id="btnThanhToan" type="button" class="btn btn-primary">Thanh
							toán</button>
					</span>
    </div>
    <!-- </div> -->
</div>