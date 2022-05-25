# dictionary Type
# Java 의 Map 과 같은 구조로 ( Key , Value ) 의 한 쌍으로 구성된 자료구조
# Key 값을 이용해 Value 를 찾아낸다

# {key1:value1, key2:value2 ...} ==> JSON 과 같은 형태

from typing import Counter


dict1 = {"name": "Hong", "age": 12}
dict2 = {0: "Hello Python", 1: "No Coding"}
dict3 = {"arr": [0, 1, 2, 3, 4], "mod": (5, 6, 7)}
dict4 = {"addr": {"address": "Seoul", "number": "123-11"}, "phone": "010-1111-2222"}

print(dict1)
print(dict2)
print(dict3)
print(dict4)

# dictionary 에서 원하는 값 가져오기
print(dict1["age"])
# print(dict1["addr"]) # KeyError: 'addr' ( Key 값이 없을 경우 )

# Dictionary 쌍 추가 DictName[Key] = Value
dict1["birth"] = "1115"
print(dict1)

dict2[2] = ["Hello Java", "HI Python"]
print(dict2)

dict3["rank"] = (16, 17, 18)
print(dict3)

dict4["user"] = {"name": "Hong", "age": 16, "height": 175.4, "male": True}
print(dict4)
# Dictionary 쌍 삭제 del DictName[Key]
del dict1["birth"]
print(dict1)

# 실습
# numbers 내부에 들어있는 숫자가 각각 몇 번 등장하는지를 Dictionary로 작성하여 출력하기
numbers = [1, 2, 6, 8, 4, 3, 2, 1, 9, 5, 4, 9, 7, 2, 1, 3, 5, 4, 8, 9, 7, 2, 3]

# 출력 { 1 : 3, 2 : 4, 6 : 1 ...}
counter = {}
for n in numbers:
    counter[n] = numbers.count(n)

print(counter)

# Dictionary 함수
"""
    keys() : Key 값을 모아서 보여줌
    values() : Value 값을 모아서 보여줌
    items() : Key 와 Value 를 쌍으로 가져옴 ( () 괄호로, Dictionary의 내부적인 표현 방식을 따른다. )
    get() : Key 로 Value 를 가져온다.
        => 장점 : 없는 Key 값을 가져올 때, Error 발생이 아닌 None 값을 반환한다.
"""
print(dict4.keys())
print(dict4.values())
print(dict4["addr"].values())
print(dict4.items())
print(dict1.get("age"))
print(dict1.get("addr"))
print(dict1["age"])

# dictionary 에서 in 사용 가능 ( 해당 Key 가 Dictionary 안에 있는지 조사 )
print("name" in dict1)
print("addr" in dict1)

print()

my_info = {"name": "kim", "age": 30, "city": "seoul"}
for k in my_info.keys():
    print(k)

for v in my_info.values():
    print(v)

for t in my_info.items():
    print(t)


# 실습
# Dictionary dict1 을 아래와 같은 조건으로 생성하시오
# 'A':90, 'B':80, 'C':70
dict1 = {"A": 90, "B": 80, "C": 70}
# 작성된 dict1 에서 B 키에 해당하는 값만 출력
print(dict1.get("B"))
# B 키 값을 삭제한 후 dict1 출력
del dict1["B"]
print(dict1)

# dict2 생성
# '성인':100000, '청소년':70000, '어린이':30000
dict2 = {"성인": 100000, "청소년": 70000, "어린이": 30000}
# dict2 항목에 '소아':0 항목 추가 후 출력
dict2["소아"] = 0
print(dict2)
# key 값만 출력
print(dict2.keys())
# value 값만 출력
print(dict2.values())
