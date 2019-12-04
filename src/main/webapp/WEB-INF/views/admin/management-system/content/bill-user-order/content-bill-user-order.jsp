<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
    <h3>Theo dõi đơn hàng</h3>
    <div id="changer"></div>
    <div>
        <div class="progressbar-container">
            <input id="valueid" type="hidden" value="${value.getBillstatus().getBillstatusid()}">
            <c:if test="${value.getBillstatus().getBillstatusid() == 'HDH'}">
                <jsp:include page="progressbar_2.jsp"></jsp:include>
            </c:if>
            <c:if test="${value.getBillstatus().getBillstatusid() != 'HDH'}">
                <jsp:include page="progress_4.jsp"></jsp:include>
                <c:if test="${value.getBillstatus().getBillstatusid() == 'CD'}">
                    <div class="form-group ">
                        <label for="billid" class="  col-form-label">Chọn Shipper để duyệt đơn hàng: </label>
                        <form action="/admin/duyetdonhang" method="post">
                            <input id="billid" name="billid" type="hidden"
                                   value='<c:out value="${value.getBillid()}" />' />
                            <div class="row">
                                <div class="col-4">
                                    <select class="form-control" id="employeeid" name="employeeid">
                                        <option value="-1"></option>
                                        <c:forEach items="${listEmployee}" var="listEmployee">
                                            <option value='<c:out value = "${listEmployee.getEmployeeid()}" />'>
                                                <c:out value="${listEmployee.getName() }" />
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-danger" id="btnDuyet" value="${value.getBillid()}">Duyệt Đơn Hàng</button>
                        </form>


                    </div>
                    <br>
                    <div class="row">
                        <br>
                        <br>
                    </div>
                </c:if>
            </c:if>
        </div>
    </div>
</div>