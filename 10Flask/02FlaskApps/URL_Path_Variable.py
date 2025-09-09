'''
static 폴더
  템플릿 파일들에서 참조하는 정적 리소스 저장 
  하위에 css, img, js 등의 폴더를 생성
templates 폴더
  render_template 함수에 의해 사용되는 html 파일을 참조하기 위한 폴더 
'''
# HTML파일을 템플릿으로 사용하기 위한 모듈 임포트
from flask import Flask, render_template
# 폼값 처리를 위한 모듈 임포트
from flask import request
# from flask import redirect, session, url_for
# from markupsafe import escape

# 플라스크 앱 초기화
app = Flask(__name__)

# 앱을 최초로 실행했을때의 화면. 주로 index화면이라고 한다.
@app.route('/') 
def root(): 
  return 'Hello Flask Apps'

# 이미지 사용을 위한 static 폴더 확인
# 요청명과 함수명은 보통 동일하게 작성한다.(필수 사항은 아님)
@app.route('/image') 
def image(): 
  # render_template() 함수로 템플릿으로 사용할 HTML파일을 렌더링한다.
  # 프로젝트에 생성된 templates 폴더 하위로 경로가 자동으로 지정된다.
  return render_template('static.html') # templates/static.html을 브라우저에 렌더링
'''
render_template()란?
  Flask에서 **HTML 파일(템플릿 파일)**을 불러와서 클라이언트(브라우저)에게 보내줄 때 사용하는 함수입니다.
  => 📦 Flask 백엔드 → HTML 프론트엔드를 연결해주는 함수

✅ 2. 용도
🖼 HTML 파일 보여주기  =>	  텍스트 대신 웹 페이지를 브라우저에 띄움
📦 변수 넘기기        =>	 Flask에서 HTML로 값 전달 가능 ({{ 변수 }})
🔁 코드 재사용        =>	 base.html 만들고 extends로 상속 가능 (템플릿 구조화)

📁 폴더 구조 예시
project/
├── app.py
└── templates/
    └── index.html
'''

'''
Jinja2는 플라스크에서 사용하는 템플릿 엔진으로, 웹개발에서 사용되는 HTML문서에
동적인 데이터를 삽입할 수 있게 해준다.
즉 HTML 문서에 Python 코드를 사용할 수 있게 해주는 엔진이다.
'''
@app.route('/jinja2') 
def jinja2():
  '''
  함수에서 처리한 내용을 템플릿 파일로 전달하기 위해 여러개의 인수를 아래와 같이 추가할 수 있다.
  문자열과 리스트를 전달하고 있다.
  '''
  return render_template('jinja2.html',
                  title = 'Jinja2',
                  home_str = 'Jinja2를 알아봅시다',
                  home_list = [1,2,3,4,5])
  

# 폼값을 입력하고 전송하기 위한 페이지
@app.route('/form') 
def info(): 
  return render_template('form.html')

# 라우팅 설정시 methods 속성에 사용할 방식을 리스트로 설정
# methods=['GET', 'POST']  =>  /method 경로에 대해 GET과 POST 둘 다 처리
""" 
@app.route(...) 기본이 GET 방식
  methods 파라미터를 지정하지 않으면 GET만 허용되도록 설계되어 있음.
  🧠 이유 (왜 기본은 GET인가?)
    ✅ 브라우저가 기본으로 보내는 요청이 GET	주소창 입력
      - 링크 클릭 등은 모두 GET 요청
    ✅ 가장 안전하고 읽기 전용이기 때문
      - GET은 데이터를 "조회"하는 데 사용되므로 위험성이 적음
    🔒 POST는 데이터 변경을 수반할 수 있어 위험
      - POST 요청은 "회원가입", "삭제" 등 **행동(action)**을 포함함. 실수로 호출되면 위험할 수 있음
    🧩 RESTful 규칙과 맞음
      - URL 경로와 메서드를 나누는 REST 설계 원칙을 따름
      
GET만 허용될 때 POST 요청을 보내면?
  405 Method Not Allowed
  => Flask가 자동으로 **"이 URL은 POST 요청 허용 안 함"**이라고 알려줍니다.
"""
@app.route('/method', methods=['GET', 'POST']) 
def method(): 
  '''
  1. request.args와 request.form의 핵심 차이
    GET 요청에서 request.form을 읽으면 항상 None 또는 빈 값이 나옵니다.
    반대로 POST 요청에서 request.args를 읽으면 쿼리스트링 값만 들어 있습니다.
    
  request.args  =>  GET 방식	  =>  URL 뒤에 붙은 파라미터 받기	
  request.form  =>  POST 방식   =>  form 태그에서 POST 전송된 데이터 받기
  '''
  if request.method == 'GET':
    # GET 방식 : form 데이터를 request.args로 받음
    args_dict = request.args.to_dict()
    # 전송된 폼값 전체를 딕셔너리로 변환 후 출력
    print("args_dict (GET):", args_dict)
    # 딕셔너리의 Key값으로 접근하듯 사용
    '''
    파라미터 꺼내는 세 가지 안전한 방법
      val = request.args['key']          # 키가 없으면 KeyError (예외 발생)
      val = request.args.get('key')      # 키 없으면 None 반환
      val = request.args.get('key', '')  # 키 없으면 기본값 '' 반환
    '''
    userid = request.args["userid"] # 방법1
    # 함수의 인수로 접근하여 사용
    name = request.args.get("name") # 방법2
    email = request.args.get("email")
    # POST 방식에서 사용하는 form은 사용할 수 없으므로 값은 None으로 출력됨.
    fail = request.form.get("name") # 의도적 오류(None)
    print("실패예시 request.form.get(name):", fail)
    # 템플릿을 렌더링하면서 필요한 변수는 인수로 전달.
    return render_template(
      'get.html',
      userid = userid,
      name = name,
      email = email,
      fail = fail
    )
  else:
    # POST 방식 : form 데이터를 request.form 으로 받음
    form_dict = request.form.to_dict()
    print("form_dict (GET):", form_dict)
    userid = request.form["userid"] # 방법1
    name = request.form.get("name") # 방법2
    email = request.form.get("email")
    fail = request.args.get("name") # 의도적 오류(None)
    print("실패예시 request.args.get(name):", fail)
    return render_template(
      'post.html',
      userid = userid,
      name = name,
      email = email,
      fail = fail
    )
  


# URL 패스 Variable 1
'''
<name>은 URL 경로에서 전달받는 변수
  => **Flask에서는 "경로 변수" 또는 "URL 파라미터"**라고 부릅니다.
'''
@app.route('/hello/<name>') 
def hello(name): # def 함수(변수):	<변수>에 들어온 값을 인자로 받음
  return '내 이름은 {}'.format(name)

# URL 패스 Variable 2
'''
다른 타입도 가능
기본적으로는 문자열이지만, 타입을 지정할 수도 있다.

타입 예시
<string:name> (기본)	   문자열 (예: 홍길동)
<int:id>	              정수 (예: 123)
<float:score>	          소수 (예: 3.14)
<path:filepath>	        슬래시(/) 포함 경로 (예: a/b/c)
'''
@app.route('/input/<int:num>') 
def input(num):
  name = ''
  if num == 1:
    name = '홍길동'
  elif num == 2:
    name = '전우치' 
  elif num == 3:
    name = '손오공' 
  return f'내 선택은 {name}'




# 플라스크 애플리케이션 작성시 모든 함수를 정의한 후 app.run()을 실행해야 한다.
if __name__ == '__main__':
  app.run(host='127.0.0.1', port=8080, debug=True)
# 만약 아래쪽에 함수가 정의되어 있으면 오류가 발생된다.
'''
정확히 말해서, "오류가 발생할 수도 있다"
이유는 app.run()이 Flask 서버를 실행시키고, 그 이후 코드는 보통 실행되지 않기 때문

예시)
if __name__ == '__main__':
    app.run(host='127.0.0.1', port=8080, debug=True)

# 그 아래에 라우팅 함수 정의
@app.route('/')
def home():
    return 'Hello'
'''