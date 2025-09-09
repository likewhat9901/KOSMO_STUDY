# 1.map()
""" 
map 함수는 주어진 함수와 컬렉션을 인수로 받아, 컬렉션의 각 요소에 함수를
적용한 결과를 반환한다.
for문과 같은 반복문을 사용하지 않아도 지정한 함수로 인자를 자동 전달하여
그 결과를 List 형태로 반환한다.
"""
# 함수 정의 : 매개변수에 2를 곱한 결과를 반환
def multiply_by_two(n):
  return n * 2
# 리스트 정의
numbers = [1,2,3,4,5]

# map(함수, 리스트) 와 같이 호출
# 리스트(numbers)의 각 요소를 자동으로 함수의 인자로 전달.
result = map(multiply_by_two, numbers)
# 결과1 : map Object로 출력
print('결과1-1', result) # map객체(map Object)라는 반복자(iterator)를 반환 -> 성능 최적화 때문.
# 결과2 : Object를 List로 변환 후 출력
print('결과1-2', list(result))
# 각 요소에 2를 곱한 결과를 반환.

# 2.filter 함수
""" 
filter 함수는 주어진 요소 중 조건에 맞는 것만 필터링하여 반환한다.
즉, 지정된 함수(혹은 람다식)에서 True가 되는 것만 반환하여 결과를 생성한다.
"""
# 인수가 짝수인 경우에만 반환하는 함수 정의
def is_even(x):
  return x % 2 == 0
numbers = [1,2,3,4,5]
result = filter(is_even, numbers)
print('결과2', list(result))
# 짝수만 리스트에 남고 홀수는 모두 제거된 상태로 출력.

# 3.reduce 함수
""" 
반복 가능한 객체의 각 요소를 지정된 함수로 처리한 뒤 이전 결과와 누적해서
반환하는 함수. 즉, 하나의 값을 반환한다. 파이썬 3.x부터는 내장함수가
아니므로 모듈을 import 후 사용해야 한다.
"""
from functools import reduce

def add(x, y):
  return x + y
numbers = [1,2,3,4,5]
""" 
reduce함수는 처음 2개를 먼저 함수로 전달하여 결과를 만들고, 그 결과를
다시 다음 요소와 결합하는 방식으로 전체 리스트를 처리한다.
reduce에서 사용하는 함수는 2개의 인수만 받을 수 있으므로, 3개로 정의하면 에러가 발생한다.
ex. add(x, y, z) -> 오류
"""
result = reduce(add, numbers)
print(result)
""" 
+예시)
result = reduce(lambda x, y: x + y, [1, 2, 3, 4])
print(result)  # 10
"""