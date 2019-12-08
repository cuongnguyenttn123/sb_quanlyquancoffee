<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/29/2018
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <jsp:include page="common/head.jsp"/>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div id="header" class="nav3-inverse">
    <div class="nen">
        <img style="width: 100%;height: 450px" src="<c:out value="resources/images/cafe-me.jpg"/>" alt="">
    </div>

    <div class="event_header text-center container wow bounceIn">
        <span style="color: red">Ngay 10/10/2018</span><br/>
        <span style="font-size: 50px; color: #0c85d0">Mua 1 tang 1</span><br/>
        <button type="button" class="btn btn-info">Xem Ngay</button>
    </div>

</div>
<%--den phan san pham noi bat--%>
<div class="container">

    <hr class="thegach">
    <h1 class="text-center thegach">Sản Phẩm Hot</h1>


    <%--san pham hot--%>



    <div class="row">

        <c:forEach items="${productDTOs}" var="productDTO">
            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                <div class="thumbnail wow flipInX ">
                    <c:forEach items="${productDTO.getImages()}" var="image">
                        <img style="height: 250px" class="d-block w-100 col-lg-12 img-<c:out value="${productDTO.getProductid()}" />"
                            src='../resources/images/my-images/<c:out value="${image.getName()}" />'
                            alt='<c:out value="${alt}" />'>
                    </c:forEach>
                    <div class="caption text-center">
                        <div class="product-body">
                            <p class="product-category">
                                <c:out
                                        value="${productDTO.getCategoryproductNAME()}" />
                            </p>
                            <h3 class="product-name product-name-<c:out value="${productDTO.getProductid()}" />">
                                <c:out value="${productDTO.getName()}" />
                            </h3>
                            <h4 class="product-price product-price-<c:out value="${productDTO.getProductid()}" />">
                                <c:if test="${productDTO.getNewPrice()!=null}">
                                    <!-- new price -->
                                    <c:out value="${productDTO.getNewPrice().getPrice()}" />
                                    <del class="product-old-price">
                                        <c:out value="${productDTO.getPrice()}đ" />
                                    </del>
                                </c:if>
                                <c:if test="${productDTO.getNewPrice()==null}">
                                    <c:out value="${productDTO.getPrice()}đ" />
                                </c:if>
                            </h4>
                            <div class="product-rating">
                                <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
                                    class="fa fa-star"></i> <i class="fa fa-star"></i> <i
                                    class="fa fa-star"></i>
                            </div>
                            <div class="product-btns">
                                <button id="IDsanpham" title="Quan tâm" class="add-to-wishlist"
                                        tabindex="-1">
                                    <i class="fa fa-heart-o"></i>
                                </button>
                                <button title="Xem đánh giá" class="add-to-compare" tabindex="-1">
                                    <i class="fa fa-star-half-empty"></i>
                                </button>
                                <button
                                        data-PId='<c:out value="${productDTO.getProductid()}"></c:out>'
                                        title="Xem nhanh" class="quick-view btn-View" tabindex="-1"
                                        data-toggle="modal" data-target="#exampleModal">
                                    <i class="fa fa-eye"></i>
                                </button>
                                <button
                                        data-PId='<c:out value="${productDTO.getProductid()}"></c:out>'
                                        title="Thêm vào giỏ" class="quick-view btn-add-to-cart"
                                        tabindex="-1">
                                    <i class="fa fa-shopping-cart"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </c:forEach>
        <!-- End Display Product -->
        <!-- Detail Product -->

    </div>

</div>

<div>
    <hr class="thegach">
    <div class="row">
        <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4 wow fadeInLeft" data-wow-duration="500">
            <div class="thumbnail canchuan">
                <img class="tag_icon" src="<c:out value="resources/images/chatluong.png"/>" alt="">
                <div class="caption text-center">
                    <h3>Chất Lượng</h3>
                    <p>
                        Chúng tôi  cam kết mang tới chất lượng tốt nhất.
                    </p>
                </div>
            </div>
        </div>
        <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4 wow fadeInDown" data-wow-duration="500">
            <div class="thumbnail canchuan">
                <img class="tag_icon" src="<c:out value="resources/images/chiphi.png"/>" alt="">
                <div class="caption text-center">
                    <h3>Tiết kiệm chi phí</h3>
                    <p>
                        Mang tới cho bạn những thức uống ngon với chi phí rẻ nhất
                    </p>

                </div>
            </div>
        </div>
        <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4 wow fadeInRight" data-wow-duration="500">
            <div class="thumbnail canchuan">
                <img class="tag_icon" src="<c:out value="resources/images/vanchuyen.png"/>" alt="">
                <div class="caption text-center">
                    <h3>Giao hàng tận nơi</h3>
                    <p>
                        Miễn phí giao hàng trong bán kính 5km, chi phí giao hàng rẻ và tiết kiệm
                    </p>

                </div>
            </div>
        </div>

    </div>
    <jsp:include page="common/jsLibary.jsp"/>
</div>


<jsp:include page="common/footer.jsp"/>
</body>



</html>
