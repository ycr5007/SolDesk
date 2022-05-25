# File 읽고 쓰기
"""
    open() : 파일을 읽거나 쓸 때 사용
        "w" : 새로 쓰기, 기존 내용 삭제 후, 새로운 내용으로 덮어씌움
        "a" : append 개념으로, 기존 내용 뒤에 추가 작성
        "r" : read 개념으로, 파일을 읽어올 때 사용
        "rb" : Byte 형태로 읽어오기 ( 2진 파일 - 동영상, 이미지 ... 파일 )
        "wb" : Byte 형태로 쓰기 ( 2진 파일 - 동영상, 이미지 ... 파일 )
    with + open() : close() 를 자동으로 해줌 ( 블록문 형태로, 블록문 내부 코드 실행 )

    file 관련 Function
        write(val) : value 값을 파일에 입력 ( list 구조를 매개변수로 넣는 경우 TypeError 발생 )
        writelines(list) : list 형태를 파일에 입력
"""

# f = open("data/test1.txt", "a", encoding="UTF-8")
# 가상환경이기 때문에, Root 경로는 가상환경 실행경로 (PythonSource) 로 설정된다
# print(dir(f))
# FileNotFoundError: [Errno 2] No such file or directory: '../data/test1.txt'
# f.write("안녕하세요\n반갑습니다")
# f.close()


# 1 ~ 10 까지 파일로 작성
# for i in range(1, 11):
#     f.write("%d\n" % i)
# f.close()

# list 를 파일로 작성 ( for 문 + write() OR writelines() 활용 )
# list = ["홍길동\n", "김길동", "최길동"]
# f = open("data/test1.txt", "w", encoding="UTF-8")
# f.write(list) # TypeError: write() argument must be str, not list
# f.writelines(list) # 홍길동김길동최길동

# for i in list:
#     f.write(i + "\n")
# f.close()


# Dictionary 형태를 파일로 작성
# dict1 = {"name": "홍", "age": 25, "addr": "Seoul"}
# f = open("data/test1.txt", "w", encoding="UTF-8")
# f.writelines(dict1) # nameageaddr >> key 값만 입력
# for k, v in dict1.items():
#     f.writelines("{} : {}\n".format(k, v))
# f.close()


# 1,000 명의 키와 몸무게를 랜덤으로 생성한 후 파일 작성
import random

list1 = list("가나다라마바사아자차카타파하")

# f = open("data/health_info.txt", "w", encoding="UTF-8")
# f.writelines("이름\t체중\t신장\n")
# for i in range(1000):
#     name = random.choice(list1) + random.choice(list1)
#     weight = random.randrange(40, 100)
#     height = random.randrange(140, 200)
#     f.writelines("{}\t{}\t{}\n".format(name, weight, height))

# f.close()


with open("data/test1.txt", "w", encoding="UTF-8") as f:
    f.writelines("이름\t체중\t신장\n")
    for i in range(1000):
        name = random.choice(list1) + random.choice(list1)
        weight = random.randrange(40, 100)
        height = random.randrange(140, 200)
        f.writelines("{}\t{}\t{}\n".format(name, weight, height))
