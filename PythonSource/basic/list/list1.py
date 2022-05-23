# list 자료형 ( 배열과 유사한 개념이나, 배열 X )
# 다양한 형태의 자료들을 담을 수 있다. ( 자료형 혼합 X )


# list , tuple, dict, set

# 생성
from audioop import avg


list1 = []
list2 = ["a", "b", "c"]
list3 = ["a", "b", "c", 1, 2]
list4 = [1, 2, 3, 4, 5, 6.5]
list5 = [1, 2, ["Life", "is", "short"]]
list6 = list()

print(list1)
print(list2)
print(list3)
print(list4)
print(list5)
print(list6)


# list 인덱싱 ( 0 ~ N )
print("list2[0] : ", list2[0])
# print("list2[3]", list2[3]) # IndexError: list index out of range ( 배열 범위 초과 )
print("list3[-1] : ", list3[-1])
print("list5[2][1] : ", list5[2][1])


# list 슬라이싱 ( N ~ M ) : 문자열을 범위에 맞게 자름 ( 인덱스 번호 기준으로 )
print("list3[0:3] : ", list3[0:3])
print("list5[2:] : ", list5[2:])
print("list5[-1][2] : ", list5[-1][2])

list6 = [1, 2, ["a", "b", ["Life", "is"]]]

# 3차원 배열에서 값 가져오기 ( list6 에서 is 출력 )
print("list6[-1][-1][-1] : ", list6[-1][-1][-1])

# list 연산자
# ( + ) : list 연결의 의미, 더하기 순서에 따라 인덱싱 번호가 매겨진다
list1 = [1, 2, 3]
list2 = [4, 5, 6]
list3 = ["a", "b"]
list4 = ["a", "b", ["a", "b"]]

print("list1 + list2 = ", (list1 + list2))
print("list1 + list3 = ", (list1 + list3))
print("list1[0] + list2[1] = ", (list1[0] + list2[1]))
print("list1 + list4[2] = ", (list1 + list4[2]))
# print("list1[0] + list3[1] = ", (list1[0] + list3[1])) # TypeError: unsupported operand type(s) for +: 'int' and 'str'

# ( * ) : list 반복의 의미
print("list1 * 3 = ", (list1 * 3))
print("3 * list1 = ", (3 * list1))
# print("list2 * list1 = ", (list2 * list1)) # TypeError: can't multiply sequence by non-int of type 'list'

# 리스트 요소 값 변경 : 인덱싱 한 값을 변경 가능하다
print("list1 : ", list1)
list1[1] = 7
print("list1 : ", list1)
list1[2] = ["Life", 1, "is"]
print("list1 : ", list1)

print()
print("list2 : ", list2)
list2[1] = [10, 11]
print("list2 : ", list2)  # 인덱싱을 한 후 값을 삽입하면, list 형태로 배열 요소 값이 변경된다.
list2[1:2] = [10, 11]
print("list2 : ", list2)  # 슬라이싱을 한 후 값을 삽입하면, value 형태로 배열 요소 값이 변경된다.

# 리스트 요소 삭제 : del [list 요소 / 슬라이싱]
print("list1 + ", list1)
del list1[2]
print("list1 + ", list1)
list1[0:1] = []  # del 과 같은 결과

print()

# list 반복 ( for 문 )
list1 = [1, 2, 3, 4, 5, 6, 7, 8]
for num in list1:
    print(num, end=" ")

print()
numbers = [273, 103, 5, 32, 65, 9, 72, 800, 99]
# 리스트 안의 숫자 중 100 이상인 숫자 출력
for num in numbers:
    print(num, "\t :: ", end=" ")
    if num >= 100:
        print(num, end=" ")
    # 리스트 안의 숫자가 홀수 / 짝수인지 판별하기
    if num % 2 == 0:
        print("Even", end=" ")
    else:
        print("Odd", end=" ")
    # 리스트 안의 숫자들의 자릿수 출력하기 ( 273 = 3자리 )
    print(len(str(num)), end=" ")
    print()


# list 함수
"""
    append : list 안에 한 요소만 삽입가능 ( list 형태로 append 를 해도, 한개의 요소로서 삽입된다. )
    sort : list 정렬 ( default : 오름차순  정렬, 내림차순 정렬 ( reverse= 속성 활용 ))
    reverse() : list 뒤집기 ( 정렬 X )
    index() : 위치 반환 ( 없는 경우 ValueError 발생 )
    insert(삽입위치, 삽입할 요소)
    remove(삭제할 요소 값) : 값을 index 한 결과를 삭제 ( 값이 여러개인 경우, 가장 먼저 조회된 값 삭제 )
    pop() : 가장 마지막 요소값 추출 ( index 값 지정 할 경우, 해당 위치 요소를 추출 - 추출의 개념으로, 리스트 값을 반환한다 )
    count() : 리스트에 포함된 특정 요소의 개수 세기
    extenc(x list) : 기존 list 에 x list 를 더한다 ( x list + y list 와 동일 )
    clear() : 요소 모두 삭제 ( list 구조만 남음 )
"""
print("========== Append ==========")
list1 = [1, 2, 3]
list2 = [4, 5, 6]
list1.append(list2)
print(list1)
list1.append(5)
print(list1)

# 1 ~ 100 까지의 숫자 중 짝수 리스트 생성
even = []
for n in range(1, 101):
    if n % 2 == 0:
        even.append(n)

print(even)

print("========== Sort ==========")
list1 = [1, 4, 3, 2]
print("정렬 전 : ", list1)
list1.sort()  # 오름차순
print("정렬 후 : ", list1)
list1.sort(reverse=True)  # 내림차순
print("정렬 후 : ", list1)

print("========== Reverse ==========")
list1 = ["a", "b", "d", "e"]
print("list1 : ", list1)
list1.reverse()  #
print("list1 : ", list1)

print()
# sort() + reverse()
list1 = [3, 12, 1, 5, 7, 2, 9]
print("정렬 전 : ", list1)
list1.sort()
list1.reverse()  # sort + reverse 를 통해 내림차순 정렬 가능
print("정렬 후 : ", list1)

print("========== index ==========")
print("list1", list1)
print("list1 에 9 가 있는 위치 : ", list1.index(9))
# print("list1 에 45 가 있는 위치 : ", list1.index(45))
# ValueError: 45 is not in list ( 찾고자 하는 값이 없는경우 에러 발생 )

print("========== insert ==========")
list1 = [1, 2, 3]
list1.insert(0, 4)
print("list1 요소 삽입 후 : ", list1)

print("========== remove ==========")
list1.remove(2)  # ValueError: list.remove(x): x not in list ( 값이 없는 경우 에러 발생 )
print("list1 요소 삭제 후 : ", list1)

print("========== pop ==========")
list1 = [1, 2, 2, 2, 2, 3, 4, 5, 6, 7]
print("list1 : ", list1)
a = list1.pop()
print("list1 pop() 실행 후 : ", list1, " : ", a)

print("========== count ==========")
print(list1.count(2))

print("========== extend ==========")
list2 = [16, 17, 18]
list1.extend(list2)
print("list1 extend list2 : ", list1)

print("========== clear ==========")
list1.clear()
print("list1 clear() : ", list1)

print("========== 요소 in list명 ==========")
fruits = ["딸기", "바나나", "수박", "사과", "참외"]
print("딸기" in fruits)
print("블루베리" in fruits)

print()
print("========== 빈 list 가 반환하는 bool ==========")
list1 = []
if list1:  # list 가 비어있는 상태는 False
    print("True")
else:
    print("False")

print("========== list for 문 활용(enumerate) ==========")
for num in enumerate(numbers):  # (index, value) 형태로 출력 => Tuple 자료형의 형태로 반환
    print(num)
for idx, num in enumerate(numbers):
    print("[<<{}, {}>>]".format(idx, num))
for idx, num in enumerate(numbers, start=5):
    # start 값을 통해, idx 의 시작값을 수정할 수 있다 (value 값 변동 X)
    print("[{}, {}]".format(idx, num))


# 실습
# A 학급에 총 10 명의 학생이 있다. 이 학생들의 중간고사 점수는 다음과 같다.
# 70, 66, 55, 75, 90, 95, 80, 85, 100, 87
score = [70, 66, 55, 75, 90, 95, 80, 85, 100, 87]
# 중간고사 점수를 리스트로 생성하고 A 학급의 평균을 구하시오
print(sum(score) / len(score))

# 다음 리스트에서 Apple 항목만 제거하고 출력하기
# ["Banana", "Apple", "Orange", "Grape"]
fruits = ["Banana", "Apple", "Orange", "Grape"]
fruits.remove("Apple")
print(fruits)

