<%-- 
    Document   : update
    Created on : Mar 6, 2023, 5:27:45 PM
    Author     : TrungKien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update a Product</h1>
        <c:set var="c" value="${requestScope.product}"/>
        <form action="update" method="post">
            ID: <input type="text" value="${c.id}" readonly name="id" /><br/>
            Enter Category ID; <select name="category_id" id="category_id">
                <c:forEach var="cate" items="${requestScope.categories}">
                    <option ${(c.category_id == cate.id)? "selected":""} value="${cate.id}">${cate.name}</option>
                </c:forEach>
            </select>
            Enter Title: <input type="text" name="title" value="${c.title}"><br/>
            Enter price: <input type="text" name="price" value="${c.price}"><br/>
            Enter quantity: <input type="text" name="quantity" value="${c.quantity}"><br/>
            Enter discount: <input type="text" name="discount" value="${c.discount}"><br/>
            Enter description: <input type="text" name="description" value="${c.description}"><br/>

            Enter status: <input type="text" name="status" value="${c.status}"><br/>
<!--            Enter brand_id; <input type="text" name="brand_id" value="${c.brand_id}"><br/>-->
            Enter brand_id: 
            <select name="brand_id" id="brand_id">
                <c:forEach var="brand" items="${requestScope.brands}">
                    <option ${(c.brand_id == brand.id)? "selected":""} value="${brand.id}">${brand.name}</option>
                </c:forEach>
            </select>

            Enter image; <input type="text" name="image" value="${c.image}"><br/>

            <input type="submit" value="SAVE">
        </form>
    </body>
</html>
