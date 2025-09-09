from flask import Flask
app = Flask(__name__)

@app.route('/')
def root():
  return 'Hello Flask(Main.py)'

# 실행
# set FLASK_APP=Main.py
# set FLASK_DEBUG=1
# flask run
'''
실행할 Flask 앱 파일을 지정
c:\02Workspaces> set FLASK_APP=Main.py

디버그 모드 켜기 (코드 수정 시 자동 재시작, 에러 표시)
c:\02Workspaces> set FLASK_DEBUG=1
  => FLASK_DEBUG 환경 변수를 1로 지정하면 디버그 모드 활성화됨
  코드가 수정 시 어플리케이션을 다시 실행할 필요 없이 자동으로 재시작되어 수정된 코드가 반영됨
      기능	          디버그 모드 ON	              디버그 모드 OFF (set FLASK_DEBUG=0)
  🔁 코드 자동 반영	   ✅ 예 (수정 시 재시작)	     ❌ 아니요 (수동 재시작 필요)
  🧠 에러 화면	      ✅ 상세한 디버그 정보	       ❌ 간단한 에러만 보여줌
  ⚠️ 보안	           ❌ 민감 정보 노출 위험	      ✅ 안전한 실행
  🛠️ 사용시기	       개발 중	                    실서비스 운영 시

Flask 서버 실행 (기본 포트: 5000)
c:\02Workspaces> flask run
'''