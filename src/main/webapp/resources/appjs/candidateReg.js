$(function(){
	
	// validation part start from here
	
	$("button[type='submit'").on("click",function(){
		var isValid=new Validate(".required").require();
		console.log("saving form");
		console.log(isValid);
		if(isValid){
			//showFeeRegForm();
			console.log("validation done");
		}// Valid Function end block
		else{
			return false;
		}
	});
	
	$(".numberOnly").keypress(function (e) {
	     //if the letter is not digit then display error and don't type anything
	     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
	        //display error message
	        $("#phoneError").html("Digits Only").show().fadeOut("slow");
	               return false;
	    }
	   });
	
	
	
	// Due date validation here.
	$("#paidAmount").on("keyup",function(){
		console.log("on blur");
		var candidateFee=$('#candidateFee').val();
		var paidAmount=this.value;
		console.log(candidateFee);
		if(candidateFee-paidAmount>0){
			$("#dueAmountDiv").show();
			$("#dueAmount").val(candidateFee-paidAmount);
			$("#dueDateDiv").show();
			$("#dueDate").addClass('required');
		}else{
			$("#dueAmountDiv").hide();
			$("#dueAmount").val(0);
			$("#dueDateDiv").hide();
			$("#dueDate").removeClass('required');
		}
	});
	
	$("#candidateFee").on('keyup',function(){
		var candidateFee=$('#candidateFee').val();
		var paidAmount=$("#paidAmount").val();
		console.log(candidateFee);
		if(paidAmount>0 && paidAmount.length!=0){
			if(candidateFee-paidAmount>0){
				$("#dueAmountDiv").show();
				$("#dueAmount").val(candidateFee-paidAmount);
				$("#dueDateDiv").show();
				$("#dueDate").addClass('required');
			}else{
				$("#dueAmountDiv").hide();
				$("#dueAmount").val(0);
				$("#dueDateDiv").hide();
				$("#dueDate").removeClass('required');
			}
				
		}
		
	});
	
	$("select[name='roomType']").on("change",function(){
		var selectedVal=$(this).val();
		console.log(selectedVal);
		$('select[name="building"]').val("");
		$('select[name="floor"]').html("");
		$('select[name="floor"]').append('<option value="">--select--</option>');
		$('select[name="room"]').html("");
		$('select[name="room"]').append('<option value="">--select--</option>');
		if(selectedVal.length!=0){
			$('select[name="building"]').prop("disabled",false);
		}
	});
	
	$("select[name='building']").on("change",function(){
		console.log($(this).val());
		var buildingId=$(this).val();
		var roomType=$('select[name="roomType"]').val();
		console.log(context);
		
		if(buildingId.length!=0){
			$.ajax({
				type:"GET",
				url:context+"/auth/getFloors/"+roomType+"/"+buildingId,
				success:function(response){
					//console.log(response);
					$('select[name="floor"]').html("");
					$('select[name="floor"]').append('<option value="">--select--</option>');
					response.forEach(function(obj){
						$('select[name="floor"]').append('<option value="'+obj.floorId+'">'+obj.floorName+'</option>');
					});
				}
			});
		}
		$('select[name="floor"]').html("");
		$('select[name="floor"]').append('<option value="">--select--</option>');
		$('select[name="room"]').html("");
		$('select[name="room"]').append('<option value="">--select--</option>');
	});
	
	$("select[name='floor']").on("change",function(){
		
		var floorId=$(this).val();
		if(floorId.length!=0){
			var roomType=$("select[name='roomType']").val();
			var buildingId=$("select[name='building']").val();
			$.ajax({
				type:"GET",
				url:context+"/auth/getRooms/"+roomType+"/"+buildingId+"/"+floorId,
				success:function(response){
					$('select[name="room"]').html("");
					$('select[name="room"]').append('<option value="">--select--</option>');
					response.forEach(function(d){
						$('select[name="room"]').append('<option value="'+d.roomId+'">'+d.roomName+'</option>');
					});
					//console.log(response);
				}
			});
		}else{
			$('select[name="room"]').html("");
			$('select[name="room"]').append('<option value="">--select--</option>');
		}
	});
});


function Validate(elem){
	   
    /* properties */
    this.elem=elem;
   
    /* functions for validations */
    this.require=function(){
        var flag=true;
       
        $(this.elem).each(function() {
       // console.log(this);
        //console.log(this.type);   
        if(this.type=='text' || this.type=='number' || this.type=='date' || this.type=='textarea' || this.type=='select-one'){
            if ($(this).val().length == 0 )
            {
                flag=false;
                $(this).addClass('error');

            }else{
                $(this).removeClass('error');
            }
        }else if(this.type=="radio" || this.type=="checkbox"){
            // checkbox || radio
            var name=this.name;
           // console.log(name);
            isCheck=$('input[name='+name+']').is(':checked');
            console.log("is check :"+isCheck);
            if(isCheck){
                //$(this).removeClass('error');

                $("#"+name+"Error").hide();
            }else{
               // $(this).addClass('error');
                $("#"+name+"Error").show(500);

                flag=false;
            }
           
        }   
           
        });
       
        return flag;
    };

}