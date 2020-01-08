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
		
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
		
        <script language="javascript">
           function xiangmuAdd(keshiId)
           {
              var url="<%=path %>/admin/xiangmu/xiangmuAdd.jsp?keshiId="+keshiId;
              window.location.href=url;
           }
           
           function xiangmuDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
               		var keshiId = document.getElementById("keshiId").value;
                   	window.location.href="<%=path %>/xiangmuDel.action?id="+id+"&keshiId="+keshiId;
               }
           }
           
           function toKeshi()
           {
           		window.location.href="<%=path %>/keshiMana.action";
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="6" background="<%=path %>/img/tbg.gif"><font color="red">${keshi.mingcheng }</font>项目管理</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td>项目名称</td>
					<td>操作</td>
		        </tr>	
				<s:iterator value="#request.xiangmuList" id="xiangmu" status="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="#xiangmu.mingcheng"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<form action="<%=path %>/admin/xiangmu/xiangmuEditPre.jsp" method="post">
							<input type="hidden" name="id" value="<s:property value="#xiangmu.id"/>"/>
							<input type="hidden" name="keshiId" value="<s:property value="#xiangmu.keshiId"/>"/>
							<input type="hidden" name="mingcheng" value="<s:property value="#xiangmu.mingcheng"/>"/>
							<input type="submit" value="修改"/>
							<input type="button" value="删除" onclick="xiangmuDel(<s:property value="#xiangmu.id"/>)"/>
						</form>
					</td>
				</tr>
				</s:iterator>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 8px;">
			  <tr>
			    <td>
			    	<input type="hidden" id="keshiId" value="${keshi.id }"/>
			      <input type="button" value="添加项目" style="width: 80px;" onclick="xiangmuAdd(${keshi.id })" />
			      <input type="button" value="返回" onclick="toKeshi()"/>
			    </td>
			  </tr>
		    </table>
	</body>
</html>
