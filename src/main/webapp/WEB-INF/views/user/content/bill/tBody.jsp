<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	<c:forEach items="${dtos}" var="dto">
		<tr>
			<td><c:out value="${dto.getBill().getBillid()}" /></td>

			<td><c:out value="${dto.getTotalPrice()}" /></td>
			<td><c:out value="${dto.getBillstatus().getName()}" /></td>
			<td class="text-danger"><c:out
					value="${dto.getBill().getEnddate()}" /></td>
			<td>
				<a href="/user/ordertracking/<c:out value="${dto.getBill().getBillid()}" />">Chi tiết đơn hàng</a>
			</td>
		</tr>
	</c:forEach>