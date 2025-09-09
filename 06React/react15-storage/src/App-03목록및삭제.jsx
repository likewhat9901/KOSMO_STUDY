import { useState, useEffect } from "react";
import { storage } from "./storageConfig";
import { ref, listAll, deleteObject } from "firebase/storage";

function App() {
  // 스토리지 연결 및 root 경로의 참조 생성
  const listRef = ref(storage, ''); 
  // 파일목록 저장
  const [fileLists, setFileLists] = useState([]);
  // 삭제후 리렌더링을 위한 State
  const [renderFlag, setRenderFlag] = useState(false);
  
  useEffect(()=>{
    let fileRows = [];
    listAll(listRef)
      .then((res)=>{
        res.prefixes.forEach((folderRef)=>{
          // 개별 파일을 반복하면서 풀경로를 통해 삭제를 위한 참조객체 생성
          console.log('폴더', folderRef.name);
        });
        res.items.forEach((itemRef)=>{
          const deleteRef = ref(storage, itemRef.fullPath);

          fileRows.push(
            <tr key={itemRef.name}>
              <td>{itemRef.bucket}</td>
              <td>{itemRef.fullPath}</td>
              <td>{itemRef.name}</td>
              <td><button type="button" onClick={(e)=>{
                if(window.confirm('삭제할까요?')){
                  // 삭제할 파일의 참조객체를 통해 파일 삭제 처리
                  deleteObject(deleteRef).then(()=>{
                    console.log("파일 삭제 성공");
                    // 삭제 성공 시 화면의 리렌더링
                    setRenderFlag(!renderFlag);
                  })
                  .catch((error)=>{
                    console.log("파일 삭제 실패");
                  })
                }
              }}>삭제</button></td>
            </tr>
          );
        });
        setFileLists(fileRows);
      })
      .catch((error)=>{
        console.log('에러발생', error);
      });
  }, [renderFlag]);
  /* 파일 삭제 시 renderFalg가 변경되므로, 그때마다 useEffect()가 재실행되도록 의존성배열을 설정한다. */

  
  console.log('렌더링');
  return (<>
    <div className="App">
      <h2>Firebase - Storage App</h2>
      <h3>파일 목록 및 삭제</h3>
      <table border={1}>
        <thead>
          <tr>
            <th>bucket</th>
            <th>fullPath</th>
            <th>name</th>
            <th>이미지</th>
          </tr>
        </thead>
        <tbody>
          {fileLists}
        </tbody>
      </table>
    </div>
  </>) 
}

export default App;