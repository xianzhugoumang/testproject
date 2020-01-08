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
           function yishengAdd()
           {
              var url="<%=path %>/admin/yisheng/yishengAdd.jsp";
              window.location.href=url;
           }
           
           function yishengDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/yishengDel.action?id="+id;
               }
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="6" background="<%=path %>/img/tbg.gif">医生信息管理</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td>姓名</td>
					<td>性别</td>
					<td>年龄</td>
					<td>职务</td>
					<td>所在科室</td>
					<td>操作</td>
		        </tr>	
				<s:iterator value="#request.yishengList" id="yisheng" status="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="#yisheng.xingming"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="#yisheng.xingbie"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="#yisheng.nianling"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="#yisheng.zhiwu"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="#yisheng.keshi.mingcheng"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<input type="button" value="删除" onclick="yishengDel(<s:property value="#yisheng.id"/>)"/>
					</td>
				</tr>
				</s:iterator>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 8px;">
			  <tr>
			    <td>
			      <input type="button" value="添加医生" style="width: 80px;" onclick="yishengAdd()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
