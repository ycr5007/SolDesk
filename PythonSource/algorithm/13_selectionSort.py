# 선택정렬 ( 복잡도 : (n(n-1)) / 2 >> O(n2) )
# >> 정렬 알고리즘 중 가장 쉬운 방법

# 이중 for 문 사용 - 특정 위치부터 자료 값 중 최소값의 위치를 찾은 후, 정렬을 원하는 자리와 교환
def selection_ascsort(list):
    for i in range(0, len(list) - 1):
        min_idx = i
        for j in range(i + 1, len(list)):
            if list[min_idx] > list[j]:
                min_idx = j
        list[i], list[min_idx] = list[min_idx], list[i]
    return list


def selection_descsort(list):
    for i in range(0, len(list) - 1):
        max_idx = i
        for j in range(i + 1, len(list)):
            if list[max_idx] < list[j]:
                max_idx = j
        list[i], list[max_idx] = list[max_idx], list[i]
    return list


if __name__ == "__main__":
    list = [35, 9, 2, 85, 17]

    print("오름차순")
    print(selection_ascsort(list))

    print("내림차순")
    print(selection_descsort(list))
