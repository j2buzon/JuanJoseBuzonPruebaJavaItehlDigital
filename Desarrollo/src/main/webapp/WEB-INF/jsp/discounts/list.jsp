<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../commons/header.jspf"%>
<%@ include file="../commons/navigation.jspf"%>
<div class="container">
 <div>
  <a class="btn btn-primary btn-md" href="add-discount">Crear Descuento</a>
 </div>
 <br>
 <div class="panel panel-primary">
  <div class="panel-heading">
   <h3>Listado de Descuentos</h3>
  </div>
  <div class="panel-body">
   <table class="table table-striped">
    <thead>
     <tr>
      <th width="20%">Nombre</th>
      <th width="15%">Modalidad</th>
      <th width="10%">País</th>
      <th width="15%">Descuento</th>
      <th width="25%">Curso</th>
      <th width="15%">Fecha final</th>
     </tr>
    </thead>
    <tbody>
     <c:forEach items="${discounts}" var="discount">
      <tr>
       <td>${discount.nombre}</td>
       <td>${discount.modalidad.nombre}</td>
       <td>${discount.pais}</td>
       <td>${discount.valorDescuento}</td>
       <td>${discount.curso.nombre}</td>
       <td>${discount.fechaFinal}</td>
     </c:forEach>
    </tbody>
   </table>
  </div>
 </div>

</div>
<%@ include file="../commons/footer.jspf"%>