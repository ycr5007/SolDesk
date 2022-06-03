# 병합정렬 ( 복잡도 : O(nlogn) )
"""
    최소단위까지 분해 후, 정렬 후 재병합
"""


def merge_sort1(list):
    # 리스트 크기 구하기
    size = len(list)

    # 종료조건
    if size <= 1:
        return list

    # 분해 작업
    mid = size // 2  # 중간 구하기

    g1 = merge_sort1(list[:mid])  # 재귀호출로 첫번째 그룹
    g2 = merge_sort1(list[mid:])  # 재귀호출로 두번째 그룹

    # 병합 작업
    result = []
    while g1 and g2:  # 두 그룹에 자료가 남아 있으면
        if g1[0] < g2[0]:
            result.append(g1.pop(0))
        else:
            result.append(g2.pop(0))

    # 자료 비교 후 남아있는 요소를 추가
    while g1:
        result.append(g1.pop(0))
    while g2:
        result.append(g2.pop(0))

    return result


# 하나의 리스트로 정렬 처리 ( result X )
def merge_sort2(list):
    # 리스트 크기 구하기
    size = len(list)

    # 종료조건
    if size <= 1:
        return list

    # 분해 작업
    mid = size // 2  # 중간 구하기

    g1 = list[:mid]  # 재귀호출로 첫번째 그룹
    g2 = list[mid:]  # 재귀호출로 두번째 그룹

    merge_sort2(g1)
    merge_sort2(g2)

    # 병합작업
    i1, i2, ia = 0, 0, 0

    while i1 < len(g1) and i2 < len(g2):
        if g1[i1] < g2[i2]:
            list[ia] = g1[i1]
            i1 += 1
            ia += 1
        else:
            list[ia] = g2[i2]
            i2 += 1
            ia += 1

    # 남아있는 자료 결과에 추가
    while i1 < len(g1):
        list[ia] = g1[i1]
        i1 += 1
        ia += 1

    while i2 < len(g2):
        list[ia] = g2[i2]
        i2 += 1
        ia += 1


if __name__ == "__main__":
    list1 = [6, 8, 3, 9, 10, 1, 2, 4, 7, 5]
    list2 = [6, 8, 3, 9, 10, 1, 2, 4, 7, 5]
    print(merge_sort1(list1))
    merge_sort2(list2)
    print(list2)
