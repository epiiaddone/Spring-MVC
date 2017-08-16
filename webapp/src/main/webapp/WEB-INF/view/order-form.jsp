<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<head>

 <style type="text/css">
 .error{color:red}
 </style>

</head>



<body>

<form:form action="processForm" modelAttribute="order">

<h4>Order Page -  (*) means required. </h4>

<br>
Product Options:
<br>
Product 1<form:checkbox path="selected" value="product 1"/>
Product 2<form:checkbox path="selected" value="product 2"/>
Product 3<form:checkbox path="selected" value="product 3"/> *
<form:errors path="selected" class="error" />

<br><br>
Delivery Option:
<br>

Next Day: £5.00 <form:radiobutton path="delivery" value="Next Day" checked = "true"/>
1st Class: £3.50<form:radiobutton path="delivery" value="1st Class" />
Standard: £ 2.50<form:radiobutton path="delivery" value="Standard"/>
<form:errors path="delivery" class="error" />

<br><br>

Discount Code: <form:input path="discountCode" />

<br><br>

<h4>Customer Details:</h4>

<br>

First Name: <form:input path="firstName"/>

<br><br>

Last Name: <form:input path="lastName" /> *
<form:errors path="lastName" class="error" />
<br><br>

1st line of address: <form:input path="firstLineAddress" /> *
<form:errors path="firstLineAddress" class="error" />
<br><br>

Postcode: <form:input path="postCode" /> *
<form:errors path="postCode" class="error" />

<br><br>


<input type="submit" value="submit" />

</form:form>






</body>



</html>