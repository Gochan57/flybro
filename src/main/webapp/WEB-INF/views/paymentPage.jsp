<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<jsp:include page="common/css.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/bootstrap/css/dataTables.bootstrap.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/bootstrap/css/bootstrap-datetimepicker.min.css"></link>
</head>
<body class="skin-blue sidebar-mini">
  <div class="wraper">
	<jsp:include page="common/header.jsp"></jsp:include>
	
	<div class="content-wrapper" style="margin-left: 0px;">
       
        <!-- Main content -->
        <section class="content">
			<div class=row style="margin-left: 10%;margin-right: auto;width: 120%;">
				<div class="col-md-8">
					<div class="box box-success">
                <!-- form start -->
                  <div class="box-body" >
                  	
                  	  <div class="col-md-12" style="box-shadow:3px 0px 15px 2px rgba(0, 0, 0, 0.125) ! important; padding-top:5px;">
                  	  <div class="row">
							<div class="col-md-6">
								<label class="col-md-3">Building</label>
								<div class="col-md-6">
								<select class="form-control" id="buildingSelect">
								<option value="">- All -</option>
								<c:forEach var="building" items="${buildings}" varStatus="count">
								
      								<c:choose>
    <c:when test="${buildingId eq building.buildingId}">
       <option value="${building.buildingId}" selected="selected">${building.buildingName}</option>
    </c:when>
    <c:otherwise>
        <option value="${building.buildingId}">${building.buildingName}</option>
    </c:otherwise>
</c:choose>
								</c:forEach>
								</select>
								</div>
								<div class="col-md-3">
									<button class="btn btn-primary" id="Go">Go</button>
								</div>
							</div>
						
							</div>
							 <div class="row" style="height: 2px; background: #f5f5f5;margin-top:5px;"></div>
							<div class="row" style="padding:0px 5px 0px 5px;">
                  			<div class="nav-tabs-custom" >
                  				<ul class="nav nav-tabs">
                  					<li class="active text-yellow"><a data-toggle="tab" href="#payments" aria-expanded="true" class="text-blue">Today Payments</a></li>
                  					<li class=""><a data-toggle="tab" href="#delayed" aria-expanded="false" class="text-red">Delayed Payments</a></li>
                  					<li class=""><a data-toggle="tab" href="#pendings" aria-expanded="false" class="text-yellow">Balance Dues</a></li>
                				</ul>
                  			<div class="tab-content">
                  				<div id="payments" class="tab-pane active">
                  					<table class="table table-bordered table-striped dataTable" id="example1" style="cursor: pointer;">
											  <thead>
											    <tr>
											      <th>#NO</th>
											      <th>Candidate Name</th>
											      <th>Mobile No</th>
											      <th>Emergency Phone</th>
											      <th>Room No</th>
											      <th>Room Type</th>
											      <th>Fee Amount</th>
											      <th>Due Date</th>
											      <th>Due Amount</th>
											      <th>Action</th>   
											    </tr>
											  </thead>
											  <tbody>
											        <c:forEach var="candidate" items="${todayPayments }" varStatus="count">
											  		<tr>
											  		  <td>${count.count }</td>
											  		  <td>${candidate.name }</td>
											  		  <td>${candidate.mobileNo }</td>
											  		  <td>${candidate.emergencyContactNo }</td>
											  		  <td>${candidate.room.roomName }</td>
											  		  <td>${candidate.room.roomType.roomCategory }</td>
											  		  <td>${candidate.candidateFee }</td>
											  		  <td><fmt:formatDate value="${candidate.dueDate}" pattern="dd-MMM-yyyy"/></td>
											  		  <td>${candidate.dueAmount }</td>
											  		  <td><button name="payNow" class="btn btn-xs btn-primary" value="${candidate.candidateId}">Pay</button></td>
											  		  </tr>
											  		  </c:forEach>
											  </tbody>
											</table>
                  				</div>
                  				<div id="delayed" class="tab-pane ">
                  						<table class="table table-bordered table-striped dataTable" id="pendingPays" style="cursor: pointer;">
											  <thead>
											    <tr>
											      <th>#NO</th>
											      <th>Candidate Name</th>
											      <th>Mobile No</th>
											      <th>Emergency Phone</th>
											      <th>Room No</th>
											      <th>Room Type</th>
											      <th>Fee Amount</th>
											      <th>Due Date</th>
											      <th>Due Amount</th>
											      <th>Action</th>   
											    </tr>
											  </thead>
											  <tbody>
											      <c:forEach var="candidate" items="${pendingPays }" varStatus="count">
											  		<tr>
											  		  <td>${count.count }</td>
											  		  <td>${candidate.name }</td>
											  		  <td>${candidate.mobileNo }</td>
											  		  <td>${candidate.emergencyContactNo }</td>
											  		  <td>${candidate.room.roomName }</td>
											  		  <td>${candidate.room.roomType.roomCategory }</td>
											  		  <td>${candidate.candidateFee }</td>
											  		  <td><fmt:formatDate value="${candidate.dueDate}" pattern="dd-MMM-yyyy"/></td>
											  		  <td>${candidate.dueAmount }</td>
											  		  <td ><button name="payNow" class="btn btn-xs btn-danger" value="${candidate.candidateId}">Pay</button></td>
											  		  </tr>
											  		  </c:forEach>
											  </tbody>
											</table>
                  				</div>
                  				<div id="pendings" class="tab-pane ">
                  				<table class="table table-bordered table-striped dataTable" id="pendings" style="cursor: pointer;">
											  <thead>
											    <tr>
											      <th>#NO</th>
											      <th>Candidate Name</th>
											      <th>Mobile No</th>
											      <th>Emergency Phone</th>
											      <th>Room No</th>
											      <th>Room Type</th>
											      <th>Fee Amount</th>
											      <th>Due Date</th>
											      <th>Due Amount</th>
											      <th>Action</th>   
											    </tr>
											  </thead>
											  <tbody>
											    <c:forEach var="candidate" items="${pendings }" varStatus="count">
											  		<tr>
											  		  <td>${count.count }</td>
											  		  <td>${candidate.name }</td>
											  		  <td>${candidate.mobileNo }</td>
											  		  <td>${candidate.emergencyContactNo }</td>
											  		  <td>${candidate.room.roomName }</td>
											  		  <td>${candidate.room.roomType.roomCategory }</td>
											  		  <td>${candidate.candidateFee }</td>
											  		  <td><fmt:formatDate value="${candidate.pendingDueDate}" pattern="dd-MMM-yyyy"/></td>
											  		  <td>${candidate.dueAmount }</td>
											  		  <td ><button name="payNow" class="btn btn-xs btn-warning" value="${candidate.candidateId}">Pay</button></td>
											  		  </tr>
											  		  </c:forEach>
											  </tbody>
								</table>			  
                  				</div>
                  			</div>
								                  			
                  			</div>
                  			</div>
                  	  </div>
                  </div>
                  </div>
                 </div>
             </div>
             <div class="modal fade" id="paymentForm">
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">X</span></button>
                    <h4 class="modal-title"></h4>
                  </div>
                  <div class="modal-body">
                   <div class="form-group row" id="isPaid">
                   <div class="col-md-12">
                    <label for="section" class="col-xs-3" style="padding-top: 7px;padding-left:0px;">Is Balance left?</label>
                    <div class="col-md-2">
                   <div class="radio">
                        <label>
                          <input type="radio" checked="" value="No" id="optionsRadios1" name="optionsRadios">
                          No
                        </label>
                      </div>
                      </div>
                      <div class="col-md-3">
                      <div class="radio">
                        <label>
                          <input type="radio"  value="Yes" id="optionsRadios2" name="optionsRadios">
                          Yes
                        </label>
                      </div>
                      </div>
                   </div>
                  </div>
                 <div class="form-group row" id="paidAmountDiv" style="display: none;">
                      <label for="section" class="col-xs-3" >Paid Amount</label>
                      <div class="col-xs-6">
                        <input type="text" placeholder="Paid Amount" id="paid" name="paid" class="form-control numberOnly">
                      </div>
                    </div>
                    
                  <div class="form-group row" id="dueAmountDiv" style="display: none;">
                      <label for="section" class="col-xs-3" >Due Amount</label>
                      <div class="col-xs-6">
                        <input type="text" placeholder="Due Amount" id="due" name="due" class="form-control" readonly="readonly">
                      </div>
                    </div>
                    
                  <div class="form-group row" id="dueDateDiv" style="display: none;">
                      <label for="section" class="col-xs-3" >Due Date</label>
                      <div class="col-xs-6">
                        <input type="text" placeholder="Due Date" id="dueDate" class="form-control" name="dueDate">
                      </div>
                    </div>      
                  
                 
                 
                        
                    <!-- <p>One fine body...</p> -->
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-success" name="done">Done</button>
                  
                  </div>
                </div><!-- /.modal-content -->
              </div><!-- /.modal-dialog -->
            </div>
         </section>
         
         </div>
          <jsp:include page="common/footer.jsp"></jsp:include>
         
        </div>
        
        <jsp:include page="common/scripts.jsp"></jsp:include>
      
       <script type="text/javascript" src="<%=request.getContextPath() %>/resources/bootstrap/js/moment.min.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath() %>/resources/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
       <script type="text/javascript" src="<%=request.getContextPath() %>/resources/bootstrap/js/jquery.dataTables.min.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath() %>/resources/bootstrap/js/dataTables.bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/appjs/payments.js"></script>
	<script type="text/javascript">
		  $(function(){
			  $("#payment-tab").addClass("tabActive");
			  $('#example1').DataTable();
			  $('#pendingPays').DataTable();
			  var nowDate = new Date();
				var today = new Date(nowDate.getFullYear(), nowDate.getMonth(), nowDate.getDate(), 0, 0, 0, 0);
				  $('#dueDate').datetimepicker({format: 'DD-MM-YYYY',minDate: today });	
			  });
      </script>
       </body>
       
       </html>