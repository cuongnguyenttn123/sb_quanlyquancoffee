<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<div class="row add-food">
    <c:forEach items="${productDTOs}" var="productDTO">
        <div class="col-md-2 grid-margin stretch-card">
            <div class="" style="margin: 5px;">
                <div class="d-flex flex-row" style="text-align: center;">
                    <img
                            src='../resources/images/my-images/<c:out value="${productDTO.getImage() }"></c:out>'
                            class="img-lg rounded">
                </div>
                <nav class="quanlity-product img-lg" style="text-align: center;">
                    <label class="badge badge-warning" style="width: 100%;"><c:out
                            value="${productDTO.getName() }"></c:out></label>
                    <div class="btn-group soluong1" role="group"
                         aria-label="Basic example">
                        <!-- <button type="button" class="btn btn-danger icon-btn ">
                        <i class="fa fa-backward"></i>
                    </button> -->
                        <input class="form-control border-danger"
                               data-productid='<c:out value="${productDTO.getProductid() }"></c:out>'
                                <c:if test = "${productDTO.getQuantity() > 0}">
                                    value='<c:out value="${productDTO.getQuantityInventory() }"></c:out>'
                                </c:if>
                               type="number" />
                        <!-- <button type="button" class="btn btn-danger icon-btn ">
                        <i class="fa fa-forward"></i>
                    </button> -->
                    </div>
                </nav>
            </div>
        </div>
    </c:forEach>

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