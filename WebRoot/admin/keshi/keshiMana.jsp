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
           function keshiAdd()
           {
              var url="<%=path %>/admin/keshi/keshiAdd.jsp";
              window.location.href=url;
           }
           
           function keshiXiangmu(id)
           {
              var url="<%=path %>/xiangmuMana.action?keshiId="+id;
              window.location.href=url;
           }
           
           function keshiDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/keshiDel.action?id="+id;
               }
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="4" background="<%=path %>/img/tbg.gif">科室信息管理</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td>科室名称</td>
					<td>操作</td>
		        </tr>	
				<s:iterator value="#request.keshiList" id="keshi" status="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="#keshi.mingcheng"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<form action="<%=path %>/admin/keshi/keshiEditPre.jsp" method="post">
							<input type="hidden" name="id" value="<s:property value="#keshi.id"/>"/>
							<input type="hidden" name="mingcheng" value="<s:property value="#keshi.mingcheng"/>"/>
							<input type="submit" value="修改"/>
							<input type="button" value="项目管理" onclick="keshiXiangmu(<s:property value="#keshi.id"/>)"/>
							<input type="button" value="删除" onclick="keshiDel(<s:property value="#keshi.id"/>)"/>
						</form>
					</td>
				</tr>
				</s:iterator>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 8px;">
			  <tr>
			    <td>
			      <input type="button" value="添加科室" style="width: 80px;" onclick="keshiAdd()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
