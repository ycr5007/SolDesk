# 최소값, n개 숫자를 입력 받아 최솟값 구하기

# 숫자 입력
from msilib.schema import Error


def num_input(list):
    i = 0
    while True:
        val = input("{} number : ".format(i))
        try:
            list.append(int(val))
        except ValueError:
            break
        i += 1
    return list


def find_min(list):
    min = list[0]
    for i in list:
        if min > i:
            min = i
    return min


def num_input_answer(list):
    i = 1
    print("리스트에 추가할 숫자를 입력하세요\n숫자 추가를 끝내기 위해서는 q 를 입력하세요")
    while True:
        print(str(i), ":", end="")
        num = input()

        if num != "q":
            list.append(int(num))
        else:
            break
        i += 1

def find_min_answer(list):
    min = list[0]
    size = len(list)
    for i in range(i, size):
        if min > list[i]:
            min = list[i]
    return min

if __name__ == "__main__":
    print(find_min(num_input([])))
