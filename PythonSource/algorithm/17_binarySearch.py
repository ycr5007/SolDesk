# 이진탐색

# 조건 : 자료가 정렬된 상태에서만 탐색 가능


def binary_search(list, val):
    # 시작위치 지정
    start = 0
    # 종료위치 지정
    end = len(list) - 1
    # 반복문 ( 시작위치가 종료 위치보다 작거나 같을때까지 )
    while start <= end:
        # 중간위치 지정
        mid = (start + end) // 2
        # 칮고자 하는 숫자가 중간위치의 숫자보다 작으면 start = 중간위치 + 1
        if val < list[mid]:
            start = mid - 1
        # 칮고자 하는 숫자가 중간위치의 숫자보다 크면 start = 중간위치 - 1
        elif val > list[mid]:
            start = mid + 1
        # 둘 다 아닌 경우, 중간위치 반환
        else:
            return mid


# 재귀호출 방식
def reflection_binary_search(list, val, start, end):

    # 종료조건 : list 가 빈 상태라면 탐색 종료

    # 재귀
    # ① 중간위치 지정
    # ② 찾는 값과 중간위치 값이 같다면 결과값으로 중간위치 값 돌려주기
    # ③ 찾는 값이 중간위치 값보다 크다면 중간위치의 오른쪽을 대상으로 이진탐색 함수를 재귀호출
    # ③ 찾는 값이 중간위치 값보다 작다면 중간위치의 왼쪽을 대상으로 이진탐색 함수를 재귀호출

    if len(list) <= 0:
        return

    # 중간위치 지정
    mid = (start + end) // 2
    # 칮고자 하는 숫자가 중간위치의 숫자보다 작으면 start = 중간위치 + 1
    if val < list[mid]:
        return reflection_binary_search(list, val, start, mid - 1)
    # 칮고자 하는 숫자가 중간위치의 숫자보다 크면 start = 중간위치 - 1
    elif val > list[mid]:
        return reflection_binary_search(list, val, mid + 1, end)
    # 둘 다 아닌 경우, 중간위치 반환
    else:
        return mid


if __name__ == "__main__":
    list = [1, 4, 9, 16, 25, 36, 49, 64, 81]
    print("36 있는 위치 :", binary_search(list, 36))
    print("49 있는 위치 :", reflection_binary_search(list, 49, 0, len(list) - 1))
