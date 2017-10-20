$(function(){
	//给确认修改密码的button添加事件
	$("button[value='1']").click(function(){
		//得到元密码的值
		var old_password=$("#input_02").val();
		//得到现在密码的值
		var new_password=$(".input_01:first").val();
		var new_password02=$(".input_01:last").val();
		
		 if(new_password.length!=0&&new_password02.length!=0&&old_password.length!=0&&new_password===new_password02){
			//使用ajax传值
			$.ajax({
				type:"GET",
				url:"http://localhost:7878/frontpage/acc_conupdateservlet?old="+old_password+"&_new="+new_password+"&new02="+new_password02,
				success:function(data){
					if(data){
						alert("修改成功！");
					}
					else{
						alert("请输入相同的密码,或输入密码不能为空！");
					}
				}
			});
			
		}
		else{
			alert("请输入相同的密码,或输入密码不能为空！");
		}
		
		
		//alert(old_password+new_password+new_password02);
		
	});
	//使用ajax给联动赋值
	$.ajax({
				type:"GET",
				url:"http://localhost:7878/frontpage/acc_manager01servlet",
				dataType:"JSON",
				success:function(data){
				//得到集合
				console.log(JSON.stringify(data));
				
				//alert(data.length);
				var html="";
				for(var i=0;i<data.length;i++){
					if(i==0){
						
						html+="<option selected='selected'>"+data[i].aname+"</option>";
						
					}
					else{
						html+="<option>"+data[i].aname+"</option>";
					}
				}
				$("#select1").html(html);
				
				var _child=data[0].addrlist;
				var _child_have="";
				for(var i=0;i<_child.length;i++){
					if(i==0){
						_child_have+="<option selected='selected'>"+_child[i].aname+"</option>";
						
					}
					else{
						_child_have+="<option>"+_child[i].aname+"</option>";
					}
				}
				$("#select2").html(_child_have);
				
				
				var _child00=_child[0].addrlist;
				var _child_have00="";
				for(var i=0;i<_child00.length;i++){
					if(i==0){
						_child_have00+="<option selected='selected'>"+_child00[i].aname+"</option>";
						
					}
					else{
						_child_have00+="<option>"+_child00[i].aname+"</option>";
					}
				}
				$("#select3").html(_child_have00);
				
				var city=null;
				//第一个改变时
				$("#select1").change(function(){
					//获取被选择的下标
					var _index=$("#select1 option").index($("#select1 option:selected"));
					//不同的话xiugai
					
					var province=data[_index];//省份
					city=province.addrlist;//市的集合
				
					var html_child="";
					for(var i=0;i<city.length;i++){
						if(i==0){
						html_child+="<option selected='selected'>"+city[i].aname+"</option>";
						//给select3
						var _child0=city[0].addrlist;
						var _child_have0="";
						for(var j=0;j<_child0.length;j++){
							if(j==0){
								_child_have0+="<option selected='selected'>"+_child0[j].aname+"</option>";
								
							}
							else{
								_child_have0+="<option>"+_child0[j].aname+"</option>";
							}
						}
						$("#select3").html(_child_have0);
						
					}
					else{
						html_child+="<option>"+city[i].aname+"</option>";
					}
					}
					$("#select2").html(html_child);
					//alert("省份index="+_index+" city="+JSON.stringify(city));
				
				});
				
				//当select2发生改变时
				$("#select2").change(function(){
					if(city==null){
						//获取被选择的下标
						var _index=$("#select1 option").index($("#select1 option:selected"));
						//不同的话xiugai
						
						var province=data[_index];//省份
						city=province.addrlist;//市的集合
						
					}
					//获取改变的下标值
					var _index01=$("#select2 option").index($("#select2 option:selected"));
				//alert("_index01="+_index01+" city:"+JSON.stringify(city));
					//alert("_index01= "+JSON.stringify(city[_index01].aname));
					
					
					var child_child=city[_index01].addrlist;//县
				var html_child_child="";
				for(var i=0;i<child_child.length;i++){
					if(i==0){
					html_child_child+="<option selected='selected'>"+child_child[i].aname+"</option>";
					
				}
				else{
					html_child_child+="<option>"+child_child[i].aname+"</option>";
				}
				}
				$("#select3").html(html_child_child);
				});
				
				}
			});
	
			//给确认修改地址click
			$("button[value='2']").click(function(){
				//获得隐藏域的val
				var reqtype=$("#reqtype_input").val();
				
				//获取第一个下拉框的值
				var select01=$("#select1 option:selected").text();
				//var select01=$("#select1").find("option:selected").val();
				//alert(select01);
				var select02=$("#select2 option:selected").text();
				var select03=$("#select3 option:selected").text();
				var address=$("#input_address").val();
				
				$("#list03_word").html(select01+select02+select03+address);
				$.ajax({
					type:"GET",
					url:"http://localhost:7878/frontpage/acc_con_addressservlet?reqtype="+reqtype+"&select01="+select01+"&select02="+select02+"&select03="+select03+"&address="+address,
					
					success:function(data){
						if(data){
							alert("修改成功");
							if(reqtype=="1"){
								window.location.href="link_orderservlet";
							}
						
						}
						else{
							alert("修改失败");
							
						}
					}
				});
				
			});
			
			
			
})
