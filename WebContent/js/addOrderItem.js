/**
 * 向表各种添加一行物资项信息
 */
function addItem(){
	var itemName = $("#itemName").val();
	var itemCount = $("#itemCount").val();
	var itemValue = $("#itemValue").val();
	
	/**
	 * 把物资项输入传到服务器端
	 */
	OrderService.addItem(itemName,itemCount,itemValue);
	
	var content = "<tr><td>"+itemName+"</td><td>"+itemCount+"</td><td>"+itemValue+"<td/></tr>";
	$("#tbody").append(content);
	
	/**
	 * 清空input
	 */
	$("#itemName").val("");
	$("#itemCount").val("");
	$("#itemValue").val("");
}

/**
 * 删除表格中最后一行的物资项
 */
function deleteItem(){
	
	$('#tbody tr:last').remove();
	
	/**
	 * 删除服务端保存的物资项的最后一项
	 */
	OrderService.deleteItem();
}