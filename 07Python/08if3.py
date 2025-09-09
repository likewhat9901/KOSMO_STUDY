'''
퀴즈1] 국,영,수 점수를 입력받아 평균값을 구하고 이를 통해 학점을 출력하는 
    프로그램을 작성하시오. 
    90점 이상은 A학점 
    80점 이상은 B학점
    70점 이상은 C학점
    60점 이상은 D학점    
    60점 미만은 F학점으로 판단하여 출력합니다. 
'''
while True:
  try:
    num1 = int(input("국어 점수를 입력하세요 (0~100): "))
    if 0 <= num1 <= 100:
        break
    else:
      print("⚠️ 점수는 0에서 100 사이여야 합니다.")
  except ValueError:
    print("숫자를 입력하세요")
num2 = int(input("영어 점수를 입력하세요 : "))
num3 = int(input("수학 점수를 입력하세요 : "))

avg = (num1+num2+num3) / 3
# 중첩된 구조의 if문 작성
if avg>=90:
  print("A학점")
elif avg>=80:
  print("B학점")
elif avg>=70:
  print("C학점")
elif avg>=60:
  print("D학점")
else:
  print("F학점")