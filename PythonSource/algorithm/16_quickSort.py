# 퀵정렬
# 정렬할 전체 원소에 대해서 정렬을 수행하지 않고, 기준값을 중심으로 왼쪽 부분 집합과 오른쪽 부분 집합으로 분할하여 정렬하는 방법
# 왼쪽부분 집합에는 기준값보다 작은 원소들을 이동시키고 오른쪽 부분 집합에는 기준값보다 큰 원소들을 이동


def quick_sort1(list):
    # 리스트 크기 구하기
    size = len(list)

    # 종료
    if size <= 1:
        return list

    # 기준(pivot) 지정
    pivot = list[-1]

    # 기준값보다 작은 요소 담기
    g1 = []
    # 기준값보다 큰 요소 담기
    g2 = []

    # 마지막 값은 기준값이기 때문에 제외
    for i in range(0, size - 1):
        if list[i] < pivot:
            g1.append(list[i])
        else:
            g2.append(list[i])

    return quick_sort1(g1) + [pivot] + quick_sort1(g2)


def quick_sort2(list, start, end):
    # 종료
    if end - start <= 0:
        return

    # 기준(pivot) 지정
    pivot = list[end]

    i = start

    # 마지막 값은 기준값이기 때문에 제외
    for j in range(start, end):
        if list[j] < pivot:
            list[i], list[j] = list[j], list[i]
            i += 1

    list[i], list[end] = list[end], list[i]

    # 재귀호출
    quick_sort2(list, start, i - 1)
    quick_sort2(list, i + 1, end)


if __name__ == "__main__":
    list1 = [6, 8, 3, 9, 10, 1, 2, 4, 7, 5]
    list2 = [6, 8, 3, 9, 10, 1, 2, 4, 7, 5]
    print(quick_sort1(list1))
    quick_sort2(list2, 0, len(list2) - 1)
    print(list2)

