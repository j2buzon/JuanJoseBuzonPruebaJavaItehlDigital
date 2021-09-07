<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../commons/header.jspf"%>
<%@ include file="../commons/navigation.jspf"%>
<div class="container">
 <div>
  <a type="button" class="btn btn-primary btn-md" href="add-curso">Adicionar Curso</a>
 </div>
 <br>
 <div class="panel panel-primary">
  <div class="panel-heading">
   <h3>Listado de Cursos</h3>
  </div>
  <div class="panel-body">
   <table class="table table-striped">
    <thead>
     <tr>
      <th width="15%">Nombre</th>
      <th width="15%">Costo</th>
      <th width="10%">Horas</th>
      <th width="30%">Dirigido a</th>
      <th width="20%">Modalidad</th>
      <th width="10%"></th>
     </tr>
    </thead>
    <tbody>
     <c:forEach items="${courses}" var="course">
      <tr>
       <td>${course.nombre}</td>
       <td>${course.costo}</td>
       <td>${course.horas}</td>
       <td>${course.dirigidoA}</td>
       <td>${course.modalidad.nombre}</td>
       <td><a type="button" class="btn btn-success" href="update-curso?id=${course.id}">Editar</a>
        </td>
      </tr>
     </c:forEach>
    </tbody>
   </table>
  </div>
 </div>

</div>
<%@ include file="../commons/footer.jspf"%>