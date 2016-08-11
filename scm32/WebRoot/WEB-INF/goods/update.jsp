<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<%@ include file="/common/common.jspf"%>
<title>My JSP</title>
</head>
<body>

	<form id="ff" method="post">
	 	   <div>
			<label for="goodsId">商品编号:</label> <input type="text" name="goodsId" />
		</div>
		<div>
			<label for="goodsName">商品名称:</label> <input type="text" name="goodsName" />
		</div>
		<div>
			<label for="goodsUnit">商品单位:</label> <input type="text" name="goodsUnit" />
		</div>
		<div>
			<label for="goodsType">商品类型:</label> <input type="text"
				name="goodsType" />
		</div>
		<div>
			<label for="goodsColor">商品颜色:</label> <select id="cc" class="easyui-combobox" name="supType" style="width:200px;">   
					<c:forEach items="${applicationScope.sysParam.goodsColor}" var="goodsColor">
					    <option value="${goodsColor.key}">${goodsColor.value}</option>   
					</c:forEach>   
				</select>
		</div>
		<div>
			<input id="btn" type="button" value="提交" />
		</div>
	</form>

	<script type="text/javascript">
		$(function() {
			var win = parent.$("iframe[title='商品管理']").get(0).contentWindow;//返回ifram页面文档（window)
			
			var row = win.$('#dg').datagrid("getSelected");
			
			$('#ff').form('load',{
				goodsId:row.goodsId,
				goodsName:row.goodsName,
				goodsUnit:row.goodsUnit,
				goodsType:row.goodsType,
				goodsColor:row.goodsColor
			});
			$("[name='goodsName']").validatebox({
				required : true,
				missingMessage : '请填写商品名称！'
			});
			$("[name='goodsUnit']").validatebox({
				required : true,
				missingMessage : '请填写出商品单位！'
			});
			$("[name='goodsType']").validatebox({
				required : true,
				missingMessage : '请填写商品类型！'
			});
			//禁用验证
			$("#ff").form("disableValidation");

			$("#btn").click(function() {
				//alert("ddddddddddd");
				$("#ff").form("enableValidation");
				if ($("#ff").form("validate")) {
					//alert("------------");
					$('#ff').form('submit', {
						url : '${proPath}/goods/update.action',
						onSubmit : function() {
							return true;
							return $("#ff").form("validate");
						},
						success : function(count) {							
								//可以定义为对应消息框
                        	    alert("成功");
								parent.$("#win").window("close");
								win.$("#dg").datagrid("reload");							
						}
					});

				}

			});

		});
	</script>
</body>
</html>
