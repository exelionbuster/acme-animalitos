<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="clinics">
    <h2>Shops</h2>

    <table id="clinicsTable" class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Address</th>
            <th>Phone Number</th>
            <th>Email</th>
            <th>Opening Hour</th>
            <th>Closing Hour</th>
            <th>Shop ID</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${clinics}" var="clinic">
            <tr>
                <td>
                    <c:out value="${clinic.name}"/>
                    
                </td>
                <td>
                    <c:out value="${clinic.address}"/>
                    
                </td>
                <td>
                    <c:out value="${clinic.phoneNumber}"/>
                    
                </td>
                <td>
                    <c:out value="${clinic.email}"/>
                    
                </td>
                <td>
                    <c:out value="${clinic.openingHour}"/>
      
                </td>
                <td>
                    <c:out value="${clinic.closingHour}"/>
                    
                </td>
                <td>
                    <c:out value="${clinic.shop.id}"/>
                    
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</petclinic:layout>
