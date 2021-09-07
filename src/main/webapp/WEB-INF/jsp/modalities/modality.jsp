<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../commons/header.jspf"%>
<%@ include file="../commons/navigation.jspf"%>
<div class="container">
 <div class="row">
  <div class="col-md-6 col-md-offset-3 ">
   <div class="panel panel-primary">
    <div class="panel-heading">Adicionar Modalidad</div>
    <div class="panel-body">
     <form:form method="post" modelAttribute="modality">
      <form:hidden path="id" />
      <fieldset class="form-group">
       <form:label path="nombre">Nombre</form:label>
       <form:input path="nombre" type="text" class="form-control"
        required="required" />
       <form:errors path="nombre" cssClass="text-warning" />
      </fieldset>
      
      <fieldset class="form-group">
       <form:label path="descripcion">Descripción</form:label>
       <form:input path="descripcion" type="text" class="form-control"
        required="required" />
       <form:errors path="descripcion" cssClass="text-warning" />
      </fieldset>

<!--       <fieldset class="form-group"> -->
<%--        <form:label path="targetDate">Target Date</form:label> --%>
<%--        <form:input path="targetDate" type="text" class="form-control" --%>
<%--         required="required" /> --%>
<%--        <form:errors path="targetDate" cssClass="text-warning" /> --%>
<!--       </fieldset> -->

      <button type="submit" class="btn btn-success">Aceptar</button>
     </form:form>
    </div>
   </div>
  </div>
 </div>
</div>
<%@ include file="../commons/footer.jspf"%>