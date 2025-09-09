from flask import Flask
'''
Flask(...)는 Flask 웹 애플리케이션 인스턴스를 하나 만드는 함수예요.

__name__은 현재 실행 중인 파일의 이름을 뜻합니다.
→ 모듈이 실행되는 위치에 따라 Flask가 내부 설정을 잘 하도록 도와줍니다.

비유: 📦 "웹서버 박스를 만들고, 이름표를 붙였다"
→ 이 박스(app) 안에 이제 라우터 설정, 화면 출력, 서버 실행 등을 다 넣을 수 있어요.
'''
app = Flask(__name__)


'''
@app.route('/')는 데코레이터입니다.

Flask에게 **“누군가 / 이라는 주소로 접속하면 home() 함수를 실행해라”**라고 등록하는 역할을 합니다.
'''
@app.route('/')
def root():
  return 'Hello Flask(app.py)'

# 실행
# flask run