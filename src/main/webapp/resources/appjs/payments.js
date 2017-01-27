var feeAmount=0;
var candidateId=0;
$(function(){
	
	$(".numberOnly").keypress(function (e) {
	     //if the letter is not digit then display error and don't type anything
	     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
	        //display error message
	        $("#phoneError").html("Digits Only").show().fadeOut("slow");
	               return false;
	    }
	   });
	
	$('button[name="payNow"]').on('click',showPayment);
	
	$('input[name="optionsRadios"]').on('change',function(){
		var selected=$(this).val();
		if(selected=='Yes'){
			$("#paidAmountDiv").show();
			$("#dueAmountDiv").show();
			$("#dueDateDiv").show();
		}else{

			$("#paidAmountDiv").hide();
			$("#dueAmountDiv").hide();
			$("#dueDateDiv").hide();
		}
		
	});
	
	$("#paid").on("keyup",function(){
		//console.log("on blur");
		var candidateFee=feeAmount;
		console.log(candidateFee);
		var paidAmount=this.value;
		//console.log(candidateFee);
		if(candidateFee-paidAmount>0){
			
			$("#due").val(candidateFee-paidAmount);
			
		}else{
			
			$("#due").val(0);
			
		}
	});
	
	$('#paymentForm').on('hidden.bs.modal', function () {
	    // do something…
		console.log('hide');
		$("#paidAmountDiv").hide();
		$("#dueAmountDiv").hide();
		$("#dueDateDiv").hide();
		$("#due").val(0);
		$("#paid").val(0);
		$('#dueDate').val('');
		$("#optionsRadios1").prop("checked", true)
	});
	
	
	$("button[name='done']").on("click",function(){
		var radioOption=$('input[name="optionsRadios"]:checked').val();
		console.log(radioOption);
		if(radioOption=='Yes'){
		  var paid=$("#paid").val();
		  if(paid.length==0){
			  alert("Paid Amount should enter");
			  return false;
		  }
		  var dueDate=$("#dueDate").val();
		  if(dueDate.length==0){
			  alert("Due Date must required");
			  return false;
		  }
		  
		  $.ajax({
			  type:"POST",
			  url: context+"/auth/SubmitDue",
			  data:"feeAmount="+feeAmount+"&paidAmount="+paid+"&dueDate="+dueDate+"&paymentStatus=Pending&cid="+candidateId,
			  success:function(resp){
				  
			  },error:function(ex){
				  
			  }
		  });
		}else{
			$.ajax({
				  type:"POST",
				  url: context+"/auth/SubmitDue",
				  data:"feeAmount="+feeAmount+"&paidAmount="+feeAmount+"&dueDate=''&paymentStatus=DONE&cid="+candidateId,
				  success:function(resp){
					  
				  },error:function(ex){
					  
				  }
			  });
		}
		
		
	});
	
	// GO click
	
	$("#Go").on("click",function(){
		var buildingId=$("#buildingSelect").val();
		console.log(buildingId);
		if(buildingId.length==0)
			window.location.href=context+"/auth/payments";
			else
				window.location.href=context+"/auth/payments/"+buildingId;
	});
});

var showPayment=function(){
	 candidateId=$(this).val();
	console.log(candidateId);
	$.ajax({
		type:'GET',
		url:context+"/auth/paymentDetails/"+candidateId,
		success:function(resp){
            feeAmount=resp.candidateFee;
			$("#paymentForm").modal('show');
			var header="You are viewing <b>"+resp.fullName+"</b>, <b>Room -"+resp.roomName+"</b>, <b>feeAmount-"+resp.candidateFee+"</b>, DueAmount <b>"+resp.dueAmount+"</b>";
			$(".modal-title").html(header);
		},
		
		error:function(ex){
			alert("Error");
		}
	});
};

