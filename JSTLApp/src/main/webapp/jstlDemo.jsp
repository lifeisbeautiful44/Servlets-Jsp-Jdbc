<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Demo</title>
</head>
<body>
	<c:out value="${10*2}" />
	<c:set var="testScore" value="${60}" scope="session" />
	<c:out value="${ testScore}" />


	<c:if test="${testScore >=80 }">
		<p>
			Your Score is Awesome
			<c:out value="${ testScore}" />
		</p>
	</c:if>
	
	<c:choose>
	<c:when test="${testScore>=80}">
	A Grade.
	</c:when>
		<c:when test="${testScore>=60 && testScore<80}">
	B Grade.
	</c:when>
	<c:otherwise>
	C grade.
	</c:otherwise>

	</c:choose>
	
	<c:forEach var = "i" begin = "1" end = "3">
	<c:out value="${i}"/>
	</c:forEach>
	
	
	<%
   List<String> studentNames = new ArrayList<>();
	studentNames.add("Srijansil");
	studentNames.add("Srijansil2");
	studentNames.add("Srijansil3");
	studentNames.add("Srijansil4");
	request.setAttribute("studentNames", studentNames);
	%>
	
	<c:forEach var= "name" items = "${studentNames}">
	<c:out value="${name }" />
	</c:forEach>
	
  <c:set var="bankBalance" value="12345"/>
  <fmt:parseNumber var = "i" type ="number" value="${bankBalance} "/>
  <c:out value="${i }"/>
  
    <c:set var="accBal" value="12345.6789"/>
    <p> Formatted Number1: <fmt:formatNumber value="${accBal}"  type="currency"   /> </p>
    <p> Formatted Number2: <fmt:formatNumber value="${accBal}"  type="number" maxFractionDigits="3"  /> </p>
    <p> Formatted Number3: <fmt:formatNumber value="${accBal}"  type="percent"   /> </p>
    <p> Formatted Number1: <fmt:formatNumber value="${accBal}"  type="number" pattern="####.###^^"   /> </p>
    
    
    <c:set var="myDate" value="04-11-2022"/>
    <fmt:parseDate var = "parseDate" value="${myDate}" pattern="dd-MM-YYYY"/>
   <p> <c:out value="${parseDate }"/> </p>
    
    
     
	After Removal the value is:
	<c:remove var="testScore" />
	<c:out value="${testScore }" />

</body>
</html>

