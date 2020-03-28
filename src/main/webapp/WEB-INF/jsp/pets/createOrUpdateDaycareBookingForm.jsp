<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="daycareBookings">
    <jsp:attribute name="customScript">
        <script>
            $(function () {
                $("#birthDate").datepicker({dateFormat: 'yy/mm/dd'});
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <h2>
            <c:if test="${daycareBooking['new']}">New </c:if> reserva
        </h2>
        <form:form modelAttribute="daycareBooking"
                   class="form-horizontal">
            <input type="hidden" name="id" value="${petId}"/>
            <div class="form-group has-feedback">
                <div class="form-group">
                    <label class="col-sm-2 control-label">Owner</label>
                    <div class="col-sm-10">
                        <c:out value="${pet.owner.firstName} ${pet.owner.lastName}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Nombre de la mascota</label>
                    <div class="col-sm-10">
                        <c:out value="${pet.name}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Tipo de mascota</label>
                    <div class="col-sm-10">
                        <c:out value="${pet.type}"/>
                    </div>
                </div>
                <petclinic:inputField label="Fecha de entrada" name="start"/>
                <petclinic:inputField label="Fecha de salida" name="end"/>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <c:choose>
                        <c:when test="${new_pet}">
                            <button class="btn btn-default" type="submit">Registrar visita</button>
                        </c:when>
                        <c:otherwise>
                            <button class="btn btn-default" type="submit">Actualizar visita</button>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </form:form>
    </jsp:body>
</petclinic:layout>