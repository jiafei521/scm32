<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include  file="/common/common.jspf"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>主页面</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>

<body class="easyui-layout">
	<!-- 上 -->   
    <div data-options="region:'north',title:'欢迎使用进销存管理系统 ',split:true" style="height:100px;">
    	欢迎,${userinfo.accLogin}
    </div>   
    <!-- 左 -->
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:200px;">
	    <!-- 分类 -->
	    <div id="aa" class="easyui-accordion"   style="width:300px;height:200px;">   
		    <div title="基础数据录入"  style="overflow:auto;padding:10px;">   
		        <ul style="list-style: none;padding: 0px;margin:0px;">
					<li style='padding:6px;'><a href="${path}/base/goURL/supplier/supplierlist.action" title="供应商管理"
						style="text-decoration: none;display: block;font-weight:bold;">供应商管理</a>
					</li>
					<li style="padding: 6px;"><a href="${path}/base/goURL/goods/goodslist.action" title="商品管理"
						style="text-decoration: none;display: block;font-weight:bold;">商品管理</a>
					</li>
				</ul>
			</div>
		    <div title="采购管理"  style="padding:10px;">   
		       <ul style="list-style: none;padding: 0px;margin:0px;">
					<li style='padding:6px;'><a href="${path}/base/goURL/buyorder/insert.action" title="商品采购"
						style="text-decoration: none;display: block;font-weight:bold;">商品采购</a>
					</li>
					<li style="padding: 6px;"><a href="${path}/base/goURL/goods/goodslist.action" title="商品退货"
						style="text-decoration: none;display: block;font-weight:bold;">商品退货</a>
					</li>
				</ul>
		    </div>   
		    <div title="Title3">   
		        content3    
		    </div>   
		</div>  
    	
    </div>   
    <!-- 下 -->
    <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;">
	    <div id="tt" class="easyui-tabs" data-options="fit:true"
			style="width:500px;height:250px;">
			<div title="系统介绍" style="padding:20px;">这里可以写系统或公司的相关介绍等等 </div>
		</div>
    </div>
    <div id="win" ></div>   
</body>
<script type="text/javascript">
	$("a[title]").click(function(){
		//添加新面板
		var title = $(this).attr("title");
		var text = this.href;
		//alert(title);
		//alert(text);
		//判断面板是否存在 存在打开否则新建
		if($('#tt').tabs('exists',title)){
			//alert("存在了");
			$('#tt').tabs('select',title);
		}else{
			$('#tt').tabs('add',{    
		    title:title,    
		    content:'Tab Body',    
		    closable:true,
		    content:"<iframe src='"+text+"' title='"+this.title+"' height='100%' width='100%' frameborder='0px' ></iframe>"
			});  
		
		}

		return false;
	});
</script>  

</html>