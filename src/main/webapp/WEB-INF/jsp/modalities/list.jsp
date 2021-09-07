<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../commons/header.jspf"%>
<%@ include file="../commons/navigation.jspf"%>
<div class="container">
 <div>
  <a class="btn btn-primary btn-md" href="modalidad">Adicionar Modalidad</a>
 </div>
 <br>
 <div class="panel panel-primary">
  <div class="panel-heading">
   <h3>Listado de Modalidades</h3>
  </div>
  <div class="panel-body">
   <table class="table table-striped">
    <thead>
     <tr>
      <th width="30%">Nombre</th>
      <th width="70%">Descripción</th>
     </tr>
    </thead>
    <tbody>
     <c:forEach items="${modalities}" var="modality">
      <tr>
       <td>${modality.nombre}</td>
       <td>${modality.descripcion}</td>
     </c:forEach>
    </tbody>
   </table>
  </div>
 </div>

</div>
<%@ include file="../commons/footer.jspf"%>