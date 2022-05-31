# 리스트 안에서 가장 큰 숫자 찾기
# [17,92,18,33,58,7,33,42]


from gettext import find


def find_max(list):
    max = 0
    for i in list:
        if i > max:
            max = i
    return max


# 복잡도 : O(n)
def find_max_answer1(list):
    size = len(list)
    max = list[0]
    for i in range(1, size):
        if max < list[i]:
            max = list[i]
    return max


# 가장 큰 값이 있는 위치번호 반환
def find_maxIndex(list):
    max = 0
    idx = -1
    for i in list:
        if i > max:
            max = i
            idx += 1
    return idx


def find_maxIndex_answer(list):
    size = len(list)
    max_idx = 0
    for i in range(1, size):
        if list[max_idx] < list[i]:
            max_idx = i
    return max_idx


if __name__ == "__main__":
    print(find_max([17, 92, 18, 33, 58, 7, 33, 42]))
    print(find_maxIndex([17, 92, 18, 33, 58, 7, 33, 42]))
