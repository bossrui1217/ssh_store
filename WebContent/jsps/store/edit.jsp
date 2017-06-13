<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>添加新仓库</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/maple.css'/>"></link>
<style type="text/css">
	.tx td{
		padding:3px;
	}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
function isReturn(id){
	  
		  location.href="${pageContext.request.contextPath}/storeAction_list";
 }
</script>
	
</head>
<body>
	<!-- 中间内容（开始） -->
	<table border="0" class="tx" width="100%">
		<tr>
			<td>当前位置&gt;&gt;首页&gt;&gt;修改新仓库</td>
		</tr>
	</table>
	<br>
	<table border="0" width="100%" cellpadding="0" cellspacing="0">
		<tr valign="top">
			<td rowspan="2">
				<%-- <form action="<c:url value='/jsps/store/store.jsp'/>" method="post" name="select"> --%>
				<form action="${pageContext.request.contextPath }/storeAction_update" method="post" name="select">
				<input type="hidden" name = "id" value ="${store.id }">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="tx" align="center">
						<colgroup>
							<col width="20%" align="right">
							<col width="*%" align="left">
						</colgroup>
						<tr>
							<td bgcolor="a0c0c0" style="padding-left:10px;" colspan="2" align="left">
								<b>修改新仓库：</b>
							</td>
						</tr>
						<tr>
							<td>
								仓库名称：
							</td>
							<td>
								<input class="tx" type="text" name="name" value="${store.name }">
							</td>
						</tr>
						<tr>
							<td>
								仓库地址：
							</td>
							<td>
								<input class="tx" type="text" name="addr" value="${store.addr}">
								
							</td>
						</tr>
						<tr>
							<td>
								库管员：
							</td>
							<td>
								<input class="tx" type="text" name="manager" value="${store.manager}">
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center" style="padding-top:10px;">
								<input class="tx" style="width:120px;margin-right:30px;" type="button" onclick="document.forms[0].submit();" value="确定">
								<!-- <input class="tx" style="width:120px;margin-right:30px;" type="reset"  value="取消" > -->
								<a href="javascript:void(0);" onclick="isReturn('<s:property value="id"/>');">取消</a>
							</td>
						</tr>
					</table>
				</form>
			</td>
			<td valign="top" width="20%">
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td background="<c:url value='/picture/loginpage.gif'/>" align="center"><br>
						<font color="red">操作步骤</font>
						</td>
					</tr>
					<tr>
						<td background="<c:url value='/picture/bg1.jpg'/>" style="padding-left:10px;">
							1.输入仓库的名称,地址
							<br/>
							2.保存后直接去显示仓库列表
						</td>
					</tr>
					<tr>
						<td><img src="<c:url value='/picture/bottom.jpg'/>"></td>
					</tr>
				</table>
		</tr>
	</table>
</body>
</html>

