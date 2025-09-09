# flask 모듈 임포트
from flask import Flask
# Flask 객체 생성
app = Flask(__name__)

# Flask에서 말하는 "라우팅 함수", 즉 프론트엔드의 가장 기본적인 출력
''' 데코레이터를 이용해서 요청명에 대한 매핑을 한다. 이때 실행할 함수를
엔드포인트로 등록한다. '''
@app.route('/') # root함수와 연결
def root(): # 함수 이름은 home, root, index, main 등 아무 이름으로 지어도 상관없음
  ''' 예시)
  @app.route('/')
  def hello_world():
      return '홈페이지입니다'

  @app.route('/about')
  def about_page():
      return '소개 페이지입니다'
  '''
  # 이 부분이 웹브라우저에 출력(렌더링)된다.
  return 'Hello Flask(python Main.py)'
'''
📦 흐름 요약 (한 줄 설명)
사용자가 /에 접속 → Flask가 root() 실행 → 문자열 리턴 → 브라우저 화면에 표시됨 ✅

만약 HTML 템플릿을 써서 더 예쁘게 만들고 싶다면?
Flask의 render_template() 를 사용해서 HTML 파일을 출력할 수 있어요.
  
  from flask import render_template

  @app.route('/')
  def root():
      return render_template('index.html')  # templates/index.html 파일이 필요함
'''

# Main.py 파일을 직접 실행했을 때만 실행되도록 하는 조건
''' 이 파일 자체를 python명령으로 실행했을때 아래 지정한 옵션이 적용된 상태로
플라스크 애플리케이션이 실행된다. '''
if __name__ == '__main__':
  app.run(host='127.0.0.1', port=8080, debug=True)

# 실행
# python Main.py => 파이썬이 직접 Main.py 파일을 실행 (이 파일 안에 반드시 app.run() 코드가 있어야 한다.)
'''
flask run
  🔹 특징
  - Flask가 내부적으로 Main.py를 찾아서 app 객체를 실행합니다.
  - FLASK_APP=Main.py 환경변수가 설정되어 있어야 작동함.
  - app.run()을 직접 호출하지 않아도 됨.
  🔹 장점
  - 환경변수로 디버그 모드, 포트 등을 간단히 설정 가능
  - 자동으로 리로딩, 디버깅 기능이 붙어서 개발에 편함
  - 구조화된 프로젝트 (flask --app)에서 보다 권장되는 실행 방식
'''
'''
로컬에서 실행할 때의 설정
  app.run(host='127.0.0.1', port=8080, debug=True)
아마존 웹 서비스 : 모든 곳에서 접속해야 할 때 설정
  app.run(host='0.0.0.0', port=8080, debug=True)
'''