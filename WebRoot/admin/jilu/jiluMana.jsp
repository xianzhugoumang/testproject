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
           function jiluToEdit(id,bingliId)
           {
           		var url = "<%=path %>/jiluToUpd.action?id="+id+"&bingliId="+bingliId;
           		window.location.href=url;
           }
        
           function jiluDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   	window.location.href="<%=path %>/jiluDel.action?id="+id;
               }
           }
		</script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<s:iterator value="#request.jiluList" id="jilu" status="ss">
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td>病历编号</td>
					<td>姓名</td>
					<td>性别</td>
					<td>年龄</td>
					<td>诊疗时间</td>
					<s:iterator value="#jilu.neirongList" id="neirong">
						<td><s:property value="#neirong.xiangmu.mingcheng"/></td>
					</s:iterator>
					<td>操作</td>
		        </tr>	
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="#jilu.bingli.bianhao"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="#jilu.bingli.xingming"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="#jilu.bingli.xingbie"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="#jilu.bingli.nianling"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="#jilu.shijian"/>
					</td>
					<s:iterator value="#jilu.neirongList" id="neirong">
						<td bgcolor="#FFFFFF" align="center">
							<s:property value="#neirong.neirong"/>
						</td>
					</s:iterator>	
					<td bgcolor="#FFFFFF" align="center">
						<input type="button" value="修改" onclick="jiluToEdit(<s:property value="#jilu.id"/>,<s:property value="#jilu.bingli.id"/>)"/>
						<input type="button" value="删除" onclick="jiluDel(<s:property value="#jilu.id"/>)"/>
					</td>				
				</tr>
				</s:iterator>
			</table>
	</body>
</html>
