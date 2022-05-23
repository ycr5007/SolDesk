# tuple : list 와 유사
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

# del t2[1] # TypeError: 'tuple' object doesn't support item deletion
t2[1] = 5
