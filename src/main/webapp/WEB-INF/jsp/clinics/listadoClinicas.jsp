<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="clinics">
    <h2>Clinics</h2>

    <table id="clinicsTable" class="table table-striped">
        <thead>
        <tr>
            <th style="width: 200px;">Name</th>
            <th style="width: 200px;">Address</th>
            <th style="width: 120px">Phone Number</th>
            <th style="width: 120px">Email</th>
            <th style="width: 50px;">Opening Hour</th>
            <th style="width: 50px;">Clossing Hour</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${clinics}" var="clinic">
            <tr>
                <td>
                    <c:out value="${clinic.name}"/></a>
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
                    <c:out value="${clinic.openingHour}"/></a>
                </td>
                <td>
                    <c:out value="${clinic.clossingHour}"/></a>
                </td>       
            </tr>
        </c:forEach>
        </tbody>
    </table>
</petclinic:layout>
