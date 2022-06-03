# 삽입정렬

# result 에 v 가 들어가야할 위치를 return
def find_ins_idx(r, v):
    # r 은 이미 정렬된 리스트 ( 삽입 할 리스트 )
    # r 의 데이터를 앞에서부터 확인
    for i in range(0, len(r)):
        # v 가 어느 위치에 들어가는지 찾기
        if v > r[i]:
            return i
    # 적절한 위치를 못찾을 경우에는 v 가 이미 정렬된 리스트보다 크다는 뜻이므로 맨 뒤에 삽입
    return len(r)


# 두 개의 리스트에서 구현
def insertion_descSort(list):
    result = []
    while list:
        value = list.pop(0)
        ins_idx = find_ins_idx(result, value)
        result.insert(ins_idx, value)
    return result


# 하나의 리스트에서 구현
def insertion_ascSort(list):
    # for 1 ~ n
    for i in range(1, len(list)):
        # i 번 위치에 있는 값을 key 변수에 저장
        key = list[i]
        # j 를 i 바로 왼쪽 위치로 지정
        j = i - 1
        # while 문
        # 리스트의 j 번 위치에 있는 값과 key 를 비교해 key 가 삽입될 위치 찾기
        ins_idx = 0
        while j >= 0:
            if list[j] < key:
                ins_idx += 1
            j -= 1
        # while 문 종료 후, 찾은 삽입 위치에 key 저장
        list.remove(key)
        list.insert(ins_idx, key)
    return list


def insertion_ascSort_answer(list):
    size = len(list)
    for i in range(1, size):
        key = list[i]
        j = i - 1
        while j >= 0 and list[j] > key:
            list[j + 1] = list[j]
            j -= 1

        list[j + 1] = key
    return list


if __name__ == "__main__":
    list1 = [2, 4, 5, 1, 3]
    list2 = [2, 4, 5, 1, 3]
    list3 = [2, 4, 5, 1, 3]
    print(insertion_descSort(list1))
    print(insertion_ascSort(list2))
    print(insertion_ascSort_answer(list3))
