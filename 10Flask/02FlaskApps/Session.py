from flask import Flask, render_template, request
# 화면이동, 세션 처리 등을 위한 모듈 임포트
from flask import redirect, session, url_for
# 문자열 깨짐 방지를 위한 인코딩 처리를 위한 모듈 임포트
from markupsafe import escape

app = Flask(__name__)

# session 사용시 필수사항인 시크릿키
app.secret_key = 'A02as129wjDNGd/.sd12RT'

# 예시 사용자 (실제 DB 연결 대신 하드코딩)
users = {
    'admin': '1234',
    'user' : '9876'
}


@app.route('/') 
def root(): 
  return 'Hello Flask Apps'

'''
session
  - 사용자 정보 유지 (로그인 상태 등)
  - Flask의 session은 사용자의 로그인 상태나 정보를 브라우저에 저장하는 방식
    → 서버가 사용자를 기억할 수 있게 해줍니다.

🔹 특징:
  - 내부적으로는 쿠키를 사용
  - 암호화되어 저장됨 (보안 걱정 줄어듦)
  - session['username'] 이런 식으로 값을 저장하거나 읽음
'''
'''
redirect() : 다른 URL로 이동시키기
  ex. return redirect('/login')  # /login으로 이동
  
url_for() : URL 경로를 함수 이름으로 생성
  ex. url_for('login')  # 결과: '/login'
  - 하드코딩을 피하고, 코드 변경에도 자동 반영되기 때문에 추천되는 방식입니다.
  - 변수도 전달 가능:
'''
@app.route('/mypage') 
def mypage(): 
  # 페이지로 진입시 세션정보가 있는지 확인(로그인 되었는지 확인)
  if 'username' in session:
    '''
    escape()의 역할: HTML 특수문자를 무해하게 바꿔줌
    즉, <, >, ', " 같은 특수 문자가 HTML로 해석되지 않도록 이스케이프 처리해주는 함수
    => username에 <b>철수</b> 같은 값을 넣어도, 굵게 표시되지 않고 글자 그대로 보임
      안전한 웹 페이지를 만들기 위한 보안 수단입니다.
    '''
    # 로그인된 상태라면 welcome페이지를 렌더링.
    # 템플릿으로 회원의 아이디를 전달
    '''
    🔐 escape(session['username'])는
    HTML로 해석되지 않도록 안전하게 처리한 값을
    → username이라는 변수에 저장해서 템플릿에 전달하는 것
    
    session['username']에는 사용자가 입력한 값이 들어 있을 수 있어요.
    예시: "<script>alert(1)</script>" => escape 하면 글자로 바꿔서 보여준다.
    '''
    return render_template('welcome.html',
              username=escape(session['username']))
  # 로그인이 안된 상태라면 login페이지로 이동.
  # url_for() 함수의 인수는 실행할 함수명을 기술
  return redirect(url_for('login'))


# 로그인 페이지
@app.route('/login', methods=['GET', 'POST']) 
def login():
  # 폼값을 입력후 submit(전송)했을때
  if request.method == 'POST':
    # POST 방식의 전송이므로 form을 이용해서 값 받음
    input_id = request.form['username'] 
    input_pw = request.form['password']
    # 사용자 인증. 입력한 정보와 일치하는지 확인.
    if input_id in users \
      and users[input_id] == input_pw:
      # 정보가 일치하면 세션에 사용자의 아이디를 입력해서 생성
      session['username'] = input_id
      # 마이페이지로 이동
      return redirect(url_for('mypage'))
    else:
      # 사용자 정보가 일치하지 않는 경우에는 다시 로그인 페이지로 이동
      # 이때 error라는 변수에 메세지를 전달한다.
      return render_template('login.html',
                      error='아이디 또는 비밀번호가 틀렸습니다.')
  # 첫 진입시에는 메뉴 클릭을 통해 이동하게 되므로 GET방식의 요청임
  # 따라서 로그인 폼을 보여준다.
  return render_template('login.html')


# 로그아웃 처리
@app.route('/logout') 
def logout(): 
  # 세션에 저장된 사용자 정보를 삭제한다.
  session.pop('username', None)
  # 삭제가 완료되면 index화면으로 이동한다.
  return redirect(url_for('root'))



if __name__ == '__main__':
  app.run(host='127.0.0.1', port=8080, debug=True)
