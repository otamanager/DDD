/**
 * 查询现场物资单
 */
function getSceneOrdersCount(){
	
	OrderService.getSceneOrderCount(function(sceneOrderCount){
		
		if(sceneOrderCount == 0){
			$("#countOfSceneOrders").text("");
		}
		else{
			$("#countOfSceneOrders").text("("+sceneOrderCount+")");
		}
	});
}
$(document).ready(function(){
	
	setInterval(getSceneOrdersCount,5000*2);//每隔5秒查询一次现场物资单
});