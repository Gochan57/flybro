<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<jsp:include page="common/css.jsp"></jsp:include>
	<link href="<%=request.getContextPath() %>/resources/bootstrap/css/datepicker.css" rel="stylesheet">

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
               <!--
                <div class="box-header">
                  <h3 class="box-title">Register Candidate</h3>
                </div> /.box-header -->
                <!-- form start -->
                <form role="form" action="<%=request.getContextPath()%>/auth/registerCandidate" method="POST" >
                
             
                  <div class="box-body">
                  
                  <div class="row">
                  
                    <div class="col-md-12" >
                    <div class="col-md-12" style="box-shadow:3px 0px 15px 2px rgba(0, 0, 0, 0.125) ! important;">
                      <div class="col-md-12" style="color:green;"> 
                    	<h3 >Candidate Info:</h3>
                   		</div>
                      <div class="col-md-6">
                    <div class="form-group">
                      <label for="exampleInputEmail1">Full Name</label>
                      <input type="text" placeholder="Full Name" id="fullName" class="form-control required" value="${candidate.name}" name="fullName">
                    </div>
                    
                     <div class="form-group">
                      <label for="exampleInputPassword1">Address</label>
                      <textarea  class="form-control required" name="address"></textarea>
                    </div>
                    
                    <div class="form-group">
                      <label for="exampleInputPassword1">Mobile No</label>
                      <input type="text" placeholder="Mobile" id="mobile" class="form-control required numberOnly" name="mobileNo">
                    </div>
                    
                    <div class="form-group">
                      <label for="exampleInputPassword1">Emergency Contact No:</label>
                      <input type="text" placeholder="emergency" id="emergencyContactNo" class="form-control required numberOnly" name="emergencyContactNo">
                    </div>
                    
                    <div class="form-group">
                      <label for="exampleInputPassword1">Occupation</label>
                      <input type="text" placeholder="Occupation" id="occupation" class="form-control required" name="occupation">
                    </div>
                    
                    </div>
                    <div class="col-md-6">
                    <div class="form-group">
                      <label for="exampleInputPassword1">Photo</label>
                       <div  style="background-color: gray;float: right; height: 150px; margin-right: 181px;width: 150px;">
                       	
                       		
                       </div>
                    </div>
                    
                    	<div class="form-group" style="margin-top:120px;">
                      <label for="exampleInputPassword1">Work Place</label>
                      <input type="text" placeholder="Work Place" id="workPlace" class="form-control" name="workPlace">
                    </div>
                    
                    <div class="form-group">
                      <label for="exampleInputFile">Id Type</label>
                      <select class="form-control required" name="idType" >
                        <option value="">--select--</option>
                      	<option value="Adhar">Adhar</option>
                      	<option value="Pan">PAN</option>
                      	<option value="Driving">Driving Liecence</option>
                      	<option value="Voter">Voter Card</option>
                      </select>
                    </div>
                    
                    <div class="form-group">
                      <label for="exampleInputPassword1">ID No</label>
                      <input type="text" placeholder="Id No" id="idNo" class="form-control required" name="idNo">
                    </div>
                    
                    <div class="form-group">
                      <label for="exampleInputPassword1">Id Proof</label>
                      <input type="File" placeholder="Id Proof" id="idProof" class="" name="idProof">
                    </div>
 
                    </div>
                    </div>
                     </div>
                    <div class="col-md-6" style="padding-top:15px;">
                    <div class="col-md-12" style="box-shadow:3px 0px 15px 2px rgba(0, 0, 0, 0.125) ! important;">
                    <div class="col-md-12 no-padding">
                    	<h3 style="color:green;">Room Details:</h3>
                    </div>
                     <div class="form-group" >
                      <label for="exampleInputPassword1" >Room Type</label>
                      <select class="form-control required" name="roomType">
                      	<option value="">--select--</option>
                      	<c:forEach var="roomType" items="${roomTypes }">
                      	<option value="${roomType.roomTypeId }">${roomType.roomCategory }</option>
                      	</c:forEach>
                      </select>
                    </div>
                    
                     <div class="form-group" >
                      <label for="exampleInputPassword1" >Building</label>
                      <select class="form-control required" name="building" disabled="disabled">
                      	<option value="">--select--</option>
                        <c:forEach items="${buildings }" var="building">
                      	<option value="${building.buildingId }">${building.buildingName}</option>
                      </c:forEach>
                      </select>
                    </div>
                    
                    <div class="form-group" >
                      <label for="exampleInputPassword1" >Floor</label>
                      <select class="form-control required" name="floor" >
                      	<option value="">--select--</option>
                      </select>
                    </div>
                    
                    <div class="form-group" >
                      <label for="exampleInputPassword1" >Room</label>
                      <select class="form-control required" name="room" >
                      	<option value="">--select--</option>
                      </select>
                    </div>
                    </div>
                    </div>
                    <div class="col-md-6" style="padding-top:15px;">
                    <div class="col-md-12" style="box-shadow:3px 0px 15px 2px rgba(0, 0, 0, 0.125) ! important;">
                    <div class="col-md-12 no-padding">
                    	<h3 style="color:green;">Fee Details:</h3>
                    </div>
                      <div class="form-group">
                      <label for="exampleInputPassword1">Payment Date</label>
                      <input type="text" placeholder="paymentDate" id="paymentDate" class="form-control datepicker required" name="paymentDate">
                    </div>
                    
                    <div class="form-group">
                      <label for="exampleInputPassword1">Candidate Fee</label>
                      <input type="text" placeholder="Fee Amount" id="candidateFee" class="form-control required numberOnly" name="candidateFee">
                    </div>
                    
                     <div class="form-group">
                      <label for="exampleInputPassword1">Paid Amount</label>
                      <input type="text" placeholder="Paid Amount" id="paidAmount" class="form-control required numberOnly" name="paidAmount" >
                    </div>
                    
                    <div class="form-group" id="dueAmountDiv" style="display: none;">
                      <label for="exampleInputPassword1">Due Amount</label>
                      <input type="text" placeholder="Due Date" id="dueAmount" class="form-control" readonly="readonly" name="dueAmount">
                    </div>
                    
                    <div class="form-group" id="dueDateDiv" style="display: none;">
                      <label for="exampleInputPassword1">Due Date</label>
                      <input type="text" placeholder="Due Date" id="dueDate" class="form-control datePicker1" name="dueDate" >
                    </div>
                    </div>
                    </div>
                    </div>
                  </div><!-- /.box-body -->
				
			
                  <div class="box-footer" style="text-align:center;">
                    <button class="btn btn-primary" type="submit" >Submit</button>
                  </div>
                 
                </form>
              </div>
				 
				   
				   
					
				</div>
				
			</div>
			
        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->
      <jsp:include page="common/footer.jsp"></jsp:include>
     
   </div>
    
      
      
      <jsp:include page="common/scripts.jsp"></jsp:include>
       <script src="<%=request.getContextPath() %>/resources/bootstrap/js/datepicker.js" type="text/javascript"></script>
         <script type="text/javascript">
		  $(function(){
			  $("#regCandidate-tab").addClass("tabActive");
			  $('.datepicker').datepicker({format: 'dd-mm-yyyy'});
			  $(".datePicker1").datepicker({format: 'dd-mm-yyyy'});
			  });
      </script>
      <script type="text/javascript" src="<%=request.getContextPath()%>/resources/appjs/candidateReg.js"></script>
</body>
</html>