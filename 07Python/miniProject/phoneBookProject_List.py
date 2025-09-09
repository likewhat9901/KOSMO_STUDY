phoneBookData = []
idx = 1

# 입력기능
def inputFuc(idx):
  print(f"{'입력기능':-^50}")
  name = input("성명: ")
  phone = input("전화: ")
  address = input("주소: ")
  print('주소입력완료!')
  phoneBookData.append({'idx': idx, 'name': name, 'phone': phone, 'address': address})
  print(phoneBookData)

# 출력기능
def outputFuc(phoneBookData):
  print(f"{'출력기능':-^50}")
  print(f"{'번호':<10}{'성명':<10}{'전화':<10}{'주소'}")
  print(f"{'':-^60}")
  for row in phoneBookData:
    print(f"{row['idx']:<12}{row['name']:<12}{row['phone']:<12}{row['address']:<12}")

# 검색기능
def findFuc(phoneBookData):
  print(f"{'검색기능':-^50}")
  print('이름을 입력해주세요.')
  name = input('이름: ')
  result = [row for row in phoneBookData if row['name'] == name]
  if result:
    print(f"{'번호':<10}{'성명':<10}{'전화':<10}{'주소'}")
    for row in result:
        print(f"{row['idx']:<12}{row['name']:<12}{row['phone']:<12}{row['address']}")
  else:
      print("해당 이름을 찾을 수 없습니다.")

# 수정기능
def EditFunc(phoneBookData):
  print(f"{'수정기능':-^50}")
  name = input('수정할 성명을 입력하세요: ')
  
  for row in phoneBookData:
    if row['name'] == name:
      print('수정할 이름, 연락처, 주소를 입력하세요.')
      row['name'] = input('새로운 이름: ')
      row['phone'] = input('새로운 전화번호: ')
      row['address'] = input('새로운 주소: ')
      print('연락처가 수정되었습니다.')
      return
  print("해당 이름를 찾을 수 없습니다.")

# 삭제기능
def DeleteFunc(phoneBookData):
  print(f"{'삭제기능':-^50}")
  name = input("삭제할 성명을 입력하세요: ")
  for i, row in enumerate(phoneBookData):
    if row['name'] == name:
      del phoneBookData[i]
      print('정보가 삭제되었습니다.')
      return
  print('해당하는 정보가 없습니다.')

# main
while True:
  print("1.입력 2.출력 3.검색 4.수정 5.삭제 6.종료")
  menuSelect = input("선택: ").lower().strip()

  if menuSelect == "1":
    inputFuc(idx)
    idx += 1
  elif menuSelect == "2":
    outputFuc(phoneBookData)
  elif menuSelect == "3":
    findFuc(phoneBookData)
  elif menuSelect == "4":
    EditFunc(phoneBookData)
  elif menuSelect == "5":
    DeleteFunc(phoneBookData)
  elif menuSelect == "6":
      print(f"{'종료합니다':-^50}")
      break
  else:
      print("해당 기능은 아직 구현되지 않았습니다.")