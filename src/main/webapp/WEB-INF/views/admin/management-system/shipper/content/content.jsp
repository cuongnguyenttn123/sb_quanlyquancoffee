<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>All bill order by user</title>
</head>
<body>
<div class="container">
    <div class="row">

        <div class="col-12">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Danh sách người dùng đặt hàng:</h4>
                    <p id="result-tbody" class="card-description">
                        <code></code>
                    </p>
                    <table id="order-listing" class="table table-hover">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Tổng tiền</th>
                            <th>Tình trạng</th>
                            <th>Nhân Viên Phục Vụ</th>
                            <th>Chi tiết đơn hàng</th>

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

</div>
</body>
</html>
