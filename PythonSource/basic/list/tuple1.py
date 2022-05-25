# tuple : list 와 유사하지만, 값의 변경이 불가하여 고정된 값으로 사용한다.
# () 로 둘러싸여 있음
# 리스트는 값의 생성, 삭제, 수정이 가능하지만, 튜플은 변경(삽입, 수정, 삭제) 불가


# 생성
t1 = ()
t2 = (1, 2, 3)
t3 = (1,)  # 1 개의 요소만 가질때, 반드시 뒤에 , 필요하다.
t4 = 4, 5, 6  # 여러개의 데이터 삽입 시, 괄호 생략 가능
t5 = ("a", "b", ("c", "d"))  # Tuple 중첩 가능

print("t1", t1)
print("t2", t2)
print("t3", t3)
print("t4", t4)
print("t5", t5)

# del t2[1] # TypeError: 'tuple' object doesn't support item deletion ( 삭제 불가 )
# t2[1] = 5 # TypeError: 'tuple' object does not support item assignment ( 수정 불가 )

# Tuple 인덱싱 / 슬라이실
print("t2[1] : ", t2[1])
print("t2[0:3] : ", t2[0:3])
print("t4[1] + t4[2] : ", t4[1] + t4[2])
print("t3 * 2 : ", t3 * 2)  # Tuple의 반복
print("t2 + t4 : ", t2 + t4)  # Tuple의 연결

# Tuple To List
list1 = list(t4)
list1[2] = 7
print(list1)

# List To Tpule
print(tuple(list1))
