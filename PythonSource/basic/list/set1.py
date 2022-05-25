# Set 자료구조 ( 집합 자료형 )
# Java Set 과 같은 개념
# 중복허용 X
# 순서 X ( 인덱싱, 슬라이싱 사용 불가 )

set1 = set()
set2 = set("Hello")
set3 = set([1, 2, 3, 4])
set4 = set([1, 2, 3, 4, 6, 6])
set5 = set({"no": "1", "name": "hong", "age": 23})

print(set1)  # set()
print(set2)  # {'o', 'l', 'e', 'H'}
print(set3)
print(set4)  # {1, 2, 3, 4, 6}
print(set5)  # {'age', 'no', 'name'} ==> Key 값만 출력

# 인덱싱 처리 ( Set To Tuple / Set To List)
t1 = tuple(set3)
print(t1)

l1 = list(set3)
print(l1)

# 교집합, 합집합, 차집합 구하기
s1 = set([1, 2, 3, 4, 5, 6])
s2 = set([4, 5, 6, 7, 8, 9])

print("s1 ∩ s2 교집합 : ", s1 & s2)
print("s1 ∩ s2 교집합 : ", s1.intersection(s2))

print("s1 ∪ s2 합집합 : ", s1 | s2)
print("s1 ∪ s2 합집합 : ", s1.union(s2))

print("s1 - s2 차집합 : ", s1 - s2)
print("s1 - s2 차집합 : ", s1.difference(s2))

# 함수
"""
    add() : 값 하나 추가
    update() : 여러 개의 값을 한번에 추가
    remove() : 특정 값 제거
"""

s1.add(17)
print(s1)
s1.update([18, 19, 20])
print(s1)
s1.remove(2)
print(s1)
