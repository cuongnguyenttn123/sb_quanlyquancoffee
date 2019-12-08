<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
    <div class="col-lg-12">
        <div class="card px-2">
            <div class="card-body">
                <div class="table-responsive w-100">
                    <table class="table">
                        <thead>
                        <tr class="bg-dark">
                            <th class="text-center text-white"></th>
                            <th class="text-center text-white">CN</th>
                            <th class="text-center text-white">T2</th>
                            <th class="text-center text-white">T3</th>
                            <th class="text-center text-white">T4</th>
                            <th class="text-center text-white">T5</th>
                            <th class="text-center text-white">T6</th>
                            <th class="text-center text-white">T7</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${scheduleDTOs}" var="scheduleDTO">
                            <tr class="text-right">
                                <td class="text-center"><c:out value="${scheduleDTO.getScheduleid()}" /></td>
                                <c:forEach var="i" begin="1" end="7">
                                    <td class="text-left">
                                        <div class="form-check">
                                            <label class="form-check-label"> <input
                                                    data-day='<c:out value="${i}" />'
                                                    data-scheduleid='<c:out value="${scheduleDTO.getScheduleid()}" />'
                                                    type="checkbox"
                                                    <c:forEach items="${dtos}" var="dto">
                                                    <c:if test = "${i == dto.getDay() &&  scheduleDTO.getScheduleid() == dto.getScheduleid()}">
                                                    <c:forEach items="${dto.getRegisters()}" var="register">
                                                            checked
                                                    </c:forEach>
                                                    </c:if>
                                                    </c:forEach>
                                                    class="form-check-input schedule">
                                                    <c:out value="${scheduleDTO.getStarttime()}" />-<c:out
                                                    value="${scheduleDTO.getEndtime()}" />
                                            </label>
                                        </div>
                                    </td>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</div>