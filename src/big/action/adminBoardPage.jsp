<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="/Project_BigBang151130/css/admin.css" />
<title>Insert title here</title>
</head>
<script type="text/javascript" src="/Project_BigBang151130/script/jquery-2.1.4.min.js"></script>
<script>
$(document).ready(function(){
	$("div#sdiv").hide();
	$("span#smod a").click(function(){//수정
		if($(this).text()=='MOD'){
			var data=($(this).children().val().split("#"));
			 /* alert('adminUser.do?cmd=adminBoardModify&no='+data[0]+'&job='+data[1]); */ 
			  document.location.href='adminUser.do?cmd=adminUserModify&no='+data[0]+'&job='+data[1]; 
		}
		
	});
	$("span#sdel a").click(function(){//삭제
		var data=($(this ).children().val().split("#"));
	// alert('adminUser.do?cmd=AdminUserDelete&no='+data[0]+'&job='+data[1]);
		document.location.href='adminUser.do?cmd=adminBoardDelete&no='+data[0]+'&job='+data[1];
	});
	$("#sr").click(function(){//검색
		
	});
});
</script>
<body>
<%-- ${PageBean } --%>
<center>
<div>
<jsp:include page="../adminFolder/adminTop.jsp"/></div>

<table cellpadding="0" cellspacing="0"  class="alignCenter">
<colgroup>
							<col width="30" />
							<col width="90" />
							<col width="90" />
							<col width="50" />
							<col width="110" />
							<col width="110" />
							<col width="90" />
							<col width="30" />
							<col width="180" />
							<col />
						</colgroup>
<tr class="bg">

  	<th>NO</th>
    <th>WRITER</th>
    <th>TITLE</th>
    <th>PASS</th>
    <th>CONTENTS</th>
    <th>REGDATE</th>
    <th>FILENAME</th>
    <th>HIT</th>
    <th>STATE</th>
  </tr>
	<c:forEach var="i" items="${list}" varStatus="cnt">
	<tr>
	<td>${i.no }</td>
	<td>${i.writer }</td>
	<td>${i.title }</td>
	<td>${i.pass }</td>
	<td>${i.contents }</td>
	<td>${i.regdate }</td>
	<td>${i.fileName }</td>
	<td>${i.hit }</td>
	<td class="fir"><span class="fr"> 
					<span class="button" id="smod"><a href="#" id=${i.no}><input type="hidden" value=${i.no}#${'info'}>MOD</a></span> 
					<span class="button" id="sdel"><a href="#" id="delete"><input type="hidden" value=${i.no}#${'delete'}>DEL</a></span>
					</span></td>
		
	</c:forEach>
	</table>
	<br>

<select>
	<option value="작성자">작성자</option>
	<option value="제목">제목</option>
	<option value="내용">내용</option>
</select>
<input type="text">
<input type="button" value="검색">


 <div class="paging">
						<a href="admin.do?cmd=adminBoard&page=1"><img
							src="./img/button/btn_first.gif" alt="처음페이지" /></a>
						<c:choose>
							<c:when test="${PageBean.currentBlock gt 1}">
								<a
									href="admin.do?cmd=adminBoard&page=${PageBean.startPage-1}"><img
									src="./img/button/btn_prev.gif" alt="이전" /></a>
							</c:when>
							<c:otherwise>
								<a href="#"><img src="./img/button/btn_prev.gif" alt="이전" /></a>
							</c:otherwise>
						</c:choose>

						<span> <c:forEach var="i" begin="${PageBean.startPage}"
								end="${PageBean.endPage}" step="1">
								<c:choose>
									<c:when test="${i eq PageBean.currentPage}">
										<font size="4" color="red">[${i}]</font>
									</c:when>
									<c:otherwise>
										<a href="admin.do?cmd=adminBoard&page=${i}">[${i}]</a>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</span>

						<c:choose>
							<c:when test="${PageBean.totalPage gt PageBean.endPage}">
								<a href="admin.do?cmd=adminBoard&page=${PageBean.endPage+1}"><img
									src="./img/button/btn_next.gif" alt="다음" /></a>
							</c:when>
							<c:otherwise>
								<a href="#"><img src="./img/button/btn_next.gif" alt="다음" /></a>
							</c:otherwise>
						</c:choose>
						<a href="admin.do?cmd=adminBoard&page=${PageBean.totalPage}"><img
							src="./img/button/btn_last.gif" alt="마지막페이지" /></a>

					</div> 

</center>
</body>
</html>