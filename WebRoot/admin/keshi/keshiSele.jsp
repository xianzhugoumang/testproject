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
           function ksSelected()
           {
                 var ksOpts = document.getElementsByName("ksxx");
                 for(var i=0;i<ksOpts.length;i++)
                 {
                 	if(ksOpts[i].checked)
                 	{
                 		var arrksxx = ksOpts[i].value.split("_");
                 		window.returnValue = arrksxx;
                 		window.close();
                 	}
                 }
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="4" background="<%=path %>/img/tbg.gif">科室信息选择</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="10%">&nbsp;</td>
					<td width="25%">科室名称</td>
		        </tr>	
				<s:iterator value="#request.keshiList" id="keshi" status="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						 <input type="radio" name="ksxx" value="<s:property value="#keshi.id"/>_<s:property value="#keshi.mingcheng"/>"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="#keshi.mingcheng"/>
					</td>
				</tr>
				</s:iterator>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="选择" style="width: 80px;" onclick="ksSelected()" />
			    </td>
			  </tr>
		    </table>	
	</body>
</html>
