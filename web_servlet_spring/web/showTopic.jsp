﻿<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>凤姐专区</title>
	<link rel="stylesheet" type="text/css" href="css/main.css"> 
</head>
<body>
	<!-- 简单搜索表单 -->
	<div style="margin: 15px auto; " >
		<!-- 搜索表单 -->
		<form action="" class="simpleSearchForm" onsubmit="alert('暂不支持此功能！');return false;">
			<font class="logoLabel">百度贴吧</font>
			<input type="text" name="queryString" class="queryString"/>
			<input type="submit" value="搜 索" />
		</form>
	</div>
	<!-- 菜单 -->
	<div class="menubar">
		<a href="listTopics.jsp">主题列表</a>
	</div>
	
	<!-- 当前主题贴数 -->
	<div style="padding: 10px 30px; font-size: 12px; font-family:'宋体'">
		共有<font color="red">5</font>篇帖子
	</div>
	
	<!-- 显示主题 -->
	<table class="postList" cellspacing="0">
	    <tr class="title">
	        <td width="20" class="num">1</td>
	        <td>这里是标题</td>
	    </tr>
	    <tr class="content">
	        <td></td>
	        <td><pre>这里是内容</pre></td>
	    </tr>
	    <tr class="info">
	        <td></td>
	        <td>
				作者：<font color="blue">只有ip地址</font> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            <font color="#999999">发帖时间：1978-05-21 12:23:34</font>
	        </td>
	    </tr>
	</table>
	
	<!-- 显示回复列表 -->
	<table class="postList" cellspacing="0">
        <tr class="title">
            <td width="20" class="num">2</td>
            <td></td>
        </tr>
        <tr class="content">
            <td></td>
            <td><pre>灌水</pre></td>
        </tr>
        <tr class="info">
            <td></td>
            <td>
				作者：<font color="blue">12345</font> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <font color="#999999">回帖时间：1978-05-21 12:23:34</font>
            </td>
        </tr>
    </table>
	<table class="postList" cellspacing="0">
        <tr class="title">
            <td width="20" class="num">3</td>
            <td></td>
        </tr>
        <tr class="content">
            <td></td>
            <td><pre>灌水</pre></td>
        </tr>
        <tr class="info">
            <td></td>
            <td>
				作者：<font color="blue">12345</font> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <font color="#999999">回帖时间：1978-05-21 12:23:34</font>
            </td>
        </tr>
    </table>
    
    <div style="margin-bottom: 20px"></div>
	<!-- 发表回复表单 -->
	<form action="" class="addNewTopicForm">
		<table class="publishArticleForm">
	        <tr>
	            <td class="label">内　容:</td>
	            <td><textarea name="content" class="content"></textarea></td>
	        </tr>
	        <tr>
	            <td></td>
	            <td><input type="submit" value="回　贴"/></td>
	        </tr>
	    </table>
	</form>
</body>
</html>