# 판다스 모듈 import 및 별칭으로 pd를 사용
import pandas as pd

'''
시리즈(Series)
    : 시리즈는 데이터가 순차적으로 나열된 1차원 배열 형태를 가지는 자료구조이다.
    Key 와 Value로 구성된 Dictionary와 유사한 구조를 가지고 있다.
'''

# 딕셔너리 선언
dict_data = {'a': 1, 'b': 2, 'c': 3}
# 딕셔너리를 시리즈로 변환
sr = pd.Series(dict_data)
# 타입과 내용 출력
print('타입', type(sr))
print('시리즈1\n', sr)

print('='*30)

# 여러가지 타입의 데이터를 List로 선언
list_data = ['2019-01-02', 3.14, 'ABC', 100, True]
# List는 Key가 없는 자료형이므로 Series로 변환 시 정수형 위치 인덱스로 지정
sr = pd.Series(list_data)
# index 속성은 Series에서 인덱스 부분만 List로 추출
idx = sr.index
val = sr.values
print('시리즈2\n', sr)
print('인덱스', idx)
print('값', val)

print('='*30)

# 튜플 선언
tuple_data = ('유겸', '2012-04-03', '남', True)
'''
시리즈로 변환시 index 옵션을 통해 문자형 인덱스를 부여한다.
인덱스는 개수가 틀리면 에러가 발생한다.'''
sr = pd.Series(tuple_data, index=['이름', '생년월일', '성별', '학생여부'])

print('시리즈3\n', sr)
# 정수형 인덱스로 출력
# print('숫자형인덱스', sr[0]) # FutureWarning 발생
# 문자형 라벨 인덱스로 출력
print('문자형인덱스', sr['이름'])

'''
여러 개의 요소를 선택할때는 정수형 혹은 라벨형 인덱스를 콤마로 구분해서 사용할 수 있다.
이때 대괄호를 2개 겹쳐서 사용한다. '''
# print('1,2 출력\n', sr[[1,2]]) # FutureWarning 발생
print('생년월일, 성별 출력\n', sr[['생년월일', '성별']])

'''
문자(라벨)형 인덱스를 사용하면 범위의 끝이 포함된다. 따라서 생년월일부터 학생여부까지 모두 출력된다.
하지만 숫자형 인덱스는 범위의 끝이 포함되지 않는다.'''
print('숫자형 범위\n', sr[1:2])
print('숫자형 범위\n', sr['생년월일':'학생여부'])
