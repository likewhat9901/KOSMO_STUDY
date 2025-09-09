import { useState, useEffect } from "react";
import { Link, useParams, useNavigate } from "react-router-dom";

function View() {
  const navigate = useNavigate();
  // 중첩된 라우팅에서 일련번호를 읽어오기 위한 Hook
  let params = useParams();
  console.log('idx', params.idx);

  // 열람 API는 JSON 객체이므로 빈객체를 초기값으로 지정한다.
  let [boardData, setBoardData] = useState({});
  // API 요청주소
  let requestUrl = "http://nakja.co.kr/APIs/php7/boardViewJSON.php";
  let parameter = "tname=nboard_news&idx="+params.idx
      +"&apikey=a24565c6d695e4eae797e790330bacd0";

  // 1차 렌더링 후 열람API 요청
  useEffect(function(){
    fetch(requestUrl + "?" + parameter)
      .then((result)=>{
        return result.json();
      })
      .then((json)=>{
        console.log(json);
        // State 변경
        setBoardData(json);
      });
    return ()=>{
      console.log('useEffect실행==>컴포넌트 언마운트');
    }
  }, []);

  return (<>
    <header>
      <h2>게시판-읽기</h2>
    </header>
    <nav>
      <Link to="/list">목록</Link>&nbsp;
      {/* 수정페이지로 진입시 일련번호가 필요하므로 링크를 수정한다. */}
      <Link to={"/edit/"+params.idx}>수정</Link>&nbsp;
      <Link onClick={()=>{
        if(window.confirm('삭제하시겠습니까?')){
          console.log('삭제idx', params.idx);
          fetch("http://nakja.co.kr/APIs/php7/boardDeleteJSON.php", {
            method: 'POST',
            headers: {
              'Content-type' : 'application/x-www-form-urlencoded;charset=UTF-8'
            },
            body: new URLSearchParams({
              tname: 'nboard_news',
              idx: params.idx,
              apikey: "a24565c6d695e4eae797e790330bacd0"
            })
          })
          .then((result)=>{
            return result.json();
          })
          .then((json)=>{
            // 삭제 성공 시 목록으로 이동
            console.log(json, json.result);
            if (json.result==='success') {
              alert('삭제되었습니다.');
              navigate("/list");
            }
            else{
              alert('삭제에 실패했습니다.');
            }
          });
        }
      }}>삭제</Link>
    </nav>
    <article>
      <table id="boardTable">
        <colgroup>
          <col width="20%" />
          <col width="*" />
        </colgroup>
        <tbody>
          <tr>
            <th>작성자</th>
            <td>{boardData.name}</td>
          </tr>
          <tr>
            <th>제목</th>
            <td>{boardData.subject}</td>
          </tr>
          <tr>
            <th>날짜</th>
            <td>{boardData.regdate}</td>
          </tr>
          <tr>
            <th>내용</th>
            {/* HTML 태그가 그대로 출력된다. React는 보안적인 문제로 태그를
            화면에 그대로 출력하는 것이 Default 설정이다. */}
            {/* <td>{boardData.content}</td> */}
            {/* 마크업이 적용된 상태로 출력된다. */}
            {/* 이미지가 테이블 크기보다 큰 경우 450px로 맞춰서 출력. index.css에 설정 */}
            <td 
              className="tableImg"
              dangerouslySetInnerHTML={{__html: boardData.content}}
              style={{ whiteSpace:"pre-wrap" }}
            ></td>
          </tr>
        </tbody>
      </table>
    </article>
  </>) 
}

export default View;