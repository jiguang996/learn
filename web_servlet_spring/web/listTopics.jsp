<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>主题列表</title>
	<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
	<s:debug></s:debug>
	<!-- 简单搜索表单 -->
	<div style="margin: 15px auto; " >
		<!-- 搜索表单 -->
		<form action="${pageContext.request.contextPath}/topic_search" class="simpleSearchForm">
			<font class="logoLabel">百度贴吧</font>
			<input type="text" name="key" class="queryString"/>
			<input type="submit" value="搜 索" />
		</form>
	</div>

	<!-- 菜单 -->
	<div class="menubar"></div>

	<!-- 主题列表 -->
	<table cellspacing="0">
		<tbody class="list topicList">
    		<!--显示表头-->
		    <tr class="title">
		        <td width="25">编号</td>
		        <td width="25">回复</td>
		        <td width="500">标题</td>
		        <td width="110">作者</td>
		        <td width="145">最后回复时间</td>
		    </tr>

    		<!-- 显示帖子列表 -->
			<s:iterator value="topicList" var="topic" status="st">
				<tr class="data">
					<td class="num">${st.count}</td>
					<td class="num">123</td>
					<td><a href="showTopic.jsp">${topic.title}</a></td>
					<td class="info">${topic.ipAddr}</td>
					<td class="info">1994-10-21 15:16:20</td>
				</tr>
			</s:iterator>

	     <%--   <tr class="data">
	            <td class="num">2</td>
	            <td class="num">56</td>
	            <td><a href="showTopic.jsp">凤姐专区</a></td>
	            <td class="info">127.0.0.1</td>
	            <td class="info">1994-10-21 15:16:20</td>
	        </tr>--%>

		    <tr>
		        <td colspan="5" class="num">共有主题数<font color="red">2</font>个</td>
		    </tr>
   		 </tbody>
	</table>

	<div style="margin-bottom: 15px"></div>

	<!--发表主题表单-->
	<form method="post" action="${pageContext.request.contextPath}/topic_save.action" class="addNewTopicForm">
	    <table class="publishArticleForm">
	        <tr>
	            <td>标　题:</td>
	            <td>
	            	<input type="text" class="title" name="title"/>
	            </td>
	        </tr>
	        <tr>
	            <td>内　容:</td>
	            <td>
	            	<textarea name="topicContent" class="content"></textarea>
	            </td>
	        </tr>
	        <tr>
	            <td></td>
	            <td><input type="submit" value="发　表" /></td>
	        </tr>
	    </table>
    </form>

</body>
</html>
