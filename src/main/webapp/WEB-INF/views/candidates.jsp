<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <div class="modal" id="moreInfoModal">
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">X</span></button>
                    <h4 class="modal-title">More Information</h4>
                  </div>
                  <div class="modal-body">
                    <p>One fine body...</p>
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                  </div>
                </div><!-- /.modal-content -->
              </div><!-- /.modal-dialog -->
            </div>
        <div class="modal fade" id="vacateModal">
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">X</span></button>
                    <h4 class="modal-title">Vacate Information</h4>
                  </div>
                  <div class="modal-body">
                  <div class="form-group row" id="duedate">
                      <label for="section" class="col-xs-3" >Vacate Date</label>
                      <div class="col-xs-6">
                        <input type="text" placeholder="Vacate" id="due" name="nextDue" class="form-control"  REQUIRED>
                        <input type="hidden" name="candidateId" id="candidateId">
                      </div>
                    </div>
                    <!-- <p>One fine body...</p> -->
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" onclick="updateVacateData()">Vacate</button>
                  </div>
                </div><!-- /.modal-content -->
              </div><!-- /.modal-dialog -->
            </div>
            
            <div class="modal fade" id="vacateEditModal">
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">X</span></button>
                    <h4 class="modal-title">Vacate Information</h4>
                  </div>
                  <div class="modal-body">
                  <div class="form-group row" id="duedate">
                      <label for="section" class="col-xs-3" >Vacate Date</label>
                      <div class="col-xs-6">
                        <input type="text" placeholder="Vacate" id="due" name="nextDue" class="form-control"  REQUIRED>
                        <input type="hidden" name="candidateId" id="candidateId">
                      </div>
                    </div>
                    <!-- <p>One fine body...</p> -->
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary red" onclick="updateVacateData()" >Cancel Vacate</button>
                    <button type="button" class="btn btn-primary" onclick="updateVacateData()">Update Vacate</button>
                  </div>
                </div><!-- /.modal-content -->
              </div><!-- /.modal-dialog -->
            </div>
            
			<div class=row style="margin-left: 10%;margin-right: auto;width: 120%;">
				<div class="col-md-8">
				<!--  User body starts from here -->
				<div class="box box-success">
					<div class="box-body">
						<div class="col-md-12" style="box-shadow:3px 0px 15px 2px rgba(0, 0, 0, 0.125) ! important; padding-top:5px;">
							<div class="row">
							<div class="col-md-6">
								<label class="col-md-3">Building</label>
								<div class="col-md-6">
								<select class="form-control" id="buildingSelect">
								<option>- select -</option>
								<c:forEach var="building" items="${buildings}" varStatus="count">
								<c:choose>
    <c:when test="${count.count eq 1}">
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
							 <div class="row" style="height: 2px; background: #f5f5f5;margin-top:5px; "></div>
							<div class="row" style="padding:0px 5px 0px 5px;">
								<div class="col-md-12" id="candidateTable" style=" display: none;">
								<div id="example1_wrapper" class="dataTables_wrapper form-inline dt-bootstrap" style="padding-top:10px;">
									
									<div class="row">
										<div class="col-sm-12 no-padding">
											<table class="table table-bordered table-striped dataTable" id="example1">
											  <thead>
											    <tr>
											      <th>#NO</th>
											      <th>Candidate Name</th>
											      <th>Mobile No</th>
											      <th>Emergency Phone</th>
											      <th>Room No</th>
											      <th>Room Type</th>
											      <th>Fee Amount</th>
											      <th>Join Date</th>
											      <th>Action</th>   
											    </tr>
											  </thead>
											  <tbody>
											  	<c:forEach var="candidate" items="${candidates }" varStatus="count">
											  		<tr>
											  		  <td>${count.count }</td>
											  		  <td>${candidate.name }</td>
											  		  <td>${candidate.mobileNo }</td>
											  		  <td>${candidate.emergencyContactNo }</td>
											  		  <td>${candidate.room.roomName }</td>
											  		  <td>${candidate.room.roomType.roomCategory }</td>
											  		  <td>${candidate.candidateFee }</td>
											  		  <td><fmt:formatDate value="${candidate.joinDate}" pattern="dd-MMM-yyyy"/></td>
											  		  <td style="padding-left: 0px;
    padding-right: 0px;">
											  		  <div class="btn-group">
                      <button class="btn btn-warning btn-xs" type="button">Options</button>
                      <button data-toggle="dropdown" class="btn btn-warning dropdown-toggle btn-xs" type="button" style="height: 22px;" >
                        <span class="caret"></span>
                        <span class="sr-only">Toggle Dropdown</span>
                      </button>
											  		  	<ul role="menu" class="dropdown-menu" >
										                        <li><a href="#"  onclick="showVacateForm(${candidate.candidateId})" data-toggle="modal" data-target="#vacateModal">Vacate</a></li>
										                        <li><a href="#" onclick="showMoreInfo(${candidate.candidateId})" data-toggle="modal" data-target="#moreInfoModal">View More info...</a></li>
                  										   </ul>
                  										   </div>
											  		  </td>
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
			</div>
		</section>
		
	</div>
	
	 <jsp:include page="common/footer.jsp"></jsp:include>
	</div>
	 <jsp:include page="common/scripts.jsp"></jsp:include>
       <script src="<%=request.getContextPath() %>/resources/bootstrap/js/datepicker.js" type="text/javascript"></script>
       <script type="text/javascript" src="<%=request.getContextPath() %>/resources/bootstrap/js/jquery.dataTables.min.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath() %>/resources/bootstrap/js/dataTables.bootstrap.min.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath() %>/resources/bootstrap/js/moment.min.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath() %>/resources/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
       <script type="text/javascript">
			$(function(){
				
				$("#candidatesDetails-tab").addClass("tabActive");
				var nowDate = new Date();
				var today = new Date(nowDate.getFullYear(), nowDate.getMonth(), nowDate.getDate(), 0, 0, 0, 0);
				  $('#due').datetimepicker({format: 'DD-MM-YYYY',minDate: today });	
				  
				  var table=$('#example1').DataTable();
				  $("#Go").on("click",function(){
					  getCandidates(table);
				  });
				  getCandidates(table);  
			});
			
			function showVacateForm (candidateId) {
				$("#candidateId").val(candidateId);
				  
				$("#vacateModal").modal("show");
			}
			
            function showEditVacateForm (candidateId, vacationId) {
            	$("#vacateEditModal").modal("show");
            }
			
			function updateVacateData () {
               var candidateId = $("#candidateId").val();
               var date = $("#due").val();
               var table=$('#example1').DataTable();
				  table.clear();
               $.ajax({
   	 			type: "GET",
   	 			url: context + "/auth/updateVacateData/"+candidateId+"/"+date,
   	 			cache: false,
   				contentType: 'text/html',
   	 			success: function(res){
   	 			var buildingId = $("#buildingSelect").val();
   				 if (res == 1) {
   					 $.ajax({
   		   	 			type: "GET",
   		   	 			url: context + "/auth/candidatesList/"+buildingId,
   		   	 			cache: false,
   		   				contentType: 'text/html',
   		   	 			success: function(candidatesRes){
   		   				  
   		   	 			$("#vacateModal").modal("hide");
   		   	 		    getCandidates(table);
   		   	 		    
   		   	 			}
   		   	 		}); 
   				 } 
   	 				
   	 			}
   	 		});
			}
			
			function getCandidates (table) {
				var buildingId = $("#buildingSelect").val();
	               console.log("buildingId: " + buildingId);
				$.ajax({
		   	 			type: "GET",
		   	 			url: context + "/auth/candidatesList/"+buildingId,
		   	 			cache: false,
		   				contentType: 'text/html',
		   	 			success: function(candidatesRes){
		   				  $("#candidateTable").show();
		   		table.clear();
		   	 			$.each(candidatesRes,function(index,candidate){
		   	 				var toggleDropdown = null;
		   	 				if (candidate.vacationFlag == 0) {
		   	 					toggleDropdown = '<div class="btn-group" style="width:100px;">'
 				                       +'<button class="btn btn-warning btn-xs" type="button">Options</button>'
   	 				                   +'<button data-toggle="dropdown" class="btn btn-warning dropdown-toggle btn-xs" type="button" style="height: 22px;" >'
   	 				               +'   <span class="caret"></span>'
   	 				           +'       <span class="sr-only">Toggle Dropdown</span> '
   	 				       +'         </button> '
   	 				   +'									  		  	<ul role="menu" class="dropdown-menu" >'
   	 				+'									                        <li><a href="#"  onclick="showEditVacateForm('+candidate.candidateId+', '+candidate.vacationId+')">Edit/Cancel Vacate</a></li>'
   	 			+'									                        <li><a href="#" onclick="showMoreInfo('+candidate+')" >View More info...</a></li>'
   	 		+'                  										   </ul> </div>';
		   	 				} else {
		   	 				toggleDropdown = '<div class="btn-group" style="width:100px;">'
				                       +'<button class="btn btn-warning btn-xs" type="button">Options</button>'
				                   +'<button data-toggle="dropdown" class="btn btn-warning dropdown-toggle btn-xs" type="button" style="height: 22px;" >'
				               +'   <span class="caret"></span>'
				           +'       <span class="sr-only">Toggle Dropdown</span> '
				       +'         </button> '
				   +'									  		  	<ul role="menu" class="dropdown-menu" >'
				+'									                        <li><a href="#"  onclick="showVacateForm('+candidate.candidateId+')">Vacate</a></li>'
			+'									                        <li><a href="#" onclick="showMoreInfo('+candidate.candidateId+')" >View More info...</a></li>'
		+'                  										   </ul> </div>'
		   	 				}
		   	 				//var joinDate=moment(candidate.joinDate, "yyyy-mm-dd").format("D-MMM-yyyy");
		   	 				//console.log(moment(candidate.joinDate).format("DD-MMM-YYYY"));
		   	 				var rowNode=table.row.add([index+1,candidate.fullName,candidate.mobileNo,candidate.emergencyContactNo,
		   	 				                           candidate.room, candidate.roomCategory, candidate.candidateFee,moment(candidate.joinDate).format("DD-MMM-YYYY"), toggleDropdown
		   	 				                           ]).draw().node();
		   	 			if(candidate.vacationFlag == 0) {
		   	 				console.log("Zero :")
		   	 				$(rowNode).css('background-color', 'rgb(255, 224, 241)');
		   	 			}
		   	 				
		   	 			});
		   	 			  	 			
		   	 			
		   	 			}
		   	 		});
			}
			
       </script>
</body>				