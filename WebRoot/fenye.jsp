<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery_dev.js"></script>
<script type="text/javascript">

   var currPageNo = 1;
   var totalPageCount = 0;
   // 编写一个函数
   // 1 发送请求首页的table
   // 2 接收
   // 3 将响应插入userListDiv中
   function fetchUserListTable(pageNo){
	   var _pageNo = 1;
	   // pageNo有传值，并且它不是非数字（是数字） Global
	   if(pageNo && !isNaN(pageNo)){
		   _pageNo = pageNo;
	   }
	   // 传递的数据
	   var _data = "pageNo=" + _pageNo;
	   $.ajax({
		   type:'post',
		   url:'searchUserListByPageNoServlet',
		   data:_data,
		   async:false,
		   success:function(result){
			   // 插入（替换）
			   $("#userListDiv").html(result);
		   }
	   });
   }

   // 在当前页码的基础上+1
   // 发送页码fetchUserListTable
   function toNext(){
	   currPageNo++;
	   if(currPageNo>=totalPageCount){
		   currPageNo = totalPageCount;
	   }
	   fetchUserListTable(currPageNo);
   }
   
   function toPrev(){
	   currPageNo--;
	   if(currPageNo<=1){
		   currPageNo = 1;
	   }
	   fetchUserListTable(currPageNo);
   }
   
   $(document).ready(function(){
	   $.when(fetchUserListTable(1)).then(function(){
		   // 使用ajax请求10
		   $.ajax({
			   type:'post',
			   url:'fetchTotalPageCountServlet',
			   success:function(num){
				   totalPageCount = parseInt(num);
			   }
		   });
		  
	   });
   });
</script>
</head>
<body>


<p>&nbsp;</p>
<table width="80%" border="1" align="center">
  <tr>
    <td>用户列表</td>
  </tr>
  <tr>
    <td>
    
    <div id="userListDiv">
    </div>
    
    </td>
  </tr>
  <tr>
    <td align="center">
    
    	<input type='button' name='button' id='button' value='首页' onClick='toFirst()'>           
    <input type='button' name='button2' id='button2' value='上一页' onClick='toPrev()'>       
    <input type='button' name='button3' id='button3' value='下一页' onClick='toNext()'>       
    <input type='button' name='button4' id='button4' value='末页' onClick='toLast()'>         
    </td>
  </tr>
</table>



</body>

</html>