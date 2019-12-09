
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<!-- head -->
<%@ include file="common/head.jsp"%>
<!-- head [END] -->

<body style="background-color: white">
<div class="container-scroller">

    <!-- nav -->0

    <%@ include file="common/nav.jsp"%>
    <!-- nav [END] -->

    <!-- content-wrapper -->
    <div class="container-fluid page-body-wrapper"
         style="height:650px;background: url(<c:out value="/resources/images/background.jpg"/>); background-size: cover;">
        <!-- content -->
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
                                <jsp:include page="content/tBody.jsp"/>
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

        <!-- content [END] -->
    </div>
    <!-- page-body-wrapper ends -->
</div>

<!-- js libary-->
<%@ include file="./common/jsLibary.jsp"%>
<!-- js libary [END] -->

<!-- Modal -->
<script src="<c:out value="/resources/ajax-jquery/book-table.js"/>"></script>
<!-- End Modal -->

</body>

</html>