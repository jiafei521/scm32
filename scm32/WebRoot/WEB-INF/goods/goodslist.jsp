<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/common/common.jspf" %>
<html>
<head>


<title> </title>

<script type="text/javascript">
	$(function(){
	
			$('#dg').datagrid({    
			    //url:'${proPath}/supplier/selectPage.action', //通过关键字查询
			    //支持多条件查询
			    url:'${proPath}/goods/selectPageUseDyc.action', 
			    
			    fitColumns:true,
			    nowrapL:true,
			    idField:'goodsId',
			    rownumbers:true,
			    pagination:true,
			    pageSize:5,
			    pageList:[2,5,10,20],
			    
			     queryParams: {
					goodsName: '%%'			
				}, 
						    
			    toolbar: [{
					iconCls: 'icon-add',
					text:'新增',
					handler: function(){
						//alert('新增按钮');
						parent.$('#win').window({    
							title :'添加商品',						
						    width:600,    
						    height:400,    
						    modal:true,
						    content:"<iframe src='${proPath}/base/goURL/goods/insert.action' height='100%' width='100%' frameborder='0px' ></iframe>"  
						}); 
					}
						

				},'-',{
					iconCls: 'icon-edit',
					text:'修改',
					handler: function(){
						//alert('修改按钮');
						//判断是否选中一行，并且只能选中一行进行修改
						var array = $('#dg').datagrid("getSelections");
						if(array.length!=1){
							alert("请选择需要修改的记录，并且只能选中一条！");
							return false;							
						}
						
						//打开修改窗口
						parent.$('#win').window({    
							title :'修改供应商',
						    width:600,    
						    height:400,    
						    modal:true,
						    content:"<iframe src='${proPath}/base/goURL/goods/update.action' height='100%' width='100%' frameborder='0px' ></iframe>"  
						}); 
						
					}
				},'-',{
					iconCls: 'icon-remove',
					text:'删除',
					handler: function(){
						//alert('删除按钮');
						var array = $('#dg').datagrid("getSelections");
						if(array.length>0){
							//alert("选中");
							//定义数组，通过下边的用来存储选中记录的Id
						var ids = new Array();
						for (i = 0; i < array.length; i++) {
							ids[i] = array[i].goodsId;
							//alert(ids[i]);
						}
						//alert("ids" + ids);
						//如果需要锁整个页面，前面加parent.
						parent.$.messager.confirm('删除对话框', '您确认要删除吗？', function(r) {
							if (r) {
								//alert(r);
								$.ajax({
								  url: "${proPath}/goods/deleteList.action",
								  type:"POST",
								  //设置为传统方式传送参数
								  traditional:true,
								  data:{pks:ids},
								  success: function(html){
									  if(html>0){
									  	alert("恭喜您 ，删除成功，共删除了"+html+"条记录");
									  }else{
									  	alert("对不超 ，删除失败");
									  }
								  //重新刷新页面
								    $("#dg").datagrid("reload");
								    //请除所有勾选的行
								    $("#dg").datagrid("clearSelections");
								  },
								  error: function (XMLHttpRequest, textStatus, errorThrown) {
									    $.messager.alert('删除错误','请联系管理员！','error');
									},
								  dataType:'json'
								});


							}
						});
						}else{
							alert("请选择需要删除的记录！");
						}
						
						
					}
				},'-',{
					text:"名称：<input type='text' id='goodsName' name='goodsName'/>"					
				}
				],			       
				columns : [ [{
					checkbox:true,
				}, {
				field : 'goodsId',
				title : '商品编号'
			}, {
				field : 'goodsName',
				title : '商品名称',
				width : 100
			}, {
				field : 'goodsUnit',
				title : '商品单位',
				width : 100
			}, {
				field : 'goodsType',
				title : '商品类型',
				width : 100
			}, {
				field : 'goodsColor',
				title : '商品颜色',
				width : 100,
				formatter: function(value,row,index){
					var str = "${applicationScope.sysParam.goodsColor}";			
					return valueToText(str,value);				
				}
			} ] ]
		});
		
			$('#goodsName').searchbox({ 
			searcher:function(value,name){ 
				 alert("goodsName:"+value); 
				//alert("goodsName:"+$('#supName').val());
				$('#dg').datagrid('load',{
					goodsName: '%'+value+'%'
				});		 			
			}, 
			prompt:'请输入商品名称' 
		});
	});
</script>
</head>

<body>
<table id="dg"></table>
</body>
</html>