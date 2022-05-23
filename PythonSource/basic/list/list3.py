# List Comprehension
"""
    ? list 의 for 문 활용을 간결하게 처리해주는 문법
    ? list 를 조금 더 편하게 생성하기 위한 문법

    list = [(append 할 내용) for (for문 변수) in (범위) [조건문 사용 가능]]

    list = [n for n in range(1, 101)]


"""

# List 생성 1 ~ 100
# numbers = []
# for n in range(1, 101):
#     numbers.append(n)

# numbers = list(range(1, 101))
# print(numbers)


numbers2 = [n for n in range(1, 101)]
print(numbers2)

list1 = ["갑", "을", "병", "정"]
# 정을 제외하고 출력
for word in list1:
    print("" if word == "정" else word, end=" ")

print()

print([word for word in list1 if word != "정"])

print()

# 1 ~ 100 까지 숫자 중, 홀수만 출력
print([n for n in range(1, 101) if n % 2 != 0])

# 5글자 이상의 단어만 출력
list2 = ["nice", "study", "python", "anaconda", "abe"]
print([word for word in list2 if len(word) >= 5])

# 소문자만 출력
list3 = ["A", "b", "C", "D", "e", "z"]
print([word for word in list3 if 97 <= ord(word) <= 122])
print([word for word in list3 if word.islower()])

# 아래 리스트를 각요소에 *2 한 후 출력
list4 = [1,2,3,4]
print([n * 2 for n in list4])