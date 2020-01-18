function page_nav(frm,num){
	// 隐藏域pageNO
		frm.pageNo.value = num;
		frm.submit();
}

function jump_to(frm,num){
    //alert(num);
	//验证用户的输入
	var regexp=/^[1-9]\d*$/;
	var maxPage = document.getElementById("maxPage").value;
	//alert(totalPageCount);
	if(!regexp.test(num)){
		alert("请输入大于0的正整数！");
		return false;
	}else if((num-maxPage) > 0){
		alert("请输入小于总页数的页码");
		return false;
	}else{
		page_nav(frm,num);
	}
}