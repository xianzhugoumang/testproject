<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
        <script language="javascript">
           function addJilu(bingliId)
           {
              var url="<%=path %>/jiluToAdd.action?bingliId="+bingliId;
              window.location.href=url;
           }
           
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="10" background="<%=path %>/img/tbg.gif">病例信息查询</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="14" colspan="10">
						<form action="<%=path %>/bingliList.action" method="post">
							编号：<input type="text" name="bianhao" value="${param.bianhao }"/>
							<input type="submit" value="查询"/>
						</form>
					</td>
				</tr>				
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td>编号</td>
					<td>姓名</td>
					<td>性别</td>
					<td>年龄</td>
					<td>出生日期</td>
					<td>婚否</td>
					<td>住址</td>
					<td>联系电话</td>
					<td>身份证号</td>
					<td>操作</td>
		        </tr>	
				<s:iterator value="#request.bingliList" id="bingli" status="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="#bingli.bianhao"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="#bingli.xingming"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="#bingli.xingbie"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="#bingli.nianling"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="#bingli.shengri"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="#bingli.hunfou"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="#bingli.zhuzhi"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="#bingli.lianxi"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="#bingli.shenfen"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<input type="button" value="添加诊疗记录" onclick="addJilu(<s:property value="#bingli.id"/>)"/>
					</td>
				</tr>
				</s:iterator>
			</table>
	</body>
</html>
