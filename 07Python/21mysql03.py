import pymysql

# MariaDB에 연결하기(포트는 3306이 기본이므로 생략가능)
conn = pymysql.connect(host='localhost', user='sample_user', port=3306,
                      password='1234', db='sample_db', charset='utf8')
# 커서 생성
curs = conn.cursor()

sql = """update board
            set title='{1}', content='{2}'
            where num={0}
""".format(input('수정할일련번호:'), input('제목:'), input('내용:'))

try:
  curs.execute(sql)
  conn.commit()
  print("1개의 레코드가 수정됨")
except Exception as e:
  conn.rollback()
  print("쿼리 실행시 오류발생", e)

conn.close()