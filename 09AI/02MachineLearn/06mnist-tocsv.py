import struct
'''
struct 모듈
    바이너리 데이터 읽기용 도구
    unpack()을 이용해 이진 데이터를 정수 등으로 변환
'''

# 다운로드 한 바이너리 파일을 csv파일로 변환하기 위한 함수
'''
name: 파일 이름 앞부분 ("train" 또는 "t10k").
maxdata: 몇 개의 데이터만 변환할 것인지. (전체 다 안 하고 일부만)
'''
def to_csv(name, maxdata):
    # 레이블 파일과 이미지 파일 열기
    # 레이블 파일 : 숫자의 실제값을 저장할 파일
    lbl_f = open("./resMnist/" + name + "-labels-idx1-ubyte", "rb") # "rb"(바이너리 읽기)
    # 이미지 파일 : 손글씨 이미지 데이터를 저장한 파일
    img_f = open("./resMnist/" + name + "-images-idx3-ubyte", "rb")
    # 변환된 데이터를 저장할 csv 파일 경로(쓰기 모드)
    csv_f = open("./resMnist/" + name + ".csv", "w", encoding="utf-8")
    print('lbl_f', lbl_f)
    print('img_f', img_f)
    '''
    레이블 파일: 숫자 정답 (예: 이 이미지는 ‘7’이다)
    이미지 파일: 손글씨 이미지 픽셀값 (28×28)
    CSV 파일: 변환해서 저장할 텍스트 파일
    '''

    # 헤더 정보 읽기
    ''' struct 모듈을 사용하여 바이너리 데이터를 읽고 정수로 변환한다.
    >II 는 빅엔디안 방식으로 4바이트 정수 2개를 읽겠다는 의미로 사용된다. '''
    '''
    struct.unpack(format, bytes)
        바이트(이진 데이터)를 우리가 아는 숫자나 문자열 등으로 변환해주는 함수
        -> 사람이 읽을 수 있는 정수나 실수로 바꾸는 작업
        
    📌 자주 쓰는 포맷 코드
    코드	의미	바이트 수
    B	unsigned char (0~255)	1바이트
    H	unsigned short	2바이트
    I	unsigned int	4바이트
    f	float	4바이트
    d	double	8바이트
    >	big-endian (네트워크 방식)	
    <	little-endian (x86 CPU 기본)
    '''
    # 바이너리 파일에서 8바이트를 읽어서,
    # 그걸 두 개의 4바이트 정수(unsigned int)로 해석하는 코드
    mag, lbl_count = struct.unpack(">II", lbl_f.read(8))
    '''
    컴퓨터는 0~255까지를 1바이트(8비트)**로 처리
    1바이트 = 8비트
    2⁸ = 256가지 경우의 수
    그래서 0 ~ 255까지 표현 가능
    '''
    # 레이블과 이미지 파일에서 매직넘버와 이이템 개수 읽기
    # 반환된 튜플의 첫 값은 매직 넘버, 두 번째 값은 레이블 개수
    mag, img_count = struct.unpack(">II", img_f.read(8))
    # 이미지의 행과 열 크기 읽기
    rows, cols = struct.unpack(">II", img_f.read(8))
    # 이미지의 픽셀 개수 계산(28*28)
    pixels = rows * cols

    # 이미지 데이터를 읽고 CSV로 저장
    res = []
    for idx in range(lbl_count):
        # 최대 데이터 개수를 초과하면 반복문 탈출
        if idx > maxdata:
            break

        # 레이블(0~9)을 1바이트씩 읽어서 정수로 변환
        label = struct.unpack("B", lbl_f.read(1))[0]
        # 이미지 데이터를 픽셀 단위로 읽기
        bdata = img_f.read(pixels)
        # 각 픽셀값을 문자열로 변환 후 리스트에 저장
        sdata = list(map(lambda n: str(n), bdata))
        # csv 파일에 데이터 저장
        csv_f.write(str(label)+",") # 첫번째 컬럼에 레이블 저장
        csv_f.write(",".join(sdata)+"\r\n") # 픽셀 데이터 저장 후 줄바꿈

        # 잘 저장됐는지 일부 이미지 파일을 PGM 포맷으로 저장해서 확인
        if idx < 10: # 처음 10개만 저장
            s = "P2 28 28 255\n" # PGM 헤더(ASCII 형식의 그레이스케일 이미지)
            s += " ".join(sdata) # 픽셀 데이터를 공백으로 구분하여 추가
            # 저장될 파일의 이름과 경로를 지정
            iname = "./resMnist/{0}-{1}-{2}.pgm".format(name, idx, label)
            '''
            파일명은 ./resMnist/{이름}-{번호}-{레이블}.pgm 으로 만들어 저장
            PGM 파일은 이미지 뷰어에서 열어볼 수 있는 간단한 흑백 이미지 파일
            '''
            with open(iname, "w", encoding="utf-8") as f:
                f.write(s)

    # 자원해제
    csv_f.close()
    lbl_f.close()
    img_f.close()

# # 바이너리 파일을 읽어 csv파일로 변환하여 실행
# to_csv("train", 1000) # 학습데이터 1000개
# to_csv("t10k", 500) # 테스트데이터 500개

# MNIST 전체 데이터를 CSV로 변환
to_csv("train", 70000)
to_csv("t10k", 20000)