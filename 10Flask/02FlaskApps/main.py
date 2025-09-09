from flask import Flask, render_template, request
from flask import redirect, session, url_for
from markupsafe import escape

app = Flask(__name__)


@app.route('/') 
def root(): 
  return 'Hello Flask Apps'


# 요청시 외부페이지로 이동
@app.route('/daum') 
def daum(): 
  return redirect("https://www.daum.net")

@app.route('/naver') 
def naver(): 
  return redirect("https://www.naver.com")

'''
✅ 404란?
404 Not Found는 가장 유명한 웹 에러 중 하나예요.
사용자가 존재하지 않는 URL에 접속했을 때 브라우저가 받는 응답 코드

✅ Flask에서 자동 발생하는 대표적인 에러
존재하지 않는 URL 접속    404      Not Found
코드 내부 오류            500	    Internal Server Error
권한 문제	               403	    Forbidden
잘못된 요청 형식          400	     Bad Request
'''
# Page not found 에러 발생시 핸들링
@app.errorhandler(404) 
def page_not_found(error):
  # 실제 서비스에서는 Parking페이지를 만들어서 보여줌. (네이버, 다음 참조)
  print('오류 로그:', error) # 서버 콘솔에 출력
  # return "페이지가 없습니다."
  return "페이지가 없습니다. URL를 확인하세요.", 404
# return문 마지막에 404파라미터가 없으면 Status code가 200으로 반환되므로
# 반드시 추가하는 것이 좋다.
'''
✅ 왜 404를 명시해야 하나?
Flask는 기본적으로 상태 코드를 200 OK로 처리합니다.
  => return "페이지가 없습니다. URL를 확인하세요.", 404  # → 상태코드도 올바르게 404
📌 브라우저나 API 클라이언트는 이 404를 보고
  “아, 이건 없는 페이지구나” 하고 판단합니다.
  
✅ 자주 쓰는 상태 코드들
200	OK	정상 응답
302	Found	리다이렉션
400	Bad Request	잘못된 요청
403	Forbidden	권한 없음
404	Not Found	경로 없음
500	Internal Server Error	서버 내부 오류
'''


if __name__ == '__main__':
  app.run(host='127.0.0.1', port=8080, debug=True)
