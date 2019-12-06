<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-md-7 grid-margin stretch-card">
    <div class="card">
    <div class="card-body">
        <h4 class="card-title">Danh sách sản phẩm</h4>
        <p id="result-tbody" class="card-description"><code></code>
        </p>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Tên</th>
                <th>Lọai sản phẩm</th>
                <th>Cập nhập lần cuối</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${product}" var="dto">
                    <tr>
                        <td><c:out value="${dto.getProduct().getName()}" /></td>
                        <td class="text-danger"><c:out value="${dto.getQuantity()}" /></td>
                        <td><c:out value="${dto.getProduct().getUpdateat()}" /></td>
                    </tr>
                </c:forEach>
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