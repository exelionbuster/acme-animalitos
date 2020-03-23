<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="groomers">
    <h2>Pet Groomers</h2>

    <table id="groomersTable" class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Types</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${groomers.petGroomerList}" var="groomer">
            <tr>
                <td>
                    <c:out value="${groomer.firstName} ${groomer.lastName}"/>
                </td>
                <td>
                    <c:forEach var="type" items="${groomer.types}">
                        <c:out value="${type.name} "/>
                    </c:forEach>
                    <c:if test="${groomer.nrOfTypes == 0}">none</c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <table class="table-buttons">
        <tr>
            <td>
                <a href="<spring:url value="/groomers.xml" htmlEscape="true" />">View as XML</a>
            </td>            
        </tr>
    </table>
</petclinic:layout>
