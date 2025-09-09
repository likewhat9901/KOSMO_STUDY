import pymysql

conn = pymysql.connect(host='localhost', user='sample_user', port=3306,
                      password='1234', db='sample_db', charset='utf8')
curs = conn.cursor()


# 입력기능
def inputFuc():
  print(f"{'입력기능':-^50}")

  sql = f""" INSERT INTO phonebooks (name, phone, address)
    VALUES ('{input('성명:')}', '{input('전화:')}', '{input('주소:')}')"""
  try:
    curs.execute(sql)
    conn.commit()
    print("입력 완료!")
  except Exception as e:
    conn.rollback()
    print("쿼리 실행시 오류발생", e)


# 출력기능
def outputFuc():
  print(f"{'출력기능':-^50}")
    
  sql = f""" select * from phonebooks """
  try:
    curs.execute(sql)
    rows = curs.fetchall()
    
    print(f"{'번호':<10}{'성명':<10}{'전화':<10}{'주소'}")
    print(f"{'':-^60}")
    for row in rows:
      print(f"{row[0]:<12}{row[1]:<12}{row[2]:<12}{row[3]:<12}")
    
    print("모두 출력됨.")
  except Exception as e:
    conn.rollback()
    print("쿼리 실행시 오류발생", e)


# 검색기능
def findFuc():
  print(f"{'검색기능':-^50}")
  print('이름을 입력해주세요.')
  name = input('이름: ')
  
  sql = f""" select * from phonebooks 
          WHERE name like '%{name}%' """
  try:
    curs.execute(sql)
    rows = curs.fetchall()
    
    print(f"{'번호':<10}{'성명':<10}{'전화':<10}{'주소'}")
    print(f"{'':-^60}")
    for row in rows:
      print(f"{row[0]:<12}{row[1]:<12}{row[2]:<12}{row[3]:<12}")
    
    print("모두 출력됨.")
  except Exception as e:
    conn.rollback()
    print("쿼리 실행시 오류발생", e)


# 수정기능
def EditFunc():
  print(f"{'수정기능':-^50}")
  name = input('수정할 성명을 입력하세요: ')
  
  sql = f""" select * from phonebooks 
        WHERE name like '%{name}%' """
  curs.execute(sql)
  rows = curs.fetchall()
  
  if not rows:
    print("해당 이름를 찾을 수 없습니다.")
    return
  elif len(rows) > 1:
    print("해당 이름의 정보가 2개 이상입니다.")
    return
  
  target = rows[0]
  
  new_name = input("성명: ")
  new_phone = input("전화: ")
  new_address = input("주소: ")
  
  update_sql = """ UPDATE phonebooks
        SET name = %s, phone = %s, address = %s
        WHERE idx = %s """
  try:
    curs.execute(update_sql, (new_name, new_phone, new_address, target[0]))
    conn.commit()
    print('연락처가 수정되었습니다.')
  except Exception as e:
    conn.rollback()
    print("쿼리 실행시 오류발생", e)


# 삭제기능
def DeleteFunc():
  print(f"{'삭제기능':-^50}")
  name = input("삭제할 성명을 입력하세요: ")
  
  sql = f"delete from phonebooks where name='{name}'"
  try:
    deleted = curs.execute(sql)
    conn.commit()
    
    if deleted > 0:
      print('정보가 삭제되었습니다.')
    else:
      print('해당하는 정보가 없습니다.')
    return
  except Exception as e:
    conn.rollback()
    print("쿼리 실행시 오류발생", e)


# main
while True:
  print("1.입력 2.출력 3.검색 4.수정 5.삭제 6.종료")
  menuSelect = input("선택: ").lower().strip()

  if menuSelect == "1":
    inputFuc()
  elif menuSelect == "2":
    outputFuc()
  elif menuSelect == "3":
    findFuc()
  elif menuSelect == "4":
    EditFunc()
  elif menuSelect == "5":
    DeleteFunc()
  elif menuSelect == "6":
    print(f"{'종료합니다':-^50}")
    conn.close()
    break
  else:
    print("해당 기능은 아직 구현되지 않았습니다.")