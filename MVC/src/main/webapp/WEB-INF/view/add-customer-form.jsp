<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Customer Form</title>
    <!-- include any necessary CSS or JavaScript -->
</head>
<body>

    <h2>Add Customer</h2>

    <form action="${pageContext.request.contextPath}/customer/addCustomer" method="post">
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" required>
        <br>
        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" required>
        <br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        <br>
        <input type="submit" value="Add Customer">
    </form>

</body>
</html>
