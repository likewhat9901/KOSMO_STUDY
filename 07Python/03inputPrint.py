# 표준 입출력 장치

# 변수 생성, 초기화
i,j,k=7,8,9
# 출력값 사이 구분자는 스페이스가 기본값
print(i,j,k)
# 출력값 사이 구분자 설정가능.
print(i,j,k,sep='-')
# 값을 줄바꿈 없이 출력할 때 end를 사용
print(i,end=',')
print(j,end=',')
print(k)

# format함수 : 출력시 서식에 맞추기 위해 사용
# 실수 출력시 전체 8자리, 소수 3자리 표현
print("원주율 =", format(3.14159, "8.3f"))
# 정수 출력시 전체 10자리
print("맥주 =", format(5000, "10d"))
# 정수 출력 시 3자리마다 컴마 표시
print("노트북 =", format(1580000, "3,d"))

# 서식문자 : 문자열 %s, 정수 %d, 실수 %f
name = "성유겸"
age = 13
price = 123.456
print("이름 : %s, 나이 : %d, 용돈 : %.2f만원" % (name, age, price))

# format()함수
# 인덱스 혹은 변수명을 지정하여 출력가능
menu1 = "치킨"
menu2 = "맥주"
print("오늘 {str}은 {0}과 {1}로 정했다".
      format(menu1, menu2, str="저녁"))
print("오늘은 {}과 {}로 {str}을 시작하겠다".
      format(menu1, menu2, str="아침"))

# 입력받기 : 키보드를 통해 입력받은 값은 항상 '문자형(str)'
# 입력받는 값은 무조건 '문자형(str)'
num = input('숫자를 입력하세요 : ')
print('입력한 숫자는', num, '이고, 타입은', type(num))

# 문자+숫자 => 에러
# result_error = num + 10
# 연산을 위해 정수형으로 변환 후 처리.
result1 = int(num)+10
print('덧셈결과', result1)

# 입력 및 정수변환 : 일반적으로 동시에 처리한다.
result2 = int(input('숫자1 : ')) * int(input('숫자2 : '))
print('곱셈결과', result2)

# 실수변환은 float함수 사용(문장이 걸어져 줄바꿈 해야하는 경우 \을 마지막에 추가하면 된다.)
result3 = float(input('원주율 : ')) * \
  (float(input('원의 반지름 : ')) ** 2)
print('원의넓이', result3)