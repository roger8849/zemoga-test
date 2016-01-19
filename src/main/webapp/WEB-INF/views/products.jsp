<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>
    </head>
    <body>
        <div align="center">
            <h1>Products List</h1>
            <table border="1">
                <th>SKU</th>
                <th>Name</th>
                <th>Price</th>
                 
                <c:forEach var="product" items="${products}" >
                <tr>
                    <td>${product.sku}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                             
                </tr>
                </c:forEach>              
            </table>
        </div>
    </body>
</html>