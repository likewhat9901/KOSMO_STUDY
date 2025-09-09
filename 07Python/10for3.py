# 숫자형으로 연/월/일 입력
year = int(input("년도를 입력하시오:"))
month = int(input("월을 입력하시오:"))
day = int(input("일을 입력하시오:"))

# 서기 1년 1일부터 입력한 날짜까지의 누적일수 합산
total_days = 0
# 월별 날짜수를 리스트로 정의. 1월을 인덱스 1로 사용하기 위해 첫번재 요소는 0으로 설정
year_month_days = [0,31,28,31,30,31,30,31,31,30,31,30,31]

# 입력한 이전년도(작년)까지의 전체날짜를 누적해서 더함
for d in range(1, year):
  if d % 400 == 0: # 윤년. 
    total_days = total_days + 366
  elif d % 100 == 0:
    total_days += 365
  elif d % 4 == 0: # 윤년
    total_days += 366
  else:
    total_days += 365

# 입력 년도의 각 월의 날짜수를 누적해서 합산. 만약 1월을 입력하면 해당 for문은 실행되지 않음
for m in range(1, month):
  total_days += year_month_days[m]

# 입력월이 3이상이고, 입력연도가 윤년인 경우 1을 더해줘야 함. 1,2월은 해당X
if month >= 3:
  if year % 400 == 0:
    total_days += 1
  elif year % 100 == 0:
    pass
  elif year % 4 == 0:
    total_days += 1
  else:
    pass

total_days += day
print()
print("total_days :", total_days)

# 서기 1년 1월 1일은 월요일이므로 7로 나눈 나머지를 통해 요일 판단 가능.
remainder = total_days % 7

if remainder == 0:
  print("일요일입니다.")
if remainder == 1:
  print("월요일입니다.")
if remainder == 2:
  print("화요일입니다.")
if remainder == 3:
  print("수요일입니다.")
if remainder == 4:
  print("목요일입니다.")
if remainder == 5:
  print("금요일입니다.")
if remainder == 6:
  print("토요일입니다.")