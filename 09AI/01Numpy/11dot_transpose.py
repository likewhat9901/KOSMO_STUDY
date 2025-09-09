import numpy as np
from numpy.ma.core import transpose

# 행렬 내적 (행렬 곱)
A = np.array([[1,2,3], [4,5,6]])
B = np.array([[7,8], [9.10], [11,12]])

dot_product = np.dot(A, B)
print('행렬 내적 결과:\n', dot_product)

# 전치 행렬
A = np.array([[1,2], [3,4]])
transpose_mat = np.transpose(A)
print('A의 전치행렬:\n', transpose_mat)