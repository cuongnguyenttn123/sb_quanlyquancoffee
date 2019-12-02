<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="form-group ">
	<label for="exportbillid" class="  col-form-label">Sản phẩm</label>
	<input
		id="exportbillid" name="exportbillid" type="hidden"
		value='<c:out value="${exportbill.getExportbillid()}" />' />
	<select
		<c:if test="${exportbilldetails != null}">
                                disabled="disabled"
                        </c:if>
		class="form-control" id="productid">
		<option value="-1"></option>
		<c:forEach items="${products}" var="product">
			<option
				<c:if test="${exportbill!= null }">
					selected
				</c:if>
				value='<c:out value = "${product.getProductid()}" />'>
				<c:out value="${product.getName() }" />
			</option>
		</c:forEach>
	</select>
</div>
<div class="form-group ">
	<label for="quantityProduct" class="  col-form-label">Số lượng sản phẩm chế biến được</label>
	<input id="quantityProduct" type="number" class="form-control" value='<c:out value="${exportbill.getQuantity() }" />'>
</div>
<table class="table">
	<thead>
		<tr>
			<th></th>
			<th>ID</th>
			<th>Nguyên liệu</th>
			<th>Số lượng</th>
		</tr>
	</thead>
	<tbody>
	<div id="containermaterial">
		<div class="detail-material">
			<tr class="-1 detail-material1" hidden>
			<td>
				<label class="badge badge-danger remove-import" data-remove-import="-1"><i class="fa fa-times"></i></label></td>
			<td class="detail-material2">
				<input id="materialdetailid" name="materialdetailid" type="hidden" />
				<label for="materialid" class="  col-form-label"></label>
				<select class="" id="materialid" name = "materialid" style="border: 2px solid #f2f2f2; width: 80px;">
					<option value="-1"></option>
					<c:forEach items="${materials}" var="material">
						<option value='<c:out value = "${material.getMaterialid()}" />'>
							<c:out value="${material.getName() }" />
						</option>
					</c:forEach>
				</select>
			</td>
			<td>
				<input id="quantityproduc" name="quantity" type="number" style="border: 2px solid #f2f2f2; width: 70px;" placeholder="0" />
			</td>
		</tr>
		</div>
	<div/>
		<%@ include file="./foreach.jsp"%>
	</tbody>
</table>
<div class="form-group" style="text-align: center;">
	<button id="btn-Add-Row" type="button"
		class="btn btn-light btn-rounded btn-fw">
		<i class="mdi mdi-plus"></i>
	</button>
</div>
<c:if test="${exportbilldetails ==null}">
	<button id="btnSave" type="button" class="btn btn-success mr-2">
		Thêm</button>
</c:if>
<c:if test="${exportbilldetails!=null}">
	<button id="btnUpdate" type="button" class="btn btn-success mr-2">
		Cập nhật</button>
</c:if>
<button id="btnClear" class="btn btn-light">Làm mới</button>
<div class="modal fade bd-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Bạn muốn xóa dòng này?</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
        <button type="button" class="btn btn-primary">Đồng ý</button>
      </div>
    </div>
  </div>
</div>

<script
	src="../resouces/ajax-jquery/warehouse/export-material/export-bill-edit.js"></script>
