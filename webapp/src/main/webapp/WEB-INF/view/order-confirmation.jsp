<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<head>
<title>Order Confirmation Page</title>


</head>
<body>

<h4>Your Order</h4>

<ul>
<c:forEach var="temp" items="${order.selected}" >
<li> ${temp} </li>
</c:forEach>
</ul>
Delivery Option: ${order.delivery }
<br><br>
Discount Code: ${order.discountCode}
<br><br>
Total Price: £ ${order.price}
<br><br><br><br>
<h4>Delivering to:</h4>
${order.firstName} ${order.lastName}<br>
${order.firstLineAddress}<br>
${order.postCode}


</body>


</html>