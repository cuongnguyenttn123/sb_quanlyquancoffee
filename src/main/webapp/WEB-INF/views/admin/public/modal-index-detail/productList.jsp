<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

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