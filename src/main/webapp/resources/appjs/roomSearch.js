$(function(){
	
	$("#search").on("click",searchRooms);
	$("#building").on("change",getSharingTypes);
	$("#example1").on("click","tbody tr", function(){
		//alert("clicked"+$(this).attr("id"));
		$.ajax({
			type:"GET",
			url: context+"/auth/getCandidatesOfRoom/"+$(this).attr("id"),
			success:function(resp){
				$("#candidates").modal('show');
				$("#candidates-modal-body").html(resp);
			}
		});
	});
	
});

var searchRooms=function(){
	 var table=$('#example1').DataTable();
	 
	var buildingId=$("#building :selected").val();
	console.log(buildingId);
	
	var searchReqObj={};
	
	if(buildingId.length==0){
		alert("Building must select ");
		return false;
	}
	searchReqObj.buildingId=Number(buildingId);
	
	var shareTypeId=$("#sharing :selected").val();
	
	if(shareTypeId.length!=0){
		searchReqObj.shareTypeId=Number(shareTypeId);
	}
	
	if($("#fully").prop("checked")){
		searchReqObj.fully=true;
	}else{
		searchReqObj.fully=false;
	}
	
	if($("#partially").prop("checked")){
		searchReqObj.partially=true;
	}else{
		searchReqObj.partially=false;
	}
	
	if($("#empty").prop("checked")){
		searchReqObj.empty=true;
	}else{
		searchReqObj.empty=false;
	}
	
	if($("#vacates").prop("checked")){
		searchReqObj.vacates=true;
	}else{
		searchReqObj.vacates=false;
	}
	
	console.log(searchReqObj);
	
	$.ajax({
		type: "POST",
		contentType:"application/json",
		data:JSON.stringify(searchReqObj),
		url:context+"/auth/findRooms",
		success:function(resp){
			//console.log(resp);
			diplayTable(resp,searchReqObj,table);
		},
		error:function(ex){
			console.log(ex);
		}
	});
};

var diplayTable=function(response,searchReqObj,table){
	//console.log(response);
	console.log(searchReqObj);
	table.clear().draw();
	$.each(response,function(index,roomObject){
		//console.log(roomObject);
	// setting color codes based on search criteria 
	
	if(searchReqObj.fully){
	   		if(roomObject.capacity==roomObject.occupaid){
	   			//#ff5d5d
	   			var rowNode=table.row.add([
	   			       			 (index+1),
	   			       			roomObject.roomCategory,
	   			       			roomObject.floorName,
	   			       			roomObject.roomName,
	   			       			roomObject.capacity,
	   			       		    roomObject.occupaid,
	   			       			roomObject.cost
	   			       		]).draw().node();
	   			$(rowNode).css('background-color', '#ff5d5d');
	   			$(rowNode).attr('id',roomObject.roomId);
	   			if(roomObject.isVacate==0 && searchReqObj.vacates==true)
	   			$(table
	   	        .cell( $(rowNode), 5 )
	   	        .nodes())// note that you could actually pass in 'this' as the row selector!
	   	        .css('background-color', 'rgb(255, 224, 241)');
	   	        
	   		}
	}
	
	if(searchReqObj.partially && roomObject.occupaid!=0){
		if(roomObject.capacity>roomObject.occupaid){
			
			var rowNode=table.row.add([
 			       			 (index+1),
 			       			roomObject.roomCategory,
 			       			roomObject.floorName,
 			       			roomObject.roomName,
 			       			roomObject.capacity,
 			       		    roomObject.occupaid,
 			       			roomObject.cost
 			       		]).draw().node();
			$(rowNode).attr('id',roomObject.roomId);
			$(rowNode).css('background-color', 'rgba(253,255,110,0.56)');
			if(roomObject.isVacate==0 && searchReqObj.vacates==true)
	   			$(table
	   	        .cell( $(rowNode), 5 )
	   	        .nodes())// note that you could actually pass in 'this' as the row selector!
	   	        .css('background-color', 'rgb(255, 224, 241)');
		}
	}
	
	if(searchReqObj.empty){
		if(roomObject.occupaid==0){
			var rowNode=table.row.add([
			       			 (index+1),
			       			roomObject.roomCategory,
			       			roomObject.floorName,
			       			roomObject.roomName,
			       			roomObject.capacity,
			       			roomObject.occupaid,
			       			roomObject.cost
			       		]).draw().node();
			$(rowNode).attr('id',roomObject.roomId);
			$(rowNode).css('background-color', 'rgba(185, 255, 93, 0.54)');
		}
	}
	
	
	if(searchReqObj.fully==false && searchReqObj.partially==false && searchReqObj.empty==false){
		
		var rowNode=table.row.add([
					       			 (index+1),
					       			roomObject.roomCategory,
					       			roomObject.floorName,
					       			roomObject.roomName,
					       			roomObject.capacity,
					       			roomObject.occupaid,
					       			roomObject.cost
					       		]).draw().node();
		$(rowNode).attr('id',roomObject.roomId);
		if(roomObject.isVacate==0 && searchReqObj.vacates==true && roomObject.occupaid>0)
   			$(table
   	        .cell( $(rowNode), 5 )
   	        .nodes())// note that you could actually pass in 'this' as the row selector!
   	        .css('background-color', 'rgb(255, 224, 241)');
	}
	
	

	
	});
	
	
	
};

var getSharingTypes=function(){
	var buildingId=$(this).val();
	$('#sharing').html("");
	$('#sharing').append('<option value="">--select--</option>');
	
	if(buildingId.length!=0){
		$.ajax({
			type:"GET",
			url: context+"/auth/getShareTypes/"+buildingId,
			success:function(resp){
				console.log(resp);
				$.each(resp, function(index, value){
					$('#sharing').append('<option value="'+value.roomTypeId+'">'+value.roomCategroy+'</option>');
				});
			},
			error:function(ex){
				alert("Check your network/ Contact your provider");
			}
		});
	}
};
