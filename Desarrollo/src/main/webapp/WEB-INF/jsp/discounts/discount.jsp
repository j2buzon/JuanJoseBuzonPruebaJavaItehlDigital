<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../commons/header.jspf"%>
<%@ include file="../commons/navigation.jspf"%>
<div class="container">
 <div class="row">
  <div class="col-md-6 col-md-offset-3 ">
   <div class="panel panel-primary">
    <div class="panel-heading">Crear Descuento</div>
    <div class="panel-body">
     <form:form method="post" modelAttribute="discount">
      <form:hidden path="id" />
      <fieldset class="form-group">
       <form:label path="nombre">Nombre</form:label>
       <form:input path="nombre" type="text" class="form-control"
        required="required" />
       <form:errors path="nombre" cssClass="text-warning" />
      </fieldset>
      
      <fieldset class="form-group">
       <form:label path="curso.id">Curso</form:label>
       <form:select path="curso.id" class="form-control" required="required"> 
       	<c:forEach items="${courses}" var="course">
       		<form:option value="${course.id}" label="${course.nombre}"/>
       	</c:forEach>
        </form:select>  
       <form:errors path="curso.id" cssClass="text-warning" />
      </fieldset>
      
      <fieldset class="form-group">
       <form:label path="pais">País</form:label>
       <form:select path="pais" class="form-control" required="required">
        <form:option value="ARG" label="Argentina"/>
        <form:option value="BRA" label="Brasil"/>
        <form:option value="COL" label="Colombia"/>
        <form:option value="CHI" label="Chile"/>
        <form:option value="ECU" label="Ecuador"/>
        <form:option value="PAR" label="Paraguay"/>
        <form:option value="PER" label="Perú"/>
        <form:option value="URU" label="Uruguay"/>
        <form:option value="VEN" label="Venezuela"/>
        </form:select>  
       <form:errors path="pais" cssClass="text-warning" />
      </fieldset>

      <fieldset class="form-group">
       <form:label path="fechaFinal">Fecha Final</form:label>
       <form:input path="fechaFinal" type="text" class="form-control" required="required" />
       <form:errors path="fechaFinal" cssClass="text-warning" />
      </fieldset>

      <button type="submit" class="btn btn-success">Aceptar</button>
     </form:form>
    </div>
   </div>
  </div>
 </div>
</div>
<%@ include file="../commons/footer.jspf"%>