<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 첨부형 게시판</title>
</head>
<body>
<jsp:include page="../Common/Link.jsp" />
<h2>파일 첨부형 게시판 - 상세 보기(View)</h2>

<table border="1" width="90%">
    <colgroup>
        <col width="15%"/> <col width="35%"/>
        <col width="15%"/> <col width="*"/>
    </colgroup> 
    <tr>
        <td>번호</td> <td>${ dto.idx }</td>
        <td>작성자</td> <td>${ dto.name }</td>
    </tr>
    <tr>
        <td>작성일</td> <td>${ dto.postdate }</td>
        <td>조회수</td> <td>${ dto.visitcount }</td>
    </tr>
    <tr>
        <td>제목</td>
        <td colspan="3">${ dto.title }</td>
    </tr>
    <tr>
        <td>내용</td>
        <td colspan="3" height="100">
        	${ dto.content }
        	<%-- 첨부파일이 이미지인지 판단하는 로직 and isImage eq true --%>
        	<!-- 첨부파일이 있다면 img태그로 이미지 출력 -->
<c:if test="${ not empty dto.ofile }">
	<c:choose>
		<c:when test="${ dto.ext eq 'jpg' or dto.ext eq 'png' or dto.ext eq 'gif' }">
		<br><img alt="첨부파일 이미지" src="../Uploads/${ dto.sfile }"
      			style="max-width:400px;">
		</c:when>
		<c:when test="${ dto.ext eq 'mp3' or dto.ext eq 'wav' }">
		<br><audio src="../Uploads/${ dto.sfile }" controls />
		</c:when>
		<c:when test="${ dto.ext eq 'mp4' or dto.ext eq 'avi' or dto.ext eq 'wmv' }">
		<br><video src="../Uploads/${ dto.sfile }" controls width="400">
			브라우저가 video태그를 지원하지 않습니다.
		</video>
		</c:when>
		<c:otherwise></c:otherwise>
	</c:choose>
</c:if>
        </td>
    </tr> 
    <tr>
        <td>첨부파일</td>
        <td>
        	<!-- 첨부파일 있으면 다운로드 링크 출력 -->
<c:if test="${ not empty dto.ofile }">
       		${ dto.ofile }
       		<!-- 다운로드 링크에는 원본파일명, 저장된파일명, 일련번호를 파라미터로 전달 -->
       		<a href="../mvcboard/download.do?ofile=${ dto.ofile }&sfile=${ dto.sfile }&idx=${ dto.idx }">
       			[다운로드]
       		</a>
</c:if>                        
        </td>
         <td>다운로드수</td>
        <td>${ dto.downcount }</td>
    </tr> 
    
    <!-- 하단 메뉴(버튼) -->
    <tr>
    		<!-- 열람(내용보기)페이지로 진입할때 일련번호(idx)를 파라미터로 전달하게되므로 
    		수정, 삭제 링크에는 EL의 내장객체 param을 이용해서 일련번호를 전달하고 있다. -->
        <td colspan="4" align="center">
<c:if test="${ not empty UserId and sessionScope.UserId eq dto.id }">
   			<button type="button" 
            	onclick="location.href='../mvcboard/edit.do?idx=${ param.idx }';">
                수정하기
            </button>
            <button type="button" 
            	onclick="deletePost(${ param.idx });">
                삭제하기
            </button>
</c:if>
            <button type="button" 
            	onclick="location.href='../mvcboard/list.do';">
                목록 바로가기
            </button>
        </td>
    </tr>
</table>
</body>
<script>
	let deletePost = (idx) => {
		if(confirm('삭제할까요?')) {
			location.href='../mvcboard/delete.do?idx='+idx;
		} else {
    		alert('삭제가 취소되었습니다.');
		}
	}
</script>
</html>
