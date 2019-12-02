<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<c:if test="${ exportbilldetails != null}">
    <c:set var = "i" scope = "session" value = "${1}"></c:set>
    <c:forEach items="${exportbilldetails}" var="exportbilldetail">
        <div class="detail-material">
        <tr class="0">
            <td><label class="badge badge-danger remove-import" data-remove-import='<c:out value="${i }"></c:out>'><i
                    class="fa fa-times"></i></label></td>
            <td><c:out value="${exportbilldetail.getMaterialdetail().getMaterialdetailid()}" /></td>
            <td><input id="materialdetailid" name="materialdetailid" type="hidden" value='<c:out value="${exportbilldetail.getMaterialdetail().getMaterialdetailid()}" />' />
                <select class="" id="materialid" disabled="disabled"
                        style="border: 2px solid #f2f2f2; width: 80px;">
                    <option value="-1"></option>
                    <c:forEach items="${materials}" var="material">
                        <option
                                <c:if test="${exportbilldetail.getMaterialdetail().getMaterial().getMaterialid()==material.getMaterialid()}">
                                    selected
                                </c:if>
                                value='<c:out value = "${material.getMaterialid()}" />'>
                            <c:out value="${material.getName() }" />
                        </option>
                    </c:forEach>
                </select></td>
            <td><input id="quantity" name="quantity" type="number"
                       style="border: 2px solid #f2f2f2; width: 70px;"
                       value='<c:out value="${exportbilldetail.getQuantity()}" />'
                       placeholder="0" /></td>
                <%-- <td><input id="dateofmanufacture" type="date"
                    style="border: 2px solid #f2f2f2; width: 100px;"
                    value='<c:out value="${ exportbilldetail.getMaterialdetail().getDateofmanufacture()}" />' /></td>
                <td><input id="expirationdate" type="date"
                    style="border: 2px solid #f2f2f2; width: 100px;"
                    value='<c:out value="${ exportbilldetail.getMaterialdetail().getExpirationdate()}" />' /></td> --%>
        </tr>
        <c:set var = "i" scope = "session" value = "${i + 1}"></c:set>
        </div>
    </c:forEach>
</c:if>
