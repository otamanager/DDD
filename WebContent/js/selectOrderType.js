function selectOrderType(){
	
	var orderType = $("#orderType option:selected").val();
	if(orderType == 1){//入库订单
	
		$("#sourceLocationInput").fadeOut();
		$("#toWarehouseCodeInput").fadeIn();
		$("#destinationLocationInput").fadeOut();
		$("#fromWarehouseCodeInput").fadeOut();
	}else if(orderType == 2){//出库订单

		$("#sourceLocationInput").fadeOut();
		$("#toWarehouseCodeInput").fadeOut();
		$("#destinationLocationInput").fadeOut();
		$("#fromWarehouseCodeInput").fadeIn();
	}else if(orderType == 3){//移仓单

		$("#sourceLocationInput").fadeOut();
		$("#toWarehouseCodeInput").fadeIn();
		$("#destinationLocationInput").fadeOut();
		$("#fromWarehouseCodeInput").fadeIn();
	}else if(orderType == 4){//配送单

		$("#sourceLocationInput").fadeIn();
		$("#toWarehouseCodeInput").fadeIn();
		$("#destinationLocationInput").fadeIn();
		$("#fromWarehouseCodeInput").fadeIn();
	}
}