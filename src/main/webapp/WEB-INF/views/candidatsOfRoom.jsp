<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

                   				<div  class="dataTables_wrapper form-inline dt-bootstrap">
                   					

											<table class="table table-bordered table-striped dataTable"  style="cursor: pointer;">
											  <thead>
											    <tr>
											      <th>Candidate Name</th>
											      <th>Mobile No</th>
											      <th>Emergency Phone</th>
											      <th>Room No</th>
											      <th>Room Type</th>
											      <th>Fee Amount</th>
											      <th>Join Date</th>
											      <th>Vacate Date</th>
											    </tr>
											  </thead>
											  <tbody>
											  <c:forEach var="candidate" items="${candidates }" varStatus="count">
											  		<tr>
											  		  <td>${candidate.name }</td>
											  		  <td>${candidate.mobileNo }</td>
											  		  <td>${candidate.emergencyContactNo }</td>
											  		  <td>${candidate.room.roomName }</td>
											  		  <td>${candidate.room.roomType.roomCategory }</td>
											  		  <td>${candidate.candidateFee }</td>
											  		  <td>${candidate.joinDate }</td>
											  		<c:choose>
											  		  	<c:when test="${candidate.vacationDate eq null }">
											  		  		<td>--</td>
											  		  	</c:when>
											  		  	<c:otherwise>
											  		  	   <td style="background-color: rgb(255, 224, 241);">${candidate.vacationDate}</td>
											  		  	</c:otherwise>
											  		  </c:choose>  
											  		 
											  </tr>
											  </c:forEach>	
											  
											  </tbody>
											 </table> 
                   					</div>
                   				
                   					