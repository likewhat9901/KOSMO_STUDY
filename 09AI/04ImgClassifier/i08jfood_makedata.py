'''
train_test_split: 학습/테스트 데이터 자동 분리
PIL.Image: 이미지 열고 변환하는 도구
glob: 파일 목록 불러오기 (예: *.jpg)
numpy: 숫자 데이터 처리용 필수 도구
'''
from sklearn.model_selection import train_test_split
from PIL import Image
import glob
import numpy as np

# 분류 대상 카테고리
root_dir = "./download"     # 음식 사진이 저장된 최상위 폴더
categories = ["Gyudon", "Ramen", "Sushi", "Okonomiyaki", "Karaage"]  # (폴더 이름과 동일해야 함)
# 카테고리 개수(5개)
nb_classes = len(categories)
# 이미지 크기(모든 이미지를 50x50 크기로 통일)
image_size = 50

# 이미지 및 레이블 데이터를 저장할 리스트
X = []
Y = []
# 각 카테고리별로 이미지 파일을 불러와서 처리
for idx, cat in enumerate(categories):
    # 경로를 조립한 후 jpg 파일 가져오기
    image_dir = root_dir + "/" + cat
    # 각 카테고리 폴더에 있는 모든 jpg 파일을 리스트로 반환
    files = glob.glob(image_dir + "/*.jpg")
    # 파일 개수만큼 반복
    for i, f in enumerate(files):
        # print(i, image_dir, f, "처리중")
        # 이미지 파일 오픈 및 변환, 사이즈 조절
        img = Image.open(f)
        img = img.convert("RGB")
        img = img.resize((image_size, image_size))
        # 이미지 픽셀값을 numpy 배열로 변환
        data = np.asarray(img)
        # numpy 배열로 변환된 이미지와 카테고리 인덱스 추가
        X.append(data)
        Y.append(idx)
        # if i == 1:
        #     print(idx, data)

# 리스트를 Numpy 배열로 변환
X = np.array(X)     # 이미지 데이터
Y = np.array(Y)     # 레이블 데이터
'''
X_train : 훈련용 입력 데이터
X_test : 테스트용 입력 데이터
Y_train : 훈련용 정답 데이터
Y_test : 테스트용 정답 데이터
'''
# 학습 전용 데이터와 테스트 전용 데이터 분류
X_train, X_test, Y_train, Y_test = train_test_split(X, Y)

# 파일로 저장
np.savez("./saveFiles/japanese_food.npz", X_train=X_train, X_test=X_test,
         Y_train=Y_train, Y_test=Y_test)
print("Task Finished..!!", len(Y))